package lip.com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.internal.aq.a;

public final class ah extends g<ar> {
    private static final ah lR = new ah();

    private ah() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public static aq a(Context context, al alVar, String str, bs bsVar) {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            aq b = lR.b(context, alVar, str, bsVar);
            if (b != null) {
                return b;
            }
        }
        eu.z("Using AdManager from the client jar.");
        return new u(context, alVar, str, bsVar, new ev(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, true));
    }

    private aq b(Context context, al alVar, String str, bs bsVar) {
        try {
            return a.f(((ar) G(context)).a(e.h(context), alVar, str, bsVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE));
        } catch (Throwable e) {
            eu.c("Could not create remote AdManager.", e);
            return null;
        } catch (Throwable e2) {
            eu.c("Could not create remote AdManager.", e2);
            return null;
        }
    }

    /* renamed from: c */
    protected ar d(IBinder iBinder) {
        return ar.a.g(iBinder);
    }
}
