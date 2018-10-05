package lip.com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.eu;

public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
    private View n;
    private CustomEventBanner sW;
    private CustomEventInterstitial sX;

    private static final class a implements CustomEventBannerListener {
        private final MediationBannerListener l;
        private final CustomEventAdapter sY;

        public a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.sY = customEventAdapter;
            this.l = mediationBannerListener;
        }

        public void onAdClicked() {
            eu.z("Custom event adapter called onAdClicked.");
            this.l.onAdClicked(this.sY);
        }

        public void onAdClosed() {
            eu.z("Custom event adapter called onAdClosed.");
            this.l.onAdClosed(this.sY);
        }

        public void onAdFailedToLoad(int errorCode) {
            eu.z("Custom event adapter called onAdFailedToLoad.");
            this.l.onAdFailedToLoad(this.sY, errorCode);
        }

        public void onAdLeftApplication() {
            eu.z("Custom event adapter called onAdLeftApplication.");
            this.l.onAdLeftApplication(this.sY);
        }

        public void onAdLoaded(View view) {
            eu.z("Custom event adapter called onAdLoaded.");
            this.sY.a(view);
            this.l.onAdLoaded(this.sY);
        }

        public void onAdOpened() {
            eu.z("Custom event adapter called onAdOpened.");
            this.l.onAdOpened(this.sY);
        }
    }

    private class b implements CustomEventInterstitialListener {
        private final MediationInterstitialListener m;
        private final CustomEventAdapter sY;

        public b(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.sY = customEventAdapter;
            this.m = mediationInterstitialListener;
        }

        public void onAdClicked() {
            eu.z("Custom event adapter called onAdClicked.");
            this.m.onAdClicked(this.sY);
        }

        public void onAdClosed() {
            eu.z("Custom event adapter called onAdClosed.");
            this.m.onAdClosed(this.sY);
        }

        public void onAdFailedToLoad(int errorCode) {
            eu.z("Custom event adapter called onFailedToReceiveAd.");
            this.m.onAdFailedToLoad(this.sY, errorCode);
        }

        public void onAdLeftApplication() {
            eu.z("Custom event adapter called onAdLeftApplication.");
            this.m.onAdLeftApplication(this.sY);
        }

        public void onAdLoaded() {
            eu.z("Custom event adapter called onReceivedAd.");
            this.m.onAdLoaded(CustomEventAdapter.this);
        }

        public void onAdOpened() {
            eu.z("Custom event adapter called onAdOpened.");
            this.m.onAdOpened(this.sY);
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

    public View getBannerView() {
        return this.n;
    }

    public void onDestroy() {
        if (this.sW != null) {
            this.sW.onDestroy();
        }
        if (this.sX != null) {
            this.sX.onDestroy();
        }
    }

    public void onPause() {
        if (this.sW != null) {
            this.sW.onPause();
        }
        if (this.sX != null) {
            this.sX.onPause();
        }
    }

    public void onResume() {
        if (this.sW != null) {
            this.sW.onResume();
        }
        if (this.sX != null) {
            this.sX.onResume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener listener, Bundle serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle customEventExtras) {
        this.sW = (CustomEventBanner) a(serverParameters.getString("class_name"));
        if (this.sW == null) {
            listener.onAdFailedToLoad(this, 0);
            return;
        }
        this.sW.requestBannerAd(context, new a(this, listener), serverParameters.getString("parameter"), adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getBundle(serverParameters.getString("class_name")));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener listener, Bundle serverParameters, MediationAdRequest mediationAdRequest, Bundle customEventExtras) {
        this.sX = (CustomEventInterstitial) a(serverParameters.getString("class_name"));
        if (this.sX == null) {
            listener.onAdFailedToLoad(this, 0);
            return;
        }
        this.sX.requestInterstitialAd(context, new b(this, listener), serverParameters.getString("parameter"), mediationAdRequest, customEventExtras == null ? null : customEventExtras.getBundle(serverParameters.getString("class_name")));
    }

    public void showInterstitial() {
        this.sX.showInterstitial();
    }
}
