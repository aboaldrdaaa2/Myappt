package lip.com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.hm;
import com.google.android.gms.maps.internal.c.a;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class u {
    private static Context aaj;
    private static c aak;

    public static c H(Context context) throws GooglePlayServicesNotAvailableException {
        hm.f(context);
        if (aak != null) {
            return aak;
        }
        I(context);
        aak = J(context);
        try {
            aak.a(e.h(getRemoteContext(context).getResources()), (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            return aak;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    private static void I(Context context) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        switch (isGooglePlayServicesAvailable) {
            case 0:
                return;
            default:
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
    }

    private static c J(Context context) {
        if (jJ()) {
            Log.i(u.class.getSimpleName(), "Making Creator statically");
            return (c) c(jK());
        }
        Log.i(u.class.getSimpleName(), "Making Creator dynamically");
        return a.ax((IBinder) a(getRemoteContext(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
    }

    private static <T> T a(ClassLoader classLoader, String str) {
        try {
            return c(((ClassLoader) hm.f(classLoader)).loadClass(str));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Unable to find dynamic class " + str);
        }
    }

    private static <T> T c(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalStateException("Unable to instantiate the dynamic class " + cls.getName());
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unable to call the default constructor of " + cls.getName());
        }
    }

    private static Context getRemoteContext(Context context) {
        if (aaj == null) {
            if (jJ()) {
                aaj = context.getApplicationContext();
            } else {
                aaj = GooglePlayServicesUtil.getRemoteContext(context);
            }
        }
        return aaj;
    }

    private static boolean jJ() {
        return false;
    }

    private static Class<?> jK() {
        try {
            return VERSION.SDK_INT < 15 ? Class.forName("com.google.android.gms.maps.internal.CreatorImplGmm6") : Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
