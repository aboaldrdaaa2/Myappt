package lip.com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class hd implements Callback {
    private static final Object Gv = new Object();
    private static hd Gw;
    private final HashMap<String, a> Gx = new HashMap();
    private final Context lz;
    private final Handler mHandler;

    final class a {
        private final HashSet<f> GA = new HashSet();
        private boolean GB;
        private IBinder GC;
        private ComponentName GD;
        private final String Gy;
        private final a Gz = new a();
        private int mState = 0;

        public class a implements ServiceConnection {
            public void onServiceConnected(ComponentName component, IBinder binder) {
                synchronized (hd.this.Gx) {
                    a.this.GC = binder;
                    a.this.GD = component;
                    Iterator it = a.this.GA.iterator();
                    while (it.hasNext()) {
                        ((f) it.next()).onServiceConnected(component, binder);
                    }
                    a.this.mState = 1;
                }
            }

            public void onServiceDisconnected(ComponentName component) {
                synchronized (hd.this.Gx) {
                    a.this.GC = null;
                    a.this.GD = component;
                    Iterator it = a.this.GA.iterator();
                    while (it.hasNext()) {
                        ((f) it.next()).onServiceDisconnected(component);
                    }
                    a.this.mState = 2;
                }
            }
        }

        public a(String str) {
            this.Gy = str;
        }

        public void B(boolean z) {
            this.GB = z;
        }

        public void a(f fVar) {
            this.GA.add(fVar);
        }

        public void b(f fVar) {
            this.GA.remove(fVar);
        }

        public boolean c(f fVar) {
            return this.GA.contains(fVar);
        }

        public a fx() {
            return this.Gz;
        }

        public String fy() {
            return this.Gy;
        }

        public boolean fz() {
            return this.GA.isEmpty();
        }

        public IBinder getBinder() {
            return this.GC;
        }

        public ComponentName getComponentName() {
            return this.GD;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.GB;
        }
    }

    private hd(Context context) {
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.lz = context.getApplicationContext();
    }

    public static hd E(Context context) {
        synchronized (Gv) {
            if (Gw == null) {
                Gw = new hd(context.getApplicationContext());
            }
        }
        return Gw;
    }

    public boolean a(String str, f fVar) {
        boolean isBound;
        synchronized (this.Gx) {
            a aVar = (a) this.Gx.get(str);
            if (aVar != null) {
                this.mHandler.removeMessages(0, aVar);
                if (!aVar.c(fVar)) {
                    aVar.a((f) fVar);
                    switch (aVar.getState()) {
                        case 1:
                            fVar.onServiceConnected(aVar.getComponentName(), aVar.getBinder());
                            break;
                        case 2:
                            aVar.B(this.lz.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), aVar.fx(), 129));
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + str);
            }
            aVar = new a(str);
            aVar.a((f) fVar);
            aVar.B(this.lz.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), aVar.fx(), 129));
            this.Gx.put(str, aVar);
            isBound = aVar.isBound();
        }
        return isBound;
    }

    public void b(String str, f fVar) {
        synchronized (this.Gx) {
            a aVar = (a) this.Gx.get(str);
            if (aVar == null) {
                throw new IllegalStateException("Nonexistent connection status for service action: " + str);
            } else if (aVar.c(fVar)) {
                aVar.b(fVar);
                if (aVar.fz()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, aVar), 5000);
                }
            } else {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + str);
            }
        }
    }

    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case 0:
                a aVar = (a) msg.obj;
                synchronized (this.Gx) {
                    if (aVar.fz()) {
                        this.lz.unbindService(aVar.fx());
                        this.Gx.remove(aVar.fy());
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
