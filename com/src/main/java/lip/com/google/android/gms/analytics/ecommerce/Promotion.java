package lip.com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.internal.hm;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Promotion {
    public static final String ACTION_CLICK = "click";
    public static final String ACTION_VIEW = "view";
    Map<String, String> xF = new HashMap();

    public Map<String, String> X(String str) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : this.xF.entrySet()) {
            hashMap.put(str + ((String) entry.getKey()), entry.getValue());
        }
        return hashMap;
    }

    void put(String name, String value) {
        hm.b((Object) name, (Object) "Name should be non-null");
        this.xF.put(name, value);
    }

    public Promotion setCreative(String value) {
        put("cr", value);
        return this;
    }

    public Promotion setId(String value) {
        put("id", value);
        return this;
    }

    public Promotion setName(String value) {
        put("nm", value);
        return this;
    }

    public Promotion setPosition(String value) {
        put("ps", value);
        return this;
    }
}
