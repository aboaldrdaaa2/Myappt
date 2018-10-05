package lip.com.google.android.gms.analytics;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.fd;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

class s implements ag, com.google.android.gms.analytics.c.b, com.google.android.gms.analytics.c.c {
    private final Context mContext;
    private d tU;
    private final f tV;
    private boolean tX;
    private volatile long uh;
    private volatile a ui;
    private volatile b uj;
    private d uk;
    private final GoogleAnalytics ul;
    private final Queue<d> um;
    private volatile int un;
    private volatile Timer uo;
    private volatile Timer up;
    private volatile Timer uq;
    private boolean ur;
    private boolean us;
    private boolean ut;
    private i uu;
    private long uv;

    private enum a {
        CONNECTING,
        CONNECTED_SERVICE,
        CONNECTED_LOCAL,
        BLOCKED,
        PENDING_CONNECTION,
        PENDING_DISCONNECT,
        DISCONNECTED
    }

    private class b extends TimerTask {
        private b() {
        }

        /* synthetic */ b(s sVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void run() {
            if (s.this.ui == a.CONNECTED_SERVICE && s.this.um.isEmpty() && s.this.uh + s.this.uv < s.this.uu.currentTimeMillis()) {
                aa.C("Disconnecting due to inactivity");
                s.this.bs();
                return;
            }
            s.this.uq.schedule(new b(), s.this.uv);
        }
    }

    private class c extends TimerTask {
        private c() {
        }

        /* synthetic */ c(s sVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void run() {
            if (s.this.ui == a.CONNECTING) {
                s.this.cO();
            }
        }
    }

    private static class d {
        private final Map<String, String> uG;
        private final long uH;
        private final String uI;
        private final List<fd> uJ;

        public d(Map<String, String> map, long j, String str, List<fd> list) {
            this.uG = map;
            this.uH = j;
            this.uI = str;
            this.uJ = list;
        }

        public Map<String, String> cR() {
            return this.uG;
        }

        public long cS() {
            return this.uH;
        }

        public List<fd> cT() {
            return this.uJ;
        }

        public String getPath() {
            return this.uI;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PATH: ");
            stringBuilder.append(this.uI);
            if (this.uG != null) {
                stringBuilder.append("  PARAMS: ");
                for (Entry entry : this.uG.entrySet()) {
                    stringBuilder.append((String) entry.getKey());
                    stringBuilder.append("=");
                    stringBuilder.append((String) entry.getValue());
                    stringBuilder.append(",  ");
                }
            }
            return stringBuilder.toString();
        }
    }

    private class e extends TimerTask {
        private e() {
        }

        /* synthetic */ e(s sVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void run() {
            s.this.cP();
        }
    }

    s(Context context, f fVar) {
        this(context, fVar, null, GoogleAnalytics.getInstance(context));
    }

    s(Context context, f fVar, d dVar, GoogleAnalytics googleAnalytics) {
        this.um = new ConcurrentLinkedQueue();
        this.uv = 300000;
        this.uk = dVar;
        this.mContext = context;
        this.tV = fVar;
        this.ul = googleAnalytics;
        this.uu = new i() {
            public long currentTimeMillis() {
                return System.currentTimeMillis();
            }
        };
        this.un = 0;
        this.ui = a.DISCONNECTED;
    }

    private Timer a(Timer timer) {
        if (timer != null) {
            timer.cancel();
        }
        return null;
    }

    private synchronized void bs() {
        if (this.uj != null && this.ui == a.CONNECTED_SERVICE) {
            this.ui = a.PENDING_DISCONNECT;
            this.uj.disconnect();
        }
    }

    private void cK() {
        this.uo = a(this.uo);
        this.up = a(this.up);
        this.uq = a(this.uq);
    }

    /* JADX WARNING: Missing block: B:31:0x00d0, code:
            r7.uh = r7.uu.currentTimeMillis();
     */
    private synchronized void cM() {
        /*
        r7 = this;
        monitor-enter(r7);
        r1 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0074 }
        r2 = r7.tV;	 Catch:{ all -> 0x0074 }
        r2 = r2.getThread();	 Catch:{ all -> 0x0074 }
        r1 = r1.equals(r2);	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x0021;
    L_0x0011:
        r1 = r7.tV;	 Catch:{ all -> 0x0074 }
        r1 = r1.ct();	 Catch:{ all -> 0x0074 }
        r2 = new com.google.android.gms.analytics.s$2;	 Catch:{ all -> 0x0074 }
        r2.<init>();	 Catch:{ all -> 0x0074 }
        r1.add(r2);	 Catch:{ all -> 0x0074 }
    L_0x001f:
        monitor-exit(r7);
        return;
    L_0x0021:
        r1 = r7.ur;	 Catch:{ all -> 0x0074 }
        if (r1 == 0) goto L_0x0028;
    L_0x0025:
        r7.cl();	 Catch:{ all -> 0x0074 }
    L_0x0028:
        r1 = com.google.android.gms.analytics.s.AnonymousClass3.ux;	 Catch:{ all -> 0x0074 }
        r2 = r7.ui;	 Catch:{ all -> 0x0074 }
        r2 = r2.ordinal();	 Catch:{ all -> 0x0074 }
        r1 = r1[r2];	 Catch:{ all -> 0x0074 }
        switch(r1) {
            case 1: goto L_0x0036;
            case 2: goto L_0x007f;
            case 3: goto L_0x0035;
            case 4: goto L_0x0035;
            case 5: goto L_0x0035;
            case 6: goto L_0x00da;
            default: goto L_0x0035;
        };	 Catch:{ all -> 0x0074 }
    L_0x0035:
        goto L_0x001f;
    L_0x0036:
        r1 = r7.um;	 Catch:{ all -> 0x0074 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x0077;
    L_0x003e:
        r1 = r7.um;	 Catch:{ all -> 0x0074 }
        r1 = r1.poll();	 Catch:{ all -> 0x0074 }
        r0 = r1;
        r0 = (com.google.android.gms.analytics.s.d) r0;	 Catch:{ all -> 0x0074 }
        r6 = r0;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0074 }
        r1.<init>();	 Catch:{ all -> 0x0074 }
        r2 = "Sending hit to store  ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0074 }
        r1 = r1.append(r6);	 Catch:{ all -> 0x0074 }
        r1 = r1.toString();	 Catch:{ all -> 0x0074 }
        com.google.android.gms.analytics.aa.C(r1);	 Catch:{ all -> 0x0074 }
        r1 = r7.tU;	 Catch:{ all -> 0x0074 }
        r2 = r6.cR();	 Catch:{ all -> 0x0074 }
        r3 = r6.cS();	 Catch:{ all -> 0x0074 }
        r5 = r6.getPath();	 Catch:{ all -> 0x0074 }
        r6 = r6.cT();	 Catch:{ all -> 0x0074 }
        r1.a(r2, r3, r5, r6);	 Catch:{ all -> 0x0074 }
        goto L_0x0036;
    L_0x0074:
        r1 = move-exception;
        monitor-exit(r7);
        throw r1;
    L_0x0077:
        r1 = r7.tX;	 Catch:{ all -> 0x0074 }
        if (r1 == 0) goto L_0x001f;
    L_0x007b:
        r7.cN();	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
    L_0x007f:
        r1 = r7.um;	 Catch:{ all -> 0x0074 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x00d0;
    L_0x0087:
        r1 = r7.um;	 Catch:{ all -> 0x0074 }
        r1 = r1.peek();	 Catch:{ all -> 0x0074 }
        r0 = r1;
        r0 = (com.google.android.gms.analytics.s.d) r0;	 Catch:{ all -> 0x0074 }
        r6 = r0;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0074 }
        r1.<init>();	 Catch:{ all -> 0x0074 }
        r2 = "Sending hit to service   ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0074 }
        r1 = r1.append(r6);	 Catch:{ all -> 0x0074 }
        r1 = r1.toString();	 Catch:{ all -> 0x0074 }
        com.google.android.gms.analytics.aa.C(r1);	 Catch:{ all -> 0x0074 }
        r1 = r7.ul;	 Catch:{ all -> 0x0074 }
        r1 = r1.isDryRunEnabled();	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x00ca;
    L_0x00af:
        r1 = r7.uj;	 Catch:{ all -> 0x0074 }
        r2 = r6.cR();	 Catch:{ all -> 0x0074 }
        r3 = r6.cS();	 Catch:{ all -> 0x0074 }
        r5 = r6.getPath();	 Catch:{ all -> 0x0074 }
        r6 = r6.cT();	 Catch:{ all -> 0x0074 }
        r1.a(r2, r3, r5, r6);	 Catch:{ all -> 0x0074 }
    L_0x00c4:
        r1 = r7.um;	 Catch:{ all -> 0x0074 }
        r1.poll();	 Catch:{ all -> 0x0074 }
        goto L_0x007f;
    L_0x00ca:
        r1 = "Dry run enabled. Hit not actually sent to service.";
        com.google.android.gms.analytics.aa.C(r1);	 Catch:{ all -> 0x0074 }
        goto L_0x00c4;
    L_0x00d0:
        r1 = r7.uu;	 Catch:{ all -> 0x0074 }
        r1 = r1.currentTimeMillis();	 Catch:{ all -> 0x0074 }
        r7.uh = r1;	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
    L_0x00da:
        r1 = "Need to reconnect";
        com.google.android.gms.analytics.aa.C(r1);	 Catch:{ all -> 0x0074 }
        r1 = r7.um;	 Catch:{ all -> 0x0074 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x001f;
    L_0x00e7:
        r7.cP();	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.s.cM():void");
    }

    private void cN() {
        this.tU.cq();
        this.tX = false;
    }

    private synchronized void cO() {
        if (this.ui != a.CONNECTED_LOCAL) {
            cK();
            aa.C("falling back to local store");
            if (this.uk != null) {
                this.tU = this.uk;
            } else {
                r cE = r.cE();
                cE.a(this.mContext, this.tV);
                this.tU = cE.cH();
            }
            this.ui = a.CONNECTED_LOCAL;
            cM();
        }
    }

    private synchronized void cP() {
        if (this.ut || this.uj == null || this.ui == a.CONNECTED_LOCAL) {
            aa.D("client not initialized.");
            cO();
        } else {
            try {
                this.un++;
                a(this.up);
                this.ui = a.CONNECTING;
                this.up = new Timer("Failed Connect");
                this.up.schedule(new c(this, null), 3000);
                aa.C("connecting to Analytics service");
                this.uj.connect();
            } catch (SecurityException e) {
                aa.D("security exception on connectToService");
                cO();
            }
        }
        return;
    }

    private void cQ() {
        this.uo = a(this.uo);
        this.uo = new Timer("Service Reconnect");
        this.uo.schedule(new e(this, null), 5000);
    }

    public synchronized void a(int i, Intent intent) {
        this.ui = a.PENDING_CONNECTION;
        if (this.un < 2) {
            aa.D("Service unavailable (code=" + i + "), will retry.");
            cQ();
        } else {
            aa.D("Service unavailable (code=" + i + "), using local store.");
            cO();
        }
    }

    public void b(Map<String, String> map, long j, String str, List<fd> list) {
        aa.C("putHit called");
        this.um.add(new d(map, j, str, list));
        cM();
    }

    public void cL() {
        if (this.uj == null) {
            this.uj = new c(this.mContext, this, this);
            cP();
        }
    }

    public void cl() {
        aa.C("clearHits called");
        this.um.clear();
        switch (this.ui) {
            case CONNECTED_LOCAL:
                this.tU.l(0);
                this.ur = false;
                return;
            case CONNECTED_SERVICE:
                this.uj.cl();
                this.ur = false;
                return;
            default:
                this.ur = true;
                return;
        }
    }

    public void cq() {
        switch (this.ui) {
            case CONNECTED_LOCAL:
                cN();
                return;
            case CONNECTED_SERVICE:
                return;
            default:
                this.tX = true;
                return;
        }
    }

    public synchronized void cs() {
        if (!this.ut) {
            aa.C("setForceLocalDispatch called.");
            this.ut = true;
            switch (this.ui) {
                case CONNECTED_SERVICE:
                    bs();
                    break;
                case CONNECTING:
                    this.us = true;
                    break;
            }
        }
    }

    public synchronized void onConnected() {
        this.up = a(this.up);
        this.un = 0;
        aa.C("Connected to service");
        this.ui = a.CONNECTED_SERVICE;
        if (this.us) {
            bs();
            this.us = false;
        } else {
            cM();
            this.uq = a(this.uq);
            this.uq = new Timer("disconnect check");
            this.uq.schedule(new b(this, null), this.uv);
        }
    }

    public synchronized void onDisconnected() {
        if (this.ui == a.PENDING_DISCONNECT) {
            aa.C("Disconnected from service");
            cK();
            this.ui = a.DISCONNECTED;
        } else {
            aa.C("Unexpected disconnect.");
            this.ui = a.PENDING_CONNECTION;
            if (this.un < 2) {
                cQ();
            } else {
                cO();
            }
        }
    }
}
