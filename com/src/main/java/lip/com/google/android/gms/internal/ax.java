package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ax implements Creator<aw> {
    static void a(aw awVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, awVar.versionCode);
        b.c(parcel, 2, awVar.mD);
        b.c(parcel, 3, awVar.backgroundColor);
        b.c(parcel, 4, awVar.mE);
        b.c(parcel, 5, awVar.mF);
        b.c(parcel, 6, awVar.mG);
        b.c(parcel, 7, awVar.mH);
        b.c(parcel, 8, awVar.mI);
        b.c(parcel, 9, awVar.mJ);
        b.a(parcel, 10, awVar.mK, false);
        b.c(parcel, 11, awVar.mL);
        b.a(parcel, 12, awVar.mM, false);
        b.c(parcel, 13, awVar.mN);
        b.c(parcel, 14, awVar.mO);
        b.a(parcel, 15, awVar.mP, false);
        b.G(parcel, C);
    }

    /* renamed from: d */
    public aw createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
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
                    i3 = a.g(parcel, A);
                    break;
                case 4:
                    i4 = a.g(parcel, A);
                    break;
                case 5:
                    i5 = a.g(parcel, A);
                    break;
                case 6:
                    i6 = a.g(parcel, A);
                    break;
                case 7:
                    i7 = a.g(parcel, A);
                    break;
                case 8:
                    i8 = a.g(parcel, A);
                    break;
                case 9:
                    i9 = a.g(parcel, A);
                    break;
                case 10:
                    str = a.o(parcel, A);
                    break;
                case 11:
                    i10 = a.g(parcel, A);
                    break;
                case 12:
                    str2 = a.o(parcel, A);
                    break;
                case 13:
                    i11 = a.g(parcel, A);
                    break;
                case 14:
                    i12 = a.g(parcel, A);
                    break;
                case 15:
                    str3 = a.o(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new aw(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: f */
    public aw[] newArray(int i) {
        return new aw[i];
    }
}
