package lip.com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class cg extends aj {
    private static final String ID = a.REGEX_GROUP.toString();
    private static final String agH = b.ARG0.toString();
    private static final String agI = b.ARG1.toString();
    private static final String agJ = b.IGNORE_CASE.toString();
    private static final String agK = b.GROUP.toString();

    public cg() {
        super(ID, agH, agI);
    }

    public boolean lh() {
        return true;
    }

    public d.a w(Map<String, d.a> map) {
        d.a aVar = (d.a) map.get(agH);
        d.a aVar2 = (d.a) map.get(agI);
        if (aVar == null || aVar == dh.nd() || aVar2 == null || aVar2 == dh.nd()) {
            return dh.nd();
        }
        int intValue;
        int i = 64;
        if (dh.n((d.a) map.get(agJ)).booleanValue()) {
            i = 66;
        }
        d.a aVar3 = (d.a) map.get(agK);
        if (aVar3 != null) {
            Long l = dh.l(aVar3);
            if (l == dh.mY()) {
                return dh.nd();
            }
            intValue = l.intValue();
            if (intValue < 0) {
                return dh.nd();
            }
        }
        intValue = 1;
        try {
            CharSequence j = dh.j(aVar);
            Object obj = null;
            Matcher matcher = Pattern.compile(dh.j(aVar2), i).matcher(j);
            if (matcher.find() && matcher.groupCount() >= intValue) {
                obj = matcher.group(intValue);
            }
            return obj == null ? dh.nd() : dh.r(obj);
        } catch (PatternSyntaxException e) {
            return dh.nd();
        }
    }
}
