package lip.com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.dq.b;

public final class dp {

    public interface a {
        void a(du duVar);
    }

    public static em a(Context context, ds dsVar, a aVar) {
        return dsVar.kQ.sz ? b(context, dsVar, aVar) : c(context, dsVar, aVar);
    }

    private static em b(Context context, ds dsVar, a aVar) {
        eu.z("Fetching ad response from local ad request service.");
        em aVar2 = new com.google.android.gms.internal.dq.a(context, dsVar, aVar);
        aVar2.start();
        return aVar2;
    }

    private static em c(Context context, ds dsVar, a aVar) {
        eu.z("Fetching ad response from remote ad request service.");
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            return new b(context, dsVar, aVar);
        }
        eu.D("Failed to connect to remote ad request service.");
        return null;
    }
}
