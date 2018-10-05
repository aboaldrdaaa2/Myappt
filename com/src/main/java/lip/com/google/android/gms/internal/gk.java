package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class gk implements Creator<gj> {
    static void a(gj gjVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, gjVar.getVersionCode());
        b.a(parcel, 2, gjVar.eh());
        b.a(parcel, 3, gjVar.en());
        b.c(parcel, 4, gjVar.eo());
        b.G(parcel, C);
    }

    /* renamed from: Y */
    public gj[] newArray(int i) {
        return new gj[i];
    }

    /* renamed from: v */
    public gj createFromParcel(Parcel parcel) {
        int i = 0;
        int B = a.B(parcel);
        double d = 0.0d;
        boolean z = false;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i2 = a.g(parcel, A);
                    break;
                case 2:
                    d = a.m(parcel, A);
                    break;
                case 3:
                    z = a.c(parcel, A);
                    break;
                case 4:
                    i = a.g(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new gj(i2, d, z, i);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }
}
