package lip.com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionApi;

public class ja implements ActivityRecognitionApi {

    private static abstract class a extends com.google.android.gms.location.ActivityRecognition.a<Status> {
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

    public PendingResult<Status> removeActivityUpdates(GoogleApiClient client, final PendingIntent callbackIntent) {
        return client.b(new a() {
            protected void a(jg jgVar) throws RemoteException {
                jgVar.removeActivityUpdates(callbackIntent);
                a(Status.En);
            }
        });
    }

    public PendingResult<Status> requestActivityUpdates(GoogleApiClient client, final long detectionIntervalMillis, final PendingIntent callbackIntent) {
        return client.b(new a() {
            protected void a(jg jgVar) throws RemoteException {
                jgVar.requestActivityUpdates(detectionIntervalMillis, callbackIntent);
                a(Status.En);
            }
        });
    }
}
