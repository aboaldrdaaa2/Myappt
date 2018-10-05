package lip.com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;

public final class LocationRequest implements SafeParcelable {
    public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;
    long Vb;
    long Vl;
    long Vm;
    boolean Vn;
    int Vo;
    float Vp;
    int mPriority;
    private final int xM;

    public LocationRequest() {
        this.xM = 1;
        this.mPriority = 102;
        this.Vl = 3600000;
        this.Vm = 600000;
        this.Vn = false;
        this.Vb = Long.MAX_VALUE;
        this.Vo = Integer.MAX_VALUE;
        this.Vp = 0.0f;
    }

    LocationRequest(int versionCode, int priority, long interval, long fastestInterval, boolean explicitFastestInterval, long expireAt, int numUpdates, float smallestDisplacement) {
        this.xM = versionCode;
        this.mPriority = priority;
        this.Vl = interval;
        this.Vm = fastestInterval;
        this.Vn = explicitFastestInterval;
        this.Vb = expireAt;
        this.Vo = numUpdates;
        this.Vp = smallestDisplacement;
    }

    private static void a(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("invalid displacement: " + f);
        }
    }

    private static void cG(int i) {
        switch (i) {
            case 100:
            case 102:
            case PRIORITY_LOW_POWER /*104*/:
            case PRIORITY_NO_POWER /*105*/:
                return;
            default:
                throw new IllegalArgumentException("invalid quality: " + i);
        }
    }

    public static String cH(int i) {
        switch (i) {
            case 100:
                return "PRIORITY_HIGH_ACCURACY";
            case 102:
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            case PRIORITY_LOW_POWER /*104*/:
                return "PRIORITY_LOW_POWER";
            case PRIORITY_NO_POWER /*105*/:
                return "PRIORITY_NO_POWER";
            default:
                return "???";
        }
    }

    public static LocationRequest create() {
        return new LocationRequest();
    }

    private static void v(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("invalid interval: " + j);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) object;
        return this.mPriority == locationRequest.mPriority && this.Vl == locationRequest.Vl && this.Vm == locationRequest.Vm && this.Vn == locationRequest.Vn && this.Vb == locationRequest.Vb && this.Vo == locationRequest.Vo && this.Vp == locationRequest.Vp;
    }

    public long getExpirationTime() {
        return this.Vb;
    }

    public long getFastestInterval() {
        return this.Vm;
    }

    public long getInterval() {
        return this.Vl;
    }

    public int getNumUpdates() {
        return this.Vo;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public float getSmallestDisplacement() {
        return this.Vp;
    }

    int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return hk.hashCode(Integer.valueOf(this.mPriority), Long.valueOf(this.Vl), Long.valueOf(this.Vm), Boolean.valueOf(this.Vn), Long.valueOf(this.Vb), Integer.valueOf(this.Vo), Float.valueOf(this.Vp));
    }

    public LocationRequest setExpirationDuration(long millis) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (millis > Long.MAX_VALUE - elapsedRealtime) {
            this.Vb = Long.MAX_VALUE;
        } else {
            this.Vb = elapsedRealtime + millis;
        }
        if (this.Vb < 0) {
            this.Vb = 0;
        }
        return this;
    }

    public LocationRequest setExpirationTime(long millis) {
        this.Vb = millis;
        if (this.Vb < 0) {
            this.Vb = 0;
        }
        return this;
    }

    public LocationRequest setFastestInterval(long millis) {
        v(millis);
        this.Vn = true;
        this.Vm = millis;
        return this;
    }

    public LocationRequest setInterval(long millis) {
        v(millis);
        this.Vl = millis;
        if (!this.Vn) {
            this.Vm = (long) (((double) this.Vl) / 6.0d);
        }
        return this;
    }

    public LocationRequest setNumUpdates(int numUpdates) {
        if (numUpdates <= 0) {
            throw new IllegalArgumentException("invalid numUpdates: " + numUpdates);
        }
        this.Vo = numUpdates;
        return this;
    }

    public LocationRequest setPriority(int priority) {
        cG(priority);
        this.mPriority = priority;
        return this;
    }

    public LocationRequest setSmallestDisplacement(float smallestDisplacementMeters) {
        a(smallestDisplacementMeters);
        this.Vp = smallestDisplacementMeters;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request[").append(cH(this.mPriority));
        if (this.mPriority != PRIORITY_NO_POWER) {
            stringBuilder.append(" requested=");
            stringBuilder.append(this.Vl + "ms");
        }
        stringBuilder.append(" fastest=");
        stringBuilder.append(this.Vm + "ms");
        if (this.Vb != Long.MAX_VALUE) {
            long elapsedRealtime = this.Vb - SystemClock.elapsedRealtime();
            stringBuilder.append(" expireIn=");
            stringBuilder.append(elapsedRealtime + "ms");
        }
        if (this.Vo != Integer.MAX_VALUE) {
            stringBuilder.append(" num=").append(this.Vo);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        LocationRequestCreator.a(this, parcel, flags);
    }
}
