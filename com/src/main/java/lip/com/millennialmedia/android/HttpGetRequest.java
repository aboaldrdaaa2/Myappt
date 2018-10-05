package lip.com.millennialmedia.android;

import android.text.TextUtils;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

class HttpGetRequest {
    private static final String TAG = "HttpGetRequest";
    private HttpClient client;
    private HttpGet getRequest = new HttpGet();

    HttpGetRequest() {
        HttpParams params = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(params, 10000);
        this.client = new DefaultHttpClient(params);
    }

    HttpGetRequest(int timeout) {
        HttpParams params = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(params, 10000);
        HttpConnectionParams.setSoTimeout(params, timeout);
        this.client = new DefaultHttpClient(params);
    }

    HttpResponse get(String url) throws Exception {
        HttpResponse response = null;
        if (!TextUtils.isEmpty(url)) {
            try {
                this.getRequest.setURI(new URI(url));
                response = this.client.execute(this.getRequest);
            } catch (OutOfMemoryError e) {
                MMLog.e(TAG, "Out of memory!", e);
                return null;
            } catch (Exception ex) {
                if (ex == null) {
                    return null;
                }
                MMLog.e(TAG, "Error connecting:", ex);
                return null;
            }
        }
        return response;
    }

    void trackConversion(String goalId, boolean isFirstLaunch, long installTime, TreeMap<String, String> extraParams) throws Exception {
        try {
            StringBuilder urlBuilder = new StringBuilder("http://cvt.mydas.mobi/handleConversion?firstlaunch=" + (isFirstLaunch ? 1 : 0));
            if (goalId != null) {
                urlBuilder.append("&goalId=" + goalId);
            }
            if (installTime > 0) {
                urlBuilder.append("&installtime=" + (installTime / 1000));
            }
            if (extraParams != null) {
                for (Entry<String, String> entry : extraParams.entrySet()) {
                    urlBuilder.append(String.format("&%s=%s", new Object[]{entry.getKey(), URLEncoder.encode((String) entry.getValue(), "UTF-8")}));
                }
            }
            MMLog.d(TAG, String.format("Sending conversion tracker report: %s", new Object[]{urlBuilder.toString()}));
            this.getRequest.setURI(new URI(url));
            if (this.client.execute(this.getRequest).getStatusLine().getStatusCode() == 200) {
                MMLog.v(TAG, String.format("Successful conversion tracking event: %d", new Object[]{Integer.valueOf(this.client.execute(this.getRequest).getStatusLine().getStatusCode())}));
            } else {
                MMLog.e(TAG, String.format("Conversion tracking error: %d", new Object[]{Integer.valueOf(this.client.execute(this.getRequest).getStatusLine().getStatusCode())}));
            }
        } catch (IOException e) {
            MMLog.e(TAG, "Conversion tracking error: ", e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0050 A:{SYNTHETIC, Splitter: B:20:0x0050} */
    static String convertStreamToString(java.io.InputStream r8) throws IOException {
        /*
        r2 = 0;
        r1 = 0;
        if (r8 != 0) goto L_0x000c;
    L_0x0004:
        r5 = new java.io.IOException;
        r6 = "Stream is null.";
        r5.<init>(r6);
        throw r5;
    L_0x000c:
        r3 = new java.io.BufferedReader;	 Catch:{ OutOfMemoryError -> 0x0073 }
        r5 = new java.io.InputStreamReader;	 Catch:{ OutOfMemoryError -> 0x0073 }
        r5.<init>(r8);	 Catch:{ OutOfMemoryError -> 0x0073 }
        r6 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r3.<init>(r5, r6);	 Catch:{ OutOfMemoryError -> 0x0073 }
        r4 = new java.lang.StringBuilder;	 Catch:{ OutOfMemoryError -> 0x003a, all -> 0x0070 }
        r4.<init>();	 Catch:{ OutOfMemoryError -> 0x003a, all -> 0x0070 }
    L_0x001d:
        r1 = r3.readLine();	 Catch:{ OutOfMemoryError -> 0x003a, all -> 0x0070 }
        if (r1 == 0) goto L_0x0054;
    L_0x0023:
        r5 = new java.lang.StringBuilder;	 Catch:{ OutOfMemoryError -> 0x003a, all -> 0x0070 }
        r5.<init>();	 Catch:{ OutOfMemoryError -> 0x003a, all -> 0x0070 }
        r5 = r5.append(r1);	 Catch:{ OutOfMemoryError -> 0x003a, all -> 0x0070 }
        r6 = "\n";
        r5 = r5.append(r6);	 Catch:{ OutOfMemoryError -> 0x003a, all -> 0x0070 }
        r5 = r5.toString();	 Catch:{ OutOfMemoryError -> 0x003a, all -> 0x0070 }
        r4.append(r5);	 Catch:{ OutOfMemoryError -> 0x003a, all -> 0x0070 }
        goto L_0x001d;
    L_0x003a:
        r0 = move-exception;
        r2 = r3;
    L_0x003c:
        r4 = 0;
        r1 = 0;
        r5 = "HttpGetRequest";
        r6 = "Out of Memeory: ";
        com.millennialmedia.android.MMLog.e(r5, r6, r0);	 Catch:{ all -> 0x004d }
        r5 = new java.io.IOException;	 Catch:{ all -> 0x004d }
        r6 = "Out of memory.";
        r5.<init>(r6);	 Catch:{ all -> 0x004d }
        throw r5;	 Catch:{ all -> 0x004d }
    L_0x004d:
        r5 = move-exception;
    L_0x004e:
        if (r2 == 0) goto L_0x0053;
    L_0x0050:
        r2.close();	 Catch:{ IOException -> 0x0067 }
    L_0x0053:
        throw r5;
    L_0x0054:
        if (r3 == 0) goto L_0x0059;
    L_0x0056:
        r3.close();	 Catch:{ IOException -> 0x005e }
    L_0x0059:
        r5 = r4.toString();
        return r5;
    L_0x005e:
        r0 = move-exception;
        r5 = "HttpGetRequest";
        r6 = "Error closing file";
        com.millennialmedia.android.MMLog.e(r5, r6, r0);
        goto L_0x0059;
    L_0x0067:
        r0 = move-exception;
        r6 = "HttpGetRequest";
        r7 = "Error closing file";
        com.millennialmedia.android.MMLog.e(r6, r7, r0);
        goto L_0x0053;
    L_0x0070:
        r5 = move-exception;
        r2 = r3;
        goto L_0x004e;
    L_0x0073:
        r0 = move-exception;
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.millennialmedia.android.HttpGetRequest.convertStreamToString(java.io.InputStream):java.lang.String");
    }

    static void log(final String[] urls) {
        if (urls != null && urls.length > 0) {
            ThreadUtils.execute(new Runnable() {
                public void run() {
                    for (String url : urls) {
                        MMLog.v(HttpGetRequest.TAG, String.format("Logging event to: %s", new Object[]{url}));
                        try {
                            new HttpGetRequest().get(arr$[i$]);
                        } catch (Exception e) {
                            MMLog.e(HttpGetRequest.TAG, "Logging request failed.", e);
                        }
                    }
                }
            });
        }
    }
}
