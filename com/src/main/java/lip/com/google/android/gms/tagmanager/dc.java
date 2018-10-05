package lip.com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;
import java.util.Map;

abstract class dc extends cc {
    public dc(String str) {
        super(str);
    }

    protected boolean a(a aVar, a aVar2, Map<String, a> map) {
        String j = dh.j(aVar);
        String j2 = dh.j(aVar2);
        return (j == dh.nc() || j2 == dh.nc()) ? false : a(j, j2, (Map) map);
    }

    protected abstract boolean a(String str, String str2, Map<String, a> map);
}
