package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class fl implements Creator<fk> {
    static void a(fk fkVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.a(parcel, 1, fkVar.xU, false);
        b.c(parcel, 1000, fkVar.xM);
        b.a(parcel, 3, fkVar.xV, i, false);
        b.c(parcel, 4, fkVar.xW);
        b.a(parcel, 5, fkVar.xX, false);
        b.G(parcel, C);
    }

    /* renamed from: F */
    public fk[] newArray(int i) {
        return new fk[i];
    }

    /* renamed from: n */
    public fk createFromParcel(Parcel parcel) {
        byte[] bArr = null;
        int B = a.B(parcel);
        int i = 0;
        int i2 = -1;
        fp fpVar = null;
        String str = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    str = a.o(parcel, A);
                    break;
                case 3:
                    fpVar = (fp) a.a(parcel, A, fp.CREATOR);
                    break;
                case 4:
                    i2 = a.g(parcel, A);
                    break;
                case 5:
                    bArr = a.r(parcel, A);
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
            return new fk(i, str, fpVar, i2, bArr);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }
}
