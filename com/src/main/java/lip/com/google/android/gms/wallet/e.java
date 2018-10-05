package lip.com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class e implements Creator<d> {
    static void a(d dVar, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, dVar.getVersionCode());
        b.a(parcel, 2, dVar.aiO, i, false);
        b.a(parcel, 3, dVar.aiP, i, false);
        b.G(parcel, C);
    }

    /* renamed from: bT */
    public d createFromParcel(Parcel parcel) {
        OfferWalletObject offerWalletObject = null;
        int B = a.B(parcel);
        int i = 0;
        LoyaltyWalletObject loyaltyWalletObject = null;
        while (parcel.dataPosition() < B) {
            LoyaltyWalletObject loyaltyWalletObject2;
            int g;
            OfferWalletObject offerWalletObject2;
            int A = a.A(parcel);
            switch (a.ar(A)) {
                case 1:
                    OfferWalletObject offerWalletObject3 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    g = a.g(parcel, A);
                    offerWalletObject2 = offerWalletObject3;
                    break;
                case 2:
                    g = i;
                    LoyaltyWalletObject loyaltyWalletObject3 = (LoyaltyWalletObject) a.a(parcel, A, LoyaltyWalletObject.CREATOR);
                    offerWalletObject2 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject3;
                    break;
                case 3:
                    offerWalletObject2 = (OfferWalletObject) a.a(parcel, A, OfferWalletObject.CREATOR);
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    g = i;
                    break;
                default:
                    a.b(parcel, A);
                    offerWalletObject2 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    g = i;
                    break;
            }
            i = g;
            loyaltyWalletObject = loyaltyWalletObject2;
            offerWalletObject = offerWalletObject2;
        }
        if (parcel.dataPosition() == B) {
            return new d(i, loyaltyWalletObject, offerWalletObject);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: dz */
    public d[] newArray(int i) {
        return new d[i];
    }
}
