package lip.com.google.android.gms.tagmanager;

import com.google.android.gms.internal.c.h;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class cq {

    public static class a {
        private final Map<String, com.google.android.gms.internal.d.a> agX;
        private final com.google.android.gms.internal.d.a agY;

        private a(Map<String, com.google.android.gms.internal.d.a> map, com.google.android.gms.internal.d.a aVar) {
            this.agX = map;
            this.agY = aVar;
        }

        public static b mn() {
            return new b();
        }

        public void a(String str, com.google.android.gms.internal.d.a aVar) {
            this.agX.put(str, aVar);
        }

        public Map<String, com.google.android.gms.internal.d.a> mo() {
            return Collections.unmodifiableMap(this.agX);
        }

        public com.google.android.gms.internal.d.a mp() {
            return this.agY;
        }

        public String toString() {
            return "Properties: " + mo() + " pushAfterEvaluate: " + this.agY;
        }
    }

    public static class b {
        private final Map<String, com.google.android.gms.internal.d.a> agX;
        private com.google.android.gms.internal.d.a agY;

        private b() {
            this.agX = new HashMap();
        }

        public b b(String str, com.google.android.gms.internal.d.a aVar) {
            this.agX.put(str, aVar);
            return this;
        }

        public b i(com.google.android.gms.internal.d.a aVar) {
            this.agY = aVar;
            return this;
        }

        public a mq() {
            return new a(this.agX, this.agY);
        }
    }

    public static class c {
        private final String aeU;
        private final List<e> agZ;
        private final Map<String, List<a>> aha;
        private final int ahb;

        private c(List<e> list, Map<String, List<a>> map, String str, int i) {
            this.agZ = Collections.unmodifiableList(list);
            this.aha = Collections.unmodifiableMap(map);
            this.aeU = str;
            this.ahb = i;
        }

        public static d mr() {
            return new d();
        }

        public String getVersion() {
            return this.aeU;
        }

        public List<e> ms() {
            return this.agZ;
        }

        public Map<String, List<a>> mt() {
            return this.aha;
        }

        public String toString() {
            return "Rules: " + ms() + "  Macros: " + this.aha;
        }
    }

    public static class d {
        private String aeU;
        private final List<e> agZ;
        private final Map<String, List<a>> aha;
        private int ahb;

        private d() {
            this.agZ = new ArrayList();
            this.aha = new HashMap();
            this.aeU = "";
            this.ahb = 0;
        }

        public d a(a aVar) {
            String j = dh.j((com.google.android.gms.internal.d.a) aVar.mo().get(com.google.android.gms.internal.b.INSTANCE_NAME.toString()));
            List list = (List) this.aha.get(j);
            if (list == null) {
                list = new ArrayList();
                this.aha.put(j, list);
            }
            list.add(aVar);
            return this;
        }

        public d a(e eVar) {
            this.agZ.add(eVar);
            return this;
        }

        public d ce(String str) {
            this.aeU = str;
            return this;
        }

        public d du(int i) {
            this.ahb = i;
            return this;
        }

        public c mu() {
            return new c(this.agZ, this.aha, this.aeU, this.ahb);
        }
    }

    public static class e {
        private final List<a> ahc;
        private final List<a> ahd;
        private final List<a> ahe;
        private final List<a> ahf;
        private final List<a> ahg;
        private final List<a> ahh;
        private final List<String> ahi;
        private final List<String> ahj;
        private final List<String> ahk;
        private final List<String> ahl;

        private e(List<a> list, List<a> list2, List<a> list3, List<a> list4, List<a> list5, List<a> list6, List<String> list7, List<String> list8, List<String> list9, List<String> list10) {
            this.ahc = Collections.unmodifiableList(list);
            this.ahd = Collections.unmodifiableList(list2);
            this.ahe = Collections.unmodifiableList(list3);
            this.ahf = Collections.unmodifiableList(list4);
            this.ahg = Collections.unmodifiableList(list5);
            this.ahh = Collections.unmodifiableList(list6);
            this.ahi = Collections.unmodifiableList(list7);
            this.ahj = Collections.unmodifiableList(list8);
            this.ahk = Collections.unmodifiableList(list9);
            this.ahl = Collections.unmodifiableList(list10);
        }

        public static f mv() {
            return new f();
        }

        public List<a> mA() {
            return this.ahg;
        }

        public List<String> mB() {
            return this.ahi;
        }

        public List<String> mC() {
            return this.ahj;
        }

        public List<String> mD() {
            return this.ahk;
        }

        public List<String> mE() {
            return this.ahl;
        }

        public List<a> mF() {
            return this.ahh;
        }

        public List<a> mw() {
            return this.ahc;
        }

        public List<a> mx() {
            return this.ahd;
        }

        public List<a> my() {
            return this.ahe;
        }

        public List<a> mz() {
            return this.ahf;
        }

        public String toString() {
            return "Positive predicates: " + mw() + "  Negative predicates: " + mx() + "  Add tags: " + my() + "  Remove tags: " + mz() + "  Add macros: " + mA() + "  Remove macros: " + mF();
        }
    }

    public static class f {
        private final List<a> ahc;
        private final List<a> ahd;
        private final List<a> ahe;
        private final List<a> ahf;
        private final List<a> ahg;
        private final List<a> ahh;
        private final List<String> ahi;
        private final List<String> ahj;
        private final List<String> ahk;
        private final List<String> ahl;

        private f() {
            this.ahc = new ArrayList();
            this.ahd = new ArrayList();
            this.ahe = new ArrayList();
            this.ahf = new ArrayList();
            this.ahg = new ArrayList();
            this.ahh = new ArrayList();
            this.ahi = new ArrayList();
            this.ahj = new ArrayList();
            this.ahk = new ArrayList();
            this.ahl = new ArrayList();
        }

        public f b(a aVar) {
            this.ahc.add(aVar);
            return this;
        }

        public f c(a aVar) {
            this.ahd.add(aVar);
            return this;
        }

        public f cf(String str) {
            this.ahk.add(str);
            return this;
        }

        public f cg(String str) {
            this.ahl.add(str);
            return this;
        }

        public f ch(String str) {
            this.ahi.add(str);
            return this;
        }

        public f ci(String str) {
            this.ahj.add(str);
            return this;
        }

        public f d(a aVar) {
            this.ahe.add(aVar);
            return this;
        }

        public f e(a aVar) {
            this.ahf.add(aVar);
            return this;
        }

        public f f(a aVar) {
            this.ahg.add(aVar);
            return this;
        }

        public f g(a aVar) {
            this.ahh.add(aVar);
            return this;
        }

        public e mG() {
            return new e(this.ahc, this.ahd, this.ahe, this.ahf, this.ahg, this.ahh, this.ahi, this.ahj, this.ahk, this.ahl);
        }
    }

    public static class g extends Exception {
        public g(String str) {
            super(str);
        }
    }

    private static com.google.android.gms.internal.d.a a(int i, com.google.android.gms.internal.c.f fVar, com.google.android.gms.internal.d.a[] aVarArr, Set<Integer> set) throws g {
        int i2 = 0;
        if (set.contains(Integer.valueOf(i))) {
            cd("Value cycle detected.  Current value reference: " + i + "." + "  Previous value references: " + set + ".");
        }
        com.google.android.gms.internal.d.a aVar = (com.google.android.gms.internal.d.a) a(fVar.eX, i, "values");
        if (aVarArr[i] != null) {
            return aVarArr[i];
        }
        com.google.android.gms.internal.d.a aVar2 = null;
        set.add(Integer.valueOf(i));
        h h;
        int[] iArr;
        int length;
        int i3;
        int i4;
        switch (aVar.type) {
            case 1:
            case 5:
            case 6:
            case 8:
                aVar2 = aVar;
                break;
            case 2:
                h = h(aVar);
                aVar2 = g(aVar);
                aVar2.fO = new com.google.android.gms.internal.d.a[h.fz.length];
                iArr = h.fz;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    aVar2.fO[i3] = a(iArr[i2], fVar, aVarArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case 3:
                aVar2 = g(aVar);
                h h2 = h(aVar);
                if (h2.fA.length != h2.fB.length) {
                    cd("Uneven map keys (" + h2.fA.length + ") and map values (" + h2.fB.length + ")");
                }
                aVar2.fP = new com.google.android.gms.internal.d.a[h2.fA.length];
                aVar2.fQ = new com.google.android.gms.internal.d.a[h2.fA.length];
                int[] iArr2 = h2.fA;
                int length2 = iArr2.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length2) {
                    int i5 = i4 + 1;
                    aVar2.fP[i4] = a(iArr2[i3], fVar, aVarArr, (Set) set);
                    i3++;
                    i4 = i5;
                }
                iArr = h2.fB;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    aVar2.fQ[i3] = a(iArr[i2], fVar, aVarArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case 4:
                aVar2 = g(aVar);
                aVar2.fR = dh.j(a(h(aVar).fE, fVar, aVarArr, (Set) set));
                break;
            case 7:
                aVar2 = g(aVar);
                h = h(aVar);
                aVar2.fV = new com.google.android.gms.internal.d.a[h.fD.length];
                iArr = h.fD;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    aVar2.fV[i3] = a(iArr[i2], fVar, aVarArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
        }
        if (aVar2 == null) {
            cd("Invalid value: " + aVar);
        }
        aVarArr[i] = aVar2;
        set.remove(Integer.valueOf(i));
        return aVar2;
    }

    private static a a(com.google.android.gms.internal.c.b bVar, com.google.android.gms.internal.c.f fVar, com.google.android.gms.internal.d.a[] aVarArr, int i) throws g {
        b mn = a.mn();
        for (int valueOf : bVar.eH) {
            com.google.android.gms.internal.c.e eVar = (com.google.android.gms.internal.c.e) a(fVar.eY, Integer.valueOf(valueOf).intValue(), "properties");
            String str = (String) a(fVar.eW, eVar.key, "keys");
            com.google.android.gms.internal.d.a aVar = (com.google.android.gms.internal.d.a) a(aVarArr, eVar.value, "values");
            if (com.google.android.gms.internal.b.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                mn.i(aVar);
            } else {
                mn.b(str, aVar);
            }
        }
        return mn.mq();
    }

    private static e a(com.google.android.gms.internal.c.g gVar, List<a> list, List<a> list2, List<a> list3, com.google.android.gms.internal.c.f fVar) {
        f mv = e.mv();
        for (int valueOf : gVar.fn) {
            mv.b((a) list3.get(Integer.valueOf(valueOf).intValue()));
        }
        for (int valueOf2 : gVar.fo) {
            mv.c((a) list3.get(Integer.valueOf(valueOf2).intValue()));
        }
        for (int valueOf22 : gVar.fp) {
            mv.d((a) list.get(Integer.valueOf(valueOf22).intValue()));
        }
        for (int valueOf3 : gVar.fr) {
            mv.cf(fVar.eX[Integer.valueOf(valueOf3).intValue()].fN);
        }
        for (int valueOf222 : gVar.fq) {
            mv.e((a) list.get(Integer.valueOf(valueOf222).intValue()));
        }
        for (int valueOf32 : gVar.fs) {
            mv.cg(fVar.eX[Integer.valueOf(valueOf32).intValue()].fN);
        }
        for (int valueOf2222 : gVar.ft) {
            mv.f((a) list2.get(Integer.valueOf(valueOf2222).intValue()));
        }
        for (int valueOf322 : gVar.fv) {
            mv.ch(fVar.eX[Integer.valueOf(valueOf322).intValue()].fN);
        }
        for (int valueOf22222 : gVar.fu) {
            mv.g((a) list2.get(Integer.valueOf(valueOf22222).intValue()));
        }
        for (int valueOf4 : gVar.fw) {
            mv.ci(fVar.eX[Integer.valueOf(valueOf4).intValue()].fN);
        }
        return mv.mG();
    }

    private static <T> T a(T[] tArr, int i, String str) throws g {
        if (i < 0 || i >= tArr.length) {
            cd("Index out of bounds detected: " + i + " in " + str);
        }
        return tArr[i];
    }

    public static c b(com.google.android.gms.internal.c.f fVar) throws g {
        int i;
        int i2 = 0;
        com.google.android.gms.internal.d.a[] aVarArr = new com.google.android.gms.internal.d.a[fVar.eX.length];
        for (i = 0; i < fVar.eX.length; i++) {
            a(i, fVar, aVarArr, new HashSet(0));
        }
        d mr = c.mr();
        List arrayList = new ArrayList();
        for (i = 0; i < fVar.fa.length; i++) {
            arrayList.add(a(fVar.fa[i], fVar, aVarArr, i));
        }
        List arrayList2 = new ArrayList();
        for (i = 0; i < fVar.fb.length; i++) {
            arrayList2.add(a(fVar.fb[i], fVar, aVarArr, i));
        }
        List arrayList3 = new ArrayList();
        for (i = 0; i < fVar.eZ.length; i++) {
            a a = a(fVar.eZ[i], fVar, aVarArr, i);
            mr.a(a);
            arrayList3.add(a);
        }
        com.google.android.gms.internal.c.g[] gVarArr = fVar.fc;
        int length = gVarArr.length;
        while (i2 < length) {
            mr.a(a(gVarArr[i2], arrayList, arrayList3, arrayList2, fVar));
            i2++;
        }
        mr.ce(fVar.fg);
        mr.du(fVar.fl);
        return mr.mu();
    }

    public static void b(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static void cd(String str) throws g {
        bh.A(str);
        throw new g(str);
    }

    public static com.google.android.gms.internal.d.a g(com.google.android.gms.internal.d.a aVar) {
        com.google.android.gms.internal.d.a aVar2 = new com.google.android.gms.internal.d.a();
        aVar2.type = aVar.type;
        aVar2.fW = (int[]) aVar.fW.clone();
        if (aVar.fX) {
            aVar2.fX = aVar.fX;
        }
        return aVar2;
    }

    private static h h(com.google.android.gms.internal.d.a aVar) throws g {
        if (((h) aVar.a(h.fx)) == null) {
            cd("Expected a ServingValue and didn't get one. Value is: " + aVar);
        }
        return (h) aVar.a(h.fx);
    }
}
