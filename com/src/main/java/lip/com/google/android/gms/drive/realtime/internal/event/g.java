package lip.com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class g implements Creator<ValueChangedDetails> {
    static void a(ValueChangedDetails valueChangedDetails, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, valueChangedDetails.xM);
        b.c(parcel, 2, valueChangedDetails.LM);
        b.G(parcel, C);
    }

    /* renamed from: aZ */
    public ValueChangedDetails createFromParcel(Parcel parcel) {
        int i = 0;
        int B = a.B(parcel);
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i2 = a.g(parcel, A);
                    break;
                case 2:
                    i = a.g(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ValueChangedDetails(i2, i);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: bW */
    public ValueChangedDetails[] newArray(int i) {
        return new ValueChangedDetails[i];
    }
}
