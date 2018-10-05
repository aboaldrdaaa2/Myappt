package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.FileConflictEvent;

public class OnEventResponse implements SafeParcelable {
    public static final Creator<OnEventResponse> CREATOR = new aj();
    final int Iq;
    final ChangeEvent Jy;
    final FileConflictEvent Jz;
    final int xM;

    OnEventResponse(int versionCode, int eventType, ChangeEvent changeEvent, FileConflictEvent conflictEvent) {
        this.xM = versionCode;
        this.Iq = eventType;
        this.Jy = changeEvent;
        this.Jz = conflictEvent;
    }

    public int describeContents() {
        return 0;
    }

    public int getEventType() {
        return this.Iq;
    }

    public ChangeEvent gw() {
        return this.Jy;
    }

    public FileConflictEvent gx() {
        return this.Jz;
    }

    public void writeToParcel(Parcel dest, int flags) {
        aj.a(this, dest, flags);
    }
}
