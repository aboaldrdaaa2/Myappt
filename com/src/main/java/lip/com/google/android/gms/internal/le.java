package lip.com.google.android.gms.internal;

import com.google.android.gms.internal.c.f;
import com.google.android.gms.internal.c.j;
import com.millennialmedia.android.MMException;
import java.io.IOException;

public interface le {

    public static final class a extends ma<a> {
        public long aiG;
        public j aiH;
        public f fK;

        public a() {
            nf();
        }

        public static a l(byte[] bArr) throws md {
            return (a) me.a(new a(), bArr);
        }

        public void a(lz lzVar) throws IOException {
            lzVar.b(1, this.aiG);
            if (this.fK != null) {
                lzVar.a(2, this.fK);
            }
            if (this.aiH != null) {
                lzVar.a(3, this.aiH);
            }
            super.a(lzVar);
        }

        protected int c() {
            int c = super.c() + lz.d(1, this.aiG);
            if (this.fK != null) {
                c += lz.b(2, this.fK);
            }
            return this.aiH != null ? c + lz.b(3, this.aiH) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof a)) {
                return false;
            }
            a aVar = (a) o;
            if (this.aiG != aVar.aiG) {
                return false;
            }
            if (this.fK == null) {
                if (aVar.fK != null) {
                    return false;
                }
            } else if (!this.fK.equals(aVar.fK)) {
                return false;
            }
            if (this.aiH == null) {
                if (aVar.aiH != null) {
                    return false;
                }
            } else if (!this.aiH.equals(aVar.aiH)) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return aVar.amX == null || aVar.amX.isEmpty();
            } else {
                return this.amX.equals(aVar.amX);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.aiH == null ? 0 : this.aiH.hashCode()) + (((this.fK == null ? 0 : this.fK.hashCode()) + ((((int) (this.aiG ^ (this.aiG >>> 32))) + 527) * 31)) * 31)) * 31;
            if (!(this.amX == null || this.amX.isEmpty())) {
                i = this.amX.hashCode();
            }
            return hashCode + i;
        }

        public a nf() {
            this.aiG = 0;
            this.fK = null;
            this.aiH = null;
            this.amX = null;
            this.anb = -1;
            return this;
        }

        /* renamed from: p */
        public a b(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                switch (nB) {
                    case 0:
                        break;
                    case 8:
                        this.aiG = lyVar.nD();
                        continue;
                    case 18:
                        if (this.fK == null) {
                            this.fK = new f();
                        }
                        lyVar.a(this.fK);
                        continue;
                    case MMException.AD_NO_ACTIVITY /*26*/:
                        if (this.aiH == null) {
                            this.aiH = new j();
                        }
                        lyVar.a(this.aiH);
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
}
