package lip.com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class w implements Creator<v> {
    static void a(v vVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, vVar.versionCode);
        b.c(parcel, 2, vVar.statusCode);
        b.a(parcel, 3, vVar.alO, i, false);
        b.G(parcel, C);
    }

    /* renamed from: cB */
    public v createFromParcel(Parcel parcel) {
        int i = 0;
        int B = a.B(parcel);
        m mVar = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i2 = a.g(parcel, A);
                    break;
                case 2:
                    i = a.g(parcel, A);
                    break;
                case 3:
                    mVar = (m) a.a(parcel, A, m.CREATOR);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new v(i2, i, mVar);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: ek */
    public v[] newArray(int i) {
        return new v[i];
    }
}
