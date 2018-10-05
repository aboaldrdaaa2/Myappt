package lip.com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.ArrayList;

public class c implements Creator<FileConflictEvent> {
    static void a(FileConflictEvent fileConflictEvent, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, fileConflictEvent.xM);
        b.a(parcel, 2, fileConflictEvent.Hz, i, false);
        b.a(parcel, 3, fileConflictEvent.yQ, false);
        b.a(parcel, 4, fileConflictEvent.Ij, i, false);
        b.a(parcel, 5, fileConflictEvent.Ik, i, false);
        b.a(parcel, 6, fileConflictEvent.Il, i, false);
        b.a(parcel, 7, fileConflictEvent.Im, false);
        b.G(parcel, C);
    }

    /* renamed from: Q */
    public FileConflictEvent createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int B = a.B(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        String str = null;
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
                case 3:
                    str = a.o(parcel, A);
                    break;
                case 4:
                    parcelFileDescriptor2 = (ParcelFileDescriptor) a.a(parcel, A, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    parcelFileDescriptor = (ParcelFileDescriptor) a.a(parcel, A, ParcelFileDescriptor.CREATOR);
                    break;
                case 6:
                    metadataBundle = (MetadataBundle) a.a(parcel, A, MetadataBundle.CREATOR);
                    break;
                case 7:
                    arrayList = a.B(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new FileConflictEvent(i, driveId, str, parcelFileDescriptor2, parcelFileDescriptor, metadataBundle, arrayList);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: aL */
    public FileConflictEvent[] newArray(int i) {
        return new FileConflictEvent[i];
    }
}
