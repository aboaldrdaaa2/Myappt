package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class ar implements Creator<OpenContentsRequest> {
    static void a(OpenContentsRequest openContentsRequest, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, openContentsRequest.xM);
        b.a(parcel, 2, openContentsRequest.Iu, i, false);
        b.c(parcel, 3, openContentsRequest.Hy);
        b.G(parcel, C);
    }

    /* renamed from: as */
    public OpenContentsRequest createFromParcel(Parcel parcel) {
        int i = 0;
        int B = a.B(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            DriveId driveId2;
            int g;
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    int i3 = i;
                    driveId2 = driveId;
                    g = a.g(parcel, A);
                    A = i3;
                    break;
                case 2:
                    g = i2;
                    DriveId driveId3 = (DriveId) a.a(parcel, A, DriveId.CREATOR);
                    A = i;
                    driveId2 = driveId3;
                    break;
                case 3:
                    A = a.g(parcel, A);
                    driveId2 = driveId;
                    g = i2;
                    break;
                default:
                    a.b(parcel, A);
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
            return new OpenContentsRequest(i2, driveId, i);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: bo */
    public OpenContentsRequest[] newArray(int i) {
        return new OpenContentsRequest[i];
    }
}
