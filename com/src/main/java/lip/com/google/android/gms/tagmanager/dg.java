package lip.com.google.android.gms.tagmanager;

class dg extends Number implements Comparable<dg> {
    private double aik;
    private long ail;
    private boolean aim = false;

    private dg(double d) {
        this.aik = d;
    }

    private dg(long j) {
        this.ail = j;
    }

    public static dg a(Double d) {
        return new dg(d.doubleValue());
    }

    public static dg co(String str) throws NumberFormatException {
        try {
            return new dg(Long.parseLong(str));
        } catch (NumberFormatException e) {
            try {
                return new dg(Double.parseDouble(str));
            } catch (NumberFormatException e2) {
                throw new NumberFormatException(str + " is not a valid TypedNumber");
            }
        }
    }

    public static dg z(long j) {
        return new dg(j);
    }

    /* renamed from: a */
    public int compareTo(dg dgVar) {
        return (mT() && dgVar.mT()) ? new Long(this.ail).compareTo(Long.valueOf(dgVar.ail)) : Double.compare(doubleValue(), dgVar.doubleValue());
    }

    public byte byteValue() {
        return (byte) ((int) longValue());
    }

    public double doubleValue() {
        return mT() ? (double) this.ail : this.aik;
    }

    public boolean equals(Object other) {
        return (other instanceof dg) && compareTo((dg) other) == 0;
    }

    public float floatValue() {
        return (float) doubleValue();
    }

    public int hashCode() {
        return new Long(longValue()).hashCode();
    }

    public int intValue() {
        return mV();
    }

    public long longValue() {
        return mU();
    }

    public boolean mS() {
        return !mT();
    }

    public boolean mT() {
        return this.aim;
    }

    public long mU() {
        return mT() ? this.ail : (long) this.aik;
    }

    public int mV() {
        return (int) longValue();
    }

    public short mW() {
        return (short) ((int) longValue());
    }

    public short shortValue() {
        return mW();
    }

    public String toString() {
        return mT() ? Long.toString(this.ail) : Double.toString(this.aik);
    }
}
