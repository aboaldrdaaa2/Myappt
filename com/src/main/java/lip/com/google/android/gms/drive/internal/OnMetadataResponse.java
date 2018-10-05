package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class OnMetadataResponse implements SafeParcelable {
    public static final Creator<OnMetadataResponse> CREATOR = new am();
    final MetadataBundle IE;
    final int xM;

    OnMetadataResponse(int versionCode, MetadataBundle metadata) {
        this.xM = versionCode;
        this.IE = metadata;
    }

    public int describeContents() {
        return 0;
    }

    public MetadataBundle gB() {
        return this.IE;
    }

    public void writeToParcel(Parcel dest, int flags) {
        am.a(this, dest, flags);
    }
}
