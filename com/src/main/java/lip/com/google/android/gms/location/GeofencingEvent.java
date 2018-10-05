package lip.com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import com.google.android.gms.internal.jh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeofencingEvent {
    private final int Vi;
    private final List<Geofence> Vj;
    private final Location Vk;
    private final int pJ;

    private GeofencingEvent(int errorCode, int transitionType, List<Geofence> triggeringGeofences, Location triggeringLocaton) {
        this.pJ = errorCode;
        this.Vi = transitionType;
        this.Vj = triggeringGeofences;
        this.Vk = triggeringLocaton;
    }

    public static GeofencingEvent fromIntent(Intent intent) {
        return intent == null ? null : new GeofencingEvent(intent.getIntExtra("gms_error_code", -1), getGeofenceTransition(intent), getTriggeringGeofences(intent), (Location) intent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
    }

    private static int getGeofenceTransition(Intent intent) {
        int intExtra = intent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
        if (intExtra == -1) {
            return -1;
        }
        return (intExtra == 1 || intExtra == 2 || intExtra == 4) ? intExtra : -1;
    }

    private static List<Geofence> getTriggeringGeofences(Intent intent) {
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

    public int getErrorCode() {
        return this.pJ;
    }

    public int getGeofenceTransition() {
        return this.Vi;
    }

    public List<Geofence> getTriggeringGeofences() {
        return this.Vj;
    }

    public Location getTriggeringLocation() {
        return this.Vk;
    }

    public boolean hasError() {
        return this.pJ != -1;
    }
}
