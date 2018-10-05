package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ge implements SafeParcelable {
    public static final Creator<ge> CREATOR = new gf();
    private String BC;
    private final int xM;

    public ge() {
        this(1, null);
    }

    ge(int i, String str) {
        this.xM = i;
        this.BC = str;
    }

    public int describeContents() {
        return 0;
    }

    public String ec() {
        return this.BC;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ge)) {
            return false;
        }
        return gi.a(this.BC, ((ge) obj).BC);
    }

    public int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return hk.hashCode(this.BC);
    }

    public void writeToParcel(Parcel out, int flags) {
        gf.a(this, out, flags);
    }
}
