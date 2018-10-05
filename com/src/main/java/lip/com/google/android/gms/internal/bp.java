package lip.com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.bq.a;

public final class bp implements a {
    private final bt kB;
    private final ai lh;
    private final Object ls = new Object();
    private final Context mContext;
    private final String nC;
    private final long nD;
    private final bl nE;
    private final al nF;
    private final ev nG;
    private bu nH;
    private int nI = -2;

    public bp(Context context, String str, bt btVar, bm bmVar, bl blVar, ai aiVar, al alVar, ev evVar) {
        this.mContext = context;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            this.nC = b(blVar);
        } else {
            this.nC = str;
        }
        this.kB = btVar;
        this.nD = bmVar.ns != -1 ? bmVar.ns : 10000;
        this.nE = blVar;
        this.lh = aiVar;
        this.nF = alVar;
        this.nG = evVar;
    }

    private void a(long j, long j2, long j3, long j4) {
        while (this.nI == -2) {
            b(j, j2, j3, j4);
        }
    }

    private void a(bo boVar) {
        try {
            if (this.nG.sy < 4100000) {
                if (this.nF.mf) {
                    this.nH.a(e.h(this.mContext), this.lh, this.nE.nq, boVar);
                } else {
                    this.nH.a(e.h(this.mContext), this.nF, this.lh, this.nE.nq, (bv) boVar);
                }
            } else if (this.nF.mf) {
                this.nH.a(e.h(this.mContext), this.lh, this.nE.nq, this.nE.nk, (bv) boVar);
            } else {
                this.nH.a(e.h(this.mContext), this.nF, this.lh, this.nE.nq, this.nE.nk, boVar);
            }
        } catch (Throwable e) {
            eu.c("Could not request ad from mediation adapter.", e);
            g(5);
        }
    }

    private bu aP() {
        eu.B("Instantiating mediation adapter: " + this.nC);
        try {
            return this.kB.m(this.nC);
        } catch (Throwable e) {
            eu.a("Could not instantiate mediation adapter: " + this.nC, e);
            return null;
        }
    }

    private String b(bl blVar) {
        try {
            if (!TextUtils.isEmpty(blVar.no)) {
                if (CustomEvent.class.isAssignableFrom(Class.forName(blVar.no, false, bp.class.getClassLoader()))) {
                    return "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
                }
            }
        } catch (ClassNotFoundException e) {
            eu.D("Could not create custom event adapter.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    private void b(long j, long j2, long j3, long j4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = j2 - (elapsedRealtime - j);
        elapsedRealtime = j4 - (elapsedRealtime - j3);
        if (j5 <= 0 || elapsedRealtime <= 0) {
            eu.B("Timed out waiting for adapter.");
            this.nI = 3;
            return;
        }
        try {
            this.ls.wait(Math.min(j5, elapsedRealtime));
        } catch (InterruptedException e) {
            this.nI = -1;
        }
    }

    public bq b(long j, long j2) {
        bq bqVar;
        synchronized (this.ls) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            final bo boVar = new bo();
            et.sv.post(new Runnable() {
                public void run() {
                    synchronized (bp.this.ls) {
                        if (bp.this.nI != -2) {
                            return;
                        }
                        bp.this.nH = bp.this.aP();
                        if (bp.this.nH == null) {
                            bp.this.g(4);
                            return;
                        }
                        boVar.a(bp.this);
                        bp.this.a(boVar);
                    }
                }
            });
            a(elapsedRealtime, this.nD, j, j2);
            bqVar = new bq(this.nE, this.nH, this.nC, boVar, this.nI);
        }
        return bqVar;
    }

    public void cancel() {
        synchronized (this.ls) {
            try {
                if (this.nH != null) {
                    this.nH.destroy();
                }
            } catch (Throwable e) {
                eu.c("Could not destroy mediation adapter.", e);
            }
            this.nI = -1;
            this.ls.notify();
        }
    }

    public void g(int i) {
        synchronized (this.ls) {
            this.nI = i;
            this.ls.notify();
        }
    }
}
