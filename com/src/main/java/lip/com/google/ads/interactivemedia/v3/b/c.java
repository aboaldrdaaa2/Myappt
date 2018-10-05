package lip.com.google.ads.interactivemedia.v3.b;

import com.google.ads.interactivemedia.v3.api.Ad;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent.AdEventType;

/* compiled from: IMASDK */
public final class c implements AdEvent {
    private AdEventType a;
    private Ad b;

    c(AdEventType adEventType, Ad ad) {
        this.a = adEventType;
        this.b = ad;
    }

    public final AdEventType getType() {
        return this.a;
    }

    public final Ad getAd() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.b == null) {
            if (cVar.b != null) {
                return false;
            }
        } else if (!this.b.equals(cVar.b)) {
            return false;
        }
        if (this.a != cVar.a) {
            return false;
        }
        return true;
    }

    public final String toString() {
        return String.format("AdEvent[type=%s, ad=%s]", new Object[]{this.a, this.b});
    }
}
