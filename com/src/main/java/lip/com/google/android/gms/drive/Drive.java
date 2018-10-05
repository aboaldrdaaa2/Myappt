package lip.com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.internal.p;
import com.google.android.gms.drive.internal.r;
import com.google.android.gms.drive.internal.t;
import com.google.android.gms.drive.internal.w;
import com.google.android.gms.internal.gy;
import java.util.List;

public final class Drive {
    public static final Api<NoOptions> API = new Api(new a<NoOptions>() {
        protected Bundle a(NoOptions noOptions) {
            return new Bundle();
        }
    }, yH, new Scope[0]);
    public static final DriveApi DriveApi = new p();
    public static final Scope HH = new Scope("https://www.googleapis.com/auth/drive");
    public static final Scope HI = new Scope("https://www.googleapis.com/auth/drive.apps");
    public static final Api<b> HJ = new Api(new a<b>() {
        protected Bundle a(b bVar) {
            return bVar == null ? new Bundle() : bVar.gj();
        }
    }, yH, new Scope[0]);
    public static final b HK = new t();
    public static final d HL = new w();
    public static final Scope SCOPE_APPFOLDER = new Scope(Scopes.DRIVE_APPFOLDER);
    public static final Scope SCOPE_FILE = new Scope(Scopes.DRIVE_FILE);
    public static final c<r> yH = new c();

    public static abstract class a<O extends ApiOptions> implements com.google.android.gms.common.api.Api.b<r, O> {
        protected abstract Bundle a(O o);

        public r a(Context context, Looper looper, gy gyVar, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            List fl = gyVar.fl();
            return new r(context, looper, gyVar, connectionCallbacks, onConnectionFailedListener, (String[]) fl.toArray(new String[fl.size()]), a(o));
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public static class b implements Optional {
        private final Bundle HM;

        private b() {
            this(new Bundle());
        }

        private b(Bundle bundle) {
            this.HM = bundle;
        }

        public Bundle gj() {
            return this.HM;
        }
    }

    private Drive() {
    }
}
