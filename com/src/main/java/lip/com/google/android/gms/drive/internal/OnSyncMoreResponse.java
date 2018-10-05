package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnSyncMoreResponse implements SafeParcelable {
    public static final Creator<OnSyncMoreResponse> CREATOR = new aq();
    final boolean IP;
    final int xM;

    OnSyncMoreResponse(int versionCode, boolean moreEntriesMayExist) {
        this.xM = versionCode;
        this.IP = moreEntriesMayExist;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        aq.a(this, dest, flags);
    }
}
