package lip.com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.api.Releasable;
import java.util.Iterator;

public abstract class DataBuffer<T> implements Releasable, Iterable<T> {
    protected final DataHolder DG;

    protected DataBuffer(DataHolder dataHolder) {
        this.DG = dataHolder;
        if (this.DG != null) {
            this.DG.b(this);
        }
    }

    @Deprecated
    public final void close() {
        release();
    }

    public int describeContents() {
        return 0;
    }

    public Bundle eU() {
        return this.DG.eU();
    }

    public abstract T get(int i);

    public int getCount() {
        return this.DG == null ? 0 : this.DG.getCount();
    }

    @Deprecated
    public boolean isClosed() {
        return this.DG == null ? true : this.DG.isClosed();
    }

    public Iterator<T> iterator() {
        return new c(this);
    }

    public void release() {
        if (this.DG != null) {
            this.DG.close();
        }
    }

    public Iterator<T> singleRefIterator() {
        return new h(this);
    }
}
