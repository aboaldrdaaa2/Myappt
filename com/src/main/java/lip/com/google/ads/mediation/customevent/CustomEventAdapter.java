package lip.com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.eu;

public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View n;
    private CustomEventBanner o;
    private CustomEventInterstitial p;

    private static final class a implements CustomEventBannerListener {
        private final CustomEventAdapter q;
        private final MediationBannerListener r;

        public a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.q = customEventAdapter;
            this.r = mediationBannerListener;
        }

        public void onClick() {
            eu.z("Custom event adapter called onFailedToReceiveAd.");
            this.r.onClick(this.q);
        }

        public void onDismissScreen() {
            eu.z("Custom event adapter called onFailedToReceiveAd.");
            this.r.onDismissScreen(this.q);
        }

        public void onFailedToReceiveAd() {
            eu.z("Custom event adapter called onFailedToReceiveAd.");
            this.r.onFailedToReceiveAd(this.q, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            eu.z("Custom event adapter called onFailedToReceiveAd.");
            this.r.onLeaveApplication(this.q);
        }

        public void onPresentScreen() {
            eu.z("Custom event adapter called onFailedToReceiveAd.");
            this.r.onPresentScreen(this.q);
        }

        public void onReceivedAd(View view) {
            eu.z("Custom event adapter called onReceivedAd.");
            this.q.a(view);
            this.r.onReceivedAd(this.q);
        }
    }

    private class b implements CustomEventInterstitialListener {
        private final CustomEventAdapter q;
        private final MediationInterstitialListener s;

        public b(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.q = customEventAdapter;
            this.s = mediationInterstitialListener;
        }

        public void onDismissScreen() {
            eu.z("Custom event adapter called onDismissScreen.");
            this.s.onDismissScreen(this.q);
        }

        public void onFailedToReceiveAd() {
            eu.z("Custom event adapter called onFailedToReceiveAd.");
            this.s.onFailedToReceiveAd(this.q, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            eu.z("Custom event adapter called onLeaveApplication.");
            this.s.onLeaveApplication(this.q);
        }

        public void onPresentScreen() {
            eu.z("Custom event adapter called onPresentScreen.");
            this.s.onPresentScreen(this.q);
        }

        public void onReceivedAd() {
            eu.z("Custom event adapter called onReceivedAd.");
            this.s.onReceivedAd(CustomEventAdapter.this);
        }
    }

    private static <T> T a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            eu.D("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    private void a(View view) {
        this.n = view;
    }

    public void destroy() {
        if (this.o != null) {
            this.o.destroy();
        }
        if (this.p != null) {
            this.p.destroy();
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.n;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener listener, Activity activity, CustomEventServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.o = (CustomEventBanner) a(serverParameters.className);
        if (this.o == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.o.requestBannerAd(new a(this, listener), activity, serverParameters.label, serverParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener listener, Activity activity, CustomEventServerParameters serverParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.p = (CustomEventInterstitial) a(serverParameters.className);
        if (this.p == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.p.requestInterstitialAd(new b(this, listener), activity, serverParameters.label, serverParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void showInterstitial() {
        this.p.showInterstitial();
    }
}
