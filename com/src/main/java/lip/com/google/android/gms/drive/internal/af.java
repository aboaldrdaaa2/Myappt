package lip.com.google.android.gms.drive.internal;

import com.google.android.gms.internal.ly;
import com.google.android.gms.internal.lz;
import com.google.android.gms.internal.ma;
import com.google.android.gms.internal.md;
import com.google.android.gms.internal.me;
import com.millennialmedia.android.MMException;
import java.io.IOException;

public final class af extends ma<af> {
    public String Jt;
    public long Ju;
    public long Jv;
    public int versionCode;

    public af() {
        gs();
    }

    public static af g(byte[] bArr) throws md {
        return (af) me.a(new af(), bArr);
    }

    public void a(lz lzVar) throws IOException {
        lzVar.p(1, this.versionCode);
        lzVar.b(2, this.Jt);
        lzVar.c(3, this.Ju);
        lzVar.c(4, this.Jv);
        super.a(lzVar);
    }

    protected int c() {
        return (((super.c() + lz.r(1, this.versionCode)) + lz.h(2, this.Jt)) + lz.e(3, this.Ju)) + lz.e(4, this.Jv);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof af)) {
            return false;
        }
        af afVar = (af) o;
        if (this.versionCode != afVar.versionCode) {
            return false;
        }
        if (this.Jt == null) {
            if (afVar.Jt != null) {
                return false;
            }
        } else if (!this.Jt.equals(afVar.Jt)) {
            return false;
        }
        if (this.Ju != afVar.Ju || this.Jv != afVar.Jv) {
            return false;
        }
        if (this.amX == null || this.amX.isEmpty()) {
            return afVar.amX == null || afVar.amX.isEmpty();
        } else {
            return this.amX.equals(afVar.amX);
        }
    }

    public af gs() {
        this.versionCode = 1;
        this.Jt = "";
        this.Ju = -1;
        this.Jv = -1;
        this.amX = null;
        this.anb = -1;
        return this;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((this.Jt == null ? 0 : this.Jt.hashCode()) + ((this.versionCode + 527) * 31)) * 31) + ((int) (this.Ju ^ (this.Ju >>> 32)))) * 31) + ((int) (this.Jv ^ (this.Jv >>> 32)))) * 31;
        if (!(this.amX == null || this.amX.isEmpty())) {
            i = this.amX.hashCode();
        }
        return hashCode + i;
    }

    /* renamed from: m */
    public af b(ly lyVar) throws IOException {
        while (true) {
            int nB = lyVar.nB();
            switch (nB) {
                case 0:
                    break;
                case 8:
                    this.versionCode = lyVar.nE();
                    continue;
                case 18:
                    this.Jt = lyVar.readString();
                    continue;
                case MMException.DISPLAY_AD_NOT_PERMITTED /*24*/:
                    this.Ju = lyVar.nH();
                    continue;
                case 32:
                    this.Jv = lyVar.nH();
                    continue;
                default:
                    if (!a(lyVar, nB)) {
                        break;
                    }
                    continue;
            }
        }
        return this;
    }
}
