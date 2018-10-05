package lip.com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ac.a;

public class ao implements SafeParcelable {
    public static final Creator<ao> CREATOR = new ap();
    public final ac alz;
    final int xM;

    ao(int i, IBinder iBinder) {
        this.xM = i;
        if (iBinder != null) {
            this.alz = a.bx(iBinder);
        } else {
            this.alz = null;
        }
    }

    public ao(ac acVar) {
        this.xM = 1;
        this.alz = acVar;
    }

    public int describeContents() {
        return 0;
    }

    IBinder no() {
        return this.alz == null ? null : this.alz.asBinder();
    }

    public void writeToParcel(Parcel dest, int flags) {
        ap.a(this, dest, flags);
    }
}
