package lip.com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;

public final class au {
    private AdListener lQ;
    private ViewGroup mA;
    private InAppPurchaseListener mB;
    private PlayStorePurchaseListener mC;
    private AppEventListener mh;
    private AdSize[] mi;
    private String mj;
    private final bs mw;
    private final ak mx;
    private aq my;
    private String mz;

    public au(ViewGroup viewGroup) {
        this(viewGroup, null, false, ak.aF());
    }

    public au(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, ak.aF());
    }

    au(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, ak akVar) {
        this.mw = new bs();
        this.mA = viewGroup;
        this.mx = akVar;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                ao aoVar = new ao(context, attributeSet);
                this.mi = aoVar.f(z);
                this.mj = aoVar.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    et.a(viewGroup, new al(context, this.mi[0]), "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                et.a(viewGroup, new al(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    private void aL() {
        try {
            d U = this.my.U();
            if (U != null) {
                this.mA.addView((View) e.e(U));
            }
        } catch (Throwable e) {
            eu.c("Failed to get an ad frame.", e);
        }
    }

    private void aM() throws RemoteException {
        if ((this.mi == null || this.mj == null) && this.my == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        Context context = this.mA.getContext();
        this.my = ah.a(context, new al(context, this.mi), this.mj, this.mw);
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
        aL();
    }

    public void a(at atVar) {
        try {
            if (this.my == null) {
                aM();
            }
            if (this.my.a(this.mx.a(this.mA.getContext(), atVar))) {
                this.mw.c(atVar.aI());
            }
        } catch (Throwable e) {
            eu.c("Failed to load ad.", e);
        }
    }

    public void a(AdSize... adSizeArr) {
        this.mi = adSizeArr;
        try {
            if (this.my != null) {
                this.my.a(new al(this.mA.getContext(), this.mi));
            }
        } catch (Throwable e) {
            eu.c("Failed to set the ad size.", e);
        }
        this.mA.requestLayout();
    }

    public void destroy() {
        try {
            if (this.my != null) {
                this.my.destroy();
            }
        } catch (Throwable e) {
            eu.c("Failed to destroy AdView.", e);
        }
    }

    public AdListener getAdListener() {
        return this.lQ;
    }

    public AdSize getAdSize() {
        try {
            if (this.my != null) {
                return this.my.V().aG();
            }
        } catch (Throwable e) {
            eu.c("Failed to get the current AdSize.", e);
        }
        return this.mi != null ? this.mi[0] : null;
    }

    public AdSize[] getAdSizes() {
        return this.mi;
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

    public void pause() {
        try {
            if (this.my != null) {
                this.my.pause();
            }
        } catch (Throwable e) {
            eu.c("Failed to call pause.", e);
        }
    }

    public void recordManualImpression() {
        try {
            this.my.ag();
        } catch (Throwable e) {
            eu.c("Failed to record impression.", e);
        }
    }

    public void resume() {
        try {
            if (this.my != null) {
                this.my.resume();
            }
        } catch (Throwable e) {
            eu.c("Failed to call resume.", e);
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

    public void setAdSizes(AdSize... adSizes) {
        if (this.mi != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        a(adSizes);
    }

    public void setAdUnitId(String adUnitId) {
        if (this.mj != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
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
        if (this.mB != null) {
            throw new IllegalStateException("InAppPurchaseListener has already been set.");
        }
        try {
            this.mC = playStorePurchaseListener;
            this.mz = publicKey;
            if (this.my != null) {
                this.my.a(playStorePurchaseListener != null ? new dl(playStorePurchaseListener) : null, publicKey);
            }
        } catch (Throwable e) {
            eu.c("Failed to set the play store purchase parameter.", e);
        }
    }
}
