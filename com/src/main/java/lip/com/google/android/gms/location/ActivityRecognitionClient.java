package lip.com.google.android.gms.location;

import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.jg;

@Deprecated
public class ActivityRecognitionClient implements GooglePlayServicesClient {
    private final jg UU;

    public ActivityRecognitionClient(Context context, ConnectionCallbacks connectedListener, OnConnectionFailedListener connectionFailedListener) {
        this.UU = new jg(context, connectedListener, connectionFailedListener, ActivityRecognition.CLIENT_NAME);
    }

    public void connect() {
        this.UU.connect();
    }

    public void disconnect() {
        this.UU.disconnect();
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

    public void removeActivityUpdates(PendingIntent callbackIntent) {
        try {
            this.UU.removeActivityUpdates(callbackIntent);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void requestActivityUpdates(long detectionIntervalMillis, PendingIntent callbackIntent) {
        try {
            this.UU.requestActivityUpdates(detectionIntervalMillis, callbackIntent);
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
