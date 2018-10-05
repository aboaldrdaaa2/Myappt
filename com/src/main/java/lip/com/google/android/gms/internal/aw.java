package lip.com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class aw implements SafeParcelable {
    public static final ax CREATOR = new ax();
    public final int backgroundColor;
    public final int mD;
    public final int mE;
    public final int mF;
    public final int mG;
    public final int mH;
    public final int mI;
    public final int mJ;
    public final String mK;
    public final int mL;
    public final String mM;
    public final int mN;
    public final int mO;
    public final String mP;
    public final int versionCode;

    aw(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, int i10, String str2, int i11, int i12, String str3) {
        this.versionCode = i;
        this.mD = i2;
        this.backgroundColor = i3;
        this.mE = i4;
        this.mF = i5;
        this.mG = i6;
        this.mH = i7;
        this.mI = i8;
        this.mJ = i9;
        this.mK = str;
        this.mL = i10;
        this.mM = str2;
        this.mN = i11;
        this.mO = i12;
        this.mP = str3;
    }

    public aw(SearchAdRequest searchAdRequest) {
        this.versionCode = 1;
        this.mD = searchAdRequest.getAnchorTextColor();
        this.backgroundColor = searchAdRequest.getBackgroundColor();
        this.mE = searchAdRequest.getBackgroundGradientBottom();
        this.mF = searchAdRequest.getBackgroundGradientTop();
        this.mG = searchAdRequest.getBorderColor();
        this.mH = searchAdRequest.getBorderThickness();
        this.mI = searchAdRequest.getBorderType();
        this.mJ = searchAdRequest.getCallButtonColor();
        this.mK = searchAdRequest.getCustomChannels();
        this.mL = searchAdRequest.getDescriptionTextColor();
        this.mM = searchAdRequest.getFontFace();
        this.mN = searchAdRequest.getHeaderTextColor();
        this.mO = searchAdRequest.getHeaderTextSize();
        this.mP = searchAdRequest.getQuery();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        ax.a(this, out, flags);
    }
}
