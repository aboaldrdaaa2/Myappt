package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class gf implements Creator<ge> {
    static void a(ge geVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, geVar.getVersionCode());
        b.a(parcel, 2, geVar.ec(), false);
        b.G(parcel, C);
    }

    /* renamed from: S */
    public ge[] newArray(int i) {
        return new ge[i];
    }

    /* renamed from: u */
    public ge createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    str = a.o(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ge(i, str);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }
}
