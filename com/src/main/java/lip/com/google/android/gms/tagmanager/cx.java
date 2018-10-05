package lip.com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class cx extends cw {
    private static cx ahU;
    private static final Object tT = new Object();
    private Context ahK;
    private at ahL;
    private volatile ar ahM;
    private int ahN = 1800000;
    private boolean ahO = true;
    private boolean ahP = false;
    private boolean ahQ = true;
    private au ahR = new au() {
        public void s(boolean z) {
            cx.this.a(z, cx.this.connected);
        }
    };
    private bn ahS;
    private boolean ahT = false;
    private boolean connected = true;
    private Handler handler;

    private cx() {
    }

    private void cF() {
        this.ahS = new bn(this);
        this.ahS.v(this.ahK);
    }

    private void cG() {
        this.handler = new Handler(this.ahK.getMainLooper(), new Callback() {
            public boolean handleMessage(Message msg) {
                if (1 == msg.what && cx.tT.equals(msg.obj)) {
                    cx.this.cq();
                    if (cx.this.ahN > 0 && !cx.this.ahT) {
                        cx.this.handler.sendMessageDelayed(cx.this.handler.obtainMessage(1, cx.tT), (long) cx.this.ahN);
                    }
                }
                return true;
            }
        });
        if (this.ahN > 0) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(1, tT), (long) this.ahN);
        }
    }

    public static cx mQ() {
        if (ahU == null) {
            ahU = new cx();
        }
        return ahU;
    }

    synchronized void a(Context context, ar arVar) {
        if (this.ahK == null) {
            this.ahK = context.getApplicationContext();
            if (this.ahM == null) {
                this.ahM = arVar;
            }
        }
    }

    synchronized void a(boolean z, boolean z2) {
        if (!(this.ahT == z && this.connected == z2)) {
            if (z || !z2) {
                if (this.ahN > 0) {
                    this.handler.removeMessages(1, tT);
                }
            }
            if (!z && z2 && this.ahN > 0) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(1, tT), (long) this.ahN);
            }
            StringBuilder append = new StringBuilder().append("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            bh.C(append.append(str).toString());
            this.ahT = z;
            this.connected = z2;
        }
    }

    synchronized void cI() {
        if (!this.ahT && this.connected && this.ahN > 0) {
            this.handler.removeMessages(1, tT);
            this.handler.sendMessage(this.handler.obtainMessage(1, tT));
        }
    }

    public synchronized void cq() {
        if (this.ahP) {
            this.ahM.a(new Runnable() {
                public void run() {
                    cx.this.ahL.cq();
                }
            });
        } else {
            bh.C("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.ahO = true;
        }
    }

    synchronized at mR() {
        if (this.ahL == null) {
            if (this.ahK == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.ahL = new ca(this.ahR, this.ahK);
        }
        if (this.handler == null) {
            cG();
        }
        this.ahP = true;
        if (this.ahO) {
            cq();
            this.ahO = false;
        }
        if (this.ahS == null && this.ahQ) {
            cF();
        }
        return this.ahL;
    }

    synchronized void t(boolean z) {
        a(this.ahT, z);
    }
}
