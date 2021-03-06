package lip.com.google.ads.interactivemedia.v3.api;

import com.google.ads.interactivemedia.v3.api.AdErrorEvent.AdErrorListener;
import com.google.ads.interactivemedia.v3.api.AdEvent.AdEventListener;
import java.util.List;

/* compiled from: IMASDK */
public interface AdsManager {
    void addAdErrorListener(AdErrorListener adErrorListener);

    void addAdEventListener(AdEventListener adEventListener);

    void destroy();

    List<Float> getAdCuePoints();

    Ad getCurrentAd();

    void init();

    void init(AdsRenderingSettings adsRenderingSettings);

    void removeAdErrorListener(AdErrorListener adErrorListener);

    void removeAdEventListener(AdEventListener adEventListener);

    void skip();

    void start();
}
