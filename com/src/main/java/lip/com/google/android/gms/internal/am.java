package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class am implements Creator<al> {
    static void a(al alVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, alVar.versionCode);
        b.a(parcel, 2, alVar.me, false);
        b.c(parcel, 3, alVar.height);
        b.c(parcel, 4, alVar.heightPixels);
        b.a(parcel, 5, alVar.mf);
        b.c(parcel, 6, alVar.width);
        b.c(parcel, 7, alVar.widthPixels);
        b.a(parcel, 8, alVar.mg, i, false);
        b.G(parcel, C);
    }

    /* renamed from: c */
    public al createFromParcel(Parcel parcel) {
        al[] alVarArr = null;
        int i = 0;
        int B = a.B(parcel);
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i5 = a.g(parcel, A);
                    break;
                case 2:
                    str = a.o(parcel, A);
                    break;
                case 3:
                    i4 = a.g(parcel, A);
                    break;
                case 4:
                    i3 = a.g(parcel, A);
                    break;
                case 5:
                    z = a.c(parcel, A);
                    break;
                case 6:
                    i2 = a.g(parcel, A);
                    break;
                case 7:
                    i = a.g(parcel, A);
                    break;
                case 8:
                    alVarArr = (al[]) a.b(parcel, A, al.CREATOR);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new al(i5, str, i4, i3, z, i2, i, alVarArr);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: d */
    public al[] newArray(int i) {
        return new al[i];
    }
}
