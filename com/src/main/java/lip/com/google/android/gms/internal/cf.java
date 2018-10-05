package lip.com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.drive.DriveFile;

public class cf extends com.google.android.gms.internal.cn.a {
    private static final int of = Color.argb(0, 0, 0, 0);
    private ex lN;
    private final Activity og;
    private ch oh;
    private cj oi;
    private c oj;
    private ck ok;
    private boolean ol;
    private FrameLayout om;
    private CustomViewCallback on;
    private boolean oo = false;
    private boolean op = false;
    private boolean oq = false;
    private RelativeLayout or;

    private static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    private static final class b extends RelativeLayout {
        private final ep kI;

        public b(Context context, String str) {
            super(context);
            this.kI = new ep(context, str);
        }

        public boolean onInterceptTouchEvent(MotionEvent event) {
            this.kI.c(event);
            return false;
        }
    }

    private static final class c {
        public final int index;
        public final LayoutParams ot;
        public final ViewGroup ou;

        public c(ex exVar) throws a {
            this.ot = exVar.getLayoutParams();
            ViewParent parent = exVar.getParent();
            if (parent instanceof ViewGroup) {
                this.ou = (ViewGroup) parent;
                this.index = this.ou.indexOfChild(exVar);
                this.ou.removeView(exVar);
                exVar.q(true);
                return;
            }
            throw new a("Could not get the parent of the WebView for an overlay.");
        }
    }

    public cf(Activity activity) {
        this.og = activity;
    }

    private static RelativeLayout.LayoutParams a(int i, int i2, int i3, int i4) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        return layoutParams;
    }

    public static void a(Context context, ch chVar) {
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", chVar.kQ.sz);
        ch.a(intent, chVar);
        intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        if (!(context instanceof Activity)) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
        }
        context.startActivity(intent);
    }

    private void aT() {
        if (this.og.isFinishing() && !this.op) {
            this.op = true;
            if (this.og.isFinishing()) {
                if (this.lN != null) {
                    this.lN.bY();
                    this.or.removeView(this.lN);
                    if (this.oj != null) {
                        this.lN.q(false);
                        this.oj.ou.addView(this.lN, this.oj.index, this.oj.ot);
                    }
                }
                if (this.oh != null && this.oh.ox != null) {
                    this.oh.ox.Z();
                }
            }
        }
    }

    private void k(boolean z) throws a {
        if (!this.ol) {
            this.og.requestWindowFeature(1);
        }
        Window window = this.og.getWindow();
        if (!this.oq || this.oh.oH.ld) {
            window.setFlags(1024, 1024);
        }
        setRequestedOrientation(this.oh.orientation);
        if (VERSION.SDK_INT >= 11) {
            eu.z("Enabling hardware acceleration on the AdActivity window.");
            eq.a(window);
        }
        this.or = new b(this.og, this.oh.oG);
        if (this.oq) {
            this.or.setBackgroundColor(of);
        } else {
            this.or.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.og.setContentView(this.or);
        S();
        boolean cj = this.oh.oy.cb().cj();
        if (z) {
            this.lN = ex.a(this.og, this.oh.oy.V(), true, cj, null, this.oh.kQ);
            this.lN.cb().a(null, null, this.oh.oz, this.oh.oD, true, this.oh.oF);
            this.lN.cb().a(new com.google.android.gms.internal.ey.a() {
                public void a(ex exVar) {
                    exVar.bZ();
                }
            });
            if (this.oh.ob != null) {
                this.lN.loadUrl(this.oh.ob);
            } else if (this.oh.oC != null) {
                this.lN.loadDataWithBaseURL(this.oh.oA, this.oh.oC, "text/html", "UTF-8", null);
            } else {
                throw new a("No URL or HTML to display in ad overlay.");
            }
        }
        this.lN = this.oh.oy;
        this.lN.setContext(this.og);
        this.lN.a(this);
        ViewParent parent = this.lN.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.lN);
        }
        if (this.oq) {
            this.lN.setBackgroundColor(of);
        }
        this.or.addView(this.lN, -1, -1);
        if (!z) {
            this.lN.bZ();
        }
        i(cj);
    }

    public void S() {
        this.ol = true;
    }

    public void a(View view, CustomViewCallback customViewCallback) {
        this.om = new FrameLayout(this.og);
        this.om.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.om.addView(view, -1, -1);
        this.og.setContentView(this.om);
        S();
        this.on = customViewCallback;
    }

    public cj aQ() {
        return this.oi;
    }

    public void aR() {
        if (this.oh != null) {
            setRequestedOrientation(this.oh.orientation);
        }
        if (this.om != null) {
            this.og.setContentView(this.or);
            S();
            this.om.removeAllViews();
            this.om = null;
        }
        if (this.on != null) {
            this.on.onCustomViewHidden();
            this.on = null;
        }
    }

    public void aS() {
        this.or.removeView(this.ok);
        i(true);
    }

    public void b(int i, int i2, int i3, int i4) {
        if (this.oi != null) {
            this.oi.setLayoutParams(a(i, i2, i3, i4));
        }
    }

    public void c(int i, int i2, int i3, int i4) {
        if (this.oi == null) {
            this.oi = new cj(this.og, this.lN);
            this.or.addView(this.oi, 0, a(i, i2, i3, i4));
            this.lN.cb().r(false);
        }
    }

    public void close() {
        this.og.finish();
    }

    public void i(boolean z) {
        this.ok = new ck(this.og, z ? 50 : 32);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.ok.j(this.oh.oB);
        this.or.addView(this.ok, layoutParams);
    }

    public void j(boolean z) {
        if (this.ok != null) {
            this.ok.j(z);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean z = false;
        if (savedInstanceState != null) {
            z = savedInstanceState.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.oo = z;
        try {
            this.oh = ch.a(this.og.getIntent());
            if (this.oh == null) {
                throw new a("Could not get info for ad overlay.");
            }
            if (this.oh.oH != null) {
                this.oq = this.oh.oH.lb;
            } else {
                this.oq = false;
            }
            if (savedInstanceState == null) {
                if (this.oh.ox != null) {
                    this.oh.ox.aa();
                }
                if (!(this.oh.oE == 1 || this.oh.ow == null)) {
                    this.oh.ow.onAdClicked();
                }
            }
            switch (this.oh.oE) {
                case 1:
                    k(false);
                    return;
                case 2:
                    this.oj = new c(this.oh.oy);
                    k(false);
                    return;
                case 3:
                    k(true);
                    return;
                case 4:
                    if (this.oo) {
                        this.og.finish();
                        return;
                    } else if (!cc.a(this.og, this.oh.ov, this.oh.oD)) {
                        this.og.finish();
                        return;
                    } else {
                        return;
                    }
                default:
                    throw new a("Could not determine ad overlay type.");
            }
        } catch (a e) {
            eu.D(e.getMessage());
            this.og.finish();
        }
    }

    public void onDestroy() {
        if (this.oi != null) {
            this.oi.destroy();
        }
        if (this.lN != null) {
            this.or.removeView(this.lN);
        }
        aT();
    }

    public void onPause() {
        if (this.oi != null) {
            this.oi.pause();
        }
        aR();
        if (this.lN != null && (!this.og.isFinishing() || this.oj == null)) {
            eo.a(this.lN);
        }
        aT();
    }

    public void onRestart() {
    }

    public void onResume() {
        if (this.oh != null && this.oh.oE == 4) {
            if (this.oo) {
                this.og.finish();
            } else {
                this.oo = true;
            }
        }
        if (this.lN != null) {
            eo.b(this.lN);
        }
    }

    public void onSaveInstanceState(Bundle outBundle) {
        outBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.oo);
    }

    public void onStart() {
    }

    public void onStop() {
        aT();
    }

    public void setRequestedOrientation(int requestedOrientation) {
        this.og.setRequestedOrientation(requestedOrientation);
    }
}
