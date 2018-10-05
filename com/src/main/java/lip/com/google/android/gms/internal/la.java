package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.ks.f;
import java.util.HashSet;
import java.util.Set;

public class la implements Creator<f> {
    static void a(f fVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        Set kk = fVar.kk();
        if (kk.contains(Integer.valueOf(1))) {
            b.c(parcel, 1, fVar.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            b.a(parcel, 2, fVar.getDepartment(), true);
        }
        if (kk.contains(Integer.valueOf(3))) {
            b.a(parcel, 3, fVar.getDescription(), true);
        }
        if (kk.contains(Integer.valueOf(4))) {
            b.a(parcel, 4, fVar.getEndDate(), true);
        }
        if (kk.contains(Integer.valueOf(5))) {
            b.a(parcel, 5, fVar.getLocation(), true);
        }
        if (kk.contains(Integer.valueOf(6))) {
            b.a(parcel, 6, fVar.getName(), true);
        }
        if (kk.contains(Integer.valueOf(7))) {
            b.a(parcel, 7, fVar.isPrimary());
        }
        if (kk.contains(Integer.valueOf(8))) {
            b.a(parcel, 8, fVar.getStartDate(), true);
        }
        if (kk.contains(Integer.valueOf(9))) {
            b.a(parcel, 9, fVar.getTitle(), true);
        }
        if (kk.contains(Integer.valueOf(10))) {
            b.c(parcel, 10, fVar.getType());
        }
        b.G(parcel, C);
    }

    /* renamed from: bN */
    public f createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int B = a.B(parcel);
        Set hashSet = new HashSet();
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i2 = a.g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str7 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str6 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str5 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str4 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str3 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    z = a.c(parcel, A);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    str2 = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str = a.o(parcel, A);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    i = a.g(parcel, A);
                    hashSet.add(Integer.valueOf(10));
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new f(hashSet, i2, str7, str6, str5, str4, str3, z, str2, str, i);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: dk */
    public f[] newArray(int i) {
        return new f[i];
    }
}
