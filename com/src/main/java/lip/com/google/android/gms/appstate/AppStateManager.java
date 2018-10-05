package lip.com.google.android.gms.appstate;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ga;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hm;

public final class AppStateManager {
    public static final Api<NoOptions> API = new Api(yI, yH, SCOPE_APP_STATE);
    public static final Scope SCOPE_APP_STATE = new Scope(Scopes.APP_STATE);
    static final com.google.android.gms.common.api.Api.c<ga> yH = new com.google.android.gms.common.api.Api.c();
    private static final com.google.android.gms.common.api.Api.b<ga, NoOptions> yI = new com.google.android.gms.common.api.Api.b<ga, NoOptions>() {
        /* renamed from: b */
        public ga a(Context context, Looper looper, gy gyVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new ga(context, looper, connectionCallbacks, onConnectionFailedListener, gyVar.fj(), (String[]) gyVar.fl().toArray(new String[0]));
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };

    public interface StateConflictResult extends Releasable, Result {
        byte[] getLocalData();

        String getResolvedVersion();

        byte[] getServerData();

        int getStateKey();
    }

    public interface StateDeletedResult extends Result {
        int getStateKey();
    }

    public interface StateListResult extends Result {
        AppStateBuffer getStateBuffer();
    }

    public interface StateLoadedResult extends Releasable, Result {
        byte[] getLocalData();

        int getStateKey();
    }

    public interface StateResult extends Releasable, Result {
        StateConflictResult getConflictResult();

        StateLoadedResult getLoadedResult();
    }

    public static abstract class a<R extends Result> extends com.google.android.gms.common.api.a.b<R, ga> {
        public a() {
            super(AppStateManager.yH);
        }
    }

    private static abstract class b extends a<StateDeletedResult> {
        private b() {
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private static abstract class c extends a<StateListResult> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: h */
        public StateListResult c(final Status status) {
            return new StateListResult() {
                public AppStateBuffer getStateBuffer() {
                    return new AppStateBuffer(null);
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class d extends a<Status> {
        private d() {
        }

        /* synthetic */ d(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: d */
        public Status c(Status status) {
            return status;
        }
    }

    private static abstract class e extends a<StateResult> {
        private e() {
        }

        /* synthetic */ e(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: i */
        public StateResult c(Status status) {
            return AppStateManager.e(status);
        }
    }

    private AppStateManager() {
    }

    public static ga a(GoogleApiClient googleApiClient) {
        boolean z = true;
        hm.b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        hm.a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        ga gaVar = (ga) googleApiClient.a(yH);
        if (gaVar == null) {
            z = false;
        }
        hm.a(z, "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return gaVar;
    }

    public static PendingResult<StateDeletedResult> delete(GoogleApiClient googleApiClient, final int stateKey) {
        return googleApiClient.b(new b() {
            protected void a(ga gaVar) {
                gaVar.a((com.google.android.gms.common.api.a.d) this, stateKey);
            }

            /* renamed from: g */
            public StateDeletedResult c(final Status status) {
                return new StateDeletedResult() {
                    public int getStateKey() {
                        return stateKey;
                    }

                    public Status getStatus() {
                        return status;
                    }
                };
            }
        });
    }

    private static StateResult e(final Status status) {
        return new StateResult() {
            public StateConflictResult getConflictResult() {
                return null;
            }

            public StateLoadedResult getLoadedResult() {
                return null;
            }

            public Status getStatus() {
                return status;
            }

            public void release() {
            }
        };
    }

    public static int getMaxNumKeys(GoogleApiClient googleApiClient) {
        return a(googleApiClient).dV();
    }

    public static int getMaxStateSize(GoogleApiClient googleApiClient) {
        return a(googleApiClient).dU();
    }

    public static PendingResult<StateListResult> list(GoogleApiClient googleApiClient) {
        return googleApiClient.a(new c() {
            protected void a(ga gaVar) {
                gaVar.a(this);
            }
        });
    }

    public static PendingResult<StateResult> load(GoogleApiClient googleApiClient, final int stateKey) {
        return googleApiClient.a(new e() {
            protected void a(ga gaVar) {
                gaVar.b(this, stateKey);
            }
        });
    }

    public static PendingResult<StateResult> resolve(GoogleApiClient googleApiClient, final int stateKey, final String resolvedVersion, final byte[] resolvedData) {
        return googleApiClient.b(new e() {
            protected void a(ga gaVar) {
                gaVar.a(this, stateKey, resolvedVersion, resolvedData);
            }
        });
    }

    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.b(new d() {
            protected void a(ga gaVar) {
                gaVar.b((com.google.android.gms.common.api.a.d) this);
            }
        });
    }

    public static void update(GoogleApiClient googleApiClient, final int stateKey, final byte[] data) {
        googleApiClient.b(new e() {
            protected void a(ga gaVar) {
                gaVar.a(null, stateKey, data);
            }
        });
    }

    public static PendingResult<StateResult> updateImmediate(GoogleApiClient googleApiClient, final int stateKey, final byte[] data) {
        return googleApiClient.b(new e() {
            protected void a(ga gaVar) {
                gaVar.a(this, stateKey, data);
            }
        });
    }
}
