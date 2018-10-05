package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnListEntriesResponse implements SafeParcelable {
    public static final Creator<OnListEntriesResponse> CREATOR = new ak();
    final boolean IP;
    final DataHolder JA;
    final int xM;

    OnListEntriesResponse(int versionCode, DataHolder entries, boolean moreEntriesMayExist) {
        this.xM = versionCode;
        this.JA = entries;
        this.IP = moreEntriesMayExist;
    }

    public int describeContents() {
        return 0;
    }

    public DataHolder gy() {
        return this.JA;
    }

    public boolean gz() {
        return this.IP;
    }

    public void writeToParcel(Parcel dest, int flags) {
        ak.a(this, dest, flags);
    }
}
