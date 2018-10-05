package lip.com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hk.a;
import com.google.android.gms.internal.hm;
import java.util.HashMap;

public final class ScoreSubmissionData {
    private static final String[] Sn = new String[]{"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    private int CT;
    private String MS;
    private HashMap<Integer, Result> ST = new HashMap();
    private String Sp;

    public static final class Result {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        public Result(long rawScore, String formattedScore, String scoreTag, boolean newBest) {
            this.rawScore = rawScore;
            this.formattedScore = formattedScore;
            this.scoreTag = scoreTag;
            this.newBest = newBest;
        }

        public String toString() {
            return hk.e(this).a("RawScore", Long.valueOf(this.rawScore)).a("FormattedScore", this.formattedScore).a("ScoreTag", this.scoreTag).a("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }

    public ScoreSubmissionData(DataHolder dataHolder) {
        this.CT = dataHolder.getStatusCode();
        int count = dataHolder.getCount();
        hm.C(count == 3);
        for (int i = 0; i < count; i++) {
            int ae = dataHolder.ae(i);
            if (i == 0) {
                this.Sp = dataHolder.c("leaderboardId", i, ae);
                this.MS = dataHolder.c("playerId", i, ae);
            }
            if (dataHolder.d("hasResult", i, ae)) {
                a(new Result(dataHolder.a("rawScore", i, ae), dataHolder.c("formattedScore", i, ae), dataHolder.c("scoreTag", i, ae), dataHolder.d("newBest", i, ae)), dataHolder.b("timeSpan", i, ae));
            }
        }
    }

    private void a(Result result, int i) {
        this.ST.put(Integer.valueOf(i), result);
    }

    public String getLeaderboardId() {
        return this.Sp;
    }

    public String getPlayerId() {
        return this.MS;
    }

    public Result getScoreResult(int timeSpan) {
        return (Result) this.ST.get(Integer.valueOf(timeSpan));
    }

    public String toString() {
        a a = hk.e(this).a("PlayerId", this.MS).a("StatusCode", Integer.valueOf(this.CT));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return a.toString();
            }
            Result result = (Result) this.ST.get(Integer.valueOf(i2));
            a.a("TimesSpan", TimeSpan.cm(i2));
            a.a("Result", result == null ? "null" : result.toString());
            i = i2 + 1;
        }
    }
}
