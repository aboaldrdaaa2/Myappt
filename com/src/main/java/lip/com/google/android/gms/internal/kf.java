package lip.com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

public class kf implements PanoramaApi {

    private static final class a extends com.google.android.gms.internal.kd.a {
        private final com.google.android.gms.common.api.a.d<com.google.android.gms.panorama.PanoramaApi.a> yR;

        public a(com.google.android.gms.common.api.a.d<com.google.android.gms.panorama.PanoramaApi.a> dVar) {
            this.yR = dVar;
        }

        public void a(int i, Bundle bundle, int i2, Intent intent) {
            this.yR.a(new kc(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null), intent, i2));
        }
    }

    private static final class c extends com.google.android.gms.internal.kd.a {
        private final com.google.android.gms.common.api.a.d<PanoramaResult> yR;

        public c(com.google.android.gms.common.api.a.d<PanoramaResult> dVar) {
            this.yR = dVar;
        }

        public void a(int i, Bundle bundle, int i2, Intent intent) {
            this.yR.a(new kh(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null), intent));
        }
    }

    private static abstract class d<R extends Result> extends com.google.android.gms.common.api.a.b<R, kg> {
        protected d() {
            super(Panorama.yH);
        }

        protected abstract void a(Context context, ke keVar) throws RemoteException;

        protected final void a(kg kgVar) throws RemoteException {
            a(kgVar.getContext(), (ke) kgVar.ft());
        }
    }

    /* renamed from: com.google.android.gms.internal.kf$1 */
    class AnonymousClass1 extends d<com.google.android.gms.panorama.PanoramaApi.a> {
        final /* synthetic */ Uri abk;
        final /* synthetic */ Bundle abl;

        protected void a(Context context, ke keVar) throws RemoteException {
            kf.a(context, keVar, new a(this), this.abk, this.abl);
        }

        /* renamed from: aj */
        protected com.google.android.gms.panorama.PanoramaApi.a c(Status status) {
            return new kc(status, null, 0);
        }
    }

    private static abstract class b extends d<PanoramaResult> {
        private b() {
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: ak */
        protected PanoramaResult c(Status status) {
            return new kh(status, null);
        }
    }

    private static void a(Context context, Uri uri) {
        context.revokeUriPermission(uri, 1);
    }

    private static void a(final Context context, ke keVar, final kd kdVar, final Uri uri, Bundle bundle) throws RemoteException {
        context.grantUriPermission(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, uri, 1);
        try {
            keVar.a(new com.google.android.gms.internal.kd.a() {
                public void a(int i, Bundle bundle, int i2, Intent intent) throws RemoteException {
                    kf.a(context, uri);
                    kdVar.a(i, bundle, i2, intent);
                }
            }, uri, bundle, true);
        } catch (RemoteException e) {
            a(context, uri);
            throw e;
        } catch (RuntimeException e2) {
            a(context, uri);
            throw e2;
        }
    }

    public PendingResult<PanoramaResult> loadPanoramaInfo(GoogleApiClient client, final Uri uri) {
        return client.a(new b() {
            protected void a(Context context, ke keVar) throws RemoteException {
                keVar.a(new c(this), uri, null, false);
            }
        });
    }

    public PendingResult<PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient client, final Uri uri) {
        return client.a(new b() {
            protected void a(Context context, ke keVar) throws RemoteException {
                kf.a(context, keVar, new c(this), uri, null);
            }
        });
    }
}
