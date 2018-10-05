package lip.com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class aj implements Creator<ai> {
    static void a(ai aiVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, aiVar.xM);
        b.a(parcel, 2, aiVar.getId(), false);
        b.a(parcel, 3, aiVar.getDisplayName(), false);
        b.G(parcel, C);
    }

    /* renamed from: cF */
    public ai createFromParcel(Parcel parcel) {
        String str = null;
        int B = a.B(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    str2 = a.o(parcel, A);
                    break;
                case 3:
                    str = a.o(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ai(i, str2, str);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: eo */
    public ai[] newArray(int i) {
        return new ai[i];
    }
}
