package lip.com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.c.j;
import com.google.android.gms.internal.ij;
import com.google.android.gms.internal.il;

class o extends com.google.android.gms.common.api.a.a<ContainerHolder> {
    private final Looper DF;
    private final TagManager aeF;
    private final d aeI;
    private final cf aeJ;
    private final int aeK;
    private f aeL;
    private volatile n aeM;
    private volatile boolean aeN;
    private j aeO;
    private String aeP;
    private e aeQ;
    private a aeR;
    private final ij aef;
    private final String aet;
    private long aey;
    private final Context mContext;

    interface a {
        boolean b(Container container);
    }

    private class b implements bg<com.google.android.gms.internal.le.a> {
        private b() {
        }

        /* synthetic */ b(o oVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: a */
        public void i(com.google.android.gms.internal.le.a aVar) {
            j jVar;
            if (aVar.aiH != null) {
                jVar = aVar.aiH;
            } else {
                com.google.android.gms.internal.c.f fVar = aVar.fK;
                jVar = new j();
                jVar.fK = fVar;
                jVar.fJ = null;
                jVar.fL = fVar.fg;
            }
            o.this.a(jVar, aVar.aiG, true);
        }

        public void a(com.google.android.gms.tagmanager.bg.a aVar) {
            if (!o.this.aeN) {
                o.this.w(0);
            }
        }

        public void lv() {
        }
    }

    private class c implements bg<j> {
        private c() {
        }

        /* synthetic */ c(o oVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void a(com.google.android.gms.tagmanager.bg.a aVar) {
            if (o.this.aeM != null) {
                o.this.a(o.this.aeM);
            } else {
                o.this.a(o.this.c(Status.Eq));
            }
            o.this.w(3600000);
        }

        /* JADX WARNING: Missing block: B:18:?, code:
            return;
     */
        /* renamed from: b */
        public void i(com.google.android.gms.internal.c.j r6) {
            /*
            r5 = this;
            r1 = com.google.android.gms.tagmanager.o.this;
            monitor-enter(r1);
            r0 = r6.fK;	 Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x002a;
        L_0x0007:
            r0 = com.google.android.gms.tagmanager.o.this;	 Catch:{ all -> 0x0065 }
            r0 = r0.aeO;	 Catch:{ all -> 0x0065 }
            r0 = r0.fK;	 Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x0020;
        L_0x0011:
            r0 = "Current resource is null; network resource is also null";
            com.google.android.gms.tagmanager.bh.A(r0);	 Catch:{ all -> 0x0065 }
            r0 = com.google.android.gms.tagmanager.o.this;	 Catch:{ all -> 0x0065 }
            r2 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
            r0.w(r2);	 Catch:{ all -> 0x0065 }
            monitor-exit(r1);	 Catch:{ all -> 0x0065 }
        L_0x001f:
            return;
        L_0x0020:
            r0 = com.google.android.gms.tagmanager.o.this;	 Catch:{ all -> 0x0065 }
            r0 = r0.aeO;	 Catch:{ all -> 0x0065 }
            r0 = r0.fK;	 Catch:{ all -> 0x0065 }
            r6.fK = r0;	 Catch:{ all -> 0x0065 }
        L_0x002a:
            r0 = com.google.android.gms.tagmanager.o.this;	 Catch:{ all -> 0x0065 }
            r2 = com.google.android.gms.tagmanager.o.this;	 Catch:{ all -> 0x0065 }
            r2 = r2.aef;	 Catch:{ all -> 0x0065 }
            r2 = r2.currentTimeMillis();	 Catch:{ all -> 0x0065 }
            r4 = 0;
            r0.a(r6, r2, r4);	 Catch:{ all -> 0x0065 }
            r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0065 }
            r0.<init>();	 Catch:{ all -> 0x0065 }
            r2 = "setting refresh time to current time: ";
            r0 = r0.append(r2);	 Catch:{ all -> 0x0065 }
            r2 = com.google.android.gms.tagmanager.o.this;	 Catch:{ all -> 0x0065 }
            r2 = r2.aey;	 Catch:{ all -> 0x0065 }
            r0 = r0.append(r2);	 Catch:{ all -> 0x0065 }
            r0 = r0.toString();	 Catch:{ all -> 0x0065 }
            com.google.android.gms.tagmanager.bh.C(r0);	 Catch:{ all -> 0x0065 }
            r0 = com.google.android.gms.tagmanager.o.this;	 Catch:{ all -> 0x0065 }
            r0 = r0.lu();	 Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x0063;
        L_0x005e:
            r0 = com.google.android.gms.tagmanager.o.this;	 Catch:{ all -> 0x0065 }
            r0.a(r6);	 Catch:{ all -> 0x0065 }
        L_0x0063:
            monitor-exit(r1);	 Catch:{ all -> 0x0065 }
            goto L_0x001f;
        L_0x0065:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0065 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.o.c.b(com.google.android.gms.internal.c$j):void");
        }

        public void lv() {
        }
    }

    private class d implements com.google.android.gms.tagmanager.n.a {
        private d() {
        }

        /* synthetic */ d(o oVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void bJ(String str) {
            o.this.bJ(str);
        }

        public String lo() {
            return o.this.lo();
        }

        public void lq() {
            if (o.this.aeJ.do()) {
                o.this.w(0);
            }
        }
    }

    interface e extends Releasable {
        void a(bg<j> bgVar);

        void bM(String str);

        void e(long j, String str);
    }

    interface f extends Releasable {
        void a(bg<com.google.android.gms.internal.le.a> bgVar);

        void b(com.google.android.gms.internal.le.a aVar);

        com.google.android.gms.tagmanager.cq.c dn(int i);

        void lw();
    }

    o(Context context, TagManager tagManager, Looper looper, String str, int i, f fVar, e eVar, ij ijVar, cf cfVar) {
        super(looper == null ? Looper.getMainLooper() : looper);
        this.mContext = context;
        this.aeF = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.DF = looper;
        this.aet = str;
        this.aeK = i;
        this.aeL = fVar;
        this.aeQ = eVar;
        this.aeI = new d(this, null);
        this.aeO = new j();
        this.aef = ijVar;
        this.aeJ = cfVar;
        if (lu()) {
            bJ(cd.md().mf());
        }
    }

    public o(Context context, TagManager tagManager, Looper looper, String str, int i, r rVar) {
        this(context, tagManager, looper, str, i, new cp(context, str), new co(context, str, rVar), il.gb(), new bf(30, 900000, 5000, "refreshing", il.gb()));
    }

    private void H(final boolean z) {
        this.aeL.a(new b(this, null));
        this.aeQ.a(new c(this, null));
        com.google.android.gms.tagmanager.cq.c dn = this.aeL.dn(this.aeK);
        if (dn != null) {
            this.aeM = new n(this.aeF, this.DF, new Container(this.mContext, this.aeF.getDataLayer(), this.aet, 0, dn), this.aeI);
        }
        this.aeR = new a() {
            public boolean b(Container container) {
                return z ? container.getLastRefreshTime() + 43200000 >= o.this.aef.currentTimeMillis() : !container.isDefault();
            }
        };
        if (lu()) {
            this.aeQ.e(0, "");
        } else {
            this.aeL.lw();
        }
    }

    private synchronized void a(j jVar) {
        if (this.aeL != null) {
            com.google.android.gms.internal.le.a aVar = new com.google.android.gms.internal.le.a();
            aVar.aiG = this.aey;
            aVar.fK = new com.google.android.gms.internal.c.f();
            aVar.aiH = jVar;
            this.aeL.b(aVar);
        }
    }

    /* JADX WARNING: Missing block: B:5:0x0008, code:
            if (r8.aeN != false) goto L_0x000a;
     */
    private synchronized void a(com.google.android.gms.internal.c.j r9, long r10, boolean r12) {
        /*
        r8 = this;
        r6 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        monitor-enter(r8);
        if (r12 == 0) goto L_0x000c;
    L_0x0006:
        r0 = r8.aeN;	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r8);
        return;
    L_0x000c:
        r0 = r8.isReady();	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x0016;
    L_0x0012:
        r0 = r8.aeM;	 Catch:{ all -> 0x006a }
        if (r0 != 0) goto L_0x0016;
    L_0x0016:
        r8.aeO = r9;	 Catch:{ all -> 0x006a }
        r8.aey = r10;	 Catch:{ all -> 0x006a }
        r0 = 0;
        r2 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        r4 = r8.aey;	 Catch:{ all -> 0x006a }
        r4 = r4 + r6;
        r6 = r8.aef;	 Catch:{ all -> 0x006a }
        r6 = r6.currentTimeMillis();	 Catch:{ all -> 0x006a }
        r4 = r4 - r6;
        r2 = java.lang.Math.min(r2, r4);	 Catch:{ all -> 0x006a }
        r0 = java.lang.Math.max(r0, r2);	 Catch:{ all -> 0x006a }
        r8.w(r0);	 Catch:{ all -> 0x006a }
        r0 = new com.google.android.gms.tagmanager.Container;	 Catch:{ all -> 0x006a }
        r1 = r8.mContext;	 Catch:{ all -> 0x006a }
        r2 = r8.aeF;	 Catch:{ all -> 0x006a }
        r2 = r2.getDataLayer();	 Catch:{ all -> 0x006a }
        r3 = r8.aet;	 Catch:{ all -> 0x006a }
        r4 = r10;
        r6 = r9;
        r0.<init>(r1, r2, r3, r4, r6);	 Catch:{ all -> 0x006a }
        r1 = r8.aeM;	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x006d;
    L_0x0049:
        r1 = new com.google.android.gms.tagmanager.n;	 Catch:{ all -> 0x006a }
        r2 = r8.aeF;	 Catch:{ all -> 0x006a }
        r3 = r8.DF;	 Catch:{ all -> 0x006a }
        r4 = r8.aeI;	 Catch:{ all -> 0x006a }
        r1.<init>(r2, r3, r0, r4);	 Catch:{ all -> 0x006a }
        r8.aeM = r1;	 Catch:{ all -> 0x006a }
    L_0x0056:
        r1 = r8.isReady();	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x000a;
    L_0x005c:
        r1 = r8.aeR;	 Catch:{ all -> 0x006a }
        r0 = r1.b(r0);	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x000a;
    L_0x0064:
        r0 = r8.aeM;	 Catch:{ all -> 0x006a }
        r8.a(r0);	 Catch:{ all -> 0x006a }
        goto L_0x000a;
    L_0x006a:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x006d:
        r1 = r8.aeM;	 Catch:{ all -> 0x006a }
        r1.a(r0);	 Catch:{ all -> 0x006a }
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.o.a(com.google.android.gms.internal.c$j, long, boolean):void");
    }

    private boolean lu() {
        cd md = cd.md();
        return (md.me() == a.CONTAINER || md.me() == a.CONTAINER_DEBUG) && this.aet.equals(md.getContainerId());
    }

    private synchronized void w(long j) {
        if (this.aeQ == null) {
            bh.D("Refresh requested, but no network load scheduler.");
        } else {
            this.aeQ.e(j, this.aeO.fL);
        }
    }

    /* renamed from: ap */
    protected ContainerHolder c(Status status) {
        if (this.aeM != null) {
            return this.aeM;
        }
        if (status == Status.Eq) {
            bh.A("timer expired: setting result to failure");
        }
        return new n(status);
    }

    synchronized void bJ(String str) {
        this.aeP = str;
        if (this.aeQ != null) {
            this.aeQ.bM(str);
        }
    }

    synchronized String lo() {
        return this.aeP;
    }

    public void lr() {
        com.google.android.gms.tagmanager.cq.c dn = this.aeL.dn(this.aeK);
        if (dn != null) {
            a(new n(this.aeF, this.DF, new Container(this.mContext, this.aeF.getDataLayer(), this.aet, 0, dn), new com.google.android.gms.tagmanager.n.a() {
                public void bJ(String str) {
                    o.this.bJ(str);
                }

                public String lo() {
                    return o.this.lo();
                }

                public void lq() {
                    bh.D("Refresh ignored: container loaded as default only.");
                }
            }));
        } else {
            String str = "Default was requested, but no default container was found";
            bh.A(str);
            a(c(new Status(10, str, null)));
        }
        this.aeQ = null;
        this.aeL = null;
    }

    public void ls() {
        H(false);
    }

    public void lt() {
        H(true);
    }
}
