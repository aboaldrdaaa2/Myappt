package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class lj implements Creator<li> {
    static void a(li liVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, liVar.getVersionCode());
        b.a(parcel, 2, liVar.ake, false);
        b.a(parcel, 3, liVar.akf, false);
        b.G(parcel, C);
    }

    /* renamed from: cf */
    public li createFromParcel(Parcel parcel) {
        String[] strArr = null;
        int B = a.B(parcel);
        int i = 0;
        byte[][] bArr = (byte[][]) null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    strArr = a.A(parcel, A);
                    break;
                case 3:
                    bArr = a.s(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new li(i, strArr, bArr);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: dL */
    public li[] newArray(int i) {
        return new li[i];
    }
}
