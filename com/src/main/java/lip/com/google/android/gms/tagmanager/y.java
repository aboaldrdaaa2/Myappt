package lip.com.google.android.gms.tagmanager;

import android.content.Context;
import java.net.URLEncoder;

class y implements aq {
    private static y afu;
    private static final Object tq = new Object();
    private cf aeJ;
    private String afv;
    private String afw;
    private ar afx;

    private y(Context context) {
        this(as.P(context), new cv());
    }

    y(ar arVar, cf cfVar) {
        this.afx = arVar;
        this.aeJ = cfVar;
    }

    public static aq N(Context context) {
        aq aqVar;
        synchronized (tq) {
            if (afu == null) {
                afu = new y(context);
            }
            aqVar = afu;
        }
        return aqVar;
    }

    public boolean bR(String str) {
        if (this.aeJ.do()) {
            if (!(this.afv == null || this.afw == null)) {
                try {
                    str = this.afv + "?" + this.afw + "=" + URLEncoder.encode(str, "UTF-8");
                    bh.C("Sending wrapped url hit: " + str);
                } catch (Throwable e) {
                    bh.c("Error wrapping URL for testing.", e);
                    return false;
                }
            }
            this.afx.bU(str);
            return true;
        }
        bh.D("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
        return false;
    }
}
