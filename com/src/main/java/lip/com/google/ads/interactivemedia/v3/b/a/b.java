package lip.com.google.ads.interactivemedia.v3.b.a;

import com.google.ads.interactivemedia.v3.api.AdPodInfo;

/* compiled from: IMASDK */
public final class b implements AdPodInfo {
    public int adPosition = 1;
    public boolean isBumper = false;
    public int totalAds = 1;

    public final int getTotalAds() {
        return this.totalAds;
    }

    public final int getAdPosition() {
        return this.adPosition;
    }

    public final boolean isBumper() {
        return this.isBumper;
    }

    public final int hashCode() {
        return (((this.isBumper ? 1231 : 1237) + ((this.adPosition + 31) * 31)) * 31) + this.totalAds;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.adPosition != bVar.adPosition) {
            return false;
        }
        if (this.isBumper != bVar.isBumper) {
            return false;
        }
        if (this.totalAds != bVar.totalAds) {
            return false;
        }
        return true;
    }

    public final String toString() {
        return "AdPodInfo [totalAds=" + this.totalAds + ", adPosition=" + this.adPosition + ", isBumper=" + this.isBumper + "]";
    }
}
