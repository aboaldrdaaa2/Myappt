package lip.com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class l implements SafeParcelable {
    public static final Creator<l> CREATOR = new m();
    long ala;
    long alb;
    private final int xM;

    l() {
        this.xM = 1;
    }

    l(int i, long j, long j2) {
        this.xM = i;
        this.ala = j;
        this.alb = j2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        m.a(this, dest, flags);
    }
}
