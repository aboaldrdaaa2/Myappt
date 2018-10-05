package lip.com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class GoogleAnalytics extends TrackerHandler {
    private static boolean wm;
    private static GoogleAnalytics wt;
    private Context mContext;
    private String tC;
    private String tD;
    private f tV;
    private boolean wn;
    private af wo;
    private volatile Boolean wp;
    private Logger wq;
    private Set<a> wr;
    private boolean ws;

    interface a {
        void h(Activity activity);

        void i(Activity activity);
    }

    class b implements ActivityLifecycleCallbacks {
        b() {
        }

        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        public void onActivityStarted(Activity activity) {
            GoogleAnalytics.this.f(activity);
        }

        public void onActivityStopped(Activity activity) {
            GoogleAnalytics.this.g(activity);
        }
    }

    protected GoogleAnalytics(Context context) {
        this(context, t.x(context), r.cE());
    }

    private GoogleAnalytics(Context context, f thread, af serviceManager) {
        this.wp = Boolean.valueOf(false);
        this.ws = false;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.tV = thread;
        this.wo = serviceManager;
        g.u(this.mContext);
        ae.u(this.mContext);
        h.u(this.mContext);
        this.wq = new l();
        this.wr = new HashSet();
        dj();
    }

    private int P(String str) {
        String toLowerCase = str.toLowerCase();
        return "verbose".equals(toLowerCase) ? 0 : "info".equals(toLowerCase) ? 1 : "warning".equals(toLowerCase) ? 2 : NativeProtocol.BRIDGE_ARG_ERROR_BUNDLE.equals(toLowerCase) ? 3 : -1;
    }

    private Tracker a(Tracker tracker) {
        if (this.tC != null) {
            tracker.set("&an", this.tC);
        }
        if (this.tD != null) {
            tracker.set("&av", this.tD);
        }
        return tracker;
    }

    static GoogleAnalytics di() {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            googleAnalytics = wt;
        }
        return googleAnalytics;
    }

    private void dj() {
        if (!wm) {
            ApplicationInfo applicationInfo;
            try {
                applicationInfo = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 129);
            } catch (NameNotFoundException e) {
                aa.C("PackageManager doesn't know about package: " + e);
                applicationInfo = null;
            }
            if (applicationInfo == null) {
                aa.D("Couldn't get ApplicationInfo to load gloabl config.");
                return;
            }
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                int i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource");
                if (i > 0) {
                    w wVar = (w) new v(this.mContext).r(i);
                    if (wVar != null) {
                        a(wVar);
                    }
                }
            }
        }
    }

    private void f(Activity activity) {
        for (a h : this.wr) {
            h.h(activity);
        }
    }

    private void g(Activity activity) {
        for (a i : this.wr) {
            i.i(activity);
        }
    }

    public static GoogleAnalytics getInstance(Context context) {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            if (wt == null) {
                wt = new GoogleAnalytics(context);
            }
            googleAnalytics = wt;
        }
        return googleAnalytics;
    }

    void a(a aVar) {
        this.wr.add(aVar);
    }

    void a(w wVar) {
        aa.C("Loading global config values.");
        if (wVar.cY()) {
            this.tC = wVar.cZ();
            aa.C("app name loaded: " + this.tC);
        }
        if (wVar.da()) {
            this.tD = wVar.db();
            aa.C("app version loaded: " + this.tD);
        }
        if (wVar.dc()) {
            int P = P(wVar.dd());
            if (P >= 0) {
                aa.C("log level loaded: " + P);
                getLogger().setLogLevel(P);
            }
        }
        if (wVar.de()) {
            this.wo.setLocalDispatchPeriod(wVar.df());
        }
        if (wVar.dg()) {
            setDryRun(wVar.dh());
        }
    }

    void b(a aVar) {
        this.wr.remove(aVar);
    }

    @Deprecated
    public void dispatchLocalHits() {
        this.wo.dispatchLocalHits();
    }

    public void enableAutoActivityReports(Application application) {
        if (VERSION.SDK_INT >= 14 && !this.ws) {
            application.registerActivityLifecycleCallbacks(new b());
            this.ws = true;
        }
    }

    public boolean getAppOptOut() {
        u.cU().a(com.google.android.gms.analytics.u.a.GET_APP_OPT_OUT);
        return this.wp.booleanValue();
    }

    public Logger getLogger() {
        return this.wq;
    }

    public boolean isDryRunEnabled() {
        u.cU().a(com.google.android.gms.analytics.u.a.GET_DRY_RUN);
        return this.wn;
    }

    public Tracker newTracker(int configResId) {
        Tracker a;
        synchronized (this) {
            u.cU().a(com.google.android.gms.analytics.u.a.GET_TRACKER);
            Tracker tracker = new Tracker(null, this, this.mContext);
            if (configResId > 0) {
                aj ajVar = (aj) new ai(this.mContext).r(configResId);
                if (ajVar != null) {
                    tracker.a(ajVar);
                }
            }
            a = a(tracker);
        }
        return a;
    }

    public Tracker newTracker(String trackingId) {
        Tracker a;
        synchronized (this) {
            u.cU().a(com.google.android.gms.analytics.u.a.GET_TRACKER);
            a = a(new Tracker(trackingId, this, this.mContext));
        }
        return a;
    }

    void p(Map<String, String> map) {
        synchronized (this) {
            if (map == null) {
                throw new IllegalArgumentException("hit cannot be null");
            }
            ak.a(map, "&ul", ak.a(Locale.getDefault()));
            ak.a(map, "&sr", ae.dv().getValue("&sr"));
            map.put("&_u", u.cU().cW());
            u.cU().cV();
            this.tV.p(map);
        }
    }

    public void reportActivityStart(Activity activity) {
        if (!this.ws) {
            f(activity);
        }
    }

    public void reportActivityStop(Activity activity) {
        if (!this.ws) {
            g(activity);
        }
    }

    public void setAppOptOut(boolean optOut) {
        u.cU().a(com.google.android.gms.analytics.u.a.SET_APP_OPT_OUT);
        this.wp = Boolean.valueOf(optOut);
        if (this.wp.booleanValue()) {
            this.tV.cl();
        }
    }

    public void setDryRun(boolean dryRun) {
        u.cU().a(com.google.android.gms.analytics.u.a.SET_DRY_RUN);
        this.wn = dryRun;
    }

    @Deprecated
    public void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
        this.wo.setLocalDispatchPeriod(dispatchPeriodInSeconds);
    }

    public void setLogger(Logger logger) {
        u.cU().a(com.google.android.gms.analytics.u.a.SET_LOGGER);
        this.wq = logger;
    }
}
