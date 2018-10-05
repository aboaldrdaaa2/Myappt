package lip.com.google.android.gms.appindexing;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.internal.ff;
import com.google.android.gms.internal.fy;

public final class AppIndex {
    public static final Api<NoOptions> APP_INDEX_API = ff.xK;
    public static final AppIndexApi AppIndexApi = new fy();

    private AppIndex() {
    }
}
