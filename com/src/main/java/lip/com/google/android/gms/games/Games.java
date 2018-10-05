package lip.com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.api.AchievementsImpl;
import com.google.android.gms.games.internal.api.AclsImpl;
import com.google.android.gms.games.internal.api.EventsImpl;
import com.google.android.gms.games.internal.api.GamesMetadataImpl;
import com.google.android.gms.games.internal.api.InvitationsImpl;
import com.google.android.gms.games.internal.api.LeaderboardsImpl;
import com.google.android.gms.games.internal.api.MultiplayerImpl;
import com.google.android.gms.games.internal.api.NotificationsImpl;
import com.google.android.gms.games.internal.api.PlayersImpl;
import com.google.android.gms.games.internal.api.QuestsImpl;
import com.google.android.gms.games.internal.api.RealTimeMultiplayerImpl;
import com.google.android.gms.games.internal.api.RequestsImpl;
import com.google.android.gms.games.internal.api.SnapshotsImpl;
import com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hm;

public final class Games {
    public static final Api<GamesOptions> API = new Api(yI, yH, SCOPE_GAMES);
    public static final Achievements Achievements = new AchievementsImpl();
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final Events Events = new EventsImpl();
    public static final GamesMetadata GamesMetadata = new GamesMetadataImpl();
    public static final Invitations Invitations = new InvitationsImpl();
    public static final Leaderboards Leaderboards = new LeaderboardsImpl();
    public static final Scope MI = new Scope("https://www.googleapis.com/auth/games.firstparty");
    public static final Api<GamesOptions> MJ = new Api(yI, yH, MI);
    public static final Multiplayer MK = new MultiplayerImpl();
    public static final Acls ML = new AclsImpl();
    public static final Notifications Notifications = new NotificationsImpl();
    public static final Players Players = new PlayersImpl();
    public static final Quests Quests = new QuestsImpl();
    public static final RealTimeMultiplayer RealTimeMultiplayer = new RealTimeMultiplayerImpl();
    public static final Requests Requests = new RequestsImpl();
    public static final Scope SCOPE_GAMES = new Scope(Scopes.GAMES);
    public static final Snapshots Snapshots = new SnapshotsImpl();
    public static final TurnBasedMultiplayer TurnBasedMultiplayer = new TurnBasedMultiplayerImpl();
    static final c<GamesClientImpl> yH = new c();
    private static final b<GamesClientImpl, GamesOptions> yI = new b<GamesClientImpl, GamesOptions>() {
        public GamesClientImpl a(Context context, Looper looper, gy gyVar, GamesOptions gamesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (gamesOptions == null) {
                GamesOptions gamesOptions2 = new GamesOptions();
            }
            return new GamesClientImpl(context, looper, gyVar.fn(), gyVar.fj(), connectionCallbacks, onConnectionFailedListener, gyVar.fm(), gyVar.fk(), gyVar.fo(), gamesOptions.MM, gamesOptions.MN, gamesOptions.MO, gamesOptions.MP, gamesOptions.MQ, gamesOptions.MR);
        }

        public int getPriority() {
            return 1;
        }
    };

    public static abstract class BaseGamesApiMethodImpl<R extends Result> extends a.b<R, GamesClientImpl> {
        public BaseGamesApiMethodImpl() {
            super(Games.yH);
        }
    }

    public static final class GamesOptions implements Optional {
        final boolean MM;
        final boolean MN;
        final int MO;
        final boolean MP;
        final int MQ;
        final String MR;

        public static final class Builder {
            boolean MM;
            boolean MN;
            int MO;
            boolean MP;
            int MQ;
            String MR;

            private Builder() {
                this.MM = false;
                this.MN = true;
                this.MO = 17;
                this.MP = false;
                this.MQ = 4368;
                this.MR = null;
            }

            /* synthetic */ Builder(AnonymousClass1 x0) {
                this();
            }

            public GamesOptions build() {
                return new GamesOptions(this, null);
            }

            public Builder setSdkVariant(int variant) {
                this.MQ = variant;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup) {
                this.MN = showConnectingPopup;
                this.MO = 17;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup, int gravity) {
                this.MN = showConnectingPopup;
                this.MO = gravity;
                return this;
            }
        }

        private GamesOptions() {
            this.MM = false;
            this.MN = true;
            this.MO = 17;
            this.MP = false;
            this.MQ = 4368;
            this.MR = null;
        }

        private GamesOptions(Builder builder) {
            this.MM = builder.MM;
            this.MN = builder.MN;
            this.MO = builder.MO;
            this.MP = builder.MP;
            this.MQ = builder.MQ;
            this.MR = builder.MR;
        }

        /* synthetic */ GamesOptions(Builder x0, AnonymousClass1 x1) {
            this(x0);
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    private static abstract class SignOutImpl extends BaseGamesApiMethodImpl<Status> {
        private SignOutImpl() {
        }

        /* synthetic */ SignOutImpl(AnonymousClass1 x0) {
            this();
        }

        /* renamed from: d */
        public Status c(Status status) {
            return status;
        }
    }

    private Games() {
    }

    public static GamesClientImpl c(GoogleApiClient googleApiClient) {
        hm.b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        hm.a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        return d(googleApiClient);
    }

    public static GamesClientImpl d(GoogleApiClient googleApiClient) {
        GamesClientImpl gamesClientImpl = (GamesClientImpl) googleApiClient.a(yH);
        hm.a(gamesClientImpl != null, "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return gamesClientImpl;
    }

    public static String getAppId(GoogleApiClient apiClient) {
        return c(apiClient).ho();
    }

    public static String getCurrentAccountName(GoogleApiClient apiClient) {
        return c(apiClient).gZ();
    }

    public static int getSdkVariant(GoogleApiClient apiClient) {
        return c(apiClient).hn();
    }

    public static Intent getSettingsIntent(GoogleApiClient apiClient) {
        return c(apiClient).hm();
    }

    public static void setGravityForPopups(GoogleApiClient apiClient, int gravity) {
        c(apiClient).cg(gravity);
    }

    public static void setViewForPopups(GoogleApiClient apiClient, View gamesContentView) {
        hm.f(gamesContentView);
        c(apiClient).f(gamesContentView);
    }

    public static PendingResult<Status> signOut(GoogleApiClient apiClient) {
        return apiClient.b(new SignOutImpl() {
            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.b((d) this);
            }
        });
    }
}
