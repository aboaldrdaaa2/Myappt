package lip.com.google.ads.interactivemedia.v3.a;

import com.google.ads.interactivemedia.v3.a.b.a.e;
import com.google.ads.interactivemedia.v3.a.d.a;
import com.google.ads.interactivemedia.v3.a.d.c;
import java.io.IOException;

/* compiled from: IMASDK */
public abstract class w<T> {
    public abstract T a(a aVar) throws IOException;

    public abstract void a(c cVar, T t) throws IOException;

    public final l a(T t) {
        try {
            c eVar = new e();
            a(eVar, t);
            return eVar.a();
        } catch (Throwable e) {
            throw new m(e);
        }
    }
}
