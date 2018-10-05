package lip.com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.ja;
import com.google.android.gms.internal.jg;

public class ActivityRecognition {
    public static final Api<NoOptions> API = new Api(yI, yH, new Scope[0]);
    public static ActivityRecognitionApi ActivityRecognitionApi = new ja();
    public static final String CLIENT_NAME = "activity_recognition";
    private static final c<jg> yH = new c();
    private static final b<jg, NoOptions> yI = new b<jg, NoOptions>() {
        /* renamed from: c */
        public jg a(Context context, Looper looper, gy gyVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new jg(context, looper, connectionCallbacks, onConnectionFailedListener, ActivityRecognition.CLIENT_NAME);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };

    public static abstract class a<R extends Result> extends com.google.android.gms.common.api.a.b<R, jg> {
        public a() {
            super(ActivityRecognition.yH);
        }
    }

    private ActivityRecognition() {
    }
}
