package lip.com.google.ads.interactivemedia.v3.b;

import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent.AdErrorListener;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IMASDK */
public final class o {
    private final List<AdErrorListener> a = new ArrayList(1);

    public final void a(AdErrorListener adErrorListener) {
        this.a.add(adErrorListener);
    }

    public final void b(AdErrorListener adErrorListener) {
        this.a.remove(adErrorListener);
    }

    public final void a(AdErrorEvent adErrorEvent) {
        for (AdErrorListener onAdError : this.a) {
            onAdError.onAdError(adErrorEvent);
        }
    }
}
