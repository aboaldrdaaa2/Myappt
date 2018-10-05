package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class j implements Creator<CreateFileRequest> {
    static void a(CreateFileRequest createFileRequest, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, createFileRequest.xM);
        b.a(parcel, 2, createFileRequest.IG, i, false);
        b.a(parcel, 3, createFileRequest.IE, i, false);
        b.a(parcel, 4, createFileRequest.Iw, i, false);
        b.a(parcel, 5, createFileRequest.IF, false);
        b.a(parcel, 6, createFileRequest.IH);
        b.a(parcel, 7, createFileRequest.Iy, false);
        b.G(parcel, C);
    }

    /* renamed from: Y */
    public CreateFileRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int B = a.B(parcel);
        Integer num = null;
        Contents contents = null;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    driveId = (DriveId) a.a(parcel, A, DriveId.CREATOR);
                    break;
                case 3:
                    metadataBundle = (MetadataBundle) a.a(parcel, A, MetadataBundle.CREATOR);
                    break;
                case 4:
                    contents = (Contents) a.a(parcel, A, Contents.CREATOR);
                    break;
                case 5:
                    num = a.h(parcel, A);
                    break;
                case 6:
                    z = a.c(parcel, A);
                    break;
                case 7:
                    str = a.o(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new CreateFileRequest(i, driveId, metadataBundle, contents, num, z, str);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: aU */
    public CreateFileRequest[] newArray(int i) {
        return new CreateFileRequest[i];
    }
}
