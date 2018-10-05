package lip.com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hm;

public final class PlayerLevelInfo implements SafeParcelable {
    public static final PlayerLevelInfoCreator CREATOR = new PlayerLevelInfoCreator();
    private final long Nc;
    private final long Nd;
    private final PlayerLevel Ne;
    private final PlayerLevel Nf;
    private final int xM;

    PlayerLevelInfo(int versionCode, long currentXpTotal, long lastLevelUpTimestamp, PlayerLevel currentLevel, PlayerLevel nextLevel) {
        hm.A(currentXpTotal != -1);
        hm.f(currentLevel);
        hm.f(nextLevel);
        this.xM = versionCode;
        this.Nc = currentXpTotal;
        this.Nd = lastLevelUpTimestamp;
        this.Ne = currentLevel;
        this.Nf = nextLevel;
    }

    public PlayerLevelInfo(long currentXpTotal, long lastLevelUpTimestamp, PlayerLevel currentLevel, PlayerLevel nextLevel) {
        this(1, currentXpTotal, lastLevelUpTimestamp, currentLevel, nextLevel);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevelInfo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        PlayerLevelInfo playerLevelInfo = (PlayerLevelInfo) obj;
        return hk.equal(Long.valueOf(this.Nc), Long.valueOf(playerLevelInfo.Nc)) && hk.equal(Long.valueOf(this.Nd), Long.valueOf(playerLevelInfo.Nd)) && hk.equal(this.Ne, playerLevelInfo.Ne) && hk.equal(this.Nf, playerLevelInfo.Nf);
    }

    public PlayerLevel getCurrentLevel() {
        return this.Ne;
    }

    public long getCurrentXpTotal() {
        return this.Nc;
    }

    public long getLastLevelUpTimestamp() {
        return this.Nd;
    }

    public PlayerLevel getNextLevel() {
        return this.Nf;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return hk.hashCode(Long.valueOf(this.Nc), Long.valueOf(this.Nd), this.Ne, this.Nf);
    }

    public boolean isMaxLevel() {
        return this.Ne.equals(this.Nf);
    }

    public void writeToParcel(Parcel out, int flags) {
        PlayerLevelInfoCreator.a(this, out, flags);
    }
}
