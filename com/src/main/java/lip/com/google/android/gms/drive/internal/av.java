package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;
import java.util.List;

public class av implements Creator<SetResourceParentsRequest> {
    static void a(SetResourceParentsRequest setResourceParentsRequest, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, setResourceParentsRequest.xM);
        b.a(parcel, 2, setResourceParentsRequest.JF, i, false);
        b.b(parcel, 3, setResourceParentsRequest.JG, false);
        b.G(parcel, C);
    }

    /* renamed from: aw */
    public SetResourceParentsRequest createFromParcel(Parcel parcel) {
        List list = null;
        int B = a.B(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < B) {
            DriveId driveId2;
            int g;
            ArrayList c;
            int A = a.A(parcel);
            List c2;
            switch (a.ar(A)) {
                case 1:
                    List list2 = list;
                    driveId2 = driveId;
                    g = a.g(parcel, A);
                    c2 = list2;
                    break;
                case 2:
                    g = i;
                    DriveId driveId3 = (DriveId) a.a(parcel, A, DriveId.CREATOR);
                    c2 = list;
                    driveId2 = driveId3;
                    break;
                case 3:
                    c2 = a.c(parcel, A, DriveId.CREATOR);
                    driveId2 = driveId;
                    g = i;
                    break;
                default:
                    a.b(parcel, A);
                    c2 = list;
                    driveId2 = driveId;
                    g = i;
                    break;
            }
            i = g;
            driveId = driveId2;
            Object list3 = c2;
        }
        if (parcel.dataPosition() == B) {
            return new SetResourceParentsRequest(i, driveId, list3);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: bs */
    public SetResourceParentsRequest[] newArray(int i) {
        return new SetResourceParentsRequest[i];
    }
}
