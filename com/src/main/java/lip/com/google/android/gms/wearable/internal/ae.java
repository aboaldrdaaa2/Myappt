package lip.com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

public final class ae implements MessageApi {

    public static class a implements SendMessageResult {
        private final int ra;
        private final Status yz;

        public a(Status status, int i) {
            this.yz = status;
            this.ra = i;
        }

        public int getRequestId() {
            return this.ra;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private PendingResult<Status> a(GoogleApiClient googleApiClient, final MessageListener messageListener, final IntentFilter[] intentFilterArr) {
        return googleApiClient.a(new d<Status>() {
            protected void a(au auVar) throws RemoteException {
                auVar.a((d) this, messageListener, intentFilterArr);
            }

            /* renamed from: d */
            public Status c(Status status) {
                return new Status(13);
            }
        });
    }

    public PendingResult<Status> addListener(GoogleApiClient client, MessageListener listener) {
        return a(client, listener, null);
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final MessageListener listener) {
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

    public PendingResult<SendMessageResult> sendMessage(GoogleApiClient client, final String nodeId, final String action, final byte[] data) {
        return client.a(new d<SendMessageResult>() {
            protected void a(au auVar) throws RemoteException {
                auVar.a(this, nodeId, action, data);
            }

            /* renamed from: au */
            protected SendMessageResult c(Status status) {
                return new a(status, -1);
            }
        });
    }
}
