package lip.com.google.ads.interactivemedia.v3.a.b.a;

import com.google.ads.interactivemedia.v3.a.b.c;
import com.google.ads.interactivemedia.v3.a.b.d;
import com.google.ads.interactivemedia.v3.a.b.i;
import com.google.ads.interactivemedia.v3.a.e;
import com.google.ads.interactivemedia.v3.a.f;
import com.google.ads.interactivemedia.v3.a.t;
import com.google.ads.interactivemedia.v3.a.w;
import com.google.ads.interactivemedia.v3.a.x;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: IMASDK */
public final class h implements x {
    private final c a;
    private final e b;
    private final d c;

    /* compiled from: IMASDK */
    static abstract class b {
        final String g;
        final boolean h;
        final boolean i;

        abstract void a(com.google.ads.interactivemedia.v3.a.d.a aVar, Object obj) throws IOException, IllegalAccessException;

        abstract void a(com.google.ads.interactivemedia.v3.a.d.c cVar, Object obj) throws IOException, IllegalAccessException;

        protected b(String str, boolean z, boolean z2) {
            this.g = str;
            this.h = z;
            this.i = z2;
        }
    }

    /* compiled from: IMASDK */
    public static final class a<T> extends w<T> {
        private final com.google.ads.interactivemedia.v3.a.b.h<T> a;
        private final Map<String, b> b;

        /* synthetic */ a(com.google.ads.interactivemedia.v3.a.b.h hVar, Map map, byte b) {
            this(hVar, map);
        }

        private a(com.google.ads.interactivemedia.v3.a.b.h<T> hVar, Map<String, b> map) {
            this.a = hVar;
            this.b = map;
        }

        public final T a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            if (aVar.f() == com.google.ads.interactivemedia.v3.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            T a = this.a.a();
            try {
                aVar.c();
                while (aVar.e()) {
                    b bVar = (b) this.b.get(aVar.g());
                    if (bVar == null || !bVar.i) {
                        aVar.n();
                    } else {
                        bVar.a(aVar, (Object) a);
                    }
                }
                aVar.d();
                return a;
            } catch (Throwable e) {
                throw new t(e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        public final void a(com.google.ads.interactivemedia.v3.a.d.c cVar, T t) throws IOException {
            if (t == null) {
                cVar.f();
                return;
            }
            cVar.d();
            try {
                for (b bVar : this.b.values()) {
                    if (bVar.h) {
                        cVar.a(bVar.g);
                        bVar.a(cVar, (Object) t);
                    }
                }
                cVar.e();
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            }
        }
    }

    public h(c cVar, e eVar, d dVar) {
        this.a = cVar;
        this.b = eVar;
        this.c = dVar;
    }

    private boolean a(Field field, boolean z) {
        return (this.c.a(field.getType(), z) || this.c.a(field, z)) ? false : true;
    }

    public final <T> w<T> a(f fVar, com.google.ads.interactivemedia.v3.a.c.a<T> aVar) {
        Class a = aVar.a();
        if (Object.class.isAssignableFrom(a)) {
            return new a(this.a.a((com.google.ads.interactivemedia.v3.a.c.a) aVar), a(fVar, aVar, a), (byte) 0);
        }
        return null;
    }

    private Map<String, b> a(f fVar, com.google.ads.interactivemedia.v3.a.c.a<?> aVar, Class<?> cls) {
        Map<String, b> linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type b = aVar.b();
        Class cls2;
        while (cls2 != Object.class) {
            for (final Field field : cls2.getDeclaredFields()) {
                boolean a = a(field, true);
                boolean a2 = a(field, false);
                if (a || a2) {
                    field.setAccessible(true);
                    Type a3 = com.google.ads.interactivemedia.v3.a.b.b.a(aVar.b(), cls2, field.getGenericType());
                    com.google.ads.interactivemedia.v3.a.a.b bVar = (com.google.ads.interactivemedia.v3.a.a.b) field.getAnnotation(com.google.ads.interactivemedia.v3.a.a.b.class);
                    String a4 = bVar == null ? this.b.a(field) : bVar.a();
                    final com.google.ads.interactivemedia.v3.a.c.a a5 = com.google.ads.interactivemedia.v3.a.c.a.a(a3);
                    final boolean a6 = i.a(a5.a());
                    final f fVar2 = fVar;
                    b anonymousClass1 = new b(a4, a, a2) {
                        final w<?> a = fVar2.a(a5);

                        final void a(com.google.ads.interactivemedia.v3.a.d.c cVar, Object obj) throws IOException, IllegalAccessException {
                            new k(fVar2, this.a, a5.b()).a(cVar, field.get(obj));
                        }

                        final void a(com.google.ads.interactivemedia.v3.a.d.a aVar, Object obj) throws IOException, IllegalAccessException {
                            Object a = this.a.a(aVar);
                            if (a != null || !a6) {
                                field.set(obj, a);
                            }
                        }
                    };
                    anonymousClass1 = (b) linkedHashMap.put(anonymousClass1.g, anonymousClass1);
                    if (anonymousClass1 != null) {
                        throw new IllegalArgumentException(b + " declares multiple JSON fields named " + anonymousClass1.g);
                    }
                }
            }
            com.google.ads.interactivemedia.v3.a.c.a aVar2 = com.google.ads.interactivemedia.v3.a.c.a.a(com.google.ads.interactivemedia.v3.a.b.b.a(aVar2.b(), cls2, cls2.getGenericSuperclass()));
            cls2 = aVar2.a();
        }
        return linkedHashMap;
    }
}
