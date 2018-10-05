package lip.com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.hm;

public abstract class g<T> {
    private final String Ml;
    private T Mm;

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th) {
            super(str, th);
        }
    }

    protected g(String str) {
        this.Ml = str;
    }

    protected final T G(Context context) throws a {
        if (this.Mm == null) {
            hm.f(context);
            Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
            if (remoteContext == null) {
                throw new a("Could not get remote context.");
            }
            try {
                this.Mm = d((IBinder) remoteContext.getClassLoader().loadClass(this.Ml).newInstance());
            } catch (ClassNotFoundException e) {
                throw new a("Could not load creator class.");
            } catch (InstantiationException e2) {
                throw new a("Could not instantiate creator.");
            } catch (IllegalAccessException e3) {
                throw new a("Could not access creator.");
            }
        }
        return this.Mm;
    }

    protected abstract T d(IBinder iBinder);
}
