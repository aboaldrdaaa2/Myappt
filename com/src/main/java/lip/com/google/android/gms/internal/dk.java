package lip.com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchase;

public class dk implements InAppPurchase {
    private final db pi;

    public dk(db dbVar) {
        this.pi = dbVar;
    }

    public String getProductId() {
        try {
            return this.pi.getProductId();
        } catch (Throwable e) {
            eu.c("Could not forward getProductId to InAppPurchase", e);
            return null;
        }
    }

    public void recordPlayBillingResolution(int billingResponseCode) {
        try {
            this.pi.recordPlayBillingResolution(billingResponseCode);
        } catch (Throwable e) {
            eu.c("Could not forward recordPlayBillingResolution to InAppPurchase", e);
        }
    }

    public void recordResolution(int resolution) {
        try {
            this.pi.recordResolution(resolution);
        } catch (Throwable e) {
            eu.c("Could not forward recordResolution to InAppPurchase", e);
        }
    }
}
