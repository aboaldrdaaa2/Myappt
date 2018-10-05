package lip.com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public class a implements Creator<Address> {
    static void a(Address address, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, address.getVersionCode());
        b.a(parcel, 2, address.name, false);
        b.a(parcel, 3, address.UH, false);
        b.a(parcel, 4, address.UI, false);
        b.a(parcel, 5, address.UJ, false);
        b.a(parcel, 6, address.rf, false);
        b.a(parcel, 7, address.aiI, false);
        b.a(parcel, 8, address.aiJ, false);
        b.a(parcel, 9, address.UO, false);
        b.a(parcel, 10, address.UQ, false);
        b.a(parcel, 11, address.UR);
        b.a(parcel, 12, address.US, false);
        b.G(parcel, C);
    }

    /* renamed from: bQ */
    public Address createFromParcel(Parcel parcel) {
        int B = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        boolean z = false;
        String str10 = null;
        while (parcel.dataPosition() < B) {
            int A = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.ar(A)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, A);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 4:
                    str3 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 6:
                    str5 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 7:
                    str6 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 8:
                    str7 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 9:
                    str8 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 10:
                    str9 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                case 11:
                    z = com.google.android.gms.common.internal.safeparcel.a.c(parcel, A);
                    break;
                case 12:
                    str10 = com.google.android.gms.common.internal.safeparcel.a.o(parcel, A);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new Address(i, str, str2, str3, str4, str5, str6, str7, str8, str9, z, str10);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: dw */
    public Address[] newArray(int i) {
        return new Address[i];
    }
}
