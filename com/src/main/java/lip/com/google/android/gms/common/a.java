package lip.com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class a implements ServiceConnection {
    boolean CQ = false;
    private final BlockingQueue<IBinder> CR = new LinkedBlockingQueue();

    public IBinder ew() throws InterruptedException {
        if (this.CQ) {
            throw new IllegalStateException();
        }
        this.CQ = true;
        return (IBinder) this.CR.take();
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        try {
            this.CR.put(service);
        } catch (InterruptedException e) {
        }
    }

    public void onServiceDisconnected(ComponentName name) {
    }
}
