package lip.com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener;
import com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.ArrayList;
import java.util.List;

public class jc implements GeofencingApi {

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

    public PendingResult<Status> addGeofences(GoogleApiClient client, List<Geofence> geofences, final PendingIntent pendingIntent) {
        List list;
        if (geofences != null) {
            List arrayList = new ArrayList(geofences.size());
            for (Geofence geofence : geofences) {
                hm.b(geofence instanceof jh, (Object) "Geofence must be created using Geofence.Builder.");
                arrayList.add((jh) geofence);
            }
            list = arrayList;
        } else {
            list = null;
        }
        return client.b(new a() {
            protected void a(jg jgVar) throws RemoteException {
                jgVar.addGeofences(list, pendingIntent, new OnAddGeofencesResultListener() {
                    public void onAddGeofencesResult(int statusCode, String[] geofenceRequestIds) {
                        AnonymousClass1.this.a(LocationStatusCodes.cK(statusCode));
                    }
                });
            }
        });
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient client, final PendingIntent pendingIntent) {
        return client.b(new a() {
            protected void a(jg jgVar) throws RemoteException {
                jgVar.removeGeofences(pendingIntent, new OnRemoveGeofencesResultListener() {
                    public void onRemoveGeofencesByPendingIntentResult(int statusCode, PendingIntent pendingIntent) {
                        AnonymousClass2.this.a(LocationStatusCodes.cK(statusCode));
                    }

                    public void onRemoveGeofencesByRequestIdsResult(int statusCode, String[] geofenceRequestIds) {
                        Log.wtf("GeofencingImpl", "Request ID callback shouldn't have been called");
                    }
                });
            }
        });
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient client, final List<String> geofenceRequestIds) {
        return client.b(new a() {
            protected void a(jg jgVar) throws RemoteException {
                jgVar.removeGeofences(geofenceRequestIds, new OnRemoveGeofencesResultListener() {
                    public void onRemoveGeofencesByPendingIntentResult(int statusCode, PendingIntent pendingIntent) {
                        Log.wtf("GeofencingImpl", "PendingIntent callback shouldn't have been called");
                    }

                    public void onRemoveGeofencesByRequestIdsResult(int statusCode, String[] geofenceRequestIds) {
                        AnonymousClass3.this.a(LocationStatusCodes.cK(statusCode));
                    }
                });
            }
        });
    }
}
