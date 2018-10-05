package lip.com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class jw implements SafeParcelable {
    public static final jx CREATOR = new jx();
    public static final jw YP = w("test_type", 1);
    public static final jw YQ = w("saved_offers", 4);
    public static final Set<jw> YR = Collections.unmodifiableSet(new HashSet(Arrays.asList(new jw[]{YP, YQ})));
    final int YS;
    final String qX;
    final int xM;

    jw(int i, String str, int i2) {
        hm.aE(str);
        this.xM = i;
        this.qX = str;
        this.YS = i2;
    }

    private static jw w(String str, int i) {
        return new jw(0, str, i);
    }

    public int describeContents() {
        jx jxVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof jw)) {
            return false;
        }
        jw jwVar = (jw) object;
        return this.qX.equals(jwVar.qX) && this.YS == jwVar.YS;
    }

    public int hashCode() {
        return this.qX.hashCode();
    }

    public String toString() {
        return this.qX;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        jx jxVar = CREATOR;
        jx.a(this, parcel, flags);
    }
}
