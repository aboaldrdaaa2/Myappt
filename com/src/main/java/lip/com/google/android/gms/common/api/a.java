package lip.com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.hg;
import com.google.android.gms.internal.hm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class a {

    public static class c<R extends Result> extends Handler {
        public c() {
            this(Looper.getMainLooper());
        }

        public c(Looper looper) {
            super(looper);
        }

        public void a(ResultCallback<R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void a(a<R> aVar, long j) {
            sendMessageDelayed(obtainMessage(2, aVar), j);
        }

        protected void b(ResultCallback<R> resultCallback, R r) {
            try {
                resultCallback.onResult(r);
            } catch (RuntimeException e) {
                a.a(r);
                throw e;
            }
        }

        public void eH() {
            removeMessages(2);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Pair pair = (Pair) msg.obj;
                    b((ResultCallback) pair.first, (Result) pair.second);
                    return;
                case 2:
                    ((a) msg.obj).eF();
                    return;
                default:
                    Log.wtf("GoogleApi", "Don't know how to handle this message.");
                    return;
            }
        }
    }

    public interface d<R> {
        void a(R r);
    }

    public static abstract class a<R extends Result> implements PendingResult<R>, d<R> {
        private final Object Dp = new Object();
        private c<R> Dq;
        private final ArrayList<com.google.android.gms.common.api.PendingResult.a> Dr = new ArrayList();
        private ResultCallback<R> Ds;
        private volatile R Dt;
        private volatile boolean Du;
        private boolean Dv;
        private boolean Dw;
        private hg Dx;
        private final CountDownLatch kK = new CountDownLatch(1);

        a() {
        }

        public a(Looper looper) {
            this.Dq = new c(looper);
        }

        public a(c<R> cVar) {
            this.Dq = cVar;
        }

        private void c(R r) {
            this.Dt = r;
            this.Dx = null;
            this.kK.countDown();
            Status status = this.Dt.getStatus();
            if (this.Ds != null) {
                this.Dq.eH();
                if (!this.Dv) {
                    this.Dq.a(this.Ds, eC());
                }
            }
            Iterator it = this.Dr.iterator();
            while (it.hasNext()) {
                ((com.google.android.gms.common.api.PendingResult.a) it.next()).n(status);
            }
            this.Dr.clear();
        }

        private R eC() {
            R r;
            synchronized (this.Dp) {
                hm.a(!this.Du, "Result has already been consumed.");
                hm.a(isReady(), "Result is not ready.");
                r = this.Dt;
                eD();
            }
            return r;
        }

        private void eE() {
            synchronized (this.Dp) {
                if (!isReady()) {
                    a(c(Status.Eo));
                    this.Dw = true;
                }
            }
        }

        private void eF() {
            synchronized (this.Dp) {
                if (!isReady()) {
                    a(c(Status.Eq));
                    this.Dw = true;
                }
            }
        }

        public final void a(com.google.android.gms.common.api.PendingResult.a aVar) {
            hm.a(!this.Du, "Result has already been consumed.");
            synchronized (this.Dp) {
                if (isReady()) {
                    aVar.n(this.Dt.getStatus());
                } else {
                    this.Dr.add(aVar);
                }
            }
        }

        protected void a(c<R> cVar) {
            this.Dq = cVar;
        }

        protected final void a(hg hgVar) {
            synchronized (this.Dp) {
                this.Dx = hgVar;
            }
        }

        public final R await() {
            boolean z = true;
            hm.a(Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread");
            if (this.Du) {
                z = false;
            }
            hm.a(z, "Result has already been consumed");
            try {
                this.kK.await();
            } catch (InterruptedException e) {
                eE();
            }
            hm.a(isReady(), "Result is not ready.");
            return eC();
        }

        public final R await(long time, TimeUnit units) {
            boolean z = true;
            boolean z2 = time <= 0 || Looper.myLooper() != Looper.getMainLooper();
            hm.a(z2, "await must not be called on the UI thread when time is greater than zero.");
            if (this.Du) {
                z = false;
            }
            hm.a(z, "Result has already been consumed.");
            try {
                if (!this.kK.await(time, units)) {
                    eF();
                }
            } catch (InterruptedException e) {
                eE();
            }
            hm.a(isReady(), "Result is not ready.");
            return eC();
        }

        /* renamed from: b */
        public final void a(R r) {
            boolean z = true;
            synchronized (this.Dp) {
                if (this.Dw || this.Dv) {
                    a.a(r);
                    return;
                }
                hm.a(!isReady(), "Results have already been set");
                if (this.Du) {
                    z = false;
                }
                hm.a(z, "Result has already been consumed");
                c((Result) r);
            }
        }

        protected abstract R c(Status status);

        /* JADX WARNING: Missing block: B:19:?, code:
            return;
     */
        public void cancel() {
            /*
            r2 = this;
            r1 = r2.Dp;
            monitor-enter(r1);
            r0 = r2.Dv;	 Catch:{ all -> 0x002c }
            if (r0 != 0) goto L_0x000b;
        L_0x0007:
            r0 = r2.Du;	 Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x000d;
        L_0x000b:
            monitor-exit(r1);	 Catch:{ all -> 0x002c }
        L_0x000c:
            return;
        L_0x000d:
            r0 = r2.Dx;	 Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x0016;
        L_0x0011:
            r0 = r2.Dx;	 Catch:{ RemoteException -> 0x002f }
            r0.cancel();	 Catch:{ RemoteException -> 0x002f }
        L_0x0016:
            r0 = r2.Dt;	 Catch:{ all -> 0x002c }
            com.google.android.gms.common.api.a.a(r0);	 Catch:{ all -> 0x002c }
            r0 = 0;
            r2.Ds = r0;	 Catch:{ all -> 0x002c }
            r0 = 1;
            r2.Dv = r0;	 Catch:{ all -> 0x002c }
            r0 = com.google.android.gms.common.api.Status.Er;	 Catch:{ all -> 0x002c }
            r0 = r2.c(r0);	 Catch:{ all -> 0x002c }
            r2.c(r0);	 Catch:{ all -> 0x002c }
            monitor-exit(r1);	 Catch:{ all -> 0x002c }
            goto L_0x000c;
        L_0x002c:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x002c }
            throw r0;
        L_0x002f:
            r0 = move-exception;
            goto L_0x0016;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.a.a.cancel():void");
        }

        protected void eD() {
            this.Du = true;
            this.Dt = null;
            this.Ds = null;
        }

        public boolean isCanceled() {
            boolean z;
            synchronized (this.Dp) {
                z = this.Dv;
            }
            return z;
        }

        public final boolean isReady() {
            return this.kK.getCount() == 0;
        }

        /* JADX WARNING: Missing block: B:20:?, code:
            return;
     */
        public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<R> r4) {
            /*
            r3 = this;
            r0 = r3.Du;
            if (r0 != 0) goto L_0x0015;
        L_0x0004:
            r0 = 1;
        L_0x0005:
            r1 = "Result has already been consumed.";
            com.google.android.gms.internal.hm.a(r0, r1);
            r1 = r3.Dp;
            monitor-enter(r1);
            r0 = r3.isCanceled();	 Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0017;
        L_0x0013:
            monitor-exit(r1);	 Catch:{ all -> 0x0028 }
        L_0x0014:
            return;
        L_0x0015:
            r0 = 0;
            goto L_0x0005;
        L_0x0017:
            r0 = r3.isReady();	 Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x002b;
        L_0x001d:
            r0 = r3.Dq;	 Catch:{ all -> 0x0028 }
            r2 = r3.eC();	 Catch:{ all -> 0x0028 }
            r0.a(r4, r2);	 Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r1);	 Catch:{ all -> 0x0028 }
            goto L_0x0014;
        L_0x0028:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0028 }
            throw r0;
        L_0x002b:
            r3.Ds = r4;	 Catch:{ all -> 0x0028 }
            goto L_0x0026;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.a.a.setResultCallback(com.google.android.gms.common.api.ResultCallback):void");
        }

        /* JADX WARNING: Missing block: B:20:?, code:
            return;
     */
        public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<R> r5, long r6, TimeUnit r8) {
            /*
            r4 = this;
            r0 = r4.Du;
            if (r0 != 0) goto L_0x0015;
        L_0x0004:
            r0 = 1;
        L_0x0005:
            r1 = "Result has already been consumed.";
            com.google.android.gms.internal.hm.a(r0, r1);
            r1 = r4.Dp;
            monitor-enter(r1);
            r0 = r4.isCanceled();	 Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0017;
        L_0x0013:
            monitor-exit(r1);	 Catch:{ all -> 0x0028 }
        L_0x0014:
            return;
        L_0x0015:
            r0 = 0;
            goto L_0x0005;
        L_0x0017:
            r0 = r4.isReady();	 Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x002b;
        L_0x001d:
            r0 = r4.Dq;	 Catch:{ all -> 0x0028 }
            r2 = r4.eC();	 Catch:{ all -> 0x0028 }
            r0.a(r5, r2);	 Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r1);	 Catch:{ all -> 0x0028 }
            goto L_0x0014;
        L_0x0028:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0028 }
            throw r0;
        L_0x002b:
            r4.Ds = r5;	 Catch:{ all -> 0x0028 }
            r0 = r4.Dq;	 Catch:{ all -> 0x0028 }
            r2 = r8.toMillis(r6);	 Catch:{ all -> 0x0028 }
            r0.a(r4, r2);	 Catch:{ all -> 0x0028 }
            goto L_0x0026;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.a.a.setResultCallback(com.google.android.gms.common.api.ResultCallback, long, java.util.concurrent.TimeUnit):void");
        }
    }

    public static abstract class b<R extends Result, A extends com.google.android.gms.common.api.Api.a> extends a<R> implements c<A> {
        private final com.google.android.gms.common.api.Api.c<A> Dn;
        private a Dy;

        protected b(com.google.android.gms.common.api.Api.c<A> cVar) {
            this.Dn = (com.google.android.gms.common.api.Api.c) hm.f(cVar);
        }

        private void a(RemoteException remoteException) {
            m(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        protected abstract void a(A a) throws RemoteException;

        public void a(a aVar) {
            this.Dy = aVar;
        }

        public final void b(A a) throws DeadObjectException {
            a(new c(a.getLooper()));
            try {
                a((com.google.android.gms.common.api.Api.a) a);
            } catch (RemoteException e) {
                a(e);
                throw e;
            } catch (RemoteException e2) {
                a(e2);
            }
        }

        public final com.google.android.gms.common.api.Api.c<A> eB() {
            return this.Dn;
        }

        protected void eD() {
            super.eD();
            if (this.Dy != null) {
                this.Dy.b(this);
                this.Dy = null;
            }
        }

        public int eG() {
            return 0;
        }

        public final void m(Status status) {
            hm.b(!status.isSuccess(), (Object) "Failed result must not be success");
            a(c(status));
        }
    }

    static void a(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (Throwable e) {
                Log.w("GoogleApi", "Unable to release " + result, e);
            }
        }
    }
}
