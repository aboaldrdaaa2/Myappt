package lip.com.google.android.gms.analytics;

import android.content.Context;
import android.os.Process;
import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import com.facebook.AppEventsConstants;
import com.google.android.gms.internal.fd;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

class t extends Thread implements f {
    private static t uO;
    private volatile boolean mClosed = false;
    private final Context mContext;
    private final LinkedBlockingQueue<Runnable> uK = new LinkedBlockingQueue();
    private volatile boolean uL = false;
    private volatile List<fd> uM;
    private volatile String uN;
    private volatile ag uP;

    private t(Context context) {
        super("GAThread");
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    static int O(String str) {
        int i = 1;
        if (!TextUtils.isEmpty(str)) {
            i = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                char charAt = str.charAt(length);
                i = (((i << 6) & 268435455) + charAt) + (charAt << 14);
                int i2 = 266338304 & i;
                if (i2 != 0) {
                    i ^= i2 >> 21;
                }
            }
        }
        return i;
    }

    private String a(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    private String q(Map<String, String> map) {
        return map.containsKey("useSecure") ? ak.d((String) map.get("useSecure"), true) ? "https:" : "http:" : "https:";
    }

    private boolean r(Map<String, String> map) {
        if (map.get("&sf") == null) {
            return false;
        }
        double a = ak.a((String) map.get("&sf"), 100.0d);
        if (a >= 100.0d) {
            return false;
        }
        if (((double) (O((String) map.get("&cid")) % 10000)) < a * 100.0d) {
            return false;
        }
        String str = map.get("&t") == null ? EnvironmentCompat.MEDIA_UNKNOWN : (String) map.get("&t");
        aa.C(String.format("%s hit sampled out", new Object[]{str}));
        return true;
    }

    private void s(Map<String, String> map) {
        m s = a.s(this.mContext);
        ak.a(map, "&adid", s.getValue("&adid"));
        ak.a(map, "&ate", s.getValue("&ate"));
    }

    private void t(Map<String, String> map) {
        m cu = g.cu();
        ak.a(map, "&an", cu.getValue("&an"));
        ak.a(map, "&av", cu.getValue("&av"));
        ak.a(map, "&aid", cu.getValue("&aid"));
        ak.a(map, "&aiid", cu.getValue("&aiid"));
        map.put("&v", AppEventsConstants.EVENT_PARAM_VALUE_YES);
    }

    static t x(Context context) {
        if (uO == null) {
            uO = new t(context);
        }
        return uO;
    }

    static String y(Context context) {
        try {
            FileInputStream openFileInput = context.openFileInput("gaInstallData");
            byte[] bArr = new byte[8192];
            int read = openFileInput.read(bArr, 0, 8192);
            if (openFileInput.available() > 0) {
                aa.A("Too much campaign data, ignoring it.");
                openFileInput.close();
                context.deleteFile("gaInstallData");
                return null;
            }
            openFileInput.close();
            context.deleteFile("gaInstallData");
            if (read <= 0) {
                aa.D("Campaign file is empty.");
                return null;
            }
            String str = new String(bArr, 0, read);
            aa.B("Campaign found: " + str);
            return str;
        } catch (FileNotFoundException e) {
            aa.B("No campaign data found.");
            return null;
        } catch (IOException e2) {
            aa.A("Error reading campaign data.");
            context.deleteFile("gaInstallData");
            return null;
        }
    }

    void a(Runnable runnable) {
        this.uK.add(runnable);
    }

    public void cl() {
        a(new Runnable() {
            public void run() {
                t.this.uP.cl();
            }
        });
    }

    public void cq() {
        a(new Runnable() {
            public void run() {
                t.this.uP.cq();
            }
        });
    }

    public void cs() {
        a(new Runnable() {
            public void run() {
                t.this.uP.cs();
            }
        });
    }

    public LinkedBlockingQueue<Runnable> ct() {
        return this.uK;
    }

    public Thread getThread() {
        return this;
    }

    protected void init() {
        this.uP.cL();
        this.uM = new ArrayList();
        this.uM.add(new fd("appendVersion", "&_v".substring(1), "ma4.0.2"));
        this.uM.add(new fd("appendQueueTime", "&qt".substring(1), null));
        this.uM.add(new fd("appendCacheBuster", "&z".substring(1), null));
    }

    public void p(Map<String, String> map) {
        final Map hashMap = new HashMap(map);
        String str = (String) map.get("&ht");
        if (str != null) {
            try {
                Long.valueOf(str);
            } catch (NumberFormatException e) {
                str = null;
            }
        }
        if (str == null) {
            hashMap.put("&ht", Long.toString(System.currentTimeMillis()));
        }
        a(new Runnable() {
            public void run() {
                t.this.s(hashMap);
                if (TextUtils.isEmpty((CharSequence) hashMap.get("&cid"))) {
                    hashMap.put("&cid", h.cv().getValue("&cid"));
                }
                if (!GoogleAnalytics.getInstance(t.this.mContext).getAppOptOut() && !t.this.r(hashMap)) {
                    if (!TextUtils.isEmpty(t.this.uN)) {
                        u.cU().u(true);
                        hashMap.putAll(new HitBuilder().setCampaignParamsFromUrl(t.this.uN).build());
                        u.cU().u(false);
                        t.this.uN = null;
                    }
                    t.this.t(hashMap);
                    t.this.uP.b(y.u(hashMap), Long.valueOf((String) hashMap.get("&ht")).longValue(), t.this.q(hashMap), t.this.uM);
                }
            }
        });
    }

    public void run() {
        Process.setThreadPriority(10);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            aa.D("sleep interrupted in GAThread initialize");
        }
        try {
            if (this.uP == null) {
                this.uP = new s(this.mContext, this);
            }
            init();
            this.uN = y(this.mContext);
            aa.C("Initialized GA Thread");
        } catch (Throwable th) {
            aa.A("Error initializing the GAThread: " + a(th));
            aa.A("Google Analytics will not start up.");
            this.uL = true;
        }
        while (!this.mClosed) {
            try {
                Runnable runnable = (Runnable) this.uK.take();
                if (!this.uL) {
                    runnable.run();
                }
            } catch (InterruptedException e2) {
                aa.B(e2.toString());
            } catch (Throwable th2) {
                aa.A("Error on GAThread: " + a(th2));
                aa.A("Google Analytics is shutting down.");
                this.uL = true;
            }
        }
    }
}
