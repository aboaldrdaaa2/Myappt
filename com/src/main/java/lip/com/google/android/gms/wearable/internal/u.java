package lip.com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class u implements Creator<t> {
    static void a(t tVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, tVar.versionCode);
        b.c(parcel, 2, tVar.statusCode);
        b.b(parcel, 3, tVar.alN, false);
        b.G(parcel, C);
    }

    /* renamed from: cA */
    public t createFromParcel(Parcel parcel) {
        int i = 0;
        int B = a.B(parcel);
        List list = null;
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
                    list = a.c(parcel, A, ai.CREATOR);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new t(i2, i, list);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: ej */
    public t[] newArray(int i) {
        return new t[i];
    }
}
