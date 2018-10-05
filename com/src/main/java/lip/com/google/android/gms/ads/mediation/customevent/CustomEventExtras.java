package lip.com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
public final class CustomEventExtras implements NetworkExtras {
    private final HashMap<String, Object> ta = new HashMap();

    public Object getExtra(String label) {
        return this.ta.get(label);
    }

    public void setExtra(String label, Object value) {
        this.ta.put(label, value);
    }
}
