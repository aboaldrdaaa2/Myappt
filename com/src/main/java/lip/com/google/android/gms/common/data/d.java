package lip.com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hm;

public abstract class d {
    protected final DataHolder DG;
    protected int EC;
    private int ED;

    public d(DataHolder dataHolder, int i) {
        this.DG = (DataHolder) hm.f(dataHolder);
        ac(i);
    }

    protected void a(String str, CharArrayBuffer charArrayBuffer) {
        this.DG.a(str, this.EC, this.ED, charArrayBuffer);
    }

    protected void ac(int i) {
        boolean z = i >= 0 && i < this.DG.getCount();
        hm.A(z);
        this.EC = i;
        this.ED = this.DG.ae(this.EC);
    }

    public boolean av(String str) {
        return this.DG.av(str);
    }

    protected Uri aw(String str) {
        return this.DG.g(str, this.EC, this.ED);
    }

    protected boolean ax(String str) {
        return this.DG.h(str, this.EC, this.ED);
    }

    protected int eV() {
        return this.EC;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return hk.equal(Integer.valueOf(dVar.EC), Integer.valueOf(this.EC)) && hk.equal(Integer.valueOf(dVar.ED), Integer.valueOf(this.ED)) && dVar.DG == this.DG;
    }

    protected boolean getBoolean(String column) {
        return this.DG.d(column, this.EC, this.ED);
    }

    protected byte[] getByteArray(String column) {
        return this.DG.f(column, this.EC, this.ED);
    }

    protected float getFloat(String column) {
        return this.DG.e(column, this.EC, this.ED);
    }

    protected int getInteger(String column) {
        return this.DG.b(column, this.EC, this.ED);
    }

    protected long getLong(String column) {
        return this.DG.a(column, this.EC, this.ED);
    }

    protected String getString(String column) {
        return this.DG.c(column, this.EC, this.ED);
    }

    public int hashCode() {
        return hk.hashCode(Integer.valueOf(this.EC), Integer.valueOf(this.ED), this.DG);
    }

    public boolean isDataValid() {
        return !this.DG.isClosed();
    }
}
