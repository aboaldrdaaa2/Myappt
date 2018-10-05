package lip.com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import org.json.JSONException;

public class dn extends em implements com.google.android.gms.internal.dp.a, com.google.android.gms.internal.ey.a {
    private final bt kB;
    private final ex lN;
    private final Object ls = new Object();
    private final Context mContext;
    private bm nf;
    private final k pA;
    private em pB;
    private du pC;
    private boolean pD = false;
    private bk pE;
    private bq pF;
    private final com.google.android.gms.internal.dm.a px;
    private final Object py = new Object();
    private final com.google.android.gms.internal.ds.a pz;

    private static final class a extends Exception {
        private final int pJ;

        public a(String str, int i) {
            super(str);
            this.pJ = i;
        }

        public int getErrorCode() {
            return this.pJ;
        }
    }

    public dn(Context context, com.google.android.gms.internal.ds.a aVar, k kVar, ex exVar, bt btVar, com.google.android.gms.internal.dm.a aVar2) {
        this.kB = btVar;
        this.px = aVar2;
        this.lN = exVar;
        this.mContext = context;
        this.pz = aVar;
        this.pA = kVar;
    }

    private al a(ds dsVar) throws a {
        if (this.pC.qj == null) {
            throw new a("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.pC.qj.split("x");
        if (split.length != 2) {
            throw new a("Could not parse the ad size from the ad response: " + this.pC.qj, 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (al alVar : dsVar.kT.mg) {
                float f = this.mContext.getResources().getDisplayMetrics().density;
                int i = alVar.width == -1 ? (int) (((float) alVar.widthPixels) / f) : alVar.width;
                int i2 = alVar.height == -2 ? (int) (((float) alVar.heightPixels) / f) : alVar.height;
                if (parseInt == i && parseInt2 == i2) {
                    return new al(alVar, dsVar.kT.mg);
                }
            }
            throw new a("The ad size from the ad response was not one of the requested sizes: " + this.pC.qj, 0);
        } catch (NumberFormatException e) {
            throw new a("Could not parse the ad size from the ad response: " + this.pC.qj, 0);
        }
    }

    private void a(ds dsVar, long j) throws a {
        synchronized (this.py) {
            this.pE = new bk(this.mContext, dsVar, this.kB, this.nf);
        }
        this.pF = this.pE.a(j, 60000);
        switch (this.pF.nL) {
            case 0:
                return;
            case 1:
                throw new a("No fill from any mediation ad networks.", 3);
            default:
                throw new a("Unexpected mediation result: " + this.pF.nL, 0);
        }
    }

    private void bn() throws a {
        if (this.pC.errorCode != -3) {
            if (TextUtils.isEmpty(this.pC.qe)) {
                throw new a("No fill from ad server.", 3);
            } else if (this.pC.qg) {
                try {
                    this.nf = new bm(this.pC.qe);
                } catch (JSONException e) {
                    throw new a("Could not parse mediation config: " + this.pC.qe, 0);
                }
            }
        }
    }

    private boolean c(long j) throws a {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.ls.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new a("Ad request cancelled.", -1);
        }
    }

    private void e(long j) throws a {
        et.sv.post(new Runnable() {
            /* JADX WARNING: Missing block: B:16:?, code:
            return;
     */
            public void run() {
                /*
                r7 = this;
                r0 = com.google.android.gms.internal.dn.this;
                r6 = r0.ls;
                monitor-enter(r6);
                r0 = com.google.android.gms.internal.dn.this;	 Catch:{ all -> 0x005f }
                r0 = r0.pC;	 Catch:{ all -> 0x005f }
                r0 = r0.errorCode;	 Catch:{ all -> 0x005f }
                r1 = -2;
                if (r0 == r1) goto L_0x0014;
            L_0x0012:
                monitor-exit(r6);	 Catch:{ all -> 0x005f }
            L_0x0013:
                return;
            L_0x0014:
                r0 = com.google.android.gms.internal.dn.this;	 Catch:{ all -> 0x005f }
                r0 = r0.lN;	 Catch:{ all -> 0x005f }
                r0 = r0.cb();	 Catch:{ all -> 0x005f }
                r1 = com.google.android.gms.internal.dn.this;	 Catch:{ all -> 0x005f }
                r0.a(r1);	 Catch:{ all -> 0x005f }
                r0 = com.google.android.gms.internal.dn.this;	 Catch:{ all -> 0x005f }
                r0 = r0.pC;	 Catch:{ all -> 0x005f }
                r0 = r0.errorCode;	 Catch:{ all -> 0x005f }
                r1 = -3;
                if (r0 != r1) goto L_0x0062;
            L_0x002e:
                r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005f }
                r0.<init>();	 Catch:{ all -> 0x005f }
                r1 = "Loading URL in WebView: ";
                r0 = r0.append(r1);	 Catch:{ all -> 0x005f }
                r1 = com.google.android.gms.internal.dn.this;	 Catch:{ all -> 0x005f }
                r1 = r1.pC;	 Catch:{ all -> 0x005f }
                r1 = r1.oA;	 Catch:{ all -> 0x005f }
                r0 = r0.append(r1);	 Catch:{ all -> 0x005f }
                r0 = r0.toString();	 Catch:{ all -> 0x005f }
                com.google.android.gms.internal.eu.C(r0);	 Catch:{ all -> 0x005f }
                r0 = com.google.android.gms.internal.dn.this;	 Catch:{ all -> 0x005f }
                r0 = r0.lN;	 Catch:{ all -> 0x005f }
                r1 = com.google.android.gms.internal.dn.this;	 Catch:{ all -> 0x005f }
                r1 = r1.pC;	 Catch:{ all -> 0x005f }
                r1 = r1.oA;	 Catch:{ all -> 0x005f }
                r0.loadUrl(r1);	 Catch:{ all -> 0x005f }
            L_0x005d:
                monitor-exit(r6);	 Catch:{ all -> 0x005f }
                goto L_0x0013;
            L_0x005f:
                r0 = move-exception;
                monitor-exit(r6);	 Catch:{ all -> 0x005f }
                throw r0;
            L_0x0062:
                r0 = "Loading HTML in WebView.";
                com.google.android.gms.internal.eu.C(r0);	 Catch:{ all -> 0x005f }
                r0 = com.google.android.gms.internal.dn.this;	 Catch:{ all -> 0x005f }
                r0 = r0.lN;	 Catch:{ all -> 0x005f }
                r1 = com.google.android.gms.internal.dn.this;	 Catch:{ all -> 0x005f }
                r1 = r1.pC;	 Catch:{ all -> 0x005f }
                r1 = r1.oA;	 Catch:{ all -> 0x005f }
                r1 = com.google.android.gms.internal.eo.v(r1);	 Catch:{ all -> 0x005f }
                r2 = com.google.android.gms.internal.dn.this;	 Catch:{ all -> 0x005f }
                r2 = r2.pC;	 Catch:{ all -> 0x005f }
                r2 = r2.qe;	 Catch:{ all -> 0x005f }
                r3 = "text/html";
                r4 = "UTF-8";
                r5 = 0;
                r0.loadDataWithBaseURL(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x005f }
                goto L_0x005d;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.dn.3.run():void");
            }
        });
        h(j);
    }

    private void g(long j) throws a {
        while (c(j)) {
            if (this.pC != null) {
                synchronized (this.py) {
                    this.pB = null;
                }
                if (this.pC.errorCode != -2 && this.pC.errorCode != -3) {
                    throw new a("There was a problem getting an ad response. ErrorCode: " + this.pC.errorCode, this.pC.errorCode);
                }
                return;
            }
        }
        throw new a("Timed out waiting for ad response.", 2);
    }

    private void h(long j) throws a {
        while (c(j)) {
            if (this.pD) {
                return;
            }
        }
        throw new a("Timed out waiting for WebView to finish loading.", 2);
    }

    public void a(du duVar) {
        synchronized (this.ls) {
            eu.z("Received ad response.");
            this.pC = duVar;
            this.ls.notify();
        }
    }

    public void a(ex exVar) {
        synchronized (this.ls) {
            eu.z("WebView finished loading.");
            this.pD = true;
            this.ls.notify();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:73:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d9 A:{Catch:{ Exception -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e5 A:{Catch:{ Exception -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f3 A:{Catch:{ Exception -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x010d A:{Catch:{ Exception -> 0x01b7 }} */
    public void bh() {
        /*
        r31 = this;
        r0 = r31;
        r0 = r0.ls;
        r30 = r0;
        monitor-enter(r30);
        r2 = "AdLoaderBackgroundTask started.";
        com.google.android.gms.internal.eu.z(r2);	 Catch:{ all -> 0x0194 }
        r0 = r31;
        r2 = r0.pA;	 Catch:{ all -> 0x0194 }
        r2 = r2.z();	 Catch:{ all -> 0x0194 }
        r0 = r31;
        r3 = r0.mContext;	 Catch:{ all -> 0x0194 }
        r3 = r2.b(r3);	 Catch:{ all -> 0x0194 }
        r0 = r31;
        r4 = r0.mContext;	 Catch:{ all -> 0x0194 }
        r2 = r2.a(r4);	 Catch:{ all -> 0x0194 }
        r12 = new com.google.android.gms.internal.ds;	 Catch:{ all -> 0x0194 }
        r0 = r31;
        r4 = r0.pz;	 Catch:{ all -> 0x0194 }
        r12.<init>(r4, r3, r2);	 Catch:{ all -> 0x0194 }
        r5 = 0;
        r6 = -2;
        r3 = -1;
        r7 = android.os.SystemClock.elapsedRealtime();	 Catch:{ a -> 0x005a }
        r0 = r31;
        r2 = r0.mContext;	 Catch:{ a -> 0x005a }
        r0 = r31;
        r2 = com.google.android.gms.internal.dp.a(r2, r12, r0);	 Catch:{ a -> 0x005a }
        r0 = r31;
        r9 = r0.py;	 Catch:{ a -> 0x005a }
        monitor-enter(r9);	 Catch:{ a -> 0x005a }
        r0 = r31;
        r0.pB = r2;	 Catch:{ all -> 0x0057 }
        r0 = r31;
        r2 = r0.pB;	 Catch:{ all -> 0x0057 }
        if (r2 != 0) goto L_0x015a;
    L_0x004e:
        r2 = new com.google.android.gms.internal.dn$a;	 Catch:{ all -> 0x0057 }
        r6 = "Could not start the ad request service.";
        r7 = 0;
        r2.<init>(r6, r7);	 Catch:{ all -> 0x0057 }
        throw r2;	 Catch:{ all -> 0x0057 }
    L_0x0057:
        r2 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x0057 }
        throw r2;	 Catch:{ a -> 0x005a }
    L_0x005a:
        r2 = move-exception;
        r6 = r2.getErrorCode();	 Catch:{ all -> 0x0194 }
        r7 = 3;
        if (r6 == r7) goto L_0x0065;
    L_0x0062:
        r7 = -1;
        if (r6 != r7) goto L_0x019d;
    L_0x0065:
        r2 = r2.getMessage();	 Catch:{ all -> 0x0194 }
        com.google.android.gms.internal.eu.B(r2);	 Catch:{ all -> 0x0194 }
    L_0x006c:
        r0 = r31;
        r2 = r0.pC;	 Catch:{ all -> 0x0194 }
        if (r2 != 0) goto L_0x01a6;
    L_0x0072:
        r2 = new com.google.android.gms.internal.du;	 Catch:{ all -> 0x0194 }
        r2.<init>(r6);	 Catch:{ all -> 0x0194 }
        r0 = r31;
        r0.pC = r2;	 Catch:{ all -> 0x0194 }
    L_0x007b:
        r2 = com.google.android.gms.internal.et.sv;	 Catch:{ all -> 0x0194 }
        r7 = new com.google.android.gms.internal.dn$1;	 Catch:{ all -> 0x0194 }
        r0 = r31;
        r7.<init>();	 Catch:{ all -> 0x0194 }
        r2.post(r7);	 Catch:{ all -> 0x0194 }
        r24 = r3;
        r21 = r5;
    L_0x008b:
        r3 = 0;
        r0 = r31;
        r2 = r0.pC;	 Catch:{ all -> 0x0194 }
        r2 = r2.qo;	 Catch:{ all -> 0x0194 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x0194 }
        if (r2 != 0) goto L_0x01bd;
    L_0x0098:
        r29 = new org.json.JSONObject;	 Catch:{ Exception -> 0x01b7 }
        r0 = r31;
        r2 = r0.pC;	 Catch:{ Exception -> 0x01b7 }
        r2 = r2.qo;	 Catch:{ Exception -> 0x01b7 }
        r0 = r29;
        r0.<init>(r2);	 Catch:{ Exception -> 0x01b7 }
    L_0x00a5:
        r2 = new com.google.android.gms.internal.ef;	 Catch:{ all -> 0x0194 }
        r3 = r12.pX;	 Catch:{ all -> 0x0194 }
        r0 = r31;
        r4 = r0.lN;	 Catch:{ all -> 0x0194 }
        r0 = r31;
        r5 = r0.pC;	 Catch:{ all -> 0x0194 }
        r5 = r5.nt;	 Catch:{ all -> 0x0194 }
        r0 = r31;
        r7 = r0.pC;	 Catch:{ all -> 0x0194 }
        r7 = r7.nu;	 Catch:{ all -> 0x0194 }
        r0 = r31;
        r8 = r0.pC;	 Catch:{ all -> 0x0194 }
        r8 = r8.qi;	 Catch:{ all -> 0x0194 }
        r0 = r31;
        r9 = r0.pC;	 Catch:{ all -> 0x0194 }
        r9 = r9.orientation;	 Catch:{ all -> 0x0194 }
        r0 = r31;
        r10 = r0.pC;	 Catch:{ all -> 0x0194 }
        r10 = r10.nx;	 Catch:{ all -> 0x0194 }
        r12 = r12.qa;	 Catch:{ all -> 0x0194 }
        r0 = r31;
        r13 = r0.pC;	 Catch:{ all -> 0x0194 }
        r13 = r13.qg;	 Catch:{ all -> 0x0194 }
        r0 = r31;
        r14 = r0.pF;	 Catch:{ all -> 0x0194 }
        if (r14 == 0) goto L_0x01c1;
    L_0x00d9:
        r0 = r31;
        r14 = r0.pF;	 Catch:{ all -> 0x0194 }
        r14 = r14.nM;	 Catch:{ all -> 0x0194 }
    L_0x00df:
        r0 = r31;
        r15 = r0.pF;	 Catch:{ all -> 0x0194 }
        if (r15 == 0) goto L_0x01c4;
    L_0x00e5:
        r0 = r31;
        r15 = r0.pF;	 Catch:{ all -> 0x0194 }
        r15 = r15.nN;	 Catch:{ all -> 0x0194 }
    L_0x00eb:
        r0 = r31;
        r0 = r0.pF;	 Catch:{ all -> 0x0194 }
        r16 = r0;
        if (r16 == 0) goto L_0x01c7;
    L_0x00f3:
        r0 = r31;
        r0 = r0.pF;	 Catch:{ all -> 0x0194 }
        r16 = r0;
        r0 = r16;
        r0 = r0.nO;	 Catch:{ all -> 0x0194 }
        r16 = r0;
    L_0x00ff:
        r0 = r31;
        r0 = r0.nf;	 Catch:{ all -> 0x0194 }
        r17 = r0;
        r0 = r31;
        r0 = r0.pF;	 Catch:{ all -> 0x0194 }
        r18 = r0;
        if (r18 == 0) goto L_0x01cb;
    L_0x010d:
        r0 = r31;
        r0 = r0.pF;	 Catch:{ all -> 0x0194 }
        r18 = r0;
        r0 = r18;
        r0 = r0.nP;	 Catch:{ all -> 0x0194 }
        r18 = r0;
    L_0x0119:
        r0 = r31;
        r0 = r0.pC;	 Catch:{ all -> 0x0194 }
        r19 = r0;
        r0 = r19;
        r0 = r0.qh;	 Catch:{ all -> 0x0194 }
        r19 = r0;
        r0 = r31;
        r0 = r0.pC;	 Catch:{ all -> 0x0194 }
        r22 = r0;
        r0 = r22;
        r0 = r0.qf;	 Catch:{ all -> 0x0194 }
        r22 = r0;
        r0 = r31;
        r0 = r0.pC;	 Catch:{ all -> 0x0194 }
        r26 = r0;
        r0 = r26;
        r0 = r0.qk;	 Catch:{ all -> 0x0194 }
        r26 = r0;
        r0 = r31;
        r0 = r0.pC;	 Catch:{ all -> 0x0194 }
        r28 = r0;
        r0 = r28;
        r0 = r0.ql;	 Catch:{ all -> 0x0194 }
        r28 = r0;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16, r17, r18, r19, r21, r22, r24, r26, r28, r29);	 Catch:{ all -> 0x0194 }
        r3 = com.google.android.gms.internal.et.sv;	 Catch:{ all -> 0x0194 }
        r4 = new com.google.android.gms.internal.dn$2;	 Catch:{ all -> 0x0194 }
        r0 = r31;
        r4.<init>(r2);	 Catch:{ all -> 0x0194 }
        r3.post(r4);	 Catch:{ all -> 0x0194 }
        monitor-exit(r30);	 Catch:{ all -> 0x0194 }
        return;
    L_0x015a:
        monitor-exit(r9);	 Catch:{ all -> 0x0057 }
        r0 = r31;
        r0.g(r7);	 Catch:{ a -> 0x005a }
        r3 = android.os.SystemClock.elapsedRealtime();	 Catch:{ a -> 0x005a }
        r31.bn();	 Catch:{ a -> 0x005a }
        r2 = r12.kT;	 Catch:{ a -> 0x005a }
        r2 = r2.mg;	 Catch:{ a -> 0x005a }
        if (r2 == 0) goto L_0x0173;
    L_0x016d:
        r0 = r31;
        r5 = r0.a(r12);	 Catch:{ a -> 0x005a }
    L_0x0173:
        r0 = r31;
        r2 = r0.pC;	 Catch:{ a -> 0x005a }
        r2 = r2.qg;	 Catch:{ a -> 0x005a }
        if (r2 == 0) goto L_0x0186;
    L_0x017b:
        r0 = r31;
        r0.a(r12, r7);	 Catch:{ a -> 0x005a }
    L_0x0180:
        r24 = r3;
        r21 = r5;
        goto L_0x008b;
    L_0x0186:
        r0 = r31;
        r2 = r0.pC;	 Catch:{ a -> 0x005a }
        r2 = r2.qm;	 Catch:{ a -> 0x005a }
        if (r2 == 0) goto L_0x0197;
    L_0x018e:
        r0 = r31;
        r0.f(r7);	 Catch:{ a -> 0x005a }
        goto L_0x0180;
    L_0x0194:
        r2 = move-exception;
        monitor-exit(r30);	 Catch:{ all -> 0x0194 }
        throw r2;
    L_0x0197:
        r0 = r31;
        r0.e(r7);	 Catch:{ a -> 0x005a }
        goto L_0x0180;
    L_0x019d:
        r2 = r2.getMessage();	 Catch:{ all -> 0x0194 }
        com.google.android.gms.internal.eu.D(r2);	 Catch:{ all -> 0x0194 }
        goto L_0x006c;
    L_0x01a6:
        r2 = new com.google.android.gms.internal.du;	 Catch:{ all -> 0x0194 }
        r0 = r31;
        r7 = r0.pC;	 Catch:{ all -> 0x0194 }
        r7 = r7.nx;	 Catch:{ all -> 0x0194 }
        r2.<init>(r6, r7);	 Catch:{ all -> 0x0194 }
        r0 = r31;
        r0.pC = r2;	 Catch:{ all -> 0x0194 }
        goto L_0x007b;
    L_0x01b7:
        r2 = move-exception;
        r4 = "Error parsing the JSON for Active View.";
        com.google.android.gms.internal.eu.b(r4, r2);	 Catch:{ all -> 0x0194 }
    L_0x01bd:
        r29 = r3;
        goto L_0x00a5;
    L_0x01c1:
        r14 = 0;
        goto L_0x00df;
    L_0x01c4:
        r15 = 0;
        goto L_0x00eb;
    L_0x01c7:
        r16 = 0;
        goto L_0x00ff;
    L_0x01cb:
        r18 = 0;
        goto L_0x0119;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.dn.bh():void");
    }

    protected void f(long j) throws a {
        int i;
        int i2;
        al V = this.lN.V();
        if (V.mf) {
            i = this.mContext.getResources().getDisplayMetrics().widthPixels;
            i2 = this.mContext.getResources().getDisplayMetrics().heightPixels;
        } else {
            i = V.widthPixels;
            i2 = V.heightPixels;
        }
        final do doVar = new do(this, this.lN, i, i2);
        et.sv.post(new Runnable() {
            public void run() {
                synchronized (dn.this.ls) {
                    if (dn.this.pC.errorCode != -2) {
                        return;
                    }
                    dn.this.lN.cb().a(dn.this);
                    doVar.b(dn.this.pC);
                }
            }
        });
        h(j);
        if (doVar.bq()) {
            eu.z("Ad-Network indicated no fill with passback URL.");
            throw new a("AdNetwork sent passback url", 3);
        } else if (!doVar.br()) {
            throw new a("AdNetwork timed out", 2);
        }
    }

    public void onStop() {
        synchronized (this.py) {
            if (this.pB != null) {
                this.pB.cancel();
            }
            this.lN.stopLoading();
            eo.a(this.lN);
            if (this.pE != null) {
                this.pE.cancel();
            }
        }
    }
}
