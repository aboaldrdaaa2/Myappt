package lip.com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class f implements SafeParcelable {
    public static final Creator<f> CREATOR = new i();
    l ajs;
    g akS;
    String label;
    String type;
    private final int xM;

    f() {
        this.xM = 1;
    }

    f(int i, String str, g gVar, String str2, l lVar) {
        this.xM = i;
        this.label = str;
        this.akS = gVar;
        this.type = str2;
        this.ajs = lVar;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        i.a(this, dest, flags);
    }
}
