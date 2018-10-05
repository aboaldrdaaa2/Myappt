package lip.com.cnative.tv;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.FrameLayout.LayoutParams;
import com.cnative.tv.adplayer.AdPlayer;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent.AdErrorListener;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent.AdEventListener;
import com.google.ads.interactivemedia.v3.api.AdsLoader;
import com.google.ads.interactivemedia.v3.api.AdsLoader.AdsLoadedListener;
import com.google.ads.interactivemedia.v3.api.AdsManager;
import com.google.ads.interactivemedia.v3.api.AdsManagerLoadedEvent;
import com.google.ads.interactivemedia.v3.api.AdsRequest;
import com.google.ads.interactivemedia.v3.api.ImaSdkFactory;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class IMA implements IIMA, AdErrorListener, AdsLoadedListener, AdEventListener {
    public static String TAG = "IMA";
    private TvCoreActivity m_activity;
    private AdsLoader m_adsLoader;
    private AdsManager m_adsManager;
    private boolean m_adsinited = false;
    private AdDisplayContainer m_container;
    private int m_handler = 0;
    private String m_language;
    private ReadWriteLock m_lock = new ReentrantReadWriteLock();
    private ImaSdkFactory m_sdkFactory;
    private IMA m_this;
    private ImaUIActivity m_uiActivity = null;
    private String m_url;
    private AdPlayer m_videoPlayer;

    public native void ImaAllCompleted(int i);

    public native void ImaClicked(int i);

    public native void ImaFailed(int i);

    public native void ImaPaused(int i);

    public native void ImaReady(int i);

    public native void ImaResumed(int i);

    public native void ImaStarted(int i);

    public native void ImaStopped(int i);

    public native void ImaTrackCompleted(int i);

    public native void ImaWillPlay(int i);

    public IMA(TvCoreActivity activity, int handler, String language) {
        Log.i(TAG, "Creating IMA: (" + handler + ")");
        this.m_this = this;
        this.m_activity = activity;
        this.m_handler = handler;
        this.m_language = language;
        this.m_sdkFactory = ImaSdkFactory.getInstance();
    }

    public void requestAd(String url) {
        this.m_url = url;
        this.m_activity.runOnUiThread(new Runnable() {
            public void run() {
                IMA.this.m_lock.writeLock().lock();
                try {
                    Log.i(IMA.TAG, "requestAd() - " + IMA.this.m_language);
                    if (IMA.this.m_adsLoader == null) {
                        ImaSdkSettings settings = IMA.this.m_sdkFactory.createImaSdkSettings();
                        settings.setLanguage(IMA.this.m_language);
                        IMA.this.m_adsLoader = IMA.this.m_sdkFactory.createAdsLoader(IMA.this.m_activity, settings);
                        IMA.this.m_adsLoader.contentComplete();
                        IMA.this.m_adsLoader.addAdErrorListener(IMA.this.m_this);
                        IMA.this.m_adsLoader.addAdsLoadedListener(IMA.this.m_this);
                    }
                    if (IMA.this.m_videoPlayer == null) {
                        IMA.this.m_videoPlayer = new AdPlayer(IMA.this.m_activity);
                        IMA.this.m_videoPlayer.setLayoutParams(new LayoutParams(-1, -1));
                        if (IMA.this.m_uiActivity != null && IMA.this.m_videoPlayer.getParent() == null) {
                            IMA.this.m_uiActivity.setPlayer(IMA.this.m_videoPlayer);
                        }
                    }
                    IMA.this.m_container = IMA.this.m_sdkFactory.createAdDisplayContainer();
                    IMA.this.m_container.setPlayer(IMA.this.m_videoPlayer);
                    IMA.this.m_container.setAdContainer(IMA.this.m_videoPlayer.getUiContainer());
                    AdsRequest request = IMA.this.m_sdkFactory.createAdsRequest();
                    request.setAdTagUrl(IMA.this.m_url);
                    request.setAdDisplayContainer(IMA.this.m_container);
                    IMA.this.m_adsLoader.requestAds(request);
                } catch (Throwable e) {
                    Log.e(IMA.TAG, String.format("requestAd: Exception!!!", new Object[0]));
                    e.printStackTrace();
                } finally {
                    IMA.this.m_lock.writeLock().unlock();
                }
            }
        });
    }

    private void show() {
        this.m_lock.writeLock().lock();
        try {
            if (!this.m_adsinited) {
                Log.i(TAG, "show()");
                this.m_adsinited = true;
                Intent startNewActivityOpen = new Intent(this.m_activity, ImaUIActivity.class);
                startNewActivityOpen.putExtra("IMA.Handler.ID", this.m_handler);
                this.m_activity.startActivity(startNewActivityOpen);
            }
            this.m_lock.writeLock().unlock();
        } catch (Throwable th) {
            this.m_lock.writeLock().unlock();
            throw th;
        }
    }

    private void hide() {
        this.m_lock.writeLock().lock();
        try {
            if (this.m_adsinited) {
                Log.i(TAG, "hide()");
                this.m_adsinited = false;
                if (this.m_uiActivity != null) {
                    this.m_uiActivity.setPlayer(null);
                }
                if (this.m_uiActivity != null) {
                    this.m_uiActivity.finish();
                }
                this.m_uiActivity = null;
            }
            this.m_lock.writeLock().unlock();
        } catch (Throwable th) {
            this.m_lock.writeLock().unlock();
            throw th;
        }
    }

    public void start() {
        this.m_lock.writeLock().lock();
        try {
            if (this.m_adsManager != null) {
                Log.i(TAG, "start()");
                this.m_adsManager.start();
            }
            this.m_lock.writeLock().unlock();
        } catch (Throwable th) {
            this.m_lock.writeLock().unlock();
            throw th;
        }
    }

    public void destroy() {
        hide();
        this.m_lock.writeLock().lock();
        try {
            if (this.m_adsLoader != null) {
                this.m_adsLoader.contentComplete();
                this.m_adsLoader = null;
            }
            if (this.m_adsManager != null) {
                Log.i(TAG, "destroy()");
                this.m_adsManager.destroy();
                this.m_adsManager = null;
            }
            this.m_lock.writeLock().unlock();
        } catch (Throwable th) {
            this.m_lock.writeLock().unlock();
            throw th;
        }
    }

    public void stop() {
        Log.i(TAG, "stop()");
        this.m_lock.writeLock().lock();
        this.m_handler = 0;
        this.m_lock.writeLock().unlock();
        destroy();
    }

    public void setImaUIActivity(Activity uiActivity) {
        Log.i(TAG, "setImaUIActivity()");
        this.m_lock.writeLock().lock();
        try {
            this.m_uiActivity = (ImaUIActivity) uiActivity;
            if (this.m_uiActivity != null && this.m_videoPlayer.getParent() == null) {
                this.m_uiActivity.setPlayer(this.m_videoPlayer);
            }
            this.m_lock.writeLock().unlock();
        } catch (Throwable th) {
            this.m_lock.writeLock().unlock();
            throw th;
        }
    }

    private int getHandler() {
        this.m_lock.readLock().lock();
        int handler = this.m_handler;
        this.m_lock.readLock().unlock();
        return handler;
    }

    public void onAdError(AdErrorEvent event) {
        Log.e(TAG, "onAdError (" + getHandler() + "): " + event.getError().getMessage());
        ImaFailed(getHandler());
        destroy();
    }

    public void onAdsManagerLoaded(AdsManagerLoadedEvent event) {
        Log.i(TAG, "onAdsManagerLoaded: success loaded");
        this.m_lock.writeLock().lock();
        try {
            this.m_adsManager = event.getAdsManager();
            this.m_adsManager.addAdErrorListener(this);
            this.m_adsManager.addAdEventListener(this);
            this.m_adsManager.init();
        } catch (Throwable e) {
            Log.e(TAG, String.format("onAdsManagerLoaded: Exception!!!", new Object[0]));
            e.printStackTrace();
        } finally {
            this.m_lock.writeLock().unlock();
        }
    }

    public void onAdEvent(AdEvent event) {
        switch (event.getType()) {
            case CONTENT_PAUSE_REQUESTED:
                Log.i(TAG, "onAdEvent: content paused");
                ImaWillPlay(getHandler());
                show();
                return;
            case CONTENT_RESUME_REQUESTED:
                Log.i(TAG, "onAdEvent: content resumed");
                ImaStopped(getHandler());
                hide();
                return;
            case LOADED:
                Log.i(TAG, "onAdEvent: LOADED");
                ImaReady(getHandler());
                return;
            case STARTED:
                Log.i(TAG, "onAdEvent: STARTED");
                ImaStarted(getHandler());
                return;
            case FIRST_QUARTILE:
                Log.i(TAG, "onAdEvent: FIRST_QUARTILE");
                return;
            case MIDPOINT:
                Log.i(TAG, "onAdEvent: MIDPOINT");
                return;
            case THIRD_QUARTILE:
                Log.i(TAG, "onAdEvent: THIRD_QUARTILE");
                return;
            case COMPLETED:
                Log.i(TAG, "onAdEvent: COMPLETED");
                ImaTrackCompleted(getHandler());
                return;
            case ALL_ADS_COMPLETED:
                Log.i(TAG, "onAdEvent: ALL_ADS_COMPLETED (" + getHandler() + ")");
                ImaTrackCompleted(getHandler());
                return;
            case PAUSED:
                Log.i(TAG, "onAdEvent: PAUSED");
                ImaPaused(getHandler());
                return;
            case RESUMED:
                Log.i(TAG, "onAdEvent: RESUMED");
                ImaResumed(getHandler());
                return;
            case CLICKED:
                Log.i(TAG, "onAdEvent: CLICKED");
                ImaClicked(getHandler());
                return;
            case SKIPPED:
                Log.i(TAG, "onAdEvent: SKIPPED");
                return;
            default:
                Log.e(TAG, "onAdEvent: different event");
                return;
        }
    }
}
