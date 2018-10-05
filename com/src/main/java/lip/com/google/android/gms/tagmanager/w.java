package lip.com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d;
import java.util.List;
import java.util.Map;

class w extends df {
    private static final String ID = a.DATA_LAYER_WRITE.toString();
    private static final String VALUE = b.VALUE.toString();
    private static final String aft = b.CLEAR_PERSISTENT_DATA_LAYER_PREFIX.toString();
    private final DataLayer aeu;

    public w(DataLayer dataLayer) {
        super(ID, VALUE);
        this.aeu = dataLayer;
    }

    private void a(d.a aVar) {
        if (aVar != null && aVar != dh.mX()) {
            String j = dh.j(aVar);
            if (j != dh.nc()) {
                this.aeu.bN(j);
            }
        }
    }

    private void b(d.a aVar) {
        if (aVar != null && aVar != dh.mX()) {
            Object o = dh.o(aVar);
            if (o instanceof List) {
                for (Object o2 : (List) o2) {
                    if (o2 instanceof Map) {
                        this.aeu.push((Map) o2);
                    }
                }
            }
        }
    }

    public void y(Map<String, d.a> map) {
        b((d.a) map.get(VALUE));
        a((d.a) map.get(aft));
    }
}
