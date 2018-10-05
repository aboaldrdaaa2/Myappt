package lip.com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class aa implements Creator<z> {
    static void a(z zVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, zVar.versionCode);
        b.c(parcel, 2, zVar.statusCode);
        b.a(parcel, 3, zVar.alQ, i, false);
        b.G(parcel, C);
    }

    /* renamed from: cD */
    public z createFromParcel(Parcel parcel) {
        int i = 0;
        int B = a.B(parcel);
        ai aiVar = null;
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
                    aiVar = (ai) a.a(parcel, A, ai.CREATOR);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new z(i2, i, aiVar);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: em */
    public z[] newArray(int i) {
        return new z[i];
    }
}
