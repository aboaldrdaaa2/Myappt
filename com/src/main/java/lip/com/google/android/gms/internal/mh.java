package lip.com.google.android.gms.internal;

import java.io.IOException;

public final class mh {
    public static final int[] and = new int[0];
    public static final long[] ane = new long[0];
    public static final float[] anf = new float[0];
    public static final double[] ang = new double[0];
    public static final boolean[] anh = new boolean[0];
    public static final String[] ani = new String[0];
    public static final byte[][] anj = new byte[0][];
    public static final byte[] ank = new byte[0];

    public static final int b(ly lyVar, int i) throws IOException {
        int i2 = 1;
        int position = lyVar.getPosition();
        lyVar.ev(i);
        while (lyVar.nN() > 0 && lyVar.nB() == i) {
            lyVar.ev(i);
            i2++;
        }
        lyVar.ez(position);
        return i2;
    }

    static int eN(int i) {
        return i & 7;
    }

    public static int eO(int i) {
        return i >>> 3;
    }

    static int u(int i, int i2) {
        return (i << 3) | i2;
    }
}
