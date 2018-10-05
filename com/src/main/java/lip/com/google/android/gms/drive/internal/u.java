package lip.com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveFolder.DriveFileResult;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.Query.Builder;
import com.google.android.gms.drive.query.SearchableField;

public class u extends v implements DriveFolder {

    private static class d implements DriveFileResult {
        private final DriveFile Jj;
        private final Status yz;

        public d(Status status, DriveFile driveFile) {
            this.yz = status;
            this.Jj = driveFile;
        }

        public DriveFile getDriveFile() {
            return this.Jj;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static class e implements DriveFolderResult {
        private final DriveFolder Jk;
        private final Status yz;

        public e(Status status, DriveFolder driveFolder) {
            this.yz = status;
            this.Jk = driveFolder;
        }

        public DriveFolder getDriveFolder() {
            return this.Jk;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static class a extends c {
        private final com.google.android.gms.common.api.a.d<DriveFileResult> yR;

        public a(com.google.android.gms.common.api.a.d<DriveFileResult> dVar) {
            this.yR = dVar;
        }

        public void a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.yR.a(new d(Status.En, new s(onDriveIdResponse.getDriveId())));
        }

        public void o(Status status) throws RemoteException {
            this.yR.a(new d(status, null));
        }
    }

    private static class b extends c {
        private final com.google.android.gms.common.api.a.d<DriveFolderResult> yR;

        public b(com.google.android.gms.common.api.a.d<DriveFolderResult> dVar) {
            this.yR = dVar;
        }

        public void a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.yR.a(new e(Status.En, new u(onDriveIdResponse.getDriveId())));
        }

        public void o(Status status) throws RemoteException {
            this.yR.a(new e(status, null));
        }
    }

    private abstract class c extends q<DriveFolderResult> {
        private c() {
        }

        /* synthetic */ c(u uVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: t */
        public DriveFolderResult c(Status status) {
            return new e(status, null);
        }
    }

    public u(DriveId driveId) {
        super(driveId);
    }

    private PendingResult<DriveFileResult> a(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, Contents contents, int i, boolean z, String str) {
        final Contents contents2 = contents;
        final MetadataChangeSet metadataChangeSet2 = metadataChangeSet;
        final int i2 = i;
        final boolean z2 = z;
        final String str2 = str;
        return googleApiClient.b(new q<DriveFileResult>() {
            protected void a(r rVar) throws RemoteException {
                if (contents2 != null) {
                    contents2.close();
                }
                rVar.gp().a(new CreateFileRequest(u.this.getDriveId(), metadataChangeSet2.gm(), contents2, i2, z2, str2), new a(this));
            }

            /* renamed from: s */
            public DriveFileResult c(Status status) {
                return new d(status, null);
            }
        });
    }

    private PendingResult<DriveFileResult> a(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, Contents contents, boolean z, String str) {
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (contents == null) {
            throw new IllegalArgumentException("Contents must be provided.");
        } else if (!DriveFolder.MIME_TYPE.equals(metadataChangeSet.getMimeType())) {
            return a(googleApiClient, metadataChangeSet, contents, 0, z, str);
        } else {
            throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
        }
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient apiClient, MetadataChangeSet changeSet, Contents contents) {
        return a(apiClient, changeSet, contents, false, null);
    }

    public PendingResult<DriveFolderResult> createFolder(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (changeSet.getMimeType() == null || changeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            return apiClient.b(new c() {
                protected void a(r rVar) throws RemoteException {
                    rVar.gp().a(new CreateFolderRequest(u.this.getDriveId(), changeSet.gm()), new b(this));
                }
            });
        } else {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        }
    }

    public PendingResult<MetadataBufferResult> listChildren(GoogleApiClient apiClient) {
        return queryChildren(apiClient, null);
    }

    public PendingResult<MetadataBufferResult> queryChildren(GoogleApiClient apiClient, Query query) {
        Builder addFilter = new Builder().addFilter(Filters.in(SearchableField.PARENTS, getDriveId()));
        if (query != null) {
            if (query.getFilter() != null) {
                addFilter.addFilter(query.getFilter());
            }
            addFilter.setPageToken(query.getPageToken());
            addFilter.setSortOrder(query.getSortOrder());
        }
        return new p().query(apiClient, addFilter.build());
    }
}
