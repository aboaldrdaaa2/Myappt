package lip.com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d;
import java.util.Map;

class ah extends aj {
    private static final String ID = a.EVENT.toString();
    private final cs aev;

    public ah(cs csVar) {
        super(ID, new String[0]);
        this.aev = csVar;
    }

    public boolean lh() {
        return false;
    }

    public d.a w(Map<String, d.a> map) {
        String mH = this.aev.mH();
        return mH == null ? dh.nd() : dh.r(mH);
    }
}
