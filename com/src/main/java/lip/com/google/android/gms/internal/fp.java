package lip.com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class fp implements SafeParcelable {
    public static final fq CREATOR = new fq();
    public final String name;
    public final int weight;
    final int xM;
    public final String yb;
    public final boolean yc;
    public final boolean yd;
    public final String ye;
    public final fm[] yf;
    final int[] yg;
    public final String yh;

    public static final class a {
        private final String mName;
        private String yi;
        private boolean yj;
        private int yk = 1;
        private boolean yl;
        private String ym;
        private final List<fm> yn = new ArrayList();
        private BitSet yo;
        private String yp;

        public a(String str) {
            this.mName = str;
        }

        public a I(int i) {
            if (this.yo == null) {
                this.yo = new BitSet();
            }
            this.yo.set(i);
            return this;
        }

        public a Z(String str) {
            this.yi = str;
            return this;
        }

        public a aa(String str) {
            this.yp = str;
            return this;
        }

        public fp dQ() {
            int i = 0;
            int[] iArr = null;
            if (this.yo != null) {
                iArr = new int[this.yo.cardinality()];
                int nextSetBit = this.yo.nextSetBit(0);
                while (nextSetBit >= 0) {
                    int i2 = i + 1;
                    iArr[i] = nextSetBit;
                    nextSetBit = this.yo.nextSetBit(nextSetBit + 1);
                    i = i2;
                }
            }
            return new fp(this.mName, this.yi, this.yj, this.yk, this.yl, this.ym, (fm[]) this.yn.toArray(new fm[this.yn.size()]), iArr, this.yp);
        }

        public a w(boolean z) {
            this.yj = z;
            return this;
        }

        public a x(boolean z) {
            this.yl = z;
            return this;
        }
    }

    fp(int i, String str, String str2, boolean z, int i2, boolean z2, String str3, fm[] fmVarArr, int[] iArr, String str4) {
        this.xM = i;
        this.name = str;
        this.yb = str2;
        this.yc = z;
        this.weight = i2;
        this.yd = z2;
        this.ye = str3;
        this.yf = fmVarArr;
        this.yg = iArr;
        this.yh = str4;
    }

    fp(String str, String str2, boolean z, int i, boolean z2, String str3, fm[] fmVarArr, int[] iArr, String str4) {
        this(2, str, str2, z, i, z2, str3, fmVarArr, iArr, str4);
    }

    public int describeContents() {
        fq fqVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (!(object instanceof fp)) {
            return false;
        }
        fp fpVar = (fp) object;
        return this.name.equals(fpVar.name) && this.yb.equals(fpVar.yb) && this.yc == fpVar.yc;
    }

    public void writeToParcel(Parcel out, int flags) {
        fq fqVar = CREATOR;
        fq.a(this, out, flags);
    }
}
