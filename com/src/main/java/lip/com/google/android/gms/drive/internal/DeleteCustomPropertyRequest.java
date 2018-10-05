package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class DeleteCustomPropertyRequest implements SafeParcelable {
    public static final Creator<DeleteCustomPropertyRequest> CREATOR = new m();
    final DriveId Hz;
    final CustomPropertyKey IJ;
    final int xM;

    DeleteCustomPropertyRequest(int versionCode, DriveId driveId, CustomPropertyKey propertyKey) {
        this.xM = versionCode;
        this.Hz = driveId;
        this.IJ = propertyKey;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        m.a(this, dest, flags);
    }
}
