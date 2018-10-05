package lip.com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public final class Address implements SafeParcelable {
    public static final Creator<Address> CREATOR = new a();
    String UH;
    String UI;
    String UJ;
    String UO;
    String UQ;
    boolean UR;
    String US;
    String aiI;
    String aiJ;
    String name;
    String rf;
    private final int xM;

    Address() {
        this.xM = 1;
    }

    Address(int versionCode, String name, String address1, String address2, String address3, String countryCode, String city, String state, String postalCode, String phoneNumber, boolean isPostBox, String companyName) {
        this.xM = versionCode;
        this.name = name;
        this.UH = address1;
        this.UI = address2;
        this.UJ = address3;
        this.rf = countryCode;
        this.aiI = city;
        this.aiJ = state;
        this.UO = postalCode;
        this.UQ = phoneNumber;
        this.UR = isPostBox;
        this.US = companyName;
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress1() {
        return this.UH;
    }

    public String getAddress2() {
        return this.UI;
    }

    public String getAddress3() {
        return this.UJ;
    }

    public String getCity() {
        return this.aiI;
    }

    public String getCompanyName() {
        return this.US;
    }

    public String getCountryCode() {
        return this.rf;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.UQ;
    }

    public String getPostalCode() {
        return this.UO;
    }

    public String getState() {
        return this.aiJ;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public boolean isPostBox() {
        return this.UR;
    }

    public void writeToParcel(Parcel out, int flags) {
        a.a(this, out, flags);
    }
}
