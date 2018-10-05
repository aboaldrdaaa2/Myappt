package lip.com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class v implements SafeParcelable {
    public static final w CREATOR = new w();
    public final boolean lb;
    public final boolean ld;
    public final int versionCode;

    v(int i, boolean z, boolean z2) {
        this.versionCode = i;
        this.lb = z;
        this.ld = z2;
    }

    public v(boolean z, boolean z2) {
        this.versionCode = 1;
        this.lb = z;
        this.ld = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        w.a(this, out, flags);
    }
}
