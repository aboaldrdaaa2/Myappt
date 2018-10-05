package lip.com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class a implements Creator<ChangeEvent> {
    static void a(ChangeEvent changeEvent, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, changeEvent.xM);
        b.a(parcel, 2, changeEvent.Hz, i, false);
        b.c(parcel, 3, changeEvent.Ig);
        b.G(parcel, C);
    }

    /* renamed from: P */
    public ChangeEvent createFromParcel(Parcel parcel) {
        int i = 0;
        int B = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            DriveId driveId2;
            int g;
            int A = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(A)) {
                case 1:
                    int i3 = i;
                    driveId2 = driveId;
                    g = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    A = i3;
                    break;
                case 2:
                    g = i2;
                    DriveId driveId3 = (DriveId) com.google.android.gms.common.internal.safeparcel.a.a(parcel, A, DriveId.CREATOR);
                    A = i;
                    driveId2 = driveId3;
                    break;
                case 3:
                    A = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    driveId2 = driveId;
                    g = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, A);
                    A = i;
                    driveId2 = driveId;
                    g = i2;
                    break;
            }
            i2 = g;
            driveId = driveId2;
            i = A;
        }
        if (parcel.dataPosition() == B) {
            return new ChangeEvent(i2, driveId, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: aJ */
    public ChangeEvent[] newArray(int i) {
        return new ChangeEvent[i];
    }
}
