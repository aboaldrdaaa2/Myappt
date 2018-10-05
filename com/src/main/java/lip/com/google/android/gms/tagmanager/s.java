package lip.com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class s extends aj {
    private static final String ID = com.google.android.gms.internal.a.FUNCTION_CALL.toString();
    private static final String aeW = b.FUNCTION_CALL_NAME.toString();
    private static final String aem = b.ADDITIONAL_PARAMS.toString();
    private final a aeX;

    public interface a {
        Object b(String str, Map<String, Object> map);
    }

    public s(a aVar) {
        super(ID, aeW);
        this.aeX = aVar;
    }

    public boolean lh() {
        return false;
    }

    public com.google.android.gms.internal.d.a w(Map<String, com.google.android.gms.internal.d.a> map) {
        String j = dh.j((com.google.android.gms.internal.d.a) map.get(aeW));
        Map hashMap = new HashMap();
        com.google.android.gms.internal.d.a aVar = (com.google.android.gms.internal.d.a) map.get(aem);
        if (aVar != null) {
            Object o = dh.o(aVar);
            if (o instanceof Map) {
                for (Entry entry : ((Map) o).entrySet()) {
                    hashMap.put(entry.getKey().toString(), entry.getValue());
                }
            } else {
                bh.D("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return dh.nd();
            }
        }
        try {
            return dh.r(this.aeX.b(j, hashMap));
        } catch (Exception e) {
            bh.D("Custom macro/tag " + j + " threw exception " + e.getMessage());
            return dh.nd();
        }
    }
}
