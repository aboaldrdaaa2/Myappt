package lip.com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public class a implements Creator<Contents> {
    static void a(Contents contents, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, contents.xM);
        b.a(parcel, 2, contents.Fj, i, false);
        b.c(parcel, 3, contents.ra);
        b.c(parcel, 4, contents.Hy);
        b.a(parcel, 5, contents.Hz, i, false);
        b.a(parcel, 6, contents.HA, false);
        b.a(parcel, 7, contents.HB);
        b.G(parcel, C);
    }

    /* renamed from: M */
    public Contents createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int B = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
        DriveId driveId = null;
        int i = 0;
        int i2 = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(A)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    break;
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) com.google.android.gms.common.internal.safeparcel.a.a(parcel, A, ParcelFileDescriptor.CREATOR);
                    break;
                case 3:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    break;
                case 4:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    break;
                case 5:
                    driveId = (DriveId) com.google.android.gms.common.internal.safeparcel.a.a(parcel, A, DriveId.CREATOR);
                    break;
                case 6:
                    str = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 7:
                    z = com.google.android.gms.common.internal.safeparcel.a.c(parcel, A);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new Contents(i3, parcelFileDescriptor, i2, i, driveId, str, z);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: aG */
    public Contents[] newArray(int i) {
        return new Contents[i];
    }
}
