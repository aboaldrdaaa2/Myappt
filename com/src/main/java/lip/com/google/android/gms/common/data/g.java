package lip.com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class g<T> extends DataBuffer<T> {
    private boolean EU = false;
    private ArrayList<Integer> EV;

    protected g(DataHolder dataHolder) {
        super(dataHolder);
    }

    private void fa() {
        synchronized (this) {
            if (!this.EU) {
                int count = this.DG.getCount();
                this.EV = new ArrayList();
                if (count > 0) {
                    this.EV.add(Integer.valueOf(0));
                    String eZ = eZ();
                    String c = this.DG.c(eZ, 0, this.DG.ae(0));
                    int i = 1;
                    while (i < count) {
                        String c2 = this.DG.c(eZ, i, this.DG.ae(i));
                        if (c2.equals(c)) {
                            c2 = c;
                        } else {
                            this.EV.add(Integer.valueOf(i));
                        }
                        i++;
                        c = c2;
                    }
                }
                this.EU = true;
            }
        }
    }

    int ah(int i) {
        if (i >= 0 && i < this.EV.size()) {
            return ((Integer) this.EV.get(i)).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }

    protected int ai(int i) {
        if (i < 0 || i == this.EV.size()) {
            return 0;
        }
        int count = i == this.EV.size() + -1 ? this.DG.getCount() - ((Integer) this.EV.get(i)).intValue() : ((Integer) this.EV.get(i + 1)).intValue() - ((Integer) this.EV.get(i)).intValue();
        if (count != 1) {
            return count;
        }
        int ah = ah(i);
        int ae = this.DG.ae(ah);
        String fb = fb();
        return (fb == null || this.DG.c(fb, ah, ae) != null) ? count : 0;
    }

    protected abstract T c(int i, int i2);

    protected abstract String eZ();

    protected String fb() {
        return null;
    }

    public final T get(int position) {
        fa();
        return c(ah(position), ai(position));
    }

    public int getCount() {
        fa();
        return this.EV.size();
    }
}
