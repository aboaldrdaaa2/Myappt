package lip.com.google.android.gms.drive.metadata;

import com.google.android.gms.common.data.DataHolder;
import java.util.Collection;
import java.util.Collections;

public abstract class b<T> extends a<Collection<T>> {
    protected b(String str, int i) {
        super(str, Collections.emptySet(), Collections.emptySet(), i);
    }

    /* renamed from: c */
    protected Collection<T> b(DataHolder dataHolder, int i, int i2) {
        throw new UnsupportedOperationException("Cannot read collections from a dataHolder.");
    }
}
