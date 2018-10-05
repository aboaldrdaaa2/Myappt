package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ji implements Creator<jh> {
    static void a(jh jhVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.a(parcel, 1, jhVar.getRequestId(), false);
        b.c(parcel, 1000, jhVar.getVersionCode());
        b.a(parcel, 2, jhVar.getExpirationTime());
        b.a(parcel, 3, jhVar.ja());
        b.a(parcel, 4, jhVar.getLatitude());
        b.a(parcel, 5, jhVar.getLongitude());
        b.a(parcel, 6, jhVar.jb());
        b.c(parcel, 7, jhVar.jc());
        b.c(parcel, 8, jhVar.getNotificationResponsiveness());
        b.c(parcel, 9, jhVar.jd());
        b.G(parcel, C);
    }

    /* renamed from: bt */
    public jh createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = (short) 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    str = a.o(parcel, A);
                    break;
                case 2:
                    j = a.i(parcel, A);
                    break;
                case 3:
                    s = a.f(parcel, A);
                    break;
                case 4:
                    d = a.m(parcel, A);
                    break;
                case 5:
                    d2 = a.m(parcel, A);
                    break;
                case 6:
                    f = a.l(parcel, A);
                    break;
                case 7:
                    i2 = a.g(parcel, A);
                    break;
                case 8:
                    i3 = a.g(parcel, A);
                    break;
                case 9:
                    i4 = a.g(parcel, A);
                    break;
                case 1000:
                    i = a.g(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new jh(i, str, i2, s, d, d2, f, j, i3, i4);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: cO */
    public jh[] newArray(int i) {
        return new jh[i];
    }
}
