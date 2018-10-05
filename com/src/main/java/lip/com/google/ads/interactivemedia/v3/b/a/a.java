package lip.com.google.ads.interactivemedia.v3.b.a;

import com.google.ads.interactivemedia.v3.api.Ad;
import com.google.ads.interactivemedia.v3.api.AdPodInfo;
import java.util.Arrays;

/* compiled from: IMASDK */
public final class a implements Ad {
    private String adId;
    private b adPodInfo = new b();
    private String adSystem;
    private String[] adWrapperIds;
    private String[] adWrapperSystems;
    private String clickThroughUrl;
    private double duration;
    private int height;
    private boolean linear;
    private String selectedMediaUrl;
    private boolean skippable;
    private String traffickingParameters;
    private int width;

    public final String getAdId() {
        return this.adId;
    }

    public final String getAdSystem() {
        return this.adSystem;
    }

    public final String[] getAdWrapperIds() {
        return this.adWrapperIds;
    }

    public final String[] getAdWrapperSystems() {
        return this.adWrapperSystems;
    }

    public final boolean isLinear() {
        return this.linear;
    }

    public final boolean isSkippable() {
        return this.skippable;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getTraffickingParameters() {
        return this.traffickingParameters;
    }

    public final String getClickThruUrl() {
        return this.clickThroughUrl;
    }

    public final double getDuration() {
        return this.duration;
    }

    public final AdPodInfo getAdPodInfo() {
        return this.adPodInfo;
    }

    public final String getSelectedMediaUrl() {
        return this.selectedMediaUrl;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (this.clickThroughUrl == null ? 0 : this.clickThroughUrl.hashCode()) + (((this.adPodInfo == null ? 0 : this.adPodInfo.hashCode()) + (((this.adId == null ? 0 : this.adId.hashCode()) + 31) * 31)) * 31);
        long doubleToLongBits = Double.doubleToLongBits(this.duration);
        hashCode = ((this.linear ? 1231 : 1237) + (((((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.height) * 31)) * 31;
        if (this.traffickingParameters != null) {
            i = this.traffickingParameters.hashCode();
        }
        return ((hashCode + i) * 31) + this.width;
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
        a aVar = (a) obj;
        if (this.adId == null) {
            if (aVar.adId != null) {
                return false;
            }
        } else if (!this.adId.equals(aVar.adId)) {
            return false;
        }
        if (this.adSystem == null) {
            if (aVar.adSystem != null) {
                return false;
            }
        } else if (!this.adSystem.equals(aVar.adSystem)) {
            return false;
        }
        if (this.adPodInfo == null) {
            if (aVar.adPodInfo != null) {
                return false;
            }
        } else if (!this.adPodInfo.equals(aVar.adPodInfo)) {
            return false;
        }
        if (this.clickThroughUrl == null) {
            if (aVar.clickThroughUrl != null) {
                return false;
            }
        } else if (!this.clickThroughUrl.equals(aVar.clickThroughUrl)) {
            return false;
        }
        if (Double.doubleToLongBits(this.duration) != Double.doubleToLongBits(aVar.duration)) {
            return false;
        }
        if (this.height != aVar.height) {
            return false;
        }
        if (this.linear != aVar.linear) {
            return false;
        }
        if (this.traffickingParameters == null) {
            if (aVar.traffickingParameters != null) {
                return false;
            }
        } else if (!this.traffickingParameters.equals(aVar.traffickingParameters)) {
            return false;
        }
        if (this.width != aVar.width) {
            return false;
        }
        return true;
    }

    public final String toString() {
        return "Ad [adId=" + this.adId + ", adWrapperIds=" + Arrays.toString(this.adWrapperIds) + ", adWrapperSystems=" + Arrays.toString(this.adWrapperSystems) + ", adSystem=" + this.adSystem + ", linear=" + this.linear + ", width=" + this.width + ", height=" + this.height + ", traffickingParameters=" + this.traffickingParameters + ", clickThroughUrl=" + this.clickThroughUrl + ", duration=" + this.duration + ", adPodInfo=" + this.adPodInfo + "]";
    }
}
