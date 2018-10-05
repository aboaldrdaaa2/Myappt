package lip.com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;

public class Asset implements SafeParcelable {
    public static final Creator<Asset> CREATOR = new a();
    private byte[] TF;
    private String alg;
    public ParcelFileDescriptor alh;
    public Uri uri;
    final int xM;

    Asset(int versionCode, byte[] data, String digest, ParcelFileDescriptor fd, Uri uri) {
        this.xM = versionCode;
        this.TF = data;
        this.alg = digest;
        this.alh = fd;
        this.uri = uri;
    }

    public static Asset createFromBytes(byte[] assetData) {
        if (assetData != null) {
            return new Asset(1, assetData, null, null, null);
        }
        throw new IllegalArgumentException("Asset data cannot be null");
    }

    public static Asset createFromFd(ParcelFileDescriptor fd) {
        if (fd != null) {
            return new Asset(1, null, null, fd, null);
        }
        throw new IllegalArgumentException("Asset fd cannot be null");
    }

    public static Asset createFromRef(String digest) {
        if (digest != null) {
            return new Asset(1, null, digest, null, null);
        }
        throw new IllegalArgumentException("Asset digest cannot be null");
    }

    public static Asset createFromUri(Uri uri) {
        if (uri != null) {
            return new Asset(1, null, null, null, uri);
        }
        throw new IllegalArgumentException("Asset uri cannot be null");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Asset)) {
            return false;
        }
        Asset asset = (Asset) o;
        return hk.equal(this.TF, asset.TF) && hk.equal(this.alg, asset.alg) && hk.equal(this.alh, asset.alh) && hk.equal(this.uri, asset.uri);
    }

    public byte[] getData() {
        return this.TF;
    }

    public String getDigest() {
        return this.alg;
    }

    public ParcelFileDescriptor getFd() {
        return this.alh;
    }

    public Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        return hk.hashCode(this.TF, this.alg, this.alh, this.uri);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Asset[@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.alg == null) {
            stringBuilder.append(", nodigest");
        } else {
            stringBuilder.append(", ");
            stringBuilder.append(this.alg);
        }
        if (this.TF != null) {
            stringBuilder.append(", size=");
            stringBuilder.append(this.TF.length);
        }
        if (this.alh != null) {
            stringBuilder.append(", fd=");
            stringBuilder.append(this.alh);
        }
        if (this.uri != null) {
            stringBuilder.append(", uri=");
            stringBuilder.append(this.uri);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        a.a(this, dest, flags | 1);
    }
}
