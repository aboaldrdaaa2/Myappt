package lip.com.cnative.tv;

import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest.Builder;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BannerAd implements IBannerAd {
    public static String TAG = "BannerAd";
    private TvCoreActivity m_activity;
    private PublisherAdView m_adView;
    private boolean m_adsinited = false;
    private Rect m_banner;
    private float m_density;
    private int m_handler = 0;
    private boolean m_lTestMode = false;
    private LinearLayout m_layout;
    private ReadWriteLock m_lock = new ReentrantReadWriteLock();
    private PopupWindow m_popUp;

    private class BannerAdListener extends AdListener {
        private BannerAdListener() {
        }

        /* synthetic */ BannerAdListener(BannerAd x0, AnonymousClass1 x1) {
            this();
        }

        public void onAdLoaded() {
            Log.i(BannerAd.TAG, "onAdLoaded " + BannerAd.this.m_adView.getWidth() + " x " + BannerAd.this.m_adView.getHeight() + " (" + BannerAd.this.getHandler() + ") ");
            BannerAd.this.onBannerLoaded(BannerAd.this.getHandler(), BannerAd.this.m_adView.getWidth(), BannerAd.this.m_adView.getHeight());
        }

        public void onAdFailedToLoad(int errorCode) {
            Log.e(BannerAd.TAG, String.format("onAdFailedToLoad (" + BannerAd.this.getHandler() + ") (%s)", new Object[]{getErrorReason(errorCode)}));
            BannerAd.this.onBannerFailed(BannerAd.this.getHandler());
        }

        public void onAdOpened() {
            Log.i(BannerAd.TAG, "onAdOpened (" + BannerAd.this.getHandler() + ")");
            BannerAd.this.onBannerOpened(BannerAd.this.getHandler());
        }

        public void onAdClosed() {
            Log.i(BannerAd.TAG, "onAdClosed (" + BannerAd.this.getHandler() + ")");
            BannerAd.this.onBannerClosed(BannerAd.this.getHandler());
        }

        public void onAdLeftApplication() {
            Log.i(BannerAd.TAG, "onAdLeftApplication (" + BannerAd.this.getHandler() + ")");
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

    public native void onBannerClosed(int i);

    public native void onBannerFailed(int i);

    public native void onBannerLoaded(int i, int i2, int i3);

    public native void onBannerOpened(int i);

    public BannerAd(TvCoreActivity activity, int handler) {
        Log.i(TAG, "Creating BannerAd (" + handler + ")");
        this.m_activity = activity;
        this.m_handler = handler;
        this.m_banner = new Rect(0, 0, 0, 0);
        DisplayMetrics metrics = new DisplayMetrics();
        this.m_activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        this.m_density = metrics.density;
    }

    public void show() {
        this.m_lock.writeLock().lock();
        Log.i(TAG, "show (" + this.m_handler + ")");
        try {
            if (!this.m_adsinited) {
                if (this.m_adView != null) {
                    this.m_activity.runOnUiThread(new Runnable() {
                        public void run() {
                            BannerAd.this.m_adsinited = true;
                            if (BannerAd.this.m_popUp == null) {
                                BannerAd.this.m_popUp = new PopupWindow(BannerAd.this.m_activity);
                                BannerAd.this.m_popUp.setWidth(((int) (((float) BannerAd.this.m_banner.width()) * BannerAd.this.m_density)) + 1);
                                BannerAd.this.m_popUp.setHeight(((int) (((float) BannerAd.this.m_banner.height()) * BannerAd.this.m_density)) + 1);
                                BannerAd.this.m_popUp.setWindowLayoutMode(-2, -2);
                                BannerAd.this.m_popUp.setClippingEnabled(false);
                                BannerAd.this.m_layout = new LinearLayout(BannerAd.this.m_activity);
                                BannerAd.this.m_layout.setPadding(-5, -5, -5, -5);
                                MarginLayoutParams params = new MarginLayoutParams(((int) (((float) BannerAd.this.m_banner.width()) * BannerAd.this.m_density)) + 1, ((int) (((float) BannerAd.this.m_banner.height()) * BannerAd.this.m_density)) + 1);
                                params.setMargins(0, 0, 0, 0);
                                BannerAd.this.m_layout.setOrientation(1);
                                BannerAd.this.m_layout.addView(BannerAd.this.m_adView, params);
                                BannerAd.this.m_popUp.setContentView(BannerAd.this.m_layout);
                            }
                            BannerAd.this.m_popUp.showAtLocation(BannerAd.this.m_activity.getMainLayout(), 0, BannerAd.this.m_banner.left, BannerAd.this.m_banner.top);
                            BannerAd.this.m_popUp.update();
                        }
                    });
                }
                this.m_lock.writeLock().unlock();
            }
        } catch (Throwable e) {
            Log.e(TAG, String.format("Show: Exception!!!", new Object[0]));
            e.printStackTrace();
        } finally {
            this.m_lock.writeLock().unlock();
        }
    }

    public void setPosition(int x, int y, int w, int h) {
        this.m_lock.writeLock().lock();
        try {
            this.m_banner.set(x, y, x + w, y + h);
            Log.i(TAG, "setPosition (" + this.m_handler + ") " + this.m_banner.left + "x" + this.m_banner.top + "x" + this.m_banner.width() + "x" + this.m_banner.height());
            if (this.m_adsinited) {
                this.m_activity.runOnUiThread(new Runnable() {
                    public void run() {
                        BannerAd.this.m_popUp.update(BannerAd.this.m_banner.left, BannerAd.this.m_banner.top, ((int) (((float) BannerAd.this.m_banner.width()) * BannerAd.this.m_density)) + 1, ((int) (((float) BannerAd.this.m_banner.height()) * BannerAd.this.m_density)) + 1);
                    }
                });
            }
            this.m_lock.writeLock().unlock();
        } catch (Throwable th) {
            this.m_lock.writeLock().unlock();
            throw th;
        }
    }

    public void hide() {
        this.m_lock.writeLock().lock();
        Log.i(TAG, "hide (" + this.m_handler + ")");
        try {
            if (this.m_adsinited) {
                this.m_activity.runOnUiThread(new Runnable() {
                    public void run() {
                        BannerAd.this.m_adsinited = false;
                        BannerAd.this.m_popUp.dismiss();
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
        this.m_lock.writeLock().lock();
        Log.i(TAG, "requestAd, mode: " + lTest + " (" + this.m_handler + ") " + this.m_banner.width() + " x " + this.m_banner.height());
        this.m_lTestMode = lTest;
        this.m_adView = new PublisherAdView(this.m_activity);
        this.m_adView.setAdUnitId(uid);
        this.m_adView.setAdSizes(new AdSize(this.m_banner.width(), this.m_banner.height()));
        try {
            this.m_activity.runOnUiThread(new Runnable() {
                public void run() {
                    BannerAd.this.m_adView.setAdListener(new BannerAdListener(BannerAd.this, null));
                    Builder builer = new Builder();
                    if (BannerAd.this.m_lTestMode) {
                        builer.addTestDevice("758A2037069C92340235DFD7FB42907A");
                    }
                    BannerAd.this.m_adView.loadAd(builer.build());
                }
            });
        } catch (Throwable e) {
            Log.e(TAG, String.format("Request: Exception!!!", new Object[0]));
            e.printStackTrace();
        } finally {
            this.m_lock.writeLock().unlock();
        }
    }

    public void stop() {
        Log.i(TAG, "stop");
        this.m_lock.writeLock().lock();
        this.m_handler = 0;
        this.m_lock.writeLock().unlock();
    }

    private int getHandler() {
        this.m_lock.readLock().lock();
        int handler = this.m_handler;
        this.m_lock.readLock().unlock();
        return handler;
    }
}
