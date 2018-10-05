package lip.com.google.android.gms.internal;

import android.os.Bundle;

public class ek {
    private final Object ls;
    private final eh rD;
    private final String rG;
    private int sc;
    private int sd;

    ek(eh ehVar, String str) {
        this.ls = new Object();
        this.rD = ehVar;
        this.rG = str;
    }

    public ek(String str) {
        this(eh.bH(), str);
    }

    public void a(int i, int i2) {
        synchronized (this.ls) {
            this.sc = i;
            this.sd = i2;
            this.rD.a(this.rG, this);
        }
    }

    public Bundle toBundle() {
        Bundle bundle;
        synchronized (this.ls) {
            bundle = new Bundle();
            bundle.putInt("pmnli", this.sc);
            bundle.putInt("pmnll", this.sd);
        }
        return bundle;
    }
}
