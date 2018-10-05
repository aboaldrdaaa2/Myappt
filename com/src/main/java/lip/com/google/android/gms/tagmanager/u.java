package lip.com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d;
import java.util.Map;

class u extends aj {
    private static final String ID = a.CUSTOM_VAR.toString();
    private static final String NAME = b.NAME.toString();
    private static final String afi = b.DEFAULT_VALUE.toString();
    private final DataLayer aeu;

    public u(DataLayer dataLayer) {
        super(ID, NAME);
        this.aeu = dataLayer;
    }

    public boolean lh() {
        return false;
    }

    public d.a w(Map<String, d.a> map) {
        Object obj = this.aeu.get(dh.j((d.a) map.get(NAME)));
        if (obj != null) {
            return dh.r(obj);
        }
        d.a aVar = (d.a) map.get(afi);
        return aVar != null ? aVar : dh.nd();
    }
}
