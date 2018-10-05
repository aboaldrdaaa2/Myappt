package lip.com.google.android.gms.panorama;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.kf;
import com.google.android.gms.internal.kg;

public final class Panorama {
    public static final Api<NoOptions> API = new Api(yI, yH, new Scope[0]);
    public static final PanoramaApi PanoramaApi = new kf();
    public static final c<kg> yH = new c();
    static final b<kg, NoOptions> yI = new b<kg, NoOptions>() {
        /* renamed from: d */
        public kg a(Context context, Looper looper, gy gyVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new kg(context, looper, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };

    private Panorama() {
    }
}
