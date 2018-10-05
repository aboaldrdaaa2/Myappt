package lip.com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.hb.e;
import com.google.android.gms.internal.ke.a;

public class kg extends hb<ke> {
    public kg(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, (String[]) null);
    }

    protected void a(hi hiVar, e eVar) throws RemoteException {
        hiVar.a((hh) eVar, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), new Bundle());
    }

    /* renamed from: bj */
    public ke x(IBinder iBinder) {
        return a.bi(iBinder);
    }

    protected String bu() {
        return "com.google.android.gms.panorama.service.START";
    }

    protected String bv() {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }
}
