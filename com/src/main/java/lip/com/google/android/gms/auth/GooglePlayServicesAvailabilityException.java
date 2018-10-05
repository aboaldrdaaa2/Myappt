package lip.com.google.android.gms.auth;

import android.content.Intent;

public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {
    private final int yY;

    GooglePlayServicesAvailabilityException(int connectionStatusCode, String msg, Intent intent) {
        super(msg, intent);
        this.yY = connectionStatusCode;
    }

    public int getConnectionStatusCode() {
        return this.yY;
    }
}
