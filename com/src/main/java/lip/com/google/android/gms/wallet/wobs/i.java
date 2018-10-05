package lip.com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class i implements Creator<f> {
    static void a(f fVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, fVar.getVersionCode());
        b.a(parcel, 2, fVar.label, false);
        b.a(parcel, 3, fVar.akS, i, false);
        b.a(parcel, 4, fVar.type, false);
        b.a(parcel, 5, fVar.ajs, i, false);
        b.G(parcel, C);
    }

    /* renamed from: cn */
    public f createFromParcel(Parcel parcel) {
        l lVar = null;
        int B = a.B(parcel);
        int i = 0;
        String str = null;
        g gVar = null;
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
                    gVar = (g) a.a(parcel, A, g.CREATOR);
                    break;
                case 4:
                    str = a.o(parcel, A);
                    break;
                case 5:
                    lVar = (l) a.a(parcel, A, l.CREATOR);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new f(i, str2, gVar, str, lVar);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: dV */
    public f[] newArray(int i) {
        return new f[i];
    }
}
