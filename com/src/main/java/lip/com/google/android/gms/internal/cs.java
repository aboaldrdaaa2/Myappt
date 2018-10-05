package lip.com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.market.IabHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class cs extends em implements ServiceConnection {
    private final Object ls = new Object();
    private Context mContext;
    private boolean oW = false;
    private dg oX;
    private cr oY;
    private cx oZ;
    private List<cv> pa = null;
    private cz pb;

    public cs(Context context, dg dgVar, cz czVar) {
        this.mContext = context;
        this.oX = dgVar;
        this.pb = czVar;
        this.oY = new cr(context);
        this.oZ = cx.k(this.mContext);
        this.pa = this.oZ.d(10);
    }

    private void a(final cv cvVar, String str, String str2) {
        final Intent intent = new Intent();
        intent.putExtra("RESPONSE_CODE", 0);
        intent.putExtra("INAPP_PURCHASE_DATA", str);
        intent.putExtra("INAPP_DATA_SIGNATURE", str2);
        et.sv.post(new Runnable() {
            public void run() {
                try {
                    if (cs.this.pb.a(cvVar.pm, -1, intent)) {
                        cs.this.oX.a(new cw(cs.this.mContext, cvVar.pn, true, -1, intent, cvVar));
                    } else {
                        cs.this.oX.a(new cw(cs.this.mContext, cvVar.pn, false, -1, intent, cvVar));
                    }
                } catch (RemoteException e) {
                    eu.D("Fail to verify and dispatch pending transaction");
                }
            }
        });
    }

    private void b(long j) {
        do {
            if (!c(j)) {
                eu.D("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.oW);
    }

    private void bi() {
        if (!this.pa.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (cv cvVar : this.pa) {
                hashMap.put(cvVar.pn, cvVar);
            }
            String str = null;
            while (true) {
                Bundle b = this.oY.b(this.mContext.getPackageName(), str);
                if (b == null || cy.a(b) != 0) {
                    break;
                }
                ArrayList stringArrayList = b.getStringArrayList(IabHelper.RESPONSE_INAPP_ITEM_LIST);
                ArrayList stringArrayList2 = b.getStringArrayList(IabHelper.RESPONSE_INAPP_PURCHASE_DATA_LIST);
                ArrayList stringArrayList3 = b.getStringArrayList(IabHelper.RESPONSE_INAPP_SIGNATURE_LIST);
                String string = b.getString(IabHelper.INAPP_CONTINUATION_TOKEN);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= stringArrayList.size()) {
                        break;
                    }
                    if (hashMap.containsKey(stringArrayList.get(i2))) {
                        str = (String) stringArrayList.get(i2);
                        String str2 = (String) stringArrayList2.get(i2);
                        String str3 = (String) stringArrayList3.get(i2);
                        cv cvVar2 = (cv) hashMap.get(str);
                        if (cvVar2.pm.equals(cy.p(str2))) {
                            a(cvVar2, str2, str3);
                            hashMap.remove(str);
                        }
                    }
                    i = i2 + 1;
                }
                if (string == null || hashMap.isEmpty()) {
                    break;
                }
                str = string;
            }
            for (String str4 : hashMap.keySet()) {
                this.oZ.a((cv) hashMap.get(str4));
            }
        }
    }

    private boolean c(long j) {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.ls.wait(elapsedRealtime);
        } catch (InterruptedException e) {
            eu.D("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    public void bh() {
        synchronized (this.ls) {
            Context context = this.mContext;
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            Context context2 = this.mContext;
            context.bindService(intent, this, 1);
            b(SystemClock.elapsedRealtime());
            this.mContext.unbindService(this);
            this.oY.destroy();
        }
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        synchronized (this.ls) {
            this.oY.o(service);
            bi();
            this.oW = true;
            this.ls.notify();
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        eu.B("In-app billing service disconnected.");
        this.oY.destroy();
    }

    public void onStop() {
        synchronized (this.ls) {
            this.mContext.unbindService(this);
            this.oY.destroy();
        }
    }
}
