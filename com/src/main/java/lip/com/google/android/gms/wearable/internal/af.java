package lip.com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.MessageEvent;

public class af implements SafeParcelable, MessageEvent {
    public static final Creator<af> CREATOR = new ag();
    private final byte[] TF;
    private final String alV;
    private final String alW;
    private final int ra;
    final int xM;

    af(int i, int i2, String str, byte[] bArr, String str2) {
        this.xM = i;
        this.ra = i2;
        this.alV = str;
        this.TF = bArr;
        this.alW = str2;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getData() {
        return this.TF;
    }

    public String getPath() {
        return this.alV;
    }

    public int getRequestId() {
        return this.ra;
    }

    public String getSourceNodeId() {
        return this.alW;
    }

    public String toString() {
        return "MessageEventParcelable[" + this.ra + "," + this.alV + ", size=" + (this.TF == null ? "null" : Integer.valueOf(this.TF.length)) + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        ag.a(this, dest, flags);
    }
}
