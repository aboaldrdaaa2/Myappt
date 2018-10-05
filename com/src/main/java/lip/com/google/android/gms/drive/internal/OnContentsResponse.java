package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class OnContentsResponse implements SafeParcelable {
    public static final Creator<OnContentsResponse> CREATOR = new ag();
    final Contents HG;
    final int xM;

    OnContentsResponse(int versionCode, Contents contents) {
        this.xM = versionCode;
        this.HG = contents;
    }

    public int describeContents() {
        return 0;
    }

    public Contents gt() {
        return this.HG;
    }

    public void writeToParcel(Parcel dest, int flags) {
        ag.a(this, dest, flags);
    }
}
