package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class if implements Creator<ie> {
    static void a(ie ieVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, ieVar.getVersionCode());
        b.a(parcel, 2, ieVar.fY(), false);
        b.a(parcel, 3, ieVar.fZ(), i, false);
        b.G(parcel, C);
    }

    /* renamed from: L */
    public ie createFromParcel(Parcel parcel) {
        ib ibVar = null;
        int B = a.B(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    parcel2 = a.C(parcel, A);
                    break;
                case 3:
                    ibVar = (ib) a.a(parcel, A, ib.CREATOR);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ie(i, parcel2, ibVar);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: aA */
    public ie[] newArray(int i) {
        return new ie[i];
    }
}
