package lip.com.google.android.gms.internal;

import android.text.TextUtils;
import java.io.IOException;

public abstract class gg {
    protected final gn BD;
    private final String BE;
    private gp BF;

    protected gg(String str, String str2, String str3) {
        gi.ak(str);
        this.BE = str;
        this.BD = new gn(str2);
        if (!TextUtils.isEmpty(str3)) {
            this.BD.ap(str3);
        }
    }

    public void a(long j, int i) {
    }

    public final void a(gp gpVar) {
        this.BF = gpVar;
        if (this.BF == null) {
            ee();
        }
    }

    protected final void a(String str, long j, String str2) throws IOException {
        this.BD.a("Sending text message: %s to: %s", str, str2);
        this.BF.a(this.BE, str, j, str2);
    }

    public void ai(String str) {
    }

    protected final long ed() {
        return this.BF.eb();
    }

    public void ee() {
    }

    public final String getNamespace() {
        return this.BE;
    }
}
