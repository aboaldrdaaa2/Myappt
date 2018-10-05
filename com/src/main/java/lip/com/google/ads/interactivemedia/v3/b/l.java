package lip.com.google.ads.interactivemedia.v3.b;

import android.content.Context;
import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.webkit.WebViewClient;
import com.google.ads.interactivemedia.v3.b.a.c;
import com.google.ads.interactivemedia.v3.b.a.c.a;

/* compiled from: IMASDK */
public final class l extends WebView {
    public l(final Context context, final s sVar, c cVar) {
        super(context);
        getSettings().setSupportMultipleWindows(true);
        setWebChromeClient(new WebChromeClient() {
            public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message resultMsg) {
                WebViewTransport webViewTransport = (WebViewTransport) resultMsg.obj;
                webViewTransport.setWebView(new WebView(context));
                webViewTransport.getWebView().setWebViewClient(new WebViewClient() {
                    public final boolean shouldOverrideUrlLoading(WebView webView, String url) {
                        sVar.b(url);
                        return true;
                    }
                });
                resultMsg.sendToTarget();
                return true;
            }
        });
        if (cVar.type == a.Html) {
            loadData(cVar.src, "text/html", null);
        } else if (cVar.type == a.IFrame) {
            loadUrl(cVar.src);
        } else {
            throw new IllegalArgumentException("Companion type " + cVar.type + " is not valid for a CompanionWebView");
        }
    }
}
