package lip.com.google.android.gms.internal;

public final class il implements ij {
    private static il Hv;

    public static synchronized ij gb() {
        ij ijVar;
        synchronized (il.class) {
            if (Hv == null) {
                Hv = new il();
            }
            ijVar = Hv;
        }
        return ijVar;
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
