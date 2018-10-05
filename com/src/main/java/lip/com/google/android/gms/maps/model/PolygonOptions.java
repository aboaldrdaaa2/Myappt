package lip.com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions implements SafeParcelable {
    public static final PolygonOptionsCreator CREATOR = new PolygonOptionsCreator();
    private final List<LatLng> aaX;
    private final List<List<LatLng>> aaY;
    private boolean aaZ;
    private float aau;
    private int aav;
    private int aaw;
    private float aax;
    private boolean aay;
    private final int xM;

    public PolygonOptions() {
        this.aau = 10.0f;
        this.aav = ViewCompat.MEASURED_STATE_MASK;
        this.aaw = 0;
        this.aax = 0.0f;
        this.aay = true;
        this.aaZ = false;
        this.xM = 1;
        this.aaX = new ArrayList();
        this.aaY = new ArrayList();
    }

    PolygonOptions(int versionCode, List<LatLng> points, List holes, float strokeWidth, int strokeColor, int fillColor, float zIndex, boolean visible, boolean geodesic) {
        this.aau = 10.0f;
        this.aav = ViewCompat.MEASURED_STATE_MASK;
        this.aaw = 0;
        this.aax = 0.0f;
        this.aay = true;
        this.aaZ = false;
        this.xM = versionCode;
        this.aaX = points;
        this.aaY = holes;
        this.aau = strokeWidth;
        this.aav = strokeColor;
        this.aaw = fillColor;
        this.aax = zIndex;
        this.aay = visible;
        this.aaZ = geodesic;
    }

    public PolygonOptions add(LatLng point) {
        this.aaX.add(point);
        return this;
    }

    public PolygonOptions add(LatLng... points) {
        this.aaX.addAll(Arrays.asList(points));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> points) {
        for (LatLng add : points) {
            this.aaX.add(add);
        }
        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> points) {
        ArrayList arrayList = new ArrayList();
        for (LatLng add : points) {
            arrayList.add(add);
        }
        this.aaY.add(arrayList);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolygonOptions fillColor(int color) {
        this.aaw = color;
        return this;
    }

    public PolygonOptions geodesic(boolean geodesic) {
        this.aaZ = geodesic;
        return this;
    }

    public int getFillColor() {
        return this.aaw;
    }

    public List<List<LatLng>> getHoles() {
        return this.aaY;
    }

    public List<LatLng> getPoints() {
        return this.aaX;
    }

    public int getStrokeColor() {
        return this.aav;
    }

    public float getStrokeWidth() {
        return this.aau;
    }

    int getVersionCode() {
        return this.xM;
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

    List jP() {
        return this.aaY;
    }

    public PolygonOptions strokeColor(int color) {
        this.aav = color;
        return this;
    }

    public PolygonOptions strokeWidth(float width) {
        this.aau = width;
        return this;
    }

    public PolygonOptions visible(boolean visible) {
        this.aay = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (v.jL()) {
            g.a(this, out, flags);
        } else {
            PolygonOptionsCreator.a(this, out, flags);
        }
    }

    public PolygonOptions zIndex(float zIndex) {
        this.aax = zIndex;
        return this;
    }
}
