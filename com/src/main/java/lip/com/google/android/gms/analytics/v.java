package lip.com.google.android.gms.analytics;

import android.content.Context;

class v extends k<w> {

    private static class a implements com.google.android.gms.analytics.k.a<w> {
        private final w wi = new w();

        public void a(String str, int i) {
            if ("ga_dispatchPeriod".equals(str)) {
                this.wi.wk = i;
            } else {
                aa.D("int configuration name not recognized:  " + str);
            }
        }

        public void c(String str, String str2) {
        }

        public void c(String str, boolean z) {
            if ("ga_dryRun".equals(str)) {
                this.wi.wl = z ? 1 : 0;
                return;
            }
            aa.D("bool configuration name not recognized:  " + str);
        }

        /* renamed from: cX */
        public w cB() {
            return this.wi;
        }

        public void d(String str, String str2) {
            if ("ga_appName".equals(str)) {
                this.wi.tC = str2;
            } else if ("ga_appVersion".equals(str)) {
                this.wi.tD = str2;
            } else if ("ga_logLevel".equals(str)) {
                this.wi.wj = str2;
            } else {
                aa.D("string configuration name not recognized:  " + str);
            }
        }
    }

    public v(Context context) {
        super(context, new a());
    }
}
