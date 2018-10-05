package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ew implements Creator<ev> {
    static void a(ev evVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, evVar.versionCode);
        b.a(parcel, 2, evVar.sw, false);
        b.c(parcel, 3, evVar.sx);
        b.c(parcel, 4, evVar.sy);
        b.a(parcel, 5, evVar.sz);
        b.G(parcel, C);
    }

    /* renamed from: j */
    public ev createFromParcel(Parcel parcel) {
        boolean z = false;
        int B = a.B(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i3 = a.g(parcel, A);
                    break;
                case 2:
                    str = a.o(parcel, A);
                    break;
                case 3:
                    i2 = a.g(parcel, A);
                    break;
                case 4:
                    i = a.g(parcel, A);
                    break;
                case 5:
                    z = a.c(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ev(i3, str, i2, i, z);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: q */
    public ev[] newArray(int i) {
        return new ev[i];
    }
}
