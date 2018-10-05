package lip.com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

public class jh implements SafeParcelable, Geofence {
    public static final ji CREATOR = new ji();
    private final String OB;
    private final long VZ;
    private final int Va;
    private final short Vc;
    private final double Vd;
    private final double Ve;
    private final float Vf;
    private final int Vg;
    private final int Vh;
    private final int xM;

    public jh(int i, String str, int i2, short s, double d, double d2, float f, long j, int i3, int i4) {
        bq(str);
        b(f);
        a(d, d2);
        int cM = cM(i2);
        this.xM = i;
        this.Vc = s;
        this.OB = str;
        this.Vd = d;
        this.Ve = d2;
        this.Vf = f;
        this.VZ = j;
        this.Va = cM;
        this.Vg = i3;
        this.Vh = i4;
    }

    public jh(String str, int i, short s, double d, double d2, float f, long j, int i2, int i3) {
        this(1, str, i, s, d, d2, f, j, i2, i3);
    }

    private static void a(double d, double d2) {
        if (d > 90.0d || d < -90.0d) {
            throw new IllegalArgumentException("invalid latitude: " + d);
        } else if (d2 > 180.0d || d2 < -180.0d) {
            throw new IllegalArgumentException("invalid longitude: " + d2);
        }
    }

    private static void b(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("invalid radius: " + f);
        }
    }

    private static void bq(String str) {
        if (str == null || str.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: " + str);
        }
    }

    private static int cM(int i) {
        int i2 = i & 7;
        if (i2 != 0) {
            return i2;
        }
        throw new IllegalArgumentException("No supported transition specified: " + i);
    }

    private static String cN(int i) {
        switch (i) {
            case 1:
                return "CIRCLE";
            default:
                return null;
        }
    }

    public static jh h(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        jh bt = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return bt;
    }

    public int describeContents() {
        ji jiVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof jh)) {
            return false;
        }
        jh jhVar = (jh) obj;
        if (this.Vf != jhVar.Vf) {
            return false;
        }
        if (this.Vd != jhVar.Vd) {
            return false;
        }
        if (this.Ve != jhVar.Ve) {
            return false;
        }
        return this.Vc == jhVar.Vc;
    }

    public long getExpirationTime() {
        return this.VZ;
    }

    public double getLatitude() {
        return this.Vd;
    }

    public double getLongitude() {
        return this.Ve;
    }

    public int getNotificationResponsiveness() {
        return this.Vg;
    }

    public String getRequestId() {
        return this.OB;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.Vd);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.Ve);
        return (((((((i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.Vf)) * 31) + this.Vc) * 31) + this.Va;
    }

    public short ja() {
        return this.Vc;
    }

    public float jb() {
        return this.Vf;
    }

    public int jc() {
        return this.Va;
    }

    public int jd() {
        return this.Vh;
    }

    public String toString() {
        return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[]{cN(this.Vc), this.OB, Integer.valueOf(this.Va), Double.valueOf(this.Vd), Double.valueOf(this.Ve), Float.valueOf(this.Vf), Integer.valueOf(this.Vg / 1000), Integer.valueOf(this.Vh), Long.valueOf(this.VZ)});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        ji jiVar = CREATOR;
        ji.a(this, parcel, flags);
    }
}
