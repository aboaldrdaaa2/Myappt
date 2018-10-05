package lip.com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;

public class aw extends c {
    private final d<Status> yR;

    public aw(d<Status> dVar) {
        this.yR = dVar;
    }

    public void o(Status status) throws RemoteException {
        this.yR.a(status);
    }

    public void onSuccess() throws RemoteException {
        this.yR.a(Status.En);
    }
}
