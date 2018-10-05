package lip.com.google.android.gms.internal;

import java.util.Arrays;

public final class mg {
    final byte[] anc;
    final int tag;

    mg(int i, byte[] bArr) {
        this.tag = i;
        this.anc = bArr;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof mg)) {
            return false;
        }
        mg mgVar = (mg) o;
        return this.tag == mgVar.tag && Arrays.equals(this.anc, mgVar.anc);
    }

    public int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.anc);
    }
}
