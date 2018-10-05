package lip.com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.drive.DriveFile;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ex extends WebView implements DownloadListener {
    private final WindowManager lC;
    private final Object ls = new Object();
    private al nF;
    private final ev nG;
    private final k pA;
    private final ey sA;
    private final a sB;
    private cf sC;
    private boolean sD;
    private boolean sE;
    private boolean sF;

    private static class a extends MutableContextWrapper {
        private Context lz;
        private Activity sG;

        public a(Context context) {
            super(context);
            setBaseContext(context);
        }

        public Context cf() {
            return this.sG;
        }

        public void setBaseContext(Context base) {
            this.lz = base.getApplicationContext();
            this.sG = base instanceof Activity ? (Activity) base : null;
            super.setBaseContext(this.lz);
        }

        public void startActivity(Intent intent) {
            if (this.sG != null) {
                this.sG.startActivity(intent);
                return;
            }
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            this.lz.startActivity(intent);
        }
    }

    private ex(a aVar, al alVar, boolean z, boolean z2, k kVar, ev evVar) {
        super(aVar);
        this.sB = aVar;
        this.nF = alVar;
        this.sD = z;
        this.pA = kVar;
        this.nG = evVar;
        this.lC = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        eo.a((Context) aVar, evVar.sw, settings);
        if (VERSION.SDK_INT >= 17) {
            er.a(getContext(), settings);
        } else if (VERSION.SDK_INT >= 11) {
            eq.a(getContext(), settings);
        }
        setDownloadListener(this);
        if (VERSION.SDK_INT >= 11) {
            this.sA = new fa(this, z2);
        } else {
            this.sA = new ey(this, z2);
        }
        setWebViewClient(this.sA);
        if (VERSION.SDK_INT >= 14) {
            setWebChromeClient(new fb(this));
        } else if (VERSION.SDK_INT >= 11) {
            setWebChromeClient(new ez(this));
        }
        cg();
    }

    public static ex a(Context context, al alVar, boolean z, boolean z2, k kVar, ev evVar) {
        return new ex(new a(context), alVar, z, z2, kVar, evVar);
    }

    private void cg() {
        synchronized (this.ls) {
            if (this.sD || this.nF.mf) {
                if (VERSION.SDK_INT < 14) {
                    eu.z("Disabling hardware acceleration on an overlay.");
                    ch();
                } else {
                    eu.z("Enabling hardware acceleration on an overlay.");
                    ci();
                }
            } else if (VERSION.SDK_INT < 18) {
                eu.z("Disabling hardware acceleration on an AdView.");
                ch();
            } else {
                eu.z("Enabling hardware acceleration on an AdView.");
                ci();
            }
        }
    }

    private void ch() {
        synchronized (this.ls) {
            if (!this.sE && VERSION.SDK_INT >= 11) {
                eq.d(this);
            }
            this.sE = true;
        }
    }

    private void ci() {
        synchronized (this.ls) {
            if (this.sE && VERSION.SDK_INT >= 11) {
                eq.e(this);
            }
            this.sE = false;
        }
    }

    protected void E(String str) {
        synchronized (this.ls) {
            if (isDestroyed()) {
                eu.D("The webview is destroyed. Ignoring action.");
            } else {
                loadUrl(str);
            }
        }
    }

    public al V() {
        al alVar;
        synchronized (this.ls) {
            alVar = this.nF;
        }
        return alVar;
    }

    public void a(Context context, al alVar) {
        synchronized (this.ls) {
            this.sB.setBaseContext(context);
            this.sC = null;
            this.nF = alVar;
            this.sD = false;
            eo.b((WebView) this);
            loadUrl("about:blank");
            this.sA.reset();
        }
    }

    public void a(al alVar) {
        synchronized (this.ls) {
            this.nF = alVar;
            requestLayout();
        }
    }

    public void a(cf cfVar) {
        synchronized (this.ls) {
            this.sC = cfVar;
        }
    }

    public void a(String str, Map<String, ?> map) {
        try {
            b(str, eo.o((Map) map));
        } catch (JSONException e) {
            eu.D("Could not convert parameters to JSON.");
        }
    }

    public void a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:" + str + "(");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        E(stringBuilder.toString());
    }

    public void b(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:AFMA_ReceiveMessage('");
        stringBuilder.append(str);
        stringBuilder.append("'");
        stringBuilder.append(",");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        eu.C("Dispatching AFMA event: " + stringBuilder);
        E(stringBuilder.toString());
    }

    public void bX() {
        if (cb().cj()) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display defaultDisplay = this.lC.getDefaultDisplay();
            defaultDisplay.getMetrics(displayMetrics);
            float f = 160.0f / ((float) displayMetrics.densityDpi);
            try {
                b("onScreenInfoChanged", new JSONObject().put(MMLayout.KEY_WIDTH, (int) (((float) displayMetrics.widthPixels) * f)).put(MMLayout.KEY_HEIGHT, (int) (((float) (displayMetrics.heightPixels - eo.p(getContext()))) * f)).put("density", (double) displayMetrics.density).put("rotation", defaultDisplay.getRotation()));
            } catch (Throwable e) {
                eu.b("Error occured while obtaining screen information.", e);
            }
        }
    }

    public void bY() {
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.nG.sw);
        a("onhide", hashMap);
    }

    public void bZ() {
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.nG.sw);
        a("onshow", hashMap);
    }

    public cf ca() {
        cf cfVar;
        synchronized (this.ls) {
            cfVar = this.sC;
        }
        return cfVar;
    }

    public ey cb() {
        return this.sA;
    }

    public k cc() {
        return this.pA;
    }

    public ev cd() {
        return this.nG;
    }

    public boolean ce() {
        boolean z;
        synchronized (this.ls) {
            z = this.sD;
        }
        return z;
    }

    public Context cf() {
        return this.sB.cf();
    }

    public void destroy() {
        synchronized (this.ls) {
            super.destroy();
            this.sF = true;
        }
    }

    public boolean isDestroyed() {
        boolean z;
        synchronized (this.ls) {
            z = this.sF;
        }
        return z;
    }

    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long size) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(url), mimeType);
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            eu.z("Couldn't find an Activity to view url/mimetype: " + url + " / " + mimeType);
        }
    }

    /* JADX WARNING: Missing block: B:35:?, code:
            return;
     */
    protected void onMeasure(int r10, int r11) {
        /*
        r9 = this;
        r0 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r8 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = 8;
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r4 = r9.ls;
        monitor-enter(r4);
        r1 = r9.isInEditMode();	 Catch:{ all -> 0x00ae }
        if (r1 != 0) goto L_0x0016;
    L_0x0012:
        r1 = r9.sD;	 Catch:{ all -> 0x00ae }
        if (r1 == 0) goto L_0x001b;
    L_0x0016:
        super.onMeasure(r10, r11);	 Catch:{ all -> 0x00ae }
        monitor-exit(r4);	 Catch:{ all -> 0x00ae }
    L_0x001a:
        return;
    L_0x001b:
        r2 = android.view.View.MeasureSpec.getMode(r10);	 Catch:{ all -> 0x00ae }
        r3 = android.view.View.MeasureSpec.getSize(r10);	 Catch:{ all -> 0x00ae }
        r5 = android.view.View.MeasureSpec.getMode(r11);	 Catch:{ all -> 0x00ae }
        r1 = android.view.View.MeasureSpec.getSize(r11);	 Catch:{ all -> 0x00ae }
        if (r2 == r6) goto L_0x002f;
    L_0x002d:
        if (r2 != r8) goto L_0x00c7;
    L_0x002f:
        r2 = r3;
    L_0x0030:
        if (r5 == r6) goto L_0x0034;
    L_0x0032:
        if (r5 != r8) goto L_0x0035;
    L_0x0034:
        r0 = r1;
    L_0x0035:
        r5 = r9.nF;	 Catch:{ all -> 0x00ae }
        r5 = r5.widthPixels;	 Catch:{ all -> 0x00ae }
        if (r5 > r2) goto L_0x0041;
    L_0x003b:
        r2 = r9.nF;	 Catch:{ all -> 0x00ae }
        r2 = r2.heightPixels;	 Catch:{ all -> 0x00ae }
        if (r2 <= r0) goto L_0x00b1;
    L_0x0041:
        r0 = r9.sB;	 Catch:{ all -> 0x00ae }
        r0 = r0.getResources();	 Catch:{ all -> 0x00ae }
        r0 = r0.getDisplayMetrics();	 Catch:{ all -> 0x00ae }
        r0 = r0.density;	 Catch:{ all -> 0x00ae }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ae }
        r2.<init>();	 Catch:{ all -> 0x00ae }
        r5 = "Not enough space to show ad. Needs ";
        r2 = r2.append(r5);	 Catch:{ all -> 0x00ae }
        r5 = r9.nF;	 Catch:{ all -> 0x00ae }
        r5 = r5.widthPixels;	 Catch:{ all -> 0x00ae }
        r5 = (float) r5;	 Catch:{ all -> 0x00ae }
        r5 = r5 / r0;
        r5 = (int) r5;	 Catch:{ all -> 0x00ae }
        r2 = r2.append(r5);	 Catch:{ all -> 0x00ae }
        r5 = "x";
        r2 = r2.append(r5);	 Catch:{ all -> 0x00ae }
        r5 = r9.nF;	 Catch:{ all -> 0x00ae }
        r5 = r5.heightPixels;	 Catch:{ all -> 0x00ae }
        r5 = (float) r5;	 Catch:{ all -> 0x00ae }
        r5 = r5 / r0;
        r5 = (int) r5;	 Catch:{ all -> 0x00ae }
        r2 = r2.append(r5);	 Catch:{ all -> 0x00ae }
        r5 = " dp, but only has ";
        r2 = r2.append(r5);	 Catch:{ all -> 0x00ae }
        r3 = (float) r3;	 Catch:{ all -> 0x00ae }
        r3 = r3 / r0;
        r3 = (int) r3;	 Catch:{ all -> 0x00ae }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00ae }
        r3 = "x";
        r2 = r2.append(r3);	 Catch:{ all -> 0x00ae }
        r1 = (float) r1;	 Catch:{ all -> 0x00ae }
        r0 = r1 / r0;
        r0 = (int) r0;	 Catch:{ all -> 0x00ae }
        r0 = r2.append(r0);	 Catch:{ all -> 0x00ae }
        r1 = " dp.";
        r0 = r0.append(r1);	 Catch:{ all -> 0x00ae }
        r0 = r0.toString();	 Catch:{ all -> 0x00ae }
        com.google.android.gms.internal.eu.D(r0);	 Catch:{ all -> 0x00ae }
        r0 = r9.getVisibility();	 Catch:{ all -> 0x00ae }
        if (r0 == r7) goto L_0x00a6;
    L_0x00a2:
        r0 = 4;
        r9.setVisibility(r0);	 Catch:{ all -> 0x00ae }
    L_0x00a6:
        r0 = 0;
        r1 = 0;
        r9.setMeasuredDimension(r0, r1);	 Catch:{ all -> 0x00ae }
    L_0x00ab:
        monitor-exit(r4);	 Catch:{ all -> 0x00ae }
        goto L_0x001a;
    L_0x00ae:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x00ae }
        throw r0;
    L_0x00b1:
        r0 = r9.getVisibility();	 Catch:{ all -> 0x00ae }
        if (r0 == r7) goto L_0x00bb;
    L_0x00b7:
        r0 = 0;
        r9.setVisibility(r0);	 Catch:{ all -> 0x00ae }
    L_0x00bb:
        r0 = r9.nF;	 Catch:{ all -> 0x00ae }
        r0 = r0.widthPixels;	 Catch:{ all -> 0x00ae }
        r1 = r9.nF;	 Catch:{ all -> 0x00ae }
        r1 = r1.heightPixels;	 Catch:{ all -> 0x00ae }
        r9.setMeasuredDimension(r0, r1);	 Catch:{ all -> 0x00ae }
        goto L_0x00ab;
    L_0x00c7:
        r2 = r0;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ex.onMeasure(int, int):void");
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.pA != null) {
            this.pA.a(event);
        }
        return super.onTouchEvent(event);
    }

    public void q(boolean z) {
        synchronized (this.ls) {
            this.sD = z;
            cg();
        }
    }

    public void setContext(Context context) {
        this.sB.setBaseContext(context);
    }
}
