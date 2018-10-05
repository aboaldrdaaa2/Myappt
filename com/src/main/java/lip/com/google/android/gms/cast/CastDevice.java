package lip.com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.gi;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CastDevice implements SafeParcelable {
    public static final Creator<CastDevice> CREATOR = new b();
    private String Ah;
    String Ai;
    private Inet4Address Aj;
    private String Ak;
    private String Al;
    private String Am;
    private int An;
    private List<WebImage> Ao;
    private int Ap;
    private final int xM;

    private CastDevice() {
        this(2, null, null, null, null, null, -1, new ArrayList(), 0);
    }

    CastDevice(int versionCode, String deviceId, String hostAddress, String friendlyName, String modelName, String deviceVersion, int servicePort, List<WebImage> icons, int capabilities) {
        this.xM = versionCode;
        this.Ah = deviceId;
        this.Ai = hostAddress;
        if (this.Ai != null) {
            try {
                InetAddress byName = InetAddress.getByName(this.Ai);
                if (byName instanceof Inet4Address) {
                    this.Aj = (Inet4Address) byName;
                }
            } catch (UnknownHostException e) {
                this.Aj = null;
            }
        }
        this.Ak = friendlyName;
        this.Al = modelName;
        this.Am = deviceVersion;
        this.An = servicePort;
        this.Ao = icons;
        this.Ap = capabilities;
    }

    public static CastDevice getFromBundle(Bundle extras) {
        if (extras == null) {
            return null;
        }
        extras.setClassLoader(CastDevice.class.getClassLoader());
        return (CastDevice) extras.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CastDevice)) {
            return false;
        }
        CastDevice castDevice = (CastDevice) obj;
        return getDeviceId() == null ? castDevice.getDeviceId() == null : gi.a(this.Ah, castDevice.Ah) && gi.a(this.Aj, castDevice.Aj) && gi.a(this.Al, castDevice.Al) && gi.a(this.Ak, castDevice.Ak) && gi.a(this.Am, castDevice.Am) && this.An == castDevice.An && gi.a(this.Ao, castDevice.Ao) && this.Ap == castDevice.Ap;
    }

    public int getCapabilities() {
        return this.Ap;
    }

    public String getDeviceId() {
        return this.Ah;
    }

    public String getDeviceVersion() {
        return this.Am;
    }

    public String getFriendlyName() {
        return this.Ak;
    }

    public WebImage getIcon(int preferredWidth, int preferredHeight) {
        WebImage webImage = null;
        if (this.Ao.isEmpty()) {
            return null;
        }
        if (preferredWidth <= 0 || preferredHeight <= 0) {
            return (WebImage) this.Ao.get(0);
        }
        WebImage webImage2 = null;
        for (WebImage webImage3 : this.Ao) {
            WebImage webImage32;
            int width = webImage32.getWidth();
            int height = webImage32.getHeight();
            if (width < preferredWidth || height < preferredHeight) {
                if (width < preferredWidth && height < preferredHeight && (webImage == null || (webImage.getWidth() < width && webImage.getHeight() < height))) {
                    webImage = webImage2;
                }
                webImage32 = webImage;
                webImage = webImage2;
            } else {
                if (webImage2 == null || (webImage2.getWidth() > width && webImage2.getHeight() > height)) {
                    WebImage webImage4 = webImage;
                    webImage = webImage32;
                    webImage32 = webImage4;
                }
                webImage32 = webImage;
                webImage = webImage2;
            }
            webImage2 = webImage;
            webImage = webImage32;
        }
        if (webImage2 == null) {
            webImage2 = webImage != null ? webImage : (WebImage) this.Ao.get(0);
        }
        return webImage2;
    }

    public List<WebImage> getIcons() {
        return Collections.unmodifiableList(this.Ao);
    }

    public Inet4Address getIpAddress() {
        return this.Aj;
    }

    public String getModelName() {
        return this.Al;
    }

    public int getServicePort() {
        return this.An;
    }

    int getVersionCode() {
        return this.xM;
    }

    public boolean hasIcons() {
        return !this.Ao.isEmpty();
    }

    public int hashCode() {
        return this.Ah == null ? 0 : this.Ah.hashCode();
    }

    public boolean isSameDevice(CastDevice castDevice) {
        if (castDevice == null) {
            return false;
        }
        if (getDeviceId() == null) {
            return castDevice.getDeviceId() == null;
        } else {
            return gi.a(getDeviceId(), castDevice.getDeviceId());
        }
    }

    public void putInBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
        }
    }

    public String toString() {
        return String.format("\"%s\" (%s)", new Object[]{this.Ak, this.Ah});
    }

    public void writeToParcel(Parcel out, int flags) {
        b.a(this, out, flags);
    }
}
