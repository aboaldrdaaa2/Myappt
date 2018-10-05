package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.FileConflictEvent;

public class aj implements Creator<OnEventResponse> {
    static void a(OnEventResponse onEventResponse, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, onEventResponse.xM);
        b.c(parcel, 2, onEventResponse.Iq);
        b.a(parcel, 3, onEventResponse.Jy, i, false);
        b.a(parcel, 4, onEventResponse.Jz, i, false);
        b.G(parcel, C);
    }

    /* renamed from: ak */
    public OnEventResponse createFromParcel(Parcel parcel) {
        FileConflictEvent fileConflictEvent = null;
        int i = 0;
        int B = a.B(parcel);
        ChangeEvent changeEvent = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            ChangeEvent changeEvent2;
            int i3;
            FileConflictEvent fileConflictEvent2;
            int A = a.A(parcel);
            FileConflictEvent fileConflictEvent3;
            switch (a.ar(A)) {
                case 1:
                    fileConflictEvent3 = fileConflictEvent;
                    changeEvent2 = changeEvent;
                    i3 = i;
                    i = a.g(parcel, A);
                    fileConflictEvent2 = fileConflictEvent3;
                    break;
                case 2:
                    i = i2;
                    ChangeEvent changeEvent3 = changeEvent;
                    i3 = a.g(parcel, A);
                    fileConflictEvent2 = fileConflictEvent;
                    changeEvent2 = changeEvent3;
                    break;
                case 3:
                    i3 = i;
                    i = i2;
                    fileConflictEvent3 = fileConflictEvent;
                    changeEvent2 = (ChangeEvent) a.a(parcel, A, ChangeEvent.CREATOR);
                    fileConflictEvent2 = fileConflictEvent3;
                    break;
                case 4:
                    fileConflictEvent2 = (FileConflictEvent) a.a(parcel, A, FileConflictEvent.CREATOR);
                    changeEvent2 = changeEvent;
                    i3 = i;
                    i = i2;
                    break;
                default:
                    a.b(parcel, A);
                    fileConflictEvent2 = fileConflictEvent;
                    changeEvent2 = changeEvent;
                    i3 = i;
                    i = i2;
                    break;
            }
            i2 = i;
            i = i3;
            changeEvent = changeEvent2;
            fileConflictEvent = fileConflictEvent2;
        }
        if (parcel.dataPosition() == B) {
            return new OnEventResponse(i2, i, changeEvent, fileConflictEvent);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: bg */
    public OnEventResponse[] newArray(int i) {
        return new OnEventResponse[i];
    }
}
