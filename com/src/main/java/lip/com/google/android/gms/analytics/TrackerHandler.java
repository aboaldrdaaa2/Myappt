package lip.com.google.android.gms.analytics;

import java.util.Map;

abstract class TrackerHandler {
    TrackerHandler() {
    }

    abstract void p(Map<String, String> map);
}
