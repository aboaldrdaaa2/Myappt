package lip.com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import com.google.android.gms.tagmanager.cq.c;
import com.google.android.gms.tagmanager.cq.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ba {
    public static c bY(String str) throws JSONException {
        a k = k(new JSONObject(str));
        d mr = c.mr();
        for (int i = 0; i < k.fP.length; i++) {
            mr.a(cq.a.mn().b(b.INSTANCE_NAME.toString(), k.fP[i]).b(b.FUNCTION.toString(), dh.cp(m.lk())).b(m.ll(), k.fQ[i]).mq());
        }
        return mr.mu();
    }

    private static a k(Object obj) throws JSONException {
        return dh.r(l(obj));
    }

    static Object l(Object obj) throws JSONException {
        if (obj instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        } else if (JSONObject.NULL.equals(obj)) {
            throw new RuntimeException("JSON nulls are not supported");
        } else if (!(obj instanceof JSONObject)) {
            return obj;
        } else {
            JSONObject jSONObject = (JSONObject) obj;
            Map hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, l(jSONObject.get(str)));
            }
            return hashMap;
        }
    }
}
