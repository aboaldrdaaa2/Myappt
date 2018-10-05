package lip.com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

abstract class cc extends aj {
    private static final String afy = b.ARG0.toString();
    private static final String agv = b.ARG1.toString();

    public cc(String str) {
        super(str, afy, agv);
    }

    protected abstract boolean a(a aVar, a aVar2, Map<String, a> map);

    public boolean lh() {
        return true;
    }

    public a w(Map<String, a> map) {
        for (a aVar : map.values()) {
            if (aVar == dh.nd()) {
                return dh.r(Boolean.valueOf(false));
            }
        }
        a aVar2 = (a) map.get(afy);
        a aVar3 = (a) map.get(agv);
        boolean a = (aVar2 == null || aVar3 == null) ? false : a(aVar2, aVar3, map);
        return dh.r(Boolean.valueOf(a));
    }
}
