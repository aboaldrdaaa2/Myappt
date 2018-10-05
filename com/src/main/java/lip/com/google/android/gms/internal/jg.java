package lip.com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.hb.e;
import com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener;
import com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

public class jg extends hb<je> {
    private final jj<je> VJ;
    private final jf VP;
    private final jz VQ;
    private final iz VR;
    private final String VS;

    private final class a extends b<OnAddGeofencesResultListener> {
        private final int CT;
        private final String[] VT;

        public a(OnAddGeofencesResultListener onAddGeofencesResultListener, int i, String[] strArr) {
            super(onAddGeofencesResultListener);
            this.CT = LocationStatusCodes.cJ(i);
            this.VT = strArr;
        }

        /* renamed from: a */
        protected void d(OnAddGeofencesResultListener onAddGeofencesResultListener) {
            if (onAddGeofencesResultListener != null) {
                onAddGeofencesResultListener.onAddGeofencesResult(this.CT, this.VT);
            }
        }

        protected void fu() {
        }
    }

    private final class c implements jj<je> {
        private c() {
        }

        public void cn() {
            jg.this.b();
        }

        /* renamed from: iZ */
        public je ft() {
            return (je) jg.this.ft();
        }
    }

    private final class d extends b<OnRemoveGeofencesResultListener> {
        private final int CT;
        private final String[] VT;
        private final int VY;
        private final PendingIntent mPendingIntent;

        public d(jg jgVar, int i, OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, int i2, PendingIntent pendingIntent) {
            boolean z = true;
            jg.this = jgVar;
            super(onRemoveGeofencesResultListener);
            if (i != 1) {
                z = false;
            }
            gx.A(z);
            this.VY = i;
            this.CT = LocationStatusCodes.cJ(i2);
            this.mPendingIntent = pendingIntent;
            this.VT = null;
        }

        public d(int i, OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, int i2, String[] strArr) {
            super(onRemoveGeofencesResultListener);
            gx.A(i == 2);
            this.VY = i;
            this.CT = LocationStatusCodes.cJ(i2);
            this.VT = strArr;
            this.mPendingIntent = null;
        }

        /* renamed from: a */
        protected void d(OnRemoveGeofencesResultListener onRemoveGeofencesResultListener) {
            if (onRemoveGeofencesResultListener != null) {
                switch (this.VY) {
                    case 1:
                        onRemoveGeofencesResultListener.onRemoveGeofencesByPendingIntentResult(this.CT, this.mPendingIntent);
                        return;
                    case 2:
                        onRemoveGeofencesResultListener.onRemoveGeofencesByRequestIdsResult(this.CT, this.VT);
                        return;
                    default:
                        Log.wtf("LocationClientImpl", "Unsupported action: " + this.VY);
                        return;
                }
            }
        }

        protected void fu() {
        }
    }

    private static final class b extends com.google.android.gms.internal.jd.a {
        private OnAddGeofencesResultListener VV;
        private OnRemoveGeofencesResultListener VW;
        private jg VX;

        public b(OnAddGeofencesResultListener onAddGeofencesResultListener, jg jgVar) {
            this.VV = onAddGeofencesResultListener;
            this.VW = null;
            this.VX = jgVar;
        }

        public b(OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, jg jgVar) {
            this.VW = onRemoveGeofencesResultListener;
            this.VV = null;
            this.VX = jgVar;
        }

        public void onAddGeofencesResult(int statusCode, String[] geofenceRequestIds) throws RemoteException {
            if (this.VX == null) {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            }
            jg jgVar = this.VX;
            jg jgVar2 = this.VX;
            jgVar2.getClass();
            jgVar.a(new a(this.VV, statusCode, geofenceRequestIds));
            this.VX = null;
            this.VV = null;
            this.VW = null;
        }

        public void onRemoveGeofencesByPendingIntentResult(int statusCode, PendingIntent pendingIntent) {
            if (this.VX == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
                return;
            }
            jg jgVar = this.VX;
            jg jgVar2 = this.VX;
            jgVar2.getClass();
            jgVar.a(new d(jgVar2, 1, this.VW, statusCode, pendingIntent));
            this.VX = null;
            this.VV = null;
            this.VW = null;
        }

        public void onRemoveGeofencesByRequestIdsResult(int statusCode, String[] geofenceRequestIds) {
            if (this.VX == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
                return;
            }
            jg jgVar = this.VX;
            jg jgVar2 = this.VX;
            jgVar2.getClass();
            jgVar.a(new d(2, this.VW, statusCode, geofenceRequestIds));
            this.VX = null;
            this.VV = null;
            this.VW = null;
        }
    }

    public jg(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str) {
        this(context, looper, context.getPackageName(), connectionCallbacks, onConnectionFailedListener, str, null);
    }

    public jg(Context context, Looper looper, String str, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str2, String str3) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.VJ = new c();
        this.VP = new jf(context, this.VJ);
        this.VS = str2;
        this.VQ = new jz(str, this.VJ);
        this.VR = iz.a(context, str3, this.VJ);
    }

    public jg(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String str) {
        super(context, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.VJ = new c();
        this.VP = new jf(context, this.VJ);
        this.VS = str;
        this.VQ = new jz(context.getPackageName(), this.VJ);
        this.VR = iz.a(context, null, this.VJ);
    }

    protected void a(hi hiVar, e eVar) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.VS);
        hiVar.e(eVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), bundle);
    }

    public void addGeofences(List<jh> geofences, PendingIntent pendingIntent, OnAddGeofencesResultListener listener) throws RemoteException {
        jd jdVar;
        b();
        boolean z = geofences != null && geofences.size() > 0;
        hm.b(z, (Object) "At least one geofence must be specified.");
        hm.b((Object) pendingIntent, (Object) "PendingIntent must be specified.");
        hm.b((Object) listener, (Object) "OnAddGeofencesResultListener not provided.");
        if (listener == null) {
            jdVar = null;
        } else {
            Object jdVar2 = new b(listener, this);
        }
        ((je) ft()).a((List) geofences, pendingIntent, jdVar2, getContext().getPackageName());
    }

    /* renamed from: at */
    protected je x(IBinder iBinder) {
        return com.google.android.gms.internal.je.a.as(iBinder);
    }

    protected String bu() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected String bv() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    public void disconnect() {
        synchronized (this.VP) {
            if (isConnected()) {
                this.VP.removeAllListeners();
                this.VP.iY();
            }
            super.disconnect();
        }
    }

    public Location getLastLocation() {
        return this.VP.getLastLocation();
    }

    public void removeActivityUpdates(PendingIntent callbackIntent) throws RemoteException {
        b();
        hm.f(callbackIntent);
        ((je) ft()).removeActivityUpdates(callbackIntent);
    }

    public void removeGeofences(PendingIntent pendingIntent, OnRemoveGeofencesResultListener listener) throws RemoteException {
        jd jdVar;
        b();
        hm.b((Object) pendingIntent, (Object) "PendingIntent must be specified.");
        hm.b((Object) listener, (Object) "OnRemoveGeofencesResultListener not provided.");
        if (listener == null) {
            jdVar = null;
        } else {
            Object jdVar2 = new b(listener, this);
        }
        ((je) ft()).a(pendingIntent, jdVar2, getContext().getPackageName());
    }

    public void removeGeofences(List<String> geofenceRequestIds, OnRemoveGeofencesResultListener listener) throws RemoteException {
        jd jdVar;
        b();
        boolean z = geofenceRequestIds != null && geofenceRequestIds.size() > 0;
        hm.b(z, (Object) "geofenceRequestIds can't be null nor empty.");
        hm.b((Object) listener, (Object) "OnRemoveGeofencesResultListener not provided.");
        String[] strArr = (String[]) geofenceRequestIds.toArray(new String[0]);
        if (listener == null) {
            jdVar = null;
        } else {
            Object jdVar2 = new b(listener, this);
        }
        ((je) ft()).a(strArr, jdVar2, getContext().getPackageName());
    }

    public void removeLocationUpdates(PendingIntent callbackIntent) throws RemoteException {
        this.VP.removeLocationUpdates(callbackIntent);
    }

    public void removeLocationUpdates(LocationListener listener) throws RemoteException {
        this.VP.removeLocationUpdates(listener);
    }

    public void requestActivityUpdates(long detectionIntervalMillis, PendingIntent callbackIntent) throws RemoteException {
        b();
        hm.f(callbackIntent);
        hm.b(detectionIntervalMillis >= 0, (Object) "detectionIntervalMillis must be >= 0");
        ((je) ft()).a(detectionIntervalMillis, true, callbackIntent);
    }

    public void requestLocationUpdates(LocationRequest request, PendingIntent callbackIntent) throws RemoteException {
        this.VP.requestLocationUpdates(request, callbackIntent);
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener) throws RemoteException {
        requestLocationUpdates(request, listener, null);
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener, Looper looper) throws RemoteException {
        synchronized (this.VP) {
            this.VP.requestLocationUpdates(request, listener, looper);
        }
    }

    public void setMockLocation(Location mockLocation) throws RemoteException {
        this.VP.setMockLocation(mockLocation);
    }

    public void setMockMode(boolean isMockMode) throws RemoteException {
        this.VP.setMockMode(isMockMode);
    }
}
