package lip.com.google.ads.interactivemedia.v3.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: IMASDK */
public final class t {
    private final a a;
    private final WebView b;

    /* compiled from: IMASDK */
    public interface a {
        void a(r rVar);
    }

    public t(Context context, a aVar) {
        this(new WebView(context), aVar);
    }

    private t(WebView webView, a aVar) {
        this.a = aVar;
        this.b = webView;
        this.b.setBackgroundColor(0);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            public final boolean shouldOverrideUrlLoading(WebView webView, String url) {
                if (!url.startsWith("gmsg://")) {
                    return false;
                }
                t.this.b(url);
                return true;
            }

            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            }

            public final void onPageFinished(WebView webView, String str) {
            }

            public final void onReceivedError(WebView webView, int errorCode, String description, String failingUrl) {
                new StringBuilder("Error: ").append(errorCode).append(" ").append(description).append(" ").append(failingUrl);
            }
        });
    }

    public final WebView a() {
        return this.b;
    }

    public final void a(String str) {
        this.b.loadUrl(str);
    }

    public final void a(r rVar) {
        String e = rVar.e();
        new StringBuilder("Sending javascript msg: ").append(rVar).append(" as URL ").append(e);
        this.b.loadUrl(e);
    }

    protected final void b(String str) {
        try {
            r a = r.a(str);
            new StringBuilder("Received msg: ").append(a).append(" from URL ").append(str);
            this.a.a(a);
        } catch (IllegalArgumentException e) {
            Log.w("IMASDK", "Invalid internal message, ignoring. Please make sure the Google IMA SDK library is up to date. Message: " + str);
        } catch (Throwable e2) {
            Log.e("IMASDK", "An internal error occured parsing message from javascript.  Message to be parsed: " + str, e2);
        }
    }
}
