package lip.com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.BitSet;

public class fg implements SafeParcelable {
    public static final fh CREATOR = new fh();
    final int xM;
    final fk[] xN;
    public final String xO;
    public final boolean xP;

    fg(int i, fk[] fkVarArr, String str, boolean z) {
        this.xM = i;
        this.xN = fkVarArr;
        this.xO = str;
        this.xP = z;
    }

    public fg(String str, boolean z, fk... fkVarArr) {
        this(1, fkVarArr, str, z);
        BitSet bitSet = new BitSet(fo.dP());
        for (fk fkVar : fkVarArr) {
            int i = fkVar.xW;
            if (i != -1) {
                if (bitSet.get(i)) {
                    throw new IllegalArgumentException("Duplicate global search section type " + fo.H(i));
                }
                bitSet.set(i);
            }
        }
    }

    public int describeContents() {
        fh fhVar = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        fh fhVar = CREATOR;
        fh.a(this, dest, flags);
    }
}
