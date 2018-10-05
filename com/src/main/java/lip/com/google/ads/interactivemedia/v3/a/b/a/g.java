package lip.com.google.ads.interactivemedia.v3.a.b.a;

import com.google.ads.interactivemedia.v3.a.c.a;
import com.google.ads.interactivemedia.v3.a.d.c;
import com.google.ads.interactivemedia.v3.a.f;
import com.google.ads.interactivemedia.v3.a.w;
import com.google.ads.interactivemedia.v3.a.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IMASDK */
public final class g extends w<Object> {
    public static final x a = new x() {
        public final <T> w<T> a(f fVar, a<T> aVar) {
            if (aVar.a() == Object.class) {
                return new g(fVar, (byte) 0);
            }
            return null;
        }
    };
    private final f b;

    /* synthetic */ g(f fVar, byte b) {
        this(fVar);
    }

    private g(f fVar) {
        this.b = fVar;
    }

    public final Object a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
        switch (aVar.f()) {
            case BEGIN_ARRAY:
                List arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList.add(a(aVar));
                }
                aVar.b();
                return arrayList;
            case BEGIN_OBJECT:
                Object gVar = new com.google.ads.interactivemedia.v3.a.b.g();
                aVar.c();
                while (aVar.e()) {
                    gVar.put(aVar.g(), a(aVar));
                }
                aVar.d();
                return gVar;
            case STRING:
                return aVar.h();
            case NUMBER:
                return Double.valueOf(aVar.k());
            case BOOLEAN:
                return Boolean.valueOf(aVar.i());
            case NULL:
                aVar.j();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    public final void a(c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.f();
            return;
        }
        w a = this.b.a(obj.getClass());
        if (a instanceof g) {
            cVar.d();
            cVar.e();
            return;
        }
        a.a(cVar, obj);
    }
}
