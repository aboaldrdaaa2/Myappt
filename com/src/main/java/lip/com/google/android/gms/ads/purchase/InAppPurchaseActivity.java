package lip.com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.internal.dd;
import com.google.android.gms.internal.di;
import com.google.android.gms.internal.eu;

public final class InAppPurchaseActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.purchase.InAppPurchaseActivity";
    public static final String SIMPLE_CLASS_NAME = "InAppPurchaseActivity";
    private dd tb;

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            if (this.tb != null) {
                this.tb.onActivityResult(requestCode, resultCode, data);
            }
        } catch (Throwable e) {
            eu.c("Could not forward onActivityResult to in-app purchase manager:", e);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.tb = di.d((Activity) this);
        if (this.tb == null) {
            eu.D("Could not create in-app purchase manager.");
            finish();
            return;
        }
        try {
            this.tb.onCreate();
        } catch (Throwable e) {
            eu.c("Could not forward onCreate to in-app purchase manager:", e);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.tb != null) {
                this.tb.onDestroy();
            }
        } catch (Throwable e) {
            eu.c("Could not forward onDestroy to in-app purchase manager:", e);
        }
        super.onDestroy();
    }
}
