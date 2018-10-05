package lip.com.google.ads.interactivemedia.v3.a.b.a;

import com.google.ads.interactivemedia.v3.a.c.a;
import com.google.ads.interactivemedia.v3.a.d.b;
import com.google.ads.interactivemedia.v3.a.d.c;
import com.google.ads.interactivemedia.v3.a.f;
import com.google.ads.interactivemedia.v3.a.t;
import com.google.ads.interactivemedia.v3.a.w;
import com.google.ads.interactivemedia.v3.a.x;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/* compiled from: IMASDK */
public final class j extends w<Time> {
    public static final x a = new x() {
        public final <T> w<T> a(f fVar, a<T> aVar) {
            return aVar.a() == Time.class ? new j() : null;
        }
    };
    private final DateFormat b = new SimpleDateFormat("hh:mm:ss a");

    private synchronized Time b(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
        Time time;
        if (aVar.f() == b.NULL) {
            aVar.j();
            time = null;
        } else {
            try {
                time = new Time(this.b.parse(aVar.h()).getTime());
            } catch (Throwable e) {
                throw new t(e);
            }
        }
        return time;
    }

    private synchronized void a(c cVar, Time time) throws IOException {
        cVar.a(time == null ? null : this.b.format(time));
    }
}
