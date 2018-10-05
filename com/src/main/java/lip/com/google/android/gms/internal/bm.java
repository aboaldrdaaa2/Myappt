package lip.com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bm {
    public final List<bl> nr;
    public final long ns;
    public final List<String> nt;
    public final List<String> nu;
    public final List<String> nv;
    public final String nw;
    public final long nx;
    public int ny;
    public int nz;

    public bm(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (eu.p(2)) {
            eu.C("Mediation Response JSON: " + jSONObject.toString(2));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        List arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            bl blVar = new bl(jSONArray.getJSONObject(i2));
            arrayList.add(blVar);
            if (i < 0 && a(blVar)) {
                i = i2;
            }
        }
        this.ny = i;
        this.nz = jSONArray.length();
        this.nr = Collections.unmodifiableList(arrayList);
        this.nw = jSONObject.getString("qdata");
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.ns = optJSONObject.optLong("ad_network_timeout_millis", -1);
            this.nt = br.a(optJSONObject, "click_urls");
            this.nu = br.a(optJSONObject, "imp_urls");
            this.nv = br.a(optJSONObject, "nofill_urls");
            long optLong = optJSONObject.optLong("refresh", -1);
            this.nx = optLong > 0 ? optLong * 1000 : -1;
            return;
        }
        this.ns = -1;
        this.nt = null;
        this.nu = null;
        this.nv = null;
        this.nx = -1;
    }

    private boolean a(bl blVar) {
        for (String equals : blVar.nm) {
            if (equals.equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return true;
            }
        }
        return false;
    }
}
