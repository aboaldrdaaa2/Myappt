package lip.com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

public final class ca<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final bv nT;

    public ca(bv bvVar) {
        this.nT = bvVar;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        eu.z("Adapter called onClick.");
        if (et.bW()) {
            try {
                this.nT.onAdClicked();
                return;
            } catch (Throwable e) {
                eu.c("Could not call onAdClicked.", e);
                return;
            }
        }
        eu.D("onClick must be called on the main UI thread.");
        et.sv.post(new Runnable() {
            public void run() {
                try {
                    ca.this.nT.onAdClicked();
                } catch (Throwable e) {
                    eu.c("Could not call onAdClicked.", e);
                }
            }
        });
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        eu.z("Adapter called onDismissScreen.");
        if (et.bW()) {
            try {
                this.nT.onAdClosed();
                return;
            } catch (Throwable e) {
                eu.c("Could not call onAdClosed.", e);
                return;
            }
        }
        eu.D("onDismissScreen must be called on the main UI thread.");
        et.sv.post(new Runnable() {
            public void run() {
                try {
                    ca.this.nT.onAdClosed();
                } catch (Throwable e) {
                    eu.c("Could not call onAdClosed.", e);
                }
            }
        });
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        eu.z("Adapter called onDismissScreen.");
        if (et.bW()) {
            try {
                this.nT.onAdClosed();
                return;
            } catch (Throwable e) {
                eu.c("Could not call onAdClosed.", e);
                return;
            }
        }
        eu.D("onDismissScreen must be called on the main UI thread.");
        et.sv.post(new Runnable() {
            public void run() {
                try {
                    ca.this.nT.onAdClosed();
                } catch (Throwable e) {
                    eu.c("Could not call onAdClosed.", e);
                }
            }
        });
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, final ErrorCode errorCode) {
        eu.z("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (et.bW()) {
            try {
                this.nT.onAdFailedToLoad(cb.a(errorCode));
                return;
            } catch (Throwable e) {
                eu.c("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        eu.D("onFailedToReceiveAd must be called on the main UI thread.");
        et.sv.post(new Runnable() {
            public void run() {
                try {
                    ca.this.nT.onAdFailedToLoad(cb.a(errorCode));
                } catch (Throwable e) {
                    eu.c("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, final ErrorCode errorCode) {
        eu.z("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (et.bW()) {
            try {
                this.nT.onAdFailedToLoad(cb.a(errorCode));
                return;
            } catch (Throwable e) {
                eu.c("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        eu.D("onFailedToReceiveAd must be called on the main UI thread.");
        et.sv.post(new Runnable() {
            public void run() {
                try {
                    ca.this.nT.onAdFailedToLoad(cb.a(errorCode));
                } catch (Throwable e) {
                    eu.c("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        eu.z("Adapter called onLeaveApplication.");
        if (et.bW()) {
            try {
                this.nT.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                eu.c("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        eu.D("onLeaveApplication must be called on the main UI thread.");
        et.sv.post(new Runnable() {
            public void run() {
                try {
                    ca.this.nT.onAdLeftApplication();
                } catch (Throwable e) {
                    eu.c("Could not call onAdLeftApplication.", e);
                }
            }
        });
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        eu.z("Adapter called onLeaveApplication.");
        if (et.bW()) {
            try {
                this.nT.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                eu.c("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        eu.D("onLeaveApplication must be called on the main UI thread.");
        et.sv.post(new Runnable() {
            public void run() {
                try {
                    ca.this.nT.onAdLeftApplication();
                } catch (Throwable e) {
                    eu.c("Could not call onAdLeftApplication.", e);
                }
            }
        });
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        eu.z("Adapter called onPresentScreen.");
        if (et.bW()) {
            try {
                this.nT.onAdOpened();
                return;
            } catch (Throwable e) {
                eu.c("Could not call onAdOpened.", e);
                return;
            }
        }
        eu.D("onPresentScreen must be called on the main UI thread.");
        et.sv.post(new Runnable() {
            public void run() {
                try {
                    ca.this.nT.onAdOpened();
                } catch (Throwable e) {
                    eu.c("Could not call onAdOpened.", e);
                }
            }
        });
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        eu.z("Adapter called onPresentScreen.");
        if (et.bW()) {
            try {
                this.nT.onAdOpened();
                return;
            } catch (Throwable e) {
                eu.c("Could not call onAdOpened.", e);
                return;
            }
        }
        eu.D("onPresentScreen must be called on the main UI thread.");
        et.sv.post(new Runnable() {
            public void run() {
                try {
                    ca.this.nT.onAdOpened();
                } catch (Throwable e) {
                    eu.c("Could not call onAdOpened.", e);
                }
            }
        });
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        eu.z("Adapter called onReceivedAd.");
        if (et.bW()) {
            try {
                this.nT.onAdLoaded();
                return;
            } catch (Throwable e) {
                eu.c("Could not call onAdLoaded.", e);
                return;
            }
        }
        eu.D("onReceivedAd must be called on the main UI thread.");
        et.sv.post(new Runnable() {
            public void run() {
                try {
                    ca.this.nT.onAdLoaded();
                } catch (Throwable e) {
                    eu.c("Could not call onAdLoaded.", e);
                }
            }
        });
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        eu.z("Adapter called onReceivedAd.");
        if (et.bW()) {
            try {
                this.nT.onAdLoaded();
                return;
            } catch (Throwable e) {
                eu.c("Could not call onAdLoaded.", e);
                return;
            }
        }
        eu.D("onReceivedAd must be called on the main UI thread.");
        et.sv.post(new Runnable() {
            public void run() {
                try {
                    ca.this.nT.onAdLoaded();
                } catch (Throwable e) {
                    eu.c("Could not call onAdLoaded.", e);
                }
            }
        });
    }
}
