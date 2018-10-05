package lip.com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.facebook.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.internal.ae.a;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ac implements OnGlobalLayoutListener, OnScrollChangedListener {
    private static final long lG = TimeUnit.MILLISECONDS.toNanos(100);
    private final ae lA;
    private boolean lB;
    private final WindowManager lC;
    private final PowerManager lD;
    private final KeyguardManager lE;
    private ad lF;
    private boolean lH;
    private long lI;
    private boolean lJ;
    private BroadcastReceiver lK;
    private HashSet<z> lL;
    private boolean lj;
    private final Object ls;
    private final WeakReference<ef> lv;
    private WeakReference<ViewTreeObserver> lw;
    private final WeakReference<View> lx;
    private final aa ly;
    private final Context lz;

    public ac(al alVar, ef efVar) {
        this(alVar, efVar, efVar.oy.cd(), efVar.oy, new af(efVar.oy.getContext(), efVar.oy.cd()));
    }

    public ac(al alVar, ef efVar, ev evVar, View view, ae aeVar) {
        this.ls = new Object();
        this.lj = false;
        this.lH = false;
        this.lI = Long.MIN_VALUE;
        this.lL = new HashSet();
        this.lv = new WeakReference(efVar);
        this.lx = new WeakReference(view);
        this.lw = new WeakReference(null);
        this.lJ = true;
        this.ly = new aa(Integer.toString(efVar.hashCode()), evVar, alVar.me, efVar.ry);
        this.lA = aeVar;
        this.lC = (WindowManager) view.getContext().getSystemService("window");
        this.lD = (PowerManager) view.getContext().getApplicationContext().getSystemService("power");
        this.lE = (KeyguardManager) view.getContext().getSystemService("keyguard");
        this.lz = view.getContext().getApplicationContext();
        a(aeVar);
        this.lA.a(new a() {
            public void aE() {
                ac.this.lB = true;
                ac.this.e(false);
                ac.this.av();
            }
        });
        b(this.lA);
        eu.B("Tracking ad unit: " + this.ly.au());
    }

    protected int a(int i, DisplayMetrics displayMetrics) {
        return (int) (((float) i) / displayMetrics.density);
    }

    public void a(ad adVar) {
        synchronized (this.ls) {
            this.lF = adVar;
        }
    }

    protected void a(ae aeVar) {
        aeVar.d("http://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.html");
    }

    protected void a(ex exVar, Map<String, String> map) {
        e(false);
    }

    public void a(z zVar) {
        this.lL.add(zVar);
    }

    protected void a(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        this.lA.a("AFMA_updateActiveView", jSONObject2);
    }

    protected boolean a(View view, boolean z) {
        return view.getVisibility() == 0 && z && view.isShown() && this.lD.isScreenOn() && !this.lE.inKeyguardRestrictedInputMode();
    }

    protected void aA() {
        View view = (View) this.lx.get();
        if (view != null) {
            ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.lw.get();
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2 != viewTreeObserver) {
                this.lw = new WeakReference(viewTreeObserver2);
                viewTreeObserver2.addOnScrollChangedListener(this);
                viewTreeObserver2.addOnGlobalLayoutListener(this);
            }
        }
    }

    protected void aB() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.lw.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }

    protected JSONObject aC() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.ly.as()).put("activeViewJSON", this.ly.at()).put("timestamp", TimeUnit.NANOSECONDS.toMillis(System.nanoTime())).put("adFormat", this.ly.ar()).put("hashCode", this.ly.au());
        return jSONObject;
    }

    protected JSONObject aD() throws JSONException {
        JSONObject aC = aC();
        aC.put("doneReasonCode", "u");
        return aC;
    }

    protected void av() {
        synchronized (this.ls) {
            if (this.lK != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.lK = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    ac.this.e(false);
                }
            };
            this.lz.registerReceiver(this.lK, intentFilter);
        }
    }

    protected void aw() {
        synchronized (this.ls) {
            if (this.lK != null) {
                this.lz.unregisterReceiver(this.lK);
                this.lK = null;
            }
        }
    }

    public void ax() {
        synchronized (this.ls) {
            if (this.lJ) {
                aB();
                aw();
                try {
                    a(aD());
                } catch (Throwable e) {
                    eu.b("JSON Failure while processing active view data.", e);
                }
                this.lJ = false;
                ay();
                eu.B("Untracked ad unit: " + this.ly.au());
            }
        }
    }

    protected void ay() {
        if (this.lF != null) {
            this.lF.a(this);
        }
    }

    public boolean az() {
        boolean z;
        synchronized (this.ls) {
            z = this.lJ;
        }
        return z;
    }

    protected void b(ae aeVar) {
        aeVar.a("/updateActiveView", new bc() {
            public void b(ex exVar, Map<String, String> map) {
                ac.this.a(exVar, (Map) map);
            }
        });
        aeVar.a("/activeViewPingSent", new bc() {
            public void b(ex exVar, Map<String, String> map) {
                if (map.containsKey("pingType") && "unloadPing".equals(map.get("pingType"))) {
                    ac.this.c(ac.this.lA);
                    eu.B("Unregistered GMSG handlers for: " + ac.this.ly.au());
                }
            }
        });
        aeVar.a("/visibilityChanged", new bc() {
            public void b(ex exVar, Map<String, String> map) {
                if (map.containsKey("isVisible")) {
                    boolean z = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("isVisible")) || ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(map.get("isVisible"));
                    ac.this.d(Boolean.valueOf(z).booleanValue());
                }
            }
        });
        aeVar.a("/viewabilityChanged", bb.mT);
    }

    protected JSONObject c(View view) throws JSONException {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr);
        view.getLocationInWindow(iArr2);
        JSONObject aC = aC();
        DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        rect2.right = this.lC.getDefaultDisplay().getWidth();
        rect2.bottom = this.lC.getDefaultDisplay().getHeight();
        Rect rect3 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect3, null);
        Rect rect4 = new Rect();
        view.getLocalVisibleRect(rect4);
        aC.put("viewBox", new JSONObject().put("top", a(rect2.top, displayMetrics)).put("bottom", a(rect2.bottom, displayMetrics)).put("left", a(rect2.left, displayMetrics)).put("right", a(rect2.right, displayMetrics))).put("adBox", new JSONObject().put("top", a(rect.top, displayMetrics)).put("bottom", a(rect.bottom, displayMetrics)).put("left", a(rect.left, displayMetrics)).put("right", a(rect.right, displayMetrics))).put("globalVisibleBox", new JSONObject().put("top", a(rect3.top, displayMetrics)).put("bottom", a(rect3.bottom, displayMetrics)).put("left", a(rect3.left, displayMetrics)).put("right", a(rect3.right, displayMetrics))).put("localVisibleBox", new JSONObject().put("top", a(rect4.top, displayMetrics)).put("bottom", a(rect4.bottom, displayMetrics)).put("left", a(rect4.left, displayMetrics)).put("right", a(rect4.right, displayMetrics))).put("screenDensity", (double) displayMetrics.density).put("isVisible", a(view, globalVisibleRect)).put("isStopped", this.lH).put("isPaused", this.lj);
        return aC;
    }

    protected void c(ae aeVar) {
        aeVar.e("/viewabilityChanged");
        aeVar.e("/visibilityChanged");
        aeVar.e("/activeViewPingSent");
        aeVar.e("/updateActiveView");
    }

    protected void d(boolean z) {
        Iterator it = this.lL.iterator();
        while (it.hasNext()) {
            ((z) it.next()).a(this, z);
        }
    }

    /* JADX WARNING: Missing block: B:32:?, code:
            return;
     */
    protected void e(boolean r8) {
        /*
        r7 = this;
        r2 = r7.ls;
        monitor-enter(r2);
        r0 = r7.lB;	 Catch:{ all -> 0x001e }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r7.lJ;	 Catch:{ all -> 0x001e }
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r2);	 Catch:{ all -> 0x001e }
    L_0x000c:
        return;
    L_0x000d:
        r0 = java.lang.System.nanoTime();	 Catch:{ all -> 0x001e }
        if (r8 == 0) goto L_0x0021;
    L_0x0013:
        r3 = r7.lI;	 Catch:{ all -> 0x001e }
        r5 = lG;	 Catch:{ all -> 0x001e }
        r3 = r3 + r5;
        r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r3 <= 0) goto L_0x0021;
    L_0x001c:
        monitor-exit(r2);	 Catch:{ all -> 0x001e }
        goto L_0x000c;
    L_0x001e:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x001e }
        throw r0;
    L_0x0021:
        r7.lI = r0;	 Catch:{ all -> 0x001e }
        r0 = r7.lv;	 Catch:{ all -> 0x001e }
        r0 = r0.get();	 Catch:{ all -> 0x001e }
        r0 = (com.google.android.gms.internal.ef) r0;	 Catch:{ all -> 0x001e }
        r1 = r7.lx;	 Catch:{ all -> 0x001e }
        r1 = r1.get();	 Catch:{ all -> 0x001e }
        r1 = (android.view.View) r1;	 Catch:{ all -> 0x001e }
        if (r1 == 0) goto L_0x0037;
    L_0x0035:
        if (r0 != 0) goto L_0x003f;
    L_0x0037:
        r0 = 1;
    L_0x0038:
        if (r0 == 0) goto L_0x0041;
    L_0x003a:
        r7.ax();	 Catch:{ all -> 0x001e }
        monitor-exit(r2);	 Catch:{ all -> 0x001e }
        goto L_0x000c;
    L_0x003f:
        r0 = 0;
        goto L_0x0038;
    L_0x0041:
        r0 = r7.c(r1);	 Catch:{ JSONException -> 0x0050 }
        r7.a(r0);	 Catch:{ JSONException -> 0x0050 }
    L_0x0048:
        r7.aA();	 Catch:{ all -> 0x001e }
        r7.ay();	 Catch:{ all -> 0x001e }
        monitor-exit(r2);	 Catch:{ all -> 0x001e }
        goto L_0x000c;
    L_0x0050:
        r0 = move-exception;
        r1 = "Active view update failed.";
        com.google.android.gms.internal.eu.b(r1, r0);	 Catch:{ all -> 0x001e }
        goto L_0x0048;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ac.e(boolean):void");
    }

    public void onGlobalLayout() {
        e(false);
    }

    public void onScrollChanged() {
        e(true);
    }

    public void pause() {
        synchronized (this.ls) {
            this.lj = true;
            e(false);
            this.lA.pause();
        }
    }

    public void resume() {
        synchronized (this.ls) {
            this.lA.resume();
            this.lj = false;
            e(false);
        }
    }

    public void stop() {
        synchronized (this.ls) {
            this.lH = true;
            e(false);
            this.lA.pause();
        }
    }
}
