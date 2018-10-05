package lip.com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;

public final class o extends d implements DataItem {
    private final int RG;

    public o(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.RG = i2;
    }

    public Map<String, DataItemAsset> getAssets() {
        Map<String, DataItemAsset> hashMap = new HashMap(this.RG);
        for (int i = 0; i < this.RG; i++) {
            k kVar = new k(this.DG, this.EC + i);
            if (kVar.getDataItemKey() != null) {
                hashMap.put(kVar.getDataItemKey(), kVar);
            }
        }
        return hashMap;
    }

    public byte[] getData() {
        return getByteArray("data");
    }

    public Uri getUri() {
        return Uri.parse(getString("path"));
    }

    /* renamed from: nr */
    public DataItem freeze() {
        return new l(this);
    }

    public DataItem setData(byte[] data) {
        throw new UnsupportedOperationException();
    }
}
