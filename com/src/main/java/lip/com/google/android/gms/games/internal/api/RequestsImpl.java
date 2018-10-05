package lip.com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class RequestsImpl implements Requests {

    private static abstract class LoadRequestSummariesImpl extends BaseGamesApiMethodImpl<LoadRequestSummariesResult> {
        private LoadRequestSummariesImpl() {
        }

        /* renamed from: V */
        public LoadRequestSummariesResult c(final Status status) {
            return new LoadRequestSummariesResult() {
                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class LoadRequestsImpl extends BaseGamesApiMethodImpl<LoadRequestsResult> {
        private LoadRequestsImpl() {
        }

        /* synthetic */ LoadRequestsImpl(AnonymousClass1 x0) {
            this();
        }

        /* renamed from: W */
        public LoadRequestsResult c(final Status status) {
            return new LoadRequestsResult() {
                public GameRequestBuffer getRequests(int type) {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class SendRequestImpl extends BaseGamesApiMethodImpl<SendRequestResult> {
        private SendRequestImpl() {
        }

        /* renamed from: X */
        public SendRequestResult c(final Status status) {
            return new SendRequestResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class UpdateRequestsImpl extends BaseGamesApiMethodImpl<UpdateRequestsResult> {
        private UpdateRequestsImpl() {
        }

        /* synthetic */ UpdateRequestsImpl(AnonymousClass1 x0) {
            this();
        }

        /* renamed from: Y */
        public UpdateRequestsResult c(final Status status) {
            return new UpdateRequestsResult() {
                public Set<String> getRequestIds() {
                    return null;
                }

                public int getRequestOutcome(String requestId) {
                    throw new IllegalArgumentException("Unknown request ID " + requestId);
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$4 */
    class AnonymousClass4 extends SendRequestImpl {
        final /* synthetic */ String Ph;
        final /* synthetic */ String[] QA;
        final /* synthetic */ int QB;
        final /* synthetic */ byte[] QC;
        final /* synthetic */ int QD;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((d) this, this.Ph, this.QA, this.QB, this.QC, this.QD);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$5 */
    class AnonymousClass5 extends SendRequestImpl {
        final /* synthetic */ String Ph;
        final /* synthetic */ String[] QA;
        final /* synthetic */ int QB;
        final /* synthetic */ byte[] QC;
        final /* synthetic */ int QD;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((d) this, this.Ph, this.QA, this.QB, this.QC, this.QD);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$6 */
    class AnonymousClass6 extends UpdateRequestsImpl {
        final /* synthetic */ String Ph;
        final /* synthetic */ String Qs;
        final /* synthetic */ String[] Qw;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((d) this, this.Ph, this.Qs, this.Qw);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$7 */
    class AnonymousClass7 extends LoadRequestsImpl {
        final /* synthetic */ int PE;
        final /* synthetic */ String Ph;
        final /* synthetic */ String Qs;
        final /* synthetic */ int Qy;
        final /* synthetic */ int Qz;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((d) this, this.Ph, this.Qs, this.Qy, this.Qz, this.PE);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$8 */
    class AnonymousClass8 extends LoadRequestSummariesImpl {
        final /* synthetic */ String Qs;
        final /* synthetic */ int Qz;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.f(this, this.Qs, this.Qz);
        }
    }

    public PendingResult<UpdateRequestsResult> acceptRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return acceptRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> acceptRequests(GoogleApiClient apiClient, List<String> requestIds) {
        final String[] strArr = requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()]);
        return apiClient.b(new UpdateRequestsImpl() {
            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.b((d) this, strArr);
            }
        });
    }

    public PendingResult<UpdateRequestsResult> dismissRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return dismissRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> dismissRequests(GoogleApiClient apiClient, List<String> requestIds) {
        final String[] strArr = requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()]);
        return apiClient.b(new UpdateRequestsImpl() {
            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.c((d) this, strArr);
            }
        });
    }

    public ArrayList<GameRequest> getGameRequestsFromBundle(Bundle extras) {
        if (extras == null || !extras.containsKey(Requests.EXTRA_REQUESTS)) {
            return new ArrayList();
        }
        ArrayList arrayList = (ArrayList) extras.get(Requests.EXTRA_REQUESTS);
        ArrayList<GameRequest> arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add((GameRequest) arrayList.get(i));
        }
        return arrayList2;
    }

    public ArrayList<GameRequest> getGameRequestsFromInboxResponse(Intent response) {
        return response == null ? new ArrayList() : getGameRequestsFromBundle(response.getExtras());
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.c(apiClient).hq();
    }

    public int getMaxLifetimeDays(GoogleApiClient apiClient) {
        return Games.c(apiClient).hs();
    }

    public int getMaxPayloadSize(GoogleApiClient apiClient) {
        return Games.c(apiClient).hr();
    }

    public Intent getSendIntent(GoogleApiClient apiClient, int type, byte[] payload, int requestLifetimeDays, Bitmap icon, String description) {
        return Games.c(apiClient).a(type, payload, requestLifetimeDays, icon, description);
    }

    public PendingResult<LoadRequestsResult> loadRequests(GoogleApiClient apiClient, final int requestDirection, final int types, final int sortOrder) {
        return apiClient.a(new LoadRequestsImpl() {
            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((d) this, requestDirection, types, sortOrder);
            }
        });
    }

    public void registerRequestListener(GoogleApiClient apiClient, OnRequestReceivedListener listener) {
        Games.c(apiClient).a(listener);
    }

    public void unregisterRequestListener(GoogleApiClient apiClient) {
        Games.c(apiClient).hk();
    }
}
