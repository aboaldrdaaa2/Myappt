package lip.com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class cp implements Creator<cq> {
    static void a(cq cqVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, cqVar.versionCode);
        b.a(parcel, 2, cqVar.bd(), false);
        b.a(parcel, 3, cqVar.be(), false);
        b.a(parcel, 4, cqVar.bf(), false);
        b.a(parcel, 5, cqVar.bg(), false);
        b.G(parcel, C);
    }

    /* renamed from: g */
    public cq createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        int B = a.B(parcel);
        int i = 0;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    iBinder4 = a.p(parcel, A);
                    break;
                case 3:
                    iBinder3 = a.p(parcel, A);
                    break;
                case 4:
                    iBinder2 = a.p(parcel, A);
                    break;
                case 5:
                    iBinder = a.p(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new cq(i, iBinder4, iBinder3, iBinder2, iBinder);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: k */
    public cq[] newArray(int i) {
        return new cq[i];
    }
}
