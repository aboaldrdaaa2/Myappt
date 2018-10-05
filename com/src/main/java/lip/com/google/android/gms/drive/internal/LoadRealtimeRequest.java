package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class LoadRealtimeRequest implements SafeParcelable {
    public static final Creator<LoadRealtimeRequest> CREATOR = new ae();
    final DriveId Hz;
    final boolean Js;
    final int xM;

    LoadRealtimeRequest(int versionCode, DriveId driveId, boolean useTestMode) {
        this.xM = versionCode;
        this.Hz = driveId;
        this.Js = useTestMode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        ae.a(this, dest, flags);
    }
}
