package lip.com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.dynamic.e;

public final class cq implements SafeParcelable {
    public static final cp CREATOR = new cp();
    public final dg kX;
    public final cz kZ;
    public final db oT;
    public final Context oU;
    public final int versionCode;

    cq(int i, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4) {
        this.versionCode = i;
        this.kX = (dg) e.e(a.ag(iBinder));
        this.kZ = (cz) e.e(a.ag(iBinder2));
        this.oT = (db) e.e(a.ag(iBinder3));
        this.oU = (Context) e.e(a.ag(iBinder4));
    }

    public cq(db dbVar, dg dgVar, cz czVar, Context context) {
        this.versionCode = 1;
        this.oT = dbVar;
        this.kX = dgVar;
        this.kZ = czVar;
        this.oU = context;
    }

    public static void a(Intent intent, cq cqVar) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", cqVar);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", bundle);
    }

    public static cq b(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            bundleExtra.setClassLoader(cq.class.getClassLoader());
            return (cq) bundleExtra.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
        } catch (Exception e) {
            return null;
        }
    }

    IBinder bd() {
        return e.h(this.kX).asBinder();
    }

    IBinder be() {
        return e.h(this.kZ).asBinder();
    }

    IBinder bf() {
        return e.h(this.oT).asBinder();
    }

    IBinder bg() {
        return e.h(this.oU).asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        cp.a(this, out, flags);
    }
}
