package lip.com.google.ads.interactivemedia.v3.a.b;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: IMASDK */
public abstract class k {
    public abstract <T> T a(Class<T> cls) throws Exception;

    public static k a() {
        final Method method;
        try {
            Class cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            final Object obj = declaredField.get(null);
            method = cls.getMethod("allocateInstance", new Class[]{Class.class});
            return new k() {
                public final <T> T a(Class<T> cls) throws Exception {
                    return method.invoke(obj, new Object[]{cls});
                }
            };
        } catch (Exception e) {
            try {
                final Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});
                declaredMethod.setAccessible(true);
                return new k() {
                    public final <T> T a(Class<T> cls) throws Exception {
                        return declaredMethod.invoke(null, new Object[]{cls, Object.class});
                    }
                };
            } catch (Exception e2) {
                try {
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                    declaredMethod2.setAccessible(true);
                    final int intValue = ((Integer) declaredMethod2.invoke(null, new Object[]{Object.class})).intValue();
                    method = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});
                    method.setAccessible(true);
                    return new k() {
                        public final <T> T a(Class<T> cls) throws Exception {
                            return method.invoke(null, new Object[]{cls, Integer.valueOf(intValue)});
                        }
                    };
                } catch (Exception e3) {
                    return new k() {
                        public final <T> T a(Class<T> cls) {
                            throw new UnsupportedOperationException("Cannot allocate " + cls);
                        }
                    };
                }
            }
        }
    }
}
