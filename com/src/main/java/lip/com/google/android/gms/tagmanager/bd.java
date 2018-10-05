package lip.com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d;
import java.util.Map;

class bd extends bx {
    private static final String ID = a.LESS_EQUALS.toString();

    public bd() {
        super(ID);
    }

    protected boolean a(dg dgVar, dg dgVar2, Map<String, d.a> map) {
        return dgVar.compareTo(dgVar2) <= 0;
    }
}
