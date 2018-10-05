package lip.com.google.ads.interactivemedia.v3.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: IMASDK */
public final class i extends l implements Iterable<l> {
    private final List<l> a = new ArrayList();

    public final void a(l lVar) {
        Object lVar2;
        if (lVar2 == null) {
            lVar2 = n.a;
        }
        this.a.add(lVar2);
    }

    public final Iterator<l> iterator() {
        return this.a.iterator();
    }

    public final Number a() {
        if (this.a.size() == 1) {
            return ((l) this.a.get(0)).a();
        }
        throw new IllegalStateException();
    }

    public final String b() {
        if (this.a.size() == 1) {
            return ((l) this.a.get(0)).b();
        }
        throw new IllegalStateException();
    }

    public final double c() {
        if (this.a.size() == 1) {
            return ((l) this.a.get(0)).c();
        }
        throw new IllegalStateException();
    }

    public final long d() {
        if (this.a.size() == 1) {
            return ((l) this.a.get(0)).d();
        }
        throw new IllegalStateException();
    }

    public final int e() {
        if (this.a.size() == 1) {
            return ((l) this.a.get(0)).e();
        }
        throw new IllegalStateException();
    }

    public final boolean f() {
        if (this.a.size() == 1) {
            return ((l) this.a.get(0)).f();
        }
        throw new IllegalStateException();
    }

    public final boolean equals(Object o) {
        return o == this || ((o instanceof i) && ((i) o).a.equals(this.a));
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
