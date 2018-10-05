package lip.com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d;
import java.util.Map;

class ac extends aj {
    private static final String ID = a.ENCODE.toString();
    private static final String afA = b.INPUT_FORMAT.toString();
    private static final String afB = b.OUTPUT_FORMAT.toString();
    private static final String afy = b.ARG0.toString();
    private static final String afz = b.NO_PADDING.toString();

    public ac() {
        super(ID, afy);
    }

    public boolean lh() {
        return true;
    }

    public d.a w(Map<String, d.a> map) {
        d.a aVar = (d.a) map.get(afy);
        if (aVar == null || aVar == dh.nd()) {
            return dh.nd();
        }
        String j = dh.j(aVar);
        aVar = (d.a) map.get(afA);
        String j2 = aVar == null ? "text" : dh.j(aVar);
        aVar = (d.a) map.get(afB);
        String j3 = aVar == null ? "base16" : dh.j(aVar);
        aVar = (d.a) map.get(afz);
        int i = (aVar == null || !dh.n(aVar).booleanValue()) ? 2 : 3;
        try {
            byte[] bytes;
            Object d;
            if ("text".equals(j2)) {
                bytes = j.getBytes();
            } else if ("base16".equals(j2)) {
                bytes = j.bE(j);
            } else if ("base64".equals(j2)) {
                bytes = Base64.decode(j, i);
            } else if ("base64url".equals(j2)) {
                bytes = Base64.decode(j, i | 8);
            } else {
                bh.A("Encode: unknown input format: " + j2);
                return dh.nd();
            }
            if ("base16".equals(j3)) {
                d = j.d(bytes);
            } else if ("base64".equals(j3)) {
                d = Base64.encodeToString(bytes, i);
            } else if ("base64url".equals(j3)) {
                d = Base64.encodeToString(bytes, i | 8);
            } else {
                bh.A("Encode: unknown output format: " + j3);
                return dh.nd();
            }
            return dh.r(d);
        } catch (IllegalArgumentException e) {
            bh.A("Encode: invalid input:");
            return dh.nd();
        }
    }
}
