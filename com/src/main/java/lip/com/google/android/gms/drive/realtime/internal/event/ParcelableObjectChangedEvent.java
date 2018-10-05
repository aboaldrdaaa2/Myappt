package lip.com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableObjectChangedEvent implements SafeParcelable {
    public static final Creator<ParcelableObjectChangedEvent> CREATOR = new c();
    final int LF;
    final int LG;
    final String Lm;
    final String Lq;
    final boolean Ls;
    final String Lt;
    final String rR;
    final int xM;

    ParcelableObjectChangedEvent(int versionCode, String sessionId, String userId, boolean isLocal, String objectId, String objectType, int valueIndex, int valueCount) {
        this.rR = sessionId;
        this.Lm = userId;
        this.Ls = isLocal;
        this.Lq = objectId;
        this.Lt = objectType;
        this.xM = versionCode;
        this.LF = valueIndex;
        this.LG = valueCount;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        c.a(this, dest, flags);
    }
}
