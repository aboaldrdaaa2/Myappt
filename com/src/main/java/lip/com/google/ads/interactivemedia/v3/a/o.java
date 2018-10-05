package lip.com.google.ads.interactivemedia.v3.a;

import com.google.ads.interactivemedia.v3.a.b.g;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: IMASDK */
public final class o extends l {
    private final g<String, l> a = new g();

    public final void a(String str, l lVar) {
        Object lVar2;
        if (lVar2 == null) {
            lVar2 = n.a;
        }
        this.a.put(str, lVar2);
    }

    public final Set<Entry<String, l>> n() {
        return this.a.entrySet();
    }

    public final boolean equals(Object o) {
        return o == this || ((o instanceof o) && ((o) o).a.equals(this.a));
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
