package lip.com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hy.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class hv implements SafeParcelable, b<String, Integer> {
    public static final hw CREATOR = new hw();
    private final HashMap<String, Integer> GW;
    private final HashMap<Integer, String> GX;
    private final ArrayList<a> GY;
    private final int xM;

    public static final class a implements SafeParcelable {
        public static final hx CREATOR = new hx();
        final String GZ;
        final int Ha;
        final int versionCode;

        a(int i, String str, int i2) {
            this.versionCode = i;
            this.GZ = str;
            this.Ha = i2;
        }

        a(String str, int i) {
            this.versionCode = 1;
            this.GZ = str;
            this.Ha = i;
        }

        public int describeContents() {
            hx hxVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            hx hxVar = CREATOR;
            hx.a(this, out, flags);
        }
    }

    public hv() {
        this.xM = 1;
        this.GW = new HashMap();
        this.GX = new HashMap();
        this.GY = null;
    }

    hv(int i, ArrayList<a> arrayList) {
        this.xM = i;
        this.GW = new HashMap();
        this.GX = new HashMap();
        this.GY = null;
        a((ArrayList) arrayList);
    }

    private void a(ArrayList<a> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            f(aVar.GZ, aVar.Ha);
        }
    }

    /* renamed from: a */
    public String g(Integer num) {
        String str = (String) this.GX.get(num);
        return (str == null && this.GW.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public int describeContents() {
        hw hwVar = CREATOR;
        return 0;
    }

    public hv f(String str, int i) {
        this.GW.put(str, Integer.valueOf(i));
        this.GX.put(Integer.valueOf(i), str);
        return this;
    }

    ArrayList<a> fD() {
        ArrayList<a> arrayList = new ArrayList();
        for (String str : this.GW.keySet()) {
            arrayList.add(new a(str, ((Integer) this.GW.get(str)).intValue()));
        }
        return arrayList;
    }

    public int fE() {
        return 7;
    }

    public int fF() {
        return 0;
    }

    int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel out, int flags) {
        hw hwVar = CREATOR;
        hw.a(this, out, flags);
    }
}
