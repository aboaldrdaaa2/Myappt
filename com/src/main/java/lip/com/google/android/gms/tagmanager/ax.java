package lip.com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d;
import java.util.Map;

class ax extends aj {
    private static final String ID = a.INSTALL_REFERRER.toString();
    private static final String aek = b.COMPONENT.toString();
    private final Context kO;

    public ax(Context context) {
        super(ID, new String[0]);
        this.kO = context;
    }

    public boolean lh() {
        return true;
    }

    public d.a w(Map<String, d.a> map) {
        String e = ay.e(this.kO, ((d.a) map.get(aek)) != null ? dh.j((d.a) map.get(aek)) : null);
        return e != null ? dh.r(e) : dh.nd();
    }
}
