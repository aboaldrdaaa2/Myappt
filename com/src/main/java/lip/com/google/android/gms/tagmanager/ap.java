package lip.com.google.android.gms.tagmanager;

import android.text.TextUtils;

class ap {
    private final long afF;
    private String afG;
    private final long ww;
    private final long wx;

    ap(long j, long j2, long j3) {
        this.ww = j;
        this.wx = j2;
        this.afF = j3;
    }

    void R(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.afG = str;
        }
    }

    long dl() {
        return this.ww;
    }

    long lN() {
        return this.afF;
    }

    String lO() {
        return this.afG;
    }
}
