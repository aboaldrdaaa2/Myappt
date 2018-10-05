package lip.com.google.android.gms.internal;

import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

public final class by implements MediationBannerListener, MediationInterstitialListener {
    private final bv nT;

    public by(bv bvVar) {
        this.nT = bvVar;
    }

    public void onAdClicked(MediationBannerAdapter adapter) {
        hm.ay("onAdClicked must be called on the main UI thread.");
        eu.z("Adapter called onAdClicked.");
        try {
            this.nT.onAdClicked();
        } catch (Throwable e) {
            eu.c("Could not call onAdClicked.", e);
        }
    }

    public void onAdClicked(MediationInterstitialAdapter adapter) {
        hm.ay("onAdClicked must be called on the main UI thread.");
        eu.z("Adapter called onAdClicked.");
        try {
            this.nT.onAdClicked();
        } catch (Throwable e) {
            eu.c("Could not call onAdClicked.", e);
        }
    }

    public void onAdClosed(MediationBannerAdapter adapter) {
        hm.ay("onAdClosed must be called on the main UI thread.");
        eu.z("Adapter called onAdClosed.");
        try {
            this.nT.onAdClosed();
        } catch (Throwable e) {
            eu.c("Could not call onAdClosed.", e);
        }
    }

    public void onAdClosed(MediationInterstitialAdapter adapter) {
        hm.ay("onAdClosed must be called on the main UI thread.");
        eu.z("Adapter called onAdClosed.");
        try {
            this.nT.onAdClosed();
        } catch (Throwable e) {
            eu.c("Could not call onAdClosed.", e);
        }
    }

    public void onAdFailedToLoad(MediationBannerAdapter adapter, int errorCode) {
        hm.ay("onAdFailedToLoad must be called on the main UI thread.");
        eu.z("Adapter called onAdFailedToLoad with error. " + errorCode);
        try {
            this.nT.onAdFailedToLoad(errorCode);
        } catch (Throwable e) {
            eu.c("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdFailedToLoad(MediationInterstitialAdapter adapter, int errorCode) {
        hm.ay("onAdFailedToLoad must be called on the main UI thread.");
        eu.z("Adapter called onAdFailedToLoad with error " + errorCode + ".");
        try {
            this.nT.onAdFailedToLoad(errorCode);
        } catch (Throwable e) {
            eu.c("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdLeftApplication(MediationBannerAdapter adapter) {
        hm.ay("onAdLeftApplication must be called on the main UI thread.");
        eu.z("Adapter called onAdLeftApplication.");
        try {
            this.nT.onAdLeftApplication();
        } catch (Throwable e) {
            eu.c("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLeftApplication(MediationInterstitialAdapter adapter) {
        hm.ay("onAdLeftApplication must be called on the main UI thread.");
        eu.z("Adapter called onAdLeftApplication.");
        try {
            this.nT.onAdLeftApplication();
        } catch (Throwable e) {
            eu.c("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLoaded(MediationBannerAdapter adapter) {
        hm.ay("onAdLoaded must be called on the main UI thread.");
        eu.z("Adapter called onAdLoaded.");
        try {
            this.nT.onAdLoaded();
        } catch (Throwable e) {
            eu.c("Could not call onAdLoaded.", e);
        }
    }

    public void onAdLoaded(MediationInterstitialAdapter adapter) {
        hm.ay("onAdLoaded must be called on the main UI thread.");
        eu.z("Adapter called onAdLoaded.");
        try {
            this.nT.onAdLoaded();
        } catch (Throwable e) {
            eu.c("Could not call onAdLoaded.", e);
        }
    }

    public void onAdOpened(MediationBannerAdapter adapter) {
        hm.ay("onAdOpened must be called on the main UI thread.");
        eu.z("Adapter called onAdOpened.");
        try {
            this.nT.onAdOpened();
        } catch (Throwable e) {
            eu.c("Could not call onAdOpened.", e);
        }
    }

    public void onAdOpened(MediationInterstitialAdapter adapter) {
        hm.ay("onAdOpened must be called on the main UI thread.");
        eu.z("Adapter called onAdOpened.");
        try {
            this.nT.onAdOpened();
        } catch (Throwable e) {
            eu.c("Could not call onAdOpened.", e);
        }
    }
}
