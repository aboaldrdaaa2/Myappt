package lip.com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class BeginCompoundOperationRequest implements SafeParcelable {
    public static final Creator<BeginCompoundOperationRequest> CREATOR = new a();
    final boolean Lj;
    final String mName;
    final int xM;

    BeginCompoundOperationRequest(int versionCode, boolean isCreation, String name) {
        this.xM = versionCode;
        this.Lj = isCreation;
        this.mName = name;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        a.a(this, dest, flags);
    }
}
