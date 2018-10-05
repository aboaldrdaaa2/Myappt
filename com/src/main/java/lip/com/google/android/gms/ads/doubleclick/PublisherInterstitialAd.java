package lip.com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.av;

public final class PublisherInterstitialAd {
    private final av ky;

    public PublisherInterstitialAd(Context context) {
        this.ky = new av(context);
    }

    public AdListener getAdListener() {
        return this.ky.getAdListener();
    }

    public String getAdUnitId() {
        return this.ky.getAdUnitId();
    }

    public AppEventListener getAppEventListener() {
        return this.ky.getAppEventListener();
    }

    public boolean isLoaded() {
        return this.ky.isLoaded();
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        this.ky.a(publisherAdRequest.T());
    }

    public void setAdListener(AdListener adListener) {
        this.ky.setAdListener(adListener);
    }

    public void setAdUnitId(String adUnitId) {
        this.ky.setAdUnitId(adUnitId);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.ky.setAppEventListener(appEventListener);
    }

    public void show() {
        this.ky.show();
    }
}
