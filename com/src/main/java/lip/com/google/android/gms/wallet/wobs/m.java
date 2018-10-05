package lip.com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class m implements Creator<l> {
    static void a(l lVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, lVar.getVersionCode());
        b.a(parcel, 2, lVar.ala);
        b.a(parcel, 3, lVar.alb);
        b.G(parcel, C);
    }

    /* renamed from: cp */
    public l createFromParcel(Parcel parcel) {
        long j = 0;
        int B = a.B(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    j2 = a.i(parcel, A);
                    break;
                case 3:
                    j = a.i(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new l(i, j2, j);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: dX */
    public l[] newArray(int i) {
        return new l[i];
    }
}
