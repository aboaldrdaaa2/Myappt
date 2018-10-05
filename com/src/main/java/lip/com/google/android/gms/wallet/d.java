package lip.com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class d implements SafeParcelable {
    public static final Creator<d> CREATOR = new e();
    LoyaltyWalletObject aiO;
    OfferWalletObject aiP;
    private final int xM;

    d() {
        this.xM = 2;
    }

    d(int i, LoyaltyWalletObject loyaltyWalletObject, OfferWalletObject offerWalletObject) {
        this.xM = i;
        this.aiO = loyaltyWalletObject;
        this.aiP = offerWalletObject;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        e.a(this, dest, flags);
    }
}
