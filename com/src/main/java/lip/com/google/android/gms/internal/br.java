package lip.com.google.android.gms.internal;

import android.content.Context;
import com.facebook.AppEventsConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class br {
    public static List<String> a(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        List arrayList = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.getString(i));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static void a(Context context, String str, ef efVar, String str2, boolean z, List<String> list) {
        String str3 = z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        for (String replaceAll : list) {
            String replaceAll2 = replaceAll2.replaceAll("@gw_adlocid@", str2).replaceAll("@gw_adnetrefresh@", str3).replaceAll("@gw_qdata@", efVar.rz.nw).replaceAll("@gw_sdkver@", str).replaceAll("@gw_sessid@", eh.rQ).replaceAll("@gw_seqnum@", efVar.qa);
            if (efVar.nM != null) {
                replaceAll2 = replaceAll2.replaceAll("@gw_adnetid@", efVar.nM.nl).replaceAll("@gw_allocid@", efVar.nM.nn);
            }
            new es(context, str, replaceAll2).start();
        }
    }
}
