package lip.com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.internal.jh;

public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    public static final class Builder {
        private String OB = null;
        private int Va = 0;
        private long Vb = Long.MIN_VALUE;
        private short Vc = (short) -1;
        private double Vd;
        private double Ve;
        private float Vf;
        private int Vg = 0;
        private int Vh = -1;

        public Geofence build() {
            if (this.OB == null) {
                throw new IllegalArgumentException("Request ID not set.");
            } else if (this.Va == 0) {
                throw new IllegalArgumentException("Transitions types not set.");
            } else if ((this.Va & 4) != 0 && this.Vh < 0) {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
            } else if (this.Vb == Long.MIN_VALUE) {
                throw new IllegalArgumentException("Expiration not set.");
            } else if (this.Vc == (short) -1) {
                throw new IllegalArgumentException("Geofence region not set.");
            } else if (this.Vg >= 0) {
                return new jh(this.OB, this.Va, (short) 1, this.Vd, this.Ve, this.Vf, this.Vb, this.Vg, this.Vh);
            } else {
                throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
            }
        }

        public Builder setCircularRegion(double latitude, double longitude, float radius) {
            this.Vc = (short) 1;
            this.Vd = latitude;
            this.Ve = longitude;
            this.Vf = radius;
            return this;
        }

        public Builder setExpirationDuration(long durationMillis) {
            if (durationMillis < 0) {
                this.Vb = -1;
            } else {
                this.Vb = SystemClock.elapsedRealtime() + durationMillis;
            }
            return this;
        }

        public Builder setLoiteringDelay(int loiteringDelayMs) {
            this.Vh = loiteringDelayMs;
            return this;
        }

        public Builder setNotificationResponsiveness(int notificationResponsivenessMs) {
            this.Vg = notificationResponsivenessMs;
            return this;
        }

        public Builder setRequestId(String requestId) {
            this.OB = requestId;
            return this;
        }

        public Builder setTransitionTypes(int transitionTypes) {
            this.Va = transitionTypes;
            return this;
        }
    }

    String getRequestId();
}
