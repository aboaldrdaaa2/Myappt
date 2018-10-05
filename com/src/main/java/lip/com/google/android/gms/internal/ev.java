package lip.com.google.android.gms.internal;

import android.os.Parcel;
import com.facebook.AppEventsConstants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ev implements SafeParcelable {
    public static final ew CREATOR = new ew();
    public String sw;
    public int sx;
    public int sy;
    public boolean sz;
    public final int versionCode;

    public ev(int i, int i2, boolean z) {
        String str = "afma-sdk-a-v" + i + "." + i2 + "." + (z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
        this(1, str, i, i2, z);
    }

    ev(int i, String str, int i2, int i3, boolean z) {
        this.versionCode = i;
        this.sw = str;
        this.sx = i2;
        this.sy = i3;
        this.sz = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        ew.a(this, out, flags);
    }
}
