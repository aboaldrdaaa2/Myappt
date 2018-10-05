package lip.com.google.android.gms.analytics;

import android.text.TextUtils;

class x {
    private String wv;
    private final long ww;
    private final long wx;
    private String wy = "https:";

    x(String str, long j, long j2) {
        this.wv = str;
        this.ww = j;
        this.wx = j2;
    }

    void Q(String str) {
        this.wv = str;
    }

    void R(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim()) && str.toLowerCase().startsWith("http:")) {
            this.wy = "http:";
        }
    }

    String dk() {
        return this.wv;
    }

    long dl() {
        return this.ww;
    }

    long dm() {
        return this.wx;
    }

    String dn() {
        return this.wy;
    }
}
