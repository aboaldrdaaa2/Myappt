package lip.com.google.android.gms.analytics;

import android.content.Context;
import com.facebook.AppEventsConstants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

class h implements m {
    private static h tH;
    private static final Object tq = new Object();
    private final Context mContext;
    private String tI;
    private boolean tJ = false;
    private final Object tK = new Object();

    protected h(Context context) {
        this.mContext = context;
        cz();
    }

    private boolean K(String str) {
        try {
            aa.C("Storing clientId.");
            FileOutputStream openFileOutput = this.mContext.openFileOutput("gaClientId", 0);
            openFileOutput.write(str.getBytes());
            openFileOutput.close();
            return true;
        } catch (FileNotFoundException e) {
            aa.A("Error creating clientId file.");
            return false;
        } catch (IOException e2) {
            aa.A("Error writing to clientId file.");
            return false;
        }
    }

    public static h cv() {
        h hVar;
        synchronized (tq) {
            hVar = tH;
        }
        return hVar;
    }

    private String cx() {
        if (!this.tJ) {
            synchronized (this.tK) {
                if (!this.tJ) {
                    aa.C("Waiting for clientId to load");
                    do {
                        try {
                            this.tK.wait();
                        } catch (InterruptedException e) {
                            aa.A("Exception while waiting for clientId: " + e);
                        }
                    } while (!this.tJ);
                }
            }
        }
        aa.C("Loaded clientId");
        return this.tI;
    }

    private void cz() {
        new Thread("client_id_fetcher") {
            public void run() {
                synchronized (h.this.tK) {
                    h.this.tI = h.this.cA();
                    h.this.tJ = true;
                    h.this.tK.notifyAll();
                }
            }
        }.start();
    }

    public static void u(Context context) {
        synchronized (tq) {
            if (tH == null) {
                tH = new h(context);
            }
        }
    }

    public boolean J(String str) {
        return "&cid".equals(str);
    }

    String cA() {
        String str = null;
        try {
            FileInputStream openFileInput = this.mContext.openFileInput("gaClientId");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                aa.A("clientId file seems corrupted, deleting it.");
                openFileInput.close();
                this.mContext.deleteFile("gaClientId");
            } else if (read <= 0) {
                aa.A("clientId file seems empty, deleting it.");
                openFileInput.close();
                this.mContext.deleteFile("gaClientId");
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    aa.C("Loaded client id from disk.");
                    str = str2;
                } catch (FileNotFoundException e) {
                    str = str2;
                } catch (IOException e2) {
                    str = str2;
                    aa.A("Error reading clientId file, deleting it.");
                    this.mContext.deleteFile("gaClientId");
                }
            }
        } catch (FileNotFoundException e3) {
        } catch (IOException e4) {
            aa.A("Error reading clientId file, deleting it.");
            this.mContext.deleteFile("gaClientId");
        }
        return str == null ? cy() : str;
    }

    String cw() {
        String str;
        synchronized (this.tK) {
            this.tI = cy();
            str = this.tI;
        }
        return str;
    }

    protected String cy() {
        String toLowerCase = UUID.randomUUID().toString().toLowerCase();
        try {
            return !K(toLowerCase) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : toLowerCase;
        } catch (Exception e) {
            return null;
        }
    }

    public String getValue(String field) {
        return "&cid".equals(field) ? cx() : null;
    }
}
