package lip.com.google.android.gms.internal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchaseActivity;
import com.google.android.gms.internal.dd.a;

public class cu extends a implements ServiceConnection {
    private dg oX;
    private cr oY;
    private final cx oZ;
    private final Activity og;
    private cz pb;
    private Context ph;
    private db pi;
    private cv pj;
    private String pk = null;

    public cu(Activity activity) {
        this.og = activity;
        this.oZ = cx.k(this.og.getApplicationContext());
    }

    public static void a(Context context, boolean z, cq cqVar) {
        Intent intent = new Intent();
        intent.setClassName(context, InAppPurchaseActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", z);
        cq.a(intent, cqVar);
        context.startActivity(intent);
    }

    private void a(String str, boolean z, int i, Intent intent) {
        try {
            this.oX.a(new cw(this.ph, str, z, i, intent, this.pj));
        } catch (RemoteException e) {
            eu.D("Fail to invoke PlayStorePurchaseListener.");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1001) {
            try {
                int c = cy.c(data);
                if (resultCode != -1 || c != 0) {
                    this.oZ.a(this.pj);
                    a(this.pi.getProductId(), false, resultCode, data);
                } else if (this.pb.a(this.pk, resultCode, data)) {
                    a(this.pi.getProductId(), true, resultCode, data);
                } else {
                    a(this.pi.getProductId(), false, resultCode, data);
                }
                this.pi.recordPlayBillingResolution(c);
            } catch (RemoteException e) {
                eu.D("Fail to process purchase result.");
            } finally {
                this.pk = null;
                this.og.finish();
            }
        }
    }

    public void onCreate() {
        cq b = cq.b(this.og.getIntent());
        this.oX = b.kX;
        this.pb = b.kZ;
        this.pi = b.oT;
        this.oY = new cr(this.og.getApplicationContext());
        this.ph = b.oU;
        Activity activity = this.og;
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        this.og.getApplicationContext();
        activity.bindService(intent, this, 1);
    }

    public void onDestroy() {
        this.og.unbindService(this);
        this.oY.destroy();
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0089 A:{ExcHandler: android.os.RemoteException (r1_11 'e' java.lang.Throwable), Splitter: B:1:0x0005} */
    /* JADX WARNING: Missing block: B:6:0x0089, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:7:0x008a, code:
            com.google.android.gms.internal.eu.c("Error when connecting in-app billing service", r1);
            r8.og.finish();
     */
    /* JADX WARNING: Missing block: B:9:?, code:
            return;
     */
    public void onServiceConnected(ComponentName r9, android.os.IBinder r10) {
        /*
        r8 = this;
        r1 = r8.oY;
        r1.o(r10);
        r1 = r8.pb;	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r1 = r1.bm();	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r8.pk = r1;	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r1 = r8.oY;	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r2 = r8.og;	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r2 = r2.getPackageName();	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r3 = r8.pi;	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r3 = r3.getProductId();	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r4 = r8.pk;	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r3 = r1.a(r2, r3, r4);	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r1 = "BUY_INTENT";
        r1 = r3.getParcelable(r1);	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r0 = r1;
        r0 = (android.app.PendingIntent) r0;	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r2 = r0;
        if (r2 != 0) goto L_0x0047;
    L_0x002d:
        r1 = com.google.android.gms.internal.cy.a(r3);	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r2 = r8.pi;	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r2.recordPlayBillingResolution(r1);	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r2 = r8.pi;	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r2 = r2.getProductId();	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r3 = 0;
        r4 = 0;
        r8.a(r2, r3, r1, r4);	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r1 = r8.og;	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r1.finish();	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
    L_0x0046:
        return;
    L_0x0047:
        r1 = new com.google.android.gms.internal.cv;	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r3 = r8.pi;	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r3 = r3.getProductId();	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r4 = r8.pk;	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r1.<init>(r3, r4);	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r8.pj = r1;	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r1 = r8.oZ;	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r3 = r8.pj;	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r1.b(r3);	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r1 = r8.og;	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r2 = r2.getIntentSender();	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r3 = 1001; // 0x3e9 float:1.403E-42 double:4.946E-321;
        r4 = new android.content.Intent;	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r4.<init>();	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r5 = r5.intValue();	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r6 = 0;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r6 = r6.intValue();	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r7 = 0;
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r7 = r7.intValue();	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        r1.startIntentSenderForResult(r2, r3, r4, r5, r6, r7);	 Catch:{ RemoteException -> 0x0089, RemoteException -> 0x0089 }
        goto L_0x0046;
    L_0x0089:
        r1 = move-exception;
        r2 = "Error when connecting in-app billing service";
        com.google.android.gms.internal.eu.c(r2, r1);
        r1 = r8.og;
        r1.finish();
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cu.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public void onServiceDisconnected(ComponentName name) {
        eu.B("In-app billing service disconnected.");
        this.oY.destroy();
    }
}
