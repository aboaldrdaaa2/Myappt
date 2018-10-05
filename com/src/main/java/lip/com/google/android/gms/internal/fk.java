package lip.com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class fk implements SafeParcelable {
    public static final fl CREATOR = new fl();
    public static final int xT = Integer.parseInt("-1");
    final int xM;
    public final String xU;
    final fp xV;
    public final int xW;
    public final byte[] xX;

    fk(int i, String str, fp fpVar, int i2, byte[] bArr) {
        boolean z = i2 == xT || fo.H(i2) != null;
        hm.b(z, "Invalid section type " + i2);
        this.xM = i;
        this.xU = str;
        this.xV = fpVar;
        this.xW = i2;
        this.xX = bArr;
        String dO = dO();
        if (dO != null) {
            throw new IllegalArgumentException(dO);
        }
    }

    public fk(String str, fp fpVar) {
        this(1, str, fpVar, xT, null);
    }

    public fk(String str, fp fpVar, String str2) {
        this(1, str, fpVar, fo.Y(str2), null);
    }

    public fk(byte[] bArr, fp fpVar) {
        this(1, null, fpVar, xT, bArr);
    }

    public String dO() {
        return (this.xW == xT || fo.H(this.xW) != null) ? (this.xU == null || this.xX == null) ? null : "Both content and blobContent set" : "Invalid section type " + this.xW;
    }

    public int describeContents() {
        fl flVar = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        fl flVar = CREATOR;
        fl.a(this, dest, flags);
    }
}
