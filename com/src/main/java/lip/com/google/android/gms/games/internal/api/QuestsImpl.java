package lip.com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;

public final class QuestsImpl implements Quests {

    private static abstract class AcceptImpl extends BaseGamesApiMethodImpl<AcceptQuestResult> {
        private AcceptImpl() {
        }

        /* synthetic */ AcceptImpl(AnonymousClass1 x0) {
            this();
        }

        /* renamed from: S */
        public AcceptQuestResult c(final Status status) {
            return new AcceptQuestResult() {
                public Quest getQuest() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class ClaimImpl extends BaseGamesApiMethodImpl<ClaimMilestoneResult> {
        private ClaimImpl() {
        }

        /* synthetic */ ClaimImpl(AnonymousClass1 x0) {
            this();
        }

        /* renamed from: T */
        public ClaimMilestoneResult c(final Status status) {
            return new ClaimMilestoneResult() {
                public Milestone getMilestone() {
                    return null;
                }

                public Quest getQuest() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadQuestsResult> {
        private LoadsImpl() {
        }

        /* synthetic */ LoadsImpl(AnonymousClass1 x0) {
            this();
        }

        /* renamed from: U */
        public LoadQuestsResult c(final Status status) {
            return new LoadQuestsResult() {
                public QuestBuffer getQuests() {
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

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl$5 */
    class AnonymousClass5 extends LoadsImpl {
        final /* synthetic */ int PE;
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Ph;
        final /* synthetic */ int[] Qq;
        final /* synthetic */ String Qs;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((d) this, this.Ph, this.Qs, this.Qq, this.PE, this.Pe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl$6 */
    class AnonymousClass6 extends LoadsImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Ph;
        final /* synthetic */ String[] Qr;
        final /* synthetic */ String Qs;

        protected void a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.a((d) this, this.Ph, this.Qs, this.Pe, this.Qr);
        }
    }

    public PendingResult<AcceptQuestResult> accept(GoogleApiClient apiClient, final String questId) {
        return apiClient.b(new AcceptImpl() {
            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.i(this, questId);
            }
        });
    }

    public PendingResult<ClaimMilestoneResult> claim(GoogleApiClient apiClient, final String questId, final String milestoneId) {
        return apiClient.b(new ClaimImpl() {
            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.b((d) this, questId, milestoneId);
            }
        });
    }

    public Intent getQuestIntent(GoogleApiClient apiClient, String questId) {
        return Games.c(apiClient).aU(questId);
    }

    public Intent getQuestsIntent(GoogleApiClient apiClient, int[] questSelectors) {
        return Games.c(apiClient).a(questSelectors);
    }

    public PendingResult<LoadQuestsResult> load(GoogleApiClient apiClient, final int[] questSelectors, final int sortOrder, final boolean forceReload) {
        return apiClient.a(new LoadsImpl() {
            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.a((d) this, questSelectors, sortOrder, forceReload);
            }
        });
    }

    public PendingResult<LoadQuestsResult> loadByIds(GoogleApiClient apiClient, final boolean forceReload, final String... questIds) {
        return apiClient.a(new LoadsImpl() {
            protected void a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.b((d) this, forceReload, questIds);
            }
        });
    }

    public void registerQuestUpdateListener(GoogleApiClient apiClient, QuestUpdateListener listener) {
        Games.c(apiClient).a(listener);
    }

    public void unregisterQuestUpdateListener(GoogleApiClient apiClient) {
        Games.c(apiClient).hj();
    }
}
