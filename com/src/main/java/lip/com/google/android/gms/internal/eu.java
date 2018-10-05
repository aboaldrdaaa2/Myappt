package lip.com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;

public final class eu {
    public static void A(String str) {
        if (p(6)) {
            Log.e(AdRequest.LOGTAG, str);
        }
    }

    public static void B(String str) {
        if (p(4)) {
            Log.i(AdRequest.LOGTAG, str);
        }
    }

    public static void C(String str) {
        if (p(2)) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    public static void D(String str) {
        if (p(5)) {
            Log.w(AdRequest.LOGTAG, str);
        }
    }

    public static void a(String str, Throwable th) {
        if (p(3)) {
            Log.d(AdRequest.LOGTAG, str, th);
        }
    }

    public static void b(String str, Throwable th) {
        if (p(6)) {
            Log.e(AdRequest.LOGTAG, str, th);
        }
    }

    public static void c(String str, Throwable th) {
        if (p(5)) {
            Log.w(AdRequest.LOGTAG, str, th);
        }
    }

    public static boolean p(int i) {
        return (i >= 5 || Log.isLoggable(AdRequest.LOGTAG, i)) && i != 2;
    }

    public static void z(String str) {
        if (p(3)) {
            Log.d(AdRequest.LOGTAG, str);
        }
    }
}
