package lip.com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class LeaderboardVariantRef extends d implements LeaderboardVariant {
    LeaderboardVariantRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public boolean equals(Object obj) {
        return LeaderboardVariantEntity.a(this, obj);
    }

    public int getCollection() {
        return getInteger("collection");
    }

    public String getDisplayPlayerRank() {
        return getString("player_display_rank");
    }

    public String getDisplayPlayerScore() {
        return getString("player_display_score");
    }

    public long getNumScores() {
        return ax("total_scores") ? -1 : getLong("total_scores");
    }

    public long getPlayerRank() {
        return ax("player_rank") ? -1 : getLong("player_rank");
    }

    public String getPlayerScoreTag() {
        return getString("player_score_tag");
    }

    public long getRawPlayerScore() {
        return ax("player_raw_score") ? -1 : getLong("player_raw_score");
    }

    public int getTimeSpan() {
        return getInteger("timespan");
    }

    public boolean hasPlayerInfo() {
        return !ax("player_raw_score");
    }

    public int hashCode() {
        return LeaderboardVariantEntity.a(this);
    }

    public String iD() {
        return getString("top_page_token_next");
    }

    public String iE() {
        return getString("window_page_token_prev");
    }

    public String iF() {
        return getString("window_page_token_next");
    }

    /* renamed from: iG */
    public LeaderboardVariant freeze() {
        return new LeaderboardVariantEntity(this);
    }

    public String toString() {
        return LeaderboardVariantEntity.b(this);
    }
}
