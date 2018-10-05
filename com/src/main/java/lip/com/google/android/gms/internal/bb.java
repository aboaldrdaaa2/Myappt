package lip.com.google.android.gms.internal;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.AppEventsConstants;
import java.util.HashMap;
import java.util.Map;

public final class bb {
    public static final bc mT = new bc() {
        public void b(ex exVar, Map<String, String> map) {
        }
    };
    public static final bc mU = new bc() {
        public void b(ex exVar, Map<String, String> map) {
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                eu.D("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            Map hashMap = new HashMap();
            PackageManager packageManager = exVar.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) != null));
            }
            exVar.a("openableURLs", hashMap);
        }
    };
    public static final bc mV = new bc() {
        public void b(ex exVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                eu.D("URL missing from click GMSG.");
                return;
            }
            Uri a;
            Uri parse = Uri.parse(str);
            try {
                k cc = exVar.cc();
                if (cc != null && cc.b(parse)) {
                    a = cc.a(parse, exVar.getContext());
                    new es(exVar.getContext(), exVar.cd().sw, a.toString()).start();
                }
            } catch (l e) {
                eu.D("Unable to append parameter to URL: " + str);
            }
            a = parse;
            new es(exVar.getContext(), exVar.cd().sw, a.toString()).start();
        }
    };
    public static final bc mW = new bc() {
        public void b(ex exVar, Map<String, String> map) {
            cf ca = exVar.ca();
            if (ca == null) {
                eu.D("A GMSG tried to close something that wasn't an overlay.");
            } else {
                ca.close();
            }
        }
    };
    public static final bc mX = new bc() {
        public void b(ex exVar, Map<String, String> map) {
            cf ca = exVar.ca();
            if (ca == null) {
                eu.D("A GMSG tried to use a custom close button on something that wasn't an overlay.");
            } else {
                ca.j(AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("custom_close")));
            }
        }
    };
    public static final bc mY = new bc() {
        public void b(ex exVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                eu.D("URL missing from httpTrack GMSG.");
            } else {
                new es(exVar.getContext(), exVar.cd().sw, str).start();
            }
        }
    };
    public static final bc mZ = new bc() {
        public void b(ex exVar, Map<String, String> map) {
            eu.B("Received log message: " + ((String) map.get("string")));
        }
    };
    public static final bc na = new bc() {
        public void b(ex exVar, Map<String, String> map) {
            String str = (String) map.get("ty");
            String str2 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt((String) map.get("tx"));
                int parseInt2 = Integer.parseInt(str);
                int parseInt3 = Integer.parseInt(str2);
                k cc = exVar.cc();
                if (cc != null) {
                    cc.z().a(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                eu.D("Could not parse touch parameters from gmsg.");
            }
        }
    };
    public static final bc nb = new bh();
}
