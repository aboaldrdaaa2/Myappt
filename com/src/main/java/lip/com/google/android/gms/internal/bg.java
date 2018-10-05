package lip.com.google.android.gms.internal;

import com.facebook.AppEventsConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public final class bg implements bc {
    private final bd nd;

    public bg(bd bdVar) {
        this.nd = bdVar;
    }

    private static boolean a(Map<String, String> map) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("custom_close"));
    }

    private static int b(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return eo.bS();
            }
            if ("l".equalsIgnoreCase(str)) {
                return eo.bR();
            }
        }
        return -1;
    }

    public void b(ex exVar, Map<String, String> map) {
        String str = (String) map.get("a");
        if (str == null) {
            eu.D("Action missing from an open GMSG.");
            return;
        }
        ey cb = exVar.cb();
        if ("expand".equalsIgnoreCase(str)) {
            if (exVar.ce()) {
                eu.D("Cannot expand WebView that is already expanded.");
            } else {
                cb.a(a(map), b(map));
            }
        } else if ("webapp".equalsIgnoreCase(str)) {
            str = (String) map.get("u");
            if (str != null) {
                cb.a(a(map), b(map), str);
            } else {
                cb.a(a(map), b(map), (String) map.get("html"), (String) map.get("baseurl"));
            }
        } else if ("in_app_purchase".equalsIgnoreCase(str)) {
            str = (String) map.get("product_id");
            String str2 = (String) map.get("report_urls");
            if (this.nd == null) {
                return;
            }
            if (str2 == null || str2.isEmpty()) {
                this.nd.a(str, new ArrayList());
                return;
            }
            this.nd.a(str, new ArrayList(Arrays.asList(str2.split(" "))));
        } else {
            cb.a(new ce((String) map.get("i"), (String) map.get("u"), (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
        }
    }
}
