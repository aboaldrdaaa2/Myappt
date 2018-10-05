package lip.com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ac.a;

public class b implements SafeParcelable {
    public static final Creator<b> CREATOR = new c();
    public final IntentFilter[] alA;
    public final ac alz;
    final int xM;

    b(int i, IBinder iBinder, IntentFilter[] intentFilterArr) {
        this.xM = i;
        if (iBinder != null) {
            this.alz = a.bx(iBinder);
        } else {
            this.alz = null;
        }
        this.alA = intentFilterArr;
    }

    public b(av avVar) {
        this.xM = 1;
        this.alz = avVar;
        this.alA = avVar.nu();
    }

    public int describeContents() {
        return 0;
    }

    IBinder no() {
        return this.alz == null ? null : this.alz.asBinder();
    }

    public void writeToParcel(Parcel dest, int flags) {
        c.a(this, dest, flags);
    }
}
