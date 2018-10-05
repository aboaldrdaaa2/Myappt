package lip.com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h implements Creator<g> {
    static void a(g gVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, gVar.getVersionCode());
        b.c(parcel, 2, gVar.akT);
        b.a(parcel, 3, gVar.akU, false);
        b.a(parcel, 4, gVar.akV);
        b.a(parcel, 5, gVar.akW, false);
        b.a(parcel, 6, gVar.akX);
        b.c(parcel, 7, gVar.akY);
        b.G(parcel, C);
    }

    /* renamed from: cm */
    public g createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int B = a.B(parcel);
        double d = 0.0d;
        long j = 0;
        int i2 = -1;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i3 = a.g(parcel, A);
                    break;
                case 2:
                    i = a.g(parcel, A);
                    break;
                case 3:
                    str2 = a.o(parcel, A);
                    break;
                case 4:
                    d = a.m(parcel, A);
                    break;
                case 5:
                    str = a.o(parcel, A);
                    break;
                case 6:
                    j = a.i(parcel, A);
                    break;
                case 7:
                    i2 = a.g(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new g(i3, i, str2, d, str, j, i2);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: dU */
    public g[] newArray(int i) {
        return new g[i];
    }
}
