package lip.com.google.android.gms.games.leaderboard;

import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.internal.hk;

public final class LeaderboardVariantEntity implements LeaderboardVariant {
    private final int SH;
    private final int SI;
    private final boolean SJ;
    private final long SK;
    private final String SL;
    private final long SM;
    private final String SN;
    private final String SO;
    private final long SP;
    private final String SQ;
    private final String SR;
    private final String SS;

    public LeaderboardVariantEntity(LeaderboardVariant variant) {
        this.SH = variant.getTimeSpan();
        this.SI = variant.getCollection();
        this.SJ = variant.hasPlayerInfo();
        this.SK = variant.getRawPlayerScore();
        this.SL = variant.getDisplayPlayerScore();
        this.SM = variant.getPlayerRank();
        this.SN = variant.getDisplayPlayerRank();
        this.SO = variant.getPlayerScoreTag();
        this.SP = variant.getNumScores();
        this.SQ = variant.iD();
        this.SR = variant.iE();
        this.SS = variant.iF();
    }

    static int a(LeaderboardVariant leaderboardVariant) {
        return hk.hashCode(Integer.valueOf(leaderboardVariant.getTimeSpan()), Integer.valueOf(leaderboardVariant.getCollection()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo()), Long.valueOf(leaderboardVariant.getRawPlayerScore()), leaderboardVariant.getDisplayPlayerScore(), Long.valueOf(leaderboardVariant.getPlayerRank()), leaderboardVariant.getDisplayPlayerRank(), Long.valueOf(leaderboardVariant.getNumScores()), leaderboardVariant.iD(), leaderboardVariant.iF(), leaderboardVariant.iE());
    }

    static boolean a(LeaderboardVariant leaderboardVariant, Object obj) {
        if (!(obj instanceof LeaderboardVariant)) {
            return false;
        }
        if (leaderboardVariant == obj) {
            return true;
        }
        LeaderboardVariant leaderboardVariant2 = (LeaderboardVariant) obj;
        return hk.equal(Integer.valueOf(leaderboardVariant2.getTimeSpan()), Integer.valueOf(leaderboardVariant.getTimeSpan())) && hk.equal(Integer.valueOf(leaderboardVariant2.getCollection()), Integer.valueOf(leaderboardVariant.getCollection())) && hk.equal(Boolean.valueOf(leaderboardVariant2.hasPlayerInfo()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo())) && hk.equal(Long.valueOf(leaderboardVariant2.getRawPlayerScore()), Long.valueOf(leaderboardVariant.getRawPlayerScore())) && hk.equal(leaderboardVariant2.getDisplayPlayerScore(), leaderboardVariant.getDisplayPlayerScore()) && hk.equal(Long.valueOf(leaderboardVariant2.getPlayerRank()), Long.valueOf(leaderboardVariant.getPlayerRank())) && hk.equal(leaderboardVariant2.getDisplayPlayerRank(), leaderboardVariant.getDisplayPlayerRank()) && hk.equal(Long.valueOf(leaderboardVariant2.getNumScores()), Long.valueOf(leaderboardVariant.getNumScores())) && hk.equal(leaderboardVariant2.iD(), leaderboardVariant.iD()) && hk.equal(leaderboardVariant2.iF(), leaderboardVariant.iF()) && hk.equal(leaderboardVariant2.iE(), leaderboardVariant.iE());
    }

    static String b(LeaderboardVariant leaderboardVariant) {
        return hk.e(leaderboardVariant).a("TimeSpan", TimeSpan.cm(leaderboardVariant.getTimeSpan())).a("Collection", LeaderboardCollection.cm(leaderboardVariant.getCollection())).a("RawPlayerScore", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getRawPlayerScore()) : "none").a("DisplayPlayerScore", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerScore() : "none").a("PlayerRank", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getPlayerRank()) : "none").a("DisplayPlayerRank", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerRank() : "none").a("NumScores", Long.valueOf(leaderboardVariant.getNumScores())).a("TopPageNextToken", leaderboardVariant.iD()).a("WindowPageNextToken", leaderboardVariant.iF()).a("WindowPagePrevToken", leaderboardVariant.iE()).toString();
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public int getCollection() {
        return this.SI;
    }

    public String getDisplayPlayerRank() {
        return this.SN;
    }

    public String getDisplayPlayerScore() {
        return this.SL;
    }

    public long getNumScores() {
        return this.SP;
    }

    public long getPlayerRank() {
        return this.SM;
    }

    public String getPlayerScoreTag() {
        return this.SO;
    }

    public long getRawPlayerScore() {
        return this.SK;
    }

    public int getTimeSpan() {
        return this.SH;
    }

    public boolean hasPlayerInfo() {
        return this.SJ;
    }

    public int hashCode() {
        return a(this);
    }

    public String iD() {
        return this.SQ;
    }

    public String iE() {
        return this.SR;
    }

    public String iF() {
        return this.SS;
    }

    /* renamed from: iG */
    public LeaderboardVariant freeze() {
        return this;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return b(this);
    }
}
