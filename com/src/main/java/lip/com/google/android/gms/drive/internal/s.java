package lip.com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.ContentsResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;

public class s extends v implements DriveFile {

    private static class c extends c {
        private final DownloadProgressListener Je;
        private final com.google.android.gms.common.api.a.d<ContentsResult> yR;

        public c(com.google.android.gms.common.api.a.d<ContentsResult> dVar, DownloadProgressListener downloadProgressListener) {
            this.yR = dVar;
            this.Je = downloadProgressListener;
        }

        public void a(OnContentsResponse onContentsResponse) throws RemoteException {
            this.yR.a(new com.google.android.gms.drive.internal.p.a(Status.En, onContentsResponse.gt()));
        }

        public void a(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
            if (this.Je != null) {
                this.Je.onProgress(onDownloadProgressResponse.gu(), onDownloadProgressResponse.gv());
            }
        }

        public void o(Status status) throws RemoteException {
            this.yR.a(new com.google.android.gms.drive.internal.p.a(status, null));
        }
    }

    private abstract class a extends q<Status> {
        private a() {
        }

        /* synthetic */ a(s sVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: d */
        public Status c(Status status) {
            return status;
        }
    }

    private abstract class b extends q<Status> {
        private b() {
        }

        /* synthetic */ b(s sVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: d */
        public Status c(Status status) {
            return status;
        }
    }

    private abstract class d extends q<ContentsResult> {
        private d() {
        }

        /* synthetic */ d(s sVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: q */
        public ContentsResult c(Status status) {
            return new com.google.android.gms.drive.internal.p.a(status, null);
        }
    }

    public s(DriveId driveId) {
        super(driveId);
    }

    public PendingResult<Status> commitAndCloseContents(GoogleApiClient apiClient, final Contents contents) {
        if (contents != null) {
            return apiClient.b(new b() {
                protected void a(r rVar) throws RemoteException {
                    contents.close();
                    rVar.gp().a(new CloseContentsRequest(contents, true), new aw(this));
                }
            });
        }
        throw new IllegalArgumentException("Contents must be provided.");
    }

    public PendingResult<Status> commitAndCloseContents(GoogleApiClient apiClient, final Contents contents, final MetadataChangeSet changeSet) {
        if (contents != null) {
            return apiClient.b(new a() {
                protected void a(r rVar) throws RemoteException {
                    contents.close();
                    rVar.gp().a(new CloseContentsAndUpdateMetadataRequest(s.this.Hz, changeSet.gm(), contents, false, null), new aw(this));
                }
            });
        }
        throw new IllegalArgumentException("Contents must be provided.");
    }

    public PendingResult<Status> discardContents(GoogleApiClient apiClient, Contents contents) {
        return Drive.DriveApi.discardContents(apiClient, contents);
    }

    public PendingResult<ContentsResult> openContents(GoogleApiClient apiClient, final int mode, final DownloadProgressListener listener) {
        if (mode == DriveFile.MODE_READ_ONLY || mode == DriveFile.MODE_WRITE_ONLY || mode == DriveFile.MODE_READ_WRITE) {
            return apiClient.a(new d() {
                protected void a(r rVar) throws RemoteException {
                    rVar.gp().a(new OpenContentsRequest(s.this.getDriveId(), mode), new c(this, listener));
                }
            });
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }
}
