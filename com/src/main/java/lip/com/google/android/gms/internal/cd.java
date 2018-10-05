package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class cd implements Creator<ce> {
    static void a(ce ceVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, ceVar.versionCode);
        b.a(parcel, 2, ceVar.oa, false);
        b.a(parcel, 3, ceVar.ob, false);
        b.a(parcel, 4, ceVar.mimeType, false);
        b.a(parcel, 5, ceVar.packageName, false);
        b.a(parcel, 6, ceVar.oc, false);
        b.a(parcel, 7, ceVar.od, false);
        b.a(parcel, 8, ceVar.oe, false);
        b.G(parcel, C);
    }

    /* renamed from: e */
    public ce createFromParcel(Parcel parcel) {
        String str = null;
        int B = a.B(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    str7 = a.o(parcel, A);
                    break;
                case 3:
                    str6 = a.o(parcel, A);
                    break;
                case 4:
                    str5 = a.o(parcel, A);
                    break;
                case 5:
                    str4 = a.o(parcel, A);
                    break;
                case 6:
                    str3 = a.o(parcel, A);
                    break;
                case 7:
                    str2 = a.o(parcel, A);
                    break;
                case 8:
                    str = a.o(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ce(i, str7, str6, str5, str4, str3, str2, str);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: i */
    public ce[] newArray(int i) {
        return new ce[i];
    }
}
