package lip.com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class lz {
    private final int amW;
    private final byte[] buffer;
    private int position;

    public static class a extends IOException {
        a(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private lz(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.position = i;
        this.amW = i + i2;
    }

    public static int D(long j) {
        return G(j);
    }

    public static int E(long j) {
        return G(I(j));
    }

    public static int G(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    public static long I(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public static int J(boolean z) {
        return 1;
    }

    public static int b(int i, double d) {
        return eH(i) + f(d);
    }

    public static int b(int i, me meVar) {
        return eH(i) + c(meVar);
    }

    public static int b(int i, boolean z) {
        return eH(i) + J(z);
    }

    public static int b(int i, byte[] bArr) {
        return eH(i) + s(bArr);
    }

    public static lz b(byte[] bArr, int i, int i2) {
        return new lz(bArr, i, i2);
    }

    public static int c(int i, float f) {
        return eH(i) + e(f);
    }

    public static int c(me meVar) {
        int oa = meVar.oa();
        return oa + eJ(oa);
    }

    public static int cz(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + eJ(bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int d(int i, long j) {
        return eH(i) + D(j);
    }

    public static int e(float f) {
        return 4;
    }

    public static int e(int i, long j) {
        return eH(i) + E(j);
    }

    public static int eE(int i) {
        return i >= 0 ? eJ(i) : 10;
    }

    public static int eF(int i) {
        return eJ(eL(i));
    }

    public static int eH(int i) {
        return eJ(mh.u(i, 0));
    }

    public static int eJ(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int eL(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public static int f(double d) {
        return 8;
    }

    public static int h(int i, String str) {
        return eH(i) + cz(str);
    }

    public static lz q(byte[] bArr) {
        return b(bArr, 0, bArr.length);
    }

    public static int r(int i, int i2) {
        return eH(i) + eE(i2);
    }

    public static int s(int i, int i2) {
        return eH(i) + eF(i2);
    }

    public static int s(byte[] bArr) {
        return eJ(bArr.length) + bArr.length;
    }

    public void B(long j) throws IOException {
        F(j);
    }

    public void C(long j) throws IOException {
        F(I(j));
    }

    public void F(long j) throws IOException {
        while ((-128 & j) != 0) {
            eG((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            j >>>= 7;
        }
        eG((int) j);
    }

    public void H(long j) throws IOException {
        eG(((int) j) & MotionEventCompat.ACTION_MASK);
        eG(((int) (j >> 8)) & MotionEventCompat.ACTION_MASK);
        eG(((int) (j >> 16)) & MotionEventCompat.ACTION_MASK);
        eG(((int) (j >> 24)) & MotionEventCompat.ACTION_MASK);
        eG(((int) (j >> 32)) & MotionEventCompat.ACTION_MASK);
        eG(((int) (j >> 40)) & MotionEventCompat.ACTION_MASK);
        eG(((int) (j >> 48)) & MotionEventCompat.ACTION_MASK);
        eG(((int) (j >> 56)) & MotionEventCompat.ACTION_MASK);
    }

    public void I(boolean z) throws IOException {
        eG(z ? 1 : 0);
    }

    public void a(int i, double d) throws IOException {
        t(i, 1);
        e(d);
    }

    public void a(int i, me meVar) throws IOException {
        t(i, 2);
        b(meVar);
    }

    public void a(int i, boolean z) throws IOException {
        t(i, 0);
        I(z);
    }

    public void a(int i, byte[] bArr) throws IOException {
        t(i, 2);
        r(bArr);
    }

    public void b(byte b) throws IOException {
        if (this.position == this.amW) {
            throw new a(this.position, this.amW);
        }
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    public void b(int i, float f) throws IOException {
        t(i, 5);
        d(f);
    }

    public void b(int i, long j) throws IOException {
        t(i, 0);
        B(j);
    }

    public void b(int i, String str) throws IOException {
        t(i, 2);
        cy(str);
    }

    public void b(me meVar) throws IOException {
        eI(meVar.nZ());
        meVar.a(this);
    }

    public void c(int i, long j) throws IOException {
        t(i, 0);
        C(j);
    }

    public void c(byte[] bArr, int i, int i2) throws IOException {
        if (this.amW - this.position >= i2) {
            System.arraycopy(bArr, i, this.buffer, this.position, i2);
            this.position += i2;
            return;
        }
        throw new a(this.position, this.amW);
    }

    public void cy(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        eI(bytes.length);
        t(bytes);
    }

    public void d(float f) throws IOException {
        eK(Float.floatToIntBits(f));
    }

    public void e(double d) throws IOException {
        H(Double.doubleToLongBits(d));
    }

    public void eC(int i) throws IOException {
        if (i >= 0) {
            eI(i);
        } else {
            F((long) i);
        }
    }

    public void eD(int i) throws IOException {
        eI(eL(i));
    }

    public void eG(int i) throws IOException {
        b((byte) i);
    }

    public void eI(int i) throws IOException {
        while ((i & -128) != 0) {
            eG((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
        }
        eG(i);
    }

    public void eK(int i) throws IOException {
        eG(i & MotionEventCompat.ACTION_MASK);
        eG((i >> 8) & MotionEventCompat.ACTION_MASK);
        eG((i >> 16) & MotionEventCompat.ACTION_MASK);
        eG((i >> 24) & MotionEventCompat.ACTION_MASK);
    }

    public int nQ() {
        return this.amW - this.position;
    }

    public void nR() {
        if (nQ() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void p(int i, int i2) throws IOException {
        t(i, 0);
        eC(i2);
    }

    public void q(int i, int i2) throws IOException {
        t(i, 0);
        eD(i2);
    }

    public void r(byte[] bArr) throws IOException {
        eI(bArr.length);
        t(bArr);
    }

    public void t(int i, int i2) throws IOException {
        eI(mh.u(i, i2));
    }

    public void t(byte[] bArr) throws IOException {
        c(bArr, 0, bArr.length);
    }
}
