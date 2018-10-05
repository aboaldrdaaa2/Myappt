package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.gy.a;
import java.util.List;

public class hl implements Creator<a> {
    static void a(a aVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.a(parcel, 1, aVar.getAccountName(), false);
        b.c(parcel, 1000, aVar.getVersionCode());
        b.a(parcel, 2, aVar.fl(), false);
        b.c(parcel, 3, aVar.fk());
        b.a(parcel, 4, aVar.fn(), false);
        b.G(parcel, C);
    }

    /* renamed from: aq */
    public a[] newArray(int i) {
        return new a[i];
    }

    /* renamed from: z */
    public a createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int B = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
        List list = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(A)) {
                case 1:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 2:
                    list = com.google.android.gms.common.internal.safeparcel.a.B(parcel, A);
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 1000:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new a(i2, str2, list, i, str);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + B, parcel);
    }
}
