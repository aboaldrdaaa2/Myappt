package lip.com.google.android.gms.games.internal.api;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class NotificationsImpl implements Notifications {

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$1 */
    class AnonymousClass1 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String PV;

        /* renamed from: K */
        public GameMuteStatusChangeResult c(final Status status) {
            return new GameMuteStatusChangeResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.d((d) this, this.PV, true);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$2 */
    class AnonymousClass2 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String PV;

        /* renamed from: K */
        public GameMuteStatusChangeResult c(final Status status) {
            return new GameMuteStatusChangeResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.d((d) this, this.PV, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$3 */
    class AnonymousClass3 extends BaseGamesApiMethodImpl<GameMuteStatusLoadResult> {
        final /* synthetic */ String PV;

        /* renamed from: L */
        public GameMuteStatusLoadResult c(final Status status) {
            return new GameMuteStatusLoadResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.q(this, this.PV);
        }
    }

    private static abstract class ContactSettingLoadImpl extends BaseGamesApiMethodImpl<ContactSettingLoadResult> {
        private ContactSettingLoadImpl() {
        }

        /* renamed from: M */
        public ContactSettingLoadResult c(final Status status) {
            return new ContactSettingLoadResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class ContactSettingUpdateImpl extends BaseGamesApiMethodImpl<Status> {
        private ContactSettingUpdateImpl() {
        }

        /* renamed from: d */
        public Status c(Status status) {
            return status;
        }
    }

    private static abstract class InboxCountImpl extends BaseGamesApiMethodImpl<InboxCountResult> {
        private InboxCountImpl() {
        }

        /* renamed from: N */
        public InboxCountResult c(final Status status) {
            return new InboxCountResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$4 */
    class AnonymousClass4 extends ContactSettingLoadImpl {
        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.i(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$5 */
    class AnonymousClass5 extends ContactSettingLoadImpl {
        final /* synthetic */ boolean Pe;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.f((d) this, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$6 */
    class AnonymousClass6 extends ContactSettingUpdateImpl {
        final /* synthetic */ boolean PZ;
        final /* synthetic */ Bundle Qa;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((d) this, this.PZ, this.Qa);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$7 */
    class AnonymousClass7 extends InboxCountImpl {
        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.j(this);
        }
    }

    public void clear(GoogleApiClient apiClient, int notificationTypes) {
        Games.c(apiClient).ch(notificationTypes);
    }

    public void clearAll(GoogleApiClient apiClient) {
        clear(apiClient, 31);
    }
}
