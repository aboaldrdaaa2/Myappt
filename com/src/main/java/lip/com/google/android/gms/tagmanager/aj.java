package lip.com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class aj {
    private final Set<String> afC;
    private final String afD;

    public aj(String str, String... strArr) {
        this.afD = str;
        this.afC = new HashSet(strArr.length);
        for (Object add : strArr) {
            this.afC.add(add);
        }
    }

    boolean a(Set<String> set) {
        return set.containsAll(this.afC);
    }

    public String lL() {
        return this.afD;
    }

    public Set<String> lM() {
        return this.afC;
    }

    public abstract boolean lh();

    public abstract a w(Map<String, a> map);
}
