package lip.com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.c.j;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class co implements e {
    private String aeP;
    private final String aet;
    private bg<j> agN;
    private r agO;
    private final ScheduledExecutorService agQ;
    private final a agR;
    private ScheduledFuture<?> agS;
    private boolean mClosed;
    private final Context mContext;

    interface a {
        cn a(r rVar);
    }

    interface b {
        ScheduledExecutorService mk();
    }

    public co(Context context, String str, r rVar) {
        this(context, str, rVar, null, null);
    }

    co(Context context, String str, r rVar, b bVar, a aVar) {
        this.agO = rVar;
        this.mContext = context;
        this.aet = str;
        if (bVar == null) {
            bVar = new b() {
                public ScheduledExecutorService mk() {
                    return Executors.newSingleThreadScheduledExecutor();
                }
            };
        }
        this.agQ = bVar.mk();
        if (aVar == null) {
            this.agR = new a() {
                public cn a(r rVar) {
                    return new cn(co.this.mContext, co.this.aet, rVar);
                }
            };
        } else {
            this.agR = aVar;
        }
    }

    private cn cc(String str) {
        cn a = this.agR.a(this.agO);
        a.a(this.agN);
        a.bM(this.aeP);
        a.cb(str);
        return a;
    }

    private synchronized void mj() {
        if (this.mClosed) {
            throw new IllegalStateException("called method after closed");
        }
    }

    public synchronized void a(bg<j> bgVar) {
        mj();
        this.agN = bgVar;
    }

    public synchronized void bM(String str) {
        mj();
        this.aeP = str;
    }

    public synchronized void e(long j, String str) {
        bh.C("loadAfterDelay: containerId=" + this.aet + " delay=" + j);
        mj();
        if (this.agN == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        if (this.agS != null) {
            this.agS.cancel(false);
        }
        this.agS = this.agQ.schedule(cc(str), j, TimeUnit.MILLISECONDS);
    }

    public synchronized void release() {
        mj();
        if (this.agS != null) {
            this.agS.cancel(false);
        }
        this.agQ.shutdown();
        this.mClosed = true;
    }
}
