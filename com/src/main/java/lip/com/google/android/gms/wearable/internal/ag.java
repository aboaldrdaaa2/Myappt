package lip.com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ag implements Creator<af> {
    static void a(af afVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, afVar.xM);
        b.c(parcel, 2, afVar.getRequestId());
        b.a(parcel, 3, afVar.getPath(), false);
        b.a(parcel, 4, afVar.getData(), false);
        b.a(parcel, 5, afVar.getSourceNodeId(), false);
        b.G(parcel, C);
    }

    /* renamed from: cE */
    public af createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int B = a.B(parcel);
        byte[] bArr = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i2 = a.g(parcel, A);
                    break;
                case 2:
                    i = a.g(parcel, A);
                    break;
                case 3:
                    str2 = a.o(parcel, A);
                    break;
                case 4:
                    bArr = a.r(parcel, A);
                    break;
                case 5:
                    str = a.o(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new af(i2, i, str2, bArr, str);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: en */
    public af[] newArray(int i) {
        return new af[i];
    }
}
