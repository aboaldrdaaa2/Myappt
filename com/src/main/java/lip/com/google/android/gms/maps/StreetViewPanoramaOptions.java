package lip.com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions implements SafeParcelable {
    public static final StreetViewPanoramaOptionsCreator CREATOR = new StreetViewPanoramaOptionsCreator();
    private StreetViewPanoramaCamera ZV;
    private String ZW;
    private LatLng ZX;
    private Integer ZY;
    private Boolean ZZ;
    private Boolean Zt;
    private Boolean Zz;
    private Boolean aaa;
    private Boolean aab;
    private final int xM;

    public StreetViewPanoramaOptions() {
        this.ZZ = Boolean.valueOf(true);
        this.Zz = Boolean.valueOf(true);
        this.aaa = Boolean.valueOf(true);
        this.aab = Boolean.valueOf(true);
        this.xM = 1;
    }

    StreetViewPanoramaOptions(int versionCode, StreetViewPanoramaCamera camera, String panoId, LatLng position, Integer radius, byte userNavigationEnabled, byte zoomGesturesEnabled, byte panningGesturesEnabled, byte streetNamesEnabled, byte useViewLifecycleInFragment) {
        this.ZZ = Boolean.valueOf(true);
        this.Zz = Boolean.valueOf(true);
        this.aaa = Boolean.valueOf(true);
        this.aab = Boolean.valueOf(true);
        this.xM = versionCode;
        this.ZV = camera;
        this.ZX = position;
        this.ZY = radius;
        this.ZW = panoId;
        this.ZZ = a.a(userNavigationEnabled);
        this.Zz = a.a(zoomGesturesEnabled);
        this.aaa = a.a(panningGesturesEnabled);
        this.aab = a.a(streetNamesEnabled);
        this.Zt = a.a(useViewLifecycleInFragment);
    }

    public int describeContents() {
        return 0;
    }

    public Boolean getPanningGesturesEnabled() {
        return this.aaa;
    }

    public String getPanoramaId() {
        return this.ZW;
    }

    public LatLng getPosition() {
        return this.ZX;
    }

    public Integer getRadius() {
        return this.ZY;
    }

    public Boolean getStreetNamesEnabled() {
        return this.aab;
    }

    public StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.ZV;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.Zt;
    }

    public Boolean getUserNavigationEnabled() {
        return this.ZZ;
    }

    int getVersionCode() {
        return this.xM;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.Zz;
    }

    byte jD() {
        return a.c(this.ZZ);
    }

    byte jE() {
        return a.c(this.aaa);
    }

    byte jF() {
        return a.c(this.aab);
    }

    byte jr() {
        return a.c(this.Zt);
    }

    byte jv() {
        return a.c(this.Zz);
    }

    public StreetViewPanoramaOptions panningGesturesEnabled(boolean enabled) {
        this.aaa = Boolean.valueOf(enabled);
        return this;
    }

    public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera camera) {
        this.ZV = camera;
        return this;
    }

    public StreetViewPanoramaOptions panoramaId(String panoId) {
        this.ZW = panoId;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng position) {
        this.ZX = position;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng position, Integer radius) {
        this.ZX = position;
        this.ZY = radius;
        return this;
    }

    public StreetViewPanoramaOptions streetNamesEnabled(boolean enabled) {
        this.aab = Boolean.valueOf(enabled);
        return this;
    }

    public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean useViewLifecycleInFragment) {
        this.Zt = Boolean.valueOf(useViewLifecycleInFragment);
        return this;
    }

    public StreetViewPanoramaOptions userNavigationEnabled(boolean enabled) {
        this.ZZ = Boolean.valueOf(enabled);
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        StreetViewPanoramaOptionsCreator.a(this, out, flags);
    }

    public StreetViewPanoramaOptions zoomGesturesEnabled(boolean enabled) {
        this.Zz = Boolean.valueOf(enabled);
        return this;
    }
}
