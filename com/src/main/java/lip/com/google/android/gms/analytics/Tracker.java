package lip.com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.facebook.AppEventsConstants;
import com.google.android.gms.internal.hm;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Tracker {
    private Context mContext;
    private final TrackerHandler xe;
    private final Map<String, String> xf;
    private ad xg;
    private final h xh;
    private final ae xi;
    private final g xj;
    private boolean xk;
    private a xl;
    private aj xm;
    private ExceptionReporter xn;

    private class a implements a {
        private i uu;
        private boolean xo = false;
        private int xp = 0;
        private long xq = -1;
        private boolean xr = false;
        private long xs;

        public a() {
            this.uu = new i(Tracker.this) {
                public long currentTimeMillis() {
                    return System.currentTimeMillis();
                }
            };
        }

        private void dB() {
            GoogleAnalytics di = GoogleAnalytics.di();
            if (di == null) {
                aa.A("GoogleAnalytics isn't initialized for the Tracker!");
            } else if (this.xq >= 0 || this.xo) {
                di.a(Tracker.this.xl);
            } else {
                di.b(Tracker.this.xl);
            }
        }

        public boolean dA() {
            boolean z = this.xr;
            this.xr = false;
            return z;
        }

        boolean dC() {
            return this.uu.currentTimeMillis() >= this.xs + Math.max(1000, this.xq);
        }

        public long dy() {
            return this.xq;
        }

        public boolean dz() {
            return this.xo;
        }

        public void enableAutoActivityTracking(boolean enabled) {
            this.xo = enabled;
            dB();
        }

        public void h(Activity activity) {
            u.cU().a(com.google.android.gms.analytics.u.a.EASY_TRACKER_ACTIVITY_START);
            if (this.xp == 0 && dC()) {
                this.xr = true;
            }
            this.xp++;
            if (this.xo) {
                Map hashMap = new HashMap();
                hashMap.put("&t", "screenview");
                u.cU().u(true);
                Tracker.this.set("&cd", Tracker.this.xm != null ? Tracker.this.xm.j(activity) : activity.getClass().getCanonicalName());
                Tracker.this.send(hashMap);
                u.cU().u(false);
            }
        }

        public void i(Activity activity) {
            u.cU().a(com.google.android.gms.analytics.u.a.EASY_TRACKER_ACTIVITY_STOP);
            this.xp--;
            this.xp = Math.max(0, this.xp);
            if (this.xp == 0) {
                this.xs = this.uu.currentTimeMillis();
            }
        }

        public void setSessionTimeout(long sessionTimeout) {
            this.xq = sessionTimeout;
            dB();
        }
    }

    Tracker(String trackingId, TrackerHandler handler, Context context) {
        this(trackingId, handler, h.cv(), ae.dv(), g.cu(), new z("tracking"), context);
    }

    Tracker(String trackingId, TrackerHandler handler, h clientIdDefaultProvider, ae screenResolutionDefaultProvider, g appFieldsDefaultProvider, ad rateLimiter, Context context) {
        this.xf = new HashMap();
        this.xe = handler;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        if (trackingId != null) {
            this.xf.put("&tid", trackingId);
        }
        this.xf.put("useSecure", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        this.xh = clientIdDefaultProvider;
        this.xi = screenResolutionDefaultProvider;
        this.xj = appFieldsDefaultProvider;
        this.xf.put("&a", Integer.toString(new Random().nextInt(Integer.MAX_VALUE) + 1));
        this.xg = rateLimiter;
        this.xl = new a();
        enableAdvertisingIdCollection(false);
    }

    void a(aj ajVar) {
        String dF;
        aa.C("Loading Tracker config values.");
        this.xm = ajVar;
        if (this.xm.dE()) {
            dF = this.xm.dF();
            set("&tid", dF);
            aa.C("[Tracker] trackingId loaded: " + dF);
        }
        if (this.xm.dG()) {
            dF = Double.toString(this.xm.dH());
            set("&sf", dF);
            aa.C("[Tracker] sample frequency loaded: " + dF);
        }
        if (this.xm.dI()) {
            setSessionTimeout((long) this.xm.getSessionTimeout());
            aa.C("[Tracker] session timeout loaded: " + dy());
        }
        if (this.xm.dJ()) {
            enableAutoActivityTracking(this.xm.dK());
            aa.C("[Tracker] auto activity tracking loaded: " + dz());
        }
        if (this.xm.dL()) {
            if (this.xm.dM()) {
                set("&aip", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                aa.C("[Tracker] anonymize ip loaded: true");
            }
            aa.C("[Tracker] anonymize ip loaded: false");
        }
        enableExceptionReporting(this.xm.dN());
    }

    long dy() {
        return this.xl.dy();
    }

    boolean dz() {
        return this.xl.dz();
    }

    public void enableAdvertisingIdCollection(boolean enabled) {
        if (enabled) {
            if (this.xf.containsKey("&ate")) {
                this.xf.remove("&ate");
            }
            if (this.xf.containsKey("&adid")) {
                this.xf.remove("&adid");
                return;
            }
            return;
        }
        this.xf.put("&ate", null);
        this.xf.put("&adid", null);
    }

    public void enableAutoActivityTracking(boolean enabled) {
        this.xl.enableAutoActivityTracking(enabled);
    }

    public void enableExceptionReporting(boolean enabled) {
        if (this.xk != enabled) {
            this.xk = enabled;
            if (enabled) {
                this.xn = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), this.mContext);
                Thread.setDefaultUncaughtExceptionHandler(this.xn);
                aa.C("Uncaught exceptions will be reported to Google Analytics.");
                return;
            }
            if (this.xn != null) {
                Thread.setDefaultUncaughtExceptionHandler(this.xn.cD());
            } else {
                Thread.setDefaultUncaughtExceptionHandler(null);
            }
            aa.C("Uncaught exceptions will not be reported to Google Analytics.");
        }
    }

    public String get(String key) {
        u.cU().a(com.google.android.gms.analytics.u.a.GET);
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        if (this.xf.containsKey(key)) {
            return (String) this.xf.get(key);
        }
        if (key.equals("&ul")) {
            return ak.a(Locale.getDefault());
        }
        if (this.xh != null && this.xh.J(key)) {
            return this.xh.getValue(key);
        }
        if (this.xi == null || !this.xi.J(key)) {
            return (this.xj == null || !this.xj.J(key)) ? null : this.xj.getValue(key);
        } else {
            return this.xi.getValue(key);
        }
    }

    public void send(Map<String, String> params) {
        u.cU().a(com.google.android.gms.analytics.u.a.SEND);
        Map hashMap = new HashMap();
        hashMap.putAll(this.xf);
        if (params != null) {
            hashMap.putAll(params);
        }
        if (TextUtils.isEmpty((CharSequence) hashMap.get("&tid"))) {
            aa.D(String.format("Missing tracking id (%s) parameter.", new Object[]{"&tid"}));
        }
        String str = (String) hashMap.get("&t");
        if (TextUtils.isEmpty(str)) {
            aa.D(String.format("Missing hit type (%s) parameter.", new Object[]{"&t"}));
            str = "";
        }
        if (this.xl.dA()) {
            hashMap.put("&sc", "start");
        }
        String toLowerCase = str.toLowerCase();
        if ("screenview".equals(toLowerCase) || "pageview".equals(toLowerCase) || "appview".equals(toLowerCase) || TextUtils.isEmpty(toLowerCase)) {
            int parseInt = Integer.parseInt((String) this.xf.get("&a")) + 1;
            if (parseInt >= Integer.MAX_VALUE) {
                parseInt = 1;
            }
            this.xf.put("&a", Integer.toString(parseInt));
        }
        if (toLowerCase.equals("transaction") || toLowerCase.equals("item") || this.xg.do()) {
            this.xe.p(hashMap);
        } else {
            aa.D("Too many hits sent too quickly, rate limiting invoked.");
        }
    }

    public void set(String key, String value) {
        hm.b((Object) key, (Object) "Key should be non-null");
        u.cU().a(com.google.android.gms.analytics.u.a.SET);
        this.xf.put(key, value);
    }

    public void setAnonymizeIp(boolean anonymize) {
        set("&aip", ak.v(anonymize));
    }

    public void setAppId(String appId) {
        set("&aid", appId);
    }

    public void setAppInstallerId(String appInstallerId) {
        set("&aiid", appInstallerId);
    }

    public void setAppName(String appName) {
        set("&an", appName);
    }

    public void setAppVersion(String appVersion) {
        set("&av", appVersion);
    }

    public void setClientId(String clientId) {
        set("&cid", clientId);
    }

    public void setEncoding(String encoding) {
        set("&de", encoding);
    }

    public void setHostname(String hostname) {
        set("&dh", hostname);
    }

    public void setLanguage(String language) {
        set("&ul", language);
    }

    public void setLocation(String location) {
        set("&dl", location);
    }

    public void setPage(String page) {
        set("&dp", page);
    }

    public void setReferrer(String referrer) {
        set("&dr", referrer);
    }

    public void setSampleRate(double sampleRate) {
        set("&sf", Double.toHexString(sampleRate));
    }

    public void setScreenColors(String screenColors) {
        set("&sd", screenColors);
    }

    public void setScreenName(String screenName) {
        set("&cd", screenName);
    }

    public void setScreenResolution(int width, int height) {
        if (width >= 0 || height >= 0) {
            set("&sr", width + "x" + height);
        } else {
            aa.D("Invalid width or height. The values should be non-negative.");
        }
    }

    public void setSessionTimeout(long sessionTimeout) {
        this.xl.setSessionTimeout(1000 * sessionTimeout);
    }

    public void setTitle(String title) {
        set("&dt", title);
    }

    public void setUseSecure(boolean useSecure) {
        set("useSecure", ak.v(useSecure));
    }

    public void setViewportSize(String viewportSize) {
        set("&vp", viewportSize);
    }
}
