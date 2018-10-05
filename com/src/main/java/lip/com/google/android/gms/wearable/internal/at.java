package lip.com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class at implements Creator<as> {
    static void a(as asVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, asVar.versionCode);
        b.c(parcel, 2, asVar.statusCode);
        b.a(parcel, 3, asVar.amb);
        b.b(parcel, 4, asVar.amd, false);
        b.G(parcel, C);
    }

    /* renamed from: cK */
    public as createFromParcel(Parcel parcel) {
        int i = 0;
        int B = a.B(parcel);
        long j = 0;
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
                    j = a.i(parcel, A);
                    break;
                case 4:
                    list = a.c(parcel, A, ak.CREATOR);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new as(i2, i, j, list);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: et */
    public as[] newArray(int i) {
        return new as[i];
    }
}
