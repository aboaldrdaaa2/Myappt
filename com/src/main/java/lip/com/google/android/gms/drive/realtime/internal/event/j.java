package lip.com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class j implements Creator<ValuesSetDetails> {
    static void a(ValuesSetDetails valuesSetDetails, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, valuesSetDetails.xM);
        b.c(parcel, 2, valuesSetDetails.mIndex);
        b.c(parcel, 3, valuesSetDetails.LF);
        b.c(parcel, 4, valuesSetDetails.LG);
        b.G(parcel, C);
    }

    /* renamed from: bZ */
    public ValuesSetDetails[] newArray(int i) {
        return new ValuesSetDetails[i];
    }

    /* renamed from: bc */
    public ValuesSetDetails createFromParcel(Parcel parcel) {
        int i = 0;
        int B = a.B(parcel);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i4 = a.g(parcel, A);
                    break;
                case 2:
                    i3 = a.g(parcel, A);
                    break;
                case 3:
                    i2 = a.g(parcel, A);
                    break;
                case 4:
                    i = a.g(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ValuesSetDetails(i4, i3, i2, i);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }
}
