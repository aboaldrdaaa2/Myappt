package lip.com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class l implements DataItem {
    private byte[] TF;
    private Map<String, DataItemAsset> alK;
    private Uri mUri;

    public l(DataItem dataItem) {
        this.mUri = dataItem.getUri();
        this.TF = dataItem.getData();
        Map hashMap = new HashMap();
        for (Entry entry : dataItem.getAssets().entrySet()) {
            if (entry.getKey() != null) {
                hashMap.put(entry.getKey(), ((DataItemAsset) entry.getValue()).freeze());
            }
        }
        this.alK = Collections.unmodifiableMap(hashMap);
    }

    public Map<String, DataItemAsset> getAssets() {
        return this.alK;
    }

    public byte[] getData() {
        return this.TF;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean isDataValid() {
        return true;
    }

    /* renamed from: nr */
    public DataItem freeze() {
        return this;
    }

    public DataItem setData(byte[] data) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean verbose) {
        StringBuilder stringBuilder = new StringBuilder("DataItemEntity[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        stringBuilder.append(",dataSz=" + (this.TF == null ? "null" : Integer.valueOf(this.TF.length)));
        stringBuilder.append(", numAssets=" + this.alK.size());
        stringBuilder.append(", uri=" + this.mUri);
        if (verbose) {
            stringBuilder.append("]\n  assets: ");
            for (String str : this.alK.keySet()) {
                stringBuilder.append("\n    " + str + ": " + this.alK.get(str));
            }
            stringBuilder.append("\n  ]");
            return stringBuilder.toString();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
