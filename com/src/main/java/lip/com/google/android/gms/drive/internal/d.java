package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class d implements Creator<CheckResourceIdsExistRequest> {
    static void a(CheckResourceIdsExistRequest checkResourceIdsExistRequest, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, checkResourceIdsExistRequest.getVersionCode());
        b.a(parcel, 2, checkResourceIdsExistRequest.go(), false);
        b.G(parcel, C);
    }

    /* renamed from: T */
    public CheckResourceIdsExistRequest createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    list = a.B(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new CheckResourceIdsExistRequest(i, list);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: aO */
    public CheckResourceIdsExistRequest[] newArray(int i) {
        return new CheckResourceIdsExistRequest[i];
    }
}
