package lip.com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class fi implements SafeParcelable {
    public static final fj CREATOR = new fj();
    final int xM;
    final String xQ;
    final String xR;
    final String xS;

    fi(int i, String str, String str2, String str3) {
        this.xM = i;
        this.xQ = str;
        this.xR = str2;
        this.xS = str3;
    }

    public fi(String str, String str2, String str3) {
        this(1, str, str2, str3);
    }

    public int describeContents() {
        fj fjVar = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", new Object[]{this.xQ, this.xR, this.xS});
    }

    public void writeToParcel(Parcel dest, int flags) {
        fj fjVar = CREATOR;
        fj.a(this, dest, flags);
    }
}
