package lip.com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hc;
import com.google.android.gms.internal.hm;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class c implements GoogleApiClient {
    private final Looper DF;
    private final Lock DQ = new ReentrantLock();
    private final Condition DR = this.DQ.newCondition();
    private final hc DS;
    private final Fragment DT;
    final Queue<c<?>> DU = new LinkedList();
    private ConnectionResult DV;
    private int DW;
    private int DX = 4;
    private int DY = 0;
    private boolean DZ = false;
    private final a Dy = new a() {
        public void b(c<?> cVar) {
            c.this.Eh.remove(cVar);
        }
    };
    private int Ea;
    private long Eb = 5000;
    final Handler Ec;
    private final Bundle Ed = new Bundle();
    private final Map<com.google.android.gms.common.api.Api.c<?>, com.google.android.gms.common.api.Api.a> Ee = new HashMap();
    private final List<String> Ef;
    private boolean Eg;
    final Set<c<?>> Eh = Collections.newSetFromMap(new ConcurrentHashMap());
    final ConnectionCallbacks Ei = new ConnectionCallbacks() {
        public void onConnected(Bundle connectionHint) {
            c.this.DQ.lock();
            try {
                if (c.this.DX == 1) {
                    if (connectionHint != null) {
                        c.this.Ed.putAll(connectionHint);
                    }
                    c.this.eK();
                }
                c.this.DQ.unlock();
            } catch (Throwable th) {
                c.this.DQ.unlock();
            }
        }

        public void onConnectionSuspended(int cause) {
            c.this.DQ.lock();
            try {
                c.this.aa(cause);
                switch (cause) {
                    case 1:
                        if (!c.this.eM()) {
                            c.this.DY = 2;
                            c.this.Ec.sendMessageDelayed(c.this.Ec.obtainMessage(1), c.this.Eb);
                            break;
                        }
                        c.this.DQ.unlock();
                        return;
                    case 2:
                        c.this.connect();
                        break;
                }
                c.this.DQ.unlock();
            } catch (Throwable th) {
                c.this.DQ.unlock();
            }
        }
    };
    private final com.google.android.gms.internal.hc.b Ej = new com.google.android.gms.internal.hc.b() {
        public boolean eO() {
            return c.this.Eg;
        }

        public Bundle ef() {
            return null;
        }

        public boolean isConnected() {
            return c.this.isConnected();
        }
    };

    interface a {
        void b(c<?> cVar);
    }

    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                c.this.DQ.lock();
                try {
                    if (!(c.this.isConnected() || c.this.isConnecting())) {
                        c.this.connect();
                    }
                    c.this.DQ.unlock();
                } catch (Throwable th) {
                    c.this.DQ.unlock();
                }
            } else {
                Log.wtf("GoogleApiClientImpl", "Don't know how to handle this message.");
            }
        }
    }

    interface c<A extends com.google.android.gms.common.api.Api.a> {
        void a(a aVar);

        void b(A a) throws DeadObjectException;

        void cancel();

        com.google.android.gms.common.api.Api.c<A> eB();

        int eG();

        void m(Status status);
    }

    public c(Context context, Looper looper, gy gyVar, Map<Api<?>, ApiOptions> map, Fragment fragment, Set<ConnectionCallbacks> set, Set<OnConnectionFailedListener> set2) {
        this.DS = new hc(context, looper, this.Ej);
        this.DT = fragment;
        this.DF = looper;
        this.Ec = new b(looper);
        for (ConnectionCallbacks registerConnectionCallbacks : set) {
            this.DS.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (OnConnectionFailedListener registerConnectionFailedListener : set2) {
            this.DS.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        for (Api api : map.keySet()) {
            final com.google.android.gms.common.api.Api.b ez = api.ez();
            Object obj = map.get(api);
            this.Ee.put(api.eB(), a(ez, obj, context, looper, gyVar, this.Ei, new OnConnectionFailedListener() {
                public void onConnectionFailed(ConnectionResult result) {
                    c.this.DQ.lock();
                    try {
                        if (c.this.DV == null || ez.getPriority() < c.this.DW) {
                            c.this.DV = result;
                            c.this.DW = ez.getPriority();
                        }
                        c.this.eK();
                    } finally {
                        c.this.DQ.unlock();
                    }
                }
            }));
        }
        this.Ef = Collections.unmodifiableList(gyVar.fl());
    }

    private static <C extends com.google.android.gms.common.api.Api.a, O> C a(com.google.android.gms.common.api.Api.b<C, O> bVar, Object obj, Context context, Looper looper, gy gyVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return bVar.a(context, looper, gyVar, obj, connectionCallbacks, onConnectionFailedListener);
    }

    private <A extends com.google.android.gms.common.api.Api.a> void a(c<A> cVar) throws DeadObjectException {
        boolean z = true;
        this.DQ.lock();
        try {
            boolean z2 = isConnected() || eM();
            hm.a(z2, "GoogleApiClient is not connected yet.");
            if (cVar.eB() == null) {
                z = false;
            }
            hm.b(z, (Object) "This task can not be executed or enqueued (it's probably a Batch or malformed)");
            this.Eh.add(cVar);
            cVar.a(this.Dy);
            if (eM()) {
                cVar.m(new Status(8));
                return;
            }
            cVar.b(a(cVar.eB()));
            this.DQ.unlock();
        } finally {
            this.DQ.unlock();
        }
    }

    private void aa(int i) {
        this.DQ.lock();
        try {
            if (this.DX != 3) {
                if (i == -1) {
                    Iterator it;
                    c cVar;
                    if (isConnecting()) {
                        it = this.DU.iterator();
                        while (it.hasNext()) {
                            cVar = (c) it.next();
                            if (cVar.eG() != 1) {
                                cVar.cancel();
                                it.remove();
                            }
                        }
                    } else {
                        this.DU.clear();
                    }
                    for (c cVar2 : this.Eh) {
                        cVar2.cancel();
                    }
                    this.Eh.clear();
                    if (this.DV == null && !this.DU.isEmpty()) {
                        this.DZ = true;
                        return;
                    }
                }
                boolean isConnecting = isConnecting();
                boolean isConnected = isConnected();
                this.DX = 3;
                if (isConnecting) {
                    if (i == -1) {
                        this.DV = null;
                    }
                    this.DR.signalAll();
                }
                this.Eg = false;
                for (com.google.android.gms.common.api.Api.a aVar : this.Ee.values()) {
                    if (aVar.isConnected()) {
                        aVar.disconnect();
                    }
                }
                this.Eg = true;
                this.DX = 4;
                if (isConnected) {
                    if (i != -1) {
                        this.DS.ao(i);
                    }
                    this.Eg = false;
                }
            }
            this.DQ.unlock();
        } finally {
            this.DQ.unlock();
        }
    }

    private void eK() {
        this.DQ.lock();
        try {
            this.Ea--;
            if (this.Ea == 0) {
                if (this.DV != null) {
                    this.DZ = false;
                    aa(3);
                    if (eM()) {
                        this.DY--;
                    }
                    if (eM()) {
                        this.Ec.sendMessageDelayed(this.Ec.obtainMessage(1), this.Eb);
                    } else {
                        this.DS.a(this.DV);
                    }
                    this.Eg = false;
                } else {
                    this.DX = 2;
                    eN();
                    this.DR.signalAll();
                    eL();
                    if (this.DZ) {
                        this.DZ = false;
                        aa(-1);
                    } else {
                        this.DS.c(this.Ed.isEmpty() ? null : this.Ed);
                    }
                }
            }
            this.DQ.unlock();
        } catch (Throwable th) {
            this.DQ.unlock();
        }
    }

    private void eL() {
        boolean z = isConnected() || eM();
        hm.a(z, "GoogleApiClient is not connected yet.");
        this.DQ.lock();
        while (!this.DU.isEmpty()) {
            try {
                a((c) this.DU.remove());
            } catch (Throwable e) {
                Log.w("GoogleApiClientImpl", "Service died while flushing queue", e);
            } catch (Throwable th) {
                this.DQ.unlock();
            }
        }
        this.DQ.unlock();
    }

    private boolean eM() {
        this.DQ.lock();
        try {
            boolean z = this.DY != 0;
            this.DQ.unlock();
            return z;
        } catch (Throwable th) {
            this.DQ.unlock();
        }
    }

    private void eN() {
        this.DQ.lock();
        try {
            this.DY = 0;
            this.Ec.removeMessages(1);
        } finally {
            this.DQ.unlock();
        }
    }

    public <C extends com.google.android.gms.common.api.Api.a> C a(com.google.android.gms.common.api.Api.c<C> cVar) {
        Object obj = (com.google.android.gms.common.api.Api.a) this.Ee.get(cVar);
        hm.b(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public <A extends com.google.android.gms.common.api.Api.a, T extends com.google.android.gms.common.api.a.b<? extends Result, A>> T a(T t) {
        this.DQ.lock();
        try {
            if (isConnected()) {
                b((com.google.android.gms.common.api.a.b) t);
            } else {
                this.DU.add(t);
            }
            this.DQ.unlock();
            return t;
        } catch (Throwable th) {
            this.DQ.unlock();
        }
    }

    public <A extends com.google.android.gms.common.api.Api.a, T extends com.google.android.gms.common.api.a.b<? extends Result, A>> T b(T t) {
        boolean z = isConnected() || eM();
        hm.a(z, "GoogleApiClient is not connected yet.");
        eL();
        try {
            a((c) t);
        } catch (DeadObjectException e) {
            aa(1);
        }
        return t;
    }

    public ConnectionResult blockingConnect() {
        ConnectionResult connectionResult;
        hm.a(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.DQ.lock();
        try {
            connect();
            while (isConnecting()) {
                this.DR.await();
            }
            if (isConnected()) {
                connectionResult = ConnectionResult.CS;
            } else if (this.DV != null) {
                connectionResult = this.DV;
                this.DQ.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.DQ.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.DQ.unlock();
        }
        return connectionResult;
    }

    public ConnectionResult blockingConnect(long timeout, TimeUnit unit) {
        ConnectionResult connectionResult;
        hm.a(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.DQ.lock();
        try {
            connect();
            long toNanos = unit.toNanos(timeout);
            while (isConnecting()) {
                toNanos = this.DR.awaitNanos(toNanos);
                if (toNanos <= 0) {
                    connectionResult = new ConnectionResult(14, null);
                    break;
                }
            }
            if (isConnected()) {
                connectionResult = ConnectionResult.CS;
                this.DQ.unlock();
            } else if (this.DV != null) {
                connectionResult = this.DV;
                this.DQ.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.DQ.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.DQ.unlock();
        }
        return connectionResult;
    }

    public void connect() {
        this.DQ.lock();
        try {
            this.DZ = false;
            if (isConnected() || isConnecting()) {
                this.DQ.unlock();
                return;
            }
            this.Eg = true;
            this.DV = null;
            this.DX = 1;
            this.Ed.clear();
            this.Ea = this.Ee.size();
            for (com.google.android.gms.common.api.Api.a connect : this.Ee.values()) {
                connect.connect();
            }
            this.DQ.unlock();
        } catch (Throwable th) {
            this.DQ.unlock();
        }
    }

    public void disconnect() {
        eN();
        aa(-1);
    }

    public Looper getLooper() {
        return this.DF;
    }

    public boolean isConnected() {
        this.DQ.lock();
        try {
            boolean z = this.DX == 2;
            this.DQ.unlock();
            return z;
        } catch (Throwable th) {
            this.DQ.unlock();
        }
    }

    public boolean isConnecting() {
        boolean z = true;
        this.DQ.lock();
        try {
            if (this.DX != 1) {
                z = false;
            }
            this.DQ.unlock();
            return z;
        } catch (Throwable th) {
            this.DQ.unlock();
        }
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.DS.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.DS.isConnectionFailedListenerRegistered(listener);
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.DS.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.DS.registerConnectionFailedListener(listener);
    }

    public void stopAutoManage() {
        hm.a(this.DT != null, "Called stopAutoManage but automatic lifecycle management is not enabled.");
        if (this.DT.getActivity() != null) {
            this.DT.getActivity().getSupportFragmentManager().beginTransaction().remove(this.DT).commit();
            disconnect();
        }
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.DS.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.DS.unregisterConnectionFailedListener(listener);
    }
}
