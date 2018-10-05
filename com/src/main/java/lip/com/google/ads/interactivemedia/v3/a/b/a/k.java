package lip.com.google.ads.interactivemedia.v3.a.b.a;

import com.google.ads.interactivemedia.v3.a.d.a;
import com.google.ads.interactivemedia.v3.a.d.c;
import com.google.ads.interactivemedia.v3.a.f;
import com.google.ads.interactivemedia.v3.a.w;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: IMASDK */
final class k<T> extends w<T> {
    private final f a;
    private final w<T> b;
    private final Type c;

    k(f fVar, w<T> wVar, Type type) {
        this.a = fVar;
        this.b = wVar;
        this.c = type;
    }

    public final T a(a aVar) throws IOException {
        return this.b.a(aVar);
    }

    public final void a(c cVar, T t) throws IOException {
        w a;
        w wVar = this.b;
        Type type = this.c;
        if (t != null && (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class))) {
            type = t.getClass();
        }
        if (type != this.c) {
            a = this.a.a(com.google.ads.interactivemedia.v3.a.c.a.a(type));
            if ((a instanceof h.a) && !(this.b instanceof h.a)) {
                a = this.b;
            }
        } else {
            a = wVar;
        }
        a.a(cVar, t);
    }
}
