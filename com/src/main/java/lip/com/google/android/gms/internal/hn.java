package lip.com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.dynamic.g.a;

public final class hn extends g<hj> {
    private static final hn GL = new hn();

    private hn() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View b(Context context, int i, int i2) throws a {
        return GL.c(context, i, i2);
    }

    private View c(Context context, int i, int i2) throws a {
        try {
            return (View) e.e(((hj) G(context)).a(e.h(context), i, i2));
        } catch (Throwable e) {
            throw new a("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    /* renamed from: N */
    public hj d(IBinder iBinder) {
        return hj.a.M(iBinder);
    }
}
