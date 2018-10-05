package lip.com.google.ads.interactivemedia.v3.a;

import com.google.ads.interactivemedia.v3.a.b.a.g;
import com.google.ads.interactivemedia.v3.a.b.a.h;
import com.google.ads.interactivemedia.v3.a.b.a.i;
import com.google.ads.interactivemedia.v3.a.b.a.j;
import com.google.ads.interactivemedia.v3.a.b.a.l;
import com.google.ads.interactivemedia.v3.a.b.c;
import com.google.ads.interactivemedia.v3.a.b.d;
import com.google.ads.interactivemedia.v3.a.d.b;
import java.io.IOException;
import java.io.StringReader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
public final class f {
    final j a;
    final r b;
    private final ThreadLocal<Map<com.google.ads.interactivemedia.v3.a.c.a<?>, a<?>>> c;
    private final Map<com.google.ads.interactivemedia.v3.a.c.a<?>, w<?>> d;
    private final List<x> e;
    private final c f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;

    /* compiled from: IMASDK */
    static class a<T> extends w<T> {
        private w<T> a;

        a() {
        }

        public final void a(w<T> wVar) {
            if (this.a != null) {
                throw new AssertionError();
            }
            this.a = wVar;
        }

        public final T a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            if (this.a != null) {
                return this.a.a(aVar);
            }
            throw new IllegalStateException();
        }

        public final void a(com.google.ads.interactivemedia.v3.a.d.c cVar, T t) throws IOException {
            if (this.a == null) {
                throw new IllegalStateException();
            }
            this.a.a(cVar, t);
        }
    }

    public f() {
        this(d.a, d.a, Collections.emptyMap(), false, false, false, true, false, false, u.a, Collections.emptyList());
    }

    f(d dVar, e eVar, Map<Type, h<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, u uVar, List<x> list) {
        this.c = new ThreadLocal();
        this.d = Collections.synchronizedMap(new HashMap());
        this.a = new j() {
        };
        this.b = new r() {
        };
        this.f = new c(map);
        this.g = z;
        this.i = z3;
        this.h = z4;
        this.j = z5;
        List arrayList = new ArrayList();
        arrayList.add(l.Q);
        arrayList.add(g.a);
        arrayList.add(dVar);
        arrayList.addAll(list);
        arrayList.add(l.x);
        arrayList.add(l.m);
        arrayList.add(l.g);
        arrayList.add(l.i);
        arrayList.add(l.k);
        arrayList.add(l.a(Long.TYPE, Long.class, uVar == u.a ? l.n : new w<Number>() {
            public final /* synthetic */ Object a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
                if (aVar.f() != b.NULL) {
                    return Long.valueOf(aVar.l());
                }
                aVar.j();
                return null;
            }

            public final /* synthetic */ void a(com.google.ads.interactivemedia.v3.a.d.c cVar, Object obj) throws IOException {
                Number number = (Number) obj;
                if (number == null) {
                    cVar.f();
                } else {
                    cVar.a(number.toString());
                }
            }
        }));
        arrayList.add(l.a(Double.TYPE, Double.class, z6 ? l.p : new w<Number>() {
            public final /* synthetic */ Object a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
                if (aVar.f() != b.NULL) {
                    return Double.valueOf(aVar.k());
                }
                aVar.j();
                return null;
            }

            public final /* synthetic */ void a(com.google.ads.interactivemedia.v3.a.d.c cVar, Object obj) throws IOException {
                Number number = (Number) obj;
                if (number == null) {
                    cVar.f();
                    return;
                }
                double doubleValue = number.doubleValue();
                f fVar = f.this;
                f.a(doubleValue);
                cVar.a(number);
            }
        }));
        arrayList.add(l.a(Float.TYPE, Float.class, z6 ? l.o : new w<Number>() {
            public final /* synthetic */ Object a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
                if (aVar.f() != b.NULL) {
                    return Float.valueOf((float) aVar.k());
                }
                aVar.j();
                return null;
            }

            public final /* synthetic */ void a(com.google.ads.interactivemedia.v3.a.d.c cVar, Object obj) throws IOException {
                Number number = (Number) obj;
                if (number == null) {
                    cVar.f();
                    return;
                }
                float floatValue = number.floatValue();
                f fVar = f.this;
                f.a((double) floatValue);
                cVar.a(number);
            }
        }));
        arrayList.add(l.r);
        arrayList.add(l.t);
        arrayList.add(l.z);
        arrayList.add(l.B);
        arrayList.add(l.a(BigDecimal.class, l.v));
        arrayList.add(l.a(BigInteger.class, l.w));
        arrayList.add(l.D);
        arrayList.add(l.F);
        arrayList.add(l.J);
        arrayList.add(l.O);
        arrayList.add(l.H);
        arrayList.add(l.d);
        arrayList.add(com.google.ads.interactivemedia.v3.a.b.a.c.a);
        arrayList.add(l.M);
        arrayList.add(j.a);
        arrayList.add(i.a);
        arrayList.add(l.K);
        arrayList.add(com.google.ads.interactivemedia.v3.a.b.a.a.a);
        arrayList.add(l.R);
        arrayList.add(l.b);
        arrayList.add(new com.google.ads.interactivemedia.v3.a.b.a.b(this.f));
        arrayList.add(new com.google.ads.interactivemedia.v3.a.b.a.f(this.f, z2));
        arrayList.add(new h(this.f, eVar, dVar));
        this.e = Collections.unmodifiableList(arrayList);
    }

    public final <T> w<T> a(com.google.ads.interactivemedia.v3.a.c.a<T> aVar) {
        w<T> wVar = (w) this.d.get(aVar);
        if (wVar == null) {
            Map map;
            Map map2 = (Map) this.c.get();
            Object obj = null;
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                this.c.set(hashMap);
                map = hashMap;
                obj = 1;
            } else {
                map = map2;
            }
            a wVar2 = (a) map.get(aVar);
            if (wVar2 == null) {
                try {
                    a aVar2 = new a();
                    map.put(aVar, aVar2);
                    for (x a : this.e) {
                        w wVar22 = a.a(this, aVar);
                        if (wVar22 != null) {
                            aVar2.a(wVar22);
                            this.d.put(aVar, wVar22);
                            map.remove(aVar);
                            if (obj != null) {
                                this.c.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + aVar);
                } catch (Throwable th) {
                    map.remove(aVar);
                    if (obj != null) {
                        this.c.remove();
                    }
                }
            }
        }
        return wVar22;
    }

    public final <T> w<T> a(x xVar, com.google.ads.interactivemedia.v3.a.c.a<T> aVar) {
        Object obj = null;
        for (x xVar2 : this.e) {
            if (obj != null) {
                w<T> a = xVar2.a(this, aVar);
                if (a != null) {
                    return a;
                }
            } else if (xVar2 == xVar) {
                obj = 1;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public final <T> w<T> a(Class<T> cls) {
        return a(com.google.ads.interactivemedia.v3.a.c.a.a((Class) cls));
    }

    public final void a(Object obj, Type type, Appendable appendable) throws m {
        try {
            Writer a = com.google.ads.interactivemedia.v3.a.b.j.a(appendable);
            if (this.i) {
                a.write(")]}'\n");
            }
            com.google.ads.interactivemedia.v3.a.d.c cVar = new com.google.ads.interactivemedia.v3.a.d.c(a);
            if (this.j) {
                cVar.c("  ");
            }
            cVar.d(this.g);
            w a2 = a(com.google.ads.interactivemedia.v3.a.c.a.a(type));
            boolean g = cVar.g();
            cVar.b(true);
            boolean h = cVar.h();
            cVar.c(this.h);
            boolean i = cVar.i();
            cVar.d(this.g);
            try {
                a2.a(cVar, obj);
                cVar.b(g);
                cVar.c(h);
                cVar.d(i);
            } catch (Throwable e) {
                throw new m(e);
            } catch (Throwable th) {
                cVar.b(g);
                cVar.c(h);
                cVar.d(i);
            }
        } catch (Throwable e2) {
            throw new m(e2);
        }
    }

    public final <T> T a(String str, Class<T> cls) throws t {
        Object obj;
        if (str == null) {
            obj = null;
        } else {
            com.google.ads.interactivemedia.v3.a.d.a aVar = new com.google.ads.interactivemedia.v3.a.d.a(new StringReader(str));
            obj = a(aVar, (Type) cls);
            if (obj != null) {
                try {
                    if (aVar.f() != b.END_DOCUMENT) {
                        throw new m("JSON document was not fully consumed.");
                    }
                } catch (Throwable e) {
                    throw new t(e);
                } catch (Throwable e2) {
                    throw new m(e2);
                }
            }
        }
        return com.google.ads.interactivemedia.v3.a.b.i.a((Class) cls).cast(obj);
    }

    private <T> T a(com.google.ads.interactivemedia.v3.a.d.a aVar, Type type) throws m, t {
        boolean z = true;
        boolean p = aVar.p();
        aVar.a(true);
        try {
            aVar.f();
            z = false;
            T a = a(com.google.ads.interactivemedia.v3.a.c.a.a(type)).a(aVar);
            aVar.a(p);
            return a;
        } catch (Throwable e) {
            if (z) {
                aVar.a(p);
                return null;
            }
            throw new t(e);
        } catch (Throwable e2) {
            throw new t(e2);
        } catch (Throwable e22) {
            throw new t(e22);
        } catch (Throwable th) {
            aVar.a(p);
        }
    }

    public final String toString() {
        return "{serializeNulls:" + this.g + "factories:" + this.e + ",instanceCreators:" + this.f + "}";
    }
}
