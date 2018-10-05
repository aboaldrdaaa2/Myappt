package lip.com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.af;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.md;
import com.google.android.gms.internal.me;

public class DriveId implements SafeParcelable {
    public static final Creator<DriveId> CREATOR = new c();
    final String HN;
    final long HO;
    final long HP;
    private volatile String HQ;
    final int xM;

    DriveId(int versionCode, String resourceId, long sqlId, long databaseInstanceId) {
        boolean z = false;
        this.HQ = null;
        this.xM = versionCode;
        this.HN = resourceId;
        hm.C(!"".equals(resourceId));
        if (!(resourceId == null && sqlId == -1)) {
            z = true;
        }
        hm.C(z);
        this.HO = sqlId;
        this.HP = databaseInstanceId;
    }

    public DriveId(String resourceId, long sqlId, long databaseInstanceId) {
        this(1, resourceId, sqlId, databaseInstanceId);
    }

    public static DriveId aL(String str) {
        hm.f(str);
        return new DriveId(str, -1, -1);
    }

    public static DriveId decodeFromString(String s) {
        hm.b(s.startsWith("DriveId:"), "Invalid DriveId: " + s);
        return f(Base64.decode(s.substring("DriveId:".length()), 10));
    }

    static DriveId f(byte[] bArr) {
        try {
            af g = af.g(bArr);
            return new DriveId(g.versionCode, "".equals(g.Jt) ? null : g.Jt, g.Ju, g.Jv);
        } catch (md e) {
            throw new IllegalArgumentException();
        }
    }

    public int describeContents() {
        return 0;
    }

    public final String encodeToString() {
        if (this.HQ == null) {
            this.HQ = "DriveId:" + Base64.encodeToString(gk(), 10);
        }
        return this.HQ;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DriveId)) {
            return false;
        }
        DriveId driveId = (DriveId) obj;
        if (driveId.HP != this.HP) {
            Log.w("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
            return false;
        } else if (driveId.HO == -1 && this.HO == -1) {
            return driveId.HN.equals(this.HN);
        } else {
            return driveId.HO == this.HO;
        }
    }

    public String getResourceId() {
        return this.HN;
    }

    final byte[] gk() {
        me afVar = new af();
        afVar.versionCode = this.xM;
        afVar.Jt = this.HN == null ? "" : this.HN;
        afVar.Ju = this.HO;
        afVar.Jv = this.HP;
        return me.d(afVar);
    }

    public int hashCode() {
        return this.HO == -1 ? this.HN.hashCode() : (String.valueOf(this.HP) + String.valueOf(this.HO)).hashCode();
    }

    public String toString() {
        return encodeToString();
    }

    public void writeToParcel(Parcel out, int flags) {
        c.a(this, out, flags);
    }
}
