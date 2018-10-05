package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class w implements Creator<v> {
    static void a(v vVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, vVar.versionCode);
        b.a(parcel, 2, vVar.lb);
        b.a(parcel, 3, vVar.ld);
        b.G(parcel, C);
    }

    /* renamed from: a */
    public v createFromParcel(Parcel parcel) {
        boolean z = false;
        int B = a.B(parcel);
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    z2 = a.c(parcel, A);
                    break;
                case 3:
                    z = a.c(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new v(i, z2, z);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: b */
    public v[] newArray(int i) {
        return new v[i];
    }
}
