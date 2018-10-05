package lip.com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FieldWithSortOrder implements SafeParcelable {
    public static final c CREATOR = new c();
    final String JH;
    final boolean KO;
    final int xM;

    FieldWithSortOrder(int versionCode, String fieldName, boolean isSortAscending) {
        this.xM = versionCode;
        this.JH = fieldName;
        this.KO = isSortAscending;
    }

    public FieldWithSortOrder(String fieldName, boolean isSortAscending) {
        this(1, fieldName, isSortAscending);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        c.a(this, out, flags);
    }
}
