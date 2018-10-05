package lip.com.google.android.gms.tagmanager;

import com.facebook.internal.ServerProtocol;
import com.google.android.gms.internal.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class dh {
    private static final Object ain = null;
    private static Long aio = new Long(0);
    private static Double aip = new Double(0.0d);
    private static dg aiq = dg.z(0);
    private static String air = new String("");
    private static Boolean ais = new Boolean(false);
    private static List<Object> ait = new ArrayList(0);
    private static Map<Object, Object> aiu = new HashMap();
    private static a aiv = r(air);

    public static a cp(String str) {
        a aVar = new a();
        aVar.type = 5;
        aVar.fS = str;
        return aVar;
    }

    private static dg cq(String str) {
        try {
            return dg.co(str);
        } catch (NumberFormatException e) {
            bh.A("Failed to convert '" + str + "' to a number.");
            return aiq;
        }
    }

    private static Long cr(String str) {
        dg cq = cq(str);
        return cq == aiq ? aio : Long.valueOf(cq.longValue());
    }

    private static Double cs(String str) {
        dg cq = cq(str);
        return cq == aiq ? aip : Double.valueOf(cq.doubleValue());
    }

    private static Boolean ct(String str) {
        return ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : ais;
    }

    private static double getDouble(Object o) {
        if (o instanceof Number) {
            return ((Number) o).doubleValue();
        }
        bh.A("getDouble received non-Number");
        return 0.0d;
    }

    public static String j(a aVar) {
        return m(o(aVar));
    }

    public static dg k(a aVar) {
        return n(o(aVar));
    }

    public static Long l(a aVar) {
        return o(o(aVar));
    }

    public static Double m(a aVar) {
        return p(o(aVar));
    }

    public static String m(Object obj) {
        return obj == null ? air : obj.toString();
    }

    public static Object mX() {
        return ain;
    }

    public static Long mY() {
        return aio;
    }

    public static Double mZ() {
        return aip;
    }

    public static dg n(Object obj) {
        return obj instanceof dg ? (dg) obj : t(obj) ? dg.z(u(obj)) : s(obj) ? dg.a(Double.valueOf(getDouble(obj))) : cq(m(obj));
    }

    public static Boolean n(a aVar) {
        return q(o(aVar));
    }

    public static Boolean na() {
        return ais;
    }

    public static dg nb() {
        return aiq;
    }

    public static String nc() {
        return air;
    }

    public static a nd() {
        return aiv;
    }

    public static Long o(Object obj) {
        return t(obj) ? Long.valueOf(u(obj)) : cr(m(obj));
    }

    public static Object o(a aVar) {
        int i = 0;
        if (aVar == null) {
            return ain;
        }
        a[] aVarArr;
        int length;
        switch (aVar.type) {
            case 1:
                return aVar.fN;
            case 2:
                ArrayList arrayList = new ArrayList(aVar.fO.length);
                aVarArr = aVar.fO;
                length = aVarArr.length;
                while (i < length) {
                    Object o = o(aVarArr[i]);
                    if (o == ain) {
                        return ain;
                    }
                    arrayList.add(o);
                    i++;
                }
                return arrayList;
            case 3:
                if (aVar.fP.length != aVar.fQ.length) {
                    bh.A("Converting an invalid value to object: " + aVar.toString());
                    return ain;
                }
                Map hashMap = new HashMap(aVar.fQ.length);
                while (i < aVar.fP.length) {
                    Object o2 = o(aVar.fP[i]);
                    Object o3 = o(aVar.fQ[i]);
                    if (o2 == ain || o3 == ain) {
                        return ain;
                    }
                    hashMap.put(o2, o3);
                    i++;
                }
                return hashMap;
            case 4:
                bh.A("Trying to convert a macro reference to object");
                return ain;
            case 5:
                bh.A("Trying to convert a function id to object");
                return ain;
            case 6:
                return Long.valueOf(aVar.fT);
            case 7:
                StringBuffer stringBuffer = new StringBuffer();
                aVarArr = aVar.fV;
                length = aVarArr.length;
                while (i < length) {
                    String j = j(aVarArr[i]);
                    if (j == air) {
                        return ain;
                    }
                    stringBuffer.append(j);
                    i++;
                }
                return stringBuffer.toString();
            case 8:
                return Boolean.valueOf(aVar.fU);
            default:
                bh.A("Failed to convert a value of type: " + aVar.type);
                return ain;
        }
    }

    public static Double p(Object obj) {
        return s(obj) ? Double.valueOf(getDouble(obj)) : cs(m(obj));
    }

    public static Boolean q(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : ct(m(obj));
    }

    public static a r(Object obj) {
        boolean z = false;
        a aVar = new a();
        if (obj instanceof a) {
            return (a) obj;
        }
        List arrayList;
        boolean z2;
        boolean z3;
        if (obj instanceof String) {
            aVar.type = 1;
            aVar.fN = (String) obj;
        } else if (obj instanceof List) {
            aVar.type = 2;
            List<Object> list = (List) obj;
            arrayList = new ArrayList(list.size());
            z2 = false;
            for (Object r : list) {
                a r2 = r(r);
                if (r2 == aiv) {
                    return aiv;
                }
                z3 = z2 || r2.fX;
                arrayList.add(r2);
                z2 = z3;
            }
            aVar.fO = (a[]) arrayList.toArray(new a[0]);
            z = z2;
        } else if (obj instanceof Map) {
            aVar.type = 3;
            Set<Entry> entrySet = ((Map) obj).entrySet();
            arrayList = new ArrayList(entrySet.size());
            List arrayList2 = new ArrayList(entrySet.size());
            z2 = false;
            for (Entry entry : entrySet) {
                a r3 = r(entry.getKey());
                a r4 = r(entry.getValue());
                if (r3 == aiv || r4 == aiv) {
                    return aiv;
                }
                z3 = z2 || r3.fX || r4.fX;
                arrayList.add(r3);
                arrayList2.add(r4);
                z2 = z3;
            }
            aVar.fP = (a[]) arrayList.toArray(new a[0]);
            aVar.fQ = (a[]) arrayList2.toArray(new a[0]);
            z = z2;
        } else if (s(obj)) {
            aVar.type = 1;
            aVar.fN = obj.toString();
        } else if (t(obj)) {
            aVar.type = 6;
            aVar.fT = u(obj);
        } else if (obj instanceof Boolean) {
            aVar.type = 8;
            aVar.fU = ((Boolean) obj).booleanValue();
        } else {
            bh.A("Converting to Value from unknown object type: " + (obj == null ? "null" : obj.getClass().toString()));
            return aiv;
        }
        aVar.fX = z;
        return aVar;
    }

    private static boolean s(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof dg) && ((dg) obj).mS());
    }

    private static boolean t(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof dg) && ((dg) obj).mT());
    }

    private static long u(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        bh.A("getInt64 received non-Number");
        return 0;
    }
}
