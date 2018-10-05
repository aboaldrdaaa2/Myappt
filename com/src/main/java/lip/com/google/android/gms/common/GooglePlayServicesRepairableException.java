package lip.com.google.android.gms.common;

import android.content.Intent;

public class GooglePlayServicesRepairableException extends UserRecoverableException {
    private final int yY;

    GooglePlayServicesRepairableException(int connectionStatusCode, String msg, Intent intent) {
        super(msg, intent);
        this.yY = connectionStatusCode;
    }

    public int getConnectionStatusCode() {
        return this.yY;
    }
}
