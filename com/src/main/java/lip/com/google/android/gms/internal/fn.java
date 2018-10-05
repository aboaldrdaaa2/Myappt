package lip.com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class fn implements Creator<fm> {
    static void a(fm fmVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, fmVar.id);
        b.c(parcel, 1000, fmVar.xM);
        b.a(parcel, 2, fmVar.xY, false);
        b.G(parcel, C);
    }

    /* renamed from: G */
    public fm[] newArray(int i) {
        return new fm[i];
    }

    /* renamed from: o */
    public fm createFromParcel(Parcel parcel) {
        int i = 0;
        int B = a.B(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    bundle = a.q(parcel, A);
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
            return new fm(i2, i, bundle);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }
}
