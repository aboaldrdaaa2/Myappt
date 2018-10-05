package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.internal.ks.b;
import java.util.HashSet;
import java.util.Set;

public class kv implements Creator<b> {
    static void a(b bVar, Parcel parcel, int i) {
        int C = com.google.android.gms.common.internal.safeparcel.b.C(parcel);
        Set kk = bVar.kk();
        if (kk.contains(Integer.valueOf(1))) {
            com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, bVar.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, bVar.kO(), i, true);
        }
        if (kk.contains(Integer.valueOf(3))) {
            com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, bVar.kP(), i, true);
        }
        if (kk.contains(Integer.valueOf(4))) {
            com.google.android.gms.common.internal.safeparcel.b.c(parcel, 4, bVar.getLayout());
        }
        com.google.android.gms.common.internal.safeparcel.b.G(parcel, C);
    }

    /* renamed from: bI */
    public b createFromParcel(Parcel parcel) {
        b.b bVar = null;
        int i = 0;
        int B = a.B(parcel);
        Set hashSet = new HashSet();
        b.a aVar = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i2 = a.g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    b.a aVar2 = (b.a) a.a(parcel, A, b.a.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    aVar = aVar2;
                    break;
                case 3:
                    b.b bVar2 = (b.b) a.a(parcel, A, b.b.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    bVar = bVar2;
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
            return new b(hashSet, i2, aVar, bVar, i);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: df */
    public b[] newArray(int i) {
        return new b[i];
    }
}
