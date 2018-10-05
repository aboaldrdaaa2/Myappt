package lip.com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.google.android.gms.internal.dw.a;
import java.util.List;
import java.util.Map;

public final class dx extends a {
    private static final Object qp = new Object();
    private static dx qq;
    private final Context mContext;
    private final ed qr;
    private final bi qs;
    private final ay qt;

    dx(Context context, ay ayVar, bi biVar, ed edVar) {
        this.mContext = context;
        this.qr = edVar;
        this.qs = biVar;
        this.qt = ayVar;
    }

    private static du a(Context context, ay ayVar, bi biVar, ed edVar, ds dsVar) {
        eu.z("Starting ad request from service.");
        biVar.init();
        ec ecVar = new ec(context);
        if (ecVar.rm == -1) {
            eu.z("Device is offline.");
            return new du(2);
        }
        final dz dzVar = new dz(dsVar.applicationInfo.packageName);
        if (dsVar.pX.extras != null) {
            String string = dsVar.pX.extras.getString("_ad");
            if (string != null) {
                return dy.a(context, dsVar, string);
            }
        }
        Location a = biVar.a(250);
        final String aN = ayVar.aN();
        String a2 = dy.a(dsVar, ecVar, a, ayVar.aO());
        if (a2 == null) {
            return new du(0);
        }
        final ey.a s = s(a2);
        final Context context2 = context;
        final ds dsVar2 = dsVar;
        et.sv.post(new Runnable() {
            public void run() {
                ex a = ex.a(context2, new al(), false, false, null, dsVar2.kQ);
                a.setWillNotDraw(true);
                dzVar.b(a);
                ey cb = a.cb();
                cb.a("/invalidRequest", dzVar.qD);
                cb.a("/loadAdURL", dzVar.qE);
                cb.a("/log", bb.mZ);
                cb.a(s);
                eu.z("Loading the JS library.");
                a.loadUrl(aN);
            }
        });
        eb bx = dzVar.bx();
        if (bx == null || TextUtils.isEmpty(bx.getUrl())) {
            return new du(dzVar.getErrorCode());
        }
        a2 = null;
        if (bx.bA()) {
            a2 = edVar.u(dsVar.pY.packageName);
        }
        return a(context, dsVar.kQ.sw, bx.getUrl(), a2, bx);
    }

    /* JADX WARNING: Missing block: B:39:?, code:
            com.google.android.gms.internal.eu.D("Received error HTTP response code: " + r6);
            r1 = new com.google.android.gms.internal.du(0);
     */
    /* JADX WARNING: Missing block: B:41:?, code:
            r0.disconnect();
     */
    /* JADX WARNING: Missing block: B:62:?, code:
            return r1;
     */
    public static com.google.android.gms.internal.du a(Context r10, String r11, String r12, String r13, com.google.android.gms.internal.eb r14) {
        /*
        r9 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r0 = 0;
        r3 = new com.google.android.gms.internal.ea;	 Catch:{ IOException -> 0x00ee }
        r3.<init>();	 Catch:{ IOException -> 0x00ee }
        r1 = new java.net.URL;	 Catch:{ IOException -> 0x00ee }
        r1.<init>(r12);	 Catch:{ IOException -> 0x00ee }
        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ IOException -> 0x00ee }
        r2 = r1;
        r1 = r0;
    L_0x0013:
        r0 = r2.openConnection();	 Catch:{ IOException -> 0x00ee }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ IOException -> 0x00ee }
        r6 = 0;
        com.google.android.gms.internal.eo.a(r10, r11, r6, r0);	 Catch:{ all -> 0x0111 }
        r6 = android.text.TextUtils.isEmpty(r13);	 Catch:{ all -> 0x0111 }
        if (r6 != 0) goto L_0x0028;
    L_0x0023:
        r6 = "x-afma-drt-cookie";
        r0.addRequestProperty(r6, r13);	 Catch:{ all -> 0x0111 }
    L_0x0028:
        if (r14 == 0) goto L_0x0053;
    L_0x002a:
        r6 = r14.bz();	 Catch:{ all -> 0x0111 }
        r6 = android.text.TextUtils.isEmpty(r6);	 Catch:{ all -> 0x0111 }
        if (r6 != 0) goto L_0x0053;
    L_0x0034:
        r6 = 1;
        r0.setDoOutput(r6);	 Catch:{ all -> 0x0111 }
        r6 = r14.bz();	 Catch:{ all -> 0x0111 }
        r6 = r6.getBytes();	 Catch:{ all -> 0x0111 }
        r7 = r6.length;	 Catch:{ all -> 0x0111 }
        r0.setFixedLengthStreamingMode(r7);	 Catch:{ all -> 0x0111 }
        r7 = new java.io.BufferedOutputStream;	 Catch:{ all -> 0x0111 }
        r8 = r0.getOutputStream();	 Catch:{ all -> 0x0111 }
        r7.<init>(r8);	 Catch:{ all -> 0x0111 }
        r7.write(r6);	 Catch:{ all -> 0x0111 }
        r7.close();	 Catch:{ all -> 0x0111 }
    L_0x0053:
        r6 = r0.getResponseCode();	 Catch:{ all -> 0x0111 }
        r7 = r0.getHeaderFields();	 Catch:{ all -> 0x0111 }
        r8 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r6 < r8) goto L_0x0081;
    L_0x005f:
        if (r6 >= r9) goto L_0x0081;
    L_0x0061:
        r1 = r2.toString();	 Catch:{ all -> 0x0111 }
        r2 = new java.io.InputStreamReader;	 Catch:{ all -> 0x0111 }
        r8 = r0.getInputStream();	 Catch:{ all -> 0x0111 }
        r2.<init>(r8);	 Catch:{ all -> 0x0111 }
        r2 = com.google.android.gms.internal.eo.a(r2);	 Catch:{ all -> 0x0111 }
        a(r1, r7, r2, r6);	 Catch:{ all -> 0x0111 }
        r3.a(r1, r7, r2);	 Catch:{ all -> 0x0111 }
        r1 = r3.i(r4);	 Catch:{ all -> 0x0111 }
        r0.disconnect();	 Catch:{ IOException -> 0x00ee }
        r0 = r1;
    L_0x0080:
        return r0;
    L_0x0081:
        r2 = r2.toString();	 Catch:{ all -> 0x0111 }
        r8 = 0;
        a(r2, r7, r8, r6);	 Catch:{ all -> 0x0111 }
        if (r6 < r9) goto L_0x00c5;
    L_0x008b:
        r2 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r6 >= r2) goto L_0x00c5;
    L_0x008f:
        r2 = "Location";
        r6 = r0.getHeaderField(r2);	 Catch:{ all -> 0x0111 }
        r2 = android.text.TextUtils.isEmpty(r6);	 Catch:{ all -> 0x0111 }
        if (r2 == 0) goto L_0x00ab;
    L_0x009b:
        r1 = "No location header to follow redirect.";
        com.google.android.gms.internal.eu.D(r1);	 Catch:{ all -> 0x0111 }
        r1 = new com.google.android.gms.internal.du;	 Catch:{ all -> 0x0111 }
        r2 = 0;
        r1.<init>(r2);	 Catch:{ all -> 0x0111 }
        r0.disconnect();	 Catch:{ IOException -> 0x00ee }
        r0 = r1;
        goto L_0x0080;
    L_0x00ab:
        r2 = new java.net.URL;	 Catch:{ all -> 0x0111 }
        r2.<init>(r6);	 Catch:{ all -> 0x0111 }
        r1 = r1 + 1;
        r6 = 5;
        if (r1 <= r6) goto L_0x00e6;
    L_0x00b5:
        r1 = "Too many redirects.";
        com.google.android.gms.internal.eu.D(r1);	 Catch:{ all -> 0x0111 }
        r1 = new com.google.android.gms.internal.du;	 Catch:{ all -> 0x0111 }
        r2 = 0;
        r1.<init>(r2);	 Catch:{ all -> 0x0111 }
        r0.disconnect();	 Catch:{ IOException -> 0x00ee }
        r0 = r1;
        goto L_0x0080;
    L_0x00c5:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0111 }
        r1.<init>();	 Catch:{ all -> 0x0111 }
        r2 = "Received error HTTP response code: ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0111 }
        r1 = r1.append(r6);	 Catch:{ all -> 0x0111 }
        r1 = r1.toString();	 Catch:{ all -> 0x0111 }
        com.google.android.gms.internal.eu.D(r1);	 Catch:{ all -> 0x0111 }
        r1 = new com.google.android.gms.internal.du;	 Catch:{ all -> 0x0111 }
        r2 = 0;
        r1.<init>(r2);	 Catch:{ all -> 0x0111 }
        r0.disconnect();	 Catch:{ IOException -> 0x00ee }
        r0 = r1;
        goto L_0x0080;
    L_0x00e6:
        r3.d(r7);	 Catch:{ all -> 0x0111 }
        r0.disconnect();	 Catch:{ IOException -> 0x00ee }
        goto L_0x0013;
    L_0x00ee:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Error while connecting to ad server: ";
        r1 = r1.append(r2);
        r0 = r0.getMessage();
        r0 = r1.append(r0);
        r0 = r0.toString();
        com.google.android.gms.internal.eu.D(r0);
        r0 = new com.google.android.gms.internal.du;
        r1 = 2;
        r0.<init>(r1);
        goto L_0x0080;
    L_0x0111:
        r1 = move-exception;
        r0.disconnect();	 Catch:{ IOException -> 0x00ee }
        throw r1;	 Catch:{ IOException -> 0x00ee }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.dx.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.eb):com.google.android.gms.internal.du");
    }

    public static dx a(Context context, ay ayVar, bi biVar, ed edVar) {
        dx dxVar;
        synchronized (qp) {
            if (qq == null) {
                qq = new dx(context.getApplicationContext(), ayVar, biVar, edVar);
            }
            dxVar = qq;
        }
        return dxVar;
    }

    private static void a(String str, Map<String, List<String>> map, String str2, int i) {
        if (eu.p(2)) {
            eu.C("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (String str3 : map.keySet()) {
                    eu.C("    " + str3 + ":");
                    for (String str32 : (List) map.get(str32)) {
                        eu.C("      " + str32);
                    }
                }
            }
            eu.C("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += 1000) {
                    eu.C(str2.substring(i2, Math.min(str2.length(), i2 + 1000)));
                }
            } else {
                eu.C("    null");
            }
            eu.C("  Response Code:\n    " + i + "\n}");
        }
    }

    private static ey.a s(final String str) {
        return new ey.a() {
            public void a(ex exVar) {
                String format = String.format("javascript:%s(%s);", new Object[]{"AFMA_buildAdURL", str});
                eu.C("About to execute: " + format);
                exVar.loadUrl(format);
            }
        };
    }

    public du b(ds dsVar) {
        return a(this.mContext, this.qt, this.qs, this.qr, dsVar);
    }
}
