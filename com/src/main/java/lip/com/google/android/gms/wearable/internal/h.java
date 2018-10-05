package lip.com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public final class h extends d implements DataEvent {
    private final int RG;

    public h(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.RG = i2;
    }

    public DataItem getDataItem() {
        return new o(this.DG, this.EC, this.RG);
    }

    public int getType() {
        return getInteger("event_type");
    }

    /* renamed from: np */
    public DataEvent freeze() {
        return new g(this);
    }
}
