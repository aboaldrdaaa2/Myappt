package lip.com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;

public class ib implements SafeParcelable {
    public static final ic CREATOR = new ic();
    private final HashMap<String, HashMap<String, com.google.android.gms.internal.hy.a<?, ?>>> Hl;
    private final ArrayList<a> Hm;
    private final String Hn;
    private final int xM;

    public static class a implements SafeParcelable {
        public static final id CREATOR = new id();
        final ArrayList<b> Ho;
        final String className;
        final int versionCode;

        a(int i, String str, ArrayList<b> arrayList) {
            this.versionCode = i;
            this.className = str;
            this.Ho = arrayList;
        }

        a(String str, HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> hashMap) {
            this.versionCode = 1;
            this.className = str;
            this.Ho = a(hashMap);
        }

        private static ArrayList<b> a(HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> hashMap) {
            if (hashMap == null) {
                return null;
            }
            ArrayList<b> arrayList = new ArrayList();
            for (String str : hashMap.keySet()) {
                arrayList.add(new b(str, (com.google.android.gms.internal.hy.a) hashMap.get(str)));
            }
            return arrayList;
        }

        public int describeContents() {
            id idVar = CREATOR;
            return 0;
        }

        HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> fX() {
            HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> hashMap = new HashMap();
            int size = this.Ho.size();
            for (int i = 0; i < size; i++) {
                b bVar = (b) this.Ho.get(i);
                hashMap.put(bVar.eM, bVar.Hp);
            }
            return hashMap;
        }

        public void writeToParcel(Parcel out, int flags) {
            id idVar = CREATOR;
            id.a(this, out, flags);
        }
    }

    public static class b implements SafeParcelable {
        public static final ia CREATOR = new ia();
        final com.google.android.gms.internal.hy.a<?, ?> Hp;
        final String eM;
        final int versionCode;

        b(int i, String str, com.google.android.gms.internal.hy.a<?, ?> aVar) {
            this.versionCode = i;
            this.eM = str;
            this.Hp = aVar;
        }

        b(String str, com.google.android.gms.internal.hy.a<?, ?> aVar) {
            this.versionCode = 1;
            this.eM = str;
            this.Hp = aVar;
        }

        public int describeContents() {
            ia iaVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            ia iaVar = CREATOR;
            ia.a(this, out, flags);
        }
    }

    ib(int i, ArrayList<a> arrayList, String str) {
        this.xM = i;
        this.Hm = null;
        this.Hl = b((ArrayList) arrayList);
        this.Hn = (String) hm.f(str);
        fT();
    }

    public ib(Class<? extends hy> cls) {
        this.xM = 1;
        this.Hm = null;
        this.Hl = new HashMap();
        this.Hn = cls.getCanonicalName();
    }

    private static HashMap<String, HashMap<String, com.google.android.gms.internal.hy.a<?, ?>>> b(ArrayList<a> arrayList) {
        HashMap<String, HashMap<String, com.google.android.gms.internal.hy.a<?, ?>>> hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            a aVar = (a) arrayList.get(i);
            hashMap.put(aVar.className, aVar.fX());
        }
        return hashMap;
    }

    public void a(Class<? extends hy> cls, HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> hashMap) {
        this.Hl.put(cls.getCanonicalName(), hashMap);
    }

    public HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> aJ(String str) {
        return (HashMap) this.Hl.get(str);
    }

    public boolean b(Class<? extends hy> cls) {
        return this.Hl.containsKey(cls.getCanonicalName());
    }

    public int describeContents() {
        ic icVar = CREATOR;
        return 0;
    }

    public void fT() {
        for (String str : this.Hl.keySet()) {
            HashMap hashMap = (HashMap) this.Hl.get(str);
            for (String str2 : hashMap.keySet()) {
                ((com.google.android.gms.internal.hy.a) hashMap.get(str2)).a(this);
            }
        }
    }

    public void fU() {
        for (String str : this.Hl.keySet()) {
            HashMap hashMap = (HashMap) this.Hl.get(str);
            HashMap hashMap2 = new HashMap();
            for (String str2 : hashMap.keySet()) {
                hashMap2.put(str2, ((com.google.android.gms.internal.hy.a) hashMap.get(str2)).fJ());
            }
            this.Hl.put(str, hashMap2);
        }
    }

    ArrayList<a> fV() {
        ArrayList<a> arrayList = new ArrayList();
        for (String str : this.Hl.keySet()) {
            arrayList.add(new a(str, (HashMap) this.Hl.get(str)));
        }
        return arrayList;
    }

    public String fW() {
        return this.Hn;
    }

    int getVersionCode() {
        return this.xM;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.Hl.keySet()) {
            stringBuilder.append(str).append(":\n");
            HashMap hashMap = (HashMap) this.Hl.get(str);
            for (String str2 : hashMap.keySet()) {
                stringBuilder.append("  ").append(str2).append(": ");
                stringBuilder.append(hashMap.get(str2));
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        ic icVar = CREATOR;
        ic.a(this, out, flags);
    }
}
