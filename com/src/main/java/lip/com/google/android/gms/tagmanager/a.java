package lip.com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ij;
import com.google.android.gms.internal.il;
import java.io.IOException;

class a {
    private static a aeh;
    private static Object tq = new Object();
    private volatile long aec;
    private volatile long aed;
    private volatile long aee;
    private final ij aef;
    private a aeg;
    private volatile boolean mClosed;
    private final Context mContext;
    private final Thread sf;
    private volatile Info ts;

    public interface a {
        Info lg();
    }

    private a(Context context) {
        this(context, null, il.gb());
    }

    a(Context context, a aVar, ij ijVar) {
        this.aec = 900000;
        this.aed = 30000;
        this.mClosed = false;
        this.aeg = new a() {
            public Info lg() {
                Info info = null;
                try {
                    return AdvertisingIdClient.getAdvertisingIdInfo(a.this.mContext);
                } catch (IllegalStateException e) {
                    bh.D("IllegalStateException getting Advertising Id Info");
                    return info;
                } catch (GooglePlayServicesRepairableException e2) {
                    bh.D("GooglePlayServicesRepairableException getting Advertising Id Info");
                    return info;
                } catch (IOException e3) {
                    bh.D("IOException getting Ad Id Info");
                    return info;
                } catch (GooglePlayServicesNotAvailableException e4) {
                    bh.D("GooglePlayServicesNotAvailableException getting Advertising Id Info");
                    return info;
                } catch (Exception e5) {
                    bh.D("Unknown exception. Could not get the Advertising Id Info.");
                    return info;
                }
            }
        };
        this.aef = ijVar;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        if (aVar != null) {
            this.aeg = aVar;
        }
        this.sf = new Thread(new Runnable() {
            public void run() {
                a.this.le();
            }
        });
    }

    static a M(Context context) {
        if (aeh == null) {
            synchronized (tq) {
                if (aeh == null) {
                    aeh = new a(context);
                    aeh.start();
                }
            }
        }
        return aeh;
    }

    private void le() {
        Process.setThreadPriority(10);
        while (!this.mClosed) {
            try {
                this.ts = this.aeg.lg();
                Thread.sleep(this.aec);
            } catch (InterruptedException e) {
                bh.B("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    private void lf() {
        if (this.aef.currentTimeMillis() - this.aee >= this.aed) {
            interrupt();
            this.aee = this.aef.currentTimeMillis();
        }
    }

    void interrupt() {
        this.sf.interrupt();
    }

    public boolean isLimitAdTrackingEnabled() {
        lf();
        return this.ts == null ? true : this.ts.isLimitAdTrackingEnabled();
    }

    public String ld() {
        lf();
        return this.ts == null ? null : this.ts.getId();
    }

    void start() {
        this.sf.start();
    }
}
