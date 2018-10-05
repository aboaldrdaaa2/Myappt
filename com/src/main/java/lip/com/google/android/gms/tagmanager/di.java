package lip.com.google.android.gms.tagmanager;

import android.content.Context;
import com.facebook.AppEventsConstants;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class di extends df {
    private static final String ID = a.UNIVERSAL_ANALYTICS.toString();
    private static final String aiA = b.TRANSACTION_DATALAYER_MAP.toString();
    private static final String aiB = b.TRANSACTION_ITEM_DATALAYER_MAP.toString();
    private static Map<String, String> aiC;
    private static Map<String, String> aiD;
    private static final String aiw = b.ACCOUNT.toString();
    private static final String aix = b.ANALYTICS_PASS_THROUGH.toString();
    private static final String aiy = b.ANALYTICS_FIELDS.toString();
    private static final String aiz = b.TRACK_TRANSACTION.toString();
    private final DataLayer aeu;
    private final Set<String> aiE;
    private final de aiF;

    public di(Context context, DataLayer dataLayer) {
        this(context, dataLayer, new de(context));
    }

    di(Context context, DataLayer dataLayer, de deVar) {
        super(ID, new String[0]);
        this.aeu = dataLayer;
        this.aiF = deVar;
        this.aiE = new HashSet();
        this.aiE.add("");
        this.aiE.add(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.aiE.add("false");
    }

    private Map<String, String> G(Map<String, d.a> map) {
        d.a aVar = (d.a) map.get(aiA);
        if (aVar != null) {
            return c(aVar);
        }
        if (aiC == null) {
            Map hashMap = new HashMap();
            hashMap.put("transactionId", "&ti");
            hashMap.put("transactionAffiliation", "&ta");
            hashMap.put("transactionTax", "&tt");
            hashMap.put("transactionShipping", "&ts");
            hashMap.put("transactionTotal", "&tr");
            hashMap.put("transactionCurrency", "&cu");
            aiC = hashMap;
        }
        return aiC;
    }

    private Map<String, String> H(Map<String, d.a> map) {
        d.a aVar = (d.a) map.get(aiB);
        if (aVar != null) {
            return c(aVar);
        }
        if (aiD == null) {
            Map hashMap = new HashMap();
            hashMap.put("name", "&in");
            hashMap.put("sku", "&ic");
            hashMap.put("category", "&iv");
            hashMap.put("price", "&ip");
            hashMap.put("quantity", "&iq");
            hashMap.put("currency", "&cu");
            aiD = hashMap;
        }
        return aiD;
    }

    private void a(Tracker tracker, Map<String, d.a> map) {
        String cu = cu("transactionId");
        if (cu == null) {
            bh.A("Cannot find transactionId in data layer.");
            return;
        }
        List<Map> linkedList = new LinkedList();
        try {
            Map p = p((d.a) map.get(aiy));
            p.put("&t", "transaction");
            for (Entry entry : G(map).entrySet()) {
                b(p, (String) entry.getValue(), cu((String) entry.getKey()));
            }
            linkedList.add(p);
            List<Map> ne = ne();
            if (ne != null) {
                for (Map map2 : ne) {
                    if (map2.get("name") == null) {
                        bh.A("Unable to send transaction item hit due to missing 'name' field.");
                        return;
                    }
                    Map p2 = p((d.a) map.get(aiy));
                    p2.put("&t", "item");
                    p2.put("&ti", cu);
                    for (Entry entry2 : H(map).entrySet()) {
                        b(p2, (String) entry2.getValue(), (String) map2.get(entry2.getKey()));
                    }
                    linkedList.add(p2);
                }
            }
            for (Map map22 : linkedList) {
                tracker.send(map22);
            }
        } catch (Throwable e) {
            bh.b("Unable to send transaction", e);
        }
    }

    private void b(Map<String, String> map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    private Map<String, String> c(d.a aVar) {
        Object o = dh.o(aVar);
        if (!(o instanceof Map)) {
            return null;
        }
        Map map = (Map) o;
        Map<String, String> linkedHashMap = new LinkedHashMap();
        for (Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    private String cu(String str) {
        Object obj = this.aeu.get(str);
        return obj == null ? null : obj.toString();
    }

    private boolean e(Map<String, d.a> map, String str) {
        d.a aVar = (d.a) map.get(str);
        return aVar == null ? false : dh.n(aVar).booleanValue();
    }

    private List<Map<String, String>> ne() {
        Object obj = this.aeu.get("transactionProducts");
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                if (!(obj2 instanceof Map)) {
                    throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
                }
            }
            return (List) obj;
        }
        throw new IllegalArgumentException("transactionProducts should be of type List.");
    }

    private Map<String, String> p(d.a aVar) {
        if (aVar == null) {
            return new HashMap();
        }
        Map<String, String> c = c(aVar);
        if (c == null) {
            return new HashMap();
        }
        String str = (String) c.get("&aip");
        if (str != null && this.aiE.contains(str.toLowerCase())) {
            c.remove("&aip");
        }
        return c;
    }

    public void y(Map<String, d.a> map) {
        Tracker cm = this.aiF.cm("_GTM_DEFAULT_TRACKER_");
        if (e(map, aix)) {
            cm.send(p((d.a) map.get(aiy)));
        } else if (e(map, aiz)) {
            a(cm, map);
        } else {
            bh.D("Ignoring unknown tag.");
        }
    }
}
