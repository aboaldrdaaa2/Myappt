package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class fj implements Creator<fi> {
    static void a(fi fiVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.a(parcel, 1, fiVar.xQ, false);
        b.c(parcel, 1000, fiVar.xM);
        b.a(parcel, 2, fiVar.xR, false);
        b.a(parcel, 3, fiVar.xS, false);
        b.G(parcel, C);
    }

    /* renamed from: E */
    public fi[] newArray(int i) {
        return new fi[i];
    }

    /* renamed from: m */
    public fi createFromParcel(Parcel parcel) {
        String str = null;
        int B = a.B(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    str3 = a.o(parcel, A);
                    break;
                case 2:
                    str2 = a.o(parcel, A);
                    break;
                case 3:
                    str = a.o(parcel, A);
                    break;
                case 1000:
                    i = a.g(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new fi(i, str3, str2, str);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }
}
