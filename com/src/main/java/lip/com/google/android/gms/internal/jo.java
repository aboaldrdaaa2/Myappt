package lip.com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class jo implements SafeParcelable {
    public static final jp CREATOR = new jp();
    private final String Wl;
    private final String mTag;
    final int xM;

    jo(int i, String str, String str2) {
        this.xM = i;
        this.Wl = str;
        this.mTag = str2;
    }

    public int describeContents() {
        jp jpVar = CREATOR;
        return 0;
    }

    public boolean equals(Object that) {
        if (!(that instanceof jo)) {
            return false;
        }
        jo joVar = (jo) that;
        return hk.equal(this.Wl, joVar.Wl) && hk.equal(this.mTag, joVar.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return hk.hashCode(this.Wl, this.mTag);
    }

    public String jj() {
        return this.Wl;
    }

    public String toString() {
        return hk.e(this).a("mPlaceId", this.Wl).a("mTag", this.mTag).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        jp jpVar = CREATOR;
        jp.a(this, out, flags);
    }
}
