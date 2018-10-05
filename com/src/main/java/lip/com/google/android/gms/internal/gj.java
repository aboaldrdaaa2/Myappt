package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class gj implements SafeParcelable {
    public static final Creator<gj> CREATOR = new gk();
    private double AP;
    private boolean AQ;
    private int BR;
    private final int xM;

    public gj() {
        this(1, Double.NaN, false, -1);
    }

    gj(int i, double d, boolean z, int i2) {
        this.xM = i;
        this.AP = d;
        this.AQ = z;
        this.BR = i2;
    }

    public int describeContents() {
        return 0;
    }

    public double eh() {
        return this.AP;
    }

    public boolean en() {
        return this.AQ;
    }

    public int eo() {
        return this.BR;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof gj)) {
            return false;
        }
        gj gjVar = (gj) obj;
        return this.AP == gjVar.AP && this.AQ == gjVar.AQ && this.BR == gjVar.BR;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return hk.hashCode(Double.valueOf(this.AP), Boolean.valueOf(this.AQ), Integer.valueOf(this.BR));
    }

    public void writeToParcel(Parcel out, int flags) {
        gk.a(this, out, flags);
    }
}
