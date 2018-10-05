package lip.com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class InstrumentInfo implements SafeParcelable {
    public static final Creator<InstrumentInfo> CREATOR = new h();
    private String ajc;
    private String ajd;
    private final int xM;

    InstrumentInfo(int versionCode, String instrumentType, String instrumentDetails) {
        this.xM = versionCode;
        this.ajc = instrumentType;
        this.ajd = instrumentDetails;
    }

    public int describeContents() {
        return 0;
    }

    public String getInstrumentDetails() {
        return this.ajd;
    }

    public String getInstrumentType() {
        return this.ajc;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel out, int flags) {
        h.a(this, out, flags);
    }
}
