package lip.com.google.android.gms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.fd;
import com.google.android.gms.internal.fe;
import java.util.List;
import java.util.Map;

class c implements b {
    private Context mContext;
    private fe tA;
    private ServiceConnection tx;
    private b ty;
    private c tz;

    final class a implements ServiceConnection {
        a() {
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            aa.C("service connected, binder: " + binder);
            try {
                if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(binder.getInterfaceDescriptor())) {
                    aa.C("bound to service");
                    c.this.tA = com.google.android.gms.internal.fe.a.z(binder);
                    c.this.co();
                    return;
                }
            } catch (RemoteException e) {
            }
            c.this.mContext.unbindService(this);
            c.this.tx = null;
            c.this.tz.a(2, null);
        }

        public void onServiceDisconnected(ComponentName component) {
            aa.C("service disconnected: " + component);
            c.this.tx = null;
            c.this.ty.onDisconnected();
        }
    }

    public interface b {
        void onConnected();

        void onDisconnected();
    }

    public interface c {
        void a(int i, Intent intent);
    }

    public c(Context context, b bVar, c cVar) {
        this.mContext = context;
        if (bVar == null) {
            throw new IllegalArgumentException("onConnectedListener cannot be null");
        }
        this.ty = bVar;
        if (cVar == null) {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
        }
        this.tz = cVar;
    }

    private fe cm() {
        cn();
        return this.tA;
    }

    private void co() {
        cp();
    }

    private void cp() {
        this.ty.onConnected();
    }

    public void a(Map<String, String> map, long j, String str, List<fd> list) {
        try {
            cm().a(map, j, str, list);
        } catch (RemoteException e) {
            aa.A("sendHit failed: " + e);
        }
    }

    public void cl() {
        try {
            cm().cl();
        } catch (RemoteException e) {
            aa.A("clear hits failed: " + e);
        }
    }

    protected void cn() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect() {
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.analytics.service.AnalyticsService"));
        intent.putExtra("app_package_name", this.mContext.getPackageName());
        if (this.tx != null) {
            aa.A("Calling connect() while still connected, missing disconnect().");
            return;
        }
        this.tx = new a();
        boolean bindService = this.mContext.bindService(intent, this.tx, 129);
        aa.C("connect: bindService returned " + bindService + " for " + intent);
        if (!bindService) {
            this.tx = null;
            this.tz.a(1, null);
        }
    }

    public void disconnect() {
        this.tA = null;
        if (this.tx != null) {
            try {
                this.mContext.unbindService(this.tx);
            } catch (IllegalStateException e) {
            } catch (IllegalArgumentException e2) {
            }
            this.tx = null;
            this.ty.onDisconnected();
        }
    }

    public boolean isConnected() {
        return this.tA != null;
    }
}
