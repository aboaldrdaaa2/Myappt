package lip.com.google.android.gms.internal;

import android.content.Context;

public final class bk {
    private final bt kB;
    private final Object ls = new Object();
    private final Context mContext;
    private final ds ne;
    private final bm nf;
    private boolean ng = false;
    private bp nh;

    public bk(Context context, ds dsVar, bt btVar, bm bmVar) {
        this.mContext = context;
        this.ne = dsVar;
        this.kB = btVar;
        this.nf = bmVar;
    }

    /* JADX WARNING: Missing block: B:15:0x0080, code:
            r4 = r16.nh.b(r17, r19);
     */
    /* JADX WARNING: Missing block: B:16:0x008e, code:
            if (r4.nL != 0) goto L_0x0099;
     */
    /* JADX WARNING: Missing block: B:17:0x0090, code:
            com.google.android.gms.internal.eu.z("Adapter succeeded.");
     */
    /* JADX WARNING: Missing block: B:23:0x009b, code:
            if (r4.nN == null) goto L_0x0039;
     */
    /* JADX WARNING: Missing block: B:24:0x009d, code:
            com.google.android.gms.internal.et.sv.post(new com.google.android.gms.internal.bk.AnonymousClass1(r16));
     */
    /* JADX WARNING: Missing block: B:37:?, code:
            return r4;
     */
    public com.google.android.gms.internal.bq a(long r17, long r19) {
        /*
        r16 = this;
        r4 = "Starting mediation.";
        com.google.android.gms.internal.eu.z(r4);
        r0 = r16;
        r4 = r0.nf;
        r4 = r4.nr;
        r13 = r4.iterator();
    L_0x000f:
        r4 = r13.hasNext();
        if (r4 == 0) goto L_0x00aa;
    L_0x0015:
        r9 = r13.next();
        r9 = (com.google.android.gms.internal.bl) r9;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Trying mediation network: ";
        r4 = r4.append(r5);
        r5 = r9.nl;
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.google.android.gms.internal.eu.B(r4);
        r4 = r9.nm;
        r14 = r4.iterator();
    L_0x0039:
        r4 = r14.hasNext();
        if (r4 == 0) goto L_0x000f;
    L_0x003f:
        r6 = r14.next();
        r6 = (java.lang.String) r6;
        r0 = r16;
        r15 = r0.ls;
        monitor-enter(r15);
        r0 = r16;
        r4 = r0.ng;	 Catch:{ all -> 0x0096 }
        if (r4 == 0) goto L_0x0058;
    L_0x0050:
        r4 = new com.google.android.gms.internal.bq;	 Catch:{ all -> 0x0096 }
        r5 = -1;
        r4.<init>(r5);	 Catch:{ all -> 0x0096 }
        monitor-exit(r15);	 Catch:{ all -> 0x0096 }
    L_0x0057:
        return r4;
    L_0x0058:
        r4 = new com.google.android.gms.internal.bp;	 Catch:{ all -> 0x0096 }
        r0 = r16;
        r5 = r0.mContext;	 Catch:{ all -> 0x0096 }
        r0 = r16;
        r7 = r0.kB;	 Catch:{ all -> 0x0096 }
        r0 = r16;
        r8 = r0.nf;	 Catch:{ all -> 0x0096 }
        r0 = r16;
        r10 = r0.ne;	 Catch:{ all -> 0x0096 }
        r10 = r10.pX;	 Catch:{ all -> 0x0096 }
        r0 = r16;
        r11 = r0.ne;	 Catch:{ all -> 0x0096 }
        r11 = r11.kT;	 Catch:{ all -> 0x0096 }
        r0 = r16;
        r12 = r0.ne;	 Catch:{ all -> 0x0096 }
        r12 = r12.kQ;	 Catch:{ all -> 0x0096 }
        r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12);	 Catch:{ all -> 0x0096 }
        r0 = r16;
        r0.nh = r4;	 Catch:{ all -> 0x0096 }
        monitor-exit(r15);	 Catch:{ all -> 0x0096 }
        r0 = r16;
        r4 = r0.nh;
        r0 = r17;
        r2 = r19;
        r4 = r4.b(r0, r2);
        r5 = r4.nL;
        if (r5 != 0) goto L_0x0099;
    L_0x0090:
        r5 = "Adapter succeeded.";
        com.google.android.gms.internal.eu.z(r5);
        goto L_0x0057;
    L_0x0096:
        r4 = move-exception;
        monitor-exit(r15);	 Catch:{ all -> 0x0096 }
        throw r4;
    L_0x0099:
        r5 = r4.nN;
        if (r5 == 0) goto L_0x0039;
    L_0x009d:
        r5 = com.google.android.gms.internal.et.sv;
        r6 = new com.google.android.gms.internal.bk$1;
        r0 = r16;
        r6.<init>(r4);
        r5.post(r6);
        goto L_0x0039;
    L_0x00aa:
        r4 = new com.google.android.gms.internal.bq;
        r5 = 1;
        r4.<init>(r5);
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.bk.a(long, long):com.google.android.gms.internal.bq");
    }

    public void cancel() {
        synchronized (this.ls) {
            this.ng = true;
            if (this.nh != null) {
                this.nh.cancel();
            }
        }
    }
}
