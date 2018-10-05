package lip.com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d;
import java.util.Map;

class p extends aj {
    private static final String ID = a.CONTAINER_VERSION.toString();
    private final String aeU;

    public p(String str) {
        super(ID, new String[0]);
        this.aeU = str;
    }

    public boolean lh() {
        return true;
    }

    public d.a w(Map<String, d.a> map) {
        return this.aeU == null ? dh.nd() : dh.r(this.aeU);
    }
}
