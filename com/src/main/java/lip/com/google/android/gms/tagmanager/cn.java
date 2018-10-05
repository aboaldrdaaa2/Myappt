package lip.com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.c.j;
import com.google.android.gms.tagmanager.bg.a;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

class cn implements Runnable {
    private volatile String aeP;
    private final String aet;
    private final bm agL;
    private final String agM;
    private bg<j> agN;
    private volatile r agO;
    private volatile String agP;
    private final Context mContext;

    cn(Context context, String str, bm bmVar, r rVar) {
        this.mContext = context;
        this.agL = bmVar;
        this.aet = str;
        this.agO = rVar;
        this.agM = "/r?id=" + str;
        this.aeP = this.agM;
        this.agP = null;
    }

    public cn(Context context, String str, r rVar) {
        this(context, str, new bm(), rVar);
    }

    private boolean mg() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        bh.C("...no network connectivity");
        return false;
    }

    private void mh() {
        if (mg()) {
            bh.C("Start loading resource from network ...");
            String mi = mi();
            bl lR = this.agL.lR();
            try {
                InputStream bV = lR.bV(mi);
                try {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    cq.b(bV, byteArrayOutputStream);
                    j b = j.b(byteArrayOutputStream.toByteArray());
                    bh.C("Successfully loaded supplemented resource: " + b);
                    if (b.fK == null && b.fJ.length == 0) {
                        bh.C("No change for container: " + this.aet);
                    }
                    this.agN.i(b);
                    bh.C("Load resource from network finished.");
                } catch (Throwable e) {
                    bh.c("Error when parsing downloaded resources from url: " + mi + " " + e.getMessage(), e);
                    this.agN.a(a.SERVER_ERROR);
                    lR.close();
                }
            } catch (FileNotFoundException e2) {
                bh.D("No data is retrieved from the given url: " + mi + ". Make sure container_id: " + this.aet + " is correct.");
                this.agN.a(a.SERVER_ERROR);
            } catch (Throwable e3) {
                bh.c("Error when loading resources from url: " + mi + " " + e3.getMessage(), e3);
                this.agN.a(a.IO_ERROR);
            } finally {
                lR.close();
            }
        } else {
            this.agN.a(a.NOT_AVAILABLE);
        }
    }

    void a(bg<j> bgVar) {
        this.agN = bgVar;
    }

    void bM(String str) {
        if (str == null) {
            this.aeP = this.agM;
            return;
        }
        bh.z("Setting CTFE URL path: " + str);
        this.aeP = str;
    }

    void cb(String str) {
        bh.z("Setting previous container version: " + str);
        this.agP = str;
    }

    String mi() {
        String str = this.agO.lx() + this.aeP + "&v=a65833898";
        if (!(this.agP == null || this.agP.trim().equals(""))) {
            str = str + "&pv=" + this.agP;
        }
        return cd.md().me().equals(a.CONTAINER_DEBUG) ? str + "&gtm_debug=x" : str;
    }

    public void run() {
        if (this.agN == null) {
            throw new IllegalStateException("callback must be set before execute");
        }
        this.agN.lv();
        mh();
    }
}
