package lip.com.google.android.gms.internal;

import android.content.Intent;

public class cz {
    private final String mz;

    public cz(String str) {
        this.mz = str;
    }

    public boolean a(String str, int i, Intent intent) {
        if (str == null || intent == null) {
            return false;
        }
        String d = cy.d(intent);
        String e = cy.e(intent);
        if (d == null || e == null) {
            return false;
        }
        if (!str.equals(cy.p(d))) {
            eu.D("Developer payload not match.");
            return false;
        } else if (this.mz == null || da.b(this.mz, d, e)) {
            return true;
        } else {
            eu.D("Fail to verify signature.");
            return false;
        }
    }

    public String bm() {
        return eo.bT();
    }
}
