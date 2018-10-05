package lip.com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.a;
import com.google.android.gms.maps.internal.v;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions implements SafeParcelable {
    public static final GoogleMapOptionsCreator CREATOR = new GoogleMapOptionsCreator();
    private Boolean ZA;
    private Boolean ZB;
    private Boolean Zs;
    private Boolean Zt;
    private int Zu;
    private CameraPosition Zv;
    private Boolean Zw;
    private Boolean Zx;
    private Boolean Zy;
    private Boolean Zz;
    private final int xM;

    public GoogleMapOptions() {
        this.Zu = -1;
        this.xM = 1;
    }

    GoogleMapOptions(int versionCode, byte zOrderOnTop, byte useViewLifecycleInFragment, int mapType, CameraPosition camera, byte zoomControlsEnabled, byte compassEnabled, byte scrollGesturesEnabled, byte zoomGesturesEnabled, byte tiltGesturesEnabled, byte rotateGesturesEnabled) {
        this.Zu = -1;
        this.xM = versionCode;
        this.Zs = a.a(zOrderOnTop);
        this.Zt = a.a(useViewLifecycleInFragment);
        this.Zu = mapType;
        this.Zv = camera;
        this.Zw = a.a(zoomControlsEnabled);
        this.Zx = a.a(compassEnabled);
        this.Zy = a.a(scrollGesturesEnabled);
        this.Zz = a.a(zoomGesturesEnabled);
        this.ZA = a.a(tiltGesturesEnabled);
        this.ZB = a.a(rotateGesturesEnabled);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attrs, R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(0)) {
            googleMapOptions.mapType(obtainAttributes.getInt(0, -1));
        }
        if (obtainAttributes.hasValue(13)) {
            googleMapOptions.zOrderOnTop(obtainAttributes.getBoolean(13, false));
        }
        if (obtainAttributes.hasValue(12)) {
            googleMapOptions.useViewLifecycleInFragment(obtainAttributes.getBoolean(12, false));
        }
        if (obtainAttributes.hasValue(6)) {
            googleMapOptions.compassEnabled(obtainAttributes.getBoolean(6, true));
        }
        if (obtainAttributes.hasValue(7)) {
            googleMapOptions.rotateGesturesEnabled(obtainAttributes.getBoolean(7, true));
        }
        if (obtainAttributes.hasValue(8)) {
            googleMapOptions.scrollGesturesEnabled(obtainAttributes.getBoolean(8, true));
        }
        if (obtainAttributes.hasValue(9)) {
            googleMapOptions.tiltGesturesEnabled(obtainAttributes.getBoolean(9, true));
        }
        if (obtainAttributes.hasValue(11)) {
            googleMapOptions.zoomGesturesEnabled(obtainAttributes.getBoolean(11, true));
        }
        if (obtainAttributes.hasValue(10)) {
            googleMapOptions.zoomControlsEnabled(obtainAttributes.getBoolean(10, true));
        }
        googleMapOptions.camera(CameraPosition.createFromAttributes(context, attrs));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    public GoogleMapOptions camera(CameraPosition camera) {
        this.Zv = camera;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean enabled) {
        this.Zx = Boolean.valueOf(enabled);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CameraPosition getCamera() {
        return this.Zv;
    }

    public Boolean getCompassEnabled() {
        return this.Zx;
    }

    public int getMapType() {
        return this.Zu;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.ZB;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.Zy;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.ZA;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.Zt;
    }

    int getVersionCode() {
        return this.xM;
    }

    public Boolean getZOrderOnTop() {
        return this.Zs;
    }

    public Boolean getZoomControlsEnabled() {
        return this.Zw;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.Zz;
    }

    byte jq() {
        return a.c(this.Zs);
    }

    byte jr() {
        return a.c(this.Zt);
    }

    byte js() {
        return a.c(this.Zw);
    }

    byte jt() {
        return a.c(this.Zx);
    }

    byte ju() {
        return a.c(this.Zy);
    }

    byte jv() {
        return a.c(this.Zz);
    }

    byte jw() {
        return a.c(this.ZA);
    }

    byte jx() {
        return a.c(this.ZB);
    }

    public GoogleMapOptions mapType(int mapType) {
        this.Zu = mapType;
        return this;
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean enabled) {
        this.ZB = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean enabled) {
        this.Zy = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean enabled) {
        this.ZA = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean useViewLifecycleInFragment) {
        this.Zt = Boolean.valueOf(useViewLifecycleInFragment);
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (v.jL()) {
            a.a(this, out, flags);
        } else {
            GoogleMapOptionsCreator.a(this, out, flags);
        }
    }

    public GoogleMapOptions zOrderOnTop(boolean zOrderOnTop) {
        this.Zs = Boolean.valueOf(zOrderOnTop);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean enabled) {
        this.Zw = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean enabled) {
        this.Zz = Boolean.valueOf(enabled);
        return this;
    }
}
