package lip.com.google.ads.interactivemedia.v3.b;

import android.content.Context;
import android.util.Log;
import com.google.ads.interactivemedia.v3.api.Ad;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.b.b.d;
import com.google.ads.interactivemedia.v3.b.b.e;
import com.google.ads.interactivemedia.v3.b.r.b;
import com.google.ads.interactivemedia.v3.b.r.c;

/* compiled from: IMASDK */
public final class h implements com.google.ads.interactivemedia.v3.b.v.a {
    private final String a;
    private s b;
    private u c;
    private AdDisplayContainer d;
    private e e;
    private Context f;
    private com.google.ads.interactivemedia.v3.b.a.a g;

    /* compiled from: IMASDK */
    /* renamed from: com.google.ads.interactivemedia.v3.b.h$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[com.google.ads.interactivemedia.v3.b.a.c.a.values().length];

        static {
            b = new int[com.google.ads.interactivemedia.v3.b.r.a.values().length];
            try {
                b[com.google.ads.interactivemedia.v3.b.r.a.nativeUi.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[com.google.ads.interactivemedia.v3.b.r.a.webView.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[com.google.ads.interactivemedia.v3.b.a.c.a.Html.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[com.google.ads.interactivemedia.v3.b.a.c.a.IFrame.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[com.google.ads.interactivemedia.v3.b.a.c.a.Static.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* compiled from: IMASDK */
    private class a implements com.google.ads.interactivemedia.v3.b.b.e.a {
        private a() {
        }

        /* synthetic */ a(h hVar, byte b) {
            this();
        }

        public final void a() {
            h.this.b.b(new r(b.adsManager, c.skip, h.this.a));
        }

        public final void b() {
            h.this.b.b(new r(b.videoDisplay, c.click, h.this.a));
            h.this.b.b(h.this.g.getClickThruUrl());
        }
    }

    public h(String str, u uVar, s sVar, AdDisplayContainer adDisplayContainer, Context context) {
        this.b = sVar;
        this.c = uVar;
        this.f = context;
        this.a = str;
        this.d = adDisplayContainer;
    }

    public final void a(com.google.ads.interactivemedia.v3.b.a.a aVar) {
        if (this.g != null) {
            a(this.g);
        }
        if (aVar.isLinear()) {
            this.g = aVar;
            switch (this.c.b()) {
                case nativeUi:
                    d dVar = new d();
                    dVar.a = aVar.isSkippable();
                    Context context = this.f;
                    this.d.getPlayer();
                    this.e = new e(context, dVar, this.b, this.a);
                    this.b.a(this.e, this.a);
                    this.e.a(new a(this, (byte) 0));
                    this.d.getAdContainer().addView(this.e.a());
                    this.e.a((Ad) aVar);
                    return;
                case webView:
                    this.d.getAdContainer().addView(this.b.a());
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(Ad ad) {
        if (this.g == null || this.g.equals(ad)) {
            switch (this.c.b()) {
                case nativeUi:
                    if (this.e != null) {
                        this.e.b();
                        this.d.getAdContainer().removeView(this.e.a());
                        this.e = null;
                        this.b.a(this.a);
                        break;
                    }
                    break;
                case webView:
                    this.d.getAdContainer().removeView(this.b.a());
                    break;
            }
            this.g = null;
            return;
        }
        Log.e("IMASDK", "Cannot stop non current ad UI");
    }

    public final void a(VideoProgressUpdate videoProgressUpdate) {
        if (this.e != null) {
            this.e.a(videoProgressUpdate);
        }
    }
}
