package lip.com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hr implements SafeParcelable {
    public static final hs CREATOR = new hs();
    public final String GT;
    public final int GU;
    final int xM;

    public hr(int i, String str, int i2) {
        this.xM = i;
        this.GT = str;
        this.GU = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        hs.a(this, out, flags);
    }
}
