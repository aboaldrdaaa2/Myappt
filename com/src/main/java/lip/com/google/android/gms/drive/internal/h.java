package lip.com.google.android.gms.drive.internal;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.internal.hm;

public class h {
    private String HY;
    protected MetadataChangeSet IA;
    private Integer IB;
    private final int IC;
    private DriveId Ia;

    public h(int i) {
        this.IC = i;
    }

    public void a(DriveId driveId) {
        this.Ia = (DriveId) hm.f(driveId);
    }

    public void a(MetadataChangeSet metadataChangeSet) {
        this.IA = (MetadataChangeSet) hm.f(metadataChangeSet);
    }

    public void aM(String str) {
        this.HY = (String) hm.f(str);
    }

    public void aS(int i) {
        this.IB = Integer.valueOf(i);
    }

    public IntentSender build(GoogleApiClient apiClient) {
        hm.b(this.IA, (Object) "Must provide initial metadata to CreateFileActivityBuilder.");
        hm.a(apiClient.isConnected(), "Client must be connected");
        try {
            return ((r) apiClient.a(Drive.yH)).gp().a(new CreateFileIntentSenderRequest(this.IA.gm(), this.IB == null ? -1 : this.IB.intValue(), this.HY, this.Ia, this.IC));
        } catch (Throwable e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }
}
