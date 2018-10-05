package lip.com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;

public class c implements SafeParcelable {
    public static final Creator<c> CREATOR = new d();
    private final int AT;
    private final String YL;
    private final int ali;
    private final boolean alj;
    private final String mName;
    final int xM;

    c(int i, String str, String str2, int i2, int i3, boolean z) {
        this.xM = i;
        this.mName = str;
        this.YL = str2;
        this.AT = i2;
        this.ali = i3;
        this.alj = z;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (!(o instanceof c)) {
            return false;
        }
        c cVar = (c) o;
        return hk.equal(Integer.valueOf(this.xM), Integer.valueOf(cVar.xM)) && hk.equal(this.mName, cVar.mName) && hk.equal(this.YL, cVar.YL) && hk.equal(Integer.valueOf(this.AT), Integer.valueOf(cVar.AT)) && hk.equal(Integer.valueOf(this.ali), Integer.valueOf(cVar.ali)) && hk.equal(Boolean.valueOf(this.alj), Boolean.valueOf(cVar.alj));
    }

    public String getAddress() {
        return this.YL;
    }

    public String getName() {
        return this.mName;
    }

    public int getRole() {
        return this.ali;
    }

    public int getType() {
        return this.AT;
    }

    public int hashCode() {
        return hk.hashCode(Integer.valueOf(this.xM), this.mName, this.YL, Integer.valueOf(this.AT), Integer.valueOf(this.ali), Boolean.valueOf(this.alj));
    }

    public boolean isEnabled() {
        return this.alj;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ConnectionConfiguration[ ");
        stringBuilder.append("mName=" + this.mName);
        stringBuilder.append(", mAddress=" + this.YL);
        stringBuilder.append(", mType=" + this.AT);
        stringBuilder.append(", mRole=" + this.ali);
        stringBuilder.append(", mEnabled=" + this.alj);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        d.a(this, dest, flags);
    }
}
