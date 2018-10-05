package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.StorageStats;

public class OnStorageStatsResponse implements SafeParcelable {
    public static final Creator<OnStorageStatsResponse> CREATOR = new ap();
    StorageStats JD;
    final int xM;

    OnStorageStatsResponse(int versionCode, StorageStats storageStats) {
        this.xM = versionCode;
        this.JD = storageStats;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        ap.a(this, dest, flags);
    }
}
