package lip.com.google.ads.interactivemedia.v3.b;

import com.google.ads.interactivemedia.v3.b.r.a;

/* compiled from: IMASDK */
public final class u {
    private final long a;
    private final a b;

    u(long j, a aVar) {
        this.a = j;
        this.b = aVar;
    }

    public final long a() {
        return this.a;
    }

    public final a b() {
        return this.b;
    }

    public final int hashCode() {
        return (((int) this.a) * 31) + this.b.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        u uVar = (u) obj;
        if (this.a != uVar.a) {
            return false;
        }
        if (this.b != uVar.b) {
            return false;
        }
        return true;
    }

    public final String toString() {
        return "NativeBridgeConfig [adTimeUpdateMs=" + this.a + ", adUiStyle=" + this.b + "]";
    }
}
