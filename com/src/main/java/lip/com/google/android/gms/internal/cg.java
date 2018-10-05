package lip.com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class cg implements Creator<ch> {
    static void a(ch chVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, chVar.versionCode);
        b.a(parcel, 2, chVar.ov, i, false);
        b.a(parcel, 3, chVar.aU(), false);
        b.a(parcel, 4, chVar.aV(), false);
        b.a(parcel, 5, chVar.aW(), false);
        b.a(parcel, 6, chVar.aX(), false);
        b.a(parcel, 7, chVar.oA, false);
        b.a(parcel, 8, chVar.oB);
        b.a(parcel, 9, chVar.oC, false);
        b.a(parcel, 10, chVar.aZ(), false);
        b.c(parcel, 11, chVar.orientation);
        b.c(parcel, 12, chVar.oE);
        b.a(parcel, 13, chVar.ob, false);
        b.a(parcel, 14, chVar.kQ, i, false);
        b.a(parcel, 15, chVar.aY(), false);
        b.a(parcel, 17, chVar.oH, i, false);
        b.a(parcel, 16, chVar.oG, false);
        b.G(parcel, C);
    }

    /* renamed from: f */
    public ch createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
        int i = 0;
        ce ceVar = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        ev evVar = null;
        IBinder iBinder6 = null;
        String str4 = null;
        v vVar = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    ceVar = (ce) a.a(parcel, A, ce.CREATOR);
                    break;
                case 3:
                    iBinder = a.p(parcel, A);
                    break;
                case 4:
                    iBinder2 = a.p(parcel, A);
                    break;
                case 5:
                    iBinder3 = a.p(parcel, A);
                    break;
                case 6:
                    iBinder4 = a.p(parcel, A);
                    break;
                case 7:
                    str = a.o(parcel, A);
                    break;
                case 8:
                    z = a.c(parcel, A);
                    break;
                case 9:
                    str2 = a.o(parcel, A);
                    break;
                case 10:
                    iBinder5 = a.p(parcel, A);
                    break;
                case 11:
                    i2 = a.g(parcel, A);
                    break;
                case 12:
                    i3 = a.g(parcel, A);
                    break;
                case 13:
                    str3 = a.o(parcel, A);
                    break;
                case 14:
                    evVar = (ev) a.a(parcel, A, (Creator) ev.CREATOR);
                    break;
                case 15:
                    iBinder6 = a.p(parcel, A);
                    break;
                case 16:
                    str4 = a.o(parcel, A);
                    break;
                case 17:
                    vVar = (v) a.a(parcel, A, (Creator) v.CREATOR);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ch(i, ceVar, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, evVar, iBinder6, str4, vVar);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: j */
    public ch[] newArray(int i) {
        return new ch[i];
    }
}
