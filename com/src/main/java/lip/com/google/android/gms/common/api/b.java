package lip.com.google.android.gms.common.api;

import com.google.android.gms.common.data.DataHolder;

public abstract class b implements Releasable, Result {
    protected final DataHolder DG;
    protected final Status yz;

    protected b(DataHolder dataHolder) {
        this.yz = new Status(dataHolder.getStatusCode());
        this.DG = dataHolder;
    }

    public Status getStatus() {
        return this.yz;
    }

    public void release() {
        if (this.DG != null) {
            this.DG.close();
        }
    }
}
