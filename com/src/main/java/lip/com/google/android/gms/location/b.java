package lip.com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;

public class b implements SafeParcelable {
    public static final c CREATOR = new c();
    int Vq;
    int Vr;
    long Vs;
    private final int xM;

    b(int i, int i2, int i3, long j) {
        this.xM = i;
        this.Vq = i2;
        this.Vr = i3;
        this.Vs = j;
    }

    private String cI(int i) {
        switch (i) {
            case 0:
                return "STATUS_SUCCESSFUL";
            case 2:
                return "STATUS_TIMED_OUT_ON_SCAN";
            case 3:
                return "STATUS_NO_INFO_IN_DATABASE";
            case 4:
                return "STATUS_INVALID_SCAN";
            case 5:
                return "STATUS_UNABLE_TO_QUERY_DATABASE";
            case 6:
                return "STATUS_SCANS_DISABLED_IN_SETTINGS";
            case 7:
                return "STATUS_LOCATION_DISABLED_IN_SETTINGS";
            case 8:
                return "STATUS_IN_PROGRESS";
            default:
                return "STATUS_UNKNOWN";
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        return this.Vq == bVar.Vq && this.Vr == bVar.Vr && this.Vs == bVar.Vs;
    }

    int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return hk.hashCode(Integer.valueOf(this.Vq), Integer.valueOf(this.Vr), Long.valueOf(this.Vs));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LocationStatus[cell status: ").append(cI(this.Vq));
        stringBuilder.append(", wifi status: ").append(cI(this.Vr));
        stringBuilder.append(", elapsed realtime ns: ").append(this.Vs);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        c.a(this, parcel, flags);
    }
}
