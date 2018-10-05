package lip.com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.av;

public final class InterstitialAd {
    private final av ky;

    public InterstitialAd(Context context) {
        this.ky = new av(context);
    }

    public AdListener getAdListener() {
        return this.ky.getAdListener();
    }

    public String getAdUnitId() {
        return this.ky.getAdUnitId();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.ky.getInAppPurchaseListener();
    }

    public boolean isLoaded() {
        return this.ky.isLoaded();
    }

    public void loadAd(AdRequest adRequest) {
        this.ky.a(adRequest.T());
    }

    public void setAdListener(AdListener adListener) {
        this.ky.setAdListener(adListener);
    }

    public void setAdUnitId(String adUnitId) {
        this.ky.setAdUnitId(adUnitId);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        this.ky.setInAppPurchaseListener(inAppPurchaseListener);
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String publicKey) {
        this.ky.setPlayStorePurchaseParams(playStorePurchaseListener, publicKey);
    }

    public void show() {
        this.ky.show();
    }
}
