package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

public class jv implements Creator<ju> {
    static void a(ju juVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.a(parcel, 1, juVar.getName(), false);
        b.c(parcel, 1000, juVar.xM);
        b.a(parcel, 2, juVar.jk(), i, false);
        b.a(parcel, 3, juVar.getAddress(), false);
        b.b(parcel, 4, juVar.jl(), false);
        b.a(parcel, 5, juVar.getPhoneNumber(), false);
        b.a(parcel, 6, juVar.jm(), false);
        b.G(parcel, C);
    }

    /* renamed from: bz */
    public ju createFromParcel(Parcel parcel) {
        String str = null;
        int B = a.B(parcel);
        int i = 0;
        String str2 = null;
        List list = null;
        String str3 = null;
        LatLng latLng = null;
        String str4 = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    str4 = a.o(parcel, A);
                    break;
                case 2:
                    latLng = (LatLng) a.a(parcel, A, LatLng.CREATOR);
                    break;
                case 3:
                    str3 = a.o(parcel, A);
                    break;
                case 4:
                    list = a.c(parcel, A, js.CREATOR);
                    break;
                case 5:
                    str2 = a.o(parcel, A);
                    break;
                case 6:
                    str = a.o(parcel, A);
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
            return new ju(i, str4, latLng, str3, list, str2, str);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: cU */
    public ju[] newArray(int i) {
        return new ju[i];
    }
}
