package lip.com.google.android.gms.internal;

import android.graphics.drawable.Drawable;

public final class gw extends hq<a, Drawable> {

    public static final class a {
        public final int FS;
        public final int FT;

        public a(int i, int i2) {
            this.FS = i;
            this.FT = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            a aVar = (a) obj;
            return aVar.FS == this.FS && aVar.FT == this.FT;
        }

        public int hashCode() {
            return hk.hashCode(Integer.valueOf(this.FS), Integer.valueOf(this.FT));
        }
    }

    public gw() {
        super(10);
    }
}
