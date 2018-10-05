package lip.com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class aj implements Creator<ai> {
    static void a(ai aiVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, aiVar.versionCode);
        b.a(parcel, 2, aiVar.lS);
        b.a(parcel, 3, aiVar.extras, false);
        b.c(parcel, 4, aiVar.lT);
        b.a(parcel, 5, aiVar.lU, false);
        b.a(parcel, 6, aiVar.lV);
        b.c(parcel, 7, aiVar.lW);
        b.a(parcel, 8, aiVar.lX);
        b.a(parcel, 9, aiVar.lY, false);
        b.a(parcel, 10, aiVar.lZ, i, false);
        b.a(parcel, 11, aiVar.ma, i, false);
        b.a(parcel, 12, aiVar.mb, false);
        b.a(parcel, 13, aiVar.mc, false);
        b.G(parcel, C);
    }

    /* renamed from: b */
    public ai createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        List list = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        aw awVar = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    j = a.i(parcel, A);
                    break;
                case 3:
                    bundle = a.q(parcel, A);
                    break;
                case 4:
                    i2 = a.g(parcel, A);
                    break;
                case 5:
                    list = a.B(parcel, A);
                    break;
                case 6:
                    z = a.c(parcel, A);
                    break;
                case 7:
                    i3 = a.g(parcel, A);
                    break;
                case 8:
                    z2 = a.c(parcel, A);
                    break;
                case 9:
                    str = a.o(parcel, A);
                    break;
                case 10:
                    awVar = (aw) a.a(parcel, A, aw.CREATOR);
                    break;
                case 11:
                    location = (Location) a.a(parcel, A, Location.CREATOR);
                    break;
                case 12:
                    str2 = a.o(parcel, A);
                    break;
                case 13:
                    bundle2 = a.q(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ai(i, j, bundle, i2, list, z, i3, z2, str, awVar, location, str2, bundle2);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: c */
    public ai[] newArray(int i) {
        return new ai[i];
    }
}
