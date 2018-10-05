package lip.com.google.ads.interactivemedia.v3.a.b.a;

import com.google.ads.interactivemedia.v3.a.d.a;
import com.google.ads.interactivemedia.v3.a.d.b;
import com.google.ads.interactivemedia.v3.a.i;
import com.google.ads.interactivemedia.v3.a.n;
import com.google.ads.interactivemedia.v3.a.o;
import com.google.ads.interactivemedia.v3.a.q;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: IMASDK */
public final class d extends a {
    private static final Reader a = new Reader() {
        public final int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        public final void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object b = new Object();
    private final List<Object> c;

    public final void a() throws IOException {
        a(b.BEGIN_ARRAY);
        this.c.add(((i) q()).iterator());
    }

    public final void b() throws IOException {
        a(b.END_ARRAY);
        r();
        r();
    }

    public final void c() throws IOException {
        a(b.BEGIN_OBJECT);
        this.c.add(((o) q()).n().iterator());
    }

    public final void d() throws IOException {
        a(b.END_OBJECT);
        r();
        r();
    }

    public final boolean e() throws IOException {
        b f = f();
        return (f == b.END_OBJECT || f == b.END_ARRAY) ? false : true;
    }

    public final b f() throws IOException {
        while (!this.c.isEmpty()) {
            Object q = q();
            if (q instanceof Iterator) {
                boolean z = this.c.get(this.c.size() - 2) instanceof o;
                Iterator it = (Iterator) q;
                if (!it.hasNext()) {
                    return z ? b.END_OBJECT : b.END_ARRAY;
                } else {
                    if (z) {
                        return b.NAME;
                    }
                    this.c.add(it.next());
                }
            } else if (q instanceof o) {
                return b.BEGIN_OBJECT;
            } else {
                if (q instanceof i) {
                    return b.BEGIN_ARRAY;
                }
                if (q instanceof q) {
                    q qVar = (q) q;
                    if (qVar.p()) {
                        return b.STRING;
                    }
                    if (qVar.n()) {
                        return b.BOOLEAN;
                    }
                    if (qVar.o()) {
                        return b.NUMBER;
                    }
                    throw new AssertionError();
                } else if (q instanceof n) {
                    return b.NULL;
                } else {
                    if (q == b) {
                        throw new IllegalStateException("JsonReader is closed");
                    }
                    throw new AssertionError();
                }
            }
        }
        return b.END_DOCUMENT;
    }

    private Object q() {
        return this.c.get(this.c.size() - 1);
    }

    private Object r() {
        return this.c.remove(this.c.size() - 1);
    }

    private void a(b bVar) throws IOException {
        if (f() != bVar) {
            throw new IllegalStateException("Expected " + bVar + " but was " + f());
        }
    }

    public final String g() throws IOException {
        a(b.NAME);
        Entry entry = (Entry) ((Iterator) q()).next();
        this.c.add(entry.getValue());
        return (String) entry.getKey();
    }

    public final String h() throws IOException {
        b f = f();
        if (f == b.STRING || f == b.NUMBER) {
            return ((q) r()).b();
        }
        throw new IllegalStateException("Expected " + b.STRING + " but was " + f);
    }

    public final boolean i() throws IOException {
        a(b.BOOLEAN);
        return ((q) r()).f();
    }

    public final void j() throws IOException {
        a(b.NULL);
        r();
    }

    public final double k() throws IOException {
        b f = f();
        if (f == b.NUMBER || f == b.STRING) {
            double c = ((q) q()).c();
            if (p() || !(Double.isNaN(c) || Double.isInfinite(c))) {
                r();
                return c;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: " + c);
        }
        throw new IllegalStateException("Expected " + b.NUMBER + " but was " + f);
    }

    public final long l() throws IOException {
        b f = f();
        if (f == b.NUMBER || f == b.STRING) {
            long d = ((q) q()).d();
            r();
            return d;
        }
        throw new IllegalStateException("Expected " + b.NUMBER + " but was " + f);
    }

    public final int m() throws IOException {
        b f = f();
        if (f == b.NUMBER || f == b.STRING) {
            int e = ((q) q()).e();
            r();
            return e;
        }
        throw new IllegalStateException("Expected " + b.NUMBER + " but was " + f);
    }

    public final void close() throws IOException {
        this.c.clear();
        this.c.add(b);
    }

    public final void n() throws IOException {
        if (f() == b.NAME) {
            g();
        } else {
            r();
        }
    }

    public final String toString() {
        return getClass().getSimpleName();
    }

    public final void o() throws IOException {
        a(b.NAME);
        Entry entry = (Entry) ((Iterator) q()).next();
        this.c.add(entry.getValue());
        this.c.add(new q((String) entry.getKey()));
    }
}
