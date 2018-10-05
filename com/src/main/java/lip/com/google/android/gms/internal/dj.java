package lip.com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.ads.purchase.InAppPurchaseResult;

public class dj implements InAppPurchaseResult {
    private final df pw;

    public dj(df dfVar) {
        this.pw = dfVar;
    }

    public void finishPurchase() {
        try {
            this.pw.finishPurchase();
        } catch (Throwable e) {
            eu.c("Could not forward finishPurchase to InAppPurchaseResult", e);
        }
    }

    public String getProductId() {
        try {
            return this.pw.getProductId();
        } catch (Throwable e) {
            eu.c("Could not forward getProductId to InAppPurchaseResult", e);
            return null;
        }
    }

    public Intent getPurchaseData() {
        try {
            return this.pw.getPurchaseData();
        } catch (Throwable e) {
            eu.c("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return null;
        }
    }

    public int getResultCode() {
        try {
            return this.pw.getResultCode();
        } catch (Throwable e) {
            eu.c("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return 0;
        }
    }

    public boolean isVerified() {
        try {
            return this.pw.isVerified();
        } catch (Throwable e) {
            eu.c("Could not forward isVerified to InAppPurchaseResult", e);
            return false;
        }
    }
}
