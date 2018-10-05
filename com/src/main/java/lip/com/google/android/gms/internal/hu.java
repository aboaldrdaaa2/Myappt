package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hu implements Creator<ht> {
    static void a(ht htVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, htVar.getVersionCode());
        b.a(parcel, 2, htVar.fB(), i, false);
        b.G(parcel, C);
    }

    /* renamed from: E */
    public ht createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
        int i = 0;
        hv hvVar = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    hvVar = (hv) a.a(parcel, A, hv.CREATOR);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ht(i, hvVar);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: at */
    public ht[] newArray(int i) {
        return new ht[i];
    }
}
