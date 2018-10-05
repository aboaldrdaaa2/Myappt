package lip.com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.gy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Api<O extends ApiOptions> {
    private final b<?, O> Dm;
    private final c<?> Dn;
    private final ArrayList<Scope> Do;

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    public interface a {
        void connect();

        void disconnect();

        Looper getLooper();

        boolean isConnected();
    }

    public interface b<T extends a, O> {
        T a(Context context, Looper looper, gy gyVar, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener);

        int getPriority();
    }

    public static final class c<C extends a> {
    }

    public <C extends a> Api(b<C, O> clientBuilder, c<C> clientKey, Scope... impliedScopes) {
        this.Dm = clientBuilder;
        this.Dn = clientKey;
        this.Do = new ArrayList(Arrays.asList(impliedScopes));
    }

    public List<Scope> eA() {
        return this.Do;
    }

    public c<?> eB() {
        return this.Dn;
    }

    public b<?, O> ez() {
        return this.Dm;
    }
}
