package lip.com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class ea {
    private int mOrientation = -1;
    private String qG;
    private String qH;
    private String qI;
    private List<String> qJ;
    private String qK;
    private String qL;
    private List<String> qM;
    private long qN = -1;
    private boolean qO = false;
    private final long qP = -1;
    private List<String> qQ;
    private long qR = -1;

    private static String a(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty()) ? null : (String) list.get(0);
    }

    private static long b(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            try {
                return (long) (Float.parseFloat(str2) * 1000.0f);
            } catch (NumberFormatException e) {
                eu.D("Could not parse float from " + str + " header: " + str2);
            }
        }
        return -1;
    }

    private static List<String> c(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            if (str2 != null) {
                return Arrays.asList(str2.trim().split("\\s+"));
            }
        }
        return null;
    }

    private void e(Map<String, List<String>> map) {
        this.qG = a(map, "X-Afma-Ad-Size");
    }

    private void f(Map<String, List<String>> map) {
        List c = c(map, "X-Afma-Click-Tracking-Urls");
        if (c != null) {
            this.qJ = c;
        }
    }

    private void g(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Debug-Dialog");
        if (list != null && !list.isEmpty()) {
            this.qK = (String) list.get(0);
        }
    }

    private void h(Map<String, List<String>> map) {
        List c = c(map, "X-Afma-Tracking-Urls");
        if (c != null) {
            this.qM = c;
        }
    }

    private void i(Map<String, List<String>> map) {
        long b = b(map, "X-Afma-Interstitial-Timeout");
        if (b != -1) {
            this.qN = b;
        }
    }

    private void j(Map<String, List<String>> map) {
        this.qL = a(map, "X-Afma-ActiveView");
    }

    private void k(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Mediation");
        if (list != null && !list.isEmpty()) {
            this.qO = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    private void l(Map<String, List<String>> map) {
        List c = c(map, "X-Afma-Manual-Tracking-Urls");
        if (c != null) {
            this.qQ = c;
        }
    }

    private void m(Map<String, List<String>> map) {
        long b = b(map, "X-Afma-Refresh-Rate");
        if (b != -1) {
            this.qR = b;
        }
    }

    private void n(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Orientation");
        if (list != null && !list.isEmpty()) {
            String str = (String) list.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                this.mOrientation = eo.bS();
            } else if ("landscape".equalsIgnoreCase(str)) {
                this.mOrientation = eo.bR();
            }
        }
    }

    public void a(String str, Map<String, List<String>> map, String str2) {
        this.qH = str;
        this.qI = str2;
        d(map);
    }

    public void d(Map<String, List<String>> map) {
        e(map);
        f(map);
        g(map);
        h(map);
        i((Map) map);
        k(map);
        l(map);
        m(map);
        n(map);
        j(map);
    }

    public du i(long j) {
        return new du(this.qH, this.qI, this.qJ, this.qM, this.qN, this.qO, -1, this.qQ, this.qR, this.mOrientation, this.qG, j, this.qK, this.qL);
    }
}
