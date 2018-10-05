package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.ks.h;
import java.util.HashSet;
import java.util.Set;

public class lc implements Creator<h> {
    static void a(h hVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        Set kk = hVar.kk();
        if (kk.contains(Integer.valueOf(1))) {
            b.c(parcel, 1, hVar.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(3))) {
            b.c(parcel, 3, hVar.kX());
        }
        if (kk.contains(Integer.valueOf(4))) {
            b.a(parcel, 4, hVar.getValue(), true);
        }
        if (kk.contains(Integer.valueOf(5))) {
            b.a(parcel, 5, hVar.getLabel(), true);
        }
        if (kk.contains(Integer.valueOf(6))) {
            b.c(parcel, 6, hVar.getType());
        }
        b.G(parcel, C);
    }

    /* renamed from: bP */
    public h createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int B = a.B(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i3 = a.g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 3:
                    i = a.g(parcel, A);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str2 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    i2 = a.g(parcel, A);
                    hashSet.add(Integer.valueOf(6));
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new h(hashSet, i3, str2, i2, str, i);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: dm */
    public h[] newArray(int i) {
        return new h[i];
    }
}
