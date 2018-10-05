package lip.com.google.ads.interactivemedia.v3.a;

import com.google.ads.interactivemedia.v3.a.b.j;
import com.google.ads.interactivemedia.v3.a.d.c;
import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: IMASDK */
final class v<T> extends w<T> {
    private final s<T> a;
    private final k<T> b;
    private final f c;
    private final com.google.ads.interactivemedia.v3.a.c.a<T> d;
    private final x e;
    private w<T> f;

    /* compiled from: IMASDK */
    private static class a implements x {
        private final com.google.ads.interactivemedia.v3.a.c.a<?> a;
        private final boolean b;
        private final Class<?> c;
        private final s<?> d;
        private final k<?> e;

        /* synthetic */ a(Object obj, com.google.ads.interactivemedia.v3.a.c.a aVar, boolean z, byte b) {
            this(obj, aVar, z);
        }

        private a(Object obj, com.google.ads.interactivemedia.v3.a.c.a<?> aVar, boolean z) {
            k kVar;
            this.d = obj instanceof s ? (s) obj : null;
            if (obj instanceof k) {
                kVar = (k) obj;
            } else {
                kVar = null;
            }
            this.e = kVar;
            boolean z2 = (this.d == null && this.e == null) ? false : true;
            com.google.ads.interactivemedia.v3.a.b.a.a(z2);
            this.a = aVar;
            this.b = z;
            this.c = null;
        }

        public final <T> w<T> a(f fVar, com.google.ads.interactivemedia.v3.a.c.a<T> aVar) {
            boolean isAssignableFrom = this.a != null ? this.a.equals(aVar) || (this.b && this.a.b() == aVar.a()) : this.c.isAssignableFrom(aVar.a());
            return isAssignableFrom ? new v(this.d, this.e, fVar, aVar, this, (byte) 0) : null;
        }
    }

    /* synthetic */ v(s sVar, k kVar, f fVar, com.google.ads.interactivemedia.v3.a.c.a aVar, x xVar, byte b) {
        this(sVar, kVar, fVar, aVar, xVar);
    }

    private v(s<T> sVar, k<T> kVar, f fVar, com.google.ads.interactivemedia.v3.a.c.a<T> aVar, x xVar) {
        this.a = sVar;
        this.b = kVar;
        this.c = fVar;
        this.d = aVar;
        this.e = xVar;
    }

    public final T a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
        if (this.b == null) {
            return a().a(aVar);
        }
        l a = j.a(aVar);
        if (a.j()) {
            return null;
        }
        try {
            k kVar = this.b;
            Type b = this.d.b();
            j jVar = this.c.a;
            return kVar.a(a, b);
        } catch (p e) {
            throw e;
        } catch (Throwable e2) {
            throw new p(e2);
        }
    }

    public final void a(c cVar, T t) throws IOException {
        if (this.a == null) {
            a().a(cVar, t);
        } else if (t == null) {
            cVar.f();
        } else {
            s sVar = this.a;
            this.d.b();
            r rVar = this.c.b;
            j.a(sVar.a(t), cVar);
        }
    }

    private w<T> a() {
        w<T> wVar = this.f;
        if (wVar != null) {
            return wVar;
        }
        wVar = this.c.a(this.e, this.d);
        this.f = wVar;
        return wVar;
    }

    public static x a(com.google.ads.interactivemedia.v3.a.c.a<?> aVar, Object obj) {
        return new a(obj, aVar, false, (byte) 0);
    }
}
