package lip.com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;

public class b implements Creator<UserAddress> {
    static void a(UserAddress userAddress, Parcel parcel, int i) {
        int C = com.google.android.gms.common.internal.safeparcel.b.C(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, userAddress.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, userAddress.name, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, userAddress.UH, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, userAddress.UI, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, userAddress.UJ, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, userAddress.UK, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 7, userAddress.UL, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 8, userAddress.UM, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 9, userAddress.UN, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 10, userAddress.rf, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 11, userAddress.UO, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 12, userAddress.UP, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 13, userAddress.UQ, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 14, userAddress.UR);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 15, userAddress.US, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 16, userAddress.UT, false);
        com.google.android.gms.common.internal.safeparcel.b.G(parcel, C);
    }

    /* renamed from: br */
    public UserAddress createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
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
        String str10 = null;
        String str11 = null;
        String str12 = null;
        boolean z = false;
        String str13 = null;
        String str14 = null;
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
                    str3 = a.o(parcel, A);
                    break;
                case 5:
                    str4 = a.o(parcel, A);
                    break;
                case 6:
                    str5 = a.o(parcel, A);
                    break;
                case 7:
                    str6 = a.o(parcel, A);
                    break;
                case 8:
                    str7 = a.o(parcel, A);
                    break;
                case 9:
                    str8 = a.o(parcel, A);
                    break;
                case 10:
                    str9 = a.o(parcel, A);
                    break;
                case 11:
                    str10 = a.o(parcel, A);
                    break;
                case 12:
                    str11 = a.o(parcel, A);
                    break;
                case 13:
                    str12 = a.o(parcel, A);
                    break;
                case 14:
                    z = a.c(parcel, A);
                    break;
                case 15:
                    str13 = a.o(parcel, A);
                    break;
                case 16:
                    str14 = a.o(parcel, A);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new UserAddress(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, z, str13, str14);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: cE */
    public UserAddress[] newArray(int i) {
        return new UserAddress[i];
    }
}
