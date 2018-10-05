package lip.com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import java.util.Date;

public class d extends com.google.android.gms.drive.metadata.d<Date> {
    public d(String str, int i) {
        super(str, i);
    }

    protected void a(Bundle bundle, Date date) {
        bundle.putLong(getName(), date.getTime());
    }

    /* renamed from: e */
    protected Date b(DataHolder dataHolder, int i, int i2) {
        return new Date(dataHolder.a(getName(), i, i2));
    }

    /* renamed from: h */
    protected Date f(Bundle bundle) {
        return new Date(bundle.getLong(getName()));
    }
}
