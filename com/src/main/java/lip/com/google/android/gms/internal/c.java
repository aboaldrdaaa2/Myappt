package lip.com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.facebook.AppEventsConstants;
import com.millennialmedia.android.MMException;
import java.io.IOException;

public interface c {

    public static final class a extends ma<a> {
        public int eE;
        public int eF;
        public int level;

        public a() {
            b();
        }

        /* renamed from: a */
        public a b(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                switch (nB) {
                    case 0:
                        break;
                    case 8:
                        nB = lyVar.nE();
                        switch (nB) {
                            case 1:
                            case 2:
                            case 3:
                                this.level = nB;
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.eE = lyVar.nE();
                        continue;
                    case MMException.DISPLAY_AD_NOT_PERMITTED /*24*/:
                        this.eF = lyVar.nE();
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

        public void a(lz lzVar) throws IOException {
            if (this.level != 1) {
                lzVar.p(1, this.level);
            }
            if (this.eE != 0) {
                lzVar.p(2, this.eE);
            }
            if (this.eF != 0) {
                lzVar.p(3, this.eF);
            }
            super.a(lzVar);
        }

        public a b() {
            this.level = 1;
            this.eE = 0;
            this.eF = 0;
            this.amX = null;
            this.anb = -1;
            return this;
        }

        protected int c() {
            int c = super.c();
            if (this.level != 1) {
                c += lz.r(1, this.level);
            }
            if (this.eE != 0) {
                c += lz.r(2, this.eE);
            }
            return this.eF != 0 ? c + lz.r(3, this.eF) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof a)) {
                return false;
            }
            a aVar = (a) o;
            if (this.level != aVar.level || this.eE != aVar.eE || this.eF != aVar.eF) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return aVar.amX == null || aVar.amX.isEmpty();
            } else {
                return this.amX.equals(aVar.amX);
            }
        }

        public int hashCode() {
            int i = (((((this.level + 527) * 31) + this.eE) * 31) + this.eF) * 31;
            int hashCode = (this.amX == null || this.amX.isEmpty()) ? 0 : this.amX.hashCode();
            return hashCode + i;
        }
    }

    public static final class b extends ma<b> {
        private static volatile b[] eG;
        public int[] eH;
        public int eI;
        public boolean eJ;
        public boolean eK;
        public int name;

        public b() {
            e();
        }

        public static b[] d() {
            if (eG == null) {
                synchronized (mc.ana) {
                    if (eG == null) {
                        eG = new b[0];
                    }
                }
            }
            return eG;
        }

        public void a(lz lzVar) throws IOException {
            if (this.eK) {
                lzVar.a(1, this.eK);
            }
            lzVar.p(2, this.eI);
            if (this.eH != null && this.eH.length > 0) {
                for (int p : this.eH) {
                    lzVar.p(3, p);
                }
            }
            if (this.name != 0) {
                lzVar.p(4, this.name);
            }
            if (this.eJ) {
                lzVar.a(6, this.eJ);
            }
            super.a(lzVar);
        }

        protected int c() {
            int i = 0;
            int c = super.c();
            if (this.eK) {
                c += lz.b(1, this.eK);
            }
            int r = lz.r(2, this.eI) + c;
            if (this.eH == null || this.eH.length <= 0) {
                c = r;
            } else {
                for (int eE : this.eH) {
                    i += lz.eE(eE);
                }
                c = (r + i) + (this.eH.length * 1);
            }
            if (this.name != 0) {
                c += lz.r(4, this.name);
            }
            return this.eJ ? c + lz.b(6, this.eJ) : c;
        }

        /* renamed from: c */
        public b b(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                int b;
                switch (nB) {
                    case 0:
                        break;
                    case 8:
                        this.eK = lyVar.nF();
                        continue;
                    case 16:
                        this.eI = lyVar.nE();
                        continue;
                    case MMException.DISPLAY_AD_NOT_PERMITTED /*24*/:
                        b = mh.b(lyVar, 24);
                        nB = this.eH == null ? 0 : this.eH.length;
                        Object obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eH, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.eH = obj;
                        continue;
                    case MMException.AD_NO_ACTIVITY /*26*/:
                        int ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.eH == null ? 0 : this.eH.length;
                        Object obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.eH, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.eH = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 32:
                        this.name = lyVar.nE();
                        continue;
                    case 48:
                        this.eJ = lyVar.nF();
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

        public b e() {
            this.eH = mh.and;
            this.eI = 0;
            this.name = 0;
            this.eJ = false;
            this.eK = false;
            this.amX = null;
            this.anb = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof b)) {
                return false;
            }
            b bVar = (b) o;
            if (!mc.equals(this.eH, bVar.eH) || this.eI != bVar.eI || this.name != bVar.name || this.eJ != bVar.eJ || this.eK != bVar.eK) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return bVar.amX == null || bVar.amX.isEmpty();
            } else {
                return this.amX.equals(bVar.amX);
            }
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = ((this.eJ ? 1231 : 1237) + ((((((mc.hashCode(this.eH) + 527) * 31) + this.eI) * 31) + this.name) * 31)) * 31;
            if (!this.eK) {
                i = 1237;
            }
            i = (hashCode + i) * 31;
            hashCode = (this.amX == null || this.amX.isEmpty()) ? 0 : this.amX.hashCode();
            return hashCode + i;
        }
    }

    public static final class c extends ma<c> {
        private static volatile c[] eL;
        public String eM;
        public long eN;
        public long eO;
        public boolean eP;
        public long eQ;

        public c() {
            g();
        }

        public static c[] f() {
            if (eL == null) {
                synchronized (mc.ana) {
                    if (eL == null) {
                        eL = new c[0];
                    }
                }
            }
            return eL;
        }

        public void a(lz lzVar) throws IOException {
            if (!this.eM.equals("")) {
                lzVar.b(1, this.eM);
            }
            if (this.eN != 0) {
                lzVar.b(2, this.eN);
            }
            if (this.eO != 2147483647L) {
                lzVar.b(3, this.eO);
            }
            if (this.eP) {
                lzVar.a(4, this.eP);
            }
            if (this.eQ != 0) {
                lzVar.b(5, this.eQ);
            }
            super.a(lzVar);
        }

        protected int c() {
            int c = super.c();
            if (!this.eM.equals("")) {
                c += lz.h(1, this.eM);
            }
            if (this.eN != 0) {
                c += lz.d(2, this.eN);
            }
            if (this.eO != 2147483647L) {
                c += lz.d(3, this.eO);
            }
            if (this.eP) {
                c += lz.b(4, this.eP);
            }
            return this.eQ != 0 ? c + lz.d(5, this.eQ) : c;
        }

        /* renamed from: d */
        public c b(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                switch (nB) {
                    case 0:
                        break;
                    case 10:
                        this.eM = lyVar.readString();
                        continue;
                    case 16:
                        this.eN = lyVar.nD();
                        continue;
                    case MMException.DISPLAY_AD_NOT_PERMITTED /*24*/:
                        this.eO = lyVar.nD();
                        continue;
                    case 32:
                        this.eP = lyVar.nF();
                        continue;
                    case 40:
                        this.eQ = lyVar.nD();
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

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof c)) {
                return false;
            }
            c cVar = (c) o;
            if (this.eM == null) {
                if (cVar.eM != null) {
                    return false;
                }
            } else if (!this.eM.equals(cVar.eM)) {
                return false;
            }
            if (this.eN != cVar.eN || this.eO != cVar.eO || this.eP != cVar.eP || this.eQ != cVar.eQ) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return cVar.amX == null || cVar.amX.isEmpty();
            } else {
                return this.amX.equals(cVar.amX);
            }
        }

        public c g() {
            this.eM = "";
            this.eN = 0;
            this.eO = 2147483647L;
            this.eP = false;
            this.eQ = 0;
            this.amX = null;
            this.anb = -1;
            return this;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.eP ? 1231 : 1237) + (((((((this.eM == null ? 0 : this.eM.hashCode()) + 527) * 31) + ((int) (this.eN ^ (this.eN >>> 32)))) * 31) + ((int) (this.eO ^ (this.eO >>> 32)))) * 31)) * 31) + ((int) (this.eQ ^ (this.eQ >>> 32)))) * 31;
            if (!(this.amX == null || this.amX.isEmpty())) {
                i = this.amX.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class d extends ma<d> {
        public com.google.android.gms.internal.d.a[] eR;
        public com.google.android.gms.internal.d.a[] eS;
        public c[] eT;

        public d() {
            h();
        }

        public void a(lz lzVar) throws IOException {
            int i = 0;
            if (this.eR != null && this.eR.length > 0) {
                for (me meVar : this.eR) {
                    if (meVar != null) {
                        lzVar.a(1, meVar);
                    }
                }
            }
            if (this.eS != null && this.eS.length > 0) {
                for (me meVar2 : this.eS) {
                    if (meVar2 != null) {
                        lzVar.a(2, meVar2);
                    }
                }
            }
            if (this.eT != null && this.eT.length > 0) {
                while (i < this.eT.length) {
                    me meVar3 = this.eT[i];
                    if (meVar3 != null) {
                        lzVar.a(3, meVar3);
                    }
                    i++;
                }
            }
            super.a(lzVar);
        }

        protected int c() {
            int i;
            int i2 = 0;
            int c = super.c();
            if (this.eR != null && this.eR.length > 0) {
                i = c;
                for (me meVar : this.eR) {
                    if (meVar != null) {
                        i += lz.b(1, meVar);
                    }
                }
                c = i;
            }
            if (this.eS != null && this.eS.length > 0) {
                i = c;
                for (me meVar2 : this.eS) {
                    if (meVar2 != null) {
                        i += lz.b(2, meVar2);
                    }
                }
                c = i;
            }
            if (this.eT != null && this.eT.length > 0) {
                while (i2 < this.eT.length) {
                    me meVar3 = this.eT[i2];
                    if (meVar3 != null) {
                        c += lz.b(3, meVar3);
                    }
                    i2++;
                }
            }
            return c;
        }

        /* renamed from: e */
        public d b(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                int b;
                Object obj;
                switch (nB) {
                    case 0:
                        break;
                    case 10:
                        b = mh.b(lyVar, 10);
                        nB = this.eR == null ? 0 : this.eR.length;
                        obj = new com.google.android.gms.internal.d.a[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eR, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new com.google.android.gms.internal.d.a();
                            lyVar.a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new com.google.android.gms.internal.d.a();
                        lyVar.a(obj[nB]);
                        this.eR = obj;
                        continue;
                    case 18:
                        b = mh.b(lyVar, 18);
                        nB = this.eS == null ? 0 : this.eS.length;
                        obj = new com.google.android.gms.internal.d.a[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eS, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new com.google.android.gms.internal.d.a();
                            lyVar.a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new com.google.android.gms.internal.d.a();
                        lyVar.a(obj[nB]);
                        this.eS = obj;
                        continue;
                    case MMException.AD_NO_ACTIVITY /*26*/:
                        b = mh.b(lyVar, 26);
                        nB = this.eT == null ? 0 : this.eT.length;
                        obj = new c[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eT, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new c();
                            lyVar.a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new c();
                        lyVar.a(obj[nB]);
                        this.eT = obj;
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

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof d)) {
                return false;
            }
            d dVar = (d) o;
            if (!mc.equals(this.eR, dVar.eR) || !mc.equals(this.eS, dVar.eS) || !mc.equals(this.eT, dVar.eT)) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return dVar.amX == null || dVar.amX.isEmpty();
            } else {
                return this.amX.equals(dVar.amX);
            }
        }

        public d h() {
            this.eR = com.google.android.gms.internal.d.a.r();
            this.eS = com.google.android.gms.internal.d.a.r();
            this.eT = c.f();
            this.amX = null;
            this.anb = -1;
            return this;
        }

        public int hashCode() {
            int hashCode = (((((mc.hashCode(this.eR) + 527) * 31) + mc.hashCode(this.eS)) * 31) + mc.hashCode(this.eT)) * 31;
            int hashCode2 = (this.amX == null || this.amX.isEmpty()) ? 0 : this.amX.hashCode();
            return hashCode2 + hashCode;
        }
    }

    public static final class e extends ma<e> {
        private static volatile e[] eU;
        public int key;
        public int value;

        public e() {
            j();
        }

        public static e[] i() {
            if (eU == null) {
                synchronized (mc.ana) {
                    if (eU == null) {
                        eU = new e[0];
                    }
                }
            }
            return eU;
        }

        public void a(lz lzVar) throws IOException {
            lzVar.p(1, this.key);
            lzVar.p(2, this.value);
            super.a(lzVar);
        }

        protected int c() {
            return (super.c() + lz.r(1, this.key)) + lz.r(2, this.value);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof e)) {
                return false;
            }
            e eVar = (e) o;
            if (this.key != eVar.key || this.value != eVar.value) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return eVar.amX == null || eVar.amX.isEmpty();
            } else {
                return this.amX.equals(eVar.amX);
            }
        }

        /* renamed from: f */
        public e b(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                switch (nB) {
                    case 0:
                        break;
                    case 8:
                        this.key = lyVar.nE();
                        continue;
                    case 16:
                        this.value = lyVar.nE();
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

        public int hashCode() {
            int i = (((this.key + 527) * 31) + this.value) * 31;
            int hashCode = (this.amX == null || this.amX.isEmpty()) ? 0 : this.amX.hashCode();
            return hashCode + i;
        }

        public e j() {
            this.key = 0;
            this.value = 0;
            this.amX = null;
            this.anb = -1;
            return this;
        }
    }

    public static final class f extends ma<f> {
        public String[] eV;
        public String[] eW;
        public com.google.android.gms.internal.d.a[] eX;
        public e[] eY;
        public b[] eZ;
        public b[] fa;
        public b[] fb;
        public g[] fc;
        public String fd;
        public String fe;
        public String ff;
        public String fg;
        public a fh;
        public float fi;
        public boolean fj;
        public String[] fk;
        public int fl;

        public f() {
            k();
        }

        public static f a(byte[] bArr) throws md {
            return (f) me.a(new f(), bArr);
        }

        public void a(lz lzVar) throws IOException {
            int i = 0;
            if (this.eW != null && this.eW.length > 0) {
                for (String str : this.eW) {
                    if (str != null) {
                        lzVar.b(1, str);
                    }
                }
            }
            if (this.eX != null && this.eX.length > 0) {
                for (me meVar : this.eX) {
                    if (meVar != null) {
                        lzVar.a(2, meVar);
                    }
                }
            }
            if (this.eY != null && this.eY.length > 0) {
                for (me meVar2 : this.eY) {
                    if (meVar2 != null) {
                        lzVar.a(3, meVar2);
                    }
                }
            }
            if (this.eZ != null && this.eZ.length > 0) {
                for (me meVar22 : this.eZ) {
                    if (meVar22 != null) {
                        lzVar.a(4, meVar22);
                    }
                }
            }
            if (this.fa != null && this.fa.length > 0) {
                for (me meVar222 : this.fa) {
                    if (meVar222 != null) {
                        lzVar.a(5, meVar222);
                    }
                }
            }
            if (this.fb != null && this.fb.length > 0) {
                for (me meVar2222 : this.fb) {
                    if (meVar2222 != null) {
                        lzVar.a(6, meVar2222);
                    }
                }
            }
            if (this.fc != null && this.fc.length > 0) {
                for (me meVar22222 : this.fc) {
                    if (meVar22222 != null) {
                        lzVar.a(7, meVar22222);
                    }
                }
            }
            if (!this.fd.equals("")) {
                lzVar.b(9, this.fd);
            }
            if (!this.fe.equals("")) {
                lzVar.b(10, this.fe);
            }
            if (!this.ff.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                lzVar.b(12, this.ff);
            }
            if (!this.fg.equals("")) {
                lzVar.b(13, this.fg);
            }
            if (this.fh != null) {
                lzVar.a(14, this.fh);
            }
            if (Float.floatToIntBits(this.fi) != Float.floatToIntBits(0.0f)) {
                lzVar.b(15, this.fi);
            }
            if (this.fk != null && this.fk.length > 0) {
                for (String str2 : this.fk) {
                    if (str2 != null) {
                        lzVar.b(16, str2);
                    }
                }
            }
            if (this.fl != 0) {
                lzVar.p(17, this.fl);
            }
            if (this.fj) {
                lzVar.a(18, this.fj);
            }
            if (this.eV != null && this.eV.length > 0) {
                while (i < this.eV.length) {
                    String str3 = this.eV[i];
                    if (str3 != null) {
                        lzVar.b(19, str3);
                    }
                    i++;
                }
            }
            super.a(lzVar);
        }

        protected int c() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int c = super.c();
            if (this.eW == null || this.eW.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.eW) {
                    if (str != null) {
                        i3++;
                        i2 += lz.cz(str);
                    }
                }
                i = (c + i2) + (i3 * 1);
            }
            if (this.eX != null && this.eX.length > 0) {
                i2 = i;
                for (me meVar : this.eX) {
                    if (meVar != null) {
                        i2 += lz.b(2, meVar);
                    }
                }
                i = i2;
            }
            if (this.eY != null && this.eY.length > 0) {
                i2 = i;
                for (me meVar2 : this.eY) {
                    if (meVar2 != null) {
                        i2 += lz.b(3, meVar2);
                    }
                }
                i = i2;
            }
            if (this.eZ != null && this.eZ.length > 0) {
                i2 = i;
                for (me meVar22 : this.eZ) {
                    if (meVar22 != null) {
                        i2 += lz.b(4, meVar22);
                    }
                }
                i = i2;
            }
            if (this.fa != null && this.fa.length > 0) {
                i2 = i;
                for (me meVar222 : this.fa) {
                    if (meVar222 != null) {
                        i2 += lz.b(5, meVar222);
                    }
                }
                i = i2;
            }
            if (this.fb != null && this.fb.length > 0) {
                i2 = i;
                for (me meVar2222 : this.fb) {
                    if (meVar2222 != null) {
                        i2 += lz.b(6, meVar2222);
                    }
                }
                i = i2;
            }
            if (this.fc != null && this.fc.length > 0) {
                i2 = i;
                for (me meVar22222 : this.fc) {
                    if (meVar22222 != null) {
                        i2 += lz.b(7, meVar22222);
                    }
                }
                i = i2;
            }
            if (!this.fd.equals("")) {
                i += lz.h(9, this.fd);
            }
            if (!this.fe.equals("")) {
                i += lz.h(10, this.fe);
            }
            if (!this.ff.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                i += lz.h(12, this.ff);
            }
            if (!this.fg.equals("")) {
                i += lz.h(13, this.fg);
            }
            if (this.fh != null) {
                i += lz.b(14, this.fh);
            }
            if (Float.floatToIntBits(this.fi) != Float.floatToIntBits(0.0f)) {
                i += lz.c(15, this.fi);
            }
            if (this.fk != null && this.fk.length > 0) {
                i3 = 0;
                c = 0;
                for (String str2 : this.fk) {
                    if (str2 != null) {
                        c++;
                        i3 += lz.cz(str2);
                    }
                }
                i = (i + i3) + (c * 2);
            }
            if (this.fl != 0) {
                i += lz.r(17, this.fl);
            }
            if (this.fj) {
                i += lz.b(18, this.fj);
            }
            if (this.eV == null || this.eV.length <= 0) {
                return i;
            }
            i2 = 0;
            i3 = 0;
            while (i4 < this.eV.length) {
                String str3 = this.eV[i4];
                if (str3 != null) {
                    i3++;
                    i2 += lz.cz(str3);
                }
                i4++;
            }
            return (i + i2) + (i3 * 2);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof f)) {
                return false;
            }
            f fVar = (f) o;
            if (!mc.equals(this.eV, fVar.eV) || !mc.equals(this.eW, fVar.eW) || !mc.equals(this.eX, fVar.eX) || !mc.equals(this.eY, fVar.eY) || !mc.equals(this.eZ, fVar.eZ) || !mc.equals(this.fa, fVar.fa) || !mc.equals(this.fb, fVar.fb) || !mc.equals(this.fc, fVar.fc)) {
                return false;
            }
            if (this.fd == null) {
                if (fVar.fd != null) {
                    return false;
                }
            } else if (!this.fd.equals(fVar.fd)) {
                return false;
            }
            if (this.fe == null) {
                if (fVar.fe != null) {
                    return false;
                }
            } else if (!this.fe.equals(fVar.fe)) {
                return false;
            }
            if (this.ff == null) {
                if (fVar.ff != null) {
                    return false;
                }
            } else if (!this.ff.equals(fVar.ff)) {
                return false;
            }
            if (this.fg == null) {
                if (fVar.fg != null) {
                    return false;
                }
            } else if (!this.fg.equals(fVar.fg)) {
                return false;
            }
            if (this.fh == null) {
                if (fVar.fh != null) {
                    return false;
                }
            } else if (!this.fh.equals(fVar.fh)) {
                return false;
            }
            if (Float.floatToIntBits(this.fi) != Float.floatToIntBits(fVar.fi) || this.fj != fVar.fj || !mc.equals(this.fk, fVar.fk) || this.fl != fVar.fl) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return fVar.amX == null || fVar.amX.isEmpty();
            } else {
                return this.amX.equals(fVar.amX);
            }
        }

        /* renamed from: g */
        public f b(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                int b;
                Object obj;
                switch (nB) {
                    case 0:
                        break;
                    case 10:
                        b = mh.b(lyVar, 10);
                        nB = this.eW == null ? 0 : this.eW.length;
                        obj = new String[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eW, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.readString();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.readString();
                        this.eW = obj;
                        continue;
                    case 18:
                        b = mh.b(lyVar, 18);
                        nB = this.eX == null ? 0 : this.eX.length;
                        obj = new com.google.android.gms.internal.d.a[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eX, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new com.google.android.gms.internal.d.a();
                            lyVar.a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new com.google.android.gms.internal.d.a();
                        lyVar.a(obj[nB]);
                        this.eX = obj;
                        continue;
                    case MMException.AD_NO_ACTIVITY /*26*/:
                        b = mh.b(lyVar, 26);
                        nB = this.eY == null ? 0 : this.eY.length;
                        obj = new e[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eY, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new e();
                            lyVar.a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new e();
                        lyVar.a(obj[nB]);
                        this.eY = obj;
                        continue;
                    case 34:
                        b = mh.b(lyVar, 34);
                        nB = this.eZ == null ? 0 : this.eZ.length;
                        obj = new b[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eZ, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new b();
                            lyVar.a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new b();
                        lyVar.a(obj[nB]);
                        this.eZ = obj;
                        continue;
                    case 42:
                        b = mh.b(lyVar, 42);
                        nB = this.fa == null ? 0 : this.fa.length;
                        obj = new b[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fa, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new b();
                            lyVar.a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new b();
                        lyVar.a(obj[nB]);
                        this.fa = obj;
                        continue;
                    case 50:
                        b = mh.b(lyVar, 50);
                        nB = this.fb == null ? 0 : this.fb.length;
                        obj = new b[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fb, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new b();
                            lyVar.a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new b();
                        lyVar.a(obj[nB]);
                        this.fb = obj;
                        continue;
                    case 58:
                        b = mh.b(lyVar, 58);
                        nB = this.fc == null ? 0 : this.fc.length;
                        obj = new g[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fc, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new g();
                            lyVar.a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new g();
                        lyVar.a(obj[nB]);
                        this.fc = obj;
                        continue;
                    case 74:
                        this.fd = lyVar.readString();
                        continue;
                    case 82:
                        this.fe = lyVar.readString();
                        continue;
                    case 98:
                        this.ff = lyVar.readString();
                        continue;
                    case 106:
                        this.fg = lyVar.readString();
                        continue;
                    case 114:
                        if (this.fh == null) {
                            this.fh = new a();
                        }
                        lyVar.a(this.fh);
                        continue;
                    case 125:
                        this.fi = lyVar.readFloat();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        b = mh.b(lyVar, TransportMediator.KEYCODE_MEDIA_RECORD);
                        nB = this.fk == null ? 0 : this.fk.length;
                        obj = new String[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fk, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.readString();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.readString();
                        this.fk = obj;
                        continue;
                    case 136:
                        this.fl = lyVar.nE();
                        continue;
                    case 144:
                        this.fj = lyVar.nF();
                        continue;
                    case 154:
                        b = mh.b(lyVar, 154);
                        nB = this.eV == null ? 0 : this.eV.length;
                        obj = new String[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eV, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.readString();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.readString();
                        this.eV = obj;
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

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((this.fj ? 1231 : 1237) + (((((this.fh == null ? 0 : this.fh.hashCode()) + (((this.fg == null ? 0 : this.fg.hashCode()) + (((this.ff == null ? 0 : this.ff.hashCode()) + (((this.fe == null ? 0 : this.fe.hashCode()) + (((this.fd == null ? 0 : this.fd.hashCode()) + ((((((((((((((((mc.hashCode(this.eV) + 527) * 31) + mc.hashCode(this.eW)) * 31) + mc.hashCode(this.eX)) * 31) + mc.hashCode(this.eY)) * 31) + mc.hashCode(this.eZ)) * 31) + mc.hashCode(this.fa)) * 31) + mc.hashCode(this.fb)) * 31) + mc.hashCode(this.fc)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + Float.floatToIntBits(this.fi)) * 31)) * 31) + mc.hashCode(this.fk)) * 31) + this.fl) * 31;
            if (!(this.amX == null || this.amX.isEmpty())) {
                i = this.amX.hashCode();
            }
            return hashCode + i;
        }

        public f k() {
            this.eV = mh.ani;
            this.eW = mh.ani;
            this.eX = com.google.android.gms.internal.d.a.r();
            this.eY = e.i();
            this.eZ = b.d();
            this.fa = b.d();
            this.fb = b.d();
            this.fc = g.l();
            this.fd = "";
            this.fe = "";
            this.ff = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            this.fg = "";
            this.fh = null;
            this.fi = 0.0f;
            this.fj = false;
            this.fk = mh.ani;
            this.fl = 0;
            this.amX = null;
            this.anb = -1;
            return this;
        }
    }

    public static final class g extends ma<g> {
        private static volatile g[] fm;
        public int[] fn;
        public int[] fo;
        public int[] fp;
        public int[] fq;
        public int[] fr;
        public int[] fs;
        public int[] ft;
        public int[] fu;
        public int[] fv;
        public int[] fw;

        public g() {
            m();
        }

        public static g[] l() {
            if (fm == null) {
                synchronized (mc.ana) {
                    if (fm == null) {
                        fm = new g[0];
                    }
                }
            }
            return fm;
        }

        public void a(lz lzVar) throws IOException {
            int i = 0;
            if (this.fn != null && this.fn.length > 0) {
                for (int p : this.fn) {
                    lzVar.p(1, p);
                }
            }
            if (this.fo != null && this.fo.length > 0) {
                for (int p2 : this.fo) {
                    lzVar.p(2, p2);
                }
            }
            if (this.fp != null && this.fp.length > 0) {
                for (int p22 : this.fp) {
                    lzVar.p(3, p22);
                }
            }
            if (this.fq != null && this.fq.length > 0) {
                for (int p222 : this.fq) {
                    lzVar.p(4, p222);
                }
            }
            if (this.fr != null && this.fr.length > 0) {
                for (int p2222 : this.fr) {
                    lzVar.p(5, p2222);
                }
            }
            if (this.fs != null && this.fs.length > 0) {
                for (int p22222 : this.fs) {
                    lzVar.p(6, p22222);
                }
            }
            if (this.ft != null && this.ft.length > 0) {
                for (int p222222 : this.ft) {
                    lzVar.p(7, p222222);
                }
            }
            if (this.fu != null && this.fu.length > 0) {
                for (int p2222222 : this.fu) {
                    lzVar.p(8, p2222222);
                }
            }
            if (this.fv != null && this.fv.length > 0) {
                for (int p22222222 : this.fv) {
                    lzVar.p(9, p22222222);
                }
            }
            if (this.fw != null && this.fw.length > 0) {
                while (i < this.fw.length) {
                    lzVar.p(10, this.fw[i]);
                    i++;
                }
            }
            super.a(lzVar);
        }

        protected int c() {
            int i;
            int i2;
            int i3 = 0;
            int c = super.c();
            if (this.fn == null || this.fn.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                for (int eE : this.fn) {
                    i2 += lz.eE(eE);
                }
                i = (c + i2) + (this.fn.length * 1);
            }
            if (this.fo != null && this.fo.length > 0) {
                c = 0;
                for (int eE2 : this.fo) {
                    c += lz.eE(eE2);
                }
                i = (i + c) + (this.fo.length * 1);
            }
            if (this.fp != null && this.fp.length > 0) {
                c = 0;
                for (int eE22 : this.fp) {
                    c += lz.eE(eE22);
                }
                i = (i + c) + (this.fp.length * 1);
            }
            if (this.fq != null && this.fq.length > 0) {
                c = 0;
                for (int eE222 : this.fq) {
                    c += lz.eE(eE222);
                }
                i = (i + c) + (this.fq.length * 1);
            }
            if (this.fr != null && this.fr.length > 0) {
                c = 0;
                for (int eE2222 : this.fr) {
                    c += lz.eE(eE2222);
                }
                i = (i + c) + (this.fr.length * 1);
            }
            if (this.fs != null && this.fs.length > 0) {
                c = 0;
                for (int eE22222 : this.fs) {
                    c += lz.eE(eE22222);
                }
                i = (i + c) + (this.fs.length * 1);
            }
            if (this.ft != null && this.ft.length > 0) {
                c = 0;
                for (int eE222222 : this.ft) {
                    c += lz.eE(eE222222);
                }
                i = (i + c) + (this.ft.length * 1);
            }
            if (this.fu != null && this.fu.length > 0) {
                c = 0;
                for (int eE2222222 : this.fu) {
                    c += lz.eE(eE2222222);
                }
                i = (i + c) + (this.fu.length * 1);
            }
            if (this.fv != null && this.fv.length > 0) {
                c = 0;
                for (int eE22222222 : this.fv) {
                    c += lz.eE(eE22222222);
                }
                i = (i + c) + (this.fv.length * 1);
            }
            if (this.fw == null || this.fw.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i3 < this.fw.length) {
                i2 += lz.eE(this.fw[i3]);
                i3++;
            }
            return (i + i2) + (this.fw.length * 1);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof g)) {
                return false;
            }
            g gVar = (g) o;
            if (!mc.equals(this.fn, gVar.fn) || !mc.equals(this.fo, gVar.fo) || !mc.equals(this.fp, gVar.fp) || !mc.equals(this.fq, gVar.fq) || !mc.equals(this.fr, gVar.fr) || !mc.equals(this.fs, gVar.fs) || !mc.equals(this.ft, gVar.ft) || !mc.equals(this.fu, gVar.fu) || !mc.equals(this.fv, gVar.fv) || !mc.equals(this.fw, gVar.fw)) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return gVar.amX == null || gVar.amX.isEmpty();
            } else {
                return this.amX.equals(gVar.amX);
            }
        }

        /* renamed from: h */
        public g b(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                int b;
                Object obj;
                int ex;
                Object obj2;
                switch (nB) {
                    case 0:
                        break;
                    case 8:
                        b = mh.b(lyVar, 8);
                        nB = this.fn == null ? 0 : this.fn.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fn, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fn = obj;
                        continue;
                    case 10:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fn == null ? 0 : this.fn.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fn, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fn = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 16:
                        b = mh.b(lyVar, 16);
                        nB = this.fo == null ? 0 : this.fo.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fo, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fo = obj;
                        continue;
                    case 18:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fo == null ? 0 : this.fo.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fo, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fo = obj2;
                        lyVar.ey(ex);
                        continue;
                    case MMException.DISPLAY_AD_NOT_PERMITTED /*24*/:
                        b = mh.b(lyVar, 24);
                        nB = this.fp == null ? 0 : this.fp.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fp, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fp = obj;
                        continue;
                    case MMException.AD_NO_ACTIVITY /*26*/:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fp == null ? 0 : this.fp.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fp, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fp = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 32:
                        b = mh.b(lyVar, 32);
                        nB = this.fq == null ? 0 : this.fq.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fq, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fq = obj;
                        continue;
                    case 34:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fq == null ? 0 : this.fq.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fq, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fq = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 40:
                        b = mh.b(lyVar, 40);
                        nB = this.fr == null ? 0 : this.fr.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fr, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fr = obj;
                        continue;
                    case 42:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fr == null ? 0 : this.fr.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fr, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fr = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 48:
                        b = mh.b(lyVar, 48);
                        nB = this.fs == null ? 0 : this.fs.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fs, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fs = obj;
                        continue;
                    case 50:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fs == null ? 0 : this.fs.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fs, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fs = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 56:
                        b = mh.b(lyVar, 56);
                        nB = this.ft == null ? 0 : this.ft.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.ft, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.ft = obj;
                        continue;
                    case 58:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.ft == null ? 0 : this.ft.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.ft, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.ft = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 64:
                        b = mh.b(lyVar, 64);
                        nB = this.fu == null ? 0 : this.fu.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fu, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fu = obj;
                        continue;
                    case 66:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fu == null ? 0 : this.fu.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fu, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fu = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 72:
                        b = mh.b(lyVar, 72);
                        nB = this.fv == null ? 0 : this.fv.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fv, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fv = obj;
                        continue;
                    case 74:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fv == null ? 0 : this.fv.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fv, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fv = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 80:
                        b = mh.b(lyVar, 80);
                        nB = this.fw == null ? 0 : this.fw.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fw, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fw = obj;
                        continue;
                    case 82:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fw == null ? 0 : this.fw.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fw, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fw = obj2;
                        lyVar.ey(ex);
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

        public int hashCode() {
            int hashCode = (((((((((((((((((((mc.hashCode(this.fn) + 527) * 31) + mc.hashCode(this.fo)) * 31) + mc.hashCode(this.fp)) * 31) + mc.hashCode(this.fq)) * 31) + mc.hashCode(this.fr)) * 31) + mc.hashCode(this.fs)) * 31) + mc.hashCode(this.ft)) * 31) + mc.hashCode(this.fu)) * 31) + mc.hashCode(this.fv)) * 31) + mc.hashCode(this.fw)) * 31;
            int hashCode2 = (this.amX == null || this.amX.isEmpty()) ? 0 : this.amX.hashCode();
            return hashCode2 + hashCode;
        }

        public g m() {
            this.fn = mh.and;
            this.fo = mh.and;
            this.fp = mh.and;
            this.fq = mh.and;
            this.fr = mh.and;
            this.fs = mh.and;
            this.ft = mh.and;
            this.fu = mh.and;
            this.fv = mh.and;
            this.fw = mh.and;
            this.amX = null;
            this.anb = -1;
            return this;
        }
    }

    public static final class h extends ma<h> {
        public static final mb<com.google.android.gms.internal.d.a, h> fx = mb.a(11, h.class, 810);
        private static final h[] fy = new h[0];
        public int[] fA;
        public int[] fB;
        public int fC;
        public int[] fD;
        public int fE;
        public int fF;
        public int[] fz;

        public h() {
            n();
        }

        public void a(lz lzVar) throws IOException {
            int i = 0;
            if (this.fz != null && this.fz.length > 0) {
                for (int p : this.fz) {
                    lzVar.p(1, p);
                }
            }
            if (this.fA != null && this.fA.length > 0) {
                for (int p2 : this.fA) {
                    lzVar.p(2, p2);
                }
            }
            if (this.fB != null && this.fB.length > 0) {
                for (int p22 : this.fB) {
                    lzVar.p(3, p22);
                }
            }
            if (this.fC != 0) {
                lzVar.p(4, this.fC);
            }
            if (this.fD != null && this.fD.length > 0) {
                while (i < this.fD.length) {
                    lzVar.p(5, this.fD[i]);
                    i++;
                }
            }
            if (this.fE != 0) {
                lzVar.p(6, this.fE);
            }
            if (this.fF != 0) {
                lzVar.p(7, this.fF);
            }
            super.a(lzVar);
        }

        protected int c() {
            int i;
            int i2;
            int i3 = 0;
            int c = super.c();
            if (this.fz == null || this.fz.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                for (int eE : this.fz) {
                    i2 += lz.eE(eE);
                }
                i = (c + i2) + (this.fz.length * 1);
            }
            if (this.fA != null && this.fA.length > 0) {
                c = 0;
                for (int eE2 : this.fA) {
                    c += lz.eE(eE2);
                }
                i = (i + c) + (this.fA.length * 1);
            }
            if (this.fB != null && this.fB.length > 0) {
                c = 0;
                for (int eE22 : this.fB) {
                    c += lz.eE(eE22);
                }
                i = (i + c) + (this.fB.length * 1);
            }
            if (this.fC != 0) {
                i += lz.r(4, this.fC);
            }
            if (this.fD != null && this.fD.length > 0) {
                i2 = 0;
                while (i3 < this.fD.length) {
                    i2 += lz.eE(this.fD[i3]);
                    i3++;
                }
                i = (i + i2) + (this.fD.length * 1);
            }
            if (this.fE != 0) {
                i += lz.r(6, this.fE);
            }
            return this.fF != 0 ? i + lz.r(7, this.fF) : i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof h)) {
                return false;
            }
            h hVar = (h) o;
            if (!mc.equals(this.fz, hVar.fz) || !mc.equals(this.fA, hVar.fA) || !mc.equals(this.fB, hVar.fB) || this.fC != hVar.fC || !mc.equals(this.fD, hVar.fD) || this.fE != hVar.fE || this.fF != hVar.fF) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return hVar.amX == null || hVar.amX.isEmpty();
            } else {
                return this.amX.equals(hVar.amX);
            }
        }

        public int hashCode() {
            int hashCode = (((((((((((((mc.hashCode(this.fz) + 527) * 31) + mc.hashCode(this.fA)) * 31) + mc.hashCode(this.fB)) * 31) + this.fC) * 31) + mc.hashCode(this.fD)) * 31) + this.fE) * 31) + this.fF) * 31;
            int hashCode2 = (this.amX == null || this.amX.isEmpty()) ? 0 : this.amX.hashCode();
            return hashCode2 + hashCode;
        }

        /* renamed from: i */
        public h b(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                int b;
                Object obj;
                int ex;
                Object obj2;
                switch (nB) {
                    case 0:
                        break;
                    case 8:
                        b = mh.b(lyVar, 8);
                        nB = this.fz == null ? 0 : this.fz.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fz, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fz = obj;
                        continue;
                    case 10:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fz == null ? 0 : this.fz.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fz, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fz = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 16:
                        b = mh.b(lyVar, 16);
                        nB = this.fA == null ? 0 : this.fA.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fA, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fA = obj;
                        continue;
                    case 18:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fA == null ? 0 : this.fA.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fA, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fA = obj2;
                        lyVar.ey(ex);
                        continue;
                    case MMException.DISPLAY_AD_NOT_PERMITTED /*24*/:
                        b = mh.b(lyVar, 24);
                        nB = this.fB == null ? 0 : this.fB.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fB, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fB = obj;
                        continue;
                    case MMException.AD_NO_ACTIVITY /*26*/:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fB == null ? 0 : this.fB.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fB, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fB = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 32:
                        this.fC = lyVar.nE();
                        continue;
                    case 40:
                        b = mh.b(lyVar, 40);
                        nB = this.fD == null ? 0 : this.fD.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fD, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fD = obj;
                        continue;
                    case 42:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fD == null ? 0 : this.fD.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fD, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fD = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 48:
                        this.fE = lyVar.nE();
                        continue;
                    case 56:
                        this.fF = lyVar.nE();
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

        public h n() {
            this.fz = mh.and;
            this.fA = mh.and;
            this.fB = mh.and;
            this.fC = 0;
            this.fD = mh.and;
            this.fE = 0;
            this.fF = 0;
            this.amX = null;
            this.anb = -1;
            return this;
        }
    }

    public static final class i extends ma<i> {
        private static volatile i[] fG;
        public com.google.android.gms.internal.d.a fH;
        public d fI;
        public String name;

        public i() {
            p();
        }

        public static i[] o() {
            if (fG == null) {
                synchronized (mc.ana) {
                    if (fG == null) {
                        fG = new i[0];
                    }
                }
            }
            return fG;
        }

        public void a(lz lzVar) throws IOException {
            if (!this.name.equals("")) {
                lzVar.b(1, this.name);
            }
            if (this.fH != null) {
                lzVar.a(2, this.fH);
            }
            if (this.fI != null) {
                lzVar.a(3, this.fI);
            }
            super.a(lzVar);
        }

        protected int c() {
            int c = super.c();
            if (!this.name.equals("")) {
                c += lz.h(1, this.name);
            }
            if (this.fH != null) {
                c += lz.b(2, this.fH);
            }
            return this.fI != null ? c + lz.b(3, this.fI) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof i)) {
                return false;
            }
            i iVar = (i) o;
            if (this.name == null) {
                if (iVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(iVar.name)) {
                return false;
            }
            if (this.fH == null) {
                if (iVar.fH != null) {
                    return false;
                }
            } else if (!this.fH.equals(iVar.fH)) {
                return false;
            }
            if (this.fI == null) {
                if (iVar.fI != null) {
                    return false;
                }
            } else if (!this.fI.equals(iVar.fI)) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return iVar.amX == null || iVar.amX.isEmpty();
            } else {
                return this.amX.equals(iVar.amX);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.fI == null ? 0 : this.fI.hashCode()) + (((this.fH == null ? 0 : this.fH.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + 527) * 31)) * 31)) * 31;
            if (!(this.amX == null || this.amX.isEmpty())) {
                i = this.amX.hashCode();
            }
            return hashCode + i;
        }

        /* renamed from: j */
        public i b(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                switch (nB) {
                    case 0:
                        break;
                    case 10:
                        this.name = lyVar.readString();
                        continue;
                    case 18:
                        if (this.fH == null) {
                            this.fH = new com.google.android.gms.internal.d.a();
                        }
                        lyVar.a(this.fH);
                        continue;
                    case MMException.AD_NO_ACTIVITY /*26*/:
                        if (this.fI == null) {
                            this.fI = new d();
                        }
                        lyVar.a(this.fI);
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

        public i p() {
            this.name = "";
            this.fH = null;
            this.fI = null;
            this.amX = null;
            this.anb = -1;
            return this;
        }
    }

    public static final class j extends ma<j> {
        public i[] fJ;
        public f fK;
        public String fL;

        public j() {
            q();
        }

        public static j b(byte[] bArr) throws md {
            return (j) me.a(new j(), bArr);
        }

        public void a(lz lzVar) throws IOException {
            if (this.fJ != null && this.fJ.length > 0) {
                for (me meVar : this.fJ) {
                    if (meVar != null) {
                        lzVar.a(1, meVar);
                    }
                }
            }
            if (this.fK != null) {
                lzVar.a(2, this.fK);
            }
            if (!this.fL.equals("")) {
                lzVar.b(3, this.fL);
            }
            super.a(lzVar);
        }

        protected int c() {
            int c = super.c();
            if (this.fJ != null && this.fJ.length > 0) {
                for (me meVar : this.fJ) {
                    if (meVar != null) {
                        c += lz.b(1, meVar);
                    }
                }
            }
            if (this.fK != null) {
                c += lz.b(2, this.fK);
            }
            return !this.fL.equals("") ? c + lz.h(3, this.fL) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof j)) {
                return false;
            }
            j jVar = (j) o;
            if (!mc.equals(this.fJ, jVar.fJ)) {
                return false;
            }
            if (this.fK == null) {
                if (jVar.fK != null) {
                    return false;
                }
            } else if (!this.fK.equals(jVar.fK)) {
                return false;
            }
            if (this.fL == null) {
                if (jVar.fL != null) {
                    return false;
                }
            } else if (!this.fL.equals(jVar.fL)) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return jVar.amX == null || jVar.amX.isEmpty();
            } else {
                return this.amX.equals(jVar.amX);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.fL == null ? 0 : this.fL.hashCode()) + (((this.fK == null ? 0 : this.fK.hashCode()) + ((mc.hashCode(this.fJ) + 527) * 31)) * 31)) * 31;
            if (!(this.amX == null || this.amX.isEmpty())) {
                i = this.amX.hashCode();
            }
            return hashCode + i;
        }

        /* renamed from: k */
        public j b(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                switch (nB) {
                    case 0:
                        break;
                    case 10:
                        int b = mh.b(lyVar, 10);
                        nB = this.fJ == null ? 0 : this.fJ.length;
                        Object obj = new i[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fJ, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new i();
                            lyVar.a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new i();
                        lyVar.a(obj[nB]);
                        this.fJ = obj;
                        continue;
                    case 18:
                        if (this.fK == null) {
                            this.fK = new f();
                        }
                        lyVar.a(this.fK);
                        continue;
                    case MMException.AD_NO_ACTIVITY /*26*/:
                        this.fL = lyVar.readString();
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

        public j q() {
            this.fJ = i.o();
            this.fK = null;
            this.fL = "";
            this.amX = null;
            this.anb = -1;
            return this;
        }
    }
}
