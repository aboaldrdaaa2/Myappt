package lip.com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class EventsImpl implements Events {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadEventsResult> {
        private LoadImpl() {
        }

        /* synthetic */ LoadImpl(AnonymousClass1 x0) {
            this();
        }

        /* renamed from: A */
        public LoadEventsResult c(final Status status) {
            return new LoadEventsResult() {
                public EventBuffer getEvents() {
                    return new EventBuffer(DataHolder.af(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl<Result> {
        private UpdateImpl() {
        }

        /* synthetic */ UpdateImpl(AnonymousClass1 x0) {
            this();
        }

        public Result c(final Status status) {
            return new Result() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public void increment(GoogleApiClient apiClient, final String eventId, final int incrementAmount) {
        GamesClientImpl d = Games.d(apiClient);
        if (d.isConnected()) {
            d.l(eventId, incrementAmount);
        } else {
            apiClient.b(new UpdateImpl() {
                public void a(GamesClientImpl gamesClientImpl) {
                    gamesClientImpl.l(eventId, incrementAmount);
                }
            });
        }
    }

    public PendingResult<LoadEventsResult> load(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.a(new LoadImpl() {
            public void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.d((d) this, forceReload);
            }
        });
    }

    public PendingResult<LoadEventsResult> loadByIds(GoogleApiClient apiClient, final boolean forceReload, final String... eventIds) {
        return apiClient.a(new LoadImpl() {
            public void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((d) this, forceReload, eventIds);
            }
        });
    }
}
