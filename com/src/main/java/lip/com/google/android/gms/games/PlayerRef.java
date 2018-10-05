package lip.com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class PlayerRef extends d implements Player {
    private final PlayerLevelInfo MX;
    private final PlayerColumnNames Ng;
    private final MostRecentGameInfoRef Nh;

    public PlayerRef(DataHolder holder, int dataRow) {
        this(holder, dataRow, null);
    }

    public PlayerRef(DataHolder holder, int dataRow, String prefix) {
        super(holder, dataRow);
        this.Ng = new PlayerColumnNames(prefix);
        this.Nh = new MostRecentGameInfoRef(holder, dataRow, this.Ng);
        if (gV()) {
            PlayerLevel playerLevel;
            int integer = getInteger(this.Ng.RY);
            int integer2 = getInteger(this.Ng.Sb);
            PlayerLevel playerLevel2 = new PlayerLevel(integer, getLong(this.Ng.RZ), getLong(this.Ng.Sa));
            if (integer != integer2) {
                playerLevel = new PlayerLevel(integer2, getLong(this.Ng.Sa), getLong(this.Ng.Sc));
            } else {
                playerLevel = playerLevel2;
            }
            this.MX = new PlayerLevelInfo(getLong(this.Ng.RX), getLong(this.Ng.Sd), playerLevel2, playerLevel);
            return;
        }
        this.MX = null;
    }

    private boolean gV() {
        return (ax(this.Ng.RX) || getLong(this.Ng.RX) == -1) ? false : true;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return PlayerEntity.a(this, obj);
    }

    public Player freeze() {
        return new PlayerEntity(this);
    }

    public int gS() {
        return getInteger(this.Ng.RV);
    }

    public boolean gT() {
        return getBoolean(this.Ng.Sf);
    }

    public MostRecentGameInfo gU() {
        return ax(this.Ng.Sg) ? null : this.Nh;
    }

    public String getDisplayName() {
        return getString(this.Ng.RP);
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        a(this.Ng.RP, dataOut);
    }

    public Uri getHiResImageUri() {
        return aw(this.Ng.RS);
    }

    public String getHiResImageUrl() {
        return getString(this.Ng.RT);
    }

    public Uri getIconImageUri() {
        return aw(this.Ng.RQ);
    }

    public String getIconImageUrl() {
        return getString(this.Ng.RR);
    }

    public long getLastPlayedWithTimestamp() {
        return (!av(this.Ng.RW) || ax(this.Ng.RW)) ? -1 : getLong(this.Ng.RW);
    }

    public PlayerLevelInfo getLevelInfo() {
        return this.MX;
    }

    public String getPlayerId() {
        return getString(this.Ng.RO);
    }

    public long getRetrievedTimestamp() {
        return getLong(this.Ng.RU);
    }

    public String getTitle() {
        return getString(this.Ng.Se);
    }

    public void getTitle(CharArrayBuffer dataOut) {
        a(this.Ng.Se, dataOut);
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return PlayerEntity.a(this);
    }

    public String toString() {
        return PlayerEntity.b((Player) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((PlayerEntity) freeze()).writeToParcel(dest, flags);
    }
}
