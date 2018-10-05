package lip.com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.ki;
import com.google.android.gms.internal.kj;
import com.google.android.gms.internal.kk;
import com.google.android.gms.internal.kl;
import com.google.android.gms.internal.km;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.e;
import com.google.android.gms.plus.internal.h;
import java.util.HashSet;
import java.util.Set;

public final class Plus {
    public static final Api<PlusOptions> API = new Api(yI, yH, new Scope[0]);
    public static final Account AccountApi = new ki();
    public static final Moments MomentsApi = new kl();
    public static final People PeopleApi = new km();
    public static final Scope SCOPE_PLUS_LOGIN = new Scope(Scopes.PLUS_LOGIN);
    public static final Scope SCOPE_PLUS_PROFILE = new Scope(Scopes.PLUS_ME);
    public static final b abp = new kk();
    public static final a abq = new kj();
    public static final c<e> yH = new c();
    static final b<e, PlusOptions> yI = new b<e, PlusOptions>() {
        public e a(Context context, Looper looper, gy gyVar, PlusOptions plusOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (plusOptions == null) {
                plusOptions = new PlusOptions();
            }
            return new e(context, looper, connectionCallbacks, onConnectionFailedListener, new h(gyVar.fj(), gyVar.fm(), (String[]) plusOptions.abs.toArray(new String[0]), new String[0], context.getPackageName(), context.getPackageName(), null, new PlusCommonExtras()));
        }

        public int getPriority() {
            return 2;
        }
    };

    public static final class PlusOptions implements Optional {
        final String abr;
        final Set<String> abs;

        public static final class Builder {
            String abr;
            final Set<String> abs = new HashSet();

            public Builder addActivityTypes(String... activityTypes) {
                hm.b((Object) activityTypes, (Object) "activityTypes may not be null.");
                for (Object add : activityTypes) {
                    this.abs.add(add);
                }
                return this;
            }

            public PlusOptions build() {
                return new PlusOptions(this, null);
            }

            public Builder setServerClientId(String clientId) {
                this.abr = clientId;
                return this;
            }
        }

        private PlusOptions() {
            this.abr = null;
            this.abs = new HashSet();
        }

        private PlusOptions(Builder builder) {
            this.abr = builder.abr;
            this.abs = builder.abs;
        }

        /* synthetic */ PlusOptions(Builder x0, AnonymousClass1 x1) {
            this(x0);
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    public static abstract class a<R extends Result> extends com.google.android.gms.common.api.a.b<R, e> {
        public a() {
            super(Plus.yH);
        }
    }

    private Plus() {
    }

    public static e a(GoogleApiClient googleApiClient, c<e> cVar) {
        boolean z = true;
        hm.b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        hm.a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        e eVar = (e) googleApiClient.a((c) cVar);
        if (eVar == null) {
            z = false;
        }
        hm.a(z, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        return eVar;
    }
}
