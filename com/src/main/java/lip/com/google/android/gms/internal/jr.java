package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class jr implements Creator<jq> {
    static void a(jq jqVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1000, jqVar.xM);
        b.a(parcel, 2, jqVar.jf(), i, false);
        b.a(parcel, 3, jqVar.getInterval());
        b.c(parcel, 4, jqVar.getPriority());
        b.G(parcel, C);
    }

    /* renamed from: bx */
    public jq createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
        int i = 0;
        jm jmVar = null;
        long j = jq.Wm;
        int i2 = 102;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 2:
                    jmVar = (jm) a.a(parcel, A, jm.CREATOR);
                    break;
                case 3:
                    j = a.i(parcel, A);
                    break;
                case 4:
                    i2 = a.g(parcel, A);
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
            return new jq(i, jmVar, j, i2);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: cS */
    public jq[] newArray(int i) {
        return new jq[i];
    }
}
