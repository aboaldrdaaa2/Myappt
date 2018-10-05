package lip.com.google.android.gms.internal;

import android.os.Handler;
import java.lang.ref.WeakReference;

public final class y {
    private final a lf;
    private final Runnable lg;
    private ai lh;
    private boolean li;
    private boolean lj;
    private long lk;

    public static class a {
        private final Handler mHandler;

        public a(Handler handler) {
            this.mHandler = handler;
        }

        public boolean postDelayed(Runnable runnable, long timeFromNowInMillis) {
            return this.mHandler.postDelayed(runnable, timeFromNowInMillis);
        }

        public void removeCallbacks(Runnable runnable) {
            this.mHandler.removeCallbacks(runnable);
        }
    }

    public y(u uVar) {
        this(uVar, new a(et.sv));
    }

    y(final u uVar, a aVar) {
        this.li = false;
        this.lj = false;
        this.lk = 0;
        this.lf = aVar;
        this.lg = new Runnable() {
            private final WeakReference<u> ll = new WeakReference(uVar);

            public void run() {
                y.this.li = false;
                u uVar = (u) this.ll.get();
                if (uVar != null) {
                    uVar.b(y.this.lh);
                }
            }
        };
    }

    public void a(ai aiVar, long j) {
        if (this.li) {
            eu.D("An ad refresh is already scheduled.");
            return;
        }
        this.lh = aiVar;
        this.li = true;
        this.lk = j;
        if (!this.lj) {
            eu.B("Scheduling ad refresh " + j + " milliseconds from now.");
            this.lf.postDelayed(this.lg, j);
        }
    }

    public void cancel() {
        this.li = false;
        this.lf.removeCallbacks(this.lg);
    }

    public void d(ai aiVar) {
        a(aiVar, 60000);
    }

    public void pause() {
        this.lj = true;
        if (this.li) {
            this.lf.removeCallbacks(this.lg);
        }
    }

    public void resume() {
        this.lj = false;
        if (this.li) {
            this.li = false;
            a(this.lh, this.lk);
        }
    }
}
