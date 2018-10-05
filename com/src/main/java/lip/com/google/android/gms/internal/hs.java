package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hs implements Creator<hr> {
    static void a(hr hrVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, hrVar.xM);
        b.a(parcel, 2, hrVar.GT, false);
        b.c(parcel, 3, hrVar.GU);
        b.G(parcel, C);
    }

    /* renamed from: D */
    public hr createFromParcel(Parcel parcel) {
        int i = 0;
        int B = a.B(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i2 = a.g(parcel, A);
                    break;
                case 2:
                    str = a.o(parcel, A);
                    break;
                case 3:
                    i = a.g(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new hr(i2, str, i);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: as */
    public hr[] newArray(int i) {
        return new hr[i];
    }
}
