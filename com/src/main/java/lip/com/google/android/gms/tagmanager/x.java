package lip.com.google.android.gms.tagmanager;

import android.util.Log;

class x implements bi {
    private int tN = 5;

    x() {
    }

    public void A(String str) {
        if (this.tN <= 6) {
            Log.e("GoogleTagManager", str);
        }
    }

    public void B(String str) {
        if (this.tN <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    public void C(String str) {
        if (this.tN <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }

    public void D(String str) {
        if (this.tN <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }

    public void b(String str, Throwable th) {
        if (this.tN <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    public void c(String str, Throwable th) {
        if (this.tN <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }

    public void setLogLevel(int logLevel) {
        this.tN = logLevel;
    }

    public void z(String str) {
        if (this.tN <= 3) {
            Log.d("GoogleTagManager", str);
        }
    }
}
