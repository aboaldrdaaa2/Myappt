package lip.com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;

public final class cm extends g<co> {
    private static final cm oS = new cm();

    private static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    private cm() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static cn a(Activity activity) {
        try {
            if (!b(activity)) {
                return oS.c(activity);
            }
            eu.z("Using AdOverlay from the client jar.");
            return new cf(activity);
        } catch (a e) {
            eu.D(e.getMessage());
            return null;
        }
    }

    private static boolean b(Activity activity) throws a {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        throw new a("Ad overlay requires the useClientJar flag in intent extras.");
    }

    private cn c(Activity activity) {
        try {
            return com.google.android.gms.internal.cn.a.m(((co) G(activity)).a(e.h(activity)));
        } catch (Throwable e) {
            eu.c("Could not create remote AdOverlay.", e);
            return null;
        } catch (Throwable e2) {
            eu.c("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    /* renamed from: l */
    protected co d(IBinder iBinder) {
        return com.google.android.gms.internal.co.a.n(iBinder);
    }
}
