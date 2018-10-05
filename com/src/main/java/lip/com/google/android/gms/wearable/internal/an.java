package lip.com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class an implements Creator<am> {
    static void a(am amVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, amVar.versionCode);
        b.c(parcel, 2, amVar.statusCode);
        b.a(parcel, 3, amVar.alO, i, false);
        b.G(parcel, C);
    }

    /* renamed from: cH */
    public am createFromParcel(Parcel parcel) {
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
            return new am(i2, i, mVar);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: eq */
    public am[] newArray(int i) {
        return new am[i];
    }
}
