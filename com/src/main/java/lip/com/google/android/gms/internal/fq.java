package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class fq implements Creator<fp> {
    static void a(fp fpVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.a(parcel, 1, fpVar.name, false);
        b.c(parcel, 1000, fpVar.xM);
        b.a(parcel, 2, fpVar.yb, false);
        b.a(parcel, 3, fpVar.yc);
        b.c(parcel, 4, fpVar.weight);
        b.a(parcel, 5, fpVar.yd);
        b.a(parcel, 6, fpVar.ye, false);
        b.a(parcel, 7, fpVar.yf, i, false);
        b.a(parcel, 8, fpVar.yg, false);
        b.a(parcel, 11, fpVar.yh, false);
        b.G(parcel, C);
    }

    /* renamed from: J */
    public fp[] newArray(int i) {
        return new fp[i];
    }

    /* renamed from: p */
    public fp createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int B = a.B(parcel);
        int i = 1;
        int[] iArr = null;
        fm[] fmVarArr = null;
        String str2 = null;
        boolean z2 = false;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    str4 = a.o(parcel, A);
                    break;
                case 2:
                    str3 = a.o(parcel, A);
                    break;
                case 3:
                    z2 = a.c(parcel, A);
                    break;
                case 4:
                    i = a.g(parcel, A);
                    break;
                case 5:
                    z = a.c(parcel, A);
                    break;
                case 6:
                    str2 = a.o(parcel, A);
                    break;
                case 7:
                    fmVarArr = (fm[]) a.b(parcel, A, fm.CREATOR);
                    break;
                case 8:
                    iArr = a.u(parcel, A);
                    break;
                case 11:
                    str = a.o(parcel, A);
                    break;
                case 1000:
                    i2 = a.g(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new fp(i2, str4, str3, z2, i, z, str2, fmVarArr, iArr, str);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }
}
