package lip.com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public class g implements DataEvent {
    private int AT;
    private DataItem alH;

    public g(DataEvent dataEvent) {
        this.AT = dataEvent.getType();
        this.alH = (DataItem) dataEvent.getDataItem().freeze();
    }

    public DataItem getDataItem() {
        return this.alH;
    }

    public int getType() {
        return this.AT;
    }

    public boolean isDataValid() {
        return true;
    }

    /* renamed from: np */
    public DataEvent freeze() {
        return this;
    }
}
