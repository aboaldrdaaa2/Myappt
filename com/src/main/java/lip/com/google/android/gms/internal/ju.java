package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class ju implements SafeParcelable {
    public static final Creator<ju> CREATOR = new jv();
    private final LatLng YK;
    private final String YL;
    private final List<js> YM;
    private final String YN;
    private final String YO;
    private final String mName;
    final int xM;

    ju(int i, String str, LatLng latLng, String str2, List<js> list, String str3, String str4) {
        this.xM = i;
        this.mName = str;
        this.YK = latLng;
        this.YL = str2;
        this.YM = new ArrayList(list);
        this.YN = str3;
        this.YO = str4;
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.YL;
    }

    public String getName() {
        return this.mName;
    }

    public String getPhoneNumber() {
        return this.YN;
    }

    public LatLng jk() {
        return this.YK;
    }

    public List<js> jl() {
        return this.YM;
    }

    public String jm() {
        return this.YO;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        jv.a(this, parcel, flags);
    }
}
