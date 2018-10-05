package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnListParentsResponse implements SafeParcelable {
    public static final Creator<OnListParentsResponse> CREATOR = new al();
    final DataHolder JB;
    final int xM;

    OnListParentsResponse(int versionCode, DataHolder parents) {
        this.xM = versionCode;
        this.JB = parents;
    }

    public int describeContents() {
        return 0;
    }

    public DataHolder gA() {
        return this.JB;
    }

    public void writeToParcel(Parcel dest, int flags) {
        al.a(this, dest, flags);
    }
}
