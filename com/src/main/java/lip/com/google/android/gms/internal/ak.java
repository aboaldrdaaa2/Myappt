package lip.com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ak {
    public static final ak md = new ak();

    private ak() {
    }

    public static ak aF() {
        return md;
    }

    public ai a(Context context, at atVar) {
        Date birthday = atVar.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1;
        String contentUrl = atVar.getContentUrl();
        int gender = atVar.getGender();
        Collection keywords = atVar.getKeywords();
        List unmodifiableList = !keywords.isEmpty() ? Collections.unmodifiableList(new ArrayList(keywords)) : null;
        boolean isTestDevice = atVar.isTestDevice(context);
        int aK = atVar.aK();
        Location location = atVar.getLocation();
        Bundle networkExtrasBundle = atVar.getNetworkExtrasBundle(AdMobAdapter.class);
        boolean manualImpressionsEnabled = atVar.getManualImpressionsEnabled();
        String publisherProvidedId = atVar.getPublisherProvidedId();
        SearchAdRequest aH = atVar.aH();
        return new ai(4, time, networkExtrasBundle, gender, unmodifiableList, isTestDevice, aK, manualImpressionsEnabled, publisherProvidedId, aH != null ? new aw(aH) : null, location, contentUrl, atVar.aJ());
    }
}
