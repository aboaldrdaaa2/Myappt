package lip.com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class LeaderboardScoreRef extends d implements LeaderboardScore {
    private final PlayerRef SG;

    LeaderboardScoreRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
        this.SG = new PlayerRef(holder, dataRow);
    }

    public boolean equals(Object obj) {
        return LeaderboardScoreEntity.a(this, obj);
    }

    public String getDisplayRank() {
        return getString("display_rank");
    }

    public void getDisplayRank(CharArrayBuffer dataOut) {
        a("display_rank", dataOut);
    }

    public String getDisplayScore() {
        return getString("display_score");
    }

    public void getDisplayScore(CharArrayBuffer dataOut) {
        a("display_score", dataOut);
    }

    public long getRank() {
        return getLong("rank");
    }

    public long getRawScore() {
        return getLong("raw_score");
    }

    public Player getScoreHolder() {
        return ax("external_player_id") ? null : this.SG;
    }

    public String getScoreHolderDisplayName() {
        return ax("external_player_id") ? getString("default_display_name") : this.SG.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer dataOut) {
        if (ax("external_player_id")) {
            a("default_display_name", dataOut);
        } else {
            this.SG.getDisplayName(dataOut);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        return ax("external_player_id") ? null : this.SG.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        return ax("external_player_id") ? null : this.SG.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        return ax("external_player_id") ? aw("default_display_image_uri") : this.SG.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        return ax("external_player_id") ? getString("default_display_image_url") : this.SG.getIconImageUrl();
    }

    public String getScoreTag() {
        return getString("score_tag");
    }

    public long getTimestampMillis() {
        return getLong("achieved_timestamp");
    }

    public int hashCode() {
        return LeaderboardScoreEntity.a(this);
    }

    /* renamed from: iC */
    public LeaderboardScore freeze() {
        return new LeaderboardScoreEntity(this);
    }

    public String toString() {
        return LeaderboardScoreEntity.b(this);
    }
}
