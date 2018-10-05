package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class kq implements Creator<kp> {
    static void a(kp kpVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        Set kk = kpVar.kk();
        if (kk.contains(Integer.valueOf(1))) {
            b.c(parcel, 1, kpVar.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            b.a(parcel, 2, kpVar.getId(), true);
        }
        if (kk.contains(Integer.valueOf(4))) {
            b.a(parcel, 4, kpVar.kB(), i, true);
        }
        if (kk.contains(Integer.valueOf(5))) {
            b.a(parcel, 5, kpVar.getStartDate(), true);
        }
        if (kk.contains(Integer.valueOf(6))) {
            b.a(parcel, 6, kpVar.kC(), i, true);
        }
        if (kk.contains(Integer.valueOf(7))) {
            b.a(parcel, 7, kpVar.getType(), true);
        }
        b.G(parcel, C);
    }

    /* renamed from: bF */
    public kp createFromParcel(Parcel parcel) {
        String str = null;
        int B = a.B(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        kn knVar = null;
        String str2 = null;
        kn knVar2 = null;
        String str3 = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            kn knVar3;
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str3 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 4:
                    knVar3 = (kn) a.a(parcel, A, kn.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    knVar2 = knVar3;
                    break;
                case 5:
                    str2 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    knVar3 = (kn) a.a(parcel, A, kn.CREATOR);
                    hashSet.add(Integer.valueOf(6));
                    knVar = knVar3;
                    break;
                case 7:
                    str = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new kp(hashSet, i, str3, knVar2, str2, knVar, str);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: dc */
    public kp[] newArray(int i) {
        return new kp[i];
    }
}
