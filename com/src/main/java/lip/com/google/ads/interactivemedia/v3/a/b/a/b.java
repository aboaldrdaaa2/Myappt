package lip.com.google.ads.interactivemedia.v3.a.b.a;

import com.google.ads.interactivemedia.v3.a.b.c;
import com.google.ads.interactivemedia.v3.a.b.h;
import com.google.ads.interactivemedia.v3.a.f;
import com.google.ads.interactivemedia.v3.a.w;
import com.google.ads.interactivemedia.v3.a.x;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

/* compiled from: IMASDK */
public final class b implements x {
    private final c a;

    /* compiled from: IMASDK */
    private static final class a<E> extends w<Collection<E>> {
        private final w<E> a;
        private final h<? extends Collection<E>> b;

        public final /* synthetic */ Object a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            if (aVar.f() == com.google.ads.interactivemedia.v3.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            Collection collection = (Collection) this.b.a();
            aVar.a();
            while (aVar.e()) {
                collection.add(this.a.a(aVar));
            }
            aVar.b();
            return collection;
        }

        public final /* synthetic */ void a(com.google.ads.interactivemedia.v3.a.d.c cVar, Object obj) throws IOException {
            Collection<Object> collection = (Collection) obj;
            if (collection == null) {
                cVar.f();
                return;
            }
            cVar.b();
            for (Object a : collection) {
                this.a.a(cVar, a);
            }
            cVar.c();
        }

        public a(f fVar, Type type, w<E> wVar, h<? extends Collection<E>> hVar) {
            this.a = new k(fVar, wVar, type);
            this.b = hVar;
        }
    }

    public b(c cVar) {
        this.a = cVar;
    }

    public final <T> w<T> a(f fVar, com.google.ads.interactivemedia.v3.a.c.a<T> aVar) {
        Type b = aVar.b();
        Class a = aVar.a();
        if (!Collection.class.isAssignableFrom(a)) {
            return null;
        }
        Type a2 = com.google.ads.interactivemedia.v3.a.b.b.a(b, a);
        return new a(fVar, a2, fVar.a(com.google.ads.interactivemedia.v3.a.c.a.a(a2)), this.a.a((com.google.ads.interactivemedia.v3.a.c.a) aVar));
    }
}
