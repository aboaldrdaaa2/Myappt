package lip.com.google.android.gms.internal;

import android.content.Context;

public final class dm {

    public interface a {
        void a(ef efVar);
    }

    public static em a(Context context, com.google.android.gms.internal.ds.a aVar, k kVar, ex exVar, bt btVar, a aVar2) {
        em dnVar = new dn(context, aVar, kVar, exVar, btVar, aVar2);
        dnVar.start();
        return dnVar;
    }
}
