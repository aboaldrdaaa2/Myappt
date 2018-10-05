package lip.com.google.android.gms.internal;

import java.io.IOException;

public abstract class me {
    protected volatile int anb = -1;

    public static final <T extends me> T a(T t, byte[] bArr) throws md {
        return b(t, bArr, 0, bArr.length);
    }

    public static final void a(me meVar, byte[] bArr, int i, int i2) {
        try {
            lz b = lz.b(bArr, i, i2);
            meVar.a(b);
            b.nR();
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final <T extends me> T b(T t, byte[] bArr, int i, int i2) throws md {
        try {
            ly a = ly.a(bArr, i, i2);
            t.b(a);
            a.eu(0);
            return t;
        } catch (md e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final byte[] d(me meVar) {
        byte[] bArr = new byte[meVar.oa()];
        a(meVar, bArr, 0, bArr.length);
        return bArr;
    }

    public void a(lz lzVar) throws IOException {
    }

    public abstract me b(ly lyVar) throws IOException;

    protected int c() {
        return 0;
    }

    public int nZ() {
        if (this.anb < 0) {
            oa();
        }
        return this.anb;
    }

    public int oa() {
        int c = c();
        this.anb = c;
        return c;
    }

    public String toString() {
        return mf.e(this);
    }
}
