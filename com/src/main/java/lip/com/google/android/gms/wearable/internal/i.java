package lip.com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

public class i implements DataItemAsset {
    private final String JL;
    private final String xG;

    public i(DataItemAsset dataItemAsset) {
        this.xG = dataItemAsset.getId();
        this.JL = dataItemAsset.getDataItemKey();
    }

    public String getDataItemKey() {
        return this.JL;
    }

    public String getId() {
        return this.xG;
    }

    public boolean isDataValid() {
        return true;
    }

    /* renamed from: nq */
    public DataItemAsset freeze() {
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetEntity[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.xG == null) {
            stringBuilder.append(",noid");
        } else {
            stringBuilder.append(",");
            stringBuilder.append(this.xG);
        }
        stringBuilder.append(", key=");
        stringBuilder.append(this.JL);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
