package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AuthorizeAccessRequest implements SafeParcelable {
    public static final Creator<AuthorizeAccessRequest> CREATOR = new b();
    final DriveId Hz;
    final long Is;
    final int xM;

    AuthorizeAccessRequest(int versionCode, long appId, DriveId driveId) {
        this.xM = versionCode;
        this.Is = appId;
        this.Hz = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        b.a(this, dest, flags);
    }
}
