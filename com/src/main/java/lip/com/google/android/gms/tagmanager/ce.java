package lip.com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d;
import java.util.Map;

class ce extends aj {
    private static final String ID = a.RANDOM.toString();
    private static final String agF = b.MIN.toString();
    private static final String agG = b.MAX.toString();

    public ce() {
        super(ID, new String[0]);
    }

    public boolean lh() {
        return false;
    }

    public d.a w(Map<String, d.a> map) {
        double doubleValue;
        double d;
        d.a aVar = (d.a) map.get(agF);
        d.a aVar2 = (d.a) map.get(agG);
        if (!(aVar == null || aVar == dh.nd() || aVar2 == null || aVar2 == dh.nd())) {
            dg k = dh.k(aVar);
            dg k2 = dh.k(aVar2);
            if (!(k == dh.nb() || k2 == dh.nb())) {
                double doubleValue2 = k.doubleValue();
                doubleValue = k2.doubleValue();
                if (doubleValue2 <= doubleValue) {
                    d = doubleValue2;
                    return dh.r(Long.valueOf(Math.round(((doubleValue - d) * Math.random()) + d)));
                }
            }
        }
        doubleValue = 2.147483647E9d;
        d = 0.0d;
        return dh.r(Long.valueOf(Math.round(((doubleValue - d) * Math.random()) + d)));
    }
}
