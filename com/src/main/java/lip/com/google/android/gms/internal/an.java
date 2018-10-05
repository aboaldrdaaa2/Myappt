package lip.com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.as.a;

public final class an extends a {
    private final AppEventListener mh;

    public an(AppEventListener appEventListener) {
        this.mh = appEventListener;
    }

    public void onAppEvent(String name, String info) {
        this.mh.onAppEvent(name, info);
    }
}
