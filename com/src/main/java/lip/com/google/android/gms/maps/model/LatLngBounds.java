package lip.com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hm;
import com.google.android.gms.maps.internal.v;

public final class LatLngBounds implements SafeParcelable {
    public static final LatLngBoundsCreator CREATOR = new LatLngBoundsCreator();
    public final LatLng northeast;
    public final LatLng southwest;
    private final int xM;

    public static final class Builder {
        private double aaK = Double.POSITIVE_INFINITY;
        private double aaL = Double.NEGATIVE_INFINITY;
        private double aaM = Double.NaN;
        private double aaN = Double.NaN;

        private boolean d(double d) {
            boolean z = false;
            if (this.aaM <= this.aaN) {
                return this.aaM <= d && d <= this.aaN;
            } else {
                if (this.aaM <= d || d <= this.aaN) {
                    z = true;
                }
                return z;
            }
        }

        public LatLngBounds build() {
            hm.a(!Double.isNaN(this.aaM), "no included points");
            return new LatLngBounds(new LatLng(this.aaK, this.aaM), new LatLng(this.aaL, this.aaN));
        }

        public Builder include(LatLng point) {
            this.aaK = Math.min(this.aaK, point.latitude);
            this.aaL = Math.max(this.aaL, point.latitude);
            double d = point.longitude;
            if (Double.isNaN(this.aaM)) {
                this.aaM = d;
                this.aaN = d;
            } else if (!d(d)) {
                if (LatLngBounds.b(this.aaM, d) < LatLngBounds.c(this.aaN, d)) {
                    this.aaM = d;
                } else {
                    this.aaN = d;
                }
            }
            return this;
        }
    }

    LatLngBounds(int versionCode, LatLng southwest, LatLng northeast) {
        hm.b((Object) southwest, (Object) "null southwest");
        hm.b((Object) northeast, (Object) "null northeast");
        hm.b(northeast.latitude >= southwest.latitude, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(southwest.latitude), Double.valueOf(northeast.latitude));
        this.xM = versionCode;
        this.southwest = southwest;
        this.northeast = northeast;
    }

    public LatLngBounds(LatLng southwest, LatLng northeast) {
        this(1, southwest, northeast);
    }

    private static double b(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    public static Builder builder() {
        return new Builder();
    }

    private static double c(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    private boolean c(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    private boolean d(double d) {
        boolean z = false;
        if (this.southwest.longitude <= this.northeast.longitude) {
            return this.southwest.longitude <= d && d <= this.northeast.longitude;
        } else {
            if (this.southwest.longitude <= d || d <= this.northeast.longitude) {
                z = true;
            }
            return z;
        }
    }

    public boolean contains(LatLng point) {
        return c(point.latitude) && d(point.longitude);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) o;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public LatLng getCenter() {
        double d = (this.southwest.latitude + this.northeast.latitude) / 2.0d;
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        return new LatLng(d, d3 <= d2 ? (d2 + d3) / 2.0d : ((d2 + 360.0d) + d3) / 2.0d);
    }

    int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return hk.hashCode(this.southwest, this.northeast);
    }

    public LatLngBounds including(LatLng point) {
        double min = Math.min(this.southwest.latitude, point.latitude);
        double max = Math.max(this.northeast.latitude, point.latitude);
        double d = this.northeast.longitude;
        double d2 = this.southwest.longitude;
        double d3 = point.longitude;
        if (d(d3)) {
            d3 = d2;
            d2 = d;
        } else if (b(d2, d3) < c(d, d3)) {
            d2 = d;
        } else {
            double d4 = d2;
            d2 = d3;
            d3 = d4;
        }
        return new LatLngBounds(new LatLng(min, d3), new LatLng(max, d2));
    }

    public String toString() {
        return hk.e(this).a("southwest", this.southwest).a("northeast", this.northeast).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        if (v.jL()) {
            d.a(this, out, flags);
        } else {
            LatLngBoundsCreator.a(this, out, flags);
        }
    }
}
