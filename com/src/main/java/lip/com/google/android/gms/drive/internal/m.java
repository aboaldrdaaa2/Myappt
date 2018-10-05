package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class m implements Creator<DeleteCustomPropertyRequest> {
    static void a(DeleteCustomPropertyRequest deleteCustomPropertyRequest, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, deleteCustomPropertyRequest.xM);
        b.a(parcel, 2, deleteCustomPropertyRequest.Hz, i, false);
        b.a(parcel, 3, deleteCustomPropertyRequest.IJ, i, false);
        b.G(parcel, C);
    }

    /* renamed from: aW */
    public DeleteCustomPropertyRequest[] newArray(int i) {
        return new DeleteCustomPropertyRequest[i];
    }

    /* renamed from: aa */
    public DeleteCustomPropertyRequest createFromParcel(Parcel parcel) {
        CustomPropertyKey customPropertyKey = null;
        int B = a.B(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < B) {
            DriveId driveId2;
            int g;
            CustomPropertyKey customPropertyKey2;
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    CustomPropertyKey customPropertyKey3 = customPropertyKey;
                    driveId2 = driveId;
                    g = a.g(parcel, A);
                    customPropertyKey2 = customPropertyKey3;
                    break;
                case 2:
                    g = i;
                    DriveId driveId3 = (DriveId) a.a(parcel, A, DriveId.CREATOR);
                    customPropertyKey2 = customPropertyKey;
                    driveId2 = driveId3;
                    break;
                case 3:
                    customPropertyKey2 = (CustomPropertyKey) a.a(parcel, A, CustomPropertyKey.CREATOR);
                    driveId2 = driveId;
                    g = i;
                    break;
                default:
                    a.b(parcel, A);
                    customPropertyKey2 = customPropertyKey;
                    driveId2 = driveId;
                    g = i;
                    break;
            }
            i = g;
            driveId = driveId2;
            customPropertyKey = customPropertyKey2;
        }
        if (parcel.dataPosition() == B) {
            return new DeleteCustomPropertyRequest(i, driveId, customPropertyKey);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }
}
