package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class ad implements Creator<ListParentsRequest> {
    static void a(ListParentsRequest listParentsRequest, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, listParentsRequest.xM);
        b.a(parcel, 2, listParentsRequest.Jr, i, false);
        b.G(parcel, C);
    }

    /* renamed from: af */
    public ListParentsRequest createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    driveId = (DriveId) a.a(parcel, A, DriveId.CREATOR);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ListParentsRequest(i, driveId);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: bb */
    public ListParentsRequest[] newArray(int i) {
        return new ListParentsRequest[i];
    }
}
