package lip.com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hy.b;

public class ht implements SafeParcelable {
    public static final hu CREATOR = new hu();
    private final hv GV;
    private final int xM;

    ht(int i, hv hvVar) {
        this.xM = i;
        this.GV = hvVar;
    }

    private ht(hv hvVar) {
        this.xM = 1;
        this.GV = hvVar;
    }

    public static ht a(b<?, ?> bVar) {
        if (bVar instanceof hv) {
            return new ht((hv) bVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public int describeContents() {
        hu huVar = CREATOR;
        return 0;
    }

    hv fB() {
        return this.GV;
    }

    public b<?, ?> fC() {
        if (this.GV != null) {
            return this.GV;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel out, int flags) {
        hu huVar = CREATOR;
        hu.a(this, out, flags);
    }
}
