package lip.com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ce implements SafeParcelable {
    public static final cd CREATOR = new cd();
    public final String mimeType;
    public final String oa;
    public final String ob;
    public final String oc;
    public final String od;
    public final String oe;
    public final String packageName;
    public final int versionCode;

    public ce(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.versionCode = i;
        this.oa = str;
        this.ob = str2;
        this.mimeType = str3;
        this.packageName = str4;
        this.oc = str5;
        this.od = str6;
        this.oe = str7;
    }

    public ce(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(1, str, str2, str3, str4, str5, str6, str7);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        cd.a(this, out, flags);
    }
}
