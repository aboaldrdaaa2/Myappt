package lip.com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class g implements Creator<FullWalletRequest> {
    static void a(FullWalletRequest fullWalletRequest, Parcel parcel, int i) {
        int C = b.C(parcel);
        b.c(parcel, 1, fullWalletRequest.getVersionCode());
        b.a(parcel, 2, fullWalletRequest.aiQ, false);
        b.a(parcel, 3, fullWalletRequest.aiR, false);
        b.a(parcel, 4, fullWalletRequest.aja, i, false);
        b.G(parcel, C);
    }

    /* renamed from: bV */
    public FullWalletRequest createFromParcel(Parcel parcel) {
        Cart cart = null;
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
                    cart = (Cart) a.a(parcel, A, Cart.CREATOR);
                    break;
                default:
                    a.b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new FullWalletRequest(i, str2, str, cart);
        }
        throw new a.a("Overread allowed size end=" + B, parcel);
    }

    /* renamed from: dB */
    public FullWalletRequest[] newArray(int i) {
        return new FullWalletRequest[i];
    }
}
