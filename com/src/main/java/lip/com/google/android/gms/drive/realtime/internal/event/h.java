package lip.com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h implements Creator<ValuesAddedDetails> {
    static void a(ValuesAddedDetails valuesAddedDetails, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, valuesAddedDetails.xM);
        b.c(parcel, 2, valuesAddedDetails.mIndex);
        b.c(parcel, 3, valuesAddedDetails.LF);
        b.c(parcel, 4, valuesAddedDetails.LG);
        b.a(parcel, 5, valuesAddedDetails.LN, false);
        b.c(parcel, 6, valuesAddedDetails.LO);
        b.G(parcel, C);
    }

    /* renamed from: bX */
    public ValuesAddedDetails[] newArray(int i) {
        return new ValuesAddedDetails[i];
    }

    /* renamed from: ba */
    public ValuesAddedDetails createFromParcel(Parcel parcel) {
        int i = 0;
        int B = a.B(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i5 = a.g(parcel, A);
                    break;
                case 2:
                    i4 = a.g(parcel, A);
                    break;
                case 3:
                    i3 = a.g(parcel, A);
                    break;
                case 4:
                    i2 = a.g(parcel, A);
                    break;
                case 5:
                    str = a.o(parcel, A);
                    break;
                case 6:
                    i = a.g(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ValuesAddedDetails(i5, i4, i3, i2, str, i);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }
}
