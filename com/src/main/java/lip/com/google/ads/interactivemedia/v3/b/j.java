package lip.com.google.ads.interactivemedia.v3.b;

import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdsRequest;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
public final class j implements AdsRequest {
    private String a;
    private AdDisplayContainer b;
    private Map<String, String> c;
    private String d;
    private transient Object e;

    public final void setAdTagUrl(String adTagUrl) {
        this.a = adTagUrl;
    }

    public final String getAdTagUrl() {
        return this.a;
    }

    public final void setExtraParameter(String key, String value) {
        if (this.c == null) {
            this.c = new HashMap();
        }
        this.c.put(key, value);
    }

    public final String getExtraParameter(String key) {
        if (this.c == null) {
            return null;
        }
        return (String) this.c.get(key);
    }

    public final Map<String, String> getExtraParameters() {
        return this.c;
    }

    public final void setUserRequestContext(Object userRequestContext) {
        this.e = userRequestContext;
    }

    public final Object getUserRequestContext() {
        return this.e;
    }

    public final AdDisplayContainer getAdDisplayContainer() {
        return this.b;
    }

    public final void setAdDisplayContainer(AdDisplayContainer adDisplayContainer) {
        this.b = adDisplayContainer;
    }

    public final String getAdsResponse() {
        return this.d;
    }

    public final void setAdsResponse(String cannedAdResponse) {
        this.d = cannedAdResponse;
    }
}
