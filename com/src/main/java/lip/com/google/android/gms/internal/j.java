package lip.com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import java.io.IOException;

public class j extends i {

    class a {
        private String kd;
        private boolean ke;

        public a(String str, boolean z) {
            this.kd = str;
            this.ke = z;
        }

        public String getId() {
            return this.kd;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.ke;
        }
    }

    protected j(Context context, m mVar, n nVar) {
        super(context, mVar, nVar);
    }

    public static j a(String str, Context context) {
        m eVar = new e();
        i.a(str, context, eVar);
        return new j(context, eVar, new p(239));
    }

    protected void c(Context context) {
        super.c(context);
        try {
            a i = i(context);
            a(28, i.isLimitAdTrackingEnabled() ? 1 : 0);
            String id = i.getId();
            if (id != null) {
                a(26, 5);
                a(24, id);
            }
        } catch (GooglePlayServicesNotAvailableException e) {
            try {
                a(24, i.f(context));
            } catch (IOException e2) {
            } catch (a e3) {
            }
        }
    }

    protected void d(Context context) {
        long j = 1;
        super.c(context);
        try {
            a(24, i.f(context));
        } catch (a e) {
        }
        try {
            a i = i(context);
            try {
                if (!i.isLimitAdTrackingEnabled()) {
                    j = 0;
                }
                a(28, j);
                String id = i.getId();
                if (id != null) {
                    a(30, id);
                }
            } catch (IOException e2) {
            }
        } catch (GooglePlayServicesNotAvailableException e3) {
        } catch (IOException e4) {
            a(28, 1);
        }
    }

    a i(Context context) throws IOException, GooglePlayServicesNotAvailableException {
        int i = 0;
        try {
            String str;
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            String id = advertisingIdInfo.getId();
            if (id == null || !id.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")) {
                str = id;
            } else {
                byte[] bArr = new byte[16];
                int i2 = 0;
                while (i < id.length()) {
                    if (i == 8 || i == 13 || i == 18 || i == 23) {
                        i++;
                    }
                    bArr[i2] = (byte) ((Character.digit(id.charAt(i), 16) << 4) + Character.digit(id.charAt(i + 1), 16));
                    i2++;
                    i += 2;
                }
                str = this.jQ.a(bArr, true);
            }
            return new a(str, advertisingIdInfo.isLimitAdTrackingEnabled());
        } catch (Throwable e) {
            throw new IOException(e);
        }
    }
}
