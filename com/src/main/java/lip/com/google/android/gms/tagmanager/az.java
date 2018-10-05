package lip.com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class az extends aj {
    private static final String ID = com.google.android.gms.internal.a.JOINER.toString();
    private static final String afU = b.ITEM_SEPARATOR.toString();
    private static final String afV = b.KEY_VALUE_SEPARATOR.toString();
    private static final String afW = b.ESCAPE.toString();
    private static final String afy = b.ARG0.toString();

    private enum a {
        NONE,
        URL,
        BACKSLASH
    }

    public az() {
        super(ID, afy);
    }

    private String a(String str, a aVar, Set<Character> set) {
        switch (aVar) {
            case URL:
                try {
                    return dk.cv(str);
                } catch (Throwable e) {
                    bh.b("Joiner: unsupported encoding", e);
                    return str;
                }
            case BACKSLASH:
                String replace = str.replace("\\", "\\\\");
                Iterator it = set.iterator();
                while (true) {
                    String str2 = replace;
                    if (!it.hasNext()) {
                        return str2;
                    }
                    CharSequence ch = ((Character) it.next()).toString();
                    replace = str2.replace(ch, "\\" + ch);
                }
            default:
                return str;
        }
    }

    private void a(StringBuilder stringBuilder, String str, a aVar, Set<Character> set) {
        stringBuilder.append(a(str, aVar, set));
    }

    private void a(Set<Character> set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    public boolean lh() {
        return true;
    }

    public com.google.android.gms.internal.d.a w(Map<String, com.google.android.gms.internal.d.a> map) {
        com.google.android.gms.internal.d.a aVar = (com.google.android.gms.internal.d.a) map.get(afy);
        if (aVar == null) {
            return dh.nd();
        }
        a aVar2;
        Set set;
        com.google.android.gms.internal.d.a aVar3 = (com.google.android.gms.internal.d.a) map.get(afU);
        String j = aVar3 != null ? dh.j(aVar3) : "";
        aVar3 = (com.google.android.gms.internal.d.a) map.get(afV);
        String j2 = aVar3 != null ? dh.j(aVar3) : "=";
        a aVar4 = a.NONE;
        aVar3 = (com.google.android.gms.internal.d.a) map.get(afW);
        if (aVar3 != null) {
            String j3 = dh.j(aVar3);
            if ("url".equals(j3)) {
                aVar2 = a.URL;
                set = null;
            } else if ("backslash".equals(j3)) {
                aVar2 = a.BACKSLASH;
                set = new HashSet();
                a(set, j);
                a(set, j2);
                set.remove(Character.valueOf('\\'));
            } else {
                bh.A("Joiner: unsupported escape type: " + j3);
                return dh.nd();
            }
        }
        set = null;
        aVar2 = aVar4;
        StringBuilder stringBuilder = new StringBuilder();
        switch (aVar.type) {
            case 2:
                Object obj = 1;
                com.google.android.gms.internal.d.a[] aVarArr = aVar.fO;
                int length = aVarArr.length;
                int i = 0;
                while (i < length) {
                    com.google.android.gms.internal.d.a aVar5 = aVarArr[i];
                    if (obj == null) {
                        stringBuilder.append(j);
                    }
                    a(stringBuilder, dh.j(aVar5), aVar2, set);
                    i++;
                    obj = null;
                }
                break;
            case 3:
                for (int i2 = 0; i2 < aVar.fP.length; i2++) {
                    if (i2 > 0) {
                        stringBuilder.append(j);
                    }
                    String j4 = dh.j(aVar.fP[i2]);
                    String j5 = dh.j(aVar.fQ[i2]);
                    a(stringBuilder, j4, aVar2, set);
                    stringBuilder.append(j2);
                    a(stringBuilder, j5, aVar2, set);
                }
                break;
            default:
                a(stringBuilder, dh.j(aVar), aVar2, set);
                break;
        }
        return dh.r(stringBuilder.toString());
    }
}
