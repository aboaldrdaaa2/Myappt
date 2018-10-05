package lip.com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.wearable.internal.o;

public class DataItemBuffer extends g<DataItem> implements Result {
    private final Status yz;

    public DataItemBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.yz = new Status(dataHolder.getStatusCode());
    }

    protected String eZ() {
        return "path";
    }

    public Status getStatus() {
        return this.yz;
    }

    /* renamed from: n */
    protected DataItem c(int i, int i2) {
        return new o(this.DG, i, i2);
    }
}
