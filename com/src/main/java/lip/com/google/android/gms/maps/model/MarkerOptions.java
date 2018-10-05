package lip.com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.maps.internal.v;

public final class MarkerOptions implements SafeParcelable {
    public static final MarkerOptionsCreator CREATOR = new MarkerOptionsCreator();
    private String HY;
    private LatLng ZX;
    private float aaG;
    private float aaH;
    private String aaP;
    private BitmapDescriptor aaQ;
    private boolean aaR;
    private boolean aaS;
    private float aaT;
    private float aaU;
    private float aaV;
    private boolean aay;
    private float mAlpha;
    private final int xM;

    public MarkerOptions() {
        this.aaG = 0.5f;
        this.aaH = 1.0f;
        this.aay = true;
        this.aaS = false;
        this.aaT = 0.0f;
        this.aaU = 0.5f;
        this.aaV = 0.0f;
        this.mAlpha = 1.0f;
        this.xM = 1;
    }

    MarkerOptions(int versionCode, LatLng position, String title, String snippet, IBinder wrappedIcon, float anchorU, float anchorV, boolean draggable, boolean visible, boolean flat, float rotation, float infoWindowAnchorU, float infoWindowAnchorV, float alpha) {
        this.aaG = 0.5f;
        this.aaH = 1.0f;
        this.aay = true;
        this.aaS = false;
        this.aaT = 0.0f;
        this.aaU = 0.5f;
        this.aaV = 0.0f;
        this.mAlpha = 1.0f;
        this.xM = versionCode;
        this.ZX = position;
        this.HY = title;
        this.aaP = snippet;
        this.aaQ = wrappedIcon == null ? null : new BitmapDescriptor(a.ag(wrappedIcon));
        this.aaG = anchorU;
        this.aaH = anchorV;
        this.aaR = draggable;
        this.aay = visible;
        this.aaS = flat;
        this.aaT = rotation;
        this.aaU = infoWindowAnchorU;
        this.aaV = infoWindowAnchorV;
        this.mAlpha = alpha;
    }

    public MarkerOptions alpha(float alpha) {
        this.mAlpha = alpha;
        return this;
    }

    public MarkerOptions anchor(float u, float v) {
        this.aaG = u;
        this.aaH = v;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public MarkerOptions draggable(boolean draggable) {
        this.aaR = draggable;
        return this;
    }

    public MarkerOptions flat(boolean flat) {
        this.aaS = flat;
        return this;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public float getAnchorU() {
        return this.aaG;
    }

    public float getAnchorV() {
        return this.aaH;
    }

    public BitmapDescriptor getIcon() {
        return this.aaQ;
    }

    public float getInfoWindowAnchorU() {
        return this.aaU;
    }

    public float getInfoWindowAnchorV() {
        return this.aaV;
    }

    public LatLng getPosition() {
        return this.ZX;
    }

    public float getRotation() {
        return this.aaT;
    }

    public String getSnippet() {
        return this.aaP;
    }

    public String getTitle() {
        return this.HY;
    }

    int getVersionCode() {
        return this.xM;
    }

    public MarkerOptions icon(BitmapDescriptor icon) {
        this.aaQ = icon;
        return this;
    }

    public MarkerOptions infoWindowAnchor(float u, float v) {
        this.aaU = u;
        this.aaV = v;
        return this;
    }

    public boolean isDraggable() {
        return this.aaR;
    }

    public boolean isFlat() {
        return this.aaS;
    }

    public boolean isVisible() {
        return this.aay;
    }

    IBinder jO() {
        return this.aaQ == null ? null : this.aaQ.jn().asBinder();
    }

    public MarkerOptions position(LatLng position) {
        this.ZX = position;
        return this;
    }

    public MarkerOptions rotation(float rotation) {
        this.aaT = rotation;
        return this;
    }

    public MarkerOptions snippet(String snippet) {
        this.aaP = snippet;
        return this;
    }

    public MarkerOptions title(String title) {
        this.HY = title;
        return this;
    }

    public MarkerOptions visible(boolean visible) {
        this.aay = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (v.jL()) {
            f.a(this, out, flags);
        } else {
            MarkerOptionsCreator.a(this, out, flags);
        }
    }
}
