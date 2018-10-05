package lip.com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

class ay {
    private static String afS;
    static Map<String, String> afT = new HashMap();

    ay() {
    }

    static void bX(String str) {
        synchronized (ay.class) {
            afS = str;
        }
    }

    static String d(Context context, String str, String str2) {
        String str3 = (String) afT.get(str);
        if (str3 == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_click_referrers", 0);
            str3 = sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
            afT.put(str, str3);
        }
        return p(str3, str2);
    }

    static void d(Context context, String str) {
        cy.a(context, "gtm_install_referrer", "referrer", str);
        f(context, str);
    }

    static String e(Context context, String str) {
        if (afS == null) {
            synchronized (ay.class) {
                if (afS == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_install_referrer", 0);
                    if (sharedPreferences != null) {
                        afS = sharedPreferences.getString("referrer", "");
                    } else {
                        afS = "";
                    }
                }
            }
        }
        return p(afS, str);
    }

    static void f(Context context, String str) {
        String p = p(str, "conv");
        if (p != null && p.length() > 0) {
            afT.put(p, str);
            cy.a(context, "gtm_click_referrers", p, str);
        }
    }

    static String p(String str, String str2) {
        return str2 == null ? str.length() > 0 ? str : null : Uri.parse("http://hostname/?" + str).getQueryParameter(str2);
    }
}
