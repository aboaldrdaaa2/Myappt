package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class lg implements SafeParcelable {
    public static final Creator<lg> CREATOR = new lh();
    int[] akd;
    private final int xM;

    lg() {
        this(1, null);
    }

    lg(int i, int[] iArr) {
        this.xM = i;
        this.akd = iArr;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel out, int flags) {
        lh.a(this, out, flags);
    }
}
