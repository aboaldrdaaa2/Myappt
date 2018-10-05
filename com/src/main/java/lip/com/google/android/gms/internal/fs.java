package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class fs implements Creator<fr> {
    static void a(fr frVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.a(parcel, 1, frVar.yq, i, false);
        b.c(parcel, 1000, frVar.xM);
        b.a(parcel, 2, frVar.yr);
        b.c(parcel, 3, frVar.ys);
        b.a(parcel, 4, frVar.mP, false);
        b.a(parcel, 5, frVar.yt, i, false);
        b.G(parcel, C);
    }

    /* renamed from: K */
    public fr[] newArray(int i) {
        return new fr[i];
    }

    /* renamed from: q */
    public fr createFromParcel(Parcel parcel) {
        int i = 0;
        fg fgVar = null;
        int B = a.B(parcel);
        long j = 0;
        String str = null;
        fi fiVar = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    fiVar = (fi) a.a(parcel, A, fi.CREATOR);
                    break;
                case 2:
                    j = a.i(parcel, A);
                    break;
                case 3:
                    i = a.g(parcel, A);
                    break;
                case 4:
                    str = a.o(parcel, A);
                    break;
                case 5:
                    fgVar = (fg) a.a(parcel, A, fg.CREATOR);
                    break;
                case 1000:
                    i2 = a.g(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new fr(i2, fiVar, j, i, str, fgVar);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }
}
