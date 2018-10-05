package lip.com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.dg.a;

public final class dl extends a {
    private final PlayStorePurchaseListener mC;

    public dl(PlayStorePurchaseListener playStorePurchaseListener) {
        this.mC = playStorePurchaseListener;
    }

    public void a(df dfVar) {
        this.mC.onInAppPurchaseFinished(new dj(dfVar));
    }

    public boolean isValidPurchase(String productId) {
        return this.mC.isValidPurchase(productId);
    }
}
