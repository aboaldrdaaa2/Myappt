package lip.com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;

public final class LeaderboardBuffer extends g<Leaderboard> {
    public LeaderboardBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected String eZ() {
        return "external_leaderboard_id";
    }

    /* renamed from: f */
    protected Leaderboard c(int i, int i2) {
        return new LeaderboardRef(this.DG, i, i2);
    }
}
