package lip.com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;

public final class di extends g<de> {
    private static final di pv = new di();

    private static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    private di() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    private static boolean b(Activity activity) throws a {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
        }
        throw new a("InAppPurchaseManager requires the useClientJar flag in intent extras.");
    }

    public static dd d(Activity activity) {
        try {
            if (!b(activity)) {
                return pv.e(activity);
            }
            eu.z("Using AdOverlay from the client jar.");
            return new cu(activity);
        } catch (a e) {
            eu.D(e.getMessage());
            return null;
        }
    }

    private dd e(Activity activity) {
        try {
            return com.google.android.gms.internal.dd.a.r(((de) G(activity)).b(e.h(activity)));
        } catch (Throwable e) {
            eu.c("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (Throwable e2) {
            eu.c("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }

    /* renamed from: v */
    protected de d(IBinder iBinder) {
        return com.google.android.gms.internal.de.a.s(iBinder);
    }
}
