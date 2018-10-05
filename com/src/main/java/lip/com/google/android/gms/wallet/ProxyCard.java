package lip.com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ProxyCard implements SafeParcelable {
    public static final Creator<ProxyCard> CREATOR = new o();
    String ajV;
    String ajW;
    int ajX;
    int ajY;
    private final int xM;

    ProxyCard(int versionCode, String pan, String cvn, int expirationMonth, int expirationYear) {
        this.xM = versionCode;
        this.ajV = pan;
        this.ajW = cvn;
        this.ajX = expirationMonth;
        this.ajY = expirationYear;
    }

    public int describeContents() {
        return 0;
    }

    public String getCvn() {
        return this.ajW;
    }

    public int getExpirationMonth() {
        return this.ajX;
    }

    public int getExpirationYear() {
        return this.ajY;
    }

    public String getPan() {
        return this.ajV;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel out, int flags) {
        o.a(this, out, flags);
    }
}
