package lip.com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d;
import java.util.Map;

class m extends aj {
    private static final String ID = a.CONSTANT.toString();
    private static final String VALUE = b.VALUE.toString();

    public m() {
        super(ID, VALUE);
    }

    public static String lk() {
        return ID;
    }

    public static String ll() {
        return VALUE;
    }

    public boolean lh() {
        return true;
    }

    public d.a w(Map<String, d.a> map) {
        return (d.a) map.get(VALUE);
    }
}
