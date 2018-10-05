package lip.com.google.c;

import android.support.v4.media.TransportMediator;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: IMASDK */
public final class a {
    private final byte[] a;
    private final int b;
    private int c;
    private int d = 0;
    private final OutputStream e;

    /* compiled from: IMASDK */
    public static class a extends IOException {
        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private a(OutputStream outputStream, byte[] bArr) {
        this.e = outputStream;
        this.a = bArr;
        this.c = 0;
        this.b = bArr.length;
    }

    public static a a(OutputStream outputStream) {
        return new a(outputStream, new byte[4096]);
    }

    private void b() throws IOException {
        if (this.e == null) {
            throw new a();
        }
        this.e.write(this.a, 0, this.c);
        this.c = 0;
    }

    public final void a() throws IOException {
        if (this.e != null) {
            b();
        }
    }

    public final void a(int i) throws IOException {
        byte b = (byte) i;
        if (this.c == this.b) {
            b();
        }
        byte[] bArr = this.a;
        int i2 = this.c;
        this.c = i2 + 1;
        bArr[i2] = b;
        this.d++;
    }

    public final void a(byte[] bArr, int i) throws IOException {
        if (this.b - this.c >= i) {
            System.arraycopy(bArr, 0, this.a, this.c, i);
            this.c += i;
        } else {
            int i2 = this.b - this.c;
            System.arraycopy(bArr, 0, this.a, this.c, i2);
            int i3 = i2 + 0;
            i -= i2;
            this.c = this.b;
            this.d = i2 + this.d;
            b();
            if (i <= this.b) {
                System.arraycopy(bArr, i3, this.a, 0, i);
                this.c = i;
            } else {
                this.e.write(bArr, i3, i);
            }
        }
        this.d += i;
    }

    public final void a(int i, int i2) throws IOException {
        b(b.a(i, i2));
    }

    public final void b(int i) throws IOException {
        while ((i & -128) != 0) {
            a((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
        }
        a(i);
    }
}
