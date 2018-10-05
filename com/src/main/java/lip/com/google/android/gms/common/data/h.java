package lip.com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public class h<T> extends c<T> {
    private T EW;

    public h(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    public T next() {
        if (hasNext()) {
            this.EB++;
            if (this.EB == 0) {
                this.EW = this.EA.get(0);
                if (!(this.EW instanceof d)) {
                    throw new IllegalStateException("DataBuffer reference of type " + this.EW.getClass() + " is not movable");
                }
            }
            ((d) this.EW).ac(this.EB);
            return this.EW;
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.EB);
    }
}
