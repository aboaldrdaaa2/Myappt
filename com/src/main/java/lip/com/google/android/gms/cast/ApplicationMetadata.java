package lip.com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.hk;
import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata implements SafeParcelable {
    public static final Creator<ApplicationMetadata> CREATOR = new a();
    String mName;
    private final int xM;
    String zP;
    List<WebImage> zQ;
    List<String> zR;
    String zS;
    Uri zT;

    private ApplicationMetadata() {
        this.xM = 1;
        this.zQ = new ArrayList();
        this.zR = new ArrayList();
    }

    ApplicationMetadata(int versionCode, String applicationId, String name, List<WebImage> images, List<String> namespaces, String senderAppIdentifier, Uri senderAppLaunchUrl) {
        this.xM = versionCode;
        this.zP = applicationId;
        this.mName = name;
        this.zQ = images;
        this.zR = namespaces;
        this.zS = senderAppIdentifier;
        this.zT = senderAppLaunchUrl;
    }

    public boolean areNamespacesSupported(List<String> namespaces) {
        return this.zR != null && this.zR.containsAll(namespaces);
    }

    public Uri dX() {
        return this.zT;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationMetadata)) {
            return false;
        }
        ApplicationMetadata applicationMetadata = (ApplicationMetadata) obj;
        return gi.a(this.zP, applicationMetadata.zP) && gi.a(this.zQ, applicationMetadata.zQ) && gi.a(this.mName, applicationMetadata.mName) && gi.a(this.zR, applicationMetadata.zR) && gi.a(this.zS, applicationMetadata.zS) && gi.a(this.zT, applicationMetadata.zT);
    }

    public String getApplicationId() {
        return this.zP;
    }

    public List<WebImage> getImages() {
        return this.zQ;
    }

    public String getName() {
        return this.mName;
    }

    public String getSenderAppIdentifier() {
        return this.zS;
    }

    int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return hk.hashCode(Integer.valueOf(this.xM), this.zP, this.mName, this.zQ, this.zR, this.zS, this.zT);
    }

    public boolean isNamespaceSupported(String namespace) {
        return this.zR != null && this.zR.contains(namespace);
    }

    public String toString() {
        return this.mName;
    }

    public void writeToParcel(Parcel out, int flags) {
        a.a(this, out, flags);
    }
}
