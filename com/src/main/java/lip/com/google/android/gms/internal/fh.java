package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class fh implements Creator<fg> {
    static void a(fg fgVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.a(parcel, 1, fgVar.xN, i, false);
        b.c(parcel, 1000, fgVar.xM);
        b.a(parcel, 2, fgVar.xO, false);
        b.a(parcel, 3, fgVar.xP);
        b.G(parcel, C);
    }

    /* renamed from: D */
    public fg[] newArray(int i) {
        return new fg[i];
    }

    /* renamed from: l */
    public fg createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int B = a.B(parcel);
        fk[] fkVarArr = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int i2;
            fk[] fkVarArr2;
            boolean z2;
            String str2;
            int A = a.A(parcel);
            boolean z3;
            switch (a.ar(A)) {
                case 1:
                    i2 = i;
                    String str3 = str;
                    fkVarArr2 = (fk[]) a.b(parcel, A, fk.CREATOR);
                    z2 = z;
                    str2 = str3;
                    break;
                case 2:
                    fkVarArr2 = fkVarArr;
                    i2 = i;
                    z3 = z;
                    str2 = a.o(parcel, A);
                    z2 = z3;
                    break;
                case 3:
                    z2 = a.c(parcel, A);
                    str2 = str;
                    fkVarArr2 = fkVarArr;
                    i2 = i;
                    break;
                case 1000:
                    z3 = z;
                    str2 = str;
                    fkVarArr2 = fkVarArr;
                    i2 = a.g(parcel, A);
                    z2 = z3;
                    break;
                default:
                    a.b(parcel, A);
                    z2 = z;
                    str2 = str;
                    fkVarArr2 = fkVarArr;
                    i2 = i;
                    break;
            }
            i = i2;
            fkVarArr = fkVarArr2;
            str = str2;
            z = z2;
        }
        if (parcel.dataPosition() == B) {
            return new fg(i, fkVarArr, str, z);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }
}
