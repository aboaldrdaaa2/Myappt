package lip.com.google.ads.interactivemedia.v3.a.b.a;

import com.google.ads.interactivemedia.v3.a.c.a;
import com.google.ads.interactivemedia.v3.a.d.b;
import com.google.ads.interactivemedia.v3.a.d.c;
import com.google.ads.interactivemedia.v3.a.f;
import com.google.ads.interactivemedia.v3.a.t;
import com.google.ads.interactivemedia.v3.a.w;
import com.google.ads.interactivemedia.v3.a.x;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/* compiled from: IMASDK */
public final class i extends w<Date> {
    public static final x a = new x() {
        public final <T> w<T> a(f fVar, a<T> aVar) {
            return aVar.a() == Date.class ? new i() : null;
        }
    };
    private final DateFormat b = new SimpleDateFormat("MMM d, yyyy");

    private synchronized Date b(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
        Date date;
        if (aVar.f() == b.NULL) {
            aVar.j();
            date = null;
        } else {
            try {
                date = new Date(this.b.parse(aVar.h()).getTime());
            } catch (Throwable e) {
                throw new t(e);
            }
        }
        return date;
    }

    private synchronized void a(c cVar, Date date) throws IOException {
        cVar.a(date == null ? null : this.b.format(date));
    }
}
