package lip.com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.IOException;
import java.io.InputStream;

public final class f implements DataApi {

    public static class a implements DataItemResult {
        private final DataItem alH;
        private final Status yz;

        public a(Status status, DataItem dataItem) {
            this.yz = status;
            this.alH = dataItem;
        }

        public DataItem getDataItem() {
            return this.alH;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    public static class b implements DeleteDataItemsResult {
        private final int alI;
        private final Status yz;

        public b(Status status, int i) {
            this.yz = status;
            this.alI = i;
        }

        public int getNumDeleted() {
            return this.alI;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    public static class c implements GetFdForAssetResult {
        private final ParcelFileDescriptor alJ;
        private final Status yz;

        public c(Status status, ParcelFileDescriptor parcelFileDescriptor) {
            this.yz = status;
            this.alJ = parcelFileDescriptor;
        }

        public ParcelFileDescriptor getFd() {
            return this.alJ;
        }

        public InputStream getInputStream() {
            return new AutoCloseInputStream(this.alJ);
        }

        public Status getStatus() {
            return this.yz;
        }

        public void release() {
            try {
                this.alJ.close();
            } catch (IOException e) {
            }
        }
    }

    private PendingResult<Status> a(GoogleApiClient googleApiClient, final DataListener dataListener, final IntentFilter[] intentFilterArr) {
        return googleApiClient.a(new d<Status>() {
            protected void a(au auVar) throws RemoteException {
                auVar.a((d) this, dataListener, intentFilterArr);
            }

            /* renamed from: d */
            public Status c(Status status) {
                return new Status(13);
            }
        });
    }

    private void a(Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("asset is null");
        } else if (asset.getDigest() == null) {
            throw new IllegalArgumentException("invalid asset");
        } else if (asset.getData() != null) {
            throw new IllegalArgumentException("invalid asset");
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient client, DataListener listener) {
        return a(client, listener, null);
    }

    public PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient client, final Uri uri) {
        return client.a(new d<DeleteDataItemsResult>() {
            protected void a(au auVar) throws RemoteException {
                auVar.c(this, uri);
            }

            /* renamed from: as */
            protected DeleteDataItemsResult c(Status status) {
                return new b(status, 0);
            }
        });
    }

    public PendingResult<DataItemResult> getDataItem(GoogleApiClient client, final Uri uri) {
        return client.a(new d<DataItemResult>() {
            protected void a(au auVar) throws RemoteException {
                auVar.a((d) this, uri);
            }

            /* renamed from: aq */
            protected DataItemResult c(Status status) {
                return new a(status, null);
            }
        });
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client) {
        return client.a(new d<DataItemBuffer>() {
            protected void a(au auVar) throws RemoteException {
                auVar.o(this);
            }

            /* renamed from: ar */
            protected DataItemBuffer c(Status status) {
                return new DataItemBuffer(DataHolder.af(status.getStatusCode()));
            }
        });
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client, final Uri uri) {
        return client.a(new d<DataItemBuffer>() {
            protected void a(au auVar) throws RemoteException {
                auVar.b((d) this, uri);
            }

            /* renamed from: ar */
            protected DataItemBuffer c(Status status) {
                return new DataItemBuffer(DataHolder.af(status.getStatusCode()));
            }
        });
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient client, final Asset asset) {
        a(asset);
        return client.a(new d<GetFdForAssetResult>() {
            protected void a(au auVar) throws RemoteException {
                auVar.a((d) this, asset);
            }

            /* renamed from: at */
            protected GetFdForAssetResult c(Status status) {
                return new c(status, null);
            }
        });
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient client, final DataItemAsset asset) {
        return client.a(new d<GetFdForAssetResult>() {
            protected void a(au auVar) throws RemoteException {
                auVar.a((d) this, asset);
            }

            /* renamed from: at */
            protected GetFdForAssetResult c(Status status) {
                return new c(status, null);
            }
        });
    }

    public PendingResult<DataItemResult> putDataItem(GoogleApiClient client, final PutDataRequest request) {
        return client.a(new d<DataItemResult>() {
            protected void a(au auVar) throws RemoteException {
                auVar.a((d) this, request);
            }

            /* renamed from: aq */
            public DataItemResult c(Status status) {
                return new a(status, null);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final DataListener listener) {
        return client.a(new d<Status>() {
            protected void a(au auVar) throws RemoteException {
                auVar.a((d) this, listener);
            }

            /* renamed from: d */
            public Status c(Status status) {
                return new Status(13);
            }
        });
    }
}
