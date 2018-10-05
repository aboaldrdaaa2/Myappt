package lip.com.google.android.gms.internal;

import android.content.Context;
import java.util.regex.Pattern;

public final class ii {
    private static Pattern Hu = null;

    public static boolean F(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    public static int aB(int i) {
        return i / 1000;
    }

    public static int aC(int i) {
        return (i % 1000) / 100;
    }

    public static boolean aD(int i) {
        return aC(i) == 3;
    }
}
