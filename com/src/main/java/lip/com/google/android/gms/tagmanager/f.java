package lip.com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d;
import java.util.Map;

class f extends aj {
    private static final String ID = a.APP_ID.toString();
    private final Context mContext;

    public f(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean lh() {
        return true;
    }

    public d.a w(Map<String, d.a> map) {
        return dh.r(this.mContext.getPackageName());
    }
}
