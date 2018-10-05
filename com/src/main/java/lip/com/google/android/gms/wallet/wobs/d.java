package lip.com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ig;
import java.util.ArrayList;

public final class d implements SafeParcelable {
    public static final Creator<d> CREATOR = new e();
    String akP;
    String akQ;
    ArrayList<b> akR;
    private final int xM;

    d() {
        this.xM = 1;
        this.akR = ig.ga();
    }

    d(int i, String str, String str2, ArrayList<b> arrayList) {
        this.xM = i;
        this.akP = str;
        this.akQ = str2;
        this.akR = arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        e.a(this, dest, flags);
    }
}
