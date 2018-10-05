package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.ks.a;
import java.util.HashSet;
import java.util.Set;

public class ku implements Creator<a> {
    static void a(a aVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        Set kk = aVar.kk();
        if (kk.contains(Integer.valueOf(1))) {
            b.c(parcel, 1, aVar.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            b.c(parcel, 2, aVar.getMax());
        }
        if (kk.contains(Integer.valueOf(3))) {
            b.c(parcel, 3, aVar.getMin());
        }
        b.G(parcel, C);
    }

    /* renamed from: bH */
    public a createFromParcel(Parcel parcel) {
        int i = 0;
        int B = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(A)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new a(hashSet, i3, i2, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: de */
    public a[] newArray(int i) {
        return new a[i];
    }
}
