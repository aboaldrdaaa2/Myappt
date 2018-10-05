package lip.com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bl {
    public final String nk;
    public final String nl;
    public final List<String> nm;
    public final String nn;
    public final String no;
    public final List<String> np;
    public final String nq;

    public bl(JSONObject jSONObject) throws JSONException {
        String str = null;
        this.nl = jSONObject.getString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        List arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.nm = Collections.unmodifiableList(arrayList);
        this.nn = jSONObject.optString("allocation_id", null);
        this.np = br.a(jSONObject, "imp_urls");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        this.nk = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        this.nq = optJSONObject2 != null ? optJSONObject2.toString() : null;
        if (optJSONObject2 != null) {
            str = optJSONObject2.optString("class_name");
        }
        this.no = str;
    }
}
