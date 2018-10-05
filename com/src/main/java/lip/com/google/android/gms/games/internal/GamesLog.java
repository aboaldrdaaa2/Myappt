package lip.com.google.android.gms.games.internal;

import com.google.android.gms.internal.hf;

public final class GamesLog {
    private static final hf OV = new hf("Games");

    private GamesLog() {
    }

    public static void a(String str, String str2, Throwable th) {
        OV.a(str, str2, th);
    }

    public static void b(String str, String str2, Throwable th) {
        OV.b(str, str2, th);
    }

    public static void i(String str, String str2) {
        OV.i(str, str2);
    }

    public static void j(String str, String str2) {
        OV.j(str, str2);
    }

    public static void k(String str, String str2) {
        OV.k(str, str2);
    }
}
