package lip.com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.internal.hk;

public class PlusCommonExtras implements SafeParcelable {
    public static final f CREATOR = new f();
    public static String TAG = "PlusCommonExtras";
    private String abQ;
    private String abR;
    private final int xM;

    public PlusCommonExtras() {
        this.xM = 1;
        this.abQ = "";
        this.abR = "";
    }

    PlusCommonExtras(int versionCode, String gpsrc, String clientCallingPackage) {
        this.xM = versionCode;
        this.abQ = gpsrc;
        this.abR = clientCallingPackage;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlusCommonExtras)) {
            return false;
        }
        PlusCommonExtras plusCommonExtras = (PlusCommonExtras) obj;
        return this.xM == plusCommonExtras.xM && hk.equal(this.abQ, plusCommonExtras.abQ) && hk.equal(this.abR, plusCommonExtras.abR);
    }

    public int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return hk.hashCode(Integer.valueOf(this.xM), this.abQ, this.abR);
    }

    public String jX() {
        return this.abQ;
    }

    public String jY() {
        return this.abR;
    }

    public void n(Bundle bundle) {
        bundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", c.a(this));
    }

    public String toString() {
        return hk.e(this).a("versionCode", Integer.valueOf(this.xM)).a("Gpsrc", this.abQ).a("ClientCallingPackage", this.abR).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        f.a(this, out, flags);
    }
}
