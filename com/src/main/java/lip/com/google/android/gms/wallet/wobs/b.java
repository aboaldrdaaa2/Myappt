package lip.com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class b implements SafeParcelable {
    public static final Creator<b> CREATOR = new c();
    String label;
    String value;
    private final int xM;

    b() {
        this.xM = 1;
    }

    b(int i, String str, String str2) {
        this.xM = i;
        this.label = str;
        this.value = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        c.a(this, dest, flags);
    }
}
