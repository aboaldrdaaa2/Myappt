package lip.com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.fu.a;
import com.google.android.gms.internal.hb.e;

public class fx extends hb<fu> {
    public fx(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
    }

    /* renamed from: C */
    protected fu x(IBinder iBinder) {
        return a.A(iBinder);
    }

    protected void a(hi hiVar, e eVar) throws RemoteException {
        hiVar.b(eVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName());
    }

    protected String bu() {
        return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
    }

    protected String bv() {
        return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
    }

    public fu dR() {
        return (fu) ft();
    }
}
