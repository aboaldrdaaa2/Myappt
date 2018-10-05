package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class jl implements Creator<jk> {
    static void a(jk jkVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, jkVar.jc());
        b.c(parcel, 1000, jkVar.getVersionCode());
        b.c(parcel, 2, jkVar.je());
        b.a(parcel, 3, jkVar.jf(), i, false);
        b.G(parcel, C);
    }

    /* renamed from: bu */
    public jk createFromParcel(Parcel parcel) {
        int i = 0;
        int B = a.B(parcel);
        int i2 = -1;
        jm jmVar = null;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    i2 = a.g(parcel, A);
                    break;
                case 3:
                    jmVar = (jm) a.a(parcel, A, jm.CREATOR);
                    break;
                case 1000:
                    i3 = a.g(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new jk(i3, i, i2, jmVar);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: cP */
    public jk[] newArray(int i) {
        return new jk[i];
    }
}
