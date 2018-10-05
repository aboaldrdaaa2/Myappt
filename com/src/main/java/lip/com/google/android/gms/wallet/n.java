package lip.com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public class n implements Creator<OfferWalletObject> {
    static void a(OfferWalletObject offerWalletObject, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, offerWalletObject.getVersionCode());
        b.a(parcel, 2, offerWalletObject.eC, false);
        b.a(parcel, 3, offerWalletObject.ajT, false);
        b.a(parcel, 4, offerWalletObject.ajU, i, false);
        b.G(parcel, C);
    }

    /* renamed from: cc */
    public OfferWalletObject createFromParcel(Parcel parcel) {
        CommonWalletObject commonWalletObject = null;
        int B = a.B(parcel);
        int i = 0;
        String str = null;
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
                    commonWalletObject = (CommonWalletObject) a.a(parcel, A, CommonWalletObject.CREATOR);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new OfferWalletObject(i, str2, str, commonWalletObject);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: dI */
    public OfferWalletObject[] newArray(int i) {
        return new OfferWalletObject[i];
    }
}
