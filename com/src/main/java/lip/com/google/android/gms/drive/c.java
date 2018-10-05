package lip.com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c implements Creator<DriveId> {
    static void a(DriveId driveId, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, driveId.xM);
        b.a(parcel, 2, driveId.HN, false);
        b.a(parcel, 3, driveId.HO);
        b.a(parcel, 4, driveId.HP);
        b.G(parcel, C);
    }

    /* renamed from: N */
    public DriveId createFromParcel(Parcel parcel) {
        long j = 0;
        int B = a.B(parcel);
        int i = 0;
        String str = null;
        long j2 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    str = a.o(parcel, A);
                    break;
                case 3:
                    j2 = a.i(parcel, A);
                    break;
                case 4:
                    j = a.i(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new DriveId(i, str, j2, j);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: aH */
    public DriveId[] newArray(int i) {
        return new DriveId[i];
    }
}
