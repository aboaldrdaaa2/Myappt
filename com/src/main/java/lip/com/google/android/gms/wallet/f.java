package lip.com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.identity.intents.model.UserAddress;

public class f implements Creator<FullWallet> {
    static void a(FullWallet fullWallet, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, fullWallet.getVersionCode());
        b.a(parcel, 2, fullWallet.aiQ, false);
        b.a(parcel, 3, fullWallet.aiR, false);
        b.a(parcel, 4, fullWallet.aiS, i, false);
        b.a(parcel, 5, fullWallet.aiT, false);
        b.a(parcel, 6, fullWallet.aiU, i, false);
        b.a(parcel, 7, fullWallet.aiV, i, false);
        b.a(parcel, 8, fullWallet.aiW, false);
        b.a(parcel, 9, fullWallet.aiX, i, false);
        b.a(parcel, 10, fullWallet.aiY, i, false);
        b.a(parcel, 11, fullWallet.aiZ, i, false);
        b.G(parcel, C);
    }

    /* renamed from: bU */
    public FullWallet createFromParcel(Parcel parcel) {
        InstrumentInfo[] instrumentInfoArr = null;
        int B = a.B(parcel);
        int i = 0;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        String[] strArr = null;
        Address address = null;
        Address address2 = null;
        String str = null;
        ProxyCard proxyCard = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < B) {
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    i = a.g(parcel, A);
                    break;
                case 2:
                    str3 = a.o(parcel, A);
                    break;
                case 3:
                    str2 = a.o(parcel, A);
                    break;
                case 4:
                    proxyCard = (ProxyCard) a.a(parcel, A, ProxyCard.CREATOR);
                    break;
                case 5:
                    str = a.o(parcel, A);
                    break;
                case 6:
                    address2 = (Address) a.a(parcel, A, Address.CREATOR);
                    break;
                case 7:
                    address = (Address) a.a(parcel, A, Address.CREATOR);
                    break;
                case 8:
                    strArr = a.A(parcel, A);
                    break;
                case 9:
                    userAddress2 = (UserAddress) a.a(parcel, A, UserAddress.CREATOR);
                    break;
                case 10:
                    userAddress = (UserAddress) a.a(parcel, A, UserAddress.CREATOR);
                    break;
                case 11:
                    instrumentInfoArr = (InstrumentInfo[]) a.b(parcel, A, InstrumentInfo.CREATOR);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new FullWallet(i, str3, str2, proxyCard, str, address2, address, strArr, userAddress2, userAddress, instrumentInfoArr);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: dA */
    public FullWallet[] newArray(int i) {
        return new FullWallet[i];
    }
}
