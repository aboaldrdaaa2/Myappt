package lip.com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class j implements SafeParcelable {
    public static final Creator<j> CREATOR = new k();
    String akZ;
    String qe;
    private final int xM;

    j() {
        this.xM = 1;
    }

    j(int i, String str, String str2) {
        this.xM = i;
        this.akZ = str;
        this.qe = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        k.a(this, dest, flags);
    }
}
