package lip.com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public final class du implements SafeParcelable {
    public static final dv CREATOR = new dv();
    public final int errorCode;
    public final List<String> nt;
    public final List<String> nu;
    public final long nx;
    public final String oA;
    public final int orientation;
    public final String qe;
    public final long qf;
    public final boolean qg;
    public final long qh;
    public final List<String> qi;
    public final String qj;
    public final long qk;
    public final String ql;
    public final boolean qm;
    public final String qn;
    public final String qo;
    public final int versionCode;

    public du(int i) {
        this(7, null, null, null, i, null, -1, false, -1, null, -1, -1, null, -1, null, false, null, null);
    }

    public du(int i, long j) {
        this(7, null, null, null, i, null, -1, false, -1, null, j, -1, null, -1, null, false, null, null);
    }

    du(int i, String str, String str2, List<String> list, int i2, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i3, String str3, long j4, String str4, boolean z2, String str5, String str6) {
        this.versionCode = i;
        this.oA = str;
        this.qe = str2;
        this.nt = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i2;
        this.nu = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.qf = j;
        this.qg = z;
        this.qh = j2;
        this.qi = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.nx = j3;
        this.orientation = i3;
        this.qj = str3;
        this.qk = j4;
        this.ql = str4;
        this.qm = z2;
        this.qn = str5;
        this.qo = str6;
    }

    public du(String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, String str5) {
        this(7, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, false, null, str5);
    }

    public du(String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, boolean z2, String str5, String str6) {
        this(7, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, z2, str5, str6);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        dv.a(this, out, flags);
    }
}
