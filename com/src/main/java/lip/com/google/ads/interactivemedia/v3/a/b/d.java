package lip.com.google.ads.interactivemedia.v3.a.b;

import com.google.ads.interactivemedia.v3.a.b;
import com.google.ads.interactivemedia.v3.a.c.a;
import com.google.ads.interactivemedia.v3.a.d.c;
import com.google.ads.interactivemedia.v3.a.f;
import com.google.ads.interactivemedia.v3.a.w;
import com.google.ads.interactivemedia.v3.a.x;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
public final class d implements x, Cloneable {
    public static final d a = new d();
    private double b = -1.0d;
    private int c = 136;
    private boolean d = true;
    private boolean e;
    private List<b> f = Collections.emptyList();
    private List<b> g = Collections.emptyList();

    private d a() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public final <T> w<T> a(f fVar, a<T> aVar) {
        Class a = aVar.a();
        final boolean a2 = a(a, true);
        final boolean a3 = a(a, false);
        if (!a2 && !a3) {
            return null;
        }
        final f fVar2 = fVar;
        final a<T> aVar2 = aVar;
        return new w<T>() {
            private w<T> f;

            public final T a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
                if (!a3) {
                    return a().a(aVar);
                }
                aVar.n();
                return null;
            }

            public final void a(c cVar, T t) throws IOException {
                if (a2) {
                    cVar.f();
                } else {
                    a().a(cVar, t);
                }
            }

            private w<T> a() {
                w<T> wVar = this.f;
                if (wVar != null) {
                    return wVar;
                }
                wVar = fVar2.a(d.this, aVar2);
                this.f = wVar;
                return wVar;
            }
        };
    }

    public final boolean a(Field field, boolean z) {
        if ((this.c & field.getModifiers()) != 0) {
            return true;
        }
        if (this.b != -1.0d && !a((com.google.ads.interactivemedia.v3.a.a.c) field.getAnnotation(com.google.ads.interactivemedia.v3.a.a.c.class), (com.google.ads.interactivemedia.v3.a.a.d) field.getAnnotation(com.google.ads.interactivemedia.v3.a.a.d.class))) {
            return true;
        }
        if (field.isSynthetic()) {
            return true;
        }
        if (this.e) {
            com.google.ads.interactivemedia.v3.a.a.a aVar = (com.google.ads.interactivemedia.v3.a.a.a) field.getAnnotation(com.google.ads.interactivemedia.v3.a.a.a.class);
            if (aVar == null || (z ? !aVar.a() : !aVar.b())) {
                return true;
            }
        }
        if (!this.d && b(field.getType())) {
            return true;
        }
        if (a(field.getType())) {
            return true;
        }
        List<b> list = z ? this.f : this.g;
        if (!list.isEmpty()) {
            com.google.ads.interactivemedia.v3.a.c cVar = new com.google.ads.interactivemedia.v3.a.c(field);
            for (b a : list) {
                if (a.a()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean a(Class<?> cls, boolean z) {
        if (this.b != -1.0d && !a((com.google.ads.interactivemedia.v3.a.a.c) cls.getAnnotation(com.google.ads.interactivemedia.v3.a.a.c.class), (com.google.ads.interactivemedia.v3.a.a.d) cls.getAnnotation(com.google.ads.interactivemedia.v3.a.a.d.class))) {
            return true;
        }
        if (!this.d && b(cls)) {
            return true;
        }
        if (a(cls)) {
            return true;
        }
        for (b b : z ? this.f : this.g) {
            if (b.b()) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private static boolean b(Class<?> cls) {
        if (cls.isMemberClass()) {
            if (!((cls.getModifiers() & 8) != 0)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(com.google.ads.interactivemedia.v3.a.a.c cVar, com.google.ads.interactivemedia.v3.a.a.d dVar) {
        boolean z = cVar == null || cVar.a() <= this.b;
        if (z) {
            z = dVar == null || dVar.a() > this.b;
            if (z) {
                return true;
            }
        }
        return false;
    }
}
