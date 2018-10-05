package lip.com.google.a.a;

import android.content.Context;
import android.support.v4.media.TransportMediator;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.b.a.b;
import com.google.c.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* compiled from: IMASDK */
public abstract class d implements c {
    protected MotionEvent a = null;
    protected DisplayMetrics b = null;
    private a c = null;
    private ByteArrayOutputStream d = null;

    protected abstract void b(Context context);

    protected d(Context context) {
        try {
            this.b = context.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException e) {
            this.b = new DisplayMetrics();
            this.b.density = 1.0f;
        }
    }

    public final String a(Context context) {
        return c(context);
    }

    private String c(Context context) {
        try {
            a();
            b(context);
            byte[] b = b();
            if (b.length == 0) {
                return Integer.toString(5);
            }
            byte[] bArr;
            if (b.length > 239) {
                a();
                a(20, 1);
                b = b();
            }
            if (b.length < 239) {
                bArr = new byte[(239 - b.length)];
                new SecureRandom().nextBytes(bArr);
                b = ByteBuffer.allocate(240).put((byte) b.length).put(b).put(bArr).array();
            } else {
                b = ByteBuffer.allocate(240).put((byte) b.length).put(b).array();
            }
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(b);
            b = ByteBuffer.allocate(256).put(instance.digest()).put(b).array();
            bArr = new byte[256];
            new a().a(b, bArr);
            return b.a(bArr);
        } catch (NoSuchAlgorithmException e) {
            return Integer.toString(7);
        } catch (UnsupportedEncodingException e2) {
            return Integer.toString(7);
        } catch (IOException e3) {
            return Integer.toString(3);
        }
    }

    protected final void a(int i, long j) throws IOException {
        a aVar = this.c;
        aVar.a(i, 0);
        while ((-128 & j) != 0) {
            aVar.a((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            j >>>= 7;
        }
        aVar.a((int) j);
    }

    protected final void a(int i, String str) throws IOException {
        a aVar = this.c;
        aVar.a(i, 2);
        byte[] bytes = str.getBytes("UTF-8");
        aVar.b(bytes.length);
        aVar.a(bytes, bytes.length);
    }

    private void a() {
        this.d = new ByteArrayOutputStream();
        this.c = a.a(this.d);
    }

    private byte[] b() throws IOException {
        this.c.a();
        return this.d.toByteArray();
    }
}
