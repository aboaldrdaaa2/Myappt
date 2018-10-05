package lip.com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class al implements Creator<ak> {
    static void a(ak akVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, akVar.versionCode);
        b.a(parcel, 2, akVar.packageName, false);
        b.a(parcel, 3, akVar.label, false);
        b.a(parcel, 4, akVar.amb);
        b.G(parcel, C);
    }

    /* renamed from: cG */
    public ak createFromParcel(Parcel parcel) {
        String str = null;
        int B = a.B(parcel);
        int i = 0;
        long j = 0;
        String str2 = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    str2 = a.o(parcel, A);
                    break;
                case 3:
                    str = a.o(parcel, A);
                    break;
                case 4:
                    j = a.i(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ak(i, str2, str, j);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: ep */
    public ak[] newArray(int i) {
        return new ak[i];
    }
}
