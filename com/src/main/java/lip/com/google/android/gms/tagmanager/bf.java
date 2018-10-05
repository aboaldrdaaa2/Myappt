package lip.com.google.android.gms.tagmanager;

import com.google.android.gms.internal.ij;

class bf implements cf {
    private final ij aef;
    private final long agf;
    private final long wE;
    private final int wF;
    private double wG;
    private long wH;
    private final Object wI = new Object();
    private final String wJ;

    public bf(int i, long j, long j2, String str, ij ijVar) {
        this.wF = i;
        this.wG = (double) this.wF;
        this.wE = j;
        this.agf = j2;
        this.wJ = str;
        this.aef = ijVar;
    }

    public boolean do() {
        boolean z = false;
        synchronized (this.wI) {
            long currentTimeMillis = this.aef.currentTimeMillis();
            if (currentTimeMillis - this.wH < this.agf) {
                bh.D("Excessive " + this.wJ + " detected; call ignored.");
            } else {
                if (this.wG < ((double) this.wF)) {
                    double d = ((double) (currentTimeMillis - this.wH)) / ((double) this.wE);
                    if (d > 0.0d) {
                        this.wG = Math.min((double) this.wF, d + this.wG);
                    }
                }
                this.wH = currentTimeMillis;
                if (this.wG >= 1.0d) {
                    this.wG -= 1.0d;
                    z = true;
                } else {
                    bh.D("Excessive " + this.wJ + " detected; call ignored.");
                }
            }
        }
        return z;
    }
}
