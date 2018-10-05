package lip.com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class d implements Creator<ReferenceShiftedDetails> {
    static void a(ReferenceShiftedDetails referenceShiftedDetails, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, referenceShiftedDetails.xM);
        b.a(parcel, 2, referenceShiftedDetails.LH, false);
        b.a(parcel, 3, referenceShiftedDetails.LI, false);
        b.c(parcel, 4, referenceShiftedDetails.LJ);
        b.c(parcel, 5, referenceShiftedDetails.LK);
        b.G(parcel, C);
    }

    /* renamed from: aW */
    public ReferenceShiftedDetails createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int B = a.B(parcel);
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i3 = a.g(parcel, A);
                    break;
                case 2:
                    str2 = a.o(parcel, A);
                    break;
                case 3:
                    str = a.o(parcel, A);
                    break;
                case 4:
                    i2 = a.g(parcel, A);
                    break;
                case 5:
                    i = a.g(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ReferenceShiftedDetails(i3, str2, str, i2, i);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: bT */
    public ReferenceShiftedDetails[] newArray(int i) {
        return new ReferenceShiftedDetails[i];
    }
}
