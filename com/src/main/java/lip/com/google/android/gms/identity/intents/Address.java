package lip.com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.iw;

public final class Address {
    public static final Api<AddressOptions> API = new Api(yI, yH, new Scope[0]);
    static final c<iw> yH = new c();
    private static final b<iw, AddressOptions> yI = new b<iw, AddressOptions>() {
        public iw a(Context context, Looper looper, gy gyVar, AddressOptions addressOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            hm.b(context instanceof Activity, (Object) "An Activity must be used for Address APIs");
            if (addressOptions == null) {
                addressOptions = new AddressOptions();
            }
            return new iw((Activity) context, looper, connectionCallbacks, onConnectionFailedListener, gyVar.getAccountName(), addressOptions.theme);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };

    public static final class AddressOptions implements HasOptions {
        public final int theme;

        public AddressOptions() {
            this.theme = 0;
        }

        public AddressOptions(int theme) {
            this.theme = theme;
        }
    }

    private static abstract class a extends com.google.android.gms.common.api.a.b<Status, iw> {
        public a() {
            super(Address.yH);
        }

        /* renamed from: d */
        public Status c(Status status) {
            return status;
        }
    }

    public static void requestUserAddress(GoogleApiClient googleApiClient, final UserAddressRequest request, final int requestCode) {
        googleApiClient.a(new a() {
            protected void a(iw iwVar) throws RemoteException {
                iwVar.a(request, requestCode);
                a(Status.En);
            }
        });
    }
}
