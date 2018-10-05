package lip.com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;
import java.util.Arrays;

public class h implements SafeParcelable {
    public static final j CREATOR = new j();
    private final String[] abT;
    private final String[] abU;
    private final String[] abV;
    private final String abW;
    private final String abX;
    private final String abY;
    private final String abZ;
    private final PlusCommonExtras aca;
    private final int xM;
    private final String yQ;

    h(int i, String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String str5, PlusCommonExtras plusCommonExtras) {
        this.xM = i;
        this.yQ = str;
        this.abT = strArr;
        this.abU = strArr2;
        this.abV = strArr3;
        this.abW = str2;
        this.abX = str3;
        this.abY = str4;
        this.abZ = str5;
        this.aca = plusCommonExtras;
    }

    public h(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, PlusCommonExtras plusCommonExtras) {
        this.xM = 1;
        this.yQ = str;
        this.abT = strArr;
        this.abU = strArr2;
        this.abV = strArr3;
        this.abW = str2;
        this.abX = str3;
        this.abY = str4;
        this.abZ = null;
        this.aca = plusCommonExtras;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.xM == hVar.xM && hk.equal(this.yQ, hVar.yQ) && Arrays.equals(this.abT, hVar.abT) && Arrays.equals(this.abU, hVar.abU) && Arrays.equals(this.abV, hVar.abV) && hk.equal(this.abW, hVar.abW) && hk.equal(this.abX, hVar.abX) && hk.equal(this.abY, hVar.abY) && hk.equal(this.abZ, hVar.abZ) && hk.equal(this.aca, hVar.aca);
    }

    public String getAccountName() {
        return this.yQ;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return hk.hashCode(Integer.valueOf(this.xM), this.yQ, this.abT, this.abU, this.abV, this.abW, this.abX, this.abY, this.abZ, this.aca);
    }

    public String[] jZ() {
        return this.abT;
    }

    public String[] ka() {
        return this.abU;
    }

    public String[] kb() {
        return this.abV;
    }

    public String kc() {
        return this.abW;
    }

    public String kd() {
        return this.abX;
    }

    public String ke() {
        return this.abY;
    }

    public String kf() {
        return this.abZ;
    }

    public PlusCommonExtras kg() {
        return this.aca;
    }

    public Bundle kh() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
        this.aca.n(bundle);
        return bundle;
    }

    public String toString() {
        return hk.e(this).a("versionCode", Integer.valueOf(this.xM)).a("accountName", this.yQ).a("requestedScopes", this.abT).a("visibleActivities", this.abU).a("requiredFeatures", this.abV).a("packageNameForAuth", this.abW).a("callingPackageName", this.abX).a("applicationName", this.abY).a("extra", this.aca.toString()).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        j.a(this, out, flags);
    }
}
