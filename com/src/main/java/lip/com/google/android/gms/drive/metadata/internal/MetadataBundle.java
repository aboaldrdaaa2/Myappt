package lip.com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hm;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class MetadataBundle implements SafeParcelable {
    public static final Creator<MetadataBundle> CREATOR = new h();
    final Bundle JS;
    final int xM;

    MetadataBundle(int versionCode, Bundle valueBundle) {
        this.xM = versionCode;
        this.JS = (Bundle) hm.f(valueBundle);
        this.JS.setClassLoader(getClass().getClassLoader());
        List<String> arrayList = new ArrayList();
        for (String str : this.JS.keySet()) {
            if (e.aN(str) == null) {
                arrayList.add(str);
                Log.w("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
            }
        }
        for (String str2 : arrayList) {
            this.JS.remove(str2);
        }
    }

    private MetadataBundle(Bundle valueBundle) {
        this(1, valueBundle);
    }

    public static <T> MetadataBundle a(MetadataField<T> metadataField, T t) {
        MetadataBundle gF = gF();
        gF.b(metadataField, t);
        return gF;
    }

    public static MetadataBundle a(MetadataBundle metadataBundle) {
        return new MetadataBundle(new Bundle(metadataBundle.JS));
    }

    public static MetadataBundle gF() {
        return new MetadataBundle(new Bundle());
    }

    public <T> T a(MetadataField<T> metadataField) {
        return metadataField.e(this.JS);
    }

    public <T> void b(MetadataField<T> metadataField, T t) {
        if (e.aN(metadataField.getName()) == null) {
            throw new IllegalArgumentException("Unregistered field: " + metadataField.getName());
        }
        metadataField.a(t, this.JS);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetadataBundle)) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> keySet = this.JS.keySet();
        if (!keySet.equals(metadataBundle.JS.keySet())) {
            return false;
        }
        for (String str : keySet) {
            if (!hk.equal(this.JS.get(str), metadataBundle.JS.get(str))) {
                return false;
            }
        }
        return true;
    }

    public Set<MetadataField<?>> gG() {
        Set<MetadataField<?>> hashSet = new HashSet();
        for (String aN : this.JS.keySet()) {
            hashSet.add(e.aN(aN));
        }
        return hashSet;
    }

    public int hashCode() {
        int i = 1;
        Iterator it = this.JS.keySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i2 *= 31;
            i = this.JS.get((String) it.next()).hashCode() + i2;
        }
    }

    public String toString() {
        return "MetadataBundle [values=" + this.JS + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        h.a(this, dest, flags);
    }
}
