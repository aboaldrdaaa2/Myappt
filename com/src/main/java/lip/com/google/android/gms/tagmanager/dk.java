package lip.com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class dk {
    private static by<a> a(by<a> byVar) {
        try {
            return new by(dh.r(cv(dh.j((a) byVar.getObject()))), byVar.ma());
        } catch (Throwable e) {
            bh.b("Escape URI: unsupported encoding", e);
            return byVar;
        }
    }

    private static by<a> a(by<a> byVar, int i) {
        if (q((a) byVar.getObject())) {
            switch (i) {
                case 12:
                    return a(byVar);
                default:
                    bh.A("Unsupported Value Escaping: " + i);
                    return byVar;
            }
        }
        bh.A("Escaping can only be applied to strings.");
        return byVar;
    }

    static by<a> a(by<a> byVar, int... iArr) {
        by byVar2;
        for (int a : iArr) {
            byVar2 = a(byVar2, a);
        }
        return byVar2;
    }

    static String cv(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    private static boolean q(a aVar) {
        return dh.o(aVar) instanceof String;
    }
}
