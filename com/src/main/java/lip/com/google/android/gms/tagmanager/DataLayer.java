package lip.com.google.android.gms.tagmanager;

import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLayer {
    public static final String EVENT_KEY = "event";
    public static final Object OBJECT_NOT_PRESENT = new Object();
    static final String[] aeY = "gtm.lifetime".toString().split("\\.");
    private static final Pattern aeZ = Pattern.compile("(\\d+)\\s*([smhd]?)");
    private final ConcurrentHashMap<b, Integer> afa;
    private final Map<String, Object> afb;
    private final ReentrantLock afc;
    private final LinkedList<Map<String, Object>> afd;
    private final c afe;
    private final CountDownLatch aff;

    static final class a {
        public final String JL;
        public final Object afh;

        a(String str, Object obj) {
            this.JL = str;
            this.afh = obj;
        }

        public boolean equals(Object o) {
            if (!(o instanceof a)) {
                return false;
            }
            a aVar = (a) o;
            return this.JL.equals(aVar.JL) && this.afh.equals(aVar.afh);
        }

        public int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.JL.hashCode()), Integer.valueOf(this.afh.hashCode())});
        }

        public String toString() {
            return "Key: " + this.JL + " value: " + this.afh.toString();
        }
    }

    interface b {
        void x(Map<String, Object> map);
    }

    interface c {

        public interface a {
            void d(List<a> list);
        }

        void a(a aVar);

        void a(List<a> list, long j);

        void bP(String str);
    }

    DataLayer() {
        this(new c() {
            public void a(a aVar) {
                aVar.d(new ArrayList());
            }

            public void a(List<a> list, long j) {
            }

            public void bP(String str) {
            }
        });
    }

    DataLayer(c persistentStore) {
        this.afe = persistentStore;
        this.afa = new ConcurrentHashMap();
        this.afb = new HashMap();
        this.afc = new ReentrantLock();
        this.afd = new LinkedList();
        this.aff = new CountDownLatch(1);
        ly();
    }

    private void A(Map<String, Object> map) {
        Long B = B(map);
        if (B != null) {
            List D = D(map);
            D.remove("gtm.lifetime");
            this.afe.a(D, B.longValue());
        }
    }

    private Long B(Map<String, Object> map) {
        Object C = C(map);
        return C == null ? null : bO(C.toString());
    }

    private Object C(Map<String, Object> map) {
        String[] strArr = aeY;
        int length = strArr.length;
        int i = 0;
        Object obj = map;
        while (i < length) {
            Object obj2 = strArr[i];
            if (!(obj instanceof Map)) {
                return null;
            }
            i++;
            obj = ((Map) obj).get(obj2);
        }
        return obj;
    }

    private List<a> D(Map<String, Object> map) {
        Object arrayList = new ArrayList();
        a(map, "", arrayList);
        return arrayList;
    }

    private void E(Map<String, Object> map) {
        synchronized (this.afb) {
            for (String str : map.keySet()) {
                a(c(str, map.get(str)), this.afb);
            }
        }
        F(map);
    }

    private void F(Map<String, Object> map) {
        for (b x : this.afa.keySet()) {
            x.x(map);
        }
    }

    private void a(Map<String, Object> map, String str, Collection<a> collection) {
        for (Entry entry : map.entrySet()) {
            String str2 = str + (str.length() == 0 ? "" : ".") + ((String) entry.getKey());
            if (entry.getValue() instanceof Map) {
                a((Map) entry.getValue(), str2, collection);
            } else if (!str2.equals("gtm.lifetime")) {
                collection.add(new a(str2, entry.getValue()));
            }
        }
    }

    static Long bO(String str) {
        Matcher matcher = aeZ.matcher(str);
        if (matcher.matches()) {
            long parseLong;
            try {
                parseLong = Long.parseLong(matcher.group(1));
            } catch (NumberFormatException e) {
                bh.D("illegal number in _lifetime value: " + str);
                parseLong = 0;
            }
            if (parseLong <= 0) {
                bh.B("non-positive _lifetime: " + str);
                return null;
            }
            String group = matcher.group(2);
            if (group.length() == 0) {
                return Long.valueOf(parseLong);
            }
            switch (group.charAt(0)) {
                case 'd':
                    return Long.valueOf((((parseLong * 1000) * 60) * 60) * 24);
                case LocationRequest.PRIORITY_LOW_POWER /*104*/:
                    return Long.valueOf(((parseLong * 1000) * 60) * 60);
                case 'm':
                    return Long.valueOf((parseLong * 1000) * 60);
                case 's':
                    return Long.valueOf(parseLong * 1000);
                default:
                    bh.D("unknown units in _lifetime: " + str);
                    return null;
            }
        }
        bh.B("unknown _lifetime: " + str);
        return null;
    }

    public static List<Object> listOf(Object... objects) {
        List<Object> arrayList = new ArrayList();
        for (Object add : objects) {
            arrayList.add(add);
        }
        return arrayList;
    }

    private void ly() {
        this.afe.a(new a() {
            public void d(List<a> list) {
                for (a aVar : list) {
                    DataLayer.this.z(DataLayer.this.c(aVar.JL, aVar.afh));
                }
                DataLayer.this.aff.countDown();
            }
        });
    }

    private void lz() {
        int i = 0;
        while (true) {
            int i2 = i;
            Map map = (Map) this.afd.poll();
            if (map != null) {
                E(map);
                i = i2 + 1;
                if (i > 500) {
                    this.afd.clear();
                    throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
                }
            } else {
                return;
            }
        }
    }

    public static Map<String, Object> mapOf(Object... objects) {
        if (objects.length % 2 != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        Map<String, Object> hashMap = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objects.length) {
                return hashMap;
            }
            if (objects[i2] instanceof String) {
                hashMap.put((String) objects[i2], objects[i2 + 1]);
                i = i2 + 2;
            } else {
                throw new IllegalArgumentException("key is not a string: " + objects[i2]);
            }
        }
    }

    private void z(Map<String, Object> map) {
        this.afc.lock();
        try {
            this.afd.offer(map);
            if (this.afc.getHoldCount() == 1) {
                lz();
            }
            A(map);
        } finally {
            this.afc.unlock();
        }
    }

    void a(b bVar) {
        this.afa.put(bVar, Integer.valueOf(0));
    }

    void a(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                Object obj = list.get(i2);
                if (obj instanceof List) {
                    if (!(list2.get(i2) instanceof List)) {
                        list2.set(i2, new ArrayList());
                    }
                    a((List) obj, (List) list2.get(i2));
                } else if (obj instanceof Map) {
                    if (!(list2.get(i2) instanceof Map)) {
                        list2.set(i2, new HashMap());
                    }
                    a((Map) obj, (Map) list2.get(i2));
                } else if (obj != OBJECT_NOT_PRESENT) {
                    list2.set(i2, obj);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    void a(Map<String, Object> map, Map<String, Object> map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                a((List) obj, (List) map2.get(str));
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                a((Map) obj, (Map) map2.get(str));
            } else {
                map2.put(str, obj);
            }
        }
    }

    void bN(String str) {
        push(str, null);
        this.afe.bP(str);
    }

    Map<String, Object> c(String str, Object obj) {
        Map hashMap = new HashMap();
        String[] split = str.toString().split("\\.");
        int i = 0;
        Map map = hashMap;
        while (i < split.length - 1) {
            HashMap hashMap2 = new HashMap();
            map.put(split[i], hashMap2);
            i++;
            Object map2 = hashMap2;
        }
        map2.put(split[split.length - 1], obj);
        return hashMap;
    }

    public Object get(String key) {
        synchronized (this.afb) {
            Map map = this.afb;
            String[] split = key.split("\\.");
            int length = split.length;
            Object obj = map;
            int i = 0;
            while (i < length) {
                Object obj2 = split[i];
                if (obj instanceof Map) {
                    obj2 = ((Map) obj).get(obj2);
                    if (obj2 == null) {
                        return null;
                    }
                    i++;
                    obj = obj2;
                } else {
                    return null;
                }
            }
            return obj;
        }
    }

    public void push(String key, Object value) {
        push(c(key, value));
    }

    public void push(Map<String, Object> update) {
        try {
            this.aff.await();
        } catch (InterruptedException e) {
            bh.D("DataLayer.push: unexpected InterruptedException");
        }
        z(update);
    }

    public void pushEvent(String eventName, Map<String, Object> update) {
        Map hashMap = new HashMap(update);
        hashMap.put(EVENT_KEY, eventName);
        push(hashMap);
    }
}
