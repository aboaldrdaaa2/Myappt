package lip.com.google.android.gms.drive.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AddEventListenerRequest implements SafeParcelable {
    public static final Creator<AddEventListenerRequest> CREATOR = new a();
    final DriveId Hz;
    final int Iq;
    final PendingIntent Ir;
    final int xM;

    AddEventListenerRequest(int versionCode, DriveId driveId, int eventType, PendingIntent subscriptionIntent) {
        this.xM = versionCode;
        this.Hz = driveId;
        this.Iq = eventType;
        this.Ir = subscriptionIntent;
    }

    public AddEventListenerRequest(DriveId id, int eventType, PendingIntent subscriptionIntent) {
        this(1, id, eventType, subscriptionIntent);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        a.a(this, dest, flags);
    }
}
