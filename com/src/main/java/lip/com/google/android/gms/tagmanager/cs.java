package lip.com.google.android.gms.tagmanager;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.internal.c.i;
import com.google.android.gms.tagmanager.cq.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class cs {
    private static final by<com.google.android.gms.internal.d.a> ahm = new by(dh.nd(), true);
    private final DataLayer aeu;
    private final com.google.android.gms.tagmanager.cq.c ahn;
    private final ag aho;
    private final Map<String, aj> ahp;
    private final Map<String, aj> ahq;
    private final Map<String, aj> ahr;
    private final k<com.google.android.gms.tagmanager.cq.a, by<com.google.android.gms.internal.d.a>> ahs;
    private final k<String, b> aht;
    private final Set<e> ahu;
    private final Map<String, c> ahv;
    private volatile String ahw;
    private int ahx;

    interface a {
        void a(e eVar, Set<com.google.android.gms.tagmanager.cq.a> set, Set<com.google.android.gms.tagmanager.cq.a> set2, cm cmVar);
    }

    private static class b {
        private com.google.android.gms.internal.d.a agY;
        private by<com.google.android.gms.internal.d.a> ahD;

        public b(by<com.google.android.gms.internal.d.a> byVar, com.google.android.gms.internal.d.a aVar) {
            this.ahD = byVar;
            this.agY = aVar;
        }

        public int getSize() {
            return (this.agY == null ? 0 : this.agY.nZ()) + ((com.google.android.gms.internal.d.a) this.ahD.getObject()).nZ();
        }

        public by<com.google.android.gms.internal.d.a> mJ() {
            return this.ahD;
        }

        public com.google.android.gms.internal.d.a mp() {
            return this.agY;
        }
    }

    private static class c {
        private final Map<e, List<com.google.android.gms.tagmanager.cq.a>> ahE = new HashMap();
        private final Map<e, List<com.google.android.gms.tagmanager.cq.a>> ahF = new HashMap();
        private final Map<e, List<String>> ahG = new HashMap();
        private final Map<e, List<String>> ahH = new HashMap();
        private com.google.android.gms.tagmanager.cq.a ahI;
        private final Set<e> ahu = new HashSet();

        public void a(e eVar, com.google.android.gms.tagmanager.cq.a aVar) {
            List list = (List) this.ahE.get(eVar);
            if (list == null) {
                list = new ArrayList();
                this.ahE.put(eVar, list);
            }
            list.add(aVar);
        }

        public void a(e eVar, String str) {
            List list = (List) this.ahG.get(eVar);
            if (list == null) {
                list = new ArrayList();
                this.ahG.put(eVar, list);
            }
            list.add(str);
        }

        public void b(e eVar) {
            this.ahu.add(eVar);
        }

        public void b(e eVar, com.google.android.gms.tagmanager.cq.a aVar) {
            List list = (List) this.ahF.get(eVar);
            if (list == null) {
                list = new ArrayList();
                this.ahF.put(eVar, list);
            }
            list.add(aVar);
        }

        public void b(e eVar, String str) {
            List list = (List) this.ahH.get(eVar);
            if (list == null) {
                list = new ArrayList();
                this.ahH.put(eVar, list);
            }
            list.add(str);
        }

        public void i(com.google.android.gms.tagmanager.cq.a aVar) {
            this.ahI = aVar;
        }

        public Set<e> mK() {
            return this.ahu;
        }

        public Map<e, List<com.google.android.gms.tagmanager.cq.a>> mL() {
            return this.ahE;
        }

        public Map<e, List<String>> mM() {
            return this.ahG;
        }

        public Map<e, List<String>> mN() {
            return this.ahH;
        }

        public Map<e, List<com.google.android.gms.tagmanager.cq.a>> mO() {
            return this.ahF;
        }

        public com.google.android.gms.tagmanager.cq.a mP() {
            return this.ahI;
        }
    }

    public cs(Context context, com.google.android.gms.tagmanager.cq.c cVar, DataLayer dataLayer, com.google.android.gms.tagmanager.s.a aVar, com.google.android.gms.tagmanager.s.a aVar2, ag agVar) {
        if (cVar == null) {
            throw new NullPointerException("resource cannot be null");
        }
        com.google.android.gms.tagmanager.cq.a aVar3;
        this.ahn = cVar;
        this.ahu = new HashSet(cVar.ms());
        this.aeu = dataLayer;
        this.aho = agVar;
        this.ahs = new l().a(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new com.google.android.gms.tagmanager.l.a<com.google.android.gms.tagmanager.cq.a, by<com.google.android.gms.internal.d.a>>() {
            /* renamed from: a */
            public int sizeOf(com.google.android.gms.tagmanager.cq.a aVar, by<com.google.android.gms.internal.d.a> byVar) {
                return ((com.google.android.gms.internal.d.a) byVar.getObject()).nZ();
            }
        });
        this.aht = new l().a(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new com.google.android.gms.tagmanager.l.a<String, b>() {
            /* renamed from: a */
            public int sizeOf(String str, b bVar) {
                return str.length() + bVar.getSize();
            }
        });
        this.ahp = new HashMap();
        b(new i(context));
        b(new s(aVar2));
        b(new w(dataLayer));
        b(new di(context, dataLayer));
        this.ahq = new HashMap();
        c(new q());
        c(new ad());
        c(new ae());
        c(new al());
        c(new am());
        c(new bd());
        c(new be());
        c(new ch());
        c(new db());
        this.ahr = new HashMap();
        a(new b(context));
        a(new c(context));
        a(new e(context));
        a(new f(context));
        a(new g(context));
        a(new h(context));
        a(new m());
        a(new p(this.ahn.getVersion()));
        a(new s(aVar));
        a(new u(dataLayer));
        a(new z(context));
        a(new aa());
        a(new ac());
        a(new ah(this));
        a(new an());
        a(new ao());
        a(new ax(context));
        a(new az());
        a(new bc());
        a(new bk(context));
        a(new bz());
        a(new cb());
        a(new ce());
        a(new cg());
        a(new ci(context));
        a(new ct());
        a(new cu());
        a(new dd());
        this.ahv = new HashMap();
        for (e eVar : this.ahu) {
            String str;
            c d;
            if (agVar.lK()) {
                a(eVar.mA(), eVar.mB(), "add macro");
                a(eVar.mF(), eVar.mC(), "remove macro");
                a(eVar.my(), eVar.mD(), "add tag");
                a(eVar.mz(), eVar.mE(), "remove tag");
            }
            int i = 0;
            while (i < eVar.mA().size()) {
                aVar3 = (com.google.android.gms.tagmanager.cq.a) eVar.mA().get(i);
                str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                if (agVar.lK() && i < eVar.mB().size()) {
                    str = (String) eVar.mB().get(i);
                }
                d = d(this.ahv, h(aVar3));
                d.b(eVar);
                d.a(eVar, aVar3);
                d.a(eVar, str);
                i++;
            }
            i = 0;
            while (i < eVar.mF().size()) {
                aVar3 = (com.google.android.gms.tagmanager.cq.a) eVar.mF().get(i);
                str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                if (agVar.lK() && i < eVar.mC().size()) {
                    str = (String) eVar.mC().get(i);
                }
                d = d(this.ahv, h(aVar3));
                d.b(eVar);
                d.b(eVar, aVar3);
                d.b(eVar, str);
                i++;
            }
        }
        for (Entry entry : this.ahn.mt().entrySet()) {
            for (com.google.android.gms.tagmanager.cq.a aVar32 : (List) entry.getValue()) {
                if (!dh.n((com.google.android.gms.internal.d.a) aVar32.mo().get(com.google.android.gms.internal.b.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                    d(this.ahv, (String) entry.getKey()).i(aVar32);
                }
            }
        }
    }

    private by<com.google.android.gms.internal.d.a> a(com.google.android.gms.internal.d.a aVar, Set<String> set, dj djVar) {
        if (!aVar.fX) {
            return new by(aVar, true);
        }
        com.google.android.gms.internal.d.a g;
        int i;
        by a;
        switch (aVar.type) {
            case 2:
                g = cq.g(aVar);
                g.fO = new com.google.android.gms.internal.d.a[aVar.fO.length];
                for (i = 0; i < aVar.fO.length; i++) {
                    a = a(aVar.fO[i], (Set) set, djVar.dq(i));
                    if (a == ahm) {
                        return ahm;
                    }
                    g.fO[i] = (com.google.android.gms.internal.d.a) a.getObject();
                }
                return new by(g, false);
            case 3:
                g = cq.g(aVar);
                if (aVar.fP.length != aVar.fQ.length) {
                    bh.A("Invalid serving value: " + aVar.toString());
                    return ahm;
                }
                g.fP = new com.google.android.gms.internal.d.a[aVar.fP.length];
                g.fQ = new com.google.android.gms.internal.d.a[aVar.fP.length];
                for (i = 0; i < aVar.fP.length; i++) {
                    a = a(aVar.fP[i], (Set) set, djVar.dr(i));
                    by a2 = a(aVar.fQ[i], (Set) set, djVar.ds(i));
                    if (a == ahm || a2 == ahm) {
                        return ahm;
                    }
                    g.fP[i] = (com.google.android.gms.internal.d.a) a.getObject();
                    g.fQ[i] = (com.google.android.gms.internal.d.a) a2.getObject();
                }
                return new by(g, false);
            case 4:
                if (set.contains(aVar.fR)) {
                    bh.A("Macro cycle detected.  Current macro reference: " + aVar.fR + "." + "  Previous macro references: " + set.toString() + ".");
                    return ahm;
                }
                set.add(aVar.fR);
                by<com.google.android.gms.internal.d.a> a3 = dk.a(a(aVar.fR, (Set) set, djVar.lZ()), aVar.fW);
                set.remove(aVar.fR);
                return a3;
            case 7:
                g = cq.g(aVar);
                g.fV = new com.google.android.gms.internal.d.a[aVar.fV.length];
                for (i = 0; i < aVar.fV.length; i++) {
                    a = a(aVar.fV[i], (Set) set, djVar.dt(i));
                    if (a == ahm) {
                        return ahm;
                    }
                    g.fV[i] = (com.google.android.gms.internal.d.a) a.getObject();
                }
                return new by(g, false);
            default:
                bh.A("Unknown type: " + aVar.type);
                return ahm;
        }
    }

    private by<com.google.android.gms.internal.d.a> a(String str, Set<String> set, bj bjVar) {
        this.ahx++;
        b bVar = (b) this.aht.get(str);
        if (bVar == null || this.aho.lK()) {
            c cVar = (c) this.ahv.get(str);
            if (cVar == null) {
                bh.A(mI() + "Invalid macro: " + str);
                this.ahx--;
                return ahm;
            }
            com.google.android.gms.tagmanager.cq.a mP;
            by a = a(str, cVar.mK(), cVar.mL(), cVar.mM(), cVar.mO(), cVar.mN(), set, bjVar.lB());
            if (((Set) a.getObject()).isEmpty()) {
                mP = cVar.mP();
            } else {
                if (((Set) a.getObject()).size() > 1) {
                    bh.D(mI() + "Multiple macros active for macroName " + str);
                }
                mP = (com.google.android.gms.tagmanager.cq.a) ((Set) a.getObject()).iterator().next();
            }
            if (mP == null) {
                this.ahx--;
                return ahm;
            }
            by a2 = a(this.ahr, mP, (Set) set, bjVar.lQ());
            boolean z = a.ma() && a2.ma();
            by<com.google.android.gms.internal.d.a> byVar = a2 == ahm ? ahm : new by(a2.getObject(), z);
            com.google.android.gms.internal.d.a mp = mP.mp();
            if (byVar.ma()) {
                this.aht.e(str, new b(byVar, mp));
            }
            a(mp, (Set) set);
            this.ahx--;
            return byVar;
        }
        a(bVar.mp(), (Set) set);
        this.ahx--;
        return bVar.mJ();
    }

    private by<com.google.android.gms.internal.d.a> a(Map<String, aj> map, com.google.android.gms.tagmanager.cq.a aVar, Set<String> set, cj cjVar) {
        boolean z = true;
        com.google.android.gms.internal.d.a aVar2 = (com.google.android.gms.internal.d.a) aVar.mo().get(com.google.android.gms.internal.b.FUNCTION.toString());
        if (aVar2 == null) {
            bh.A("No function id in properties");
            return ahm;
        }
        String str = aVar2.fS;
        aj ajVar = (aj) map.get(str);
        if (ajVar == null) {
            bh.A(str + " has no backing implementation.");
            return ahm;
        }
        by<com.google.android.gms.internal.d.a> byVar = (by) this.ahs.get(aVar);
        if (byVar != null && !this.aho.lK()) {
            return byVar;
        }
        Map hashMap = new HashMap();
        boolean z2 = true;
        for (Entry entry : aVar.mo().entrySet()) {
            by a = a((com.google.android.gms.internal.d.a) entry.getValue(), (Set) set, cjVar.bZ((String) entry.getKey()).e((com.google.android.gms.internal.d.a) entry.getValue()));
            if (a == ahm) {
                return ahm;
            }
            boolean z3;
            if (a.ma()) {
                aVar.a((String) entry.getKey(), (com.google.android.gms.internal.d.a) a.getObject());
                z3 = z2;
            } else {
                z3 = false;
            }
            hashMap.put(entry.getKey(), a.getObject());
            z2 = z3;
        }
        if (ajVar.a(hashMap.keySet())) {
            if (!(z2 && ajVar.lh())) {
                z = false;
            }
            byVar = new by(ajVar.w(hashMap), z);
            if (z) {
                this.ahs.e(aVar, byVar);
            }
            cjVar.d((com.google.android.gms.internal.d.a) byVar.getObject());
            return byVar;
        }
        bh.A("Incorrect keys for function " + str + " required " + ajVar.lM() + " had " + hashMap.keySet());
        return ahm;
    }

    private by<Set<com.google.android.gms.tagmanager.cq.a>> a(Set<e> set, Set<String> set2, a aVar, cr crVar) {
        Set hashSet = new HashSet();
        Collection hashSet2 = new HashSet();
        boolean z = true;
        for (e eVar : set) {
            cm lY = crVar.lY();
            by a = a(eVar, (Set) set2, lY);
            if (((Boolean) a.getObject()).booleanValue()) {
                aVar.a(eVar, hashSet, hashSet2, lY);
            }
            boolean z2 = z && a.ma();
            z = z2;
        }
        hashSet.removeAll(hashSet2);
        crVar.b(hashSet);
        return new by(hashSet, z);
    }

    private void a(com.google.android.gms.internal.d.a aVar, Set<String> set) {
        if (aVar != null) {
            by a = a(aVar, (Set) set, new bw());
            if (a != ahm) {
                Object o = dh.o((com.google.android.gms.internal.d.a) a.getObject());
                if (o instanceof Map) {
                    this.aeu.push((Map) o);
                } else if (o instanceof List) {
                    for (Object o2 : (List) o2) {
                        if (o2 instanceof Map) {
                            this.aeu.push((Map) o2);
                        } else {
                            bh.D("pushAfterEvaluate: value not a Map");
                        }
                    }
                } else {
                    bh.D("pushAfterEvaluate: value not a Map or List");
                }
            }
        }
    }

    private static void a(List<com.google.android.gms.tagmanager.cq.a> list, List<String> list2, String str) {
        if (list.size() != list2.size()) {
            bh.B("Invalid resource: imbalance of rule names of functions for " + str + " operation. Using default rule name instead");
        }
    }

    private static void a(Map<String, aj> map, aj ajVar) {
        if (map.containsKey(ajVar.lL())) {
            throw new IllegalArgumentException("Duplicate function type name: " + ajVar.lL());
        }
        map.put(ajVar.lL(), ajVar);
    }

    private static c d(Map<String, c> map, String str) {
        c cVar = (c) map.get(str);
        if (cVar != null) {
            return cVar;
        }
        cVar = new c();
        map.put(str, cVar);
        return cVar;
    }

    private static String h(com.google.android.gms.tagmanager.cq.a aVar) {
        return dh.j((com.google.android.gms.internal.d.a) aVar.mo().get(com.google.android.gms.internal.b.INSTANCE_NAME.toString()));
    }

    private String mI() {
        if (this.ahx <= 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.ahx));
        for (int i = 2; i < this.ahx; i++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(": ");
        return stringBuilder.toString();
    }

    by<Boolean> a(com.google.android.gms.tagmanager.cq.a aVar, Set<String> set, cj cjVar) {
        by a = a(this.ahq, aVar, (Set) set, cjVar);
        Boolean n = dh.n((com.google.android.gms.internal.d.a) a.getObject());
        cjVar.d(dh.r(n));
        return new by(n, a.ma());
    }

    by<Boolean> a(e eVar, Set<String> set, cm cmVar) {
        by a;
        boolean z = true;
        for (com.google.android.gms.tagmanager.cq.a a2 : eVar.mx()) {
            a = a(a2, (Set) set, cmVar.lS());
            if (((Boolean) a.getObject()).booleanValue()) {
                cmVar.f(dh.r(Boolean.valueOf(false)));
                return new by(Boolean.valueOf(false), a.ma());
            }
            boolean z2 = z && a.ma();
            z = z2;
        }
        for (com.google.android.gms.tagmanager.cq.a a22 : eVar.mw()) {
            a = a(a22, (Set) set, cmVar.lT());
            if (((Boolean) a.getObject()).booleanValue()) {
                z = z && a.ma();
            } else {
                cmVar.f(dh.r(Boolean.valueOf(false)));
                return new by(Boolean.valueOf(false), a.ma());
            }
        }
        cmVar.f(dh.r(Boolean.valueOf(true)));
        return new by(Boolean.valueOf(true), z);
    }

    by<Set<com.google.android.gms.tagmanager.cq.a>> a(String str, Set<e> set, Map<e, List<com.google.android.gms.tagmanager.cq.a>> map, Map<e, List<String>> map2, Map<e, List<com.google.android.gms.tagmanager.cq.a>> map3, Map<e, List<String>> map4, Set<String> set2, cr crVar) {
        final Map<e, List<com.google.android.gms.tagmanager.cq.a>> map5 = map;
        final Map<e, List<String>> map6 = map2;
        final Map<e, List<com.google.android.gms.tagmanager.cq.a>> map7 = map3;
        final Map<e, List<String>> map8 = map4;
        return a((Set) set, (Set) set2, new a() {
            public void a(e eVar, Set<com.google.android.gms.tagmanager.cq.a> set, Set<com.google.android.gms.tagmanager.cq.a> set2, cm cmVar) {
                List list = (List) map5.get(eVar);
                List list2 = (List) map6.get(eVar);
                if (list != null) {
                    set.addAll(list);
                    cmVar.lU().b(list, list2);
                }
                list = (List) map7.get(eVar);
                list2 = (List) map8.get(eVar);
                if (list != null) {
                    set2.addAll(list);
                    cmVar.lV().b(list, list2);
                }
            }
        }, crVar);
    }

    by<Set<com.google.android.gms.tagmanager.cq.a>> a(Set<e> set, cr crVar) {
        return a((Set) set, new HashSet(), new a() {
            public void a(e eVar, Set<com.google.android.gms.tagmanager.cq.a> set, Set<com.google.android.gms.tagmanager.cq.a> set2, cm cmVar) {
                set.addAll(eVar.my());
                set2.addAll(eVar.mz());
                cmVar.lW().b(eVar.my(), eVar.mD());
                cmVar.lX().b(eVar.mz(), eVar.mE());
            }
        }, crVar);
    }

    void a(aj ajVar) {
        a(this.ahr, ajVar);
    }

    void b(aj ajVar) {
        a(this.ahp, ajVar);
    }

    public synchronized void bH(String str) {
        ck(str);
        af bT = this.aho.bT(str);
        t lI = bT.lI();
        for (com.google.android.gms.tagmanager.cq.a a : (Set) a(this.ahu, lI.lB()).getObject()) {
            a(this.ahp, a, new HashSet(), lI.lA());
        }
        bT.lJ();
        ck(null);
    }

    void c(aj ajVar) {
        a(this.ahq, ajVar);
    }

    public by<com.google.android.gms.internal.d.a> cj(String str) {
        this.ahx = 0;
        af bS = this.aho.bS(str);
        by<com.google.android.gms.internal.d.a> a = a(str, new HashSet(), bS.lH());
        bS.lJ();
        return a;
    }

    synchronized void ck(String str) {
        this.ahw = str;
    }

    public synchronized void h(List<i> list) {
        for (i iVar : list) {
            if (iVar.name == null || !iVar.name.startsWith("gaExperiment:")) {
                bh.C("Ignored supplemental: " + iVar);
            } else {
                ai.a(this.aeu, iVar);
            }
        }
    }

    synchronized String mH() {
        return this.ahw;
    }
}
