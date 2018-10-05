package lip.com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesMetadata.LoadExtendedGamesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class GamesMetadataImpl implements GamesMetadata {

    private static abstract class LoadExtendedGamesImpl extends BaseGamesApiMethodImpl<LoadExtendedGamesResult> {
        private LoadExtendedGamesImpl() {
        }

        /* renamed from: B */
        public LoadExtendedGamesResult c(final Status status) {
            return new LoadExtendedGamesResult() {
                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class LoadGameInstancesImpl extends BaseGamesApiMethodImpl<LoadGameInstancesResult> {
        private LoadGameInstancesImpl() {
        }

        /* renamed from: C */
        public LoadGameInstancesResult c(final Status status) {
            return new LoadGameInstancesResult() {
                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class LoadGameSearchSuggestionsImpl extends BaseGamesApiMethodImpl<LoadGameSearchSuggestionsResult> {
        private LoadGameSearchSuggestionsImpl() {
        }

        /* renamed from: D */
        public LoadGameSearchSuggestionsResult c(final Status status) {
            return new LoadGameSearchSuggestionsResult() {
                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class LoadGamesImpl extends BaseGamesApiMethodImpl<LoadGamesResult> {
        private LoadGamesImpl() {
        }

        /* synthetic */ LoadGamesImpl(AnonymousClass1 x0) {
            this();
        }

        /* renamed from: E */
        public LoadGamesResult c(final Status status) {
            return new LoadGamesResult() {
                public GameBuffer getGames() {
                    return new GameBuffer(DataHolder.af(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$10 */
    class AnonymousClass10 extends LoadExtendedGamesImpl {
        final /* synthetic */ String Pu;
        final /* synthetic */ int Pv;
        final /* synthetic */ boolean Pw;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((d) this, this.Pu, this.Pv, false, true, false, this.Pw);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$11 */
    class AnonymousClass11 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Pg;
        final /* synthetic */ int Pv;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.c(this, this.Pg, this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$12 */
    class AnonymousClass12 extends LoadExtendedGamesImpl {
        final /* synthetic */ String Pg;
        final /* synthetic */ int Pv;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.c(this, this.Pg, this.Pv, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$13 */
    class AnonymousClass13 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Pg;
        final /* synthetic */ int Pv;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.d(this, this.Pg, this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$14 */
    class AnonymousClass14 extends LoadExtendedGamesImpl {
        final /* synthetic */ String Pg;
        final /* synthetic */ int Pv;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.d(this, this.Pg, this.Pv, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$15 */
    class AnonymousClass15 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Pu;
        final /* synthetic */ int Pv;
        final /* synthetic */ boolean Pw;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((d) this, this.Pu, this.Pv, true, false, this.Pe, this.Pw);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$16 */
    class AnonymousClass16 extends LoadExtendedGamesImpl {
        final /* synthetic */ String Pu;
        final /* synthetic */ int Pv;
        final /* synthetic */ boolean Pw;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((d) this, this.Pu, this.Pv, true, true, false, this.Pw);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$17 */
    class AnonymousClass17 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;
        final /* synthetic */ String Px;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.e(this, this.Px, this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$18 */
    class AnonymousClass18 extends LoadExtendedGamesImpl {
        final /* synthetic */ int Pv;
        final /* synthetic */ String Px;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.e(this, this.Px, this.Pv, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$19 */
    class AnonymousClass19 extends LoadGameSearchSuggestionsImpl {
        final /* synthetic */ String Px;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m((d) this, this.Px);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$2 */
    class AnonymousClass2 extends LoadExtendedGamesImpl {
        final /* synthetic */ String Ph;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.k(this, this.Ph);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$3 */
    class AnonymousClass3 extends LoadGameInstancesImpl {
        final /* synthetic */ String Ph;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.l((d) this, this.Ph);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$4 */
    class AnonymousClass4 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.b(this, null, this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$5 */
    class AnonymousClass5 extends LoadExtendedGamesImpl {
        final /* synthetic */ int Pv;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.b(this, null, this.Pv, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$6 */
    class AnonymousClass6 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Pg;
        final /* synthetic */ int Pv;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.b(this, this.Pg, this.Pv, false, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$7 */
    class AnonymousClass7 extends LoadExtendedGamesImpl {
        final /* synthetic */ String Pg;
        final /* synthetic */ int Pv;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.b(this, this.Pg, this.Pv, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$8 */
    class AnonymousClass8 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;
        final /* synthetic */ int Py;
        final /* synthetic */ boolean Pz;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((d) this, this.Pv, this.Py, this.Pz, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$9 */
    class AnonymousClass9 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Pu;
        final /* synthetic */ int Pv;
        final /* synthetic */ boolean Pw;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((d) this, this.Pu, this.Pv, false, false, this.Pe, this.Pw);
        }
    }

    public Game getCurrentGame(GoogleApiClient apiClient) {
        return Games.c(apiClient).hc();
    }

    public PendingResult<LoadGamesResult> loadGame(GoogleApiClient apiClient) {
        return apiClient.a(new LoadGamesImpl() {
            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.f((d) this);
            }
        });
    }
}
