package lip.com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager.StateConflictResult;
import com.google.android.gms.appstate.AppStateManager.StateDeletedResult;
import com.google.android.gms.appstate.AppStateManager.StateListResult;
import com.google.android.gms.appstate.AppStateManager.StateLoadedResult;
import com.google.android.gms.appstate.AppStateManager.StateResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public final class ga extends hb<gc> {
    private final String yQ;

    private static final class b implements StateDeletedResult {
        private final int yS;
        private final Status yz;

        public b(Status status, int i) {
            this.yz = status;
            this.yS = i;
        }

        public int getStateKey() {
            return this.yS;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static final class d extends com.google.android.gms.common.api.b implements StateListResult {
        private final AppStateBuffer yT;

        public d(DataHolder dataHolder) {
            super(dataHolder);
            this.yT = new AppStateBuffer(dataHolder);
        }

        public AppStateBuffer getStateBuffer() {
            return this.yT;
        }
    }

    private static final class f extends com.google.android.gms.common.api.b implements StateConflictResult, StateLoadedResult, StateResult {
        private final int yS;
        private final AppStateBuffer yT;

        public f(int i, DataHolder dataHolder) {
            super(dataHolder);
            this.yS = i;
            this.yT = new AppStateBuffer(dataHolder);
        }

        private boolean dW() {
            return this.yz.getStatusCode() == 2000;
        }

        public StateConflictResult getConflictResult() {
            return dW() ? this : null;
        }

        public StateLoadedResult getLoadedResult() {
            return dW() ? null : this;
        }

        public byte[] getLocalData() {
            return this.yT.getCount() == 0 ? null : this.yT.get(0).getLocalData();
        }

        public String getResolvedVersion() {
            return this.yT.getCount() == 0 ? null : this.yT.get(0).getConflictVersion();
        }

        public byte[] getServerData() {
            return this.yT.getCount() == 0 ? null : this.yT.get(0).getConflictData();
        }

        public int getStateKey() {
            return this.yS;
        }

        public void release() {
            this.yT.close();
        }
    }

    private static final class a extends fz {
        private final com.google.android.gms.common.api.a.d<StateDeletedResult> yR;

        public a(com.google.android.gms.common.api.a.d<StateDeletedResult> dVar) {
            this.yR = (com.google.android.gms.common.api.a.d) hm.b((Object) dVar, (Object) "Result holder must not be null");
        }

        public void b(int i, int i2) {
            this.yR.a(new b(new Status(i), i2));
        }
    }

    private static final class c extends fz {
        private final com.google.android.gms.common.api.a.d<StateListResult> yR;

        public c(com.google.android.gms.common.api.a.d<StateListResult> dVar) {
            this.yR = (com.google.android.gms.common.api.a.d) hm.b((Object) dVar, (Object) "Result holder must not be null");
        }

        public void a(DataHolder dataHolder) {
            this.yR.a(new d(dataHolder));
        }
    }

    private static final class e extends fz {
        private final com.google.android.gms.common.api.a.d<StateResult> yR;

        public e(com.google.android.gms.common.api.a.d<StateResult> dVar) {
            this.yR = (com.google.android.gms.common.api.a.d) hm.b((Object) dVar, (Object) "Result holder must not be null");
        }

        public void a(int i, DataHolder dataHolder) {
            this.yR.a(new f(i, dataHolder));
        }
    }

    private static final class g extends fz {
        private final com.google.android.gms.common.api.a.d<Status> yR;

        public g(com.google.android.gms.common.api.a.d<Status> dVar) {
            this.yR = (com.google.android.gms.common.api.a.d) hm.b((Object) dVar, (Object) "Holder must not be null");
        }

        public void dT() {
            this.yR.a(new Status(0));
        }
    }

    public ga(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, String[] strArr) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.yQ = (String) hm.f(str);
    }

    /* renamed from: D */
    protected gc x(IBinder iBinder) {
        return com.google.android.gms.internal.gc.a.F(iBinder);
    }

    public void a(com.google.android.gms.common.api.a.d<StateListResult> dVar) {
        try {
            ((gc) ft()).a(new c(dVar));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d<StateDeletedResult> dVar, int i) {
        try {
            ((gc) ft()).b(new a(dVar), i);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d<StateResult> dVar, int i, String str, byte[] bArr) {
        try {
            ((gc) ft()).a(new e(dVar), i, str, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d<StateResult> dVar, int i, byte[] bArr) {
        gb gbVar;
        if (dVar == null) {
            gbVar = null;
        } else {
            Object gbVar2 = new e(dVar);
        }
        try {
            ((gc) ft()).a(gbVar2, i, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    protected void a(hi hiVar, com.google.android.gms.internal.hb.e eVar) throws RemoteException {
        hiVar.a((hh) eVar, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.yQ, fs());
    }

    public void b(com.google.android.gms.common.api.a.d<Status> dVar) {
        try {
            ((gc) ft()).b(new g(dVar));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void b(com.google.android.gms.common.api.a.d<StateResult> dVar, int i) {
        try {
            ((gc) ft()).a(new e(dVar), i);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    protected void b(String... strArr) {
        boolean z = false;
        for (String equals : strArr) {
            if (equals.equals(Scopes.APP_STATE)) {
                z = true;
            }
        }
        hm.a(z, String.format("App State APIs requires %s to function.", new Object[]{Scopes.APP_STATE}));
    }

    protected String bu() {
        return "com.google.android.gms.appstate.service.START";
    }

    protected String bv() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    public int dU() {
        try {
            return ((gc) ft()).dU();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    public int dV() {
        try {
            return ((gc) ft()).dV();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }
}
