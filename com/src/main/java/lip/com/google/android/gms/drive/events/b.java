package lip.com.google.android.gms.drive.events;

import com.google.android.gms.drive.DriveId;

public class b {
    public static boolean a(int i, DriveId driveId) {
        return driveId != null || aK(i);
    }

    public static boolean aK(int i) {
        return (6 & ((long) (1 << i))) != 0;
    }
}
