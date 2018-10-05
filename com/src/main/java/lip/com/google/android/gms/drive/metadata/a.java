package lip.com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.hm;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class a<T> implements MetadataField<T> {
    private final String JH;
    private final Set<String> JI;
    private final Set<String> JJ;
    private final int JK;

    protected a(String str, int i) {
        this.JH = (String) hm.b((Object) str, (Object) "fieldName");
        this.JI = Collections.singleton(str);
        this.JJ = Collections.emptySet();
        this.JK = i;
    }

    protected a(String str, Collection<String> collection, Collection<String> collection2, int i) {
        this.JH = (String) hm.b((Object) str, (Object) "fieldName");
        this.JI = Collections.unmodifiableSet(new HashSet(collection));
        this.JJ = Collections.unmodifiableSet(new HashSet(collection2));
        this.JK = i;
    }

    public final T a(DataHolder dataHolder, int i, int i2) {
        for (String h : this.JI) {
            if (dataHolder.h(h, i, i2)) {
                return null;
            }
        }
        return b(dataHolder, i, i2);
    }

    protected abstract void a(Bundle bundle, T t);

    public final void a(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2) {
        hm.b((Object) dataHolder, (Object) "dataHolder");
        hm.b((Object) metadataBundle, (Object) "bundle");
        metadataBundle.b(this, a(dataHolder, i, i2));
    }

    public final void a(T t, Bundle bundle) {
        hm.b((Object) bundle, (Object) "bundle");
        if (t == null) {
            bundle.putString(getName(), null);
        } else {
            a(bundle, (Object) t);
        }
    }

    protected abstract T b(DataHolder dataHolder, int i, int i2);

    public final T e(Bundle bundle) {
        hm.b((Object) bundle, (Object) "bundle");
        return bundle.get(getName()) != null ? f(bundle) : null;
    }

    protected abstract T f(Bundle bundle);

    public final Collection<String> gC() {
        return this.JI;
    }

    public final String getName() {
        return this.JH;
    }

    public String toString() {
        return this.JH;
    }
}
