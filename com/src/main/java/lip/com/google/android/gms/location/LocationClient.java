package lip.com.google.android.gms.location;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
public class LocationClient implements GooglePlayServicesClient {
    public static final String KEY_LOCATION_CHANGED = "com.google.android.location.LOCATION";
    public static final String KEY_MOCK_LOCATION = "mockLocation";
    private final jg UU;

    public interface OnAddGeofencesResultListener {
        void onAddGeofencesResult(int i, String[] strArr);
    }

    public interface OnRemoveGeofencesResultListener {
        void onRemoveGeofencesByPendingIntentResult(int i, PendingIntent pendingIntent);

        void onRemoveGeofencesByRequestIdsResult(int i, String[] strArr);
    }

    public LocationClient(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener connectionFailedListener) {
        this.UU = new jg(context, connectionCallbacks, connectionFailedListener, "location");
    }

    public static int getErrorCode(Intent intent) {
        return intent.getIntExtra("gms_error_code", -1);
    }

    public static int getGeofenceTransition(Intent intent) {
        int intExtra = intent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
        if (intExtra == -1) {
            return -1;
        }
        return (intExtra == 1 || intExtra == 2 || intExtra == 4) ? intExtra : -1;
    }

    public static List<Geofence> getTriggeringGeofences(Intent intent) {
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if (arrayList == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(jh.h((byte[]) it.next()));
        }
        return arrayList2;
    }

    public static Location getTriggeringLocation(Intent intent) {
        return (Location) intent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location");
    }

    public static boolean hasError(Intent intent) {
        return intent.hasExtra("gms_error_code");
    }

    public void addGeofences(List<Geofence> geofences, PendingIntent pendingIntent, OnAddGeofencesResultListener listener) {
        List list = null;
        if (geofences != null) {
            List arrayList = new ArrayList();
            for (Geofence geofence : geofences) {
                hm.b(geofence instanceof jh, (Object) "Geofence must be created using Geofence.Builder.");
                arrayList.add((jh) geofence);
            }
            list = arrayList;
        }
        try {
            this.UU.addGeofences(list, pendingIntent, listener);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void connect() {
        this.UU.connect();
    }

    public void disconnect() {
        this.UU.disconnect();
    }

    public Location getLastLocation() {
        return this.UU.getLastLocation();
    }

    public boolean isConnected() {
        return this.UU.isConnected();
    }

    public boolean isConnecting() {
        return this.UU.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.UU.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.UU.isConnectionFailedListenerRegistered(listener);
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.UU.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.UU.registerConnectionFailedListener(listener);
    }

    public void removeGeofences(PendingIntent pendingIntent, OnRemoveGeofencesResultListener listener) {
        try {
            this.UU.removeGeofences(pendingIntent, listener);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeGeofences(List<String> geofenceRequestIds, OnRemoveGeofencesResultListener listener) {
        try {
            this.UU.removeGeofences((List) geofenceRequestIds, listener);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(PendingIntent callbackIntent) {
        try {
            this.UU.removeLocationUpdates(callbackIntent);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(LocationListener listener) {
        try {
            this.UU.removeLocationUpdates(listener);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void requestLocationUpdates(LocationRequest request, PendingIntent callbackIntent) {
        try {
            this.UU.requestLocationUpdates(request, callbackIntent);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener) {
        try {
            this.UU.requestLocationUpdates(request, listener);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener, Looper looper) {
        try {
            this.UU.requestLocationUpdates(request, listener, looper);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void setMockLocation(Location mockLocation) {
        try {
            this.UU.setMockLocation(mockLocation);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void setMockMode(boolean isMockMode) {
        try {
            this.UU.setMockMode(isMockMode);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.UU.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.UU.unregisterConnectionFailedListener(listener);
    }
}
