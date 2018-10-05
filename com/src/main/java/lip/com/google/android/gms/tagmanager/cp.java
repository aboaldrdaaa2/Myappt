package lip.com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.internal.c.f;
import com.google.android.gms.internal.le.a;
import com.google.android.gms.internal.md;
import com.google.android.gms.internal.me;
import com.google.android.gms.tagmanager.cq.c;
import com.google.android.gms.tagmanager.cq.g;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

class cp implements f {
    private final String aet;
    private bg<a> agN;
    private final ExecutorService agU = Executors.newSingleThreadExecutor();
    private final Context mContext;

    cp(Context context, String str) {
        this.mContext = context;
        this.aet = str;
    }

    private c a(ByteArrayOutputStream byteArrayOutputStream) {
        c cVar = null;
        try {
            return ba.bY(byteArrayOutputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            bh.z("Tried to convert binary resource to string for JSON parsing; not UTF-8 format");
            return cVar;
        } catch (JSONException e2) {
            bh.D("Resource is a UTF-8 encoded string but doesn't contain a JSON container");
            return cVar;
        }
    }

    private c k(byte[] bArr) {
        c cVar = null;
        try {
            return cq.b(f.a(bArr));
        } catch (md e) {
            bh.D("Resource doesn't contain a binary container");
            return cVar;
        } catch (g e2) {
            bh.D("Resource doesn't contain a binary container");
            return cVar;
        }
    }

    public void a(bg<a> bgVar) {
        this.agN = bgVar;
    }

    public void b(final a aVar) {
        this.agU.execute(new Runnable() {
            public void run() {
                cp.this.c(aVar);
            }
        });
    }

    boolean c(a aVar) {
        boolean z = false;
        File mm = mm();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(mm);
            try {
                fileOutputStream.write(me.d(aVar));
                z = true;
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    bh.D("error closing stream for writing resource to disk");
                }
            } catch (IOException e2) {
                bh.D("Error writing resource to disk. Removing resource from disk.");
                mm.delete();
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    bh.D("error closing stream for writing resource to disk");
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    bh.D("error closing stream for writing resource to disk");
                }
                throw th;
            }
        } catch (FileNotFoundException e5) {
            bh.A("Error opening resource file for writing");
        }
        return z;
    }

    public c dn(int i) {
        bh.C("Atttempting to load container from resource ID " + i);
        try {
            InputStream openRawResource = this.mContext.getResources().openRawResource(i);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            cq.b(openRawResource, byteArrayOutputStream);
            c a = a(byteArrayOutputStream);
            return a != null ? a : k(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            bh.D("Error reading default container resource with ID " + i);
            return null;
        } catch (NotFoundException e2) {
            bh.D("No default container resource found.");
            return null;
        }
    }

    public void lw() {
        this.agU.execute(new Runnable() {
            public void run() {
                cp.this.ml();
            }
        });
    }

    void ml() {
        if (this.agN == null) {
            throw new IllegalStateException("callback must be set before execute");
        }
        this.agN.lv();
        bh.C("Start loading resource from disk ...");
        if ((cd.md().me() == a.CONTAINER || cd.md().me() == a.CONTAINER_DEBUG) && this.aet.equals(cd.md().getContainerId())) {
            this.agN.a(bg.a.NOT_AVAILABLE);
            return;
        }
        try {
            InputStream fileInputStream = new FileInputStream(mm());
            try {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                cq.b(fileInputStream, byteArrayOutputStream);
                this.agN.i(a.l(byteArrayOutputStream.toByteArray()));
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    bh.D("error closing stream for reading resource from disk");
                }
            } catch (IOException e2) {
                bh.D("error reading resource from disk");
                this.agN.a(bg.a.IO_ERROR);
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    bh.D("error closing stream for reading resource from disk");
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    bh.D("error closing stream for reading resource from disk");
                }
                throw th;
            }
            bh.C("Load resource from disk finished.");
        } catch (FileNotFoundException e5) {
            bh.z("resource not on disk");
            this.agN.a(bg.a.NOT_AVAILABLE);
        }
    }

    File mm() {
        return new File(this.mContext.getDir("google_tagmanager", 0), "resource_" + this.aet);
    }

    public synchronized void release() {
        this.agU.shutdown();
    }
}
