package lip.com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.wearable.c;

public class s implements Creator<r> {
    static void a(r rVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, rVar.versionCode);
        b.c(parcel, 2, rVar.statusCode);
        b.a(parcel, 3, rVar.alM, i, false);
        b.G(parcel, C);
    }

    /* renamed from: cz */
    public r createFromParcel(Parcel parcel) {
        int i = 0;
        int B = a.B(parcel);
        c cVar = null;
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
                    cVar = (c) a.a(parcel, A, c.CREATOR);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new r(i2, i, cVar);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: ei */
    public r[] newArray(int i) {
        return new r[i];
    }
}
