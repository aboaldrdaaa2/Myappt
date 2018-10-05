package lip.com.google.ads.interactivemedia.v3.a;

import com.google.ads.interactivemedia.v3.a.b.a;
import com.google.ads.interactivemedia.v3.a.b.a.l;
import com.google.ads.interactivemedia.v3.a.b.d;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
public final class g {
    private d a = d.a;
    private u b = u.a;
    private e c = d.a;
    private final Map<Type, h<?>> d = new HashMap();
    private final List<x> e = new ArrayList();
    private final List<x> f = new ArrayList();
    private boolean g;
    private String h;
    private int i = 2;
    private int j = 2;
    private boolean k;
    private boolean l;
    private boolean m = true;
    private boolean n;
    private boolean o;

    public final g a(Type type, Object obj) {
        boolean z = true;
        boolean z2 = (obj instanceof s) || (obj instanceof k) || (obj instanceof h) || (obj instanceof w);
        a.a(z2);
        if (obj instanceof h) {
            this.d.put(type, (h) obj);
        }
        if ((obj instanceof s) || (obj instanceof k)) {
            com.google.ads.interactivemedia.v3.a.c.a a = com.google.ads.interactivemedia.v3.a.c.a.a(type);
            List list = this.e;
            if (a.b() != a.a()) {
                z = false;
            }
            list.add(new a(obj, a, z, (byte) 0));
        }
        if (obj instanceof w) {
            this.e.add(l.a(com.google.ads.interactivemedia.v3.a.c.a.a(type), (w) obj));
        }
        return this;
    }

    public final f a() {
        Object aVar;
        List arrayList = new ArrayList();
        arrayList.addAll(this.e);
        Collections.reverse(arrayList);
        arrayList.addAll(this.f);
        String str = this.h;
        int i = this.i;
        int i2 = this.j;
        if (str == null || "".equals(str.trim())) {
            if (!(i == 2 || i2 == 2)) {
                aVar = new a(i, i2);
            }
            return new f(this.a, this.c, this.d, this.g, this.k, this.o, this.m, this.n, this.l, this.b, arrayList);
        }
        aVar = new a(str);
        arrayList.add(v.a(com.google.ads.interactivemedia.v3.a.c.a.a(Date.class), aVar));
        arrayList.add(v.a(com.google.ads.interactivemedia.v3.a.c.a.a(Timestamp.class), aVar));
        arrayList.add(v.a(com.google.ads.interactivemedia.v3.a.c.a.a(java.sql.Date.class), aVar));
        return new f(this.a, this.c, this.d, this.g, this.k, this.o, this.m, this.n, this.l, this.b, arrayList);
    }
}
