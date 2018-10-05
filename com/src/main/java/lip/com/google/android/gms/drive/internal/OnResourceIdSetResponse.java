package lip.com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class OnResourceIdSetResponse implements SafeParcelable {
    public static final Creator<OnResourceIdSetResponse> CREATOR = new ao();
    private final List<String> It;
    private final int xM;

    OnResourceIdSetResponse(int versionCode, List<String> resourceIds) {
        this.xM = versionCode;
        this.It = resourceIds;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public List<String> go() {
        return this.It;
    }

    public void writeToParcel(Parcel dest, int flags) {
        ao.a(this, dest, flags);
    }
}
