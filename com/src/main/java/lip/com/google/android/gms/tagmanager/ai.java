package lip.com.google.android.gms.tagmanager;

import com.google.android.gms.internal.c.c;
import com.google.android.gms.internal.c.d;
import com.google.android.gms.internal.c.i;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class ai {
    private static void a(DataLayer dataLayer, d dVar) {
        for (a j : dVar.eS) {
            dataLayer.bN(dh.j(j));
        }
    }

    public static void a(DataLayer dataLayer, i iVar) {
        if (iVar.fI == null) {
            bh.D("supplemental missing experimentSupplemental");
            return;
        }
        a(dataLayer, iVar.fI);
        b(dataLayer, iVar.fI);
        c(dataLayer, iVar.fI);
    }

    private static void b(DataLayer dataLayer, d dVar) {
        for (a c : dVar.eR) {
            Map c2 = c(c);
            if (c2 != null) {
                dataLayer.push(c2);
            }
        }
    }

    private static Map<String, Object> c(a aVar) {
        Object o = dh.o(aVar);
        if (o instanceof Map) {
            return (Map) o;
        }
        bh.D("value: " + o + " is not a map value, ignored.");
        return null;
    }

    private static void c(DataLayer dataLayer, d dVar) {
        for (c cVar : dVar.eT) {
            if (cVar.eM == null) {
                bh.D("GaExperimentRandom: No key");
            } else {
                Object obj = dataLayer.get(cVar.eM);
                Long valueOf = !(obj instanceof Number) ? null : Long.valueOf(((Number) obj).longValue());
                long j = cVar.eN;
                long j2 = cVar.eO;
                if (!cVar.eP || valueOf == null || valueOf.longValue() < j || valueOf.longValue() > j2) {
                    if (j <= j2) {
                        obj = Long.valueOf(Math.round((Math.random() * ((double) (j2 - j))) + ((double) j)));
                    } else {
                        bh.D("GaExperimentRandom: random range invalid");
                    }
                }
                dataLayer.bN(cVar.eM);
                Map c = dataLayer.c(cVar.eM, obj);
                if (cVar.eQ > 0) {
                    if (c.containsKey("gtm")) {
                        Object obj2 = c.get("gtm");
                        if (obj2 instanceof Map) {
                            ((Map) obj2).put("lifetime", Long.valueOf(cVar.eQ));
                        } else {
                            bh.D("GaExperimentRandom: gtm not a map");
                        }
                    } else {
                        c.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(cVar.eQ)));
                    }
                }
                dataLayer.push(c);
            }
        }
    }
}
