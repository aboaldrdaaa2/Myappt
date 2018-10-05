package lip.com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Operator implements SafeParcelable {
    public static final Creator<Operator> CREATOR = new k();
    public static final Operator La = new Operator("=");
    public static final Operator Lb = new Operator("<");
    public static final Operator Lc = new Operator("<=");
    public static final Operator Ld = new Operator(">");
    public static final Operator Le = new Operator(">=");
    public static final Operator Lf = new Operator("and");
    public static final Operator Lg = new Operator("or");
    public static final Operator Lh = new Operator("not");
    public static final Operator Li = new Operator("contains");
    final String mTag;
    final int xM;

    Operator(int versionCode, String tag) {
        this.xM = versionCode;
        this.mTag = tag;
    }

    private Operator(String tag) {
        this(1, tag);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Operator operator = (Operator) obj;
        return this.mTag == null ? operator.mTag == null : this.mTag.equals(operator.mTag);
    }

    public int hashCode() {
        return (this.mTag == null ? 0 : this.mTag.hashCode()) + 31;
    }

    public void writeToParcel(Parcel out, int flags) {
        k.a(this, out, flags);
    }
}
