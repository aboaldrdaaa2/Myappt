package lip.com.google.android.gms.analytics;

import java.util.HashMap;
import java.util.Map;

class ab {
    private final Map<String, Integer> wL = new HashMap();
    private final Map<String, String> wM = new HashMap();
    private final boolean wN;
    private final String wO;

    ab(String str, boolean z) {
        this.wN = z;
        this.wO = str;
    }

    void c(String str, int i) {
        if (this.wN) {
            Integer num = (Integer) this.wL.get(str);
            if (num == null) {
                num = Integer.valueOf(0);
            }
            this.wL.put(str, Integer.valueOf(num.intValue() + i));
        }
    }

    String dq() {
        if (!this.wN) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.wO);
        for (String str : this.wL.keySet()) {
            stringBuilder.append("&").append(str).append("=").append(this.wL.get(str));
        }
        for (String str2 : this.wM.keySet()) {
            stringBuilder.append("&").append(str2).append("=").append((String) this.wM.get(str2));
        }
        return stringBuilder.toString();
    }
}
