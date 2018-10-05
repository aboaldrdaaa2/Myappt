package lip.com.google.android.gms.tagmanager;

class cv implements cf {
    private long ahJ;
    private final long wE;
    private final int wF;
    private double wG;
    private final Object wI;

    public cv() {
        this(60, 2000);
    }

    public cv(int i, long j) {
        this.wI = new Object();
        this.wF = i;
        this.wG = (double) this.wF;
        this.wE = j;
    }

    public boolean do() {
        boolean z;
        synchronized (this.wI) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.wG < ((double) this.wF)) {
                double d = ((double) (currentTimeMillis - this.ahJ)) / ((double) this.wE);
                if (d > 0.0d) {
                    this.wG = Math.min((double) this.wF, d + this.wG);
                }
            }
            this.ahJ = currentTimeMillis;
            if (this.wG >= 1.0d) {
                this.wG -= 1.0d;
                z = true;
            } else {
                bh.D("No more tokens available.");
                z = false;
            }
        }
        return z;
    }
}
