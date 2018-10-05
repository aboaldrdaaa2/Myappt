package lip.com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import java.util.HashMap;

public class jf {
    private final jj<je> VJ;
    private ContentProviderClient VK = null;
    private boolean VL = false;
    private HashMap<LocationListener, b> VM = new HashMap();
    private final Context mContext;

    private static class a extends Handler {
        private final LocationListener VN;

        public a(LocationListener locationListener) {
            this.VN = locationListener;
        }

        public a(LocationListener locationListener, Looper looper) {
            super(looper);
            this.VN = locationListener;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    this.VN.onLocationChanged(new Location((Location) msg.obj));
                    return;
                default:
                    Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
                    return;
            }
        }
    }

    private static class b extends com.google.android.gms.location.a.a {
        private Handler VO;

        b(LocationListener locationListener, Looper looper) {
            this.VO = looper == null ? new a(locationListener) : new a(locationListener, looper);
        }

        public void onLocationChanged(Location location) {
            if (this.VO == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = location;
            this.VO.sendMessage(obtain);
        }

        public void release() {
            this.VO = null;
        }
    }

    public jf(Context context, jj<je> jjVar) {
        this.mContext = context;
        this.VJ = jjVar;
    }

    public Location getLastLocation() {
        this.VJ.cn();
        try {
            return ((je) this.VJ.ft()).bo(this.mContext.getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void iY() {
        if (this.VL) {
            try {
                setMockMode(false);
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public void removeAllListeners() {
        try {
            synchronized (this.VM) {
                for (com.google.android.gms.location.a aVar : this.VM.values()) {
                    if (aVar != null) {
                        ((je) this.VJ.ft()).a(aVar);
                    }
                }
                this.VM.clear();
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(PendingIntent callbackIntent) throws RemoteException {
        this.VJ.cn();
        ((je) this.VJ.ft()).a(callbackIntent);
    }

    public void removeLocationUpdates(LocationListener listener) throws RemoteException {
        this.VJ.cn();
        hm.b((Object) listener, (Object) "Invalid null listener");
        synchronized (this.VM) {
            com.google.android.gms.location.a aVar = (b) this.VM.remove(listener);
            if (this.VK != null && this.VM.isEmpty()) {
                this.VK.release();
                this.VK = null;
            }
            if (aVar != null) {
                aVar.release();
                ((je) this.VJ.ft()).a(aVar);
            }
        }
    }

    public void requestLocationUpdates(LocationRequest request, PendingIntent callbackIntent) throws RemoteException {
        this.VJ.cn();
        ((je) this.VJ.ft()).a(request, callbackIntent);
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener, Looper looper) throws RemoteException {
        this.VJ.cn();
        if (looper == null) {
            hm.b(Looper.myLooper(), (Object) "Can't create handler inside thread that has not called Looper.prepare()");
        }
        synchronized (this.VM) {
            com.google.android.gms.location.a bVar;
            b bVar2 = (b) this.VM.get(listener);
            if (bVar2 == null) {
                bVar = new b(listener, looper);
            } else {
                Object bVar3 = bVar2;
            }
            this.VM.put(listener, bVar3);
            ((je) this.VJ.ft()).a(request, bVar3, this.mContext.getPackageName());
        }
    }

    public void setMockLocation(Location mockLocation) throws RemoteException {
        this.VJ.cn();
        ((je) this.VJ.ft()).setMockLocation(mockLocation);
    }

    public void setMockMode(boolean isMockMode) throws RemoteException {
        this.VJ.cn();
        ((je) this.VJ.ft()).setMockMode(isMockMode);
        this.VL = isMockMode;
    }
}
