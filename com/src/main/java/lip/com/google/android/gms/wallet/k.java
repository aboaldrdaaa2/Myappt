package lip.com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.identity.intents.model.UserAddress;

public class k implements Creator<MaskedWallet> {
    static void a(MaskedWallet maskedWallet, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, maskedWallet.getVersionCode());
        b.a(parcel, 2, maskedWallet.aiQ, false);
        b.a(parcel, 3, maskedWallet.aiR, false);
        b.a(parcel, 4, maskedWallet.aiW, false);
        b.a(parcel, 5, maskedWallet.aiT, false);
        b.a(parcel, 6, maskedWallet.aiU, i, false);
        b.a(parcel, 7, maskedWallet.aiV, i, false);
        b.a(parcel, 8, maskedWallet.ajC, i, false);
        b.a(parcel, 9, maskedWallet.ajD, i, false);
        b.a(parcel, 10, maskedWallet.aiX, i, false);
        b.a(parcel, 11, maskedWallet.aiY, i, false);
        b.a(parcel, 12, maskedWallet.aiZ, i, false);
        b.G(parcel, C);
    }

    /* renamed from: bZ */
    public MaskedWallet createFromParcel(Parcel parcel) {
        int B = a.B(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String[] strArr = null;
        String str3 = null;
        Address address = null;
        Address address2 = null;
        LoyaltyWalletObject[] loyaltyWalletObjectArr = null;
        OfferWalletObject[] offerWalletObjectArr = null;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        InstrumentInfo[] instrumentInfoArr = null;
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
                    strArr = a.A(parcel, A);
                    break;
                case 5:
                    str3 = a.o(parcel, A);
                    break;
                case 6:
                    address = (Address) a.a(parcel, A, Address.CREATOR);
                    break;
                case 7:
                    address2 = (Address) a.a(parcel, A, Address.CREATOR);
                    break;
                case 8:
                    loyaltyWalletObjectArr = (LoyaltyWalletObject[]) a.b(parcel, A, LoyaltyWalletObject.CREATOR);
                    break;
                case 9:
                    offerWalletObjectArr = (OfferWalletObject[]) a.b(parcel, A, OfferWalletObject.CREATOR);
                    break;
                case 10:
                    userAddress = (UserAddress) a.a(parcel, A, UserAddress.CREATOR);
                    break;
                case 11:
                    userAddress2 = (UserAddress) a.a(parcel, A, UserAddress.CREATOR);
                    break;
                case 12:
                    instrumentInfoArr = (InstrumentInfo[]) a.b(parcel, A, InstrumentInfo.CREATOR);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new MaskedWallet(i, str, str2, strArr, str3, address, address2, loyaltyWalletObjectArr, offerWalletObjectArr, userAddress, userAddress2, instrumentInfoArr);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: dF */
    public MaskedWallet[] newArray(int i) {
        return new MaskedWallet[i];
    }
}
