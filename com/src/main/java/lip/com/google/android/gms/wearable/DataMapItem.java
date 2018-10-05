package lip.com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.internal.lv;
import com.google.android.gms.internal.lv.a;
import com.google.android.gms.internal.lw;
import com.google.android.gms.internal.md;
import java.util.ArrayList;
import java.util.List;

public class DataMapItem {
    private final DataMap all;
    private final Uri mUri;

    private DataMapItem(DataItem source) {
        this.mUri = source.getUri();
        this.all = a((DataItem) source.freeze());
    }

    private DataMap a(DataItem dataItem) {
        if (dataItem.getData() == null && dataItem.getAssets().size() > 0) {
            throw new IllegalArgumentException("Cannot create DataMapItem from a DataItem  that wasn't made with DataMapItem.");
        } else if (dataItem.getData() == null) {
            return new DataMap();
        } else {
            try {
                List arrayList = new ArrayList();
                int size = dataItem.getAssets().size();
                for (int i = 0; i < size; i++) {
                    DataItemAsset dataItemAsset = (DataItemAsset) dataItem.getAssets().get(Integer.toString(i));
                    if (dataItemAsset == null) {
                        throw new IllegalStateException("Cannot find DataItemAsset referenced in data at " + i + " for " + dataItem);
                    }
                    arrayList.add(Asset.createFromRef(dataItemAsset.getId()));
                }
                return lv.a(new a(lw.n(dataItem.getData()), arrayList));
            } catch (md e) {
                throw new IllegalStateException("Unable to parse. Not a DataItem.");
            }
        }
    }

    public static DataMapItem fromDataItem(DataItem dataItem) {
        if (dataItem != null) {
            return new DataMapItem(dataItem);
        }
        throw new IllegalStateException("provided dataItem is null");
    }

    public DataMap getDataMap() {
        return this.all;
    }

    public Uri getUri() {
        return this.mUri;
    }
}
