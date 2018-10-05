package lip.com.google.ads.interactivemedia.v3.a.b;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: IMASDK */
public final class g<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean f = (!g.class.desiredAssertionStatus());
    private static final Comparator<Comparable> g = new Comparator<Comparable>() {
        public final /* synthetic */ int compare(Object x0, Object x1) {
            return ((Comparable) x0).compareTo((Comparable) x1);
        }
    };
    Comparator<? super K> a;
    d<K, V> b;
    int c;
    int d;
    final d<K, V> e;
    private a h;
    private b i;

    /* compiled from: IMASDK */
    class a extends AbstractSet<Entry<K, V>> {
        a() {
        }

        public final int size() {
            return g.this.c;
        }

        public final Iterator<Entry<K, V>> iterator() {
            return new c<Entry<K, V>>() {
                {
                    g gVar = g.this;
                }
            };
        }

        public final boolean contains(Object o) {
            return (o instanceof Entry) && g.this.a((Entry) o) != null;
        }

        public final boolean remove(Object o) {
            if (!(o instanceof Entry)) {
                return false;
            }
            d a = g.this.a((Entry) o);
            if (a == null) {
                return false;
            }
            g.this.a(a, true);
            return true;
        }

        public final void clear() {
            g.this.clear();
        }
    }

    /* compiled from: IMASDK */
    class b extends AbstractSet<K> {
        b() {
        }

        public final int size() {
            return g.this.c;
        }

        public final Iterator<K> iterator() {
            return new c<K>() {
                {
                    g gVar = g.this;
                }

                public final K next() {
                    return next().f;
                }
            };
        }

        public final boolean contains(Object o) {
            return g.this.containsKey(o);
        }

        public final boolean remove(Object key) {
            return g.this.a(key) != null;
        }

        public final void clear() {
            g.this.clear();
        }
    }

    /* compiled from: IMASDK */
    private abstract class c<T> implements Iterator<T> {
        d<K, V> b;
        d<K, V> c;
        int d;

        private c() {
            this.b = g.this.e.d;
            this.c = null;
            this.d = g.this.d;
        }

        /* synthetic */ c(g gVar, byte b) {
            this();
        }

        public final boolean hasNext() {
            return this.b != g.this.e;
        }

        /* renamed from: a */
        final d<K, V> next() {
            d<K, V> dVar = this.b;
            if (dVar == g.this.e) {
                throw new NoSuchElementException();
            } else if (g.this.d != this.d) {
                throw new ConcurrentModificationException();
            } else {
                this.b = dVar.d;
                this.c = dVar;
                return dVar;
            }
        }

        public final void remove() {
            if (this.c == null) {
                throw new IllegalStateException();
            }
            g.this.a(this.c, true);
            this.c = null;
            this.d = g.this.d;
        }
    }

    /* compiled from: IMASDK */
    static final class d<K, V> implements Entry<K, V> {
        d<K, V> a;
        d<K, V> b;
        d<K, V> c;
        d<K, V> d;
        d<K, V> e;
        final K f;
        V g;
        int h;

        d() {
            this.f = null;
            this.e = this;
            this.d = this;
        }

        d(d<K, V> dVar, K k, d<K, V> dVar2, d<K, V> dVar3) {
            this.a = dVar;
            this.f = k;
            this.h = 1;
            this.d = dVar2;
            this.e = dVar3;
            dVar3.d = this;
            dVar2.e = this;
        }

        public final K getKey() {
            return this.f;
        }

        public final V getValue() {
            return this.g;
        }

        public final V setValue(V value) {
            V v = this.g;
            this.g = value;
            return v;
        }

        public final boolean equals(Object o) {
            if (!(o instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) o;
            if (this.f == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!this.f.equals(entry.getKey())) {
                return false;
            }
            if (this.g == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!this.g.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = this.f == null ? 0 : this.f.hashCode();
            if (this.g != null) {
                i = this.g.hashCode();
            }
            return hashCode ^ i;
        }

        public final String toString() {
            return this.f + "=" + this.g;
        }

        public final d<K, V> a() {
            d<K, V> thisR;
            for (d<K, V> dVar = this.b; dVar != null; dVar = dVar.b) {
                thisR = dVar;
            }
            return thisR;
        }

        public final d<K, V> b() {
            d<K, V> thisR;
            for (d<K, V> dVar = this.c; dVar != null; dVar = dVar.c) {
                thisR = dVar;
            }
            return thisR;
        }
    }

    public g() {
        this(g);
    }

    private g(Comparator<? super K> comparator) {
        Comparator comparator2;
        this.c = 0;
        this.d = 0;
        this.e = new d();
        if (comparator2 == null) {
            comparator2 = g;
        }
        this.a = comparator2;
    }

    public final int size() {
        return this.c;
    }

    public final V get(Object key) {
        d b = b(key);
        return b != null ? b.g : null;
    }

    public final boolean containsKey(Object key) {
        return b(key) != null;
    }

    public final V put(K key, V value) {
        if (key == null) {
            throw new NullPointerException("key == null");
        }
        d a = a((Object) key, true);
        V v = a.g;
        a.g = value;
        return v;
    }

    public final void clear() {
        this.b = null;
        this.c = 0;
        this.d++;
        d dVar = this.e;
        dVar.e = dVar;
        dVar.d = dVar;
    }

    public final V remove(Object key) {
        d a = a(key);
        return a != null ? a.g : null;
    }

    private d<K, V> a(K k, boolean z) {
        d dVar;
        int i;
        Comparator comparator = this.a;
        d<K, V> dVar2 = this.b;
        if (dVar2 != null) {
            Comparable comparable = comparator == g ? (Comparable) k : null;
            while (true) {
                int compareTo = comparable != null ? comparable.compareTo(dVar2.f) : comparator.compare(k, dVar2.f);
                if (compareTo != 0) {
                    d<K, V> dVar3 = compareTo < 0 ? dVar2.b : dVar2.c;
                    if (dVar3 == null) {
                        int i2 = compareTo;
                        dVar = dVar2;
                        i = i2;
                        break;
                    }
                    dVar2 = dVar3;
                } else {
                    return dVar2;
                }
            }
        }
        d<K, V> dVar4 = dVar2;
        i = 0;
        if (!z) {
            return null;
        }
        d<K, V> dVar5;
        d dVar6 = this.e;
        if (dVar4 != null) {
            dVar5 = new d(dVar4, k, dVar6, dVar6.e);
            if (i < 0) {
                dVar4.b = dVar5;
            } else {
                dVar4.c = dVar5;
            }
            b(dVar4, true);
        } else if (comparator != g || (k instanceof Comparable)) {
            dVar5 = new d(dVar4, k, dVar6, dVar6.e);
            this.b = dVar5;
        } else {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        }
        this.c++;
        this.d++;
        return dVar5;
    }

    private d<K, V> b(Object obj) {
        d<K, V> dVar = null;
        if (obj == null) {
            return dVar;
        }
        try {
            return a(obj, false);
        } catch (ClassCastException e) {
            return dVar;
        }
    }

    /* JADX WARNING: Missing block: B:8:0x001d, code:
            if (r3 != null) goto L_0x001f;
     */
    final com.google.ads.interactivemedia.v3.a.b.g.d<K, V> a(Entry<?, ?> r6) {
        /*
        r5 = this;
        r1 = 1;
        r2 = 0;
        r0 = r6.getKey();
        r0 = r5.b(r0);
        if (r0 == 0) goto L_0x0024;
    L_0x000c:
        r3 = r0.g;
        r4 = r6.getValue();
        if (r3 == r4) goto L_0x001c;
    L_0x0014:
        if (r3 == 0) goto L_0x0022;
    L_0x0016:
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0022;
    L_0x001c:
        r3 = r1;
    L_0x001d:
        if (r3 == 0) goto L_0x0024;
    L_0x001f:
        if (r1 == 0) goto L_0x0026;
    L_0x0021:
        return r0;
    L_0x0022:
        r3 = r2;
        goto L_0x001d;
    L_0x0024:
        r1 = r2;
        goto L_0x001f;
    L_0x0026:
        r0 = 0;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.a.b.g.a(java.util.Map$Entry):com.google.ads.interactivemedia.v3.a.b.g$d<K, V>");
    }

    final void a(d<K, V> dVar, boolean z) {
        int i = 0;
        if (z) {
            dVar.e.d = dVar.d;
            dVar.d.e = dVar.e;
        }
        d dVar2 = dVar.b;
        d dVar3 = dVar.c;
        d dVar4 = dVar.a;
        if (dVar2 == null || dVar3 == null) {
            if (dVar2 != null) {
                a((d) dVar, dVar2);
                dVar.b = null;
            } else if (dVar3 != null) {
                a((d) dVar, dVar3);
                dVar.c = null;
            } else {
                a((d) dVar, null);
            }
            b(dVar4, false);
            this.c--;
            this.d++;
            return;
        }
        int i2;
        dVar2 = dVar2.h > dVar3.h ? dVar2.b() : dVar3.a();
        a(dVar2, false);
        dVar4 = dVar.b;
        if (dVar4 != null) {
            i2 = dVar4.h;
            dVar2.b = dVar4;
            dVar4.a = dVar2;
            dVar.b = null;
        } else {
            i2 = 0;
        }
        dVar4 = dVar.c;
        if (dVar4 != null) {
            i = dVar4.h;
            dVar2.c = dVar4;
            dVar4.a = dVar2;
            dVar.c = null;
        }
        dVar2.h = Math.max(i2, i) + 1;
        a((d) dVar, dVar2);
    }

    final d<K, V> a(Object obj) {
        d b = b(obj);
        if (b != null) {
            a(b, true);
        }
        return b;
    }

    private void a(d<K, V> dVar, d<K, V> dVar2) {
        d dVar3 = dVar.a;
        dVar.a = null;
        if (dVar2 != null) {
            dVar2.a = dVar3;
        }
        if (dVar3 == null) {
            this.b = dVar2;
        } else if (dVar3.b == dVar) {
            dVar3.b = dVar2;
        } else if (f || dVar3.c == dVar) {
            dVar3.c = dVar2;
        } else {
            throw new AssertionError();
        }
    }

    private void b(d<K, V> dVar, boolean z) {
        d dVar2;
        while (dVar2 != null) {
            int i;
            d dVar3 = dVar2.b;
            d dVar4 = dVar2.c;
            int i2 = dVar3 != null ? dVar3.h : 0;
            if (dVar4 != null) {
                i = dVar4.h;
            } else {
                i = 0;
            }
            int i3 = i2 - i;
            d dVar5;
            if (i3 == -2) {
                dVar3 = dVar4.b;
                dVar5 = dVar4.c;
                if (dVar5 != null) {
                    i2 = dVar5.h;
                } else {
                    i2 = 0;
                }
                if (dVar3 != null) {
                    i = dVar3.h;
                } else {
                    i = 0;
                }
                i -= i2;
                if (i == -1 || (i == 0 && !z)) {
                    a(dVar2);
                } else if (f || i == 1) {
                    b(dVar4);
                    a(dVar2);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                dVar4 = dVar3.b;
                dVar5 = dVar3.c;
                i2 = dVar5 != null ? dVar5.h : 0;
                if (dVar4 != null) {
                    i = dVar4.h;
                } else {
                    i = 0;
                }
                i -= i2;
                if (i == 1 || (i == 0 && !z)) {
                    b(dVar2);
                } else if (f || i == -1) {
                    a(dVar3);
                    b(dVar2);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                dVar2.h = i2 + 1;
                if (z) {
                    return;
                }
            } else if (f || i3 == -1 || i3 == 1) {
                dVar2.h = Math.max(i2, i) + 1;
                if (!z) {
                    return;
                }
            } else {
                throw new AssertionError();
            }
            dVar2 = dVar2.a;
        }
    }

    private void a(d<K, V> dVar) {
        int i;
        int i2 = 0;
        d dVar2 = dVar.b;
        d dVar3 = dVar.c;
        d dVar4 = dVar3.b;
        d dVar5 = dVar3.c;
        dVar.c = dVar4;
        if (dVar4 != null) {
            dVar4.a = dVar;
        }
        a((d) dVar, dVar3);
        dVar3.b = dVar;
        dVar.a = dVar3;
        if (dVar2 != null) {
            i = dVar2.h;
        } else {
            i = 0;
        }
        dVar.h = Math.max(i, dVar4 != null ? dVar4.h : 0) + 1;
        int i3 = dVar.h;
        if (dVar5 != null) {
            i2 = dVar5.h;
        }
        dVar3.h = Math.max(i3, i2) + 1;
    }

    private void b(d<K, V> dVar) {
        int i;
        int i2 = 0;
        d dVar2 = dVar.b;
        d dVar3 = dVar.c;
        d dVar4 = dVar2.b;
        d dVar5 = dVar2.c;
        dVar.b = dVar5;
        if (dVar5 != null) {
            dVar5.a = dVar;
        }
        a((d) dVar, dVar2);
        dVar2.c = dVar;
        dVar.a = dVar2;
        if (dVar3 != null) {
            i = dVar3.h;
        } else {
            i = 0;
        }
        dVar.h = Math.max(i, dVar5 != null ? dVar5.h : 0) + 1;
        int i3 = dVar.h;
        if (dVar4 != null) {
            i2 = dVar4.h;
        }
        dVar2.h = Math.max(i3, i2) + 1;
    }

    public final Set<Entry<K, V>> entrySet() {
        Set set = this.h;
        if (set != null) {
            return set;
        }
        Set<Entry<K, V>> aVar = new a();
        this.h = aVar;
        return aVar;
    }

    public final Set<K> keySet() {
        Set set = this.i;
        if (set != null) {
            return set;
        }
        Set<K> bVar = new b();
        this.i = bVar;
        return bVar;
    }
}
