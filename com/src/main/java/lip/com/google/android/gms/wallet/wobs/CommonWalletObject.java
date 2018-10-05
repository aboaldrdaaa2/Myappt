package lip.com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ig;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class CommonWalletObject implements SafeParcelable {
    public static final Creator<CommonWalletObject> CREATOR = new a();
    ArrayList<n> ajA;
    String ajj;
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
    String name;
    int state;
    private final int xM;

    public final class a {
        private a() {
        }

        public a cw(String str) {
            CommonWalletObject.this.eC = str;
            return this;
        }

        public CommonWalletObject nl() {
            return CommonWalletObject.this;
        }
    }

    CommonWalletObject() {
        this.xM = 1;
        this.ajr = ig.ga();
        this.ajt = ig.ga();
        this.ajw = ig.ga();
        this.ajy = ig.ga();
        this.ajz = ig.ga();
        this.ajA = ig.ga();
    }

    CommonWalletObject(int versionCode, String id, String classId, String name, String issuerName, String barcodeAlternateText, String barcodeType, String barcodeValue, String barcodeLabel, int state, ArrayList<p> messages, l validTimeInterval, ArrayList<LatLng> locations, String infoModuleDataHexFontColor, String infoModuleDataHexBackgroundColor, ArrayList<d> infoModuleDataLabelValueRows, boolean infoModuleDataShowLastUpdateTime, ArrayList<n> imageModuleDataMainImageUris, ArrayList<j> textModulesData, ArrayList<n> linksModuleDataUris) {
        this.xM = versionCode;
        this.eC = id;
        this.ajq = classId;
        this.name = name;
        this.ajj = issuerName;
        this.ajm = barcodeAlternateText;
        this.ajn = barcodeType;
        this.ajo = barcodeValue;
        this.ajp = barcodeLabel;
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
    }

    public static a nk() {
        CommonWalletObject commonWalletObject = new CommonWalletObject();
        commonWalletObject.getClass();
        return new a();
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.eC;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        a.a(this, dest, flags);
    }
}
