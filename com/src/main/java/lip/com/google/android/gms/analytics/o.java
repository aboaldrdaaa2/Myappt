package lip.com.google.android.gms.analytics;

public final class o {
    private static String b(String str, int i) {
        if (i >= 1) {
            return str + i;
        }
        aa.A("index out of range for " + str + " (" + i + ")");
        return "";
    }

    static String s(int i) {
        return b("&cd", i);
    }

    static String t(int i) {
        return b("&cm", i);
    }

    public static String u(int i) {
        return b("&pr", i);
    }

    public static String v(int i) {
        return b("&promo", i);
    }

    public static String w(int i) {
        return b("pi", i);
    }

    public static String x(int i) {
        return b("&il", i);
    }

    public static String y(int i) {
        return b("cd", i);
    }

    public static String z(int i) {
        return b("cm", i);
    }
}
