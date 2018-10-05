package lip.com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class ai implements SafeParcelable {
    public static final aj CREATOR = new aj();
    public final Bundle extras;
    public final long lS;
    public final int lT;
    public final List<String> lU;
    public final boolean lV;
    public final int lW;
    public final boolean lX;
    public final String lY;
    public final aw lZ;
    public final Location ma;
    public final String mb;
    public final Bundle mc;
    public final int versionCode;

    public ai(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, aw awVar, Location location, String str2, Bundle bundle2) {
        this.versionCode = i;
        this.lS = j;
        this.extras = bundle;
        this.lT = i2;
        this.lU = list;
        this.lV = z;
        this.lW = i3;
        this.lX = z2;
        this.lY = str;
        this.lZ = awVar;
        this.ma = location;
        this.mb = str2;
        this.mc = bundle2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        aj.a(this, out, flags);
    }
}
