package lip.com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class p implements SafeParcelable {
    public static final Creator<p> CREATOR = new q();
    String akZ;
    l ald;
    n ale;
    n alf;
    String qe;
    private final int xM;

    p() {
        this.xM = 1;
    }

    p(int i, String str, String str2, l lVar, n nVar, n nVar2) {
        this.xM = i;
        this.akZ = str;
        this.qe = str2;
        this.ald = lVar;
        this.ale = nVar;
        this.alf = nVar2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        q.a(this, dest, flags);
    }
}
