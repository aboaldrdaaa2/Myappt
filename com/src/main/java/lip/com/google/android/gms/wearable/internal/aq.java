package lip.com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class aq implements SafeParcelable {
    public static final Creator<aq> CREATOR = new ar();
    public final int amc;
    public final int statusCode;
    public final int versionCode;

    aq(int i, int i2, int i3) {
        this.versionCode = i;
        this.statusCode = i2;
        this.amc = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        ar.a(this, dest, flags);
    }
}
