package lip.com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class ha implements SafeParcelable {
    private static final Object FX = new Object();
    private static ClassLoader FY = null;
    private static Integer FZ = null;
    private boolean Ga = false;

    private static boolean a(Class<?> cls) {
        boolean z = false;
        try {
            return SafeParcelable.NULL.equals(cls.getField("NULL").get(null));
        } catch (NoSuchFieldException e) {
            return z;
        } catch (IllegalAccessException e2) {
            return z;
        }
    }

    protected static boolean aA(String str) {
        ClassLoader fp = fp();
        if (fp == null) {
            return true;
        }
        try {
            return a(fp.loadClass(str));
        } catch (Exception e) {
            return false;
        }
    }

    protected static ClassLoader fp() {
        ClassLoader classLoader;
        synchronized (FX) {
            classLoader = FY;
        }
        return classLoader;
    }

    protected static Integer fq() {
        Integer num;
        synchronized (FX) {
            num = FZ;
        }
        return num;
    }

    protected boolean fr() {
        return this.Ga;
    }
}
