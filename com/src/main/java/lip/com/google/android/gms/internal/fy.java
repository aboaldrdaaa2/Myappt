package lip.com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.List;

public final class fy implements AppIndexApi, ft {

    private static abstract class a<T> implements Result {
        protected final T yA;
        private final Status yz;

        public a(Status status, T t) {
            this.yz = status;
            this.yA = t;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    static class b extends a<ParcelFileDescriptor> implements com.google.android.gms.internal.ft.a {
        public b(Status status, ParcelFileDescriptor parcelFileDescriptor) {
            super(status, parcelFileDescriptor);
        }
    }

    private static abstract class c<T extends Result> extends com.google.android.gms.common.api.a.b<T, fx> {
        public c() {
            super(ff.xI);
        }

        protected abstract void a(fu fuVar) throws RemoteException;

        protected final void a(fx fxVar) throws RemoteException {
            a(fxVar.dR());
        }
    }

    private static final class e extends fw<Status> {
        public e(com.google.android.gms.common.api.a.d<Status> dVar) {
            super(dVar);
        }

        public void a(Status status) {
            this.yu.a(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.fy$1 */
    class AnonymousClass1 extends c<com.google.android.gms.internal.ft.a> {
        protected void a(fu fuVar) throws RemoteException {
            fuVar.a(new fw<com.google.android.gms.internal.ft.a>(this) {
                public void a(Status status, ParcelFileDescriptor parcelFileDescriptor) {
                    this.yu.a(new b(status, parcelFileDescriptor));
                }
            });
        }

        /* renamed from: b */
        public com.google.android.gms.internal.ft.a c(Status status) {
            return new b(status, null);
        }
    }

    private static abstract class d<T extends Result> extends c<Status> {
        private d() {
        }

        /* synthetic */ d(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: d */
        protected Status c(Status status) {
            return status;
        }
    }

    static Uri a(String str, Uri uri) {
        if (!"android-app".equals(uri.getScheme())) {
            throw new IllegalArgumentException("Uri scheme must be android-app: " + uri);
        } else if (str.equals(uri.getHost())) {
            List pathSegments = uri.getPathSegments();
            if (pathSegments.isEmpty() || ((String) pathSegments.get(0)).isEmpty()) {
                throw new IllegalArgumentException("Uri path must exist: " + uri);
            }
            String str2 = (String) pathSegments.get(0);
            Builder builder = new Builder();
            builder.scheme(str2);
            if (pathSegments.size() > 1) {
                builder.authority((String) pathSegments.get(1));
                int i = 2;
                while (true) {
                    int i2 = i;
                    if (i2 >= pathSegments.size()) {
                        break;
                    }
                    builder.appendPath((String) pathSegments.get(i2));
                    i = i2 + 1;
                }
            }
            builder.encodedQuery(uri.getEncodedQuery());
            builder.encodedFragment(uri.getEncodedFragment());
            return builder.build();
        } else {
            throw new IllegalArgumentException("Uri host must match package name: " + uri);
        }
    }

    public PendingResult<Status> a(GoogleApiClient googleApiClient, final fr... frVarArr) {
        final String packageName = ((fx) googleApiClient.a(ff.xI)).getContext().getPackageName();
        return googleApiClient.a(new d<Status>() {
            protected void a(fu fuVar) throws RemoteException {
                fuVar.a(new e(this), packageName, frVarArr);
            }
        });
    }

    public PendingResult<Status> view(GoogleApiClient apiClient, Activity activity, Intent viewIntent, String title, Uri webUrl, List<AppIndexingLink> outLinks) {
        return a(apiClient, new fr(((fx) apiClient.a(ff.xI)).getContext().getPackageName(), viewIntent, title, webUrl, null, (List) outLinks));
    }

    public PendingResult<Status> view(GoogleApiClient apiClient, Activity activity, Uri appIndexingUrl, String title, Uri webUrl, List<AppIndexingLink> outLinks) {
        return view(apiClient, activity, new Intent("android.intent.action.VIEW", a(((fx) apiClient.a(ff.xI)).getContext().getPackageName(), appIndexingUrl)), title, webUrl, (List) outLinks);
    }

    public PendingResult<Status> viewEnd(GoogleApiClient apiClient, Activity activity, Intent viewIntent) {
        fr frVar = new fr(fr.a(((fx) apiClient.a(ff.xI)).getContext().getPackageName(), viewIntent), System.currentTimeMillis(), 3);
        return a(apiClient, frVar);
    }

    public PendingResult<Status> viewEnd(GoogleApiClient apiClient, Activity activity, Uri appIndexingUrl) {
        return viewEnd(apiClient, activity, new Intent("android.intent.action.VIEW", a(((fx) apiClient.a(ff.xI)).getContext().getPackageName(), appIndexingUrl)));
    }
}
