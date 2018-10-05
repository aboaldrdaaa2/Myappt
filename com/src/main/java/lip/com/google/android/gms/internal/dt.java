package lip.com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class dt implements Creator<ds> {
    static void a(ds dsVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, dsVar.versionCode);
        b.a(parcel, 2, dsVar.pW, false);
        b.a(parcel, 3, dsVar.pX, i, false);
        b.a(parcel, 4, dsVar.kT, i, false);
        b.a(parcel, 5, dsVar.kN, false);
        b.a(parcel, 6, dsVar.applicationInfo, i, false);
        b.a(parcel, 7, dsVar.pY, i, false);
        b.a(parcel, 8, dsVar.pZ, false);
        b.a(parcel, 9, dsVar.qa, false);
        b.a(parcel, 10, dsVar.qb, false);
        b.a(parcel, 11, dsVar.kQ, i, false);
        b.a(parcel, 12, dsVar.qc, false);
        b.a(parcel, 13, dsVar.qd, false);
        b.G(parcel, C);
    }

    /* renamed from: h */
    public ds createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
        int i = 0;
        Bundle bundle = null;
        ai aiVar = null;
        al alVar = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        ev evVar = null;
        Bundle bundle2 = null;
        String str5 = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    bundle = a.q(parcel, A);
                    break;
                case 3:
                    aiVar = (ai) a.a(parcel, A, ai.CREATOR);
                    break;
                case 4:
                    alVar = (al) a.a(parcel, A, al.CREATOR);
                    break;
                case 5:
                    str = a.o(parcel, A);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) a.a(parcel, A, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) a.a(parcel, A, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = a.o(parcel, A);
                    break;
                case 9:
                    str3 = a.o(parcel, A);
                    break;
                case 10:
                    str4 = a.o(parcel, A);
                    break;
                case 11:
                    evVar = (ev) a.a(parcel, A, ev.CREATOR);
                    break;
                case 12:
                    bundle2 = a.q(parcel, A);
                    break;
                case 13:
                    str5 = a.o(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ds(i, bundle, aiVar, alVar, str, applicationInfo, packageInfo, str2, str3, str4, evVar, bundle2, str5);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: m */
    public ds[] newArray(int i) {
        return new ds[i];
    }
}
