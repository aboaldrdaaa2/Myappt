package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.ks.c;
import java.util.HashSet;
import java.util.Set;

public class ky implements Creator<c> {
    static void a(c cVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        Set kk = cVar.kk();
        if (kk.contains(Integer.valueOf(1))) {
            b.c(parcel, 1, cVar.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            b.a(parcel, 2, cVar.getUrl(), true);
        }
        b.G(parcel, C);
    }

    /* renamed from: bL */
    public c createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(2));
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new c(hashSet, i, str);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: di */
    public c[] newArray(int i) {
        return new c[i];
    }
}
