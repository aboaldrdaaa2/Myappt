package lip.com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.a;

public class b extends a<Boolean> {
    public b(String str, int i) {
        super(str, i);
    }

    protected void a(Bundle bundle, Boolean bool) {
        bundle.putBoolean(getName(), bool.booleanValue());
    }

    /* renamed from: d */
    protected Boolean b(DataHolder dataHolder, int i, int i2) {
        return Boolean.valueOf(dataHolder.d(getName(), i, i2));
    }

    /* renamed from: g */
    protected Boolean f(Bundle bundle) {
        return Boolean.valueOf(bundle.getBoolean(getName()));
    }
}
