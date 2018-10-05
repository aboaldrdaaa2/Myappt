package lip.com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.lv;
import com.google.android.gms.internal.lv.a;
import com.google.android.gms.internal.me;

public class PutDataMapRequest {
    private final DataMap all = new DataMap();
    private final PutDataRequest alm;

    private PutDataMapRequest(PutDataRequest putDataRequest, DataMap dataMap) {
        this.alm = putDataRequest;
        if (dataMap != null) {
            this.all.putAll(dataMap);
        }
    }

    public static PutDataMapRequest create(String path) {
        return new PutDataMapRequest(PutDataRequest.create(path), null);
    }

    public static PutDataMapRequest createFromDataMapItem(DataMapItem source) {
        return new PutDataMapRequest(PutDataRequest.k(source.getUri()), source.getDataMap());
    }

    public static PutDataMapRequest createWithAutoAppendedId(String pathPrefix) {
        return new PutDataMapRequest(PutDataRequest.createWithAutoAppendedId(pathPrefix), null);
    }

    public PutDataRequest asPutDataRequest() {
        a a = lv.a(this.all);
        this.alm.setData(me.d(a.amp));
        int size = a.amq.size();
        int i = 0;
        while (i < size) {
            String num = Integer.toString(i);
            Asset asset = (Asset) a.amq.get(i);
            if (num == null) {
                throw new IllegalStateException("asset key cannot be null: " + asset);
            } else if (asset == null) {
                throw new IllegalStateException("asset cannot be null: key=" + num);
            } else {
                if (Log.isLoggable(DataMap.TAG, 3)) {
                    Log.d(DataMap.TAG, "asPutDataRequest: adding asset: " + num + " " + asset);
                }
                this.alm.putAsset(num, asset);
                i++;
            }
        }
        return this.alm;
    }

    public DataMap getDataMap() {
        return this.all;
    }

    public Uri getUri() {
        return this.alm.getUri();
    }
}
