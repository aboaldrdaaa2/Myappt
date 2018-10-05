package lip.com.google.ads.interactivemedia.v3.b;

import com.google.ads.interactivemedia.v3.api.AdsRenderingSettings;
import java.util.List;

/* compiled from: IMASDK */
public final class i implements AdsRenderingSettings {
    private int a = -1;
    private List<String> b = null;

    public final int getBitrateKbps() {
        return this.a;
    }

    public final void setBitrateKbps(int bitrate) {
        this.a = bitrate;
    }

    public final List<String> getMimeTypes() {
        return this.b;
    }

    public final void setMimeTypes(List<String> mimeTypes) {
        this.b = mimeTypes;
    }

    public final String toString() {
        return "AdsRenderingSettings [bitrate=" + this.a + ", mimeTypes=" + this.b + "]";
    }
}
