package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class jn implements Creator<jm> {
    static void a(jm jmVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.b(parcel, 1, jmVar.Wc, false);
        b.c(parcel, 1000, jmVar.xM);
        b.a(parcel, 2, jmVar.jg(), false);
        b.a(parcel, 3, jmVar.jh());
        b.b(parcel, 4, jmVar.Wf, false);
        b.a(parcel, 5, jmVar.ji(), false);
        b.a(parcel, 6, jmVar.Wh, false);
        b.G(parcel, C);
    }

    /* renamed from: bv */
    public jm createFromParcel(Parcel parcel) {
        boolean z = false;
        List list = null;
        int B = a.B(parcel);
        String str = null;
        List list2 = null;
        String str2 = null;
        List list3 = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    list3 = a.c(parcel, A, js.CREATOR);
                    break;
                case 2:
                    str2 = a.o(parcel, A);
                    break;
                case 3:
                    z = a.c(parcel, A);
                    break;
                case 4:
                    list2 = a.c(parcel, A, jw.CREATOR);
                    break;
                case 5:
                    str = a.o(parcel, A);
                    break;
                case 6:
                    list = a.B(parcel, A);
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
            return new jm(i, list3, str2, z, list2, str, list);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: cQ */
    public jm[] newArray(int i) {
        return new jm[i];
    }
}
