package lip.com.millennialmedia.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

final class AdCache {
    private static final String CACHED_AD_FILE = "ad.dat";
    private static final String CACHE_INCOMPLETE_PREFIX = "incompleteDownload_";
    private static final String CACHE_PREFIX = "nextCachedAd_";
    private static final String CACHE_PREFIX_APID = "nextCachedAd_apids";
    private static final String LOCK_FILE = "ad.lock";
    static final int PRIORITY_FETCH = 3;
    static final int PRIORITY_PRECACHE = 1;
    static final int PRIORITY_REFRESH = 2;
    private static final String PRIVATE_CACHE_DIR = ".mmsyscache";
    private static final String TAG = "AdCache";
    private static Set<String> apidListSet;
    private static String cachedVideoList;
    private static boolean cachedVideoListLoaded;
    private static Set<String> cachedVideoSet;
    private static Map<String, String> incompleteDownloadHashMap;
    private static boolean incompleteDownloadHashMapLoaded;
    static boolean isExternalEnabled = true;
    private static Map<String, String> nextCachedAdHashMap;
    private static boolean nextCachedAdHashMapLoaded;

    interface AdCacheTaskListener {
        void downloadCompleted(CachedAd cachedAd, boolean z);

        void downloadStart(CachedAd cachedAd);
    }

    static class Iterator {
        static final int ITERATE_ID = 0;
        static final int ITERATE_INFO = 1;
        static final int ITERATE_OBJECT = 2;

        Iterator() {
        }

        boolean callback(String id) {
            return false;
        }

        boolean callback(String id, int type, Date expiration, String acid, long deferredViewStart, ObjectInputStream objectInputStream) {
            return false;
        }

        boolean callback(CachedAd ad) {
            return false;
        }

        void done() {
        }
    }

    private AdCache() {
    }

    static boolean startDownloadTask(Context context, String adName, CachedAd ad, AdCacheTaskListener listener) {
        return AdCacheThreadPool.sharedThreadPool().startDownloadTask(context, adName, ad, listener);
    }

    static synchronized void cachedVideoWasAdded(Context context, String acid) {
        synchronized (AdCache.class) {
            if (acid != null) {
                if (!cachedVideoListLoaded) {
                    getCachedVideoList(context);
                }
                if (cachedVideoSet == null) {
                    cachedVideoSet = new HashSet();
                }
                cachedVideoSet.add(acid);
                cachedVideoList = null;
            }
        }
    }

    static synchronized void cachedVideoWasRemoved(Context context, String acid) {
        synchronized (AdCache.class) {
            if (acid != null) {
                if (!cachedVideoListLoaded) {
                    getCachedVideoList(context);
                }
                if (cachedVideoSet != null) {
                    cachedVideoSet.remove(acid);
                    cachedVideoList = null;
                }
            }
        }
    }

    static synchronized String getCachedVideoList(final Context context) {
        String str;
        synchronized (AdCache.class) {
            if (cachedVideoList == null) {
                if (!cachedVideoListLoaded) {
                    final Set<String> hashSet = new HashSet();
                    iterateCachedAds(context, 2, new Iterator() {
                        boolean callback(CachedAd cachedAd) {
                            if (cachedAd.acid != null && cachedAd.getType() == 1 && cachedAd.isOnDisk(context)) {
                                hashSet.add(cachedAd.acid);
                            }
                            return true;
                        }
                    });
                    cachedVideoSet = hashSet;
                    cachedVideoListLoaded = true;
                }
                if (cachedVideoSet != null && cachedVideoSet.size() > 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String acid : cachedVideoSet) {
                        if (stringBuilder.length() > 0) {
                            stringBuilder.append("," + acid);
                        } else {
                            stringBuilder.append(acid);
                        }
                    }
                    cachedVideoList = stringBuilder.toString();
                }
            }
            str = cachedVideoList;
        }
        return str;
    }

    private static void loadNextCachedAdHashMap(Context context) {
        SharedPreferences settings = context.getSharedPreferences("MillennialMediaSettings", 0);
        nextCachedAdHashMap = new ConcurrentHashMap();
        if (apidListSet == null) {
            loadApidListSet(settings);
        }
        for (String apid : apidListSet) {
            for (String adType : MMAdImpl.getAdTypes()) {
                String result = settings.getString(CACHE_PREFIX + adType + '_' + apid, null);
                if (result != null) {
                    nextCachedAdHashMap.put(adType + '_' + apid, result);
                }
            }
        }
        nextCachedAdHashMapLoaded = true;
    }

    private static void saveNextCachedAdHashMapValue(Context context, String adName) {
        if (adName != null) {
            Editor editor = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
            saveApidListSet(editor, adName);
            editor.putString(CACHE_PREFIX + adName, (String) nextCachedAdHashMap.get(adName));
            editor.commit();
        }
    }

    static synchronized String getNextCachedAd(Context context, String adName) {
        String str;
        synchronized (AdCache.class) {
            if (!nextCachedAdHashMapLoaded) {
                loadNextCachedAdHashMap(context);
            }
            str = adName == null ? null : (String) nextCachedAdHashMap.get(adName);
        }
        return str;
    }

    static CachedAd loadNextCachedAd(Context context, String adName) {
        String nextAd = getNextCachedAd(context, adName);
        return (nextAd == null || nextAd.equals("")) ? null : load(context, nextAd);
    }

    static synchronized void setNextCachedAd(Context context, String adName, String id) {
        synchronized (AdCache.class) {
            if (!nextCachedAdHashMapLoaded) {
                loadNextCachedAdHashMap(context);
            }
            if (adName != null) {
                Map map = nextCachedAdHashMap;
                if (id == null) {
                    id = "";
                }
                map.put(adName, id);
                saveNextCachedAdHashMapValue(context, adName);
            }
        }
    }

    private static void loadIncompleteDownloadHashMap(Context context) {
        SharedPreferences settings = context.getSharedPreferences("MillennialMediaSettings", 0);
        incompleteDownloadHashMap = new ConcurrentHashMap();
        if (apidListSet == null) {
            loadApidListSet(settings);
        }
        for (String apid : apidListSet) {
            for (String adType : MMAdImpl.getAdTypes()) {
                String result = settings.getString(CACHE_INCOMPLETE_PREFIX + adType + '_' + apid, null);
                if (result != null) {
                    incompleteDownloadHashMap.put(adType + '_' + apid, result);
                }
            }
        }
        incompleteDownloadHashMapLoaded = true;
    }

    private static void saveIncompleteDownloadHashMap(Context context, String adName) {
        if (adName != null) {
            Editor editor = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
            saveApidListSet(editor, adName);
            editor.putString(CACHE_INCOMPLETE_PREFIX + adName, (String) incompleteDownloadHashMap.get(adName));
            editor.commit();
        }
    }

    static synchronized String getIncompleteDownload(Context context, String adName) {
        String str;
        synchronized (AdCache.class) {
            if (!incompleteDownloadHashMapLoaded) {
                loadIncompleteDownloadHashMap(context);
            }
            str = adName == null ? null : (String) incompleteDownloadHashMap.get(adName);
        }
        return str;
    }

    static CachedAd loadIncompleteDownload(Context context, String adName) {
        String nextIncompleteAd = getIncompleteDownload(context, adName);
        return nextIncompleteAd == null ? null : load(context, nextIncompleteAd);
    }

    static synchronized void setIncompleteDownload(Context context, String adName, String id) {
        synchronized (AdCache.class) {
            if (!incompleteDownloadHashMapLoaded) {
                loadIncompleteDownloadHashMap(context);
            }
            if (adName != null) {
                Map map = incompleteDownloadHashMap;
                if (id == null) {
                    id = "";
                }
                map.put(adName, id);
                saveIncompleteDownloadHashMap(context, adName);
            }
        }
    }

    private static void loadApidListSet(SharedPreferences settings) {
        apidListSet = new HashSet();
        String apids = settings.getString(CACHE_PREFIX_APID, null);
        if (apids != null) {
            String[] apidArray = apids.split(MMSDK.COMMA);
            if (apidArray != null && apidArray.length > 0) {
                for (String apid : apidArray) {
                    apidListSet.add(apid);
                }
            }
        }
    }

    private static void saveApidListSet(Editor editor, String adName) {
        int start = adName.indexOf(95);
        if (start >= 0 && start < adName.length()) {
            String apid = adName.substring(start + 1);
            if (apid != null && !apidListSet.contains(apid)) {
                StringBuilder builder = null;
                if (!apidListSet.isEmpty()) {
                    builder = new StringBuilder();
                    for (String str : apidListSet) {
                        builder.append(str + MMSDK.COMMA);
                    }
                }
                editor.putString(CACHE_PREFIX_APID, (builder == null ? "" : builder.toString()) + apid);
                apidListSet.add(apid);
            }
        }
    }

    static void iterateCachedAds(Context context, int mode, Iterator iterator) {
        Exception e;
        Throwable th;
        File cachedDir = getInternalCacheDirectory(context);
        ObjectInputStream objectInputStream = null;
        if (cachedDir != null) {
            File[] adFiles = cachedDir.listFiles(new FileFilter() {
                public boolean accept(File file) {
                    return !file.isDirectory() && file.getName().endsWith(AdCache.CACHED_AD_FILE);
                }
            });
            if (adFiles != null) {
                File[] arr$ = adFiles;
                int len$ = arr$.length;
                int i$ = 0;
                while (true) {
                    ObjectInputStream objectInputStream2 = objectInputStream;
                    if (i$ >= len$) {
                        break;
                    }
                    File adFile = arr$[i$];
                    if (adFile != null) {
                        try {
                            if (adFile.exists()) {
                                if (mode == 0) {
                                    if (iterator.callback(adFile.getName())) {
                                        if (objectInputStream2 != null) {
                                            try {
                                                objectInputStream2.close();
                                                objectInputStream = null;
                                            } catch (IOException e2) {
                                                MMLog.e(TAG, "Failed to close", e2);
                                                objectInputStream = objectInputStream2;
                                            }
                                            i$++;
                                        }
                                        objectInputStream = objectInputStream2;
                                        i$++;
                                    } else if (objectInputStream2 != null) {
                                        try {
                                            objectInputStream2.close();
                                        } catch (IOException e22) {
                                            MMLog.e(TAG, "Failed to close", e22);
                                            objectInputStream = objectInputStream2;
                                        }
                                    }
                                } else {
                                    objectInputStream = new ObjectInputStream(new FileInputStream(adFile));
                                    try {
                                        int type = objectInputStream.readInt();
                                        Date expiration = (Date) objectInputStream.readObject();
                                        String acid = (String) objectInputStream.readObject();
                                        long deferredViewStart = objectInputStream.readLong();
                                        if (mode == 1) {
                                            if (!iterator.callback(adFile.getName(), type, expiration, acid, deferredViewStart, objectInputStream)) {
                                                objectInputStream.close();
                                                objectInputStream = null;
                                                if (objectInputStream != null) {
                                                    try {
                                                        objectInputStream.close();
                                                    } catch (IOException e222) {
                                                        MMLog.e(TAG, "Failed to close", e222);
                                                    }
                                                }
                                            }
                                        } else {
                                            if (!iterator.callback((CachedAd) objectInputStream.readObject())) {
                                                objectInputStream.close();
                                                objectInputStream = null;
                                                if (objectInputStream != null) {
                                                    try {
                                                        objectInputStream.close();
                                                    } catch (IOException e2222) {
                                                        MMLog.e(TAG, "Failed to close", e2222);
                                                    }
                                                }
                                            }
                                        }
                                        if (objectInputStream != null) {
                                            try {
                                                objectInputStream.close();
                                                objectInputStream = null;
                                            } catch (IOException e22222) {
                                                MMLog.e(TAG, "Failed to close", e22222);
                                            }
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        try {
                                            MMLog.e(TAG, String.format("There was a problem reading the cached ad %s.", new Object[]{adFile.getName()}), e);
                                            if (objectInputStream != null) {
                                                try {
                                                    objectInputStream.close();
                                                    objectInputStream = null;
                                                } catch (IOException e222222) {
                                                    MMLog.e(TAG, "Failed to close", e222222);
                                                }
                                            }
                                            i$++;
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    }
                                    i$++;
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            objectInputStream = objectInputStream2;
                        } catch (Throwable th3) {
                            th = th3;
                            objectInputStream = objectInputStream2;
                        }
                    }
                    if (objectInputStream2 != null) {
                        try {
                            objectInputStream2.close();
                            objectInputStream = null;
                        } catch (IOException e2222222) {
                            MMLog.e(TAG, "Failed to close", e2222222);
                            objectInputStream = objectInputStream2;
                        }
                        i$++;
                    }
                    objectInputStream = objectInputStream2;
                    i$++;
                }
            }
        }
        iterator.done();
        return;
        if (objectInputStream != null) {
            try {
                objectInputStream.close();
            } catch (IOException e22222222) {
                MMLog.e(TAG, "Failed to close", e22222222);
            }
        }
        throw th;
        throw th;
    }

    static void cleanCache(final Context context) {
        ThreadUtils.execute(new Runnable() {
            public void run() {
                MMLog.d(AdCache.TAG, AdCache.TAG);
                AdCache.cleanUpExpiredAds(context);
                AdCache.cleanupCache(context);
            }
        });
    }

    static void cleanUpExpiredAds(Context context) {
        iterateCachedAds(context, 1, new Iterator() {
            boolean callback(String id, int type, Date expiration, String acid, long deferredViewStart, ObjectInputStream objectInputStream) {
                if (expiration != null && expiration.getTime() <= System.currentTimeMillis()) {
                    try {
                        CachedAd ad = (CachedAd) objectInputStream.readObject();
                        MMLog.e(AdCache.TAG, String.format("Deleting expired ad %s.", new Object[]{ad.getId()}));
                    } catch (Exception e) {
                        MMLog.e(AdCache.TAG, String.format("There was a problem reading the cached ad %s.", new Object[]{id}), e);
                    }
                }
                return true;
            }
        });
    }

    static void cleanupCache(Context context) {
        cleanupInternalCache(context);
        if (isExternalStorageAvailable(context)) {
            cleanupExternalCache(context);
        }
    }

    private static void cleanupInternalCache(Context context) {
        File internalCacheDir = getInternalCacheDirectory(context);
        if (internalCacheDir != null && internalCacheDir.exists() && internalCacheDir.isDirectory()) {
            cleanupDirectory(internalCacheDir, HandShake.sharedHandShake(context).creativeCacheTimeout);
        }
    }

    private static void cleanupExternalCache(Context context) {
        File externalCacheDir = getExternalCacheDirectory(context);
        if (externalCacheDir != null && externalCacheDir.exists() && externalCacheDir.isDirectory()) {
            cleanupDirectory(externalCacheDir, HandShake.sharedHandShake(context).creativeCacheTimeout);
        }
    }

    static void cleanupDirectory(File file, long timeout) {
        for (File entry : file.listFiles()) {
            if (entry.isFile()) {
                if (System.currentTimeMillis() - entry.lastModified() > timeout) {
                    entry.delete();
                }
            } else if (entry.isDirectory()) {
                try {
                    cleanupDirectory(entry, timeout);
                    if (entry.list() != null && entry.list().length == 0) {
                        entry.delete();
                    }
                } catch (SecurityException e) {
                    MMLog.e(TAG, "Security Exception cleaning up directory", e);
                }
            }
        }
    }

    static void resetCache(final Context context) {
        iterateCachedAds(context, 2, new Iterator() {
            boolean callback(CachedAd ad) {
                MMLog.d(AdCache.TAG, String.format("Deleting ad %s.", new Object[]{ad.getId()}));
                ad.delete(context);
                return true;
            }
        });
        cachedVideoSet = null;
        cachedVideoList = null;
        cachedVideoListLoaded = false;
        if (nextCachedAdHashMap != null) {
            for (String key : nextCachedAdHashMap.keySet()) {
                setNextCachedAd(context, key, null);
            }
        }
        if (incompleteDownloadHashMap != null) {
            for (String key2 : incompleteDownloadHashMap.keySet()) {
                setIncompleteDownload(context, key2, null);
            }
        }
    }

    static File getDownloadFile(Context context, String name) {
        File dir = getExternalCacheDirectory(context);
        if (dir != null) {
            return new File(dir, name);
        }
        return null;
    }

    static File getDownloadFile(Context context, String subDirectory, String name) {
        File dir = getExternalCacheDirectory(context);
        if (dir != null) {
            return new File(dir, subDirectory + File.separator + name);
        }
        return null;
    }

    static boolean hasDownloadFile(Context context, String name) {
        File file = getDownloadFile(context, name);
        return file != null && file.exists();
    }

    static File getCacheDirectory(Context context) {
        if (isExternalStorageAvailable(context)) {
            return getExternalCacheDirectory(context);
        }
        return getInternalCacheDirectory(context);
    }

    static File getExternalCacheDirectory(Context context) {
        File externalStorageDir = Environment.getExternalStorageDirectory();
        if (externalStorageDir == null) {
            return null;
        }
        File extCacheDir = new File(externalStorageDir, PRIVATE_CACHE_DIR);
        if (extCacheDir.exists() || extCacheDir.mkdirs()) {
            return extCacheDir;
        }
        return null;
    }

    static File getInternalCacheDirectory(Context context) {
        if (context == null) {
            return null;
        }
        File cacheDir = new File(context.getFilesDir(), PRIVATE_CACHE_DIR);
        if (cacheDir == null || cacheDir.exists() || cacheDir.mkdirs()) {
            return cacheDir;
        }
        return null;
    }

    private static File getCachedAdFile(Context context, String id) {
        String fileName = id + CACHED_AD_FILE;
        boolean isExternalStateMounted = isExternalStorageAvailable(context);
        File cacheDir = getInternalCacheDirectory(context);
        File adFile = null;
        if (cacheDir != null) {
            try {
                if (cacheDir.isDirectory()) {
                    adFile = new File(cacheDir, fileName);
                }
            } catch (Exception e) {
                MMLog.e(TAG, "getCachedAdFile: ", e);
                return null;
            }
        }
        if ((adFile == null || !adFile.exists()) && !isExternalStateMounted) {
            File internalCacheDir = context.getFilesDir();
            if (internalCacheDir != null) {
                File internalFile = new File(internalCacheDir, PRIVATE_CACHE_DIR + File.separator + fileName);
                if (internalFile.exists() && internalFile.isFile()) {
                    return internalFile;
                }
            }
        }
        return adFile;
    }

    static boolean downloadComponentInternalCache(String urlString, String name, Context context) {
        File internalDir = getInternalCacheDirectory(context);
        if (internalDir == null || !internalDir.isDirectory()) {
            return false;
        }
        return downloadComponent(urlString, name, internalDir, context);
    }

    static boolean downloadComponentExternalStorage(String urlString, String name, Context context) {
        File externalDir = getExternalCacheDirectory(context);
        if (externalDir == null || !externalDir.isDirectory()) {
            return false;
        }
        return downloadComponent(urlString, name, externalDir, context);
    }

    static boolean downloadComponentExternalStorage(String urlString, String subDirectory, String name, Context context) {
        File externalDir = getExternalCacheDirectory(context);
        if (externalDir == null || !externalDir.isDirectory()) {
            return false;
        }
        return downloadComponent(urlString, name, new File(externalDir, subDirectory), context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01b5 A:{SYNTHETIC, Splitter: B:84:0x01b5} */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01ba A:{Catch:{ IOException -> 0x01e8 }} */
    private static boolean downloadComponent(String r20, String r21, File r22, Context r23) {
        /*
        r16 = android.text.TextUtils.isEmpty(r20);
        if (r16 == 0) goto L_0x0010;
    L_0x0006:
        r16 = "AdCache";
        r17 = "No Url ...";
        com.millennialmedia.android.MMLog.d(r16, r17);
        r16 = 0;
    L_0x000f:
        return r16;
    L_0x0010:
        r9 = new java.io.File;
        r0 = r22;
        r1 = r21;
        r9.<init>(r0, r1);
        r16 = "AdCache";
        r17 = "Downloading Component: %s from %s";
        r18 = 2;
        r0 = r18;
        r0 = new java.lang.Object[r0];
        r18 = r0;
        r19 = 0;
        r18[r19] = r21;
        r19 = 1;
        r18[r19] = r20;
        r17 = java.lang.String.format(r17, r18);
        com.millennialmedia.android.MMLog.v(r16, r17);
        r14 = r9.getParentFile();
        r16 = r14.exists();
        if (r16 != 0) goto L_0x0061;
    L_0x003e:
        r16 = r14.mkdirs();
        if (r16 != 0) goto L_0x0061;
    L_0x0044:
        r16 = "AdCache";
        r17 = new java.lang.StringBuilder;
        r17.<init>();
        r0 = r17;
        r17 = r0.append(r14);
        r18 = " does not exist and cannot create directory.";
        r17 = r17.append(r18);
        r17 = r17.toString();
        com.millennialmedia.android.MMLog.v(r16, r17);
        r16 = 0;
        goto L_0x000f;
    L_0x0061:
        r16 = r9.exists();
        if (r16 == 0) goto L_0x0090;
    L_0x0067:
        r16 = r9.length();
        r18 = 0;
        r16 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1));
        if (r16 <= 0) goto L_0x0090;
    L_0x0071:
        r16 = "AdCache";
        r17 = new java.lang.StringBuilder;
        r17.<init>();
        r0 = r17;
        r1 = r21;
        r17 = r0.append(r1);
        r18 = " already exists, skipping...";
        r17 = r17.append(r18);
        r17 = r17.toString();
        com.millennialmedia.android.MMLog.v(r16, r17);
        r16 = 1;
        goto L_0x000f;
    L_0x0090:
        r10 = 0;
        r12 = 0;
        r5 = -1;
        r4 = new java.net.URL;	 Catch:{ Exception -> 0x01ff }
        r0 = r20;
        r4.<init>(r0);	 Catch:{ Exception -> 0x01ff }
        r16 = 1;
        java.net.HttpURLConnection.setFollowRedirects(r16);	 Catch:{ Exception -> 0x01ff }
        r3 = r4.openConnection();	 Catch:{ Exception -> 0x01ff }
        r3 = (java.net.HttpURLConnection) r3;	 Catch:{ Exception -> 0x01ff }
        r16 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r0 = r16;
        r3.setConnectTimeout(r0);	 Catch:{ Exception -> 0x01ff }
        r16 = "GET";
        r0 = r16;
        r3.setRequestMethod(r0);	 Catch:{ Exception -> 0x01ff }
        r3.connect();	 Catch:{ Exception -> 0x01ff }
        r10 = r3.getInputStream();	 Catch:{ Exception -> 0x01ff }
        r16 = "Content-Length";
        r0 = r16;
        r15 = r3.getHeaderField(r0);	 Catch:{ Exception -> 0x01ff }
        if (r15 == 0) goto L_0x00c9;
    L_0x00c5:
        r5 = java.lang.Long.parseLong(r15);	 Catch:{ Exception -> 0x01ff }
    L_0x00c9:
        if (r10 != 0) goto L_0x0105;
    L_0x00cb:
        r16 = "AdCache";
        r17 = "Connection stream is null downloading %s.";
        r18 = 1;
        r0 = r18;
        r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x01ff }
        r18 = r0;
        r19 = 0;
        r18[r19] = r21;	 Catch:{ Exception -> 0x01ff }
        r17 = java.lang.String.format(r17, r18);	 Catch:{ Exception -> 0x01ff }
        com.millennialmedia.android.MMLog.e(r16, r17);	 Catch:{ Exception -> 0x01ff }
        r16 = 0;
        if (r10 == 0) goto L_0x00e9;
    L_0x00e6:
        r10.close();	 Catch:{ IOException -> 0x00f0 }
    L_0x00e9:
        if (r12 == 0) goto L_0x000f;
    L_0x00eb:
        r12.close();	 Catch:{ IOException -> 0x00f0 }
        goto L_0x000f;
    L_0x00f0:
        r8 = move-exception;
        r16 = "AdCache";
        r17 = "Content caching error downloading component: ";
        r0 = r16;
        r1 = r17;
        com.millennialmedia.android.MMLog.e(r0, r1, r8);
        if (r9 == 0) goto L_0x0101;
    L_0x00fe:
        r9.delete();
    L_0x0101:
        r16 = 0;
        goto L_0x000f;
    L_0x0105:
        r13 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x01ff }
        r13.<init>(r9);	 Catch:{ Exception -> 0x01ff }
        r16 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r0 = r16;
        r2 = new byte[r0];	 Catch:{ Exception -> 0x011e, all -> 0x01b1 }
    L_0x0110:
        r11 = r10.read(r2);	 Catch:{ Exception -> 0x011e, all -> 0x01b1 }
        if (r11 <= 0) goto L_0x014e;
    L_0x0116:
        r16 = 0;
        r0 = r16;
        r13.write(r2, r0, r11);	 Catch:{ Exception -> 0x011e, all -> 0x01b1 }
        goto L_0x0110;
    L_0x011e:
        r7 = move-exception;
        r12 = r13;
    L_0x0120:
        r16 = "AdCache";
        r17 = "Exception downloading component %s: %s";
        r18 = 2;
        r0 = r18;
        r0 = new java.lang.Object[r0];	 Catch:{ all -> 0x01fd }
        r18 = r0;
        r19 = 0;
        r18[r19] = r21;	 Catch:{ all -> 0x01fd }
        r19 = 1;
        r18[r19] = r7;	 Catch:{ all -> 0x01fd }
        r17 = java.lang.String.format(r17, r18);	 Catch:{ all -> 0x01fd }
        com.millennialmedia.android.MMLog.e(r16, r17);	 Catch:{ all -> 0x01fd }
        if (r10 == 0) goto L_0x0140;
    L_0x013d:
        r10.close();	 Catch:{ IOException -> 0x01d3 }
    L_0x0140:
        if (r12 == 0) goto L_0x0145;
    L_0x0142:
        r12.close();	 Catch:{ IOException -> 0x01d3 }
    L_0x0145:
        if (r9 == 0) goto L_0x014a;
    L_0x0147:
        r9.delete();
    L_0x014a:
        r16 = 0;
        goto L_0x000f;
    L_0x014e:
        if (r9 == 0) goto L_0x0188;
    L_0x0150:
        r16 = r9.length();	 Catch:{ SecurityException -> 0x0194 }
        r16 = (r16 > r5 ? 1 : (r16 == r5 ? 0 : -1));
        if (r16 == 0) goto L_0x015e;
    L_0x0158:
        r16 = -1;
        r16 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1));
        if (r16 != 0) goto L_0x0181;
    L_0x015e:
        r16 = 1;
        if (r10 == 0) goto L_0x0165;
    L_0x0162:
        r10.close();	 Catch:{ IOException -> 0x016c }
    L_0x0165:
        if (r13 == 0) goto L_0x000f;
    L_0x0167:
        r13.close();	 Catch:{ IOException -> 0x016c }
        goto L_0x000f;
    L_0x016c:
        r8 = move-exception;
        r16 = "AdCache";
        r17 = "Content caching error downloading component: ";
        r0 = r16;
        r1 = r17;
        com.millennialmedia.android.MMLog.e(r0, r1, r8);
        if (r9 == 0) goto L_0x017d;
    L_0x017a:
        r9.delete();
    L_0x017d:
        r16 = 0;
        goto L_0x000f;
    L_0x0181:
        r16 = "AdCache";
        r17 = "Content-Length does not match actual length.";
        com.millennialmedia.android.MMLog.e(r16, r17);	 Catch:{ SecurityException -> 0x0194 }
    L_0x0188:
        if (r10 == 0) goto L_0x018d;
    L_0x018a:
        r10.close();	 Catch:{ IOException -> 0x01be }
    L_0x018d:
        if (r13 == 0) goto L_0x0192;
    L_0x018f:
        r13.close();	 Catch:{ IOException -> 0x01be }
    L_0x0192:
        r12 = r13;
        goto L_0x0145;
    L_0x0194:
        r7 = move-exception;
        r16 = "AdCache";
        r17 = "Exception downloading component %s: ";
        r18 = 1;
        r0 = r18;
        r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x011e, all -> 0x01b1 }
        r18 = r0;
        r19 = 0;
        r18[r19] = r21;	 Catch:{ Exception -> 0x011e, all -> 0x01b1 }
        r17 = java.lang.String.format(r17, r18);	 Catch:{ Exception -> 0x011e, all -> 0x01b1 }
        r0 = r16;
        r1 = r17;
        com.millennialmedia.android.MMLog.e(r0, r1, r7);	 Catch:{ Exception -> 0x011e, all -> 0x01b1 }
        goto L_0x0188;
    L_0x01b1:
        r16 = move-exception;
        r12 = r13;
    L_0x01b3:
        if (r10 == 0) goto L_0x01b8;
    L_0x01b5:
        r10.close();	 Catch:{ IOException -> 0x01e8 }
    L_0x01b8:
        if (r12 == 0) goto L_0x01bd;
    L_0x01ba:
        r12.close();	 Catch:{ IOException -> 0x01e8 }
    L_0x01bd:
        throw r16;
    L_0x01be:
        r8 = move-exception;
        r16 = "AdCache";
        r17 = "Content caching error downloading component: ";
        r0 = r16;
        r1 = r17;
        com.millennialmedia.android.MMLog.e(r0, r1, r8);
        if (r9 == 0) goto L_0x01cf;
    L_0x01cc:
        r9.delete();
    L_0x01cf:
        r16 = 0;
        goto L_0x000f;
    L_0x01d3:
        r8 = move-exception;
        r16 = "AdCache";
        r17 = "Content caching error downloading component: ";
        r0 = r16;
        r1 = r17;
        com.millennialmedia.android.MMLog.e(r0, r1, r8);
        if (r9 == 0) goto L_0x01e4;
    L_0x01e1:
        r9.delete();
    L_0x01e4:
        r16 = 0;
        goto L_0x000f;
    L_0x01e8:
        r8 = move-exception;
        r16 = "AdCache";
        r17 = "Content caching error downloading component: ";
        r0 = r16;
        r1 = r17;
        com.millennialmedia.android.MMLog.e(r0, r1, r8);
        if (r9 == 0) goto L_0x01f9;
    L_0x01f6:
        r9.delete();
    L_0x01f9:
        r16 = 0;
        goto L_0x000f;
    L_0x01fd:
        r16 = move-exception;
        goto L_0x01b3;
    L_0x01ff:
        r7 = move-exception;
        goto L_0x0120;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.millennialmedia.android.AdCache.downloadComponent(java.lang.String, java.lang.String, java.io.File, android.content.Context):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006c A:{SYNTHETIC, Splitter: B:22:0x006c} */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008d A:{SYNTHETIC, Splitter: B:30:0x008d} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009f A:{SYNTHETIC, Splitter: B:36:0x009f} */
    static com.millennialmedia.android.CachedAd load(Context r14, String r15) {
        /*
        r10 = 0;
        if (r15 == 0) goto L_0x000b;
    L_0x0003:
        r11 = "";
        r11 = r15.equals(r11);
        if (r11 == 0) goto L_0x000d;
    L_0x000b:
        r1 = r10;
    L_0x000c:
        return r1;
    L_0x000d:
        r2 = 0;
        r8 = 0;
        r1 = 0;
        r2 = getCachedAdFile(r14, r15);
        if (r2 != 0) goto L_0x0018;
    L_0x0016:
        r1 = r10;
        goto L_0x000c;
    L_0x0018:
        r9 = new java.io.ObjectInputStream;	 Catch:{ FileNotFoundException -> 0x004b, Exception -> 0x0079 }
        r10 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x004b, Exception -> 0x0079 }
        r10.<init>(r2);	 Catch:{ FileNotFoundException -> 0x004b, Exception -> 0x0079 }
        r9.<init>(r10);	 Catch:{ FileNotFoundException -> 0x004b, Exception -> 0x0079 }
        r9.readInt();	 Catch:{ FileNotFoundException -> 0x00b2, Exception -> 0x00af, all -> 0x00ac }
        r6 = r9.readObject();	 Catch:{ FileNotFoundException -> 0x00b2, Exception -> 0x00af, all -> 0x00ac }
        r6 = (java.util.Date) r6;	 Catch:{ FileNotFoundException -> 0x00b2, Exception -> 0x00af, all -> 0x00ac }
        r9.readObject();	 Catch:{ FileNotFoundException -> 0x00b2, Exception -> 0x00af, all -> 0x00ac }
        r3 = r9.readLong();	 Catch:{ FileNotFoundException -> 0x00b2, Exception -> 0x00af, all -> 0x00ac }
        r10 = r9.readObject();	 Catch:{ FileNotFoundException -> 0x00b2, Exception -> 0x00af, all -> 0x00ac }
        r0 = r10;
        r0 = (com.millennialmedia.android.CachedAd) r0;	 Catch:{ FileNotFoundException -> 0x00b2, Exception -> 0x00af, all -> 0x00ac }
        r1 = r0;
        if (r9 == 0) goto L_0x003f;
    L_0x003c:
        r9.close();	 Catch:{ IOException -> 0x0041 }
    L_0x003f:
        r8 = r9;
        goto L_0x000c;
    L_0x0041:
        r5 = move-exception;
        r10 = "AdCache";
        r11 = "Failed to close";
        com.millennialmedia.android.MMLog.e(r10, r11, r5);
        r8 = r9;
        goto L_0x000c;
    L_0x004b:
        r7 = move-exception;
    L_0x004c:
        r10 = "AdCache";
        r11 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009c }
        r11.<init>();	 Catch:{ all -> 0x009c }
        r12 = "There was a problem loading up the cached ad ";
        r11 = r11.append(r12);	 Catch:{ all -> 0x009c }
        r11 = r11.append(r15);	 Catch:{ all -> 0x009c }
        r12 = ". Ad is not on disk.";
        r11 = r11.append(r12);	 Catch:{ all -> 0x009c }
        r11 = r11.toString();	 Catch:{ all -> 0x009c }
        com.millennialmedia.android.MMLog.e(r10, r11, r7);	 Catch:{ all -> 0x009c }
        if (r8 == 0) goto L_0x000c;
    L_0x006c:
        r8.close();	 Catch:{ IOException -> 0x0070 }
        goto L_0x000c;
    L_0x0070:
        r5 = move-exception;
        r10 = "AdCache";
        r11 = "Failed to close";
        com.millennialmedia.android.MMLog.e(r10, r11, r5);
        goto L_0x000c;
    L_0x0079:
        r5 = move-exception;
    L_0x007a:
        r10 = "AdCache";
        r11 = "There was a problem loading up the cached ad %s.";
        r12 = 1;
        r12 = new java.lang.Object[r12];	 Catch:{ all -> 0x009c }
        r13 = 0;
        r12[r13] = r15;	 Catch:{ all -> 0x009c }
        r11 = java.lang.String.format(r11, r12);	 Catch:{ all -> 0x009c }
        com.millennialmedia.android.MMLog.e(r10, r11, r5);	 Catch:{ all -> 0x009c }
        if (r8 == 0) goto L_0x000c;
    L_0x008d:
        r8.close();	 Catch:{ IOException -> 0x0092 }
        goto L_0x000c;
    L_0x0092:
        r5 = move-exception;
        r10 = "AdCache";
        r11 = "Failed to close";
        com.millennialmedia.android.MMLog.e(r10, r11, r5);
        goto L_0x000c;
    L_0x009c:
        r10 = move-exception;
    L_0x009d:
        if (r8 == 0) goto L_0x00a2;
    L_0x009f:
        r8.close();	 Catch:{ IOException -> 0x00a3 }
    L_0x00a2:
        throw r10;
    L_0x00a3:
        r5 = move-exception;
        r11 = "AdCache";
        r12 = "Failed to close";
        com.millennialmedia.android.MMLog.e(r11, r12, r5);
        goto L_0x00a2;
    L_0x00ac:
        r10 = move-exception;
        r8 = r9;
        goto L_0x009d;
    L_0x00af:
        r5 = move-exception;
        r8 = r9;
        goto L_0x007a;
    L_0x00b2:
        r7 = move-exception;
        r8 = r9;
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.millennialmedia.android.AdCache.load(android.content.Context, java.lang.String):com.millennialmedia.android.CachedAd");
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e7 A:{Catch:{ IOException -> 0x00eb }} */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d2 A:{Catch:{ IOException -> 0x00d7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e7 A:{Catch:{ IOException -> 0x00eb }} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d2 A:{Catch:{ IOException -> 0x00d7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A:{SYNTHETIC, RETURN} */
    static boolean save(Context r12, com.millennialmedia.android.CachedAd r13) {
        /*
        r7 = 1;
        r6 = 0;
        r0 = 0;
        r2 = 0;
        r4 = 0;
        if (r13 != 0) goto L_0x0008;
    L_0x0007:
        return r6;
    L_0x0008:
        r8 = r13.getId();
        r0 = getCachedAdFile(r12, r8);
        if (r0 == 0) goto L_0x0007;
    L_0x0012:
        r8 = "AdCache";
        r9 = "Saving CachedAd %s to %s";
        r10 = 2;
        r10 = new java.lang.Object[r10];
        r11 = r13.getId();
        r10[r6] = r11;
        r10[r7] = r0;
        r9 = java.lang.String.format(r9, r10);
        com.millennialmedia.android.MMLog.v(r8, r9);
        r3 = new java.io.File;	 Catch:{ Exception -> 0x00b7 }
        r8 = r0.getParent();	 Catch:{ Exception -> 0x00b7 }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b7 }
        r9.<init>();	 Catch:{ Exception -> 0x00b7 }
        r10 = r13.getId();	 Catch:{ Exception -> 0x00b7 }
        r9 = r9.append(r10);	 Catch:{ Exception -> 0x00b7 }
        r10 = "ad.lock";
        r9 = r9.append(r10);	 Catch:{ Exception -> 0x00b7 }
        r9 = r9.toString();	 Catch:{ Exception -> 0x00b7 }
        r3.<init>(r8, r9);	 Catch:{ Exception -> 0x00b7 }
        r8 = r3.createNewFile();	 Catch:{ Exception -> 0x0100, all -> 0x00f9 }
        if (r8 != 0) goto L_0x0076;
    L_0x004e:
        r7 = "AdCache";
        r8 = "Could not save the cached ad %s. Ad was locked.";
        r9 = 1;
        r9 = new java.lang.Object[r9];	 Catch:{ Exception -> 0x0100, all -> 0x00f9 }
        r10 = 0;
        r11 = r13.getId();	 Catch:{ Exception -> 0x0100, all -> 0x00f9 }
        r9[r10] = r11;	 Catch:{ Exception -> 0x0100, all -> 0x00f9 }
        r8 = java.lang.String.format(r8, r9);	 Catch:{ Exception -> 0x0100, all -> 0x00f9 }
        com.millennialmedia.android.MMLog.v(r7, r8);	 Catch:{ Exception -> 0x0100, all -> 0x00f9 }
        r3.delete();	 Catch:{ IOException -> 0x006d }
        if (r4 == 0) goto L_0x006b;
    L_0x0068:
        r4.close();	 Catch:{ IOException -> 0x006d }
    L_0x006b:
        r2 = r3;
        goto L_0x0007;
    L_0x006d:
        r1 = move-exception;
        r7 = "AdCache";
        r8 = "Failed to close";
        com.millennialmedia.android.MMLog.e(r7, r8, r1);
        goto L_0x006b;
    L_0x0076:
        r5 = new java.io.ObjectOutputStream;	 Catch:{ Exception -> 0x0100, all -> 0x00f9 }
        r8 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0100, all -> 0x00f9 }
        r8.<init>(r0);	 Catch:{ Exception -> 0x0100, all -> 0x00f9 }
        r5.<init>(r8);	 Catch:{ Exception -> 0x0100, all -> 0x00f9 }
        r8 = r13.getType();	 Catch:{ Exception -> 0x0103, all -> 0x00fc }
        r5.writeInt(r8);	 Catch:{ Exception -> 0x0103, all -> 0x00fc }
        r8 = r13.expiration;	 Catch:{ Exception -> 0x0103, all -> 0x00fc }
        r5.writeObject(r8);	 Catch:{ Exception -> 0x0103, all -> 0x00fc }
        r8 = r13.acid;	 Catch:{ Exception -> 0x0103, all -> 0x00fc }
        r5.writeObject(r8);	 Catch:{ Exception -> 0x0103, all -> 0x00fc }
        r8 = r13.deferredViewStart;	 Catch:{ Exception -> 0x0103, all -> 0x00fc }
        r5.writeLong(r8);	 Catch:{ Exception -> 0x0103, all -> 0x00fc }
        r5.writeObject(r13);	 Catch:{ Exception -> 0x0103, all -> 0x00fc }
        r3.delete();	 Catch:{ IOException -> 0x00ae }
        if (r5 == 0) goto L_0x00a1;
    L_0x009e:
        r5.close();	 Catch:{ IOException -> 0x00ae }
    L_0x00a1:
        r8 = r13.saveAssets(r12);
        if (r8 != 0) goto L_0x00f4;
    L_0x00a7:
        r13.delete(r12);
        r4 = r5;
        r2 = r3;
        goto L_0x0007;
    L_0x00ae:
        r1 = move-exception;
        r8 = "AdCache";
        r9 = "Failed to close";
        com.millennialmedia.android.MMLog.e(r8, r9, r1);
        goto L_0x00a1;
    L_0x00b7:
        r1 = move-exception;
    L_0x00b8:
        r7 = "AdCache";
        r8 = "There was a problem saving the cached ad %s.";
        r9 = 1;
        r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x00e1 }
        r10 = 0;
        r11 = r13.getId();	 Catch:{ all -> 0x00e1 }
        r9[r10] = r11;	 Catch:{ all -> 0x00e1 }
        r8 = java.lang.String.format(r8, r9);	 Catch:{ all -> 0x00e1 }
        com.millennialmedia.android.MMLog.e(r7, r8, r1);	 Catch:{ all -> 0x00e1 }
        r2.delete();	 Catch:{ IOException -> 0x00d7 }
        if (r4 == 0) goto L_0x0007;
    L_0x00d2:
        r4.close();	 Catch:{ IOException -> 0x00d7 }
        goto L_0x0007;
    L_0x00d7:
        r1 = move-exception;
        r7 = "AdCache";
        r8 = "Failed to close";
        com.millennialmedia.android.MMLog.e(r7, r8, r1);
        goto L_0x0007;
    L_0x00e1:
        r6 = move-exception;
    L_0x00e2:
        r2.delete();	 Catch:{ IOException -> 0x00eb }
        if (r4 == 0) goto L_0x00ea;
    L_0x00e7:
        r4.close();	 Catch:{ IOException -> 0x00eb }
    L_0x00ea:
        throw r6;
    L_0x00eb:
        r1 = move-exception;
        r7 = "AdCache";
        r8 = "Failed to close";
        com.millennialmedia.android.MMLog.e(r7, r8, r1);
        goto L_0x00ea;
    L_0x00f4:
        r4 = r5;
        r2 = r3;
        r6 = r7;
        goto L_0x0007;
    L_0x00f9:
        r6 = move-exception;
        r2 = r3;
        goto L_0x00e2;
    L_0x00fc:
        r6 = move-exception;
        r4 = r5;
        r2 = r3;
        goto L_0x00e2;
    L_0x0100:
        r1 = move-exception;
        r2 = r3;
        goto L_0x00b8;
    L_0x0103:
        r1 = move-exception;
        r4 = r5;
        r2 = r3;
        goto L_0x00b8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.millennialmedia.android.AdCache.save(android.content.Context, com.millennialmedia.android.CachedAd):boolean");
    }

    static boolean deleteFile(Context context, String fileName) {
        File deleteFile = getCachedAdFile(context, fileName);
        if (deleteFile != null) {
            return deleteFile.delete();
        }
        return false;
    }

    static boolean isExternalStorageAvailable(Context context) {
        if (context == null) {
            return false;
        }
        String storageState = Environment.getExternalStorageState();
        if (context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 && !TextUtils.isEmpty(storageState) && storageState.equals("mounted") && isExternalEnabled) {
            return true;
        }
        return false;
    }

    static boolean isExternalMounted() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    static void setEnableExternalStorage(boolean on) {
        isExternalEnabled = on;
    }
}
