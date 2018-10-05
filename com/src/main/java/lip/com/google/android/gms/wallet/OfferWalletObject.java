package lip.com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public final class OfferWalletObject implements SafeParcelable {
    public static final Creator<OfferWalletObject> CREATOR = new n();
    String ajT;
    CommonWalletObject ajU;
    String eC;
    private final int xM;

    OfferWalletObject() {
        this.xM = 3;
    }

    OfferWalletObject(int versionCode, String id, String redemptionCode, CommonWalletObject commonWalletObject) {
        this.xM = versionCode;
        this.ajT = redemptionCode;
        if (versionCode < 3) {
            this.ajU = CommonWalletObject.nk().cw(id).nl();
        } else {
            this.ajU = commonWalletObject;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.ajU.getId();
    }

    public String getRedemptionCode() {
        return this.ajT;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        n.a(this, dest, flags);
    }
}
