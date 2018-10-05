package lip.com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class d implements Creator<c> {
    static void a(c cVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, cVar.xM);
        b.a(parcel, 2, cVar.getName(), false);
        b.a(parcel, 3, cVar.getAddress(), false);
        b.c(parcel, 4, cVar.getType());
        b.c(parcel, 5, cVar.getRole());
        b.a(parcel, 6, cVar.isEnabled());
        b.G(parcel, C);
    }

    /* renamed from: ct */
    public c createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int B = a.B(parcel);
        int i = 0;
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i3 = a.g(parcel, A);
                    break;
                case 2:
                    str2 = a.o(parcel, A);
                    break;
                case 3:
                    str = a.o(parcel, A);
                    break;
                case 4:
                    i2 = a.g(parcel, A);
                    break;
                case 5:
                    i = a.g(parcel, A);
                    break;
                case 6:
                    z = a.c(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new c(i3, str2, str, i2, i, z);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: eb */
    public c[] newArray(int i) {
        return new c[i];
    }
}
