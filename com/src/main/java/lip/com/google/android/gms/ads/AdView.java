package lip.com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.au;

public final class AdView extends ViewGroup {
    private final au kx;

    public AdView(Context context) {
        super(context);
        this.kx = new au(this);
    }

    public AdView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.kx = new au(this, attrs, false);
    }

    public AdView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.kx = new au(this, attrs, false);
    }

    public void destroy() {
        this.kx.destroy();
    }

    public AdListener getAdListener() {
        return this.kx.getAdListener();
    }

    public AdSize getAdSize() {
        return this.kx.getAdSize();
    }

    public String getAdUnitId() {
        return this.kx.getAdUnitId();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.kx.getInAppPurchaseListener();
    }

    public void loadAd(AdRequest adRequest) {
        this.kx.a(adRequest.T());
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i = ((right - left) - measuredWidth) / 2;
            int i2 = ((bottom - top) - measuredHeight) / 2;
            childAt.layout(i, i2, measuredWidth + i, measuredHeight + i2);
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredWidth;
        int i = 0;
        View childAt = getChildAt(0);
        AdSize adSize = getAdSize();
        if (childAt != null && childAt.getVisibility() != 8) {
            measureChild(childAt, widthMeasureSpec, heightMeasureSpec);
            measuredWidth = childAt.getMeasuredWidth();
            i = childAt.getMeasuredHeight();
        } else if (adSize != null) {
            Context context = getContext();
            measuredWidth = adSize.getWidthInPixels(context);
            i = adSize.getHeightInPixels(context);
        } else {
            measuredWidth = 0;
        }
        setMeasuredDimension(View.resolveSize(Math.max(measuredWidth, getSuggestedMinimumWidth()), widthMeasureSpec), View.resolveSize(Math.max(i, getSuggestedMinimumHeight()), heightMeasureSpec));
    }

    public void pause() {
        this.kx.pause();
    }

    public void resume() {
        this.kx.resume();
    }

    public void setAdListener(AdListener adListener) {
        this.kx.setAdListener(adListener);
    }

    public void setAdSize(AdSize adSize) {
        this.kx.setAdSizes(adSize);
    }

    public void setAdUnitId(String adUnitId) {
        this.kx.setAdUnitId(adUnitId);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        this.kx.setInAppPurchaseListener(inAppPurchaseListener);
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String publicKey) {
        this.kx.setPlayStorePurchaseParams(playStorePurchaseListener, publicKey);
    }
}
