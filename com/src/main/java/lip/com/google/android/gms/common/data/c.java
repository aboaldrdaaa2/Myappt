package lip.com.google.android.gms.common.data;

import com.google.android.gms.internal.hm;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class c<T> implements Iterator<T> {
    protected final DataBuffer<T> EA;
    protected int EB = -1;

    public c(DataBuffer<T> dataBuffer) {
        this.EA = (DataBuffer) hm.f(dataBuffer);
    }

    public boolean hasNext() {
        return this.EB < this.EA.getCount() + -1;
    }

    public T next() {
        if (hasNext()) {
            DataBuffer dataBuffer = this.EA;
            int i = this.EB + 1;
            this.EB = i;
            return dataBuffer.get(i);
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.EB);
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
