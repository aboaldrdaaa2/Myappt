package lip.com.crystalnative.tv;

import android.app.NativeActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.LinearLayout;

public class TvCoreActivity extends NativeActivity {
    public static String TAG = "TvCoreActivity";
    private TvCoreActivity m_activity;
    private IPlayBilling m_billing = null;
    private IChromecast m_chromecast = null;
    private IFacebookSN m_facebook = null;
    private IGCMPushNotificator m_gcm = null;
    private LinearLayout m_mainLayout = null;
    private IVkSN m_vk = null;

    public static native int isRunning();

    static {
        System.loadLibrary("main");
    }

    public IInterstitialAd createInterstitialAd(int handler) {
        return ModuleManager.CreateInterstitial(this.m_activity, handler);
    }

    public IBannerAd createBannerAd(int handler) {
        return ModuleManager.CreateBanner(this.m_activity, handler);
    }

    public IIMA createImaAd(int handler, String language) {
        return ModuleManager.CreateIMA(this.m_activity, handler, language);
    }

    public IPlayBilling getPlayBilling() {
        Log.i(TAG, "getting PlayBilling");
        if (this.m_billing == null) {
            this.m_billing = ModuleManager.CreatePlayBilling(this.m_activity);
        }
        return this.m_billing;
    }

    public IGCMPushNotificator getGCM() {
        Log.i(TAG, "getting GCM");
        if (this.m_gcm == null) {
            this.m_gcm = ModuleManager.CreateGCM(this.m_activity);
        }
        return this.m_gcm;
    }

    public IFacebookSN getFacebookObject() {
        Log.i(TAG, "getting FacebookSN");
        if (this.m_facebook == null) {
            this.m_facebook = ModuleManager.CreateFacebookSN(this.m_activity);
        }
        return this.m_facebook;
    }

    public IVkSN getVkObject() {
        Log.i(TAG, "getting VkSN");
        if (this.m_vk == null) {
            this.m_vk = ModuleManager.CreateVkSN(this.m_activity);
            this.m_vk.Init();
            this.m_vk.onCreate(null);
        }
        return this.m_vk;
    }

    public IChromecast getCastObject() {
        Log.i(TAG, "getting Chromecast - " + (this.m_chromecast == null ? "null" : "not null"));
        return this.m_chromecast;
    }

    public float getDensity() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Log.i(TAG, "get density: " + metrics.density);
        return metrics.density;
    }

    public LinearLayout getMainLayout() {
        return this.m_mainLayout;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Creating TvCoreActivity - begin");
        this.m_activity = this;
        this.m_mainLayout = new LinearLayout(this.m_activity);
        this.m_activity.setContentView(this.m_mainLayout);
        if (this.m_vk != null) {
            this.m_vk.onCreate(savedInstanceState);
        }
        if (this.m_facebook != null) {
            this.m_facebook.onCreate(savedInstanceState);
        }
        if (this.m_chromecast == null) {
            this.m_chromecast = ModuleManager.CreateChromecast(this.m_activity);
        }
        Log.i(TAG, "Creating TvCoreActivity - end");
    }

    protected void onDestroy() {
        Log.i(TAG, "onDestroy");
        if (this.m_facebook != null) {
            this.m_facebook.onDestroy();
        }
        if (this.m_vk != null) {
            this.m_vk.onDestroy();
        }
        if (this.m_chromecast != null) {
            this.m_chromecast.onDestroy();
        }
        super.onDestroy();
    }

    public void onResume() {
        Log.i(TAG, "onResume");
        if (this.m_facebook != null) {
            this.m_facebook.onResume();
        }
        if (this.m_vk != null) {
            this.m_vk.onResume();
        }
        if (this.m_chromecast != null) {
            this.m_chromecast.onResume();
        }
        super.onResume();
        Log.i(TAG, "onResume - end");
    }

    public void onPause() {
        Log.i(TAG, "onPause");
        if (this.m_facebook != null) {
            this.m_facebook.onPause();
        }
        if (this.m_vk != null) {
            this.m_vk.onPause();
        }
        if (this.m_chromecast != null) {
            this.m_chromecast.onPause();
        }
        super.onPause();
    }

    public void onStop() {
        Log.i(TAG, "onStop");
        super.onStop();
    }

    public void onSaveInstanceState(Bundle outState) {
        Log.i(TAG, "onSaveInstanceState");
        if (this.m_facebook != null) {
            this.m_facebook.onSaveInstanceState(outState);
        }
        if (this.m_vk != null) {
            this.m_vk.onSaveInstanceState(outState);
        }
        super.onSaveInstanceState(outState);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i(TAG, "onActivityResult(" + requestCode + "," + resultCode + "," + data);
        if (this.m_facebook != null) {
            this.m_facebook.onActivityResult(requestCode, resultCode, data);
        }
        if (this.m_vk != null) {
            this.m_vk.onActivityResult(requestCode, resultCode, data);
        }
        if (this.m_billing == null || !this.m_billing.handleActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        if (this.m_chromecast == null || !this.m_chromecast.dispatchKeyEvent(event)) {
            return super.dispatchKeyEvent(event);
        }
        return true;
    }

    public static boolean isRunningApp() {
        return isRunning() == 1;
    }
}
