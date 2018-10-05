package lip.com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.DriveResource.MetadataResult;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;

public class v implements DriveResource {
    protected final DriveId Hz;

    private static class e implements MetadataResult {
        private final Metadata Jm;
        private final Status yz;

        public e(Status status, Metadata metadata) {
            this.yz = status;
            this.Jm = metadata;
        }

        public Metadata getMetadata() {
            return this.Jm;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static class b extends c {
        private final com.google.android.gms.common.api.a.d<MetadataBufferResult> yR;

        public b(com.google.android.gms.common.api.a.d<MetadataBufferResult> dVar) {
            this.yR = dVar;
        }

        public void a(OnListParentsResponse onListParentsResponse) throws RemoteException {
            this.yR.a(new e(Status.En, new MetadataBuffer(onListParentsResponse.gA(), null), false));
        }

        public void o(Status status) throws RemoteException {
            this.yR.a(new e(status, null, false));
        }
    }

    private static class d extends c {
        private final com.google.android.gms.common.api.a.d<MetadataResult> yR;

        public d(com.google.android.gms.common.api.a.d<MetadataResult> dVar) {
            this.yR = dVar;
        }

        public void a(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.yR.a(new e(Status.En, new l(onMetadataResponse.gB())));
        }

        public void o(Status status) throws RemoteException {
            this.yR.a(new e(status, null));
        }
    }

    private abstract class a extends q<MetadataResult> {
        private a() {
        }

        /* synthetic */ a(v vVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: u */
        public MetadataResult c(Status status) {
            return new e(status, null);
        }
    }

    private abstract class c extends q<MetadataBufferResult> {
        private c() {
        }

        /* synthetic */ c(v vVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: r */
        public MetadataBufferResult c(Status status) {
            return new e(status, null, false);
        }
    }

    private abstract class f extends q<MetadataResult> {
        private f() {
        }

        /* synthetic */ f(v vVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: u */
        public MetadataResult c(Status status) {
            return new e(status, null);
        }
    }

    protected v(DriveId driveId) {
        this.Hz = driveId;
    }

    public PendingResult<Status> addChangeListener(GoogleApiClient apiClient, Listener<ChangeEvent> listener) {
        return ((r) apiClient.a(Drive.yH)).a(apiClient, this.Hz, 1, listener);
    }

    public DriveId getDriveId() {
        return this.Hz;
    }

    public PendingResult<MetadataResult> getMetadata(GoogleApiClient apiClient) {
        return apiClient.a(new a() {
            protected void a(r rVar) throws RemoteException {
                rVar.gp().a(new GetMetadataRequest(v.this.Hz), new d(this));
            }
        });
    }

    public PendingResult<MetadataBufferResult> listParents(GoogleApiClient apiClient) {
        return apiClient.a(new c() {
            protected void a(r rVar) throws RemoteException {
                rVar.gp().a(new ListParentsRequest(v.this.Hz), new b(this));
            }
        });
    }

    public PendingResult<Status> removeChangeListener(GoogleApiClient apiClient, Listener<ChangeEvent> listener) {
        return ((r) apiClient.a(Drive.yH)).b(apiClient, this.Hz, 1, listener);
    }

    public PendingResult<MetadataResult> updateMetadata(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet != null) {
            return apiClient.b(new f() {
                protected void a(r rVar) throws RemoteException {
                    rVar.gp().a(new UpdateMetadataRequest(v.this.Hz, changeSet.gm()), new d(this));
                }
            });
        }
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }
}
