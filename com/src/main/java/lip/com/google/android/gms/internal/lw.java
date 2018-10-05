package lip.com.google.android.gms.internal;

import com.google.ads.AdSize;
import com.google.android.gms.location.LocationRequest;
import com.millennialmedia.android.MMException;
import java.io.IOException;
import java.util.Arrays;

public final class lw extends ma<lw> {
    public a[] amr;

    public static final class a extends ma<a> {
        private static volatile a[] ams;
        public a amt;
        public String name;

        public static final class a extends ma<a> {
            private static volatile a[] amu;
            public a amv;
            public int type;

            public static final class a extends ma<a> {
                public long amA;
                public int amB;
                public int amC;
                public boolean amD;
                public a[] amE;
                public a[] amF;
                public String[] amG;
                public long[] amH;
                public float[] amI;
                public long amJ;
                public byte[] amw;
                public String amx;
                public double amy;
                public float amz;

                public a() {
                    nA();
                }

                public void a(lz lzVar) throws IOException {
                    int i = 0;
                    if (!Arrays.equals(this.amw, mh.ank)) {
                        lzVar.a(1, this.amw);
                    }
                    if (!this.amx.equals("")) {
                        lzVar.b(2, this.amx);
                    }
                    if (Double.doubleToLongBits(this.amy) != Double.doubleToLongBits(0.0d)) {
                        lzVar.a(3, this.amy);
                    }
                    if (Float.floatToIntBits(this.amz) != Float.floatToIntBits(0.0f)) {
                        lzVar.b(4, this.amz);
                    }
                    if (this.amA != 0) {
                        lzVar.b(5, this.amA);
                    }
                    if (this.amB != 0) {
                        lzVar.p(6, this.amB);
                    }
                    if (this.amC != 0) {
                        lzVar.q(7, this.amC);
                    }
                    if (this.amD) {
                        lzVar.a(8, this.amD);
                    }
                    if (this.amE != null && this.amE.length > 0) {
                        for (me meVar : this.amE) {
                            if (meVar != null) {
                                lzVar.a(9, meVar);
                            }
                        }
                    }
                    if (this.amF != null && this.amF.length > 0) {
                        for (me meVar2 : this.amF) {
                            if (meVar2 != null) {
                                lzVar.a(10, meVar2);
                            }
                        }
                    }
                    if (this.amG != null && this.amG.length > 0) {
                        for (String str : this.amG) {
                            if (str != null) {
                                lzVar.b(11, str);
                            }
                        }
                    }
                    if (this.amH != null && this.amH.length > 0) {
                        for (long b : this.amH) {
                            lzVar.b(12, b);
                        }
                    }
                    if (this.amJ != 0) {
                        lzVar.b(13, this.amJ);
                    }
                    if (this.amI != null && this.amI.length > 0) {
                        while (i < this.amI.length) {
                            lzVar.b(14, this.amI[i]);
                            i++;
                        }
                    }
                    super.a(lzVar);
                }

                protected int c() {
                    int i;
                    int i2 = 0;
                    int c = super.c();
                    if (!Arrays.equals(this.amw, mh.ank)) {
                        c += lz.b(1, this.amw);
                    }
                    if (!this.amx.equals("")) {
                        c += lz.h(2, this.amx);
                    }
                    if (Double.doubleToLongBits(this.amy) != Double.doubleToLongBits(0.0d)) {
                        c += lz.b(3, this.amy);
                    }
                    if (Float.floatToIntBits(this.amz) != Float.floatToIntBits(0.0f)) {
                        c += lz.c(4, this.amz);
                    }
                    if (this.amA != 0) {
                        c += lz.d(5, this.amA);
                    }
                    if (this.amB != 0) {
                        c += lz.r(6, this.amB);
                    }
                    if (this.amC != 0) {
                        c += lz.s(7, this.amC);
                    }
                    if (this.amD) {
                        c += lz.b(8, this.amD);
                    }
                    if (this.amE != null && this.amE.length > 0) {
                        i = c;
                        for (me meVar : this.amE) {
                            if (meVar != null) {
                                i += lz.b(9, meVar);
                            }
                        }
                        c = i;
                    }
                    if (this.amF != null && this.amF.length > 0) {
                        i = c;
                        for (me meVar2 : this.amF) {
                            if (meVar2 != null) {
                                i += lz.b(10, meVar2);
                            }
                        }
                        c = i;
                    }
                    if (this.amG != null && this.amG.length > 0) {
                        int i3 = 0;
                        int i4 = 0;
                        for (String str : this.amG) {
                            if (str != null) {
                                i4++;
                                i3 += lz.cz(str);
                            }
                        }
                        c = (c + i3) + (i4 * 1);
                    }
                    if (this.amH != null && this.amH.length > 0) {
                        i = 0;
                        while (i2 < this.amH.length) {
                            i += lz.D(this.amH[i2]);
                            i2++;
                        }
                        c = (c + i) + (this.amH.length * 1);
                    }
                    if (this.amJ != 0) {
                        c += lz.d(13, this.amJ);
                    }
                    return (this.amI == null || this.amI.length <= 0) ? c : (c + (this.amI.length * 4)) + (this.amI.length * 1);
                }

                public boolean equals(Object o) {
                    if (o == this) {
                        return true;
                    }
                    if (!(o instanceof a)) {
                        return false;
                    }
                    a aVar = (a) o;
                    if (!Arrays.equals(this.amw, aVar.amw)) {
                        return false;
                    }
                    if (this.amx == null) {
                        if (aVar.amx != null) {
                            return false;
                        }
                    } else if (!this.amx.equals(aVar.amx)) {
                        return false;
                    }
                    if (Double.doubleToLongBits(this.amy) != Double.doubleToLongBits(aVar.amy) || Float.floatToIntBits(this.amz) != Float.floatToIntBits(aVar.amz) || this.amA != aVar.amA || this.amB != aVar.amB || this.amC != aVar.amC || this.amD != aVar.amD || !mc.equals(this.amE, aVar.amE) || !mc.equals(this.amF, aVar.amF) || !mc.equals(this.amG, aVar.amG) || !mc.equals(this.amH, aVar.amH) || !mc.equals(this.amI, aVar.amI) || this.amJ != aVar.amJ) {
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
                    int hashCode = (this.amx == null ? 0 : this.amx.hashCode()) + ((Arrays.hashCode(this.amw) + 527) * 31);
                    long doubleToLongBits = Double.doubleToLongBits(this.amy);
                    hashCode = ((((((((((((((this.amD ? 1231 : 1237) + (((((((((((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + Float.floatToIntBits(this.amz)) * 31) + ((int) (this.amA ^ (this.amA >>> 32)))) * 31) + this.amB) * 31) + this.amC) * 31)) * 31) + mc.hashCode(this.amE)) * 31) + mc.hashCode(this.amF)) * 31) + mc.hashCode(this.amG)) * 31) + mc.hashCode(this.amH)) * 31) + mc.hashCode(this.amI)) * 31) + ((int) (this.amJ ^ (this.amJ >>> 32)))) * 31;
                    if (!(this.amX == null || this.amX.isEmpty())) {
                        i = this.amX.hashCode();
                    }
                    return hashCode + i;
                }

                public a nA() {
                    this.amw = mh.ank;
                    this.amx = "";
                    this.amy = 0.0d;
                    this.amz = 0.0f;
                    this.amA = 0;
                    this.amB = 0;
                    this.amC = 0;
                    this.amD = false;
                    this.amE = a.nw();
                    this.amF = a.ny();
                    this.amG = mh.ani;
                    this.amH = mh.ane;
                    this.amI = mh.anf;
                    this.amJ = 0;
                    this.amX = null;
                    this.anb = -1;
                    return this;
                }

                /* renamed from: t */
                public a b(ly lyVar) throws IOException {
                    while (true) {
                        int nB = lyVar.nB();
                        int b;
                        Object obj;
                        int ex;
                        switch (nB) {
                            case 0:
                                break;
                            case 10:
                                this.amw = lyVar.readBytes();
                                continue;
                            case 18:
                                this.amx = lyVar.readString();
                                continue;
                            case MMException.AD_BROKEN_REFERENCE /*25*/:
                                this.amy = lyVar.readDouble();
                                continue;
                            case 37:
                                this.amz = lyVar.readFloat();
                                continue;
                            case 40:
                                this.amA = lyVar.nD();
                                continue;
                            case 48:
                                this.amB = lyVar.nE();
                                continue;
                            case 56:
                                this.amC = lyVar.nG();
                                continue;
                            case 64:
                                this.amD = lyVar.nF();
                                continue;
                            case 74:
                                b = mh.b(lyVar, 74);
                                nB = this.amE == null ? 0 : this.amE.length;
                                obj = new a[(b + nB)];
                                if (nB != 0) {
                                    System.arraycopy(this.amE, 0, obj, 0, nB);
                                }
                                while (nB < obj.length - 1) {
                                    obj[nB] = new a();
                                    lyVar.a(obj[nB]);
                                    lyVar.nB();
                                    nB++;
                                }
                                obj[nB] = new a();
                                lyVar.a(obj[nB]);
                                this.amE = obj;
                                continue;
                            case 82:
                                b = mh.b(lyVar, 82);
                                nB = this.amF == null ? 0 : this.amF.length;
                                obj = new a[(b + nB)];
                                if (nB != 0) {
                                    System.arraycopy(this.amF, 0, obj, 0, nB);
                                }
                                while (nB < obj.length - 1) {
                                    obj[nB] = new a();
                                    lyVar.a(obj[nB]);
                                    lyVar.nB();
                                    nB++;
                                }
                                obj[nB] = new a();
                                lyVar.a(obj[nB]);
                                this.amF = obj;
                                continue;
                            case AdSize.LARGE_AD_HEIGHT /*90*/:
                                b = mh.b(lyVar, 90);
                                nB = this.amG == null ? 0 : this.amG.length;
                                obj = new String[(b + nB)];
                                if (nB != 0) {
                                    System.arraycopy(this.amG, 0, obj, 0, nB);
                                }
                                while (nB < obj.length - 1) {
                                    obj[nB] = lyVar.readString();
                                    lyVar.nB();
                                    nB++;
                                }
                                obj[nB] = lyVar.readString();
                                this.amG = obj;
                                continue;
                            case 96:
                                b = mh.b(lyVar, 96);
                                nB = this.amH == null ? 0 : this.amH.length;
                                obj = new long[(b + nB)];
                                if (nB != 0) {
                                    System.arraycopy(this.amH, 0, obj, 0, nB);
                                }
                                while (nB < obj.length - 1) {
                                    obj[nB] = lyVar.nD();
                                    lyVar.nB();
                                    nB++;
                                }
                                obj[nB] = lyVar.nD();
                                this.amH = obj;
                                continue;
                            case 98:
                                ex = lyVar.ex(lyVar.nI());
                                b = lyVar.getPosition();
                                nB = 0;
                                while (lyVar.nN() > 0) {
                                    lyVar.nD();
                                    nB++;
                                }
                                lyVar.ez(b);
                                b = this.amH == null ? 0 : this.amH.length;
                                Object obj2 = new long[(nB + b)];
                                if (b != 0) {
                                    System.arraycopy(this.amH, 0, obj2, 0, b);
                                }
                                while (b < obj2.length) {
                                    obj2[b] = lyVar.nD();
                                    b++;
                                }
                                this.amH = obj2;
                                lyVar.ey(ex);
                                continue;
                            case LocationRequest.PRIORITY_LOW_POWER /*104*/:
                                this.amJ = lyVar.nD();
                                continue;
                            case 114:
                                nB = lyVar.nI();
                                b = lyVar.ex(nB);
                                ex = nB / 4;
                                nB = this.amI == null ? 0 : this.amI.length;
                                Object obj3 = new float[(ex + nB)];
                                if (nB != 0) {
                                    System.arraycopy(this.amI, 0, obj3, 0, nB);
                                }
                                while (nB < obj3.length) {
                                    obj3[nB] = lyVar.readFloat();
                                    nB++;
                                }
                                this.amI = obj3;
                                lyVar.ey(b);
                                continue;
                            case 117:
                                b = mh.b(lyVar, 117);
                                nB = this.amI == null ? 0 : this.amI.length;
                                obj = new float[(b + nB)];
                                if (nB != 0) {
                                    System.arraycopy(this.amI, 0, obj, 0, nB);
                                }
                                while (nB < obj.length - 1) {
                                    obj[nB] = lyVar.readFloat();
                                    lyVar.nB();
                                    nB++;
                                }
                                obj[nB] = lyVar.readFloat();
                                this.amI = obj;
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
                nz();
            }

            public static a[] ny() {
                if (amu == null) {
                    synchronized (mc.ana) {
                        if (amu == null) {
                            amu = new a[0];
                        }
                    }
                }
                return amu;
            }

            public void a(lz lzVar) throws IOException {
                lzVar.p(1, this.type);
                if (this.amv != null) {
                    lzVar.a(2, this.amv);
                }
                super.a(lzVar);
            }

            protected int c() {
                int c = super.c() + lz.r(1, this.type);
                return this.amv != null ? c + lz.b(2, this.amv) : c;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof a)) {
                    return false;
                }
                a aVar = (a) o;
                if (this.type != aVar.type) {
                    return false;
                }
                if (this.amv == null) {
                    if (aVar.amv != null) {
                        return false;
                    }
                } else if (!this.amv.equals(aVar.amv)) {
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
                int hashCode = ((this.amv == null ? 0 : this.amv.hashCode()) + ((this.type + 527) * 31)) * 31;
                if (!(this.amX == null || this.amX.isEmpty())) {
                    i = this.amX.hashCode();
                }
                return hashCode + i;
            }

            public a nz() {
                this.type = 1;
                this.amv = null;
                this.amX = null;
                this.anb = -1;
                return this;
            }

            /* renamed from: s */
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
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                    this.type = nB;
                                    break;
                                default:
                                    continue;
                            }
                        case 18:
                            if (this.amv == null) {
                                this.amv = new a();
                            }
                            lyVar.a(this.amv);
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
            nx();
        }

        public static a[] nw() {
            if (ams == null) {
                synchronized (mc.ana) {
                    if (ams == null) {
                        ams = new a[0];
                    }
                }
            }
            return ams;
        }

        public void a(lz lzVar) throws IOException {
            lzVar.b(1, this.name);
            if (this.amt != null) {
                lzVar.a(2, this.amt);
            }
            super.a(lzVar);
        }

        protected int c() {
            int c = super.c() + lz.h(1, this.name);
            return this.amt != null ? c + lz.b(2, this.amt) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof a)) {
                return false;
            }
            a aVar = (a) o;
            if (this.name == null) {
                if (aVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(aVar.name)) {
                return false;
            }
            if (this.amt == null) {
                if (aVar.amt != null) {
                    return false;
                }
            } else if (!this.amt.equals(aVar.amt)) {
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
            int hashCode = ((this.amt == null ? 0 : this.amt.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + 527) * 31)) * 31;
            if (!(this.amX == null || this.amX.isEmpty())) {
                i = this.amX.hashCode();
            }
            return hashCode + i;
        }

        public a nx() {
            this.name = "";
            this.amt = null;
            this.amX = null;
            this.anb = -1;
            return this;
        }

        /* renamed from: r */
        public a b(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                switch (nB) {
                    case 0:
                        break;
                    case 10:
                        this.name = lyVar.readString();
                        continue;
                    case 18:
                        if (this.amt == null) {
                            this.amt = new a();
                        }
                        lyVar.a(this.amt);
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

    public lw() {
        nv();
    }

    public static lw n(byte[] bArr) throws md {
        return (lw) me.a(new lw(), bArr);
    }

    public void a(lz lzVar) throws IOException {
        if (this.amr != null && this.amr.length > 0) {
            for (me meVar : this.amr) {
                if (meVar != null) {
                    lzVar.a(1, meVar);
                }
            }
        }
        super.a(lzVar);
    }

    protected int c() {
        int c = super.c();
        if (this.amr != null && this.amr.length > 0) {
            for (me meVar : this.amr) {
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
        if (!(o instanceof lw)) {
            return false;
        }
        lw lwVar = (lw) o;
        if (!mc.equals(this.amr, lwVar.amr)) {
            return false;
        }
        if (this.amX == null || this.amX.isEmpty()) {
            return lwVar.amX == null || lwVar.amX.isEmpty();
        } else {
            return this.amX.equals(lwVar.amX);
        }
    }

    public int hashCode() {
        int hashCode = (mc.hashCode(this.amr) + 527) * 31;
        int hashCode2 = (this.amX == null || this.amX.isEmpty()) ? 0 : this.amX.hashCode();
        return hashCode2 + hashCode;
    }

    public lw nv() {
        this.amr = a.nw();
        this.amX = null;
        this.anb = -1;
        return this;
    }

    /* renamed from: q */
    public lw b(ly lyVar) throws IOException {
        while (true) {
            int nB = lyVar.nB();
            switch (nB) {
                case 0:
                    break;
                case 10:
                    int b = mh.b(lyVar, 10);
                    nB = this.amr == null ? 0 : this.amr.length;
                    Object obj = new a[(b + nB)];
                    if (nB != 0) {
                        System.arraycopy(this.amr, 0, obj, 0, nB);
                    }
                    while (nB < obj.length - 1) {
                        obj[nB] = new a();
                        lyVar.a(obj[nB]);
                        lyVar.nB();
                        nB++;
                    }
                    obj[nB] = new a();
                    lyVar.a(obj[nB]);
                    this.amr = obj;
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
