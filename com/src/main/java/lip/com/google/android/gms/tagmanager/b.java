package lip.com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d;
import java.util.Map;

class b extends aj {
    private static final String ID = a.ADVERTISER_ID.toString();
    private final a aej;

    public b(Context context) {
        this(a.M(context));
    }

    b(a aVar) {
        super(ID, new String[0]);
        this.aej = aVar;
    }

    public boolean lh() {
        return false;
    }

    public d.a w(Map<String, d.a> map) {
        String ld = this.aej.ld();
        return ld == null ? dh.nd() : dh.r(ld);
    }
}
