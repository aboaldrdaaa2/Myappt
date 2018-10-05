package lip.com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolylineOptions implements SafeParcelable {
    public static final PolylineOptionsCreator CREATOR = new PolylineOptionsCreator();
    private int Dj;
    private float aaC;
    private final List<LatLng> aaX;
    private boolean aaZ;
    private float aax;
    private boolean aay;
    private final int xM;

    public PolylineOptions() {
        this.aaC = 10.0f;
        this.Dj = ViewCompat.MEASURED_STATE_MASK;
        this.aax = 0.0f;
        this.aay = true;
        this.aaZ = false;
        this.xM = 1;
        this.aaX = new ArrayList();
    }

    PolylineOptions(int versionCode, List points, float width, int color, float zIndex, boolean visible, boolean geodesic) {
        this.aaC = 10.0f;
        this.Dj = ViewCompat.MEASURED_STATE_MASK;
        this.aax = 0.0f;
        this.aay = true;
        this.aaZ = false;
        this.xM = versionCode;
        this.aaX = points;
        this.aaC = width;
        this.Dj = color;
        this.aax = zIndex;
        this.aay = visible;
        this.aaZ = geodesic;
    }

    public PolylineOptions add(LatLng point) {
        this.aaX.add(point);
        return this;
    }

    public PolylineOptions add(LatLng... points) {
        this.aaX.addAll(Arrays.asList(points));
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> points) {
        for (LatLng add : points) {
            this.aaX.add(add);
        }
        return this;
    }

    public PolylineOptions color(int color) {
        this.Dj = color;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolylineOptions geodesic(boolean geodesic) {
        this.aaZ = geodesic;
        return this;
    }

    public int getColor() {
        return this.Dj;
    }

    public List<LatLng> getPoints() {
        return this.aaX;
    }

    int getVersionCode() {
        return this.xM;
    }

    public float getWidth() {
        return this.aaC;
    }

    public float getZIndex() {
        return this.aax;
    }

    public boolean isGeodesic() {
        return this.aaZ;
    }

    public boolean isVisible() {
        return this.aay;
    }

    public PolylineOptions visible(boolean visible) {
        this.aay = visible;
        return this;
    }

    public PolylineOptions width(float width) {
        this.aaC = width;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (v.jL()) {
            h.a(this, out, flags);
        } else {
            PolylineOptionsCreator.a(this, out, flags);
        }
    }

    public PolylineOptions zIndex(float zIndex) {
        this.aax = zIndex;
        return this;
    }
}
