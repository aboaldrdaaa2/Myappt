package lip.com.google.android.gms.drive.events;

import android.app.IntentService;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.internal.hm;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.concurrent.LinkedBlockingDeque;

public abstract class DriveEventService extends IntentService {
    private static final LinkedBlockingDeque<DriveEvent> Ih = new LinkedBlockingDeque();
    private final String mName;

    protected DriveEventService() {
        this("DriveEventService");
    }

    protected DriveEventService(String name) {
        super(name);
        this.mName = name;
    }

    private void a(DriveEvent driveEvent) {
        try {
            switch (driveEvent.getType()) {
                case 1:
                    hm.a(driveEvent instanceof ChangeEvent, "Unexpected event type: %s", driveEvent);
                    onChangeEvent((ChangeEvent) driveEvent);
                    return;
                case 2:
                    hm.a(driveEvent instanceof FileConflictEvent, "Unexpected event type: %s", driveEvent);
                    a((FileConflictEvent) driveEvent);
                    return;
                default:
                    Log.w(this.mName, "Unrecognized event: " + driveEvent);
                    return;
            }
        } catch (Throwable e) {
            Log.wtf(this.mName, "Service does not implement listener for type:" + driveEvent.getType(), e);
        } catch (Throwable e2) {
            Log.w(this.mName, "Error handling event: " + driveEvent, e2);
        }
    }

    public void a(FileConflictEvent fileConflictEvent) {
        Log.w("DriveEventService", "Unhandled FileConflictEvent: " + fileConflictEvent);
    }

    public IBinder onBind(Intent intent) {
        return new Binder() {
            protected boolean onTransact(int code, Parcel in, Parcel out, int flags) {
                Log.d("DriveEventService", "onTransact");
                DriveEventService.Ih.add((DriveEvent) in.readParcelable(DriveEventService.this.getClassLoader()));
                DriveEventService.this.startService(new Intent(DriveEventService.this, DriveEventService.this.getClass()));
                return true;
            }
        };
    }

    public void onChangeEvent(ChangeEvent event) {
        Log.w("DriveEventService", "Unhandled ChangeEvent: " + event);
    }

    protected final void onHandleIntent(Intent intent) {
        intent.setExtrasClassLoader(getClassLoader());
        DriveEvent driveEvent = (DriveEvent) intent.getParcelableExtra(DataLayer.EVENT_KEY);
        if (driveEvent == null) {
            driveEvent = (DriveEvent) Ih.poll();
        }
        if (driveEvent != null) {
            a(driveEvent);
        } else {
            Log.e("DriveEventService", "The event queue is unexpectedly empty.");
        }
    }
}
