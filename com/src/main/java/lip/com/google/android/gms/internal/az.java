package lip.com.google.android.gms.internal;

import java.util.Map;

public final class az implements bc {
    private final ba mS;

    public az(ba baVar) {
        this.mS = baVar;
    }

    public void b(ex exVar, Map<String, String> map) {
        String str = (String) map.get("name");
        if (str == null) {
            eu.D("App event with no name parameter.");
        } else {
            this.mS.onAppEvent(str, (String) map.get("info"));
        }
    }
}
