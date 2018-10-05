package lip.com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class ch extends dc {
    private static final String ID = a.REGEX.toString();
    private static final String agJ = b.IGNORE_CASE.toString();

    public ch() {
        super(ID);
    }

    protected boolean a(String str, String str2, Map<String, d.a> map) {
        try {
            return Pattern.compile(str2, dh.n((d.a) map.get(agJ)).booleanValue() ? 66 : 64).matcher(str).find();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }
}
