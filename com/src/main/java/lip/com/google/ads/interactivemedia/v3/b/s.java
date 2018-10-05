package lip.com.google.ads.interactivemedia.v3.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v4.util.TimeUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdError.AdErrorCode;
import com.google.ads.interactivemedia.v3.api.AdError.AdErrorType;
import com.google.ads.interactivemedia.v3.api.AdEvent.AdEventType;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;
import com.google.ads.interactivemedia.v3.b.a.e;
import com.millennialmedia.android.MMException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;

/* compiled from: IMASDK */
public final class s implements com.google.ads.interactivemedia.v3.b.t.a {
    private static s a;
    private Map<String, b> b = new HashMap();
    private Map<String, a> c = new HashMap();
    private Map<String, c> d = new HashMap();
    private Map<String, VideoAdPlayer> e = new HashMap();
    private Map<String, AdDisplayContainer> f = new HashMap();
    private final Context g;
    private final t h;
    private u i;
    private boolean j = false;
    private Queue<r> k = new LinkedList();
    private long l = SystemClock.elapsedRealtime();

    /* compiled from: IMASDK */
    public interface a {
        void a(String str, AdErrorType adErrorType, int i, String str2);

        void a(String str, AdErrorType adErrorType, AdErrorCode adErrorCode, String str2);

        void a(String str, u uVar, List<Float> list, SortedSet<Float> sortedSet);
    }

    /* compiled from: IMASDK */
    public interface b {
        void a(AdErrorType adErrorType, int i, String str);

        void a(AdErrorType adErrorType, AdErrorCode adErrorCode, String str);

        void a(AdEventType adEventType, com.google.ads.interactivemedia.v3.b.a.a aVar);
    }

    /* compiled from: IMASDK */
    public interface c {
        void a(com.google.ads.interactivemedia.v3.b.r.c cVar, String str);
    }

    public static s a(Context context, Uri uri, ImaSdkSettings imaSdkSettings) {
        if (a == null) {
            a = new s(context, uri.buildUpon().appendQueryParameter("sdk_version", "a.3.0b2").appendQueryParameter("hl", imaSdkSettings.getLanguage()).build().toString());
        }
        return a;
    }

    private s(Context context, String str) {
        this.g = context;
        this.h = new t(context, (com.google.ads.interactivemedia.v3.b.t.a) this);
        this.h.a(str);
    }

    public final WebView a() {
        return this.h.a();
    }

    public final void a(r rVar) {
        e eVar = (e) rVar.c();
        String d = rVar.d();
        com.google.ads.interactivemedia.v3.b.r.c b = rVar.b();
        switch (rVar.a()) {
            case adsManager:
                b bVar = (b) this.b.get(d);
                if (bVar == null) {
                    Log.e("IMASDK", "Received manager message: " + b + " for invalid session id: " + d);
                    return;
                }
                com.google.ads.interactivemedia.v3.b.a.a aVar;
                if (eVar == null || eVar.adData == null) {
                    aVar = null;
                } else {
                    aVar = eVar.adData;
                }
                switch (AnonymousClass1.b[b.ordinal()]) {
                    case 7:
                        bVar.a(AdErrorType.PLAY, eVar.errorCode, a(eVar.errorMessage, eVar.innerError));
                        return;
                    case 9:
                        bVar.a(AdEventType.PAUSED, aVar);
                        return;
                    case 13:
                        return;
                    case 14:
                        if (aVar != null) {
                            bVar.a(AdEventType.LOADED, aVar);
                            return;
                        }
                        Log.e("IMASDK", "Ad loaded message requires adData");
                        bVar.a(AdErrorType.LOAD, AdErrorCode.INTERNAL_ERROR, "Ad loaded message did not contain adData.");
                        return;
                    case 15:
                        bVar.a(AdEventType.CONTENT_PAUSE_REQUESTED, null);
                        return;
                    case 16:
                        bVar.a(AdEventType.CONTENT_RESUME_REQUESTED, null);
                        return;
                    case 17:
                        bVar.a(AdEventType.COMPLETED, aVar);
                        return;
                    case 18:
                        bVar.a(AdEventType.ALL_ADS_COMPLETED, null);
                        return;
                    case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                        bVar.a(AdEventType.SKIPPED, aVar);
                        return;
                    case MMException.DISPLAY_AD_NOT_READY /*20*/:
                        bVar.a(AdEventType.STARTED, aVar);
                        return;
                    case MMException.DISPLAY_AD_EXPIRED /*21*/:
                        bVar.a(AdEventType.RESUMED, aVar);
                        return;
                    case MMException.DISPLAY_AD_NOT_FOUND /*22*/:
                        bVar.a(AdEventType.FIRST_QUARTILE, aVar);
                        return;
                    case MMException.DISPLAY_AD_ALREADY_DISPLAYED /*23*/:
                        bVar.a(AdEventType.MIDPOINT, aVar);
                        return;
                    case MMException.DISPLAY_AD_NOT_PERMITTED /*24*/:
                        bVar.a(AdEventType.THIRD_QUARTILE, aVar);
                        return;
                    case MMException.AD_BROKEN_REFERENCE /*25*/:
                        bVar.a(AdEventType.CLICKED, aVar);
                        return;
                    default:
                        throw new IllegalArgumentException("Illegal message type " + b + " received for manager channel");
                }
            case videoDisplay:
                VideoAdPlayer videoAdPlayer = (VideoAdPlayer) this.e.get(d);
                if (videoAdPlayer == null) {
                    Log.e("IMASDK", "Received player message: " + b + " for invalid session id: " + d);
                    return;
                }
                switch (b) {
                    case play:
                        if (!(eVar == null || eVar.videoUrl == null)) {
                            videoAdPlayer.loadAd(eVar.videoUrl);
                        }
                        videoAdPlayer.playAd();
                        return;
                    case pause:
                        videoAdPlayer.pauseAd();
                        return;
                    case load:
                        if (eVar == null || eVar.videoUrl == null) {
                            Log.e("IMASDK", "Load message must contain video url");
                            b bVar2 = (b) this.b.get(d);
                            if (bVar2 != null) {
                                bVar2.a(AdErrorType.LOAD, AdErrorCode.INTERNAL_ERROR, "Loading message did not contain a video url.");
                                return;
                            }
                            return;
                        }
                        videoAdPlayer.loadAd(eVar.videoUrl);
                        return;
                    case startTracking:
                    case stopTracking:
                        return;
                    default:
                        throw new IllegalArgumentException("Illegal message type " + b + " received for player channel");
                }
            case adsLoader:
                a aVar2 = (a) this.c.get(d);
                if (aVar2 == null) {
                    Log.e("IMASDK", "Received request message: " + b + " for invalid session id: " + d);
                    return;
                }
                switch (b) {
                    case adsLoaded:
                        if (eVar == null) {
                            aVar2.a(d, AdErrorType.LOAD, AdErrorCode.INTERNAL_ERROR, "adsLoaded message did not contain cue points.");
                            return;
                        } else {
                            aVar2.a(d, this.i, eVar.adCuePoints, eVar.internalCuePoints);
                            return;
                        }
                    case error:
                        aVar2.a(d, AdErrorType.LOAD, eVar.errorCode, a(eVar.errorMessage, eVar.innerError));
                        return;
                    default:
                        throw new IllegalArgumentException("Illegal message type " + b + " received for request channel");
                }
            case displayContainer:
                a(b, d, eVar);
                return;
            case i18n:
                c cVar = (c) this.d.get(d);
                if (cVar != null) {
                    cVar.a(b, eVar.translation);
                    return;
                }
                return;
            case webViewLoaded:
            case log:
                switch (b) {
                    case initialized:
                        com.google.ads.interactivemedia.v3.b.r.a aVar3 = com.google.ads.interactivemedia.v3.b.r.a.nativeUi;
                        try {
                            if (eVar.adUiStyle != null) {
                                aVar3 = com.google.ads.interactivemedia.v3.b.r.a.valueOf(eVar.adUiStyle);
                            }
                        } catch (IllegalArgumentException e) {
                        }
                        this.i = new u(eVar.adTimeUpdateMs, aVar3);
                        this.j = true;
                        long elapsedRealtime = SystemClock.elapsedRealtime() - this.l;
                        Map hashMap = new HashMap();
                        hashMap.put("webViewLoadingTime", Long.valueOf(elapsedRealtime));
                        b(new r(com.google.ads.interactivemedia.v3.b.r.b.webViewLoaded, com.google.ads.interactivemedia.v3.b.r.c.csi, d, hashMap));
                        b();
                        return;
                    case log:
                        if (eVar.ln == null || eVar.n == null || eVar.m == null) {
                            Log.e("IMASDK", "Invalid logging message data: " + eVar);
                            return;
                        }
                        String str = "SDK_LOG:" + eVar.n;
                        switch (eVar.ln.charAt(0)) {
                            case 'D':
                                Log.d(str, eVar.m);
                                return;
                            case 'E':
                            case 'S':
                                Log.e(str, eVar.m);
                                return;
                            case 'I':
                                Log.i(str, eVar.m);
                                return;
                            case 'V':
                                Log.v(str, eVar.m);
                                return;
                            case 'W':
                                Log.w(str, eVar.m);
                                return;
                            default:
                                Log.w("IMASDK", "Unrecognized log level: " + eVar.ln);
                                Log.w(str, eVar.m);
                                return;
                        }
                    default:
                        throw new IllegalArgumentException("Illegal message type " + b + " received for other channel");
                }
            default:
                Log.e("IMASDK", "Unknown message channel: " + rVar.a());
                return;
        }
    }

    private void a(com.google.ads.interactivemedia.v3.b.r.c cVar, String str, e eVar) {
        a aVar = (a) this.f.get(str);
        b bVar = (b) this.b.get(str);
        if (aVar == null || bVar == null) {
            Log.e("IMASDK", "Received displayContainer message: " + cVar + " for invalid session id: " + str);
            return;
        }
        switch (cVar) {
            case displayCompanions:
                if (eVar == null || eVar.companions == null) {
                    bVar.a(AdErrorType.LOAD, AdErrorCode.INTERNAL_ERROR, "Display companions message requires companions in data.");
                    return;
                }
                Map a = a(aVar, eVar.companions.keySet());
                if (a == null) {
                    bVar.a(AdErrorType.LOAD, AdErrorCode.INTERNAL_ERROR, "Display requested for invalid companion slot.");
                    return;
                }
                for (String str2 : a.keySet()) {
                    ViewGroup viewGroup = (ViewGroup) a.get(str2);
                    com.google.ads.interactivemedia.v3.b.a.c cVar2 = (com.google.ads.interactivemedia.v3.b.a.c) eVar.companions.get(str2);
                    viewGroup.removeAllViews();
                    View view = null;
                    switch (cVar2.type) {
                        case Html:
                        case IFrame:
                            view = new l(viewGroup.getContext(), this, cVar2);
                            break;
                        case Static:
                            view = new q(viewGroup.getContext(), this, cVar2, str);
                            break;
                        default:
                            break;
                    }
                    viewGroup.addView(view);
                }
                return;
            case showVideo:
            case hide:
                return;
            default:
                throw new IllegalArgumentException("Illegal message type " + cVar + " received for displayContainer channel");
        }
    }

    private static Map<String, ViewGroup> a(a aVar, Set<String> set) {
        Map<String, ViewGroup> hashMap = new HashMap(set.size());
        for (String str : set) {
            CompanionAdSlot companionAdSlot = (CompanionAdSlot) aVar.a().get(str);
            if (companionAdSlot.getContainer() == null) {
                return null;
            }
            hashMap.put(str, companionAdSlot.getContainer());
        }
        return hashMap;
    }

    private static String a(String str, String str2) {
        return (str2 == null || str2.length() == 0) ? str : str + " Caused by: " + str2;
    }

    public final void a(a aVar, String str) {
        this.c.put(str, aVar);
    }

    public final void a(b bVar, String str) {
        this.b.put(str, bVar);
    }

    public final void a(c cVar, String str) {
        this.d.put(str, cVar);
    }

    public final void a(String str) {
        this.d.remove(str);
    }

    public final void a(VideoAdPlayer videoAdPlayer, String str) {
        this.e.put(str, videoAdPlayer);
    }

    public final void a(AdDisplayContainer adDisplayContainer, String str) {
        this.f.put(str, adDisplayContainer);
    }

    public final void b(r rVar) {
        this.k.add(rVar);
        b();
    }

    private void b() {
        while (this.j && !this.k.isEmpty()) {
            this.h.a((r) this.k.remove());
        }
    }

    public final void b(String str) {
        this.g.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }
}
