package lip.com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public abstract class h implements g {
    protected MotionEvent jO;
    protected DisplayMetrics jP;
    protected m jQ;
    private n jR;

    protected h(Context context, m mVar, n nVar) {
        this.jQ = mVar;
        this.jR = nVar;
        try {
            this.jP = context.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException e) {
            this.jP = new DisplayMetrics();
            this.jP.density = 1.0f;
        }
    }

    private String a(Context context, String str, boolean z, boolean z2) {
        try {
            byte[] u;
            synchronized (this) {
                t();
                if (z) {
                    e(context);
                } else if (z2) {
                    d(context);
                } else {
                    c(context);
                }
                u = u();
            }
            return u.length == 0 ? Integer.toString(5) : a(u, str);
        } catch (NoSuchAlgorithmException e) {
            return Integer.toString(7);
        } catch (UnsupportedEncodingException e2) {
            return Integer.toString(7);
        } catch (IOException e3) {
            return Integer.toString(3);
        }
    }

    private void t() {
        this.jR.reset();
    }

    private byte[] u() throws IOException {
        return this.jR.A();
    }

    public String a(Context context) {
        return a(context, null, false, false);
    }

    public String a(Context context, String str) {
        return a(context, str, true, false);
    }

    String a(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
        byte[] bArr2;
        if (bArr.length > 239) {
            t();
            a(20, 1);
            bArr = u();
        }
        if (bArr.length < 239) {
            bArr2 = new byte[(239 - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).array();
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(bArr2);
        bArr2 = ByteBuffer.allocate(256).put(instance.digest()).put(bArr2).array();
        byte[] bArr3 = new byte[256];
        new f().a(bArr2, bArr3);
        if (str != null && str.length() > 0) {
            a(str, bArr3);
        }
        return this.jQ.a(bArr3, true);
    }

    public void a(int i, int i2, int i3) {
        if (this.jO != null) {
            this.jO.recycle();
        }
        this.jO = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * this.jP.density, ((float) i2) * this.jP.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
    }

    protected void a(int i, long j) throws IOException {
        this.jR.b(i, j);
    }

    protected void a(int i, String str) throws IOException {
        this.jR.b(i, str);
    }

    public void a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.jO != null) {
                this.jO.recycle();
            }
            this.jO = MotionEvent.obtain(motionEvent);
        }
    }

    void a(String str, byte[] bArr) throws UnsupportedEncodingException {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new lx(str.getBytes("UTF-8")).o(bArr);
    }

    public String b(Context context) {
        return a(context, null, false, true);
    }

    protected abstract void c(Context context);

    protected abstract void d(Context context);

    protected abstract void e(Context context);
}
