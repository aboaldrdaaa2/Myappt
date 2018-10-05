package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class i implements Creator<CreateFileIntentSenderRequest> {
    static void a(CreateFileIntentSenderRequest createFileIntentSenderRequest, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, createFileIntentSenderRequest.xM);
        b.a(parcel, 2, createFileIntentSenderRequest.IE, i, false);
        b.c(parcel, 3, createFileIntentSenderRequest.ra);
        b.a(parcel, 4, createFileIntentSenderRequest.HY, false);
        b.a(parcel, 5, createFileIntentSenderRequest.Ia, i, false);
        b.a(parcel, 6, createFileIntentSenderRequest.IF, false);
        b.G(parcel, C);
    }

    /* renamed from: X */
    public CreateFileIntentSenderRequest createFromParcel(Parcel parcel) {
        int i = 0;
        Integer num = null;
        int B = a.B(parcel);
        DriveId driveId = null;
        String str = null;
        MetadataBundle metadataBundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i2 = a.g(parcel, A);
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) a.a(parcel, A, MetadataBundle.CREATOR);
                    break;
                case 3:
                    i = a.g(parcel, A);
                    break;
                case 4:
                    str = a.o(parcel, A);
                    break;
                case 5:
                    driveId = (DriveId) a.a(parcel, A, DriveId.CREATOR);
                    break;
                case 6:
                    num = a.h(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new CreateFileIntentSenderRequest(i2, metadataBundle, i, str, driveId, num);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: aT */
    public CreateFileIntentSenderRequest[] newArray(int i) {
        return new CreateFileIntentSenderRequest[i];
    }
}
