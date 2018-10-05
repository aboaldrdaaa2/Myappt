package lip.com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.drive.events.b;
import com.google.android.gms.drive.internal.aa.a;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.e;
import com.google.android.gms.internal.hh;
import com.google.android.gms.internal.hi;
import com.google.android.gms.internal.hm;
import java.util.HashMap;
import java.util.Map;

public class r extends hb<aa> {
    private final String IQ;
    private final Bundle IR;
    private DriveId IS;
    private DriveId IT;
    final ConnectionCallbacks IU;
    Map<DriveId, Map<Listener<?>, x<?>>> IV = new HashMap();
    private final String yQ;

    public r(Context context, Looper looper, gy gyVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String[] strArr, Bundle bundle) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.yQ = (String) hm.b(gyVar.fj(), (Object) "Must call Api.ClientBuilder.setAccountName()");
        this.IQ = gyVar.fn();
        this.IU = connectionCallbacks;
        this.IR = bundle;
    }

    /* renamed from: O */
    protected aa x(IBinder iBinder) {
        return a.P(iBinder);
    }

    <C extends DriveEvent> PendingResult<Status> a(GoogleApiClient googleApiClient, final DriveId driveId, final int i, Listener<C> listener) {
        PendingResult<Status> kVar;
        hm.b(b.a(i, driveId), (Object) "id");
        hm.b((Object) listener, (Object) "listener");
        hm.a(isConnected(), "Client must be connected");
        synchronized (this.IV) {
            Map map = (Map) this.IV.get(driveId);
            if (map == null) {
                map = new HashMap();
                this.IV.put(driveId, map);
            }
            if (map.containsKey(listener)) {
                kVar = new k(googleApiClient, Status.En);
            } else {
                final x xVar = new x(getLooper(), i, listener);
                map.put(listener, xVar);
                kVar = googleApiClient.b(new j() {
                    protected void a(r rVar) throws RemoteException {
                        rVar.gp().a(new AddEventListenerRequest(driveId, i, null), xVar, null, new aw(this));
                    }
                });
            }
        }
        return kVar;
    }

    protected void a(int i, IBinder iBinder, Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.IS = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            this.IT = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
        }
        super.a(i, iBinder, bundle);
    }

    protected void a(hi hiVar, e eVar) throws RemoteException {
        String packageName = getContext().getPackageName();
        hm.f(eVar);
        hm.f(packageName);
        hm.f(fs());
        Bundle bundle = new Bundle();
        bundle.putString("proxy_package_name", this.IQ);
        bundle.putAll(this.IR);
        hiVar.a((hh) eVar, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, packageName, fs(), this.yQ, bundle);
    }

    PendingResult<Status> b(GoogleApiClient googleApiClient, final DriveId driveId, final int i, Listener<?> listener) {
        PendingResult<Status> kVar;
        hm.b(b.a(i, driveId), (Object) "id");
        hm.a(isConnected(), "Client must be connected");
        hm.b((Object) listener, (Object) "listener");
        synchronized (this.IV) {
            Map map = (Map) this.IV.get(driveId);
            if (map == null) {
                kVar = new k(googleApiClient, Status.En);
            } else {
                final x xVar = (x) map.remove(listener);
                if (xVar == null) {
                    kVar = new k(googleApiClient, Status.En);
                } else {
                    if (map.isEmpty()) {
                        this.IV.remove(driveId);
                    }
                    kVar = googleApiClient.b(new j() {
                        protected void a(r rVar) throws RemoteException {
                            rVar.gp().a(new RemoveEventListenerRequest(driveId, i), xVar, null, new aw(this));
                        }
                    });
                }
            }
        }
        return kVar;
    }

    protected String bu() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    protected String bv() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    public void disconnect() {
        aa aaVar = (aa) ft();
        if (aaVar != null) {
            try {
                aaVar.a(new DisconnectRequest());
            } catch (RemoteException e) {
            }
        }
        super.disconnect();
        this.IV.clear();
    }

    public aa gp() {
        return (aa) ft();
    }

    public DriveId gq() {
        return this.IS;
    }

    public DriveId gr() {
        return this.IT;
    }
}
