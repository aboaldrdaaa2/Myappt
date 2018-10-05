package lip.com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.AddressConstants.Extras;

public final class UserAddress implements SafeParcelable {
    public static final Creator<UserAddress> CREATOR = new b();
    String UH;
    String UI;
    String UJ;
    String UK;
    String UL;
    String UM;
    String UN;
    String UO;
    String UP;
    String UQ;
    boolean UR;
    String US;
    String UT;
    String name;
    String rf;
    private final int xM;

    UserAddress() {
        this.xM = 1;
    }

    UserAddress(int versionCode, String name, String address1, String address2, String address3, String address4, String address5, String administrativeArea, String locality, String countryCode, String postalCode, String sortingCode, String phoneNumber, boolean isPostBox, String companyName, String emailAddress) {
        this.xM = versionCode;
        this.name = name;
        this.UH = address1;
        this.UI = address2;
        this.UJ = address3;
        this.UK = address4;
        this.UL = address5;
        this.UM = administrativeArea;
        this.UN = locality;
        this.rf = countryCode;
        this.UO = postalCode;
        this.UP = sortingCode;
        this.UQ = phoneNumber;
        this.UR = isPostBox;
        this.US = companyName;
        this.UT = emailAddress;
    }

    public static UserAddress fromIntent(Intent data) {
        return (data == null || !data.hasExtra(Extras.EXTRA_ADDRESS)) ? null : (UserAddress) data.getParcelableExtra(Extras.EXTRA_ADDRESS);
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

    public String getAddress4() {
        return this.UK;
    }

    public String getAddress5() {
        return this.UL;
    }

    public String getAdministrativeArea() {
        return this.UM;
    }

    public String getCompanyName() {
        return this.US;
    }

    public String getCountryCode() {
        return this.rf;
    }

    public String getEmailAddress() {
        return this.UT;
    }

    public String getLocality() {
        return this.UN;
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

    public String getSortingCode() {
        return this.UP;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public boolean isPostBox() {
        return this.UR;
    }

    public void writeToParcel(Parcel out, int flags) {
        b.a(this, out, flags);
    }
}
