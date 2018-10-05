package lip.com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.internal.ln.a;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public class ls extends g<ln> {
    private static ls akN;

    protected ls() {
        super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
    }

    public static lk a(Activity activity, c cVar, WalletFragmentOptions walletFragmentOptions, ll llVar) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (isGooglePlayServicesAvailable != 0) {
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
        try {
            return ((ln) nj().G(activity)).a(e.h(activity), cVar, walletFragmentOptions, llVar);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    private static ls nj() {
        if (akN == null) {
            akN = new ls();
        }
        return akN;
    }

    /* renamed from: bv */
    protected ln d(IBinder iBinder) {
        return a.br(iBinder);
    }
}
