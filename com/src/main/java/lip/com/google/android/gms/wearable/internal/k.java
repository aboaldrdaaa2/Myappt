package lip.com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.wearable.DataItemAsset;

public class k extends d implements DataItemAsset {
    public k(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public String getDataItemKey() {
        return getString("asset_key");
    }

    public String getId() {
        return getString("asset_id");
    }

    /* renamed from: nq */
    public DataItemAsset freeze() {
        return new i(this);
    }
}
