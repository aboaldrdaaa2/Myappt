package lip.com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

public final class av {
    private AdListener lQ;
    private InAppPurchaseListener mB;
    private PlayStorePurchaseListener mC;
    private final Context mContext;
    private AppEventListener mh;
    private String mj;
    private final bs mw;
    private final ak mx;
    private aq my;
    private String mz;

    public av(Context context) {
        this(context, ak.aF());
    }

    public av(Context context, ak akVar) {
        this.mw = new bs();
        this.mContext = context;
        this.mx = akVar;
    }

    private void k(String str) throws RemoteException {
        if (this.mj == null) {
            l(str);
        }
        this.my = ah.a(this.mContext, new al(), this.mj, this.mw);
        if (this.lQ != null) {
            this.my.a(new ag(this.lQ));
        }
        if (this.mh != null) {
            this.my.a(new an(this.mh));
        }
        if (this.mB != null) {
            this.my.a(new dh(this.mB));
        }
        if (this.mC != null) {
            this.my.a(new dl(this.mC), this.mz);
        }
    }

    private void l(String str) {
        if (this.my == null) {
            throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + str + " is called.");
        }
    }

    public void a(at atVar) {
        try {
            if (this.my == null) {
                k("loadAd");
            }
            if (this.my.a(this.mx.a(this.mContext, atVar))) {
                this.mw.c(atVar.aI());
            }
        } catch (Throwable e) {
            eu.c("Failed to load ad.", e);
        }
    }

    public AdListener getAdListener() {
        return this.lQ;
    }

    public String getAdUnitId() {
        return this.mj;
    }

    public AppEventListener getAppEventListener() {
        return this.mh;
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.mB;
    }

    public boolean isLoaded() {
        try {
            return this.my == null ? false : this.my.isReady();
        } catch (Throwable e) {
            eu.c("Failed to check if ad is ready.", e);
            return false;
        }
    }

    public void setAdListener(AdListener adListener) {
        try {
            this.lQ = adListener;
            if (this.my != null) {
                this.my.a(adListener != null ? new ag(adListener) : null);
            }
        } catch (Throwable e) {
            eu.c("Failed to set the AdListener.", e);
        }
    }

    public void setAdUnitId(String adUnitId) {
        if (this.mj != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.mj = adUnitId;
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.mh = appEventListener;
            if (this.my != null) {
                this.my.a(appEventListener != null ? new an(appEventListener) : null);
            }
        } catch (Throwable e) {
            eu.c("Failed to set the AppEventListener.", e);
        }
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        if (this.mC != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.mB = inAppPurchaseListener;
            if (this.my != null) {
                this.my.a(inAppPurchaseListener != null ? new dh(inAppPurchaseListener) : null);
            }
        } catch (Throwable e) {
            eu.c("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String publicKey) {
        try {
            this.mC = playStorePurchaseListener;
            if (this.my != null) {
                this.my.a(playStorePurchaseListener != null ? new dl(playStorePurchaseListener) : null, publicKey);
            }
        } catch (Throwable e) {
            eu.c("Failed to set the play store purchase parameter.", e);
        }
    }

    public void show() {
        try {
            l("show");
            this.my.showInterstitial();
        } catch (Throwable e) {
            eu.c("Failed to show interstitial.", e);
        }
    }
}
