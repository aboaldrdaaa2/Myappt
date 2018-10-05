package lip.com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;

public abstract class dq extends em {
    private final ds ne;
    private final com.google.android.gms.internal.dp.a pT;

    public static final class a extends dq {
        private final Context mContext;

        public a(Context context, ds dsVar, com.google.android.gms.internal.dp.a aVar) {
            super(dsVar, aVar);
            this.mContext = context;
        }

        public void bs() {
        }

        public dw bt() {
            return dx.a(this.mContext, new ay(), new bj(), new ee());
        }
    }

    public static final class b extends dq implements ConnectionCallbacks, OnConnectionFailedListener {
        private final Object ls = new Object();
        private final com.google.android.gms.internal.dp.a pT;
        private final dr pU;

        public b(Context context, ds dsVar, com.google.android.gms.internal.dp.a aVar) {
            super(dsVar, aVar);
            this.pT = aVar;
            this.pU = new dr(context, this, this, dsVar.kQ.sy);
            this.pU.connect();
        }

        public void bs() {
            synchronized (this.ls) {
                if (this.pU.isConnected() || this.pU.isConnecting()) {
                    this.pU.disconnect();
                }
            }
        }

        public dw bt() {
            dw bw;
            synchronized (this.ls) {
                try {
                    bw = this.pU.bw();
                } catch (IllegalStateException e) {
                    bw = null;
                }
            }
            return bw;
        }

        public void onConnected(Bundle connectionHint) {
            start();
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.pT.a(new du(0));
        }

        public void onDisconnected() {
            eu.z("Disconnected from remote ad request service.");
        }
    }

    public dq(ds dsVar, com.google.android.gms.internal.dp.a aVar) {
        this.ne = dsVar;
        this.pT = aVar;
    }

    private static du a(dw dwVar, ds dsVar) {
        du duVar = null;
        try {
            return dwVar.b(dsVar);
        } catch (Throwable e) {
            eu.c("Could not fetch ad response from ad request service.", e);
            return duVar;
        } catch (Throwable e2) {
            eu.c("Could not fetch ad response from ad request service due to an Exception.", e2);
            return duVar;
        } catch (Throwable e22) {
            eu.c("Could not fetch ad response from ad request service due to an Exception.", e22);
            return duVar;
        }
    }

    public final void bh() {
        try {
            du duVar;
            dw bt = bt();
            if (bt == null) {
                duVar = new du(0);
            } else {
                duVar = a(bt, this.ne);
                if (duVar == null) {
                    duVar = new du(0);
                }
            }
            bs();
            this.pT.a(duVar);
        } catch (Throwable th) {
            bs();
        }
    }

    public abstract void bs();

    public abstract dw bt();

    public final void onStop() {
        bs();
    }
}
