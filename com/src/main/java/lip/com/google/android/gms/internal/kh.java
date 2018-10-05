package lip.com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

class kh implements PanoramaResult {
    private final Intent abo;
    private final Status yz;

    public kh(Status status, Intent intent) {
        this.yz = (Status) hm.f(status);
        this.abo = intent;
    }

    public Status getStatus() {
        return this.yz;
    }

    public Intent getViewerIntent() {
        return this.abo;
    }
}
