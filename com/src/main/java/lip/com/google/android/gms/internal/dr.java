package lip.com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.dw.a;
import com.google.android.gms.internal.hb.e;

public class dr extends hb<dw> {
    final int pV;

    public dr(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i) {
        super(context, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.pV = i;
    }

    protected void a(hi hiVar, e eVar) throws RemoteException {
        hiVar.g(eVar, this.pV, getContext().getPackageName(), new Bundle());
    }

    protected String bu() {
        return "com.google.android.gms.ads.service.START";
    }

    protected String bv() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public dw bw() {
        return (dw) super.ft();
    }

    /* renamed from: w */
    protected dw x(IBinder iBinder) {
        return a.y(iBinder);
    }
}
