package lip.com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hm;

public class CustomPropertyKey implements SafeParcelable {
    public static final Creator<CustomPropertyKey> CREATOR = new c();
    final String JL;
    final int JM;
    final int xM;

    CustomPropertyKey(int versionCode, String key, int visibility) {
        boolean z = true;
        this.xM = versionCode;
        hm.b((Object) key, (Object) "key");
        if (!(visibility == 0 || visibility == 1)) {
            z = false;
        }
        hm.a(z, "visibility must be either PUBLIC or PRIVATE");
        this.JL = key;
        this.JM = visibility;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomPropertyKey)) {
            return false;
        }
        CustomPropertyKey customPropertyKey = (CustomPropertyKey) obj;
        if (!(customPropertyKey.getKey().equals(this.JL) && customPropertyKey.getVisibility() == this.JM)) {
            z = false;
        }
        return z;
    }

    public String getKey() {
        return this.JL;
    }

    public int getVisibility() {
        return this.JM;
    }

    public int hashCode() {
        return (this.JL + this.JM).hashCode();
    }

    public String toString() {
        return "CustomPropertyKey(" + this.JL + "," + this.JM + ")";
    }

    public void writeToParcel(Parcel dest, int flags) {
        c.a(this, dest, flags);
    }
}
