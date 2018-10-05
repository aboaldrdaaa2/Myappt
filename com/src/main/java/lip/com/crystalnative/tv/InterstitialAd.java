package lip.com.crystalnative.tv;

import android.util.Log;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest.Builder;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class InterstitialAd implements IInterstitialAd {
    public static String TAG = "InterstitialAd";
    private TvCoreActivity m_activity;
    private int m_handler = 0;
    private PublisherInterstitialAd m_interstitial;
    private boolean m_isLoaded = false;
    private boolean m_lTestMode = false;
    private ReadWriteLock m_lock = new ReentrantReadWriteLock();

    private class InterstitialAdListener extends AdListener {
        private InterstitialAdListener() {
        }

        /* synthetic */ InterstitialAdListener(InterstitialAd x0, AnonymousClass1 x1) {
            this();
        }

        public void onAdLoaded() {
            Log.i(InterstitialAd.TAG, "onAdLoaded()");
            InterstitialAd.this.setLoadState(true);
            InterstitialAd.this.onAdLoaded(InterstitialAd.this.getHandler());
        }

        public void onAdFailedToLoad(int errorCode) {
            Log.e(InterstitialAd.TAG, String.format("onAdFailedToLoad (%s)", new Object[]{getErrorReason(errorCode)}));
            InterstitialAd.this.setLoadState(false);
            InterstitialAd.this.onAdFailed(InterstitialAd.this.getHandler());
        }

        public void onAdOpened() {
            Log.i(InterstitialAd.TAG, "onAdOpened()");
            InterstitialAd.this.setLoadState(false);
            InterstitialAd.this.onAdOpened(InterstitialAd.this.getHandler());
        }

        public void onAdClosed() {
            Log.i(InterstitialAd.TAG, "onAdClosed");
            InterstitialAd.this.setLoadState(false);
            InterstitialAd.this.onAdClosed(InterstitialAd.this.getHandler());
        }

        public void onAdLeftApplication() {
            Log.i(InterstitialAd.TAG, "onAdLeftApplication");
        }

        private String getErrorReason(int errorCode) {
            switch (errorCode) {
                case 0:
                    return "Internal error";
                case 1:
                    return "Invalid request";
                case 2:
                    return "Network Error";
                case 3:
                    return "No fill";
                default:
                    return "Unknown error";
            }
        }
    }

    private class MyAppEventListener implements AppEventListener {
        private MyAppEventListener() {
        }

        /* synthetic */ MyAppEventListener(InterstitialAd x0, AnonymousClass1 x1) {
            this();
        }

        public void onAppEvent(String name, String data) {
            Log.i(InterstitialAd.TAG, "onAppEvent(): " + name);
        }
    }

    public native void onAdClosed(int i);

    public native void onAdFailed(int i);

    public native void onAdLoaded(int i);

    public native void onAdOpened(int i);

    public InterstitialAd(TvCoreActivity activity, int handler) {
        Log.i(TAG, "Creating InterstitialAd: (" + handler + ")");
        this.m_activity = activity;
        this.m_handler = handler;
        this.m_interstitial = new PublisherInterstitialAd(this.m_activity);
        this.m_activity.runOnUiThread(new Runnable() {
            public void run() {
                InterstitialAd.this.m_interstitial.setAdListener(new InterstitialAdListener(InterstitialAd.this, null));
                InterstitialAd.this.m_interstitial.setAppEventListener(new MyAppEventListener(InterstitialAd.this, null));
            }
        });
    }

    public void show() {
        this.m_lock.writeLock().lock();
        try {
            if (this.m_isLoaded) {
                this.m_isLoaded = false;
                Log.i(TAG, "show");
                this.m_activity.runOnUiThread(new Runnable() {
                    public void run() {
                        if (InterstitialAd.this.m_interstitial.isLoaded()) {
                            Log.d(InterstitialAd.TAG, "DFP: show interstitial");
                            InterstitialAd.this.m_interstitial.show();
                            return;
                        }
                        Log.d(InterstitialAd.TAG, "DFP hasn't loaded yet");
                    }
                });
            }
            this.m_lock.writeLock().unlock();
        } catch (Throwable th) {
            this.m_lock.writeLock().unlock();
            throw th;
        }
    }

    public void requestAd(String uid, boolean lTest) {
        Log.i(TAG, "requestAd, mode: " + lTest);
        this.m_lock.writeLock().lock();
        this.m_lTestMode = lTest;
        try {
            this.m_isLoaded = false;
            this.m_interstitial.setAdUnitId(uid);
            this.m_activity.runOnUiThread(new Runnable() {
                public void run() {
                    Builder builer = new Builder();
                    if (InterstitialAd.this.m_lTestMode) {
                        builer.addTestDevice("758A2037069C92340235DFD7FB42907A");
                    }
                    InterstitialAd.this.m_interstitial.loadAd(builer.build());
                }
            });
        } catch (Throwable e) {
            Log.e(TAG, String.format("Request: Exception!!!", new Object[0]));
            e.printStackTrace();
        } finally {
            this.m_lock.writeLock().unlock();
        }
    }

    public int isLoaded() {
        Log.i(TAG, "isLoaded?");
        this.m_lock.writeLock().lock();
        int rez = this.m_isLoaded ? 1 : 0;
        this.m_lock.writeLock().unlock();
        return rez;
    }

    public void stop() {
        Log.i(TAG, "stop");
        this.m_lock.writeLock().lock();
        this.m_handler = 0;
        this.m_lock.writeLock().unlock();
    }

    private void setLoadState(boolean state) {
        this.m_lock.readLock().lock();
        this.m_isLoaded = state;
        this.m_lock.readLock().unlock();
    }

    private int getHandler() {
        this.m_lock.readLock().lock();
        int handler = this.m_handler;
        this.m_lock.readLock().unlock();
        return handler;
    }
}
