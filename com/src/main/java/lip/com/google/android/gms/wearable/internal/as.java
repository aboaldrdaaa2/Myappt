package lip.com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class as implements SafeParcelable {
    public static final Creator<as> CREATOR = new at();
    public final long amb;
    public final List<ak> amd;
    public final int statusCode;
    public final int versionCode;

    as(int i, int i2, long j, List<ak> list) {
        this.versionCode = i;
        this.statusCode = i2;
        this.amb = j;
        this.amd = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        at.a(this, out, flags);
    }
}
