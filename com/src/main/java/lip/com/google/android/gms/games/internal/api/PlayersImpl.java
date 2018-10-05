package lip.com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpForGamesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class PlayersImpl implements Players {

    private static abstract class LoadOwnerCoverPhotoUrisImpl extends BaseGamesApiMethodImpl<LoadOwnerCoverPhotoUrisResult> {
        private LoadOwnerCoverPhotoUrisImpl() {
        }

        /* renamed from: O */
        public LoadOwnerCoverPhotoUrisResult c(final Status status) {
            return new LoadOwnerCoverPhotoUrisResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LoadPlayersImpl extends BaseGamesApiMethodImpl<LoadPlayersResult> {
        private LoadPlayersImpl() {
        }

        /* synthetic */ LoadPlayersImpl(AnonymousClass1 x0) {
            this();
        }

        /* renamed from: P */
        public LoadPlayersResult c(final Status status) {
            return new LoadPlayersResult() {
                public PlayerBuffer getPlayers() {
                    return new PlayerBuffer(DataHolder.af(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class LoadXpForGameCategoriesResultImpl extends BaseGamesApiMethodImpl<LoadXpForGameCategoriesResult> {
        private LoadXpForGameCategoriesResultImpl() {
        }

        /* renamed from: Q */
        public LoadXpForGameCategoriesResult c(final Status status) {
            return new LoadXpForGameCategoriesResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LoadXpForGameResultImpl extends BaseGamesApiMethodImpl<LoadXpForGamesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$LoadXpForGameResultImpl$1 */
        class AnonymousClass1 implements LoadXpForGamesResult {
            final /* synthetic */ Status yJ;

            public Status getStatus() {
                return this.yJ;
            }
        }

        private LoadXpForGameResultImpl() {
        }
    }

    private static abstract class LoadXpStreamResultImpl extends BaseGamesApiMethodImpl<LoadXpStreamResult> {
        private LoadXpStreamResultImpl() {
        }

        /* renamed from: R */
        public LoadXpStreamResult c(final Status status) {
            return new LoadXpStreamResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$10 */
    class AnonymousClass10 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.b((d) this, this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$11 */
    class AnonymousClass11 extends LoadPlayersImpl {
        final /* synthetic */ int Pv;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.b((d) this, this.Pv, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$12 */
    class AnonymousClass12 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.c((d) this, this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$13 */
    class AnonymousClass13 extends LoadPlayersImpl {
        final /* synthetic */ int Pv;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.c((d) this, this.Pv, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$14 */
    class AnonymousClass14 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.d(this, this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$15 */
    class AnonymousClass15 extends LoadPlayersImpl {
        final /* synthetic */ int Pv;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.d(this, this.Pv, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$16 */
    class AnonymousClass16 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;
        final /* synthetic */ String Px;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.f(this, this.Px, this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$17 */
    class AnonymousClass17 extends LoadPlayersImpl {
        final /* synthetic */ int Pv;
        final /* synthetic */ String Px;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.f(this, this.Px, this.Pv, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$18 */
    class AnonymousClass18 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Ph;
        final /* synthetic */ int Qe;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((d) this, this.Ph, this.Qe, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$19 */
    class AnonymousClass19 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.e(this, this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$20 */
    class AnonymousClass20 extends LoadPlayersImpl {
        final /* synthetic */ int Pv;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.e(this, this.Pv, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$21 */
    class AnonymousClass21 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;
        final /* synthetic */ String Qg;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.g(this, this.Qg, this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$22 */
    class AnonymousClass22 extends LoadPlayersImpl {
        final /* synthetic */ int Pv;
        final /* synthetic */ String Qg;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.g(this, this.Qg, this.Pv, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$23 */
    class AnonymousClass23 extends LoadOwnerCoverPhotoUrisImpl {
        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.g(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$24 */
    class AnonymousClass24 extends LoadXpForGameCategoriesResultImpl {
        final /* synthetic */ String Qh;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.n((d) this, this.Qh);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$25 */
    class AnonymousClass25 extends LoadXpStreamResultImpl {
        final /* synthetic */ String Qh;
        final /* synthetic */ int Qi;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.c((d) this, this.Qh, this.Qi);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$26 */
    class AnonymousClass26 extends LoadXpStreamResultImpl {
        final /* synthetic */ String Qh;
        final /* synthetic */ int Qi;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.d((d) this, this.Qh, this.Qi);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$2 */
    class AnonymousClass2 extends LoadPlayersImpl {
        final /* synthetic */ String[] Qf;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((d) this, this.Qf);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$7 */
    class AnonymousClass7 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Ph;
        final /* synthetic */ int Pv;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((d) this, "played_with", this.Ph, this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$8 */
    class AnonymousClass8 extends LoadPlayersImpl {
        final /* synthetic */ String Ph;
        final /* synthetic */ int Pv;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((d) this, "played_with", this.Ph, this.Pv, true, false);
        }
    }

    public Player getCurrentPlayer(GoogleApiClient apiClient) {
        return Games.c(apiClient).hb();
    }

    public String getCurrentPlayerId(GoogleApiClient apiClient) {
        return Games.c(apiClient).ha();
    }

    public Intent getPlayerSearchIntent(GoogleApiClient apiClient) {
        return Games.c(apiClient).hl();
    }

    public PendingResult<LoadPlayersResult> loadConnectedPlayers(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.a(new LoadPlayersImpl() {
            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((d) this, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadInvitablePlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.a(new LoadPlayersImpl() {
            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((d) this, pageSize, false, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.a(new LoadPlayersImpl() {
            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((d) this, pageSize, true, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.a(new LoadPlayersImpl() {
            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((d) this, "played_with", pageSize, true, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, final String playerId) {
        return apiClient.a(new LoadPlayersImpl() {
            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((d) this, playerId);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.a(new LoadPlayersImpl() {
            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((d) this, "played_with", pageSize, false, forceReload);
            }
        });
    }
}
