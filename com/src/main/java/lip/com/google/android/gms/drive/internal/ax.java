package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class ax implements Creator<TrashResourceRequest> {
    static void a(TrashResourceRequest trashResourceRequest, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, trashResourceRequest.xM);
        b.a(parcel, 2, trashResourceRequest.Iu, i, false);
        b.G(parcel, C);
    }

    /* renamed from: ax */
    public TrashResourceRequest createFromParcel(Parcel parcel) {
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
            return new TrashResourceRequest(i, driveId);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: bt */
    public TrashResourceRequest[] newArray(int i) {
        return new TrashResourceRequest[i];
    }
}
