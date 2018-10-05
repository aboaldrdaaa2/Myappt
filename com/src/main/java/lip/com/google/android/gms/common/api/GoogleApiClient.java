package lip.com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions;
import com.google.android.gms.common.api.Api.a;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hm;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface GoogleApiClient {

    public static final class Builder {
        private Looper DF;
        private final Set<String> DH;
        private int DI;
        private View DJ;
        private String DK;
        private final Map<Api<?>, ApiOptions> DL;
        private FragmentActivity DM;
        private OnConnectionFailedListener DN;
        private final Set<ConnectionCallbacks> DO;
        private final Set<OnConnectionFailedListener> DP;
        private final Context mContext;
        private String yQ;

        public Builder(Context context) {
            this.DH = new HashSet();
            this.DL = new HashMap();
            this.DO = new HashSet();
            this.DP = new HashSet();
            this.mContext = context;
            this.DF = context.getMainLooper();
            this.DK = context.getPackageName();
        }

        public Builder(Context context, ConnectionCallbacks connectedListener, OnConnectionFailedListener connectionFailedListener) {
            this(context);
            hm.b((Object) connectedListener, (Object) "Must provide a connected listener");
            this.DO.add(connectedListener);
            hm.b((Object) connectionFailedListener, (Object) "Must provide a connection failed listener");
            this.DP.add(connectionFailedListener);
        }

        private d eJ() {
            FragmentManager supportFragmentManager = this.DM.getSupportFragmentManager();
            if (supportFragmentManager.getFragments() != null) {
                for (Fragment fragment : supportFragmentManager.getFragments()) {
                    if ((fragment instanceof d) && fragment.isAdded() && !((d) fragment).isInitialized()) {
                        return (d) fragment;
                    }
                }
            }
            Fragment fragment2 = new d();
            supportFragmentManager.beginTransaction().add(fragment2, null).commit();
            return fragment2;
        }

        public Builder addApi(Api<? extends NotRequiredOptions> api) {
            this.DL.put(api, null);
            List eA = api.eA();
            int size = eA.size();
            for (int i = 0; i < size; i++) {
                this.DH.add(((Scope) eA.get(i)).eP());
            }
            return this;
        }

        public <O extends HasOptions> Builder addApi(Api<O> api, O options) {
            hm.b((Object) options, (Object) "Null options are not permitted for this Api");
            this.DL.put(api, options);
            List eA = api.eA();
            int size = eA.size();
            for (int i = 0; i < size; i++) {
                this.DH.add(((Scope) eA.get(i)).eP());
            }
            return this;
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks listener) {
            this.DO.add(listener);
            return this;
        }

        public Builder addOnConnectionFailedListener(OnConnectionFailedListener listener) {
            this.DP.add(listener);
            return this;
        }

        public Builder addScope(Scope scope) {
            this.DH.add(scope.eP());
            return this;
        }

        public GoogleApiClient build() {
            hm.b(!this.DL.isEmpty(), (Object) "must call addApi() to add at least one API");
            Fragment fragment = null;
            if (this.DM != null) {
                fragment = eJ();
            }
            GoogleApiClient cVar = new c(this.mContext, this.DF, eI(), this.DL, fragment, this.DO, this.DP);
            if (fragment != null) {
                fragment.a(cVar, this.DN);
            }
            return cVar;
        }

        public gy eI() {
            return new gy(this.yQ, this.DH, this.DI, this.DJ, this.DK);
        }

        public Builder enableAutoManage(FragmentActivity fragmentActivity, OnConnectionFailedListener unresolvedConnectionFailedListener) {
            this.DM = (FragmentActivity) hm.b((Object) fragmentActivity, (Object) "Null activity is not permitted.");
            this.DN = unresolvedConnectionFailedListener;
            return this;
        }

        public Builder setAccountName(String accountName) {
            this.yQ = accountName;
            return this;
        }

        public Builder setGravityForPopups(int gravityForPopups) {
            this.DI = gravityForPopups;
            return this;
        }

        public Builder setHandler(Handler handler) {
            hm.b((Object) handler, (Object) "Handler must not be null");
            this.DF = handler.getLooper();
            return this;
        }

        public Builder setViewForPopups(View viewForPopups) {
            this.DJ = viewForPopups;
            return this;
        }

        public Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener extends com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    <C extends a> C a(c<C> cVar);

    <A extends a, T extends b<? extends Result, A>> T a(T t);

    <A extends a, T extends b<? extends Result, A>> T b(T t);

    ConnectionResult blockingConnect();

    ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    void connect();

    void disconnect();

    Looper getLooper();

    boolean isConnected();

    boolean isConnecting();

    boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks);

    boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener);

    void reconnect();

    void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    void stopAutoManage();

    void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);
}
