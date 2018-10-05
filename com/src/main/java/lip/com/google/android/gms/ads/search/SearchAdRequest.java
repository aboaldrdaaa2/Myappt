package lip.com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.at;
import com.google.android.gms.internal.at.a;

public final class SearchAdRequest {
    public static final int BORDER_TYPE_DASHED = 1;
    public static final int BORDER_TYPE_DOTTED = 2;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SOLID = 3;
    public static final int CALL_BUTTON_COLOR_DARK = 2;
    public static final int CALL_BUTTON_COLOR_LIGHT = 0;
    public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
    public static final String DEVICE_ID_EMULATOR = at.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    private final at ks;
    private final int tc;
    private final int td;
    private final int te;
    private final int tf;
    private final int tg;
    private final int th;
    private final int ti;
    private final int tj;
    private final String tk;
    private final int tl;
    private final String tm;
    private final int tn;
    private final int to;
    private final String tp;

    public static final class Builder {
        private final a kt = new a();
        private int tc;
        private int td;
        private int te;
        private int tf;
        private int tg;
        private int th;
        private int ti = 0;
        private int tj;
        private String tk;
        private int tl;
        private String tm;
        private int tn;
        private int to;
        private String tp;

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> adapterClass, Bundle customEventExtras) {
            this.kt.b(adapterClass, customEventExtras);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.kt.a(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> adapterClass, Bundle networkExtras) {
            this.kt.a(adapterClass, networkExtras);
            return this;
        }

        public Builder addTestDevice(String deviceId) {
            this.kt.h(deviceId);
            return this;
        }

        public SearchAdRequest build() {
            return new SearchAdRequest(this);
        }

        public Builder setAnchorTextColor(int anchorTextColor) {
            this.tc = anchorTextColor;
            return this;
        }

        public Builder setBackgroundColor(int backgroundColor) {
            this.td = backgroundColor;
            this.te = Color.argb(0, 0, 0, 0);
            this.tf = Color.argb(0, 0, 0, 0);
            return this;
        }

        public Builder setBackgroundGradient(int top, int bottom) {
            this.td = Color.argb(0, 0, 0, 0);
            this.te = bottom;
            this.tf = top;
            return this;
        }

        public Builder setBorderColor(int borderColor) {
            this.tg = borderColor;
            return this;
        }

        public Builder setBorderThickness(int borderThickness) {
            this.th = borderThickness;
            return this;
        }

        public Builder setBorderType(int borderType) {
            this.ti = borderType;
            return this;
        }

        public Builder setCallButtonColor(int callButtonColor) {
            this.tj = callButtonColor;
            return this;
        }

        public Builder setCustomChannels(String channelIds) {
            this.tk = channelIds;
            return this;
        }

        public Builder setDescriptionTextColor(int descriptionTextColor) {
            this.tl = descriptionTextColor;
            return this;
        }

        public Builder setFontFace(String fontFace) {
            this.tm = fontFace;
            return this;
        }

        public Builder setHeaderTextColor(int headerTextColor) {
            this.tn = headerTextColor;
            return this;
        }

        public Builder setHeaderTextSize(int headerTextSize) {
            this.to = headerTextSize;
            return this;
        }

        public Builder setLocation(Location location) {
            this.kt.a(location);
            return this;
        }

        public Builder setQuery(String query) {
            this.tp = query;
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean tagForChildDirectedTreatment) {
            this.kt.h(tagForChildDirectedTreatment);
            return this;
        }
    }

    private SearchAdRequest(Builder builder) {
        this.tc = builder.tc;
        this.td = builder.td;
        this.te = builder.te;
        this.tf = builder.tf;
        this.tg = builder.tg;
        this.th = builder.th;
        this.ti = builder.ti;
        this.tj = builder.tj;
        this.tk = builder.tk;
        this.tl = builder.tl;
        this.tm = builder.tm;
        this.tn = builder.tn;
        this.to = builder.to;
        this.tp = builder.tp;
        this.ks = new at(builder.kt, this);
    }

    at T() {
        return this.ks;
    }

    public int getAnchorTextColor() {
        return this.tc;
    }

    public int getBackgroundColor() {
        return this.td;
    }

    public int getBackgroundGradientBottom() {
        return this.te;
    }

    public int getBackgroundGradientTop() {
        return this.tf;
    }

    public int getBorderColor() {
        return this.tg;
    }

    public int getBorderThickness() {
        return this.th;
    }

    public int getBorderType() {
        return this.ti;
    }

    public int getCallButtonColor() {
        return this.tj;
    }

    public String getCustomChannels() {
        return this.tk;
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> adapterClass) {
        return this.ks.getCustomEventExtrasBundle(adapterClass);
    }

    public int getDescriptionTextColor() {
        return this.tl;
    }

    public String getFontFace() {
        return this.tm;
    }

    public int getHeaderTextColor() {
        return this.tn;
    }

    public int getHeaderTextSize() {
        return this.to;
    }

    public Location getLocation() {
        return this.ks.getLocation();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return this.ks.getNetworkExtras(networkExtrasClass);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> adapterClass) {
        return this.ks.getNetworkExtrasBundle(adapterClass);
    }

    public String getQuery() {
        return this.tp;
    }

    public boolean isTestDevice(Context context) {
        return this.ks.isTestDevice(context);
    }
}
