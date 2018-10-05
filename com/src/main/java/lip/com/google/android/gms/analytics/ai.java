package lip.com.google.android.gms.analytics;

import android.content.Context;

class ai extends k<aj> {

    private static class a implements com.google.android.gms.analytics.k.a<aj> {
        private final aj xw = new aj();

        public void a(String str, int i) {
            if ("ga_sessionTimeout".equals(str)) {
                this.xw.xz = i;
            } else {
                aa.D("int configuration name not recognized:  " + str);
            }
        }

        public void c(String str, String str2) {
            this.xw.xD.put(str, str2);
        }

        public void c(String str, boolean z) {
            int i = 1;
            aj ajVar;
            if ("ga_autoActivityTracking".equals(str)) {
                ajVar = this.xw;
                if (!z) {
                    i = 0;
                }
                ajVar.xA = i;
            } else if ("ga_anonymizeIp".equals(str)) {
                ajVar = this.xw;
                if (!z) {
                    i = 0;
                }
                ajVar.xB = i;
            } else if ("ga_reportUncaughtExceptions".equals(str)) {
                ajVar = this.xw;
                if (!z) {
                    i = 0;
                }
                ajVar.xC = i;
            } else {
                aa.D("bool configuration name not recognized:  " + str);
            }
        }

        public void d(String str, String str2) {
            if ("ga_trackingId".equals(str)) {
                this.xw.xx = str2;
            } else if ("ga_sampleFrequency".equals(str)) {
                try {
                    this.xw.xy = Double.parseDouble(str2);
                } catch (NumberFormatException e) {
                    aa.A("Error parsing ga_sampleFrequency value: " + str2);
                }
            } else {
                aa.D("string configuration name not recognized:  " + str);
            }
        }

        /* renamed from: dD */
        public aj cB() {
            return this.xw;
        }
    }

    public ai(Context context) {
        super(context, new a());
    }
}
