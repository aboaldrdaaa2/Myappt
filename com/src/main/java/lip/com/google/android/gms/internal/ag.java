package lip.com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.ap.a;

public final class ag extends a {
    private final AdListener lQ;

    public ag(AdListener adListener) {
        this.lQ = adListener;
    }

    public void onAdClosed() {
        this.lQ.onAdClosed();
    }

    public void onAdFailedToLoad(int errorCode) {
        this.lQ.onAdFailedToLoad(errorCode);
    }

    public void onAdLeftApplication() {
        this.lQ.onAdLeftApplication();
    }

    public void onAdLoaded() {
        this.lQ.onAdLoaded();
    }

    public void onAdOpened() {
        this.lQ.onAdOpened();
    }
}
