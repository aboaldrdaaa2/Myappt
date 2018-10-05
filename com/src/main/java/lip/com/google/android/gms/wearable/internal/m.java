package lip.com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class m implements SafeParcelable, DataItem {
    public static final Creator<m> CREATOR = new n();
    private byte[] TF;
    private final Map<String, DataItemAsset> alK;
    private final Uri mUri;
    final int xM;

    m(int i, Uri uri, Bundle bundle, byte[] bArr) {
        this.xM = i;
        this.mUri = uri;
        Map hashMap = new HashMap();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (String str : bundle.keySet()) {
            hashMap.put(str, (DataItemAssetParcelable) bundle.getParcelable(str));
        }
        this.alK = hashMap;
        this.TF = bArr;
    }

    public int describeContents() {
        return 0;
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

    /* renamed from: m */
    public m setData(byte[] bArr) {
        this.TF = bArr;
        return this;
    }

    public Bundle nm() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (Entry entry : this.alK.entrySet()) {
            bundle.putParcelable((String) entry.getKey(), new DataItemAssetParcelable((DataItemAsset) entry.getValue()));
        }
        return bundle;
    }

    /* renamed from: ns */
    public m freeze() {
        return this;
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean verbose) {
        StringBuilder stringBuilder = new StringBuilder("DataItemParcelable[");
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

    public void writeToParcel(Parcel dest, int flags) {
        n.a(this, dest, flags);
    }
}
