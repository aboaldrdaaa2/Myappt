package lip.com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

class de {
    private GoogleAnalytics aij;
    private Context mContext;
    private Tracker tP;

    static class a implements Logger {
        a() {
        }

        private static int dv(int i) {
            switch (i) {
                case 2:
                    return 0;
                case 3:
                case 4:
                    return 1;
                case 5:
                    return 2;
                default:
                    return 3;
            }
        }

        public void error(Exception exception) {
            bh.b("", exception);
        }

        public void error(String message) {
            bh.A(message);
        }

        public int getLogLevel() {
            return dv(bh.getLogLevel());
        }

        public void info(String message) {
            bh.B(message);
        }

        public void setLogLevel(int logLevel) {
            bh.D("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
        }

        public void verbose(String message) {
            bh.C(message);
        }

        public void warn(String message) {
            bh.D(message);
        }
    }

    de(Context context) {
        this.mContext = context;
    }

    private synchronized void cn(String str) {
        if (this.aij == null) {
            this.aij = GoogleAnalytics.getInstance(this.mContext);
            this.aij.setLogger(new a());
            this.tP = this.aij.newTracker(str);
        }
    }

    public Tracker cm(String str) {
        cn(str);
        return this.tP;
    }
}
