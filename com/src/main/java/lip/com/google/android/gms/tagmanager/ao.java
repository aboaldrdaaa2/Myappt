package lip.com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class ao extends aj {
    private static final String ID = a.HASH.toString();
    private static final String afA = b.INPUT_FORMAT.toString();
    private static final String afE = b.ALGORITHM.toString();
    private static final String afy = b.ARG0.toString();

    public ao() {
        super(ID, afy);
    }

    private byte[] c(String str, byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(bArr);
        return instance.digest();
    }

    public boolean lh() {
        return true;
    }

    public d.a w(Map<String, d.a> map) {
        d.a aVar = (d.a) map.get(afy);
        if (aVar == null || aVar == dh.nd()) {
            return dh.nd();
        }
        byte[] bytes;
        String j = dh.j(aVar);
        aVar = (d.a) map.get(afE);
        String j2 = aVar == null ? "MD5" : dh.j(aVar);
        aVar = (d.a) map.get(afA);
        String j3 = aVar == null ? "text" : dh.j(aVar);
        if ("text".equals(j3)) {
            bytes = j.getBytes();
        } else if ("base16".equals(j3)) {
            bytes = j.bE(j);
        } else {
            bh.A("Hash: unknown input format: " + j3);
            return dh.nd();
        }
        try {
            return dh.r(j.d(c(j2, bytes)));
        } catch (NoSuchAlgorithmException e) {
            bh.A("Hash: unknown algorithm: " + j2);
            return dh.nd();
        }
    }
}
