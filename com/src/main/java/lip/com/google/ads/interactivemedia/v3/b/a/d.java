package lip.com.google.ads.interactivemedia.v3.b.a;

import com.google.ads.interactivemedia.v3.api.AdsRequest;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.b.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
public final class d {
    private String adTagUrl;
    private String adsResponse;
    private Map<String, String> companionSlots;
    private String env;
    private Map<String, String> extraParameters;
    private String network;
    private ImaSdkSettings settings;

    public d(AdsRequest adsRequest, String str, String str2, ImaSdkSettings imaSdkSettings) {
        this.adTagUrl = adsRequest.getAdTagUrl();
        this.adsResponse = adsRequest.getAdsResponse();
        this.env = str;
        this.network = str2;
        this.extraParameters = adsRequest.getExtraParameters();
        this.settings = imaSdkSettings;
        Map a = ((a) adsRequest.getAdDisplayContainer()).a();
        if (a != null && !a.isEmpty()) {
            this.companionSlots = new HashMap();
            for (String str3 : a.keySet()) {
                CompanionAdSlot companionAdSlot = (CompanionAdSlot) a.get(str3);
                this.companionSlots.put(str3, companionAdSlot.getWidth() + "x" + companionAdSlot.getHeight());
            }
        }
    }

    public final String toString() {
        String str = "adTagUrl=" + this.adTagUrl + ", env=" + this.env + ", network=" + this.network + ", companionSlots=" + this.companionSlots + ", extraParameters=" + this.extraParameters + ", settings=" + this.settings;
        if (this.adsResponse != null) {
            str = str + ", adsResponse=" + this.adsResponse;
        }
        return "GsonAdsRequest [" + str + "]";
    }
}
