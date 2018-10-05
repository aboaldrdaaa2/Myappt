package lip.com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.v;

public final class CircleOptions implements SafeParcelable {
    public static final CircleOptionsCreator CREATOR = new CircleOptionsCreator();
    private LatLng aas;
    private double aat;
    private float aau;
    private int aav;
    private int aaw;
    private float aax;
    private boolean aay;
    private final int xM;

    public CircleOptions() {
        this.aas = null;
        this.aat = 0.0d;
        this.aau = 10.0f;
        this.aav = ViewCompat.MEASURED_STATE_MASK;
        this.aaw = 0;
        this.aax = 0.0f;
        this.aay = true;
        this.xM = 1;
    }

    CircleOptions(int versionCode, LatLng center, double radius, float strokeWidth, int strokeColor, int fillColor, float zIndex, boolean visible) {
        this.aas = null;
        this.aat = 0.0d;
        this.aau = 10.0f;
        this.aav = ViewCompat.MEASURED_STATE_MASK;
        this.aaw = 0;
        this.aax = 0.0f;
        this.aay = true;
        this.xM = versionCode;
        this.aas = center;
        this.aat = radius;
        this.aau = strokeWidth;
        this.aav = strokeColor;
        this.aaw = fillColor;
        this.aax = zIndex;
        this.aay = visible;
    }

    public CircleOptions center(LatLng center) {
        this.aas = center;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CircleOptions fillColor(int color) {
        this.aaw = color;
        return this;
    }

    public LatLng getCenter() {
        return this.aas;
    }

    public int getFillColor() {
        return this.aaw;
    }

    public double getRadius() {
        return this.aat;
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

    public boolean isVisible() {
        return this.aay;
    }

    public CircleOptions radius(double radius) {
        this.aat = radius;
        return this;
    }

    public CircleOptions strokeColor(int color) {
        this.aav = color;
        return this;
    }

    public CircleOptions strokeWidth(float width) {
        this.aau = width;
        return this;
    }

    public CircleOptions visible(boolean visible) {
        this.aay = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (v.jL()) {
            b.a(this, out, flags);
        } else {
            CircleOptionsCreator.a(this, out, flags);
        }
    }

    public CircleOptions zIndex(float zIndex) {
        this.aax = zIndex;
        return this;
    }
}
