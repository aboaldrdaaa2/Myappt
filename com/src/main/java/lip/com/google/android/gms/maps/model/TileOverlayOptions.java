package lip.com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.v;
import com.google.android.gms.maps.model.internal.i;
import com.google.android.gms.maps.model.internal.i.a;

public final class TileOverlayOptions implements SafeParcelable {
    public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();
    private float aax;
    private boolean aay;
    private i abd;
    private TileProvider abe;
    private boolean abf;
    private final int xM;

    public TileOverlayOptions() {
        this.aay = true;
        this.abf = true;
        this.xM = 1;
    }

    TileOverlayOptions(int versionCode, IBinder delegate, boolean visible, float zIndex, boolean fadeIn) {
        this.aay = true;
        this.abf = true;
        this.xM = versionCode;
        this.abd = a.bg(delegate);
        this.abe = this.abd == null ? null : new TileProvider() {
            private final i abg = TileOverlayOptions.this.abd;

            public Tile getTile(int x, int y, int zoom) {
                try {
                    return this.abg.getTile(x, y, zoom);
                } catch (RemoteException e) {
                    return null;
                }
            }
        };
        this.aay = visible;
        this.aax = zIndex;
        this.abf = fadeIn;
    }

    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean fadeIn) {
        this.abf = fadeIn;
        return this;
    }

    public boolean getFadeIn() {
        return this.abf;
    }

    public TileProvider getTileProvider() {
        return this.abe;
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

    IBinder jQ() {
        return this.abd.asBinder();
    }

    public TileOverlayOptions tileProvider(final TileProvider tileProvider) {
        this.abe = tileProvider;
        this.abd = this.abe == null ? null : new a() {
            public Tile getTile(int x, int y, int zoom) {
                return tileProvider.getTile(x, y, zoom);
            }
        };
        return this;
    }

    public TileOverlayOptions visible(boolean visible) {
        this.aay = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (v.jL()) {
            j.a(this, out, flags);
        } else {
            TileOverlayOptionsCreator.a(this, out, flags);
        }
    }

    public TileOverlayOptions zIndex(float zIndex) {
        this.aax = zIndex;
        return this;
    }
}
