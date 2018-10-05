package lip.com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StorageStats implements SafeParcelable {
    public static final Creator<StorageStats> CREATOR = new e();
    final long Ib;
    final long Ic;
    final long Id;
    final long Ie;
    final int If;
    final int xM;

    StorageStats(int versionCode, long metadataSizeBytes, long cachedContentsSizeBytes, long pinnedItemsSizeBytes, long totalSizeBytes, int numPinnedItems) {
        this.xM = versionCode;
        this.Ib = metadataSizeBytes;
        this.Ic = cachedContentsSizeBytes;
        this.Id = pinnedItemsSizeBytes;
        this.Ie = totalSizeBytes;
        this.If = numPinnedItems;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        e.a(this, out, flags);
    }
}
