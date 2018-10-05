package lip.com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tagmanager.ContainerHolder.ContainerAvailableListener;

class n implements ContainerHolder {
    private final Looper DF;
    private boolean Ip;
    private Container aeB;
    private Container aeC;
    private b aeD;
    private a aeE;
    private TagManager aeF;
    private Status yz;

    public interface a {
        void bJ(String str);

        String lo();

        void lq();
    }

    private class b extends Handler {
        private final ContainerAvailableListener aeG;

        public b(ContainerAvailableListener containerAvailableListener, Looper looper) {
            super(looper);
            this.aeG = containerAvailableListener;
        }

        public void bK(String str) {
            sendMessage(obtainMessage(1, str));
        }

        protected void bL(String str) {
            this.aeG.onContainerAvailable(n.this, str);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    bL((String) msg.obj);
                    return;
                default:
                    bh.A("Don't know how to handle this message.");
                    return;
            }
        }
    }

    public n(Status status) {
        this.yz = status;
        this.DF = null;
    }

    public n(TagManager tagManager, Looper looper, Container container, a aVar) {
        this.aeF = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.DF = looper;
        this.aeB = container;
        this.aeE = aVar;
        this.yz = Status.En;
        tagManager.a(this);
    }

    private void lp() {
        if (this.aeD != null) {
            this.aeD.bK(this.aeC.lm());
        }
    }

    public synchronized void a(Container container) {
        if (!this.Ip) {
            if (container == null) {
                bh.A("Unexpected null container.");
            } else {
                this.aeC = container;
                lp();
            }
        }
    }

    public synchronized void bH(String str) {
        if (!this.Ip) {
            this.aeB.bH(str);
        }
    }

    void bJ(String str) {
        if (this.Ip) {
            bh.A("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.aeE.bJ(str);
        }
    }

    public synchronized Container getContainer() {
        Container container = null;
        synchronized (this) {
            if (this.Ip) {
                bh.A("ContainerHolder is released.");
            } else {
                if (this.aeC != null) {
                    this.aeB = this.aeC;
                    this.aeC = null;
                }
                container = this.aeB;
            }
        }
        return container;
    }

    String getContainerId() {
        if (!this.Ip) {
            return this.aeB.getContainerId();
        }
        bh.A("getContainerId called on a released ContainerHolder.");
        return "";
    }

    public Status getStatus() {
        return this.yz;
    }

    String lo() {
        if (!this.Ip) {
            return this.aeE.lo();
        }
        bh.A("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        return "";
    }

    public synchronized void refresh() {
        if (this.Ip) {
            bh.A("Refreshing a released ContainerHolder.");
        } else {
            this.aeE.lq();
        }
    }

    public synchronized void release() {
        if (this.Ip) {
            bh.A("Releasing a released ContainerHolder.");
        } else {
            this.Ip = true;
            this.aeF.b(this);
            this.aeB.release();
            this.aeB = null;
            this.aeC = null;
            this.aeE = null;
            this.aeD = null;
        }
    }

    public synchronized void setContainerAvailableListener(ContainerAvailableListener listener) {
        if (this.Ip) {
            bh.A("ContainerHolder is released.");
        } else if (listener == null) {
            this.aeD = null;
        } else {
            this.aeD = new b(listener, this.DF);
            if (this.aeC != null) {
                lp();
            }
        }
    }
}
