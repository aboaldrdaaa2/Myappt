package lip.com.google.ads.interactivemedia.v3.a.b;

import com.google.ads.interactivemedia.v3.a.c.a;
import com.google.ads.interactivemedia.v3.a.h;
import com.google.ads.interactivemedia.v3.a.m;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/* compiled from: IMASDK */
public final class c {
    private final Map<Type, h<?>> a;

    public c(Map<Type, h<?>> map) {
        this.a = map;
    }

    public final <T> h<T> a(a<T> aVar) {
        final Type b = aVar.b();
        final Class a = aVar.a();
        final h hVar = (h) this.a.get(b);
        if (hVar != null) {
            return new h<T>() {
                public final T a() {
                    h hVar = hVar;
                    Type type = b;
                    return hVar.a();
                }
            };
        }
        hVar = (h) this.a.get(a);
        if (hVar != null) {
            return new h<T>() {
                public final T a() {
                    h hVar = hVar;
                    Type type = b;
                    return hVar.a();
                }
            };
        }
        h<T> a2 = a(a);
        if (a2 != null) {
            return a2;
        }
        a2 = Collection.class.isAssignableFrom(a) ? SortedSet.class.isAssignableFrom(a) ? new h<T>() {
            public final T a() {
                return new TreeSet();
            }
        } : EnumSet.class.isAssignableFrom(a) ? new h<T>() {
            public final T a() {
                if (b instanceof ParameterizedType) {
                    Type type = ((ParameterizedType) b).getActualTypeArguments()[0];
                    if (type instanceof Class) {
                        return EnumSet.noneOf((Class) type);
                    }
                    throw new m("Invalid EnumSet type: " + b.toString());
                }
                throw new m("Invalid EnumSet type: " + b.toString());
            }
        } : Set.class.isAssignableFrom(a) ? new h<T>() {
            public final T a() {
                return new LinkedHashSet();
            }
        } : Queue.class.isAssignableFrom(a) ? new h<T>() {
            public final T a() {
                return new LinkedList();
            }
        } : new h<T>() {
            public final T a() {
                return new ArrayList();
            }
        } : Map.class.isAssignableFrom(a) ? SortedMap.class.isAssignableFrom(a) ? new h<T>() {
            public final T a() {
                return new TreeMap();
            }
        } : (!(b instanceof ParameterizedType) || String.class.isAssignableFrom(a.a(((ParameterizedType) b).getActualTypeArguments()[0]).a())) ? new h<T>() {
            public final T a() {
                return new g();
            }
        } : new h<T>() {
            public final T a() {
                return new LinkedHashMap();
            }
        } : null;
        if (a2 == null) {
            return new h<T>() {
                private final k d = k.a();

                public final T a() {
                    try {
                        return this.d.a(a);
                    } catch (Throwable e) {
                        throw new RuntimeException("Unable to invoke no-args constructor for " + b + ". Register an InstanceCreator with Gson for this type may fix this problem.", e);
                    }
                }
            };
        }
        return a2;
    }

    private <T> h<T> a(Class<? super T> cls) {
        try {
            final Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new h<T>() {
                public final T a() {
                    try {
                        return declaredConstructor.newInstance(null);
                    } catch (Throwable e) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e);
                    } catch (InvocationTargetException e2) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e2.getTargetException());
                    } catch (IllegalAccessException e3) {
                        throw new AssertionError(e3);
                    }
                }
            };
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public final String toString() {
        return this.a.toString();
    }
}
