package lip.com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class q implements Creator<p> {
    static void a(p pVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, pVar.getVersionCode());
        b.a(parcel, 2, pVar.akZ, false);
        b.a(parcel, 3, pVar.qe, false);
        b.a(parcel, 4, pVar.ald, i, false);
        b.a(parcel, 5, pVar.ale, i, false);
        b.a(parcel, 6, pVar.alf, i, false);
        b.G(parcel, C);
    }

    /* renamed from: cr */
    public p createFromParcel(Parcel parcel) {
        n nVar = null;
        int B = a.B(parcel);
        int i = 0;
        n nVar2 = null;
        l lVar = null;
        String str = null;
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
                case 4:
                    lVar = (l) a.a(parcel, A, l.CREATOR);
                    break;
                case 5:
                    nVar2 = (n) a.a(parcel, A, n.CREATOR);
                    break;
                case 6:
                    nVar = (n) a.a(parcel, A, n.CREATOR);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new p(i, str2, str, lVar, nVar2, nVar);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: dZ */
    public p[] newArray(int i) {
        return new p[i];
    }
}
