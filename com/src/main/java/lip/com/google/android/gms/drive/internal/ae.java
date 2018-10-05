package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class ae implements Creator<LoadRealtimeRequest> {
    static void a(LoadRealtimeRequest loadRealtimeRequest, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, loadRealtimeRequest.xM);
        b.a(parcel, 2, loadRealtimeRequest.Hz, i, false);
        b.a(parcel, 3, loadRealtimeRequest.Js);
        b.G(parcel, C);
    }

    /* renamed from: ag */
    public LoadRealtimeRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        int B = a.B(parcel);
        DriveId driveId = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            DriveId driveId2;
            int g;
            boolean z2;
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    boolean z3 = z;
                    driveId2 = driveId;
                    g = a.g(parcel, A);
                    z2 = z3;
                    break;
                case 2:
                    g = i;
                    DriveId driveId3 = (DriveId) a.a(parcel, A, DriveId.CREATOR);
                    z2 = z;
                    driveId2 = driveId3;
                    break;
                case 3:
                    z2 = a.c(parcel, A);
                    driveId2 = driveId;
                    g = i;
                    break;
                default:
                    a.b(parcel, A);
                    z2 = z;
                    driveId2 = driveId;
                    g = i;
                    break;
            }
            i = g;
            driveId = driveId2;
            z = z2;
        }
        if (parcel.dataPosition() == B) {
            return new LoadRealtimeRequest(i, driveId, z);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: bc */
    public LoadRealtimeRequest[] newArray(int i) {
        return new LoadRealtimeRequest[i];
    }
}
