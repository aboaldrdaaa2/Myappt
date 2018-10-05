package lip.com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.dc.a;

public final class dh extends a {
    private final InAppPurchaseListener mB;

    public dh(InAppPurchaseListener inAppPurchaseListener) {
        this.mB = inAppPurchaseListener;
    }

    public void a(db dbVar) {
        this.mB.onInAppPurchaseRequested(new dk(dbVar));
    }
}
