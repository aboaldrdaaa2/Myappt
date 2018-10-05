package lip.com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.hm;
import com.google.android.gms.plus.PlusOneDummyView;

public final class g {
    private static Context aaj;
    private static c abS;

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    private static c K(Context context) throws a {
        hm.f(context);
        if (abS == null) {
            if (aaj == null) {
                aaj = GooglePlayServicesUtil.getRemoteContext(context);
                if (aaj == null) {
                    throw new a("Could not get remote context.");
                }
            }
            try {
                abS = com.google.android.gms.plus.internal.c.a.bl((IBinder) aaj.getClassLoader().loadClass("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl").newInstance());
            } catch (ClassNotFoundException e) {
                throw new a("Could not load creator class.");
            } catch (InstantiationException e2) {
                throw new a("Could not instantiate creator.");
            } catch (IllegalAccessException e3) {
                throw new a("Could not access creator.");
            }
        }
        return abS;
    }

    public static View a(Context context, int i, int i2, String str, int i3) {
        if (str != null) {
            return (View) e.e(K(context).a(e.h(context), i, i2, str, i3));
        }
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            return new PlusOneDummyView(context, i);
        }
    }
}
