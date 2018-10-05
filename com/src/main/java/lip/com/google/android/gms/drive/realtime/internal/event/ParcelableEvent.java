package lip.com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableEvent implements SafeParcelable {
    public static final Creator<ParcelableEvent> CREATOR = new a();
    final ReferenceShiftedDetails LA;
    final String Lm;
    final String Lq;
    final boolean Ls;
    final String Lt;
    final TextInsertedDetails Lu;
    final TextDeletedDetails Lv;
    final ValuesAddedDetails Lw;
    final ValuesRemovedDetails Lx;
    final ValuesSetDetails Ly;
    final ValueChangedDetails Lz;
    final String rR;
    final int xM;

    ParcelableEvent(int versionCode, String sessionId, String userId, boolean isLocal, String objectId, String objectType, TextInsertedDetails textInsertedDetails, TextDeletedDetails textDeletedDetails, ValuesAddedDetails valuesAddedDetails, ValuesRemovedDetails valuesRemovedDetails, ValuesSetDetails valuesSetDetails, ValueChangedDetails valueChangedDetails, ReferenceShiftedDetails referenceShiftedDetails) {
        this.xM = versionCode;
        this.rR = sessionId;
        this.Lm = userId;
        this.Ls = isLocal;
        this.Lq = objectId;
        this.Lt = objectType;
        this.Lu = textInsertedDetails;
        this.Lv = textDeletedDetails;
        this.Lw = valuesAddedDetails;
        this.Lx = valuesRemovedDetails;
        this.Ly = valuesSetDetails;
        this.Lz = valueChangedDetails;
        this.LA = referenceShiftedDetails;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        a.a(this, dest, flags);
    }
}
