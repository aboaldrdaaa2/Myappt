package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.hv.a;

public class hx implements Creator<a> {
    static void a(a aVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, aVar.versionCode);
        b.a(parcel, 2, aVar.GZ, false);
        b.c(parcel, 3, aVar.Ha);
        b.G(parcel, C);
    }

    /* renamed from: G */
    public a createFromParcel(Parcel parcel) {
        int i = 0;
        int B = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(A)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new a(i2, str, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: av */
    public a[] newArray(int i) {
        return new a[i];
    }
}
