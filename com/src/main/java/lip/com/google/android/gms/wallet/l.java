package lip.com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;

public class l implements Creator<MaskedWalletRequest> {
    static void a(MaskedWalletRequest maskedWalletRequest, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, maskedWalletRequest.getVersionCode());
        b.a(parcel, 2, maskedWalletRequest.aiR, false);
        b.a(parcel, 3, maskedWalletRequest.ajF);
        b.a(parcel, 4, maskedWalletRequest.ajG);
        b.a(parcel, 5, maskedWalletRequest.ajH);
        b.a(parcel, 6, maskedWalletRequest.ajI, false);
        b.a(parcel, 7, maskedWalletRequest.aiL, false);
        b.a(parcel, 8, maskedWalletRequest.ajJ, false);
        b.a(parcel, 9, maskedWalletRequest.aja, i, false);
        b.a(parcel, 10, maskedWalletRequest.ajK);
        b.a(parcel, 11, maskedWalletRequest.ajL);
        b.a(parcel, 12, maskedWalletRequest.ajM, i, false);
        b.a(parcel, 13, maskedWalletRequest.ajN);
        b.a(parcel, 14, maskedWalletRequest.ajO);
        b.b(parcel, 15, maskedWalletRequest.ajP, false);
        b.G(parcel, C);
    }

    /* renamed from: ca */
    public MaskedWalletRequest createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
        int i = 0;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Cart cart = null;
        boolean z4 = false;
        boolean z5 = false;
        CountrySpecification[] countrySpecificationArr = null;
        boolean z6 = true;
        boolean z7 = true;
        ArrayList arrayList = null;
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
                    z = a.c(parcel, A);
                    break;
                case 4:
                    z2 = a.c(parcel, A);
                    break;
                case 5:
                    z3 = a.c(parcel, A);
                    break;
                case 6:
                    str2 = a.o(parcel, A);
                    break;
                case 7:
                    str3 = a.o(parcel, A);
                    break;
                case 8:
                    str4 = a.o(parcel, A);
                    break;
                case 9:
                    cart = (Cart) a.a(parcel, A, Cart.CREATOR);
                    break;
                case 10:
                    z4 = a.c(parcel, A);
                    break;
                case 11:
                    z5 = a.c(parcel, A);
                    break;
                case 12:
                    countrySpecificationArr = (CountrySpecification[]) a.b(parcel, A, CountrySpecification.CREATOR);
                    break;
                case 13:
                    z6 = a.c(parcel, A);
                    break;
                case 14:
                    z7 = a.c(parcel, A);
                    break;
                case 15:
                    arrayList = a.c(parcel, A, CountrySpecification.CREATOR);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new MaskedWalletRequest(i, str, z, z2, z3, str2, str3, str4, cart, z4, z5, countrySpecificationArr, z6, z7, arrayList);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: dG */
    public MaskedWalletRequest[] newArray(int i) {
        return new MaskedWalletRequest[i];
    }
}
