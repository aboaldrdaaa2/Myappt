package lip.com.google.android.gms.internal;

import com.millennialmedia.android.MMException;
import java.io.IOException;

public interface iv {

    public static final class a extends ma<a> {
        public a[] Uy;

        public static final class a extends ma<a> {
            private static volatile a[] Uz;
            public String UA;
            public String UB;
            public int viewId;

            public a() {
                iS();
            }

            public static a[] iR() {
                if (Uz == null) {
                    synchronized (mc.ana) {
                        if (Uz == null) {
                            Uz = new a[0];
                        }
                    }
                }
                return Uz;
            }

            public void a(lz lzVar) throws IOException {
                if (!this.UA.equals("")) {
                    lzVar.b(1, this.UA);
                }
                if (!this.UB.equals("")) {
                    lzVar.b(2, this.UB);
                }
                if (this.viewId != 0) {
                    lzVar.p(3, this.viewId);
                }
                super.a(lzVar);
            }

            protected int c() {
                int c = super.c();
                if (!this.UA.equals("")) {
                    c += lz.h(1, this.UA);
                }
                if (!this.UB.equals("")) {
                    c += lz.h(2, this.UB);
                }
                return this.viewId != 0 ? c + lz.r(3, this.viewId) : c;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof a)) {
                    return false;
                }
                a aVar = (a) o;
                if (this.UA == null) {
                    if (aVar.UA != null) {
                        return false;
                    }
                } else if (!this.UA.equals(aVar.UA)) {
                    return false;
                }
                if (this.UB == null) {
                    if (aVar.UB != null) {
                        return false;
                    }
                } else if (!this.UB.equals(aVar.UB)) {
                    return false;
                }
                if (this.viewId != aVar.viewId) {
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
                int hashCode = ((((this.UB == null ? 0 : this.UB.hashCode()) + (((this.UA == null ? 0 : this.UA.hashCode()) + 527) * 31)) * 31) + this.viewId) * 31;
                if (!(this.amX == null || this.amX.isEmpty())) {
                    i = this.amX.hashCode();
                }
                return hashCode + i;
            }

            public a iS() {
                this.UA = "";
                this.UB = "";
                this.viewId = 0;
                this.amX = null;
                this.anb = -1;
                return this;
            }

            /* renamed from: o */
            public a b(ly lyVar) throws IOException {
                while (true) {
                    int nB = lyVar.nB();
                    switch (nB) {
                        case 0:
                            break;
                        case 10:
                            this.UA = lyVar.readString();
                            continue;
                        case 18:
                            this.UB = lyVar.readString();
                            continue;
                        case MMException.DISPLAY_AD_NOT_PERMITTED /*24*/:
                            this.viewId = lyVar.nE();
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

        public a() {
            iQ();
        }

        public void a(lz lzVar) throws IOException {
            if (this.Uy != null && this.Uy.length > 0) {
                for (me meVar : this.Uy) {
                    if (meVar != null) {
                        lzVar.a(1, meVar);
                    }
                }
            }
            super.a(lzVar);
        }

        protected int c() {
            int c = super.c();
            if (this.Uy != null && this.Uy.length > 0) {
                for (me meVar : this.Uy) {
                    if (meVar != null) {
                        c += lz.b(1, meVar);
                    }
                }
            }
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof a)) {
                return false;
            }
            a aVar = (a) o;
            if (!mc.equals(this.Uy, aVar.Uy)) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return aVar.amX == null || aVar.amX.isEmpty();
            } else {
                return this.amX.equals(aVar.amX);
            }
        }

        public int hashCode() {
            int hashCode = (mc.hashCode(this.Uy) + 527) * 31;
            int hashCode2 = (this.amX == null || this.amX.isEmpty()) ? 0 : this.amX.hashCode();
            return hashCode2 + hashCode;
        }

        public a iQ() {
            this.Uy = a.iR();
            this.amX = null;
            this.anb = -1;
            return this;
        }

        /* renamed from: n */
        public a b(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                switch (nB) {
                    case 0:
                        break;
                    case 10:
                        int b = mh.b(lyVar, 10);
                        nB = this.Uy == null ? 0 : this.Uy.length;
                        Object obj = new a[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.Uy, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new a();
                            lyVar.a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new a();
                        lyVar.a(obj[nB]);
                        this.Uy = obj;
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
