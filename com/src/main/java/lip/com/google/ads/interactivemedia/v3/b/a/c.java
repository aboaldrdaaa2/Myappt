package lip.com.google.ads.interactivemedia.v3.b.a;

/* compiled from: IMASDK */
public final class c {
    public String clickThroughUrl;
    public String companionId;
    public String size;
    public String src;
    public a type;

    /* compiled from: IMASDK */
    public enum a {
        Html,
        Static,
        IFrame
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
        c cVar = (c) obj;
        if (this.clickThroughUrl == null) {
            if (cVar.clickThroughUrl != null) {
                return false;
            }
        } else if (!this.clickThroughUrl.equals(cVar.clickThroughUrl)) {
            return false;
        }
        if (this.companionId != null && cVar.companionId != null && !this.companionId.equals(cVar.companionId)) {
            return false;
        }
        if (this.size == null) {
            if (cVar.size != null) {
                return false;
            }
        } else if (!this.size.equals(cVar.size)) {
            return false;
        }
        if (this.src == null) {
            if (cVar.src != null) {
                return false;
            }
            return true;
        } else if (this.src.equals(cVar.src)) {
            return true;
        } else {
            return false;
        }
    }

    public final String toString() {
        return "CompanionData [companionId=" + this.companionId + ", size=" + this.size + ", src=" + this.src + ", clickThroughUrl=" + this.clickThroughUrl + "]";
    }
}
