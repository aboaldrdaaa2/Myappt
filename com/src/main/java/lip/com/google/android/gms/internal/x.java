package lip.com.google.android.gms.internal;

import com.facebook.AppEventsConstants;
import java.util.HashMap;
import java.util.Map;

class x implements z {
    private ex le;

    public x(ex exVar) {
        this.le = exVar;
    }

    public void a(ac acVar, boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("isVisible", z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.le.a("onAdVisibilityChanged", hashMap);
    }
}
