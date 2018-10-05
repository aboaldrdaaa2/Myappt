package lip.com.google.ads.interactivemedia.v3.b;

import android.content.Context;
import com.google.ads.interactivemedia.v3.api.Ad;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdError.AdErrorCode;
import com.google.ads.interactivemedia.v3.api.AdError.AdErrorType;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent.AdErrorListener;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent.AdEventListener;
import com.google.ads.interactivemedia.v3.api.AdEvent.AdEventType;
import com.google.ads.interactivemedia.v3.api.AdsManager;
import com.google.ads.interactivemedia.v3.api.AdsRenderingSettings;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer.VideoAdPlayerCallback;
import com.google.ads.interactivemedia.v3.b.r.c;
import com.google.ads.interactivemedia.v3.b.s.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

/* compiled from: IMASDK */
public final class f implements AdsManager {
    v a;
    private final s b;
    private final String c;
    private final VideoAdPlayer d;
    private com.google.ads.interactivemedia.v3.b.a.a e;
    private n f;
    private d g;
    private List<Float> h;
    private h i;
    private VideoAdPlayerCallback j;
    private final List<AdEventListener> k = new ArrayList(1);
    private final o l = new o();

    /* compiled from: IMASDK */
    private class a implements b {
        private a() {
        }

        /* synthetic */ a(f fVar, byte b) {
            this();
        }

        public final void a(AdEventType adEventType, com.google.ads.interactivemedia.v3.b.a.a aVar) {
            if (aVar != null) {
                f.this.e = aVar;
            }
            switch (adEventType) {
                case CONTENT_PAUSE_REQUESTED:
                    f.this.g = new d(f.this.b, f.this.c, f.this.a);
                    f.this.d.addCallback(f.this.g);
                    f.this.a.a(f.this.g);
                    if (f.this.j != null) {
                        f.this.d.removeCallback(f.this.j);
                        break;
                    }
                    break;
                case CONTENT_RESUME_REQUESTED:
                    f.this.d.removeCallback(f.this.g);
                    f.this.a.b(f.this.g);
                    if (f.this.j != null) {
                        f.this.d.addCallback(f.this.j);
                        break;
                    }
                    break;
                case STARTED:
                    f.this.i.a(f.this.e);
                    break;
                case COMPLETED:
                    f.this.i.a(f.this.e);
                    break;
                case ALL_ADS_COMPLETED:
                    f.this.destroy();
                    break;
            }
            f.this.a(adEventType);
            if (adEventType == AdEventType.COMPLETED) {
                f.this.e = null;
            }
        }

        public final void a(AdErrorType adErrorType, int i, String str) {
            f.this.l.a(new b(new AdError(adErrorType, i, str)));
            f.this.i.a(f.this.e);
        }

        public final void a(AdErrorType adErrorType, AdErrorCode adErrorCode, String str) {
            f.this.l.a(new b(new AdError(adErrorType, adErrorCode, str)));
            f.this.i.a(f.this.e);
        }
    }

    f(String str, s sVar, u uVar, AdDisplayContainer adDisplayContainer, List<Float> list, SortedSet<Float> sortedSet, v vVar, Context context) {
        this.i = new h(str, uVar, sVar, adDisplayContainer, context);
        this.c = str;
        this.b = sVar;
        this.d = adDisplayContainer.getPlayer();
        this.h = list;
        this.a = vVar;
        vVar.a(this.i);
        if (sortedSet != null && !sortedSet.isEmpty()) {
            this.f = new n(sVar, sortedSet, str);
            vVar.c(this.f);
            this.j = new m(vVar);
        }
    }

    public final void init() {
        init(null);
    }

    public final void init(AdsRenderingSettings settings) {
        this.b.a(new a(this, (byte) 0), this.c);
        Map hashMap = new HashMap();
        hashMap.put("adsRenderingSettings", settings);
        this.b.b(new r(r.b.adsManager, c.init, this.c, hashMap));
    }

    public final void start() {
        if (this.d == null) {
            this.l.a(new b(new AdError(AdErrorType.PLAY, AdErrorCode.INVALID_ARGUMENTS, "Ad Display Container must contain a non-null video player.")));
            return;
        }
        this.b.a(this.d, this.c);
        a(c.start);
    }

    public final void destroy() {
        this.a.c();
        this.d.removeCallback(this.g);
        if (this.j != null) {
            this.d.removeCallback(this.j);
        }
        a(c.destroy);
    }

    public final List<Float> getAdCuePoints() {
        return this.h;
    }

    public final Ad getCurrentAd() {
        return this.e;
    }

    public final void addAdErrorListener(AdErrorListener errorListener) {
        this.l.a(errorListener);
    }

    public final void removeAdErrorListener(AdErrorListener errorListener) {
        this.l.b(errorListener);
    }

    public final void addAdEventListener(AdEventListener adEventListener) {
        this.k.add(adEventListener);
    }

    public final void removeAdEventListener(AdEventListener adEventListener) {
        this.k.remove(adEventListener);
    }

    public final void skip() {
        this.b.b(new r(r.b.adsManager, c.skip, this.c));
    }

    private void a(c cVar) {
        this.b.b(new r(r.b.adsManager, cVar, this.c));
    }

    final void a(AdEventType adEventType) {
        AdEvent cVar = new c(adEventType, this.e);
        for (AdEventListener onAdEvent : this.k) {
            onAdEvent.onAdEvent(cVar);
        }
    }
}
