package lip.com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.jb;
import com.google.android.gms.internal.jc;
import com.google.android.gms.internal.jg;

public class LocationServices {
    public static final Api<NoOptions> API = new Api(yI, yH, new Scope[0]);
    public static FusedLocationProviderApi FusedLocationApi = new jb();
    public static GeofencingApi GeofencingApi = new jc();
    private static final c<jg> yH = new c();
    private static final b<jg, NoOptions> yI = new b<jg, NoOptions>() {
        /* renamed from: c */
        public jg a(Context context, Looper looper, gy gyVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new jg(context, looper, connectionCallbacks, onConnectionFailedListener, "locationServices");
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };

    public static abstract class a<R extends Result> extends com.google.android.gms.common.api.a.b<R, jg> {
        public a() {
            super(LocationServices.yH);
        }
    }

    private LocationServices() {
    }

    public static jg e(GoogleApiClient googleApiClient) {
        boolean z = true;
        hm.b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        jg jgVar = (jg) googleApiClient.a(yH);
        if (jgVar == null) {
            z = false;
        }
        hm.a(z, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return jgVar;
    }
}
