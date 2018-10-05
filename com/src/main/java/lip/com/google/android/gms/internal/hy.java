package lip.com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class hy {

    public interface b<I, O> {
        int fE();

        int fF();

        I g(O o);
    }

    public static class a<I, O> implements SafeParcelable {
        public static final hz CREATOR = new hz();
        protected final int Hb;
        protected final boolean Hc;
        protected final int Hd;
        protected final boolean He;
        protected final String Hf;
        protected final int Hg;
        protected final Class<? extends hy> Hh;
        protected final String Hi;
        private ib Hj;
        private b<I, O> Hk;
        private final int xM;

        a(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, ht htVar) {
            this.xM = i;
            this.Hb = i2;
            this.Hc = z;
            this.Hd = i3;
            this.He = z2;
            this.Hf = str;
            this.Hg = i4;
            if (str2 == null) {
                this.Hh = null;
                this.Hi = null;
            } else {
                this.Hh = ie.class;
                this.Hi = str2;
            }
            if (htVar == null) {
                this.Hk = null;
            } else {
                this.Hk = htVar.fC();
            }
        }

        protected a(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends hy> cls, b<I, O> bVar) {
            this.xM = 1;
            this.Hb = i;
            this.Hc = z;
            this.Hd = i2;
            this.He = z2;
            this.Hf = str;
            this.Hg = i3;
            this.Hh = cls;
            if (cls == null) {
                this.Hi = null;
            } else {
                this.Hi = cls.getCanonicalName();
            }
            this.Hk = bVar;
        }

        public static a a(String str, int i, b<?, ?> bVar, boolean z) {
            return new a(bVar.fE(), z, bVar.fF(), false, str, i, null, bVar);
        }

        public static <T extends hy> a<T, T> a(String str, int i, Class<T> cls) {
            return new a(11, false, 11, false, str, i, cls, null);
        }

        public static <T extends hy> a<ArrayList<T>, ArrayList<T>> b(String str, int i, Class<T> cls) {
            return new a(11, true, 11, true, str, i, cls, null);
        }

        public static a<Integer, Integer> g(String str, int i) {
            return new a(0, false, 0, false, str, i, null, null);
        }

        public static a<Double, Double> h(String str, int i) {
            return new a(4, false, 4, false, str, i, null, null);
        }

        public static a<Boolean, Boolean> i(String str, int i) {
            return new a(6, false, 6, false, str, i, null, null);
        }

        public static a<String, String> j(String str, int i) {
            return new a(7, false, 7, false, str, i, null, null);
        }

        public static a<ArrayList<String>, ArrayList<String>> k(String str, int i) {
            return new a(7, true, 7, true, str, i, null, null);
        }

        public void a(ib ibVar) {
            this.Hj = ibVar;
        }

        public int describeContents() {
            hz hzVar = CREATOR;
            return 0;
        }

        public int fE() {
            return this.Hb;
        }

        public int fF() {
            return this.Hd;
        }

        public a<I, O> fJ() {
            return new a(this.xM, this.Hb, this.Hc, this.Hd, this.He, this.Hf, this.Hg, this.Hi, fR());
        }

        public boolean fK() {
            return this.Hc;
        }

        public boolean fL() {
            return this.He;
        }

        public String fM() {
            return this.Hf;
        }

        public int fN() {
            return this.Hg;
        }

        public Class<? extends hy> fO() {
            return this.Hh;
        }

        String fP() {
            return this.Hi == null ? null : this.Hi;
        }

        public boolean fQ() {
            return this.Hk != null;
        }

        ht fR() {
            return this.Hk == null ? null : ht.a(this.Hk);
        }

        public HashMap<String, a<?, ?>> fS() {
            hm.f(this.Hi);
            hm.f(this.Hj);
            return this.Hj.aJ(this.Hi);
        }

        public I g(O o) {
            return this.Hk.g(o);
        }

        public int getVersionCode() {
            return this.xM;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field\n");
            stringBuilder.append("            versionCode=").append(this.xM).append(10);
            stringBuilder.append("                 typeIn=").append(this.Hb).append(10);
            stringBuilder.append("            typeInArray=").append(this.Hc).append(10);
            stringBuilder.append("                typeOut=").append(this.Hd).append(10);
            stringBuilder.append("           typeOutArray=").append(this.He).append(10);
            stringBuilder.append("        outputFieldName=").append(this.Hf).append(10);
            stringBuilder.append("      safeParcelFieldId=").append(this.Hg).append(10);
            stringBuilder.append("       concreteTypeName=").append(fP()).append(10);
            if (fO() != null) {
                stringBuilder.append("     concreteType.class=").append(fO().getCanonicalName()).append(10);
            }
            stringBuilder.append("          converterName=").append(this.Hk == null ? "null" : this.Hk.getClass().getCanonicalName()).append(10);
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel out, int flags) {
            hz hzVar = CREATOR;
            hz.a(this, out, flags);
        }
    }

    private void a(StringBuilder stringBuilder, a aVar, Object obj) {
        if (aVar.fE() == 11) {
            stringBuilder.append(((hy) aVar.fO().cast(obj)).toString());
        } else if (aVar.fE() == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(in.aK((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    private void a(StringBuilder stringBuilder, a aVar, ArrayList<Object> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                a(stringBuilder, aVar, obj);
            }
        }
        stringBuilder.append("]");
    }

    protected <O, I> I a(a<I, O> aVar, Object obj) {
        return aVar.Hk != null ? aVar.g(obj) : obj;
    }

    protected boolean a(a aVar) {
        return aVar.fF() == 11 ? aVar.fL() ? aI(aVar.fM()) : aH(aVar.fM()) : aG(aVar.fM());
    }

    protected abstract Object aF(String str);

    protected abstract boolean aG(String str);

    protected boolean aH(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean aI(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    protected Object b(a aVar) {
        String fM = aVar.fM();
        if (aVar.fO() == null) {
            return aF(aVar.fM());
        }
        hm.a(aF(aVar.fM()) == null, "Concrete field shouldn't be value object: %s", aVar.fM());
        Map fI = aVar.fL() ? fI() : fH();
        if (fI != null) {
            return fI.get(fM);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(fM.charAt(0)) + fM.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public abstract HashMap<String, a<?, ?>> fG();

    public HashMap<String, Object> fH() {
        return null;
    }

    public HashMap<String, Object> fI() {
        return null;
    }

    public String toString() {
        HashMap fG = fG();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : fG.keySet()) {
            a aVar = (a) fG.get(str);
            if (a(aVar)) {
                Object a = a(aVar, b(aVar));
                if (stringBuilder.length() == 0) {
                    stringBuilder.append("{");
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append("\"").append(str).append("\":");
                if (a != null) {
                    switch (aVar.fF()) {
                        case 8:
                            stringBuilder.append("\"").append(ih.d((byte[]) a)).append("\"");
                            break;
                        case 9:
                            stringBuilder.append("\"").append(ih.e((byte[]) a)).append("\"");
                            break;
                        case 10:
                            io.a(stringBuilder, (HashMap) a);
                            break;
                        default:
                            if (!aVar.fK()) {
                                a(stringBuilder, aVar, a);
                                break;
                            }
                            a(stringBuilder, aVar, (ArrayList) a);
                            break;
                    }
                }
                stringBuilder.append("null");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }
}
