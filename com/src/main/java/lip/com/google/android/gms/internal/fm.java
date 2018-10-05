package lip.com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class fm implements SafeParcelable {
    public static final fn CREATOR = new fn();
    public final int id;
    final int xM;
    final Bundle xY;

    fm(int i, int i2, Bundle bundle) {
        this.xM = i;
        this.id = i2;
        this.xY = bundle;
    }

    public int describeContents() {
        fn fnVar = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        fn fnVar = CREATOR;
        fn.a(this, dest, flags);
    }
}
