package lip.com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public final class ChangeEvent implements SafeParcelable, ResourceEvent {
    public static final Creator<ChangeEvent> CREATOR = new a();
    final DriveId Hz;
    final int Ig;
    final int xM;

    ChangeEvent(int versionCode, DriveId driveId, int changeFlags) {
        this.xM = versionCode;
        this.Hz = driveId;
        this.Ig = changeFlags;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.Hz;
    }

    public int getType() {
        return 1;
    }

    public boolean hasContentChanged() {
        return (this.Ig & 2) != 0;
    }

    public boolean hasMetadataChanged() {
        return (this.Ig & 1) != 0;
    }

    public String toString() {
        return String.format("ChangeEvent [id=%s,changeFlags=%x]", new Object[]{this.Hz, Integer.valueOf(this.Ig)});
    }

    public void writeToParcel(Parcel dest, int flags) {
        a.a(this, dest, flags);
    }
}
