package lip.com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.ig;
import java.util.ArrayList;

public class e implements Creator<d> {
    static void a(d dVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, dVar.getVersionCode());
        b.a(parcel, 2, dVar.akP, false);
        b.a(parcel, 3, dVar.akQ, false);
        b.b(parcel, 4, dVar.akR, false);
        b.G(parcel, C);
    }

    /* renamed from: cl */
    public d createFromParcel(Parcel parcel) {
        String str = null;
        int B = a.B(parcel);
        int i = 0;
        ArrayList ga = ig.ga();
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
                    ga = a.c(parcel, A, b.CREATOR);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new d(i, str2, str, ga);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: dT */
    public d[] newArray(int i) {
        return new d[i];
    }
}
