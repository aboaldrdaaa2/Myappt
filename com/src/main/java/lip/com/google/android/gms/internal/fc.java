package lip.com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URI;
import java.net.URISyntaxException;

public class fc extends WebViewClient {
    private final ex lN;
    private final String sT;
    private boolean sU = false;
    private final do sV;

    public fc(do doVar, ex exVar, String str) {
        this.sT = G(str);
        this.lN = exVar;
        this.sV = doVar;
    }

    private String G(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return str.endsWith("/") ? str.substring(0, str.length() - 1) : str;
        } catch (IndexOutOfBoundsException e) {
            eu.A(e.getMessage());
            return str;
        }
    }

    protected boolean F(String str) {
        Object G = G(str);
        if (TextUtils.isEmpty(G)) {
            return false;
        }
        try {
            URI uri = new URI(G);
            if ("passback".equals(uri.getScheme())) {
                eu.z("Passback received");
                this.sV.bp();
                return true;
            } else if (TextUtils.isEmpty(this.sT)) {
                return false;
            } else {
                URI uri2 = new URI(this.sT);
                String host = uri2.getHost();
                String host2 = uri.getHost();
                String path = uri2.getPath();
                String path2 = uri.getPath();
                if (!hk.equal(host, host2) || !hk.equal(path, path2)) {
                    return false;
                }
                eu.z("Passback received");
                this.sV.bp();
                return true;
            }
        } catch (URISyntaxException e) {
            eu.A(e.getMessage());
            return false;
        }
    }

    public void onLoadResource(WebView view, String url) {
        eu.z("JavascriptAdWebViewClient::onLoadResource: " + url);
        if (!F(url)) {
            this.lN.cb().onLoadResource(this.lN, url);
        }
    }

    public void onPageFinished(WebView view, String url) {
        eu.z("JavascriptAdWebViewClient::onPageFinished: " + url);
        if (!this.sU) {
            this.sV.bo();
            this.sU = true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        eu.z("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + url);
        if (!F(url)) {
            return this.lN.cb().shouldOverrideUrlLoading(this.lN, url);
        }
        eu.z("shouldOverrideUrlLoading: received passback url");
        return true;
    }
}
