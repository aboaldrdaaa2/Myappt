package lip.com.google.android.gms.internal;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashMap;
import java.util.Map;

public class ey extends WebViewClient {
    protected final ex lN;
    private final Object ls = new Object();
    private ba mS;
    private bf nc;
    private bd nd;
    private a pN;
    private final HashMap<String, bc> sH = new HashMap();
    private t sI;
    private ci sJ;
    private boolean sK = false;
    private boolean sL;
    private cl sM;

    public interface a {
        void a(ex exVar);
    }

    public ey(ex exVar, boolean z) {
        this.lN = exVar;
        this.sL = z;
    }

    private static boolean d(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    private void e(Uri uri) {
        String path = uri.getPath();
        bc bcVar = (bc) this.sH.get(path);
        if (bcVar != null) {
            Map c = eo.c(uri);
            if (eu.p(2)) {
                eu.C("Received GMSG: " + path);
                for (String path2 : c.keySet()) {
                    eu.C("  " + path2 + ": " + ((String) c.get(path2)));
                }
            }
            bcVar.b(this.lN, c);
            return;
        }
        eu.C("No GMSG handler found for GMSG: " + uri);
    }

    public final void a(ce ceVar) {
        ci ciVar = null;
        boolean ce = this.lN.ce();
        t tVar = (!ce || this.lN.V().mf) ? this.sI : null;
        if (!ce) {
            ciVar = this.sJ;
        }
        a(new ch(ceVar, tVar, ciVar, this.sM, this.lN.cd()));
    }

    protected void a(ch chVar) {
        cf.a(this.lN.getContext(), chVar);
    }

    public final void a(a aVar) {
        this.pN = aVar;
    }

    public void a(t tVar, ci ciVar, ba baVar, cl clVar, boolean z, bd bdVar) {
        a("/appEvent", new az(baVar));
        a("/canOpenURLs", bb.mU);
        a("/click", bb.mV);
        a("/close", bb.mW);
        a("/customClose", bb.mX);
        a("/httpTrack", bb.mY);
        a("/log", bb.mZ);
        a("/open", new bg(bdVar));
        a("/touch", bb.na);
        a("/video", bb.nb);
        this.sI = tVar;
        this.sJ = ciVar;
        this.mS = baVar;
        this.nd = bdVar;
        this.sM = clVar;
        r(z);
    }

    public void a(t tVar, ci ciVar, ba baVar, cl clVar, boolean z, bd bdVar, bf bfVar) {
        a(tVar, ciVar, baVar, clVar, z, bdVar);
        a("/setInterstitialProperties", new be(bfVar));
        this.nc = bfVar;
    }

    public final void a(String str, bc bcVar) {
        this.sH.put(str, bcVar);
    }

    public final void a(boolean z, int i) {
        t tVar = (!this.lN.ce() || this.lN.V().mf) ? this.sI : null;
        a(new ch(tVar, this.sJ, this.sM, this.lN, z, i, this.lN.cd()));
    }

    public final void a(boolean z, int i, String str) {
        ci ciVar = null;
        boolean ce = this.lN.ce();
        t tVar = (!ce || this.lN.V().mf) ? this.sI : null;
        if (!ce) {
            ciVar = this.sJ;
        }
        a(new ch(tVar, ciVar, this.mS, this.sM, this.lN, z, i, str, this.lN.cd(), this.nd));
    }

    public final void a(boolean z, int i, String str, String str2) {
        boolean ce = this.lN.ce();
        t tVar = (!ce || this.lN.V().mf) ? this.sI : null;
        a(new ch(tVar, ce ? null : this.sJ, this.mS, this.sM, this.lN, z, i, str, str2, this.lN.cd(), this.nd));
    }

    public final void aS() {
        synchronized (this.ls) {
            this.sK = false;
            this.sL = true;
            final cf ca = this.lN.ca();
            if (ca != null) {
                if (et.bW()) {
                    ca.aS();
                } else {
                    et.sv.post(new Runnable() {
                        public void run() {
                            ca.aS();
                        }
                    });
                }
            }
        }
    }

    public boolean cj() {
        boolean z;
        synchronized (this.ls) {
            z = this.sL;
        }
        return z;
    }

    public final void onLoadResource(WebView webView, String url) {
        eu.C("Loading resource: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            e(parse);
        }
    }

    public final void onPageFinished(WebView webView, String url) {
        if (this.pN != null) {
            this.pN.a(this.lN);
            this.pN = null;
        }
    }

    public final void r(boolean z) {
        this.sK = z;
    }

    public final void reset() {
        synchronized (this.ls) {
            this.sH.clear();
            this.sI = null;
            this.sJ = null;
            this.pN = null;
            this.mS = null;
            this.sK = false;
            this.sL = false;
            this.nd = null;
            this.sM = null;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String url) {
        eu.C("AdWebView shouldOverrideUrlLoading: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            e(parse);
        } else if (this.sK && webView == this.lN && d(parse)) {
            return super.shouldOverrideUrlLoading(webView, url);
        } else {
            if (this.lN.willNotDraw()) {
                eu.D("AdWebView unable to handle URL: " + url);
            } else {
                Uri uri;
                try {
                    k cc = this.lN.cc();
                    if (cc != null && cc.b(parse)) {
                        parse = cc.a(parse, this.lN.getContext());
                    }
                    uri = parse;
                } catch (l e) {
                    eu.D("Unable to append parameter to URL: " + url);
                    uri = parse;
                }
                a(new ce("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            }
        }
        return true;
    }
}
