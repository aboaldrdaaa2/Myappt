package lip.com.google.android.gms.analytics;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.google.android.gms.analytics.u.a;

class r extends af {
    private static final Object tT = new Object();
    private static r uf;
    private Context mContext;
    private Handler mHandler;
    private d tU;
    private volatile f tV;
    private int tW = 1800;
    private boolean tX = true;
    private boolean tY;
    private String tZ;
    private boolean ua = true;
    private boolean ub = true;
    private e uc = new e() {
        public void s(boolean z) {
            r.this.a(z, r.this.ua);
        }
    };
    private q ud;
    private boolean ue = false;

    private r() {
    }

    public static r cE() {
        if (uf == null) {
            uf = new r();
        }
        return uf;
    }

    private void cF() {
        this.ud = new q(this);
        this.ud.v(this.mContext);
    }

    private void cG() {
        this.mHandler = new Handler(this.mContext.getMainLooper(), new Callback() {
            public boolean handleMessage(Message msg) {
                if (1 == msg.what && r.tT.equals(msg.obj)) {
                    u.cU().u(true);
                    r.this.dispatchLocalHits();
                    u.cU().u(false);
                    if (r.this.tW > 0 && !r.this.ue) {
                        r.this.mHandler.sendMessageDelayed(r.this.mHandler.obtainMessage(1, r.tT), (long) (r.this.tW * 1000));
                    }
                }
                return true;
            }
        });
        if (this.tW > 0) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, tT), (long) (this.tW * 1000));
        }
    }

    synchronized void a(Context context, f fVar) {
        if (this.mContext == null) {
            this.mContext = context.getApplicationContext();
            if (this.tV == null) {
                this.tV = fVar;
                if (this.tX) {
                    dispatchLocalHits();
                    this.tX = false;
                }
                if (this.tY) {
                    cs();
                    this.tY = false;
                }
            }
        }
    }

    synchronized void a(boolean z, boolean z2) {
        if (!(this.ue == z && this.ua == z2)) {
            if (z || !z2) {
                if (this.tW > 0) {
                    this.mHandler.removeMessages(1, tT);
                }
            }
            if (!z && z2 && this.tW > 0) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, tT), (long) (this.tW * 1000));
            }
            StringBuilder append = new StringBuilder().append("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            aa.C(append.append(str).toString());
            this.ue = z;
            this.ua = z2;
        }
    }

    synchronized d cH() {
        if (this.tU == null) {
            if (this.mContext == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.tU = new ac(this.uc, this.mContext);
            if (this.tZ != null) {
                this.tU.cr().M(this.tZ);
                this.tZ = null;
            }
        }
        if (this.mHandler == null) {
            cG();
        }
        if (this.ud == null && this.ub) {
            cF();
        }
        return this.tU;
    }

    synchronized void cI() {
        if (!this.ue && this.ua && this.tW > 0) {
            this.mHandler.removeMessages(1, tT);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, tT));
        }
    }

    void cs() {
        if (this.tV == null) {
            aa.C("setForceLocalDispatch() queued. It will be called once initialization is complete.");
            this.tY = true;
            return;
        }
        u.cU().a(a.SET_FORCE_LOCAL_DISPATCH);
        this.tV.cs();
    }

    synchronized void dispatchLocalHits() {
        if (this.tV == null) {
            aa.C("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.tX = true;
        } else {
            u.cU().a(a.DISPATCH);
            this.tV.cq();
        }
    }

    synchronized void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
        if (this.mHandler == null) {
            aa.C("Dispatch period set with null handler. Dispatch will run once initialization is complete.");
            this.tW = dispatchPeriodInSeconds;
        } else {
            u.cU().a(a.SET_DISPATCH_PERIOD);
            if (!this.ue && this.ua && this.tW > 0) {
                this.mHandler.removeMessages(1, tT);
            }
            this.tW = dispatchPeriodInSeconds;
            if (dispatchPeriodInSeconds > 0 && !this.ue && this.ua) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, tT), (long) (dispatchPeriodInSeconds * 1000));
            }
        }
    }

    synchronized void t(boolean z) {
        a(this.ue, z);
    }
}
