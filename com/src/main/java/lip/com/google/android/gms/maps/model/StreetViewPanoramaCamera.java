package lip.com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hm;

public class StreetViewPanoramaCamera implements SafeParcelable {
    public static final StreetViewPanoramaCameraCreator CREATOR = new StreetViewPanoramaCameraCreator();
    private StreetViewPanoramaOrientation abb;
    public final float bearing;
    public final float tilt;
    private final int xM;
    public final float zoom;

    public static final class Builder {
        public float bearing;
        public float tilt;
        public float zoom;

        public Builder(StreetViewPanoramaCamera previous) {
            this.zoom = previous.zoom;
            this.bearing = previous.bearing;
            this.tilt = previous.tilt;
        }

        public Builder bearing(float bearing) {
            this.bearing = bearing;
            return this;
        }

        public StreetViewPanoramaCamera build() {
            return new StreetViewPanoramaCamera(this.zoom, this.tilt, this.bearing);
        }

        public Builder orientation(StreetViewPanoramaOrientation orientation) {
            this.tilt = orientation.tilt;
            this.bearing = orientation.bearing;
            return this;
        }

        public Builder tilt(float tilt) {
            this.tilt = tilt;
            return this;
        }

        public Builder zoom(float zoom) {
            this.zoom = zoom;
            return this;
        }
    }

    public StreetViewPanoramaCamera(float zoom, float tilt, float bearing) {
        this(1, zoom, tilt, bearing);
    }

    StreetViewPanoramaCamera(int versionCode, float zoom, float tilt, float bearing) {
        boolean z = -90.0f <= tilt && tilt <= 90.0f;
        hm.b(z, (Object) "Tilt needs to be between -90 and 90 inclusive");
        this.xM = versionCode;
        this.zoom = zoom;
        this.tilt = 0.0f + tilt;
        this.bearing = (((double) bearing) <= 0.0d ? (bearing % 360.0f) + 360.0f : bearing) % 360.0f;
        this.abb = new com.google.android.gms.maps.model.StreetViewPanoramaOrientation.Builder().tilt(tilt).bearing(bearing).build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(StreetViewPanoramaCamera camera) {
        return new Builder(camera);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StreetViewPanoramaCamera)) {
            return false;
        }
        StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) o;
        return Float.floatToIntBits(this.zoom) == Float.floatToIntBits(streetViewPanoramaCamera.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(streetViewPanoramaCamera.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(streetViewPanoramaCamera.bearing);
    }

    public StreetViewPanoramaOrientation getOrientation() {
        return this.abb;
    }

    int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return hk.hashCode(Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing));
    }

    public String toString() {
        return hk.e(this).a("zoom", Float.valueOf(this.zoom)).a("tilt", Float.valueOf(this.tilt)).a("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        StreetViewPanoramaCameraCreator.a(this, out, flags);
    }
}
