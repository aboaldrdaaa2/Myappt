package lip.com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardScoreBuffer extends DataBuffer<LeaderboardScore> {
    private final LeaderboardScoreBufferHeader St;

    public LeaderboardScoreBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.St = new LeaderboardScoreBufferHeader(dataHolder.eU());
    }

    public LeaderboardScore get(int position) {
        return new LeaderboardScoreRef(this.DG, position);
    }

    public LeaderboardScoreBufferHeader iA() {
        return this.St;
    }
}
