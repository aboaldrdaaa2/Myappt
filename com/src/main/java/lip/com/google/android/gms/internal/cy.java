package lip.com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

public final class cy {
    public static int a(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            eu.D("Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            eu.D("Unexpected type for intent response code. " + obj.getClass().getName());
            return 5;
        }
    }

    public static int c(Intent intent) {
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            eu.D("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            eu.D("Unexpected type for intent response code. " + obj.getClass().getName());
            return 5;
        }
    }

    public static String d(Intent intent) {
        return intent == null ? null : intent.getStringExtra("INAPP_PURCHASE_DATA");
    }

    public static String e(Intent intent) {
        return intent == null ? null : intent.getStringExtra("INAPP_DATA_SIGNATURE");
    }

    public static String p(String str) {
        String str2 = null;
        if (str == null) {
            return str2;
        }
        try {
            return new JSONObject(str).getString("developerPayload");
        } catch (JSONException e) {
            eu.D("Fail to parse purchase data");
            return str2;
        }
    }

    public static String q(String str) {
        String str2 = null;
        if (str == null) {
            return str2;
        }
        try {
            return new JSONObject(str).getString("purchaseToken");
        } catch (JSONException e) {
            eu.D("Fail to parse purchase data");
            return str2;
        }
    }
}
