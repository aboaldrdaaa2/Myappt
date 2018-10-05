package lip.com.google.ads.interactivemedia.v3.api;

import android.content.Context;
import android.net.Uri;
import com.google.ads.interactivemedia.v3.b.a;
import com.google.ads.interactivemedia.v3.b.e;
import com.google.ads.interactivemedia.v3.b.i;
import com.google.ads.interactivemedia.v3.b.j;
import com.google.ads.interactivemedia.v3.b.k;
import com.google.ads.interactivemedia.v3.b.p;

/* compiled from: IMASDK */
public class ImaSdkFactory {
    private static ImaSdkFactory instance;

    private ImaSdkFactory() {
    }

    public static ImaSdkFactory getInstance() {
        if (instance == null) {
            instance = new ImaSdkFactory();
        }
        return instance;
    }

    public ImaSdkSettings createImaSdkSettings() {
        return new ImaSdkSettings();
    }

    public AdsLoader createAdsLoader(Context context) {
        return createAdsLoader(context, createImaSdkSettings());
    }

    public AdsLoader createAdsLoader(Context context, ImaSdkSettings settings) {
        return new e(context, p.a, settings);
    }

    private AdsLoader createAdsLoader(Context context, Uri jsCoreUrl, ImaSdkSettings settings) {
        return new e(context, jsCoreUrl, settings);
    }

    public AdDisplayContainer createAdDisplayContainer() {
        return new a();
    }

    public AdsRenderingSettings createAdsRenderingSettings() {
        return new i();
    }

    public AdsRequest createAdsRequest() {
        return new j();
    }

    public CompanionAdSlot createCompanionAdSlot() {
        return new k();
    }
}
