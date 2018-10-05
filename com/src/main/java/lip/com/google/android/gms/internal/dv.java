package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.millennialmedia.android.MMException;
import java.util.List;

public class dv implements Creator<du> {
    static void a(du duVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, duVar.versionCode);
        b.a(parcel, 2, duVar.oA, false);
        b.a(parcel, 3, duVar.qe, false);
        b.a(parcel, 4, duVar.nt, false);
        b.c(parcel, 5, duVar.errorCode);
        b.a(parcel, 6, duVar.nu, false);
        b.a(parcel, 7, duVar.qf);
        b.a(parcel, 8, duVar.qg);
        b.a(parcel, 9, duVar.qh);
        b.a(parcel, 10, duVar.qi, false);
        b.a(parcel, 11, duVar.nx);
        b.c(parcel, 12, duVar.orientation);
        b.a(parcel, 13, duVar.qj, false);
        b.a(parcel, 14, duVar.qk);
        b.a(parcel, 15, duVar.ql, false);
        b.a(parcel, 19, duVar.qn, false);
        b.a(parcel, 18, duVar.qm);
        b.a(parcel, 21, duVar.qo, false);
        b.G(parcel, C);
    }

    /* renamed from: i */
    public du createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        int i2 = 0;
        List list2 = null;
        long j = 0;
        boolean z = false;
        long j2 = 0;
        List list3 = null;
        long j3 = 0;
        int i3 = 0;
        String str3 = null;
        long j4 = 0;
        String str4 = null;
        boolean z2 = false;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    str = a.o(parcel, A);
                    break;
                case 3:
                    str2 = a.o(parcel, A);
                    break;
                case 4:
                    list = a.B(parcel, A);
                    break;
                case 5:
                    i2 = a.g(parcel, A);
                    break;
                case 6:
                    list2 = a.B(parcel, A);
                    break;
                case 7:
                    j = a.i(parcel, A);
                    break;
                case 8:
                    z = a.c(parcel, A);
                    break;
                case 9:
                    j2 = a.i(parcel, A);
                    break;
                case 10:
                    list3 = a.B(parcel, A);
                    break;
                case 11:
                    j3 = a.i(parcel, A);
                    break;
                case 12:
                    i3 = a.g(parcel, A);
                    break;
                case 13:
                    str3 = a.o(parcel, A);
                    break;
                case 14:
                    j4 = a.i(parcel, A);
                    break;
                case 15:
                    str4 = a.o(parcel, A);
                    break;
                case 18:
                    z2 = a.c(parcel, A);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    str5 = a.o(parcel, A);
                    break;
                case MMException.DISPLAY_AD_EXPIRED /*21*/:
                    str6 = a.o(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new du(i, str, str2, list, i2, list2, j, z, j2, list3, j3, i3, str3, j4, str4, z2, str5, str6);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: n */
    public du[] newArray(int i) {
        return new du[i];
    }
}
