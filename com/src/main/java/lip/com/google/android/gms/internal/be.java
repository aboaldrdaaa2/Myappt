package lip.com.google.android.gms.internal;

import com.facebook.AppEventsConstants;
import java.util.Map;

public class be implements bc {
    private final bf nc;

    public be(bf bfVar) {
        this.nc = bfVar;
    }

    public void b(ex exVar, Map<String, String> map) {
        this.nc.b(AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("transparentBackground")));
    }
}
