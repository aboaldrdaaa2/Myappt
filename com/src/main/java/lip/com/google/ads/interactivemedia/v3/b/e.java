package lip.com.google.ads.interactivemedia.v3.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Log;
import com.google.a.a.f;
import com.google.a.a.g;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdError.AdErrorCode;
import com.google.ads.interactivemedia.v3.api.AdError.AdErrorType;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent.AdErrorListener;
import com.google.ads.interactivemedia.v3.api.AdsLoader;
import com.google.ads.interactivemedia.v3.api.AdsLoader.AdsLoadedListener;
import com.google.ads.interactivemedia.v3.api.AdsManagerLoadedEvent;
import com.google.ads.interactivemedia.v3.api.AdsRequest;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.b.a.d;
import com.google.ads.interactivemedia.v3.b.r.b;
import com.google.ads.interactivemedia.v3.b.r.c;
import com.google.ads.interactivemedia.v3.b.s.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.SortedSet;

/* compiled from: IMASDK */
public final class e implements AdsLoader {
    private final s a;
    private final Context b;
    private final o c;
    private final List<AdsLoadedListener> d;
    private final Map<String, AdsRequest> e;
    private f f;
    private ImaSdkSettings g;

    public e(Context context, Uri uri, ImaSdkSettings imaSdkSettings) {
        this(s.a(context, uri, imaSdkSettings), context);
        this.g = imaSdkSettings;
    }

    private e(s sVar, Context context) {
        this.c = new o();
        this.d = new ArrayList(1);
        this.e = new HashMap();
        this.g = new ImaSdkSettings();
        this.a = sVar;
        this.b = context;
        this.f = new f("a.3.0b2", context);
    }

    public final void contentComplete() {
        this.a.b(new r(b.adsLoader, c.contentComplete, "*"));
    }

    public final void requestAds(AdsRequest adsRequest) {
        int i;
        String str = "ima_sid_" + Integer.valueOf(new Random().nextInt(1000000000)).toString();
        if (adsRequest == null) {
            this.c.a(new b(new AdError(AdErrorType.LOAD, AdErrorCode.INVALID_ARGUMENTS, "AdsRequest cannot be null.")));
            i = 0;
        } else {
            AdDisplayContainer adDisplayContainer = adsRequest.getAdDisplayContainer();
            if (adDisplayContainer == null) {
                this.c.a(new b(new AdError(AdErrorType.LOAD, AdErrorCode.INVALID_ARGUMENTS, "Ad display container must be provided in the AdsRequest.")));
                i = 0;
            } else if (adDisplayContainer.getAdContainer() == null) {
                this.c.a(new b(new AdError(AdErrorType.LOAD, AdErrorCode.INVALID_ARGUMENTS, "Ad display container must have a UI container.")));
                i = 0;
            } else if (adsRequest.getAdTagUrl() == null || adsRequest.getAdTagUrl().length() == 0) {
                this.c.a(new b(new AdError(AdErrorType.LOAD, AdErrorCode.INVALID_ARGUMENTS, "Ad tag url must non-null and non empty.")));
                i = 0;
            } else {
                i = 1;
            }
        }
        if (i != 0) {
            this.e.put(str, adsRequest);
            this.a.a(new a() {
                public final void a(String str, u uVar, List<Float> list, SortedSet<Float> sortedSet) {
                    AdsRequest adsRequest = (AdsRequest) e.this.e.get(str);
                    v vVar = new v(adsRequest.getAdDisplayContainer().getPlayer(), uVar.a());
                    e.this.a(new g(new f(str, e.this.a, uVar, adsRequest.getAdDisplayContainer(), list, sortedSet, vVar, e.this.b), adsRequest.getUserRequestContext()));
                }

                public final void a(String str, AdErrorType adErrorType, int i, String str2) {
                    e.this.c.a(new b(new AdError(adErrorType, i, str2), ((AdsRequest) e.this.e.get(str)).getUserRequestContext()));
                }

                public final void a(String str, AdErrorType adErrorType, AdErrorCode adErrorCode, String str2) {
                    e.this.c.a(new b(new AdError(adErrorType, adErrorCode, str2), ((AdsRequest) e.this.e.get(str)).getUserRequestContext()));
                }
            }, str);
            this.a.a(adsRequest.getAdDisplayContainer(), str);
            String adTagUrl = adsRequest.getAdTagUrl();
            try {
                if (!(this.f == null || adTagUrl == null)) {
                    Uri parse = Uri.parse(adTagUrl);
                    if (this.f.a(parse)) {
                        adsRequest.setAdTagUrl(this.f.a(parse, this.b).toString());
                    }
                }
            } catch (g e) {
            }
            String format = String.format("android%s:%s:%s", new Object[]{VERSION.RELEASE, "3.0b2", this.b.getPackageName()});
            if (this.b.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
                Log.w("IMASDK", "Host application doesn't have ACCESS_NETWORK_STATE permission");
                adTagUrl = "android:0";
            } else {
                if (((ConnectivityManager) this.b.getSystemService("connectivity")).getActiveNetworkInfo() == null) {
                    adTagUrl = "android:0";
                } else {
                    adTagUrl = String.format("android:%d:%d", new Object[]{Integer.valueOf(((ConnectivityManager) this.b.getSystemService("connectivity")).getActiveNetworkInfo().getType()), Integer.valueOf(((ConnectivityManager) this.b.getSystemService("connectivity")).getActiveNetworkInfo().getSubtype())});
                }
            }
            this.a.b(new r(b.adsLoader, c.requestAds, str, new d(adsRequest, format, adTagUrl, this.g)));
        }
    }

    public final ImaSdkSettings getSettings() {
        return this.g;
    }

    public final void addAdsLoadedListener(AdsLoadedListener loadedListener) {
        this.d.add(loadedListener);
    }

    public final void removeAdsLoadedListener(AdsLoadedListener loadedListener) {
        this.d.remove(loadedListener);
    }

    public final void addAdErrorListener(AdErrorListener errorListener) {
        this.c.a(errorListener);
    }

    public final void removeAdErrorListener(AdErrorListener errorListener) {
        this.c.b(errorListener);
    }

    final void a(AdsManagerLoadedEvent adsManagerLoadedEvent) {
        for (AdsLoadedListener onAdsManagerLoaded : this.d) {
            onAdsManagerLoaded.onAdsManagerLoaded(adsManagerLoadedEvent);
        }
    }
}
