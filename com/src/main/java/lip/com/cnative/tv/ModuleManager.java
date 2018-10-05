package lip.com.cnative.tv;

import android.util.Log;

public class ModuleManager {
    public static String TAG = "ModuleManager";

    static IPlayBilling CreatePlayBilling(TvCoreActivity activity) {
        Log.i(TAG, "Creating PlayBilling");
        return new PlayBilling(activity);
    }

    static IFacebookSN CreateFacebookSN(TvCoreActivity activity) {
        Log.i(TAG, "Creating FB");
        return new FacebookSN(activity);
    }

    static IVkSN CreateVkSN(TvCoreActivity activity) {
        Log.i(TAG, "Creating VK");
        return null;
    }

    static IBannerAd CreateBanner(TvCoreActivity activity, int handler) {
        Log.i(TAG, "Creating BannerAd");
        return new BannerAd(activity, handler);
    }

    static IIMA CreateIMA(TvCoreActivity activity, int handler, String language) {
        Log.i(TAG, "Creating IMA");
        return new IMA(activity, handler, language);
    }

    static IInterstitialAd CreateInterstitial(TvCoreActivity activity, int handler) {
        Log.i(TAG, "Creating InterstitialAd");
        return new InterstitialAd(activity, handler);
    }

    static IChromecast CreateChromecast(TvCoreActivity activity) {
        Log.i(TAG, "Creating Chromecast");
        return null;
    }

    static IGCMPushNotificator CreateGCM(TvCoreActivity activity) {
        Log.i(TAG, "Creating GCM");
        return new GCMPushNotificator(activity);
    }
}
