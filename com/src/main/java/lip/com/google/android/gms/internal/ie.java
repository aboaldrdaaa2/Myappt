package lip.com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.hy.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class ie extends hy implements SafeParcelable {
    public static final if CREATOR = new if();
    private final ib Hj;
    private final Parcel Hq;
    private final int Hr;
    private int Hs;
    private int Ht;
    private final String mClassName;
    private final int xM;

    ie(int i, Parcel parcel, ib ibVar) {
        this.xM = i;
        this.Hq = (Parcel) hm.f(parcel);
        this.Hr = 2;
        this.Hj = ibVar;
        if (this.Hj == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.Hj.fW();
        }
        this.Hs = 2;
    }

    private ie(SafeParcelable safeParcelable, ib ibVar, String str) {
        this.xM = 1;
        this.Hq = Parcel.obtain();
        safeParcelable.writeToParcel(this.Hq, 0);
        this.Hr = 1;
        this.Hj = (ib) hm.f(ibVar);
        this.mClassName = (String) hm.f(str);
        this.Hs = 2;
    }

    public static <T extends hy & SafeParcelable> ie a(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new ie((SafeParcelable) t, b((hy) t), canonicalName);
    }

    private static void a(ib ibVar, hy hyVar) {
        Class cls = hyVar.getClass();
        if (!ibVar.b(cls)) {
            HashMap fG = hyVar.fG();
            ibVar.a(cls, hyVar.fG());
            for (String str : fG.keySet()) {
                a aVar = (a) fG.get(str);
                Class fO = aVar.fO();
                if (fO != null) {
                    try {
                        a(ibVar, (hy) fO.newInstance());
                    } catch (Throwable e) {
                        throw new IllegalStateException("Could not instantiate an object of type " + aVar.fO().getCanonicalName(), e);
                    } catch (Throwable e2) {
                        throw new IllegalStateException("Could not access object of type " + aVar.fO().getCanonicalName(), e2);
                    }
                }
            }
        }
    }

    private void a(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                stringBuilder.append(obj);
                return;
            case 7:
                stringBuilder.append("\"").append(in.aK(obj.toString())).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(ih.d((byte[]) obj)).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(ih.e((byte[]) obj));
                stringBuilder.append("\"");
                return;
            case 10:
                io.a(stringBuilder, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private void a(StringBuilder stringBuilder, a<?, ?> aVar, Parcel parcel, int i) {
        switch (aVar.fF()) {
            case 0:
                b(stringBuilder, (a) aVar, a(aVar, Integer.valueOf(com.google.android.gms.common.internal.safeparcel.a.g(parcel, i))));
                return;
            case 1:
                b(stringBuilder, (a) aVar, a(aVar, com.google.android.gms.common.internal.safeparcel.a.k(parcel, i)));
                return;
            case 2:
                b(stringBuilder, (a) aVar, a(aVar, Long.valueOf(com.google.android.gms.common.internal.safeparcel.a.i(parcel, i))));
                return;
            case 3:
                b(stringBuilder, (a) aVar, a(aVar, Float.valueOf(com.google.android.gms.common.internal.safeparcel.a.l(parcel, i))));
                return;
            case 4:
                b(stringBuilder, (a) aVar, a(aVar, Double.valueOf(com.google.android.gms.common.internal.safeparcel.a.m(parcel, i))));
                return;
            case 5:
                b(stringBuilder, (a) aVar, a(aVar, com.google.android.gms.common.internal.safeparcel.a.n(parcel, i)));
                return;
            case 6:
                b(stringBuilder, (a) aVar, a(aVar, Boolean.valueOf(com.google.android.gms.common.internal.safeparcel.a.c(parcel, i))));
                return;
            case 7:
                b(stringBuilder, (a) aVar, a(aVar, com.google.android.gms.common.internal.safeparcel.a.o(parcel, i)));
                return;
            case 8:
            case 9:
                b(stringBuilder, (a) aVar, a(aVar, com.google.android.gms.common.internal.safeparcel.a.r(parcel, i)));
                return;
            case 10:
                b(stringBuilder, (a) aVar, a(aVar, d(com.google.android.gms.common.internal.safeparcel.a.q(parcel, i))));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + aVar.fF());
        }
    }

    private void a(StringBuilder stringBuilder, String str, a<?, ?> aVar, Parcel parcel, int i) {
        stringBuilder.append("\"").append(str).append("\":");
        if (aVar.fQ()) {
            a(stringBuilder, aVar, parcel, i);
        } else {
            b(stringBuilder, aVar, parcel, i);
        }
    }

    private void a(StringBuilder stringBuilder, HashMap<String, a<?, ?>> hashMap, Parcel parcel) {
        HashMap b = b((HashMap) hashMap);
        stringBuilder.append('{');
        int B = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
        Object obj = null;
        while (parcel.dataPosition() < B) {
            int A = com.google.android.gms.common.internal.safeparcel.a.A(parcel);
            Entry entry = (Entry) b.get(Integer.valueOf(com.google.android.gms.common.internal.safeparcel.a.ar(A)));
            if (entry != null) {
                if (obj != null) {
                    stringBuilder.append(",");
                }
                a(stringBuilder, (String) entry.getKey(), (a) entry.getValue(), parcel, A);
                obj = 1;
            }
        }
        if (parcel.dataPosition() != B) {
            throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + B, parcel);
        }
        stringBuilder.append('}');
    }

    private static ib b(hy hyVar) {
        ib ibVar = new ib(hyVar.getClass());
        a(ibVar, hyVar);
        ibVar.fU();
        ibVar.fT();
        return ibVar;
    }

    private static HashMap<Integer, Entry<String, a<?, ?>>> b(HashMap<String, a<?, ?>> hashMap) {
        HashMap<Integer, Entry<String, a<?, ?>>> hashMap2 = new HashMap();
        for (Entry entry : hashMap.entrySet()) {
            hashMap2.put(Integer.valueOf(((a) entry.getValue()).fN()), entry);
        }
        return hashMap2;
    }

    private void b(StringBuilder stringBuilder, a<?, ?> aVar, Parcel parcel, int i) {
        if (aVar.fL()) {
            stringBuilder.append("[");
            switch (aVar.fF()) {
                case 0:
                    ig.a(stringBuilder, com.google.android.gms.common.internal.safeparcel.a.u(parcel, i));
                    break;
                case 1:
                    ig.a(stringBuilder, com.google.android.gms.common.internal.safeparcel.a.w(parcel, i));
                    break;
                case 2:
                    ig.a(stringBuilder, com.google.android.gms.common.internal.safeparcel.a.v(parcel, i));
                    break;
                case 3:
                    ig.a(stringBuilder, com.google.android.gms.common.internal.safeparcel.a.x(parcel, i));
                    break;
                case 4:
                    ig.a(stringBuilder, com.google.android.gms.common.internal.safeparcel.a.y(parcel, i));
                    break;
                case 5:
                    ig.a(stringBuilder, com.google.android.gms.common.internal.safeparcel.a.z(parcel, i));
                    break;
                case 6:
                    ig.a(stringBuilder, com.google.android.gms.common.internal.safeparcel.a.t(parcel, i));
                    break;
                case 7:
                    ig.a(stringBuilder, com.google.android.gms.common.internal.safeparcel.a.A(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] D = com.google.android.gms.common.internal.safeparcel.a.D(parcel, i);
                    int length = D.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            stringBuilder.append(",");
                        }
                        D[i2].setDataPosition(0);
                        a(stringBuilder, aVar.fS(), D[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            stringBuilder.append("]");
            return;
        }
        switch (aVar.fF()) {
            case 0:
                stringBuilder.append(com.google.android.gms.common.internal.safeparcel.a.g(parcel, i));
                return;
            case 1:
                stringBuilder.append(com.google.android.gms.common.internal.safeparcel.a.k(parcel, i));
                return;
            case 2:
                stringBuilder.append(com.google.android.gms.common.internal.safeparcel.a.i(parcel, i));
                return;
            case 3:
                stringBuilder.append(com.google.android.gms.common.internal.safeparcel.a.l(parcel, i));
                return;
            case 4:
                stringBuilder.append(com.google.android.gms.common.internal.safeparcel.a.m(parcel, i));
                return;
            case 5:
                stringBuilder.append(com.google.android.gms.common.internal.safeparcel.a.n(parcel, i));
                return;
            case 6:
                stringBuilder.append(com.google.android.gms.common.internal.safeparcel.a.c(parcel, i));
                return;
            case 7:
                stringBuilder.append("\"").append(in.aK(com.google.android.gms.common.internal.safeparcel.a.o(parcel, i))).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(ih.d(com.google.android.gms.common.internal.safeparcel.a.r(parcel, i))).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(ih.e(com.google.android.gms.common.internal.safeparcel.a.r(parcel, i)));
                stringBuilder.append("\"");
                return;
            case 10:
                Bundle q = com.google.android.gms.common.internal.safeparcel.a.q(parcel, i);
                Set<String> keySet = q.keySet();
                keySet.size();
                stringBuilder.append("{");
                int i3 = 1;
                for (String str : keySet) {
                    if (i3 == 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"").append(in.aK(q.getString(str))).append("\"");
                    i3 = 0;
                }
                stringBuilder.append("}");
                return;
            case 11:
                Parcel C = com.google.android.gms.common.internal.safeparcel.a.C(parcel, i);
                C.setDataPosition(0);
                a(stringBuilder, aVar.fS(), C);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    private void b(StringBuilder stringBuilder, a<?, ?> aVar, Object obj) {
        if (aVar.fK()) {
            b(stringBuilder, (a) aVar, (ArrayList) obj);
        } else {
            a(stringBuilder, aVar.fE(), obj);
        }
    }

    private void b(StringBuilder stringBuilder, a<?, ?> aVar, ArrayList<?> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            a(stringBuilder, aVar.fE(), arrayList.get(i));
        }
        stringBuilder.append("]");
    }

    public static HashMap<String, String> d(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    protected Object aF(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    protected boolean aG(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public int describeContents() {
        if ifVar = CREATOR;
        return 0;
    }

    public HashMap<String, a<?, ?>> fG() {
        return this.Hj == null ? null : this.Hj.aJ(this.mClassName);
    }

    public Parcel fY() {
        switch (this.Hs) {
            case 0:
                this.Ht = b.C(this.Hq);
                b.G(this.Hq, this.Ht);
                this.Hs = 2;
                break;
            case 1:
                b.G(this.Hq, this.Ht);
                this.Hs = 2;
                break;
        }
        return this.Hq;
    }

    ib fZ() {
        switch (this.Hr) {
            case 0:
                return null;
            case 1:
                return this.Hj;
            case 2:
                return this.Hj;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.Hr);
        }
    }

    public int getVersionCode() {
        return this.xM;
    }

    public String toString() {
        hm.b(this.Hj, (Object) "Cannot convert to JSON on client side.");
        Parcel fY = fY();
        fY.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        a(stringBuilder, this.Hj.aJ(this.mClassName), fY);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        if ifVar = CREATOR;
        if.a(this, out, flags);
    }
}
