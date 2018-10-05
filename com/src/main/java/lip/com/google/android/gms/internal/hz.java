package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.hy.a;

public class hz implements Creator<a> {
    static void a(a aVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, aVar.getVersionCode());
        b.c(parcel, 2, aVar.fE());
        b.a(parcel, 3, aVar.fK());
        b.c(parcel, 4, aVar.fF());
        b.a(parcel, 5, aVar.fL());
        b.a(parcel, 6, aVar.fM(), false);
        b.c(parcel, 7, aVar.fN());
        b.a(parcel, 8, aVar.fP(), false);
        b.a(parcel, 9, aVar.fR(), i, false);
        b.G(parcel, C);
    }

    /* renamed from: H */
    public a createFromParcel(Parcel parcel) {
        ht htVar = null;
        int i = 0;
        int B = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < B) {
            int A = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(A)) {
                case 1:
                    i4 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    break;
                case 2:
                    i3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    break;
                case 3:
                    z2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, A);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    break;
                case 5:
                    z = com.google.android.gms.common.internal.safeparcel.a.c(parcel, A);
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 7:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    break;
                case 8:
                    str = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 9:
                    htVar = (ht) com.google.android.gms.common.internal.safeparcel.a.a(parcel, A, ht.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new a(i4, i3, z2, i2, z, str2, i, str, htVar);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: aw */
    public a[] newArray(int i) {
        return new a[i];
    }
}
