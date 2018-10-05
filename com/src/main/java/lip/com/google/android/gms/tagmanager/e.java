package lip.com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d;
import java.util.Map;

class e extends aj {
    private static final String ID = a.ADWORDS_CLICK_REFERRER.toString();
    private static final String aek = b.COMPONENT.toString();
    private static final String ael = b.CONVERSION_ID.toString();
    private final Context kO;

    public e(Context context) {
        super(ID, ael);
        this.kO = context;
    }

    public boolean lh() {
        return true;
    }

    public d.a w(Map<String, d.a> map) {
        d.a aVar = (d.a) map.get(ael);
        if (aVar == null) {
            return dh.nd();
        }
        String j = dh.j(aVar);
        aVar = (d.a) map.get(aek);
        String d = ay.d(this.kO, j, aVar != null ? dh.j(aVar) : null);
        return d != null ? dh.r(d) : dh.nd();
    }
}
