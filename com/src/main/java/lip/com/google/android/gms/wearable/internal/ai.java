package lip.com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;

public class ai implements SafeParcelable, Node {
    public static final Creator<ai> CREATOR = new aj();
    private final String Ln;
    private final String xG;
    final int xM;

    ai(int i, String str, String str2) {
        this.xM = i;
        this.xG = str;
        this.Ln = str2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (!(o instanceof ai)) {
            return false;
        }
        ai aiVar = (ai) o;
        return aiVar.xG.equals(this.xG) && aiVar.Ln.equals(this.Ln);
    }

    public String getDisplayName() {
        return this.Ln;
    }

    public String getId() {
        return this.xG;
    }

    public int hashCode() {
        return ((this.xG.hashCode() + 629) * 37) + this.Ln.hashCode();
    }

    public String toString() {
        return "NodeParcelable{" + this.xG + "," + this.Ln + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        aj.a(this, dest, flags);
    }
}
