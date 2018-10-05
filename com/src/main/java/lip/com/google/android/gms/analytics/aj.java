package lip.com.google.android.gms.analytics;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

class aj implements j {
    int xA = -1;
    int xB = -1;
    int xC = -1;
    Map<String, String> xD = new HashMap();
    String xx;
    double xy = -1.0d;
    int xz = -1;

    aj() {
    }

    public String T(String str) {
        String str2 = (String) this.xD.get(str);
        return str2 != null ? str2 : str;
    }

    public boolean dE() {
        return this.xx != null;
    }

    public String dF() {
        return this.xx;
    }

    public boolean dG() {
        return this.xy >= 0.0d;
    }

    public double dH() {
        return this.xy;
    }

    public boolean dI() {
        return this.xz >= 0;
    }

    public boolean dJ() {
        return this.xA != -1;
    }

    public boolean dK() {
        return this.xA == 1;
    }

    public boolean dL() {
        return this.xB != -1;
    }

    public boolean dM() {
        return this.xB == 1;
    }

    public boolean dN() {
        return this.xC == 1;
    }

    public int getSessionTimeout() {
        return this.xz;
    }

    public String j(Activity activity) {
        return T(activity.getClass().getCanonicalName());
    }
}
