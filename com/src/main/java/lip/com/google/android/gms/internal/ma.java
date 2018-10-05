package lip.com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class ma<M extends ma<M>> extends me {
    protected List<mg> amX;

    public final <T> T a(mb<M, T> mbVar) {
        return mbVar.i(this.amX);
    }

    public void a(lz lzVar) throws IOException {
        int size = this.amX == null ? 0 : this.amX.size();
        for (int i = 0; i < size; i++) {
            mg mgVar = (mg) this.amX.get(i);
            lzVar.eI(mgVar.tag);
            lzVar.t(mgVar.anc);
        }
    }

    protected final boolean a(ly lyVar, int i) throws IOException {
        int position = lyVar.getPosition();
        if (!lyVar.ev(i)) {
            return false;
        }
        if (this.amX == null) {
            this.amX = new ArrayList();
        }
        this.amX.add(new mg(i, lyVar.o(position, lyVar.getPosition() - position)));
        return true;
    }

    protected int c() {
        int i = 0;
        for (int i2 = 0; i2 < (this.amX == null ? 0 : this.amX.size()); i2++) {
            mg mgVar = (mg) this.amX.get(i2);
            i = (i + lz.eJ(mgVar.tag)) + mgVar.anc.length;
        }
        return i;
    }
}
