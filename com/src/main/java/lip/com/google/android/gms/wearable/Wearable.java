package lip.com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.gy;
import com.google.android.gms.wearable.internal.ae;
import com.google.android.gms.wearable.internal.ah;
import com.google.android.gms.wearable.internal.au;
import com.google.android.gms.wearable.internal.e;
import com.google.android.gms.wearable.internal.f;

public class Wearable {
    public static final Api<WearableOptions> API = new Api(yI, yH, new Scope[0]);
    public static final DataApi DataApi = new f();
    public static final MessageApi MessageApi = new ae();
    public static final NodeApi NodeApi = new ah();
    public static final b alp = new e();
    public static final c<au> yH = new c();
    private static final b<au, WearableOptions> yI = new b<au, WearableOptions>() {
        public au a(Context context, Looper looper, gy gyVar, WearableOptions wearableOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (wearableOptions == null) {
                WearableOptions wearableOptions2 = new WearableOptions(new Builder(), null);
            }
            return new au(context, looper, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };

    public static final class WearableOptions implements Optional {

        public static class Builder {
            public WearableOptions build() {
                return new WearableOptions(this, null);
            }
        }

        private WearableOptions(Builder builder) {
        }

        /* synthetic */ WearableOptions(Builder x0, AnonymousClass1 x1) {
            this(x0);
        }
    }

    private Wearable() {
    }
}
