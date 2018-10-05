package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class ic implements Creator<ib> {
    static void a(ib ibVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, ibVar.getVersionCode());
        b.b(parcel, 2, ibVar.fV(), false);
        b.a(parcel, 3, ibVar.fW(), false);
        b.G(parcel, C);
    }

    /* renamed from: J */
    public ib createFromParcel(Parcel parcel) {
        String str = null;
        int B = a.B(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    arrayList = a.c(parcel, A, ib.a.CREATOR);
                    break;
                case 3:
                    str = a.o(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ib(i, arrayList, str);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: ay */
    public ib[] newArray(int i) {
        return new ib[i];
    }
}
