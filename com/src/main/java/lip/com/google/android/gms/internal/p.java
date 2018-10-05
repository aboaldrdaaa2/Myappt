package lip.com.google.android.gms.internal;

import java.io.IOException;

class p implements n {
    private lz kn;
    private byte[] ko;
    private final int kp;

    public p(int i) {
        this.kp = i;
        reset();
    }

    public byte[] A() throws IOException {
        int nQ = this.kn.nQ();
        if (nQ < 0) {
            throw new IOException();
        } else if (nQ == 0) {
            return this.ko;
        } else {
            Object obj = new byte[(this.ko.length - nQ)];
            System.arraycopy(this.ko, 0, obj, 0, obj.length);
            return obj;
        }
    }

    public void b(int i, long j) throws IOException {
        this.kn.b(i, j);
    }

    public void b(int i, String str) throws IOException {
        this.kn.b(i, str);
    }

    public void reset() {
        this.ko = new byte[this.kp];
        this.kn = lz.q(this.ko);
    }
}
