package lip.com.google.android.gms.analytics;

public class aa {
    private static GoogleAnalytics wK;

    public static void A(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.error(str);
        }
    }

    public static void B(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.info(str);
        }
    }

    public static void C(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.verbose(str);
        }
    }

    public static void D(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.warn(str);
        }
    }

    public static boolean dp() {
        return getLogger() != null && getLogger().getLogLevel() == 0;
    }

    private static Logger getLogger() {
        if (wK == null) {
            wK = GoogleAnalytics.di();
        }
        return wK != null ? wK.getLogger() : null;
    }
}
