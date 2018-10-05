package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.internal.ks.b.b;
import java.util.HashSet;
import java.util.Set;

public class kx implements Creator<b> {
    static void a(b bVar, Parcel parcel, int i) {
        int C = com.google.android.gms.common.internal.safeparcel.b.C(parcel);
        Set kk = bVar.kk();
        if (kk.contains(Integer.valueOf(1))) {
            com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, bVar.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            com.google.android.gms.common.internal.safeparcel.b.c(parcel, 2, bVar.getHeight());
        }
        if (kk.contains(Integer.valueOf(3))) {
            com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, bVar.getUrl(), true);
        }
        if (kk.contains(Integer.valueOf(4))) {
            com.google.android.gms.common.internal.safeparcel.b.c(parcel, 4, bVar.getWidth());
        }
        com.google.android.gms.common.internal.safeparcel.b.G(parcel, C);
    }

    /* renamed from: bK */
    public b createFromParcel(Parcel parcel) {
        int i = 0;
        int B = a.B(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i3 = a.g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    i2 = a.g(parcel, A);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    i = a.g(parcel, A);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new b(hashSet, i3, i2, str, i);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: dh */
    public b[] newArray(int i) {
        return new b[i];
    }
}
