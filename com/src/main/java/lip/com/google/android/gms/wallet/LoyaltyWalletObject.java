package lip.com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ig;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.d;
import com.google.android.gms.wallet.wobs.f;
import com.google.android.gms.wallet.wobs.j;
import com.google.android.gms.wallet.wobs.l;
import com.google.android.gms.wallet.wobs.n;
import com.google.android.gms.wallet.wobs.p;
import java.util.ArrayList;

public final class LoyaltyWalletObject implements SafeParcelable {
    public static final Creator<LoyaltyWalletObject> CREATOR = new j();
    ArrayList<n> ajA;
    f ajB;
    String aji;
    String ajj;
    String ajk;
    String ajl;
    String ajm;
    String ajn;
    String ajo;
    String ajp;
    String ajq;
    ArrayList<p> ajr;
    l ajs;
    ArrayList<LatLng> ajt;
    String aju;
    String ajv;
    ArrayList<d> ajw;
    boolean ajx;
    ArrayList<n> ajy;
    ArrayList<j> ajz;
    String eC;
    int state;
    private final int xM;

    LoyaltyWalletObject() {
        this.xM = 4;
        this.ajr = ig.ga();
        this.ajt = ig.ga();
        this.ajw = ig.ga();
        this.ajy = ig.ga();
        this.ajz = ig.ga();
        this.ajA = ig.ga();
    }

    LoyaltyWalletObject(int versionCode, String id, String accountId, String issuerName, String programName, String accountName, String barcodeAlternateText, String barcodeType, String barcodeValue, String barcodeLabel, String classId, int state, ArrayList<p> messages, l validTimeInterval, ArrayList<LatLng> locations, String infoModuleDataHexFontColor, String infoModuleDataHexBackgroundColor, ArrayList<d> infoModuleDataLabelValueRows, boolean infoModuleDataShowLastUpdateTime, ArrayList<n> imageModuleDataMainImageUris, ArrayList<j> textModulesData, ArrayList<n> linksModuleDataUris, f loyaltyPoints) {
        this.xM = versionCode;
        this.eC = id;
        this.aji = accountId;
        this.ajj = issuerName;
        this.ajk = programName;
        this.ajl = accountName;
        this.ajm = barcodeAlternateText;
        this.ajn = barcodeType;
        this.ajo = barcodeValue;
        this.ajp = barcodeLabel;
        this.ajq = classId;
        this.state = state;
        this.ajr = messages;
        this.ajs = validTimeInterval;
        this.ajt = locations;
        this.aju = infoModuleDataHexFontColor;
        this.ajv = infoModuleDataHexBackgroundColor;
        this.ajw = infoModuleDataLabelValueRows;
        this.ajx = infoModuleDataShowLastUpdateTime;
        this.ajy = imageModuleDataMainImageUris;
        this.ajz = textModulesData;
        this.ajA = linksModuleDataUris;
        this.ajB = loyaltyPoints;
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountId() {
        return this.aji;
    }

    public String getAccountName() {
        return this.ajl;
    }

    public String getBarcodeAlternateText() {
        return this.ajm;
    }

    public String getBarcodeType() {
        return this.ajn;
    }

    public String getBarcodeValue() {
        return this.ajo;
    }

    public String getId() {
        return this.eC;
    }

    public String getIssuerName() {
        return this.ajj;
    }

    public String getProgramName() {
        return this.ajk;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        j.a(this, dest, flags);
    }
}
