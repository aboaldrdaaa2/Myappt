package lip.com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;

public class b implements Creator<EndCompoundOperationRequest> {
    static void a(EndCompoundOperationRequest endCompoundOperationRequest, Parcel parcel, int i) {
        int C = com.google.android.gms.common.internal.safeparcel.b.C(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, endCompoundOperationRequest.xM);
        com.google.android.gms.common.internal.safeparcel.b.G(parcel, C);
    }

    /* renamed from: aQ */
    public EndCompoundOperationRequest createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new EndCompoundOperationRequest(i);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: bM */
    public EndCompoundOperationRequest[] newArray(int i) {
        return new EndCompoundOperationRequest[i];
    }
}
