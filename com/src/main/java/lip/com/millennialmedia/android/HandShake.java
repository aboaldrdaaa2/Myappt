package lip.com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.WindowManager.BadTokenException;
import android.webkit.URLUtil;
import android.widget.Toast;
import com.millennialmedia.google.gson.Gson;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class HandShake {
    static final String BASE_URL = "http://androidsdk.ads.mp.mydas.mobi/";
    static final String BASE_URL_PATH = "getAd.php5?";
    private static final String HANDSHAKE_FALLBACK_URL = "http://ads.mp.mydas.mobi/appConfigServlet?apid=";
    private static final String HANDSHAKE_HTTPS_SCHEME = "https://";
    private static final String HANDSHAKE_HTTP_SCHEME = "http://";
    private static final String HANDSHAKE_URL_HOST = "ads.mp.mydas.mobi/";
    private static final String HANDSHAKE_URL_OVERRIDE_PARMS = "?apid=";
    private static final String HANDSHAKE_URL_PARMS = "appConfigServlet?apid=";
    private static final String KEY_CACHED_VIDEOS = "handshake_cachedvideos5.0";
    private static final String TAG = "HandShake";
    private static String adUrl = "http://androidsdk.ads.mp.mydas.mobi/getAd.php5?";
    static String apid = MMSDK.DEFAULT_BANNER_APID;
    private static boolean forceRefresh;
    private static String handShakeURL = "https://ads.mp.mydas.mobi/appConfigServlet?apid=";
    private static HandShake sharedInstance;
    long adRefreshSecs;
    private final LinkedHashMap<String, AdTypeHandShake> adTypeHandShakes = new LinkedHashMap();
    private WeakReference<Context> appContextRef;
    DTOCachedVideo[] cachedVideos;
    private WeakReference<Context> contextRef;
    long creativeCacheTimeout = 259200000;
    private long deferredViewTimeout = 3600000;
    String endSessionURL;
    private long handShakeCallback = 86400000;
    private final Handler handler = new Handler(Looper.getMainLooper());
    boolean hardwareAccelerationEnabled;
    boolean kill = false;
    private long lastHandShake;
    String mmdid;
    String mmjsUrl;
    private String noVideosToCacheURL;
    NuanceCredentials nuanceCredentials;
    private final ArrayList<Scheme> schemes = new ArrayList();
    private String schemesList;
    String startSessionURL;
    private final Runnable updateHandShakeRunnable = new Runnable() {
        public void run() {
            Context context = (Context) HandShake.this.contextRef.get();
            if (context == null) {
                context = (Context) HandShake.this.appContextRef.get();
            }
            if (context != null) {
                HandShake.sharedHandShake(context);
            }
        }
    };

    private class AdTypeHandShake {
        boolean downloading;
        long lastVideo = 0;
        long videoInterval = 0;

        AdTypeHandShake() {
        }

        boolean canRequestVideo(Context context) {
            long time = System.currentTimeMillis();
            MMLog.d(HandShake.TAG, "canRequestVideo() Current Time:" + time + " Last Video: " + (this.lastVideo / 1000) + "  Diff: " + ((time - this.lastVideo) / 1000) + "  Video interval: " + (this.videoInterval / 1000));
            if (System.currentTimeMillis() - this.lastVideo > this.videoInterval) {
                return true;
            }
            return false;
        }

        boolean canDisplayCachedAd(long cachedTime) {
            return System.currentTimeMillis() - cachedTime < HandShake.this.deferredViewTimeout;
        }

        void updateLastVideoViewedTime(Context context, String adType) {
            this.lastVideo = System.currentTimeMillis();
            save(context, adType);
        }

        void deserializeFromObj(JSONObject adTypeObject) {
            if (adTypeObject != null) {
                this.videoInterval = adTypeObject.optLong("videointerval") * 1000;
            }
        }

        boolean load(SharedPreferences settings, String adType) {
            boolean settingsFound = false;
            if (settings.contains("handshake_lastvideo_" + adType)) {
                this.lastVideo = settings.getLong("handshake_lastvideo_" + adType, this.lastVideo);
                settingsFound = true;
            }
            if (!settings.contains("handshake_videointerval_" + adType)) {
                return settingsFound;
            }
            this.videoInterval = settings.getLong("handshake_videointerval_" + adType, this.videoInterval);
            return true;
        }

        void loadLastVideo(Context context, String adType) {
            SharedPreferences settings = context.getSharedPreferences("MillennialMediaSettings", 0);
            if (settings != null && settings.contains("handshake_lastvideo_" + adType)) {
                this.lastVideo = settings.getLong("handshake_lastvideo_" + adType, this.lastVideo);
            }
        }

        void save(Editor editor, String adType) {
            editor.putLong("handshake_lastvideo_" + adType, this.lastVideo);
            editor.putLong("handshake_videointerval_" + adType, this.videoInterval);
        }

        void save(Context context, String adType) {
            Editor editor = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
            save(editor, adType);
            editor.commit();
        }
    }

    static class NuanceCredentials {
        String appID;
        String appKey;
        int port;
        String server;
        String sessionID;

        private NuanceCredentials() {
        }

        public String toString() {
            return "Credentials: appid=" + this.appID + " server=" + this.server + " port=" + this.port + " appKey=" + this.appKey + "sessionID=" + this.sessionID;
        }
    }

    private class Scheme {
        int id;
        String scheme;

        Scheme() {
        }

        Scheme(String scheme, int id) {
            this.scheme = scheme;
            this.id = id;
        }

        boolean checkAvailability(Context context) {
            Intent intent;
            if (this.scheme.contains("://")) {
                intent = new Intent("android.intent.action.VIEW", Uri.parse(this.scheme));
            } else {
                intent = new Intent("android.intent.action.VIEW", Uri.parse(this.scheme + "://"));
            }
            return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
        }

        void deserializeFromObj(JSONObject schemeObject) {
            if (schemeObject != null) {
                this.scheme = schemeObject.optString("scheme", null);
                this.id = schemeObject.optInt("schemeid");
            }
        }
    }

    static void setAdUrl(String url) {
        if (!TextUtils.isEmpty(url)) {
            if (url.endsWith("/")) {
                adUrl = url + BASE_URL_PATH;
            } else {
                adUrl = url + "/" + BASE_URL_PATH;
            }
        }
    }

    static String getAdUrl() {
        if (TextUtils.isEmpty(adUrl) || !URLUtil.isHttpUrl(adUrl.replace(BASE_URL_PATH, ""))) {
            return "http://androidsdk.ads.mp.mydas.mobi/getAd.php5?";
        }
        return adUrl;
    }

    static synchronized HandShake sharedHandShake(Context context) {
        HandShake handShake;
        synchronized (HandShake.class) {
            if (apid == null) {
                MMLog.e(TAG, "No apid set for the handshake.");
                handShake = null;
            } else {
                if (sharedInstance == null) {
                    sharedInstance = new HandShake(context);
                } else if (System.currentTimeMillis() - sharedInstance.lastHandShake > sharedInstance.handShakeCallback) {
                    MMLog.d(TAG, "Handshake expired, requesting new handshake from the server.");
                    sharedInstance = new HandShake(context);
                }
                handShake = sharedInstance;
            }
        }
        return handShake;
    }

    static synchronized void setHandShakeURL(Context context, String url) {
        synchronized (HandShake.class) {
            if (setHandShakeURL(url)) {
                forceRefresh = true;
                sharedInstance = new HandShake(context);
            }
        }
    }

    static synchronized boolean setHandShakeURL(String url) {
        boolean z;
        synchronized (HandShake.class) {
            if (TextUtils.isEmpty(url)) {
                z = false;
            } else {
                if (url.startsWith(HANDSHAKE_HTTP_SCHEME)) {
                    url = url.replaceFirst(HANDSHAKE_HTTP_SCHEME, HANDSHAKE_HTTPS_SCHEME);
                }
                handShakeURL = url + HANDSHAKE_URL_OVERRIDE_PARMS;
                z = true;
            }
        }
        return z;
    }

    synchronized boolean canRequestVideo(Context context, String adType) {
        boolean canRequestVideo;
        AdTypeHandShake adTypeHandShake = (AdTypeHandShake) this.adTypeHandShakes.get(adType);
        if (adTypeHandShake != null) {
            canRequestVideo = adTypeHandShake.canRequestVideo(context);
        } else {
            canRequestVideo = true;
        }
        return canRequestVideo;
    }

    synchronized boolean canDisplayCachedAd(String adType, long cachedTime) {
        boolean canDisplayCachedAd;
        AdTypeHandShake adTypeHandShake = (AdTypeHandShake) this.adTypeHandShakes.get(adType);
        if (adTypeHandShake != null) {
            canDisplayCachedAd = adTypeHandShake.canDisplayCachedAd(cachedTime);
        } else {
            canDisplayCachedAd = true;
        }
        return canDisplayCachedAd;
    }

    synchronized void updateLastVideoViewedTime(Context context, String adType) {
        AdTypeHandShake adTypeHandShake = (AdTypeHandShake) this.adTypeHandShakes.get(adType);
        if (adTypeHandShake != null) {
            adTypeHandShake.updateLastVideoViewedTime(context, adType);
        }
    }

    synchronized boolean isAdTypeDownloading(String adType) {
        boolean z;
        AdTypeHandShake adTypeHandShake = (AdTypeHandShake) this.adTypeHandShakes.get(adType);
        if (adTypeHandShake != null) {
            z = adTypeHandShake.downloading;
        } else {
            z = false;
        }
        return z;
    }

    synchronized void lockAdTypeDownload(String adType) {
        AdTypeHandShake adTypeHandShake = (AdTypeHandShake) this.adTypeHandShakes.get(adType);
        if (adTypeHandShake != null) {
            adTypeHandShake.downloading = true;
        }
    }

    synchronized void unlockAdTypeDownload(String adType) {
        AdTypeHandShake adTypeHandShake = (AdTypeHandShake) this.adTypeHandShakes.get(adType);
        if (adTypeHandShake != null) {
            adTypeHandShake.downloading = false;
        }
    }

    void setMMdid(Context context, String newMMdid) {
        setMMdid(context, newMMdid, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001b  */
    synchronized void setMMdid(Context r5, String r6, boolean r7) {
        /*
        r4 = this;
        monitor-enter(r4);
        if (r6 == 0) goto L_0x0032;
    L_0x0003:
        r2 = r6.length();	 Catch:{ all -> 0x0035 }
        if (r2 == 0) goto L_0x0011;
    L_0x0009:
        r2 = "NULL";
        r2 = r6.equals(r2);	 Catch:{ all -> 0x0035 }
        if (r2 == 0) goto L_0x0032;
    L_0x0011:
        r2 = 0;
        r4.mmdid = r2;	 Catch:{ all -> 0x0035 }
    L_0x0014:
        r2 = r4.mmdid;	 Catch:{ all -> 0x0035 }
        com.millennialmedia.android.MMSDK.setMMdid(r2);	 Catch:{ all -> 0x0035 }
        if (r7 == 0) goto L_0x0030;
    L_0x001b:
        r2 = "MillennialMediaSettings";
        r3 = 0;
        r1 = r5.getSharedPreferences(r2, r3);	 Catch:{ all -> 0x0035 }
        r0 = r1.edit();	 Catch:{ all -> 0x0035 }
        r2 = "handshake_mmdid";
        r3 = r4.mmdid;	 Catch:{ all -> 0x0035 }
        r0.putString(r2, r3);	 Catch:{ all -> 0x0035 }
        r0.commit();	 Catch:{ all -> 0x0035 }
    L_0x0030:
        monitor-exit(r4);
        return;
    L_0x0032:
        r4.mmdid = r6;	 Catch:{ all -> 0x0035 }
        goto L_0x0014;
    L_0x0035:
        r2 = move-exception;
        monitor-exit(r4);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.millennialmedia.android.HandShake.setMMdid(android.content.Context, java.lang.String, boolean):void");
    }

    private HandShake() {
    }

    private HandShake(Context context) {
        this.contextRef = new WeakReference(context);
        this.appContextRef = new WeakReference(context.getApplicationContext());
        if (forceRefresh || !loadHandShake(context) || System.currentTimeMillis() - this.lastHandShake > this.handShakeCallback) {
            forceRefresh = false;
            this.lastHandShake = System.currentTimeMillis();
            requestHandshake(false);
        }
    }

    private void requestHandshake(final boolean isInitialize) {
        Context context = (Context) this.contextRef.get();
        if (context != null) {
            String handShakeUrl = context.getSharedPreferences("MillennialMediaSettings", 0).getString("handShakeUrl", null);
            if (handShakeUrl != null) {
                setHandShakeURL(handShakeUrl);
            }
        }
        ThreadUtils.execute(new Runnable() {
            /* JADX WARNING: Failed to extract finally block: empty outs */
            /* JADX WARNING: Failed to extract finally block: empty outs */
            /* JADX WARNING: Removed duplicated region for block: B:72:? A:{SYNTHETIC, RETURN} */
            /* JADX WARNING: Removed duplicated region for block: B:48:0x01ce  */
            /* JADX WARNING: Removed duplicated region for block: B:52:0x01df A:{ExcHandler: java.lang.Exception (r1_0 'e' java.lang.Exception), Splitter: B:33:0x00f2, PHI: r8 } */
            /* JADX WARNING: Removed duplicated region for block: B:52:0x01df A:{ExcHandler: java.lang.Exception (r1_0 'e' java.lang.Exception), Splitter: B:33:0x00f2, PHI: r8 } */
            /* JADX WARNING: Removed duplicated region for block: B:52:0x01df A:{ExcHandler: java.lang.Exception (r1_0 'e' java.lang.Exception), Splitter: B:33:0x00f2, PHI: r8 } */
            /* JADX WARNING: Removed duplicated region for block: B:52:0x01df A:{ExcHandler: java.lang.Exception (r1_0 'e' java.lang.Exception), Splitter: B:33:0x00f2, PHI: r8 } */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing block: B:32:0x00f0, code:
            if (r5.getStatusLine().getStatusCode() != 200) goto L_0x00f2;
     */
            /* JADX WARNING: Missing block: B:39:0x0146, code:
            if (r5.getStatusLine().getStatusCode() != 200) goto L_0x0148;
     */
            /* JADX WARNING: Missing block: B:52:0x01df, code:
            r1 = move-exception;
     */
            /* JADX WARNING: Missing block: B:54:?, code:
            com.millennialmedia.android.MMLog.e(com.millennialmedia.android.HandShake.TAG, "Could not get a handshake. ", r1);
     */
            /* JADX WARNING: Missing block: B:56:0x01e8, code:
            if (false != false) goto L_0x01ea;
     */
            /* JADX WARNING: Missing block: B:57:0x01ea, code:
            com.millennialmedia.android.HandShake.access$1000(r15.this$0, r9);
     */
            /* JADX WARNING: Missing block: B:65:0x0204, code:
            r7 = move-exception;
     */
            /* JADX WARNING: Missing block: B:67:?, code:
            com.millennialmedia.android.MMLog.e(com.millennialmedia.android.HandShake.TAG, "Could not get a handshake. ", r7);
     */
            /* JADX WARNING: Missing block: B:74:?, code:
            return;
     */
            /* JADX WARNING: Missing block: B:75:?, code:
            return;
     */
            public void run() {
                /*
                r15 = this;
                r10 = com.millennialmedia.android.HandShake.this;
                r10 = r10.contextRef;
                r9 = r10.get();
                r9 = (android.content.Context) r9;
                if (r9 != 0) goto L_0x001a;
            L_0x000e:
                r10 = com.millennialmedia.android.HandShake.this;
                r10 = r10.appContextRef;
                r9 = r10.get();
                r9 = (android.content.Context) r9;
            L_0x001a:
                if (r9 != 0) goto L_0x001d;
            L_0x001c:
                return;
            L_0x001d:
                r8 = 0;
                r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r4.<init>();	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r0 = new java.util.TreeMap;	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r0.<init>();	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r10 = "ua";
                r11 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r11.<init>();	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r12 = "Android:";
                r11 = r11.append(r12);	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r12 = android.os.Build.MODEL;	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r11 = r11.append(r12);	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r11 = r11.toString();	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r0.put(r10, r11);	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r10 = com.millennialmedia.android.HandShake.this;	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r8 = r10.isFirstLaunch(r9);	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                if (r8 == 0) goto L_0x0051;
            L_0x004a:
                r10 = "firstlaunch";
                r11 = "1";
                r0.put(r10, r11);	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
            L_0x0051:
                r10 = r6;	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                if (r10 == 0) goto L_0x005c;
            L_0x0055:
                r10 = "init";
                r11 = "1";
                r0.put(r10, r11);	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
            L_0x005c:
                com.millennialmedia.android.MMSDK.insertUrlCommonValues(r9, r0);	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r10 = r0.entrySet();	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r6 = r10.iterator();	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
            L_0x0067:
                r10 = r6.hasNext();	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                if (r10 == 0) goto L_0x00a8;
            L_0x006d:
                r2 = r6.next();	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r2 = (java.util.Map.Entry) r2;	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r11 = "&%s=%s";
                r10 = 2;
                r12 = new java.lang.Object[r10];	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r10 = 0;
                r13 = r2.getKey();	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r12[r10] = r13;	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r13 = 1;
                r10 = r2.getValue();	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r10 = (java.lang.String) r10;	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r14 = "UTF-8";
                r10 = java.net.URLEncoder.encode(r10, r14);	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r12[r13] = r10;	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r10 = java.lang.String.format(r11, r12);	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r4.append(r10);	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                goto L_0x0067;
            L_0x0096:
                r7 = move-exception;
                r10 = "HandShake";
                r11 = "Could not get a handshake. ";
                com.millennialmedia.android.MMLog.e(r10, r11, r7);	 Catch:{ all -> 0x01fb }
                r8 = 0;
                if (r8 == 0) goto L_0x001c;
            L_0x00a1:
                r10 = com.millennialmedia.android.HandShake.this;
                r10.sentFirstLaunch(r9);
                goto L_0x001c;
            L_0x00a8:
                r10 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r10.<init>();	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r11 = com.millennialmedia.android.HandShake.handShakeURL;	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r10 = r10.append(r11);	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r11 = com.millennialmedia.android.HandShake.apid;	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r10 = r10.append(r11);	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r11 = r4.toString();	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r10 = r10.append(r11);	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r3 = r10.toString();	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r10 = "HandShake";
                r11 = "Performing handshake: %s";
                r12 = 1;
                r12 = new java.lang.Object[r12];	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r13 = 0;
                r12[r13] = r3;	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r11 = java.lang.String.format(r11, r12);	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                com.millennialmedia.android.MMLog.v(r10, r11);	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r5 = 0;
                r10 = new com.millennialmedia.android.HttpGetRequest;	 Catch:{ IOException -> 0x01d5, Exception -> 0x01df }
                r11 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
                r10.<init>(r11);	 Catch:{ IOException -> 0x01d5, Exception -> 0x01df }
                r5 = r10.get(r3);	 Catch:{ IOException -> 0x01d5, Exception -> 0x01df }
            L_0x00e4:
                if (r5 == 0) goto L_0x00f2;
            L_0x00e6:
                r10 = r5.getStatusLine();	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r10 = r10.getStatusCode();	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r11 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
                if (r10 == r11) goto L_0x013a;
            L_0x00f2:
                r10 = com.millennialmedia.android.HandShake.handShakeURL;	 Catch:{ IOException -> 0x01f1, Exception -> 0x01df }
                r11 = "https://";
                r12 = "http://";
                r10 = r10.replaceFirst(r11, r12);	 Catch:{ IOException -> 0x01f1, Exception -> 0x01df }
                com.millennialmedia.android.HandShake.handShakeURL = r10;	 Catch:{ IOException -> 0x01f1, Exception -> 0x01df }
                r10 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x01f1, Exception -> 0x01df }
                r10.<init>();	 Catch:{ IOException -> 0x01f1, Exception -> 0x01df }
                r11 = com.millennialmedia.android.HandShake.handShakeURL;	 Catch:{ IOException -> 0x01f1, Exception -> 0x01df }
                r10 = r10.append(r11);	 Catch:{ IOException -> 0x01f1, Exception -> 0x01df }
                r11 = com.millennialmedia.android.HandShake.apid;	 Catch:{ IOException -> 0x01f1, Exception -> 0x01df }
                r10 = r10.append(r11);	 Catch:{ IOException -> 0x01f1, Exception -> 0x01df }
                r11 = r4.toString();	 Catch:{ IOException -> 0x01f1, Exception -> 0x01df }
                r10 = r10.append(r11);	 Catch:{ IOException -> 0x01f1, Exception -> 0x01df }
                r3 = r10.toString();	 Catch:{ IOException -> 0x01f1, Exception -> 0x01df }
                r10 = "HandShake";
                r11 = "Performing handshake (HTTP Fallback): %s";
                r12 = 1;
                r12 = new java.lang.Object[r12];	 Catch:{ IOException -> 0x01f1, Exception -> 0x01df }
                r13 = 0;
                r12[r13] = r3;	 Catch:{ IOException -> 0x01f1, Exception -> 0x01df }
                r11 = java.lang.String.format(r11, r12);	 Catch:{ IOException -> 0x01f1, Exception -> 0x01df }
                com.millennialmedia.android.MMLog.v(r10, r11);	 Catch:{ IOException -> 0x01f1, Exception -> 0x01df }
                r10 = new com.millennialmedia.android.HttpGetRequest;	 Catch:{ IOException -> 0x01f1, Exception -> 0x01df }
                r10.<init>();	 Catch:{ IOException -> 0x01f1, Exception -> 0x01df }
                r5 = r10.get(r3);	 Catch:{ IOException -> 0x01f1, Exception -> 0x01df }
            L_0x013a:
                if (r5 == 0) goto L_0x0148;
            L_0x013c:
                r10 = r5.getStatusLine();	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r10 = r10.getStatusCode();	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r11 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
                if (r10 == r11) goto L_0x0186;
            L_0x0148:
                r10 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0204, Exception -> 0x01df }
                r10.<init>();	 Catch:{ IOException -> 0x0204, Exception -> 0x01df }
                r11 = "http://ads.mp.mydas.mobi/appConfigServlet?apid=";
                r10 = r10.append(r11);	 Catch:{ IOException -> 0x0204, Exception -> 0x01df }
                r11 = com.millennialmedia.android.HandShake.apid;	 Catch:{ IOException -> 0x0204, Exception -> 0x01df }
                r10 = r10.append(r11);	 Catch:{ IOException -> 0x0204, Exception -> 0x01df }
                r11 = r4.toString();	 Catch:{ IOException -> 0x0204, Exception -> 0x01df }
                r10 = r10.append(r11);	 Catch:{ IOException -> 0x0204, Exception -> 0x01df }
                r3 = r10.toString();	 Catch:{ IOException -> 0x0204, Exception -> 0x01df }
                r10 = "HandShake";
                r11 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0204, Exception -> 0x01df }
                r11.<init>();	 Catch:{ IOException -> 0x0204, Exception -> 0x01df }
                r12 = "Performing handshake (HTTP Fallback Original): ";
                r11 = r11.append(r12);	 Catch:{ IOException -> 0x0204, Exception -> 0x01df }
                r11 = r11.append(r3);	 Catch:{ IOException -> 0x0204, Exception -> 0x01df }
                r11 = r11.toString();	 Catch:{ IOException -> 0x0204, Exception -> 0x01df }
                com.millennialmedia.android.MMLog.v(r10, r11);	 Catch:{ IOException -> 0x0204, Exception -> 0x01df }
                r10 = new com.millennialmedia.android.HttpGetRequest;	 Catch:{ IOException -> 0x0204, Exception -> 0x01df }
                r10.<init>();	 Catch:{ IOException -> 0x0204, Exception -> 0x01df }
                r5 = r10.get(r3);	 Catch:{ IOException -> 0x0204, Exception -> 0x01df }
            L_0x0186:
                if (r5 == 0) goto L_0x020e;
            L_0x0188:
                r10 = r5.getStatusLine();	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r10 = r10.getStatusCode();	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r11 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
                if (r10 != r11) goto L_0x020e;
            L_0x0194:
                r10 = com.millennialmedia.android.HandShake.this;	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r11 = com.millennialmedia.android.HandShake.this;	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r12 = r5.getEntity();	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r12 = r12.getContent();	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r12 = com.millennialmedia.android.HttpGetRequest.convertStreamToString(r12);	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r11 = r11.parseJson(r12);	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r10.deserializeFromObj(r11);	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r10 = com.millennialmedia.android.HandShake.this;	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r10.saveHandShake(r9);	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r10 = com.millennialmedia.android.HandShake.this;	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r10 = r10.handler;	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r11 = com.millennialmedia.android.HandShake.this;	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r11 = r11.updateHandShakeRunnable;	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r12 = com.millennialmedia.android.HandShake.this;	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r12 = r12.handShakeCallback;	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r10.postDelayed(r11, r12);	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                r10 = "HandShake";
                r11 = "Obtained a new handshake";
                com.millennialmedia.android.MMLog.v(r10, r11);	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
            L_0x01cc:
                if (r8 == 0) goto L_0x001c;
            L_0x01ce:
                r10 = com.millennialmedia.android.HandShake.this;
                r10.sentFirstLaunch(r9);
                goto L_0x001c;
            L_0x01d5:
                r7 = move-exception;
                r10 = "HandShake";
                r11 = "Could not get a handshake. ";
                com.millennialmedia.android.MMLog.e(r10, r11, r7);	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                goto L_0x00e4;
            L_0x01df:
                r1 = move-exception;
                r10 = "HandShake";
                r11 = "Could not get a handshake. ";
                com.millennialmedia.android.MMLog.e(r10, r11, r1);	 Catch:{ all -> 0x01fb }
                r8 = 0;
                if (r8 == 0) goto L_0x001c;
            L_0x01ea:
                r10 = com.millennialmedia.android.HandShake.this;
                r10.sentFirstLaunch(r9);
                goto L_0x001c;
            L_0x01f1:
                r7 = move-exception;
                r10 = "HandShake";
                r11 = "Could not get a handshake. ";
                com.millennialmedia.android.MMLog.e(r10, r11, r7);	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                goto L_0x013a;
            L_0x01fb:
                r10 = move-exception;
                if (r8 == 0) goto L_0x0203;
            L_0x01fe:
                r11 = com.millennialmedia.android.HandShake.this;
                r11.sentFirstLaunch(r9);
            L_0x0203:
                throw r10;
            L_0x0204:
                r7 = move-exception;
                r10 = "HandShake";
                r11 = "Could not get a handshake. ";
                com.millennialmedia.android.MMLog.e(r10, r11, r7);	 Catch:{ IOException -> 0x0096, Exception -> 0x01df }
                goto L_0x0186;
            L_0x020e:
                r8 = 0;
                goto L_0x01cc;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.millennialmedia.android.HandShake.1.run():void");
            }
        });
    }

    void sendInitRequest() {
        requestHandshake(true);
    }

    private boolean isFirstLaunch(Context tempContext) {
        if (tempContext == null) {
            return false;
        }
        return tempContext.getSharedPreferences("MillennialMediaSettings", 0).getBoolean("firstlaunchHandshake", true);
    }

    private void sentFirstLaunch(Context tempContext) {
        if (tempContext != null) {
            Editor editor = tempContext.getSharedPreferences("MillennialMediaSettings", 0).edit();
            editor.putBoolean("firstlaunchHandshake", false);
            editor.commit();
        }
    }

    synchronized String getSchemesList(Context context) {
        if (this.schemesList == null && this.schemes.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator i$ = this.schemes.iterator();
            while (i$.hasNext()) {
                Scheme scheme = (Scheme) i$.next();
                if (scheme.checkAvailability(context)) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append("," + scheme.id);
                    } else {
                        stringBuilder.append(Integer.toString(scheme.id));
                    }
                }
            }
            if (stringBuilder.length() > 0) {
                this.schemesList = stringBuilder.toString();
            }
        }
        return this.schemesList;
    }

    synchronized JSONArray getSchemesJSONArray(Context context) {
        JSONArray array;
        array = new JSONArray();
        if (this.schemes.size() > 0) {
            Iterator i$ = this.schemes.iterator();
            while (i$.hasNext()) {
                Scheme scheme = (Scheme) i$.next();
                if (scheme.checkAvailability(context)) {
                    try {
                        JSONObject schemeObject = new JSONObject();
                        schemeObject.put("scheme", scheme.scheme);
                        schemeObject.put("schemeid", scheme.id);
                        array.put(schemeObject);
                    } catch (JSONException e) {
                        MMLog.e(TAG, "Json error getting scheme", e);
                    }
                }
            }
        }
        return array;
    }

    private JSONObject parseJson(String jsonString) {
        MMLog.d(TAG, String.format("JSON String: %s", new Object[]{jsonString}));
        if (jsonString != null) {
            try {
                JSONObject jsonObject = new JSONObject(jsonString);
                MMLog.v(TAG, jsonObject.toString());
                if (jsonObject.has("mmishake")) {
                    return jsonObject.getJSONObject("mmishake");
                }
            } catch (JSONException e) {
                MMLog.e(TAG, "Error parsing json", e);
            }
        }
        return null;
    }

    private void deserializeFromObj(JSONObject handShakeObject) {
        Context context = (Context) this.contextRef.get();
        if (context == null) {
            context = (Context) this.appContextRef.get();
        }
        if (context == null) {
            MMLog.e(TAG, "No context for handshake");
        } else if (handShakeObject != null) {
            try {
                int i;
                JSONObject jsonObject;
                JSONArray jsonArray = handShakeObject.optJSONArray("errors");
                if (jsonArray != null) {
                    for (i = 0; i < jsonArray.length(); i++) {
                        jsonObject = jsonArray.optJSONObject(i);
                        if (jsonObject != null) {
                            final String message = jsonObject.optString("message", null);
                            String type = jsonObject.optString("type", null);
                            if (!(message == null || type == null)) {
                                if (type.equalsIgnoreCase("log")) {
                                    MMLog.e(TAG, message);
                                } else if (type.equalsIgnoreCase("prompt")) {
                                    final Context toastContext = context;
                                    this.handler.post(new Runnable() {
                                        public void run() {
                                            try {
                                                Toast.makeText(toastContext, "Error: " + message, 1).show();
                                            } catch (BadTokenException e) {
                                                MMLog.e(HandShake.TAG, "Error with toast token", e);
                                            }
                                        }
                                    });
                                }
                            }
                        }
                    }
                }
                jsonObject = handShakeObject.optJSONObject("adtypes");
                if (jsonObject != null) {
                    String[] adTypes = MMAdImpl.getAdTypes();
                    for (i = 0; i < adTypes.length; i++) {
                        JSONObject adTypeObject = jsonObject.optJSONObject(adTypes[i]);
                        if (adTypeObject != null) {
                            AdTypeHandShake adTypeHandShake = new AdTypeHandShake();
                            adTypeHandShake.deserializeFromObj(adTypeObject);
                            adTypeHandShake.loadLastVideo(context, adTypes[i]);
                            this.adTypeHandShakes.put(adTypes[i], adTypeHandShake);
                        }
                    }
                }
                synchronized (this) {
                    jsonArray = handShakeObject.optJSONArray("schemes");
                    if (jsonArray != null) {
                        if (this.schemes != null && this.schemes.size() > 0) {
                            this.schemes.removeAll(this.schemes);
                        }
                        for (i = 0; i < jsonArray.length(); i++) {
                            jsonObject = jsonArray.optJSONObject(i);
                            if (jsonObject != null) {
                                Scheme scheme = new Scheme();
                                scheme.deserializeFromObj(jsonObject);
                                this.schemes.add(scheme);
                            }
                        }
                    }
                }
                this.adRefreshSecs = handShakeObject.optLong("adrefresh", 0);
                this.deferredViewTimeout = handShakeObject.optLong("deferredviewtimeout", 3600) * 1000;
                this.kill = handShakeObject.optBoolean("kill");
                setAdUrl(handShakeObject.optString("baseURL"));
                this.handShakeCallback = handShakeObject.optLong("handshakecallback", 86400) * 1000;
                this.creativeCacheTimeout = handShakeObject.optLong("creativeCacheTimeout", 259200) * 1000;
                this.hardwareAccelerationEnabled = handShakeObject.optBoolean("hardwareAccelerationEnabled");
                this.startSessionURL = handShakeObject.optString("startSessionURL");
                this.endSessionURL = handShakeObject.optString("endSessionURL");
                this.nuanceCredentials = (NuanceCredentials) new Gson().fromJson(handShakeObject.optString("nuanceCredentials"), NuanceCredentials.class);
                this.mmjsUrl = handShakeObject.optString("mmjs");
                handleCachedVideos(handShakeObject, context);
                if (TextUtils.isEmpty(this.mmjsUrl) || MRaid.isMRaidUpdated(context, this.mmjsUrl)) {
                    MMLog.w(TAG, "Not downloading MMJS - (" + this.mmjsUrl + ")");
                } else {
                    MRaid.downloadMraidJs((Context) this.appContextRef.get(), this.mmjsUrl);
                }
            } catch (Exception e) {
                MMLog.e(TAG, "Error deserializing handshake", e);
            }
        }
    }

    private void handleCachedVideos(JSONObject handShakeObject, Context context) {
        JSONArray jsonArray = handShakeObject.optJSONArray("cachedVideos");
        if (jsonArray != null) {
            this.cachedVideos = (DTOCachedVideo[]) new Gson().fromJson(jsonArray.toString(), DTOCachedVideo[].class);
            MMLog.d(TAG, this.cachedVideos.toString());
        }
        this.noVideosToCacheURL = handShakeObject.optString("noVideosToCacheURL");
        if (this.cachedVideos != null) {
            PreCacheWorker.preCacheVideos(this.cachedVideos, context, this.noVideosToCacheURL);
        }
    }

    private boolean loadHandShake(Context context) {
        boolean settingsFound = false;
        SharedPreferences settings = context.getSharedPreferences("MillennialMediaSettings", 0);
        if (settings == null) {
            return false;
        }
        if (settings.contains("handshake_deferredviewtimeout")) {
            this.deferredViewTimeout = settings.getLong("handshake_deferredviewtimeout", this.deferredViewTimeout);
            settingsFound = true;
        }
        if (settings.contains("handshake_baseUrl")) {
            adUrl = settings.getString("handshake_baseUrl", adUrl);
            settingsFound = true;
        }
        if (settings.contains("handshake_callback")) {
            this.handShakeCallback = settings.getLong("handshake_callback", this.handShakeCallback);
            settingsFound = true;
        }
        if (settings.contains("handshake_hardwareAccelerationEnabled")) {
            this.hardwareAccelerationEnabled = settings.getBoolean("handshake_hardwareAccelerationEnabled", false);
            settingsFound = true;
        }
        if (settings.contains("handshake_startSessionURL")) {
            this.startSessionURL = settings.getString("handshake_startSessionURL", "");
            settingsFound = true;
        }
        if (settings.contains("handshake_endSessionURL")) {
            this.endSessionURL = settings.getString("handshake_endSessionURL", "");
            settingsFound = true;
        }
        if (settings.contains("handshake_nuanceCredentials")) {
            this.nuanceCredentials = (NuanceCredentials) new Gson().fromJson(settings.getString("handshake_nuanceCredentials", ""), NuanceCredentials.class);
            settingsFound = true;
        }
        if (settings.contains("handshake_mmdid")) {
            setMMdid(context, settings.getString("handshake_mmdid", this.mmdid), false);
            settingsFound = true;
        }
        if (settings.contains("handshake_creativecachetimeout")) {
            this.creativeCacheTimeout = settings.getLong("handshake_creativecachetimeout", this.creativeCacheTimeout);
            settingsFound = true;
        }
        if (settings.contains("handshake_mmjs")) {
            this.mmjsUrl = settings.getString("handshake_mmjs", this.mmjsUrl);
            settingsFound = true;
        }
        String[] adTypes = MMAdImpl.getAdTypes();
        for (int i = 0; i < adTypes.length; i++) {
            AdTypeHandShake adTypeHandShake = new AdTypeHandShake();
            if (adTypeHandShake.load(settings, adTypes[i])) {
                settingsFound = true;
                this.adTypeHandShakes.put(adTypes[i], adTypeHandShake);
            }
        }
        synchronized (this) {
            if (settings.contains("handshake_schemes")) {
                String schemesStr = settings.getString("handshake_schemes", "");
                if (schemesStr.length() > 0) {
                    for (String str : schemesStr.split("\n")) {
                        String[] parts = str.split("\t");
                        if (parts.length >= 2) {
                            this.schemes.add(new Scheme(parts[0], Integer.parseInt(parts[1])));
                        }
                    }
                    settingsFound = true;
                }
            }
        }
        if (settings.contains(KEY_CACHED_VIDEOS)) {
            String savedVideos = settings.getString(KEY_CACHED_VIDEOS, "");
            if (savedVideos.length() > 0) {
                this.cachedVideos = (DTOCachedVideo[]) new Gson().fromJson(savedVideos, DTOCachedVideo[].class);
            }
        }
        if (settings.contains("handshake_lasthandshake")) {
            this.lastHandShake = settings.getLong("handshake_lasthandshake", this.lastHandShake);
            settingsFound = true;
        }
        if (settingsFound) {
            MMLog.d(TAG, "Handshake successfully loaded from shared preferences.");
            if (System.currentTimeMillis() - this.lastHandShake < this.handShakeCallback) {
                this.handler.postDelayed(this.updateHandShakeRunnable, this.handShakeCallback - (System.currentTimeMillis() - this.lastHandShake));
            }
            this.noVideosToCacheURL = settings.getString("handshake_novideostocacheurl", "");
            if (this.cachedVideos != null) {
                PreCacheWorker.preCacheVideos(this.cachedVideos, context, this.noVideosToCacheURL);
            }
        }
        return settingsFound;
    }

    private void saveHandShake(Context context) {
        Editor editor = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
        editor.putLong("handshake_deferredviewtimeout", this.deferredViewTimeout);
        editor.putBoolean("handshake_kill", this.kill);
        editor.putString("handshake_baseUrl", adUrl);
        editor.putLong("handshake_callback", this.handShakeCallback);
        editor.putBoolean("handshake_hardwareAccelerationEnabled", this.hardwareAccelerationEnabled);
        editor.putString("handshake_startSessionURL", this.startSessionURL);
        if (this.nuanceCredentials != null) {
            editor.putString("handshake_nuanceCredentials", new Gson().toJson(this.nuanceCredentials));
        }
        editor.putString("handshake_endSessionURL", this.endSessionURL);
        editor.putLong("handshake_creativecaetimeout", this.creativeCacheTimeout);
        editor.putString("handshake_mmjs", this.mmjsUrl);
        for (String adType : this.adTypeHandShakes.keySet()) {
            ((AdTypeHandShake) this.adTypeHandShakes.get(adType)).save(editor, adType);
        }
        synchronized (this) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < this.schemes.size(); i++) {
                Scheme scheme = (Scheme) this.schemes.get(i);
                if (i > 0) {
                    stringBuilder.append("\n");
                }
                stringBuilder.append(scheme.scheme + "\t" + scheme.id);
            }
            editor.putString("handshake_schemes", stringBuilder.toString());
        }
        if (this.cachedVideos != null) {
            editor.putString(KEY_CACHED_VIDEOS, new Gson().toJson(this.cachedVideos));
        }
        editor.putString("handshake_novideostocacheurl", this.noVideosToCacheURL);
        editor.putLong("handshake_lasthandshake", this.lastHandShake);
        editor.commit();
    }

    void startSession() {
        if (!TextUtils.isEmpty(this.startSessionURL)) {
            HttpUtils.executeUrl(this.startSessionURL);
        }
    }

    void endSession() {
        if (!TextUtils.isEmpty(this.endSessionURL)) {
            HttpUtils.executeUrl(this.endSessionURL);
        }
    }
}
