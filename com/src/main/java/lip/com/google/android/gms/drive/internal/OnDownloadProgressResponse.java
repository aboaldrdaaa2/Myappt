package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDownloadProgressResponse implements SafeParcelable {
    public static final Creator<OnDownloadProgressResponse> CREATOR = new ah();
    final long Jw;
    final long Jx;
    final int xM;

    OnDownloadProgressResponse(int versionCode, long bytesLoaded, long bytesExpected) {
        this.xM = versionCode;
        this.Jw = bytesLoaded;
        this.Jx = bytesExpected;
    }

    public int describeContents() {
        return 0;
    }

    public long gu() {
        return this.Jw;
    }

    public long gv() {
        return this.Jx;
    }

    public void writeToParcel(Parcel dest, int flags) {
        ah.a(this, dest, flags);
    }
}
