package lip.com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class jb implements FusedLocationProviderApi {

    private static abstract class a extends com.google.android.gms.location.LocationServices.a<Status> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: d */
        public Status c(Status status) {
            return status;
        }
    }

    public Location getLastLocation(GoogleApiClient client) {
        try {
            return LocationServices.e(client).getLastLocation();
        } catch (Exception e) {
            return null;
        }
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, final PendingIntent callbackIntent) {
        return client.b(new a() {
            protected void a(jg jgVar) throws RemoteException {
                jgVar.removeLocationUpdates(callbackIntent);
                a(Status.En);
            }
        });
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, final LocationListener listener) {
        return client.b(new a() {
            protected void a(jg jgVar) throws RemoteException {
                jgVar.removeLocationUpdates(listener);
                a(Status.En);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final PendingIntent callbackIntent) {
        return client.b(new a() {
            protected void a(jg jgVar) throws RemoteException {
                jgVar.requestLocationUpdates(request, callbackIntent);
                a(Status.En);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final LocationListener listener) {
        return client.b(new a() {
            protected void a(jg jgVar) throws RemoteException {
                jgVar.requestLocationUpdates(request, listener);
                a(Status.En);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final LocationListener listener, final Looper looper) {
        return client.b(new a() {
            protected void a(jg jgVar) throws RemoteException {
                jgVar.requestLocationUpdates(request, listener, looper);
                a(Status.En);
            }
        });
    }

    public PendingResult<Status> setMockLocation(GoogleApiClient client, final Location mockLocation) {
        return client.b(new a() {
            protected void a(jg jgVar) throws RemoteException {
                jgVar.setMockLocation(mockLocation);
                a(Status.En);
            }
        });
    }

    public PendingResult<Status> setMockMode(GoogleApiClient client, final boolean isMockMode) {
        return client.b(new a() {
            protected void a(jg jgVar) throws RemoteException {
                jgVar.setMockMode(isMockMode);
                a(Status.En);
            }
        });
    }
}
