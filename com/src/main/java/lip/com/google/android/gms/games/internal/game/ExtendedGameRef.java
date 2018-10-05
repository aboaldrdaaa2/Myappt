package lip.com.google.android.gms.games.internal.game;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataRef;
import java.util.ArrayList;

public class ExtendedGameRef extends d implements ExtendedGame {
    private final GameRef RE;
    private final SnapshotMetadataRef RF;
    private final int RG;

    ExtendedGameRef(DataHolder holder, int dataRow, int numChildren) {
        super(holder, dataRow);
        this.RE = new GameRef(holder, dataRow);
        this.RG = numChildren;
        if (!av("external_snapshot_id") || ax("external_snapshot_id")) {
            this.RF = null;
        } else {
            this.RF = new SnapshotMetadataRef(holder, dataRow);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return ExtendedGameEntity.a(this, obj);
    }

    public Game getGame() {
        return this.RE;
    }

    public ArrayList<GameBadge> hQ() {
        int i = 0;
        if (this.DG.c("badge_title", this.EC, this.DG.ae(this.EC)) == null) {
            return new ArrayList(0);
        }
        ArrayList<GameBadge> arrayList = new ArrayList(this.RG);
        while (i < this.RG) {
            arrayList.add(new GameBadgeRef(this.DG, this.EC + i));
            i++;
        }
        return arrayList;
    }

    public int hR() {
        return getInteger("availability");
    }

    public boolean hS() {
        return getBoolean("owned");
    }

    public int hT() {
        return getInteger("achievement_unlocked_count");
    }

    public long hU() {
        return getLong("last_played_server_time");
    }

    public long hV() {
        return getLong("price_micros");
    }

    public String hW() {
        return getString("formatted_price");
    }

    public long hX() {
        return getLong("full_price_micros");
    }

    public String hY() {
        return getString("formatted_full_price");
    }

    public SnapshotMetadata hZ() {
        return this.RF;
    }

    public int hashCode() {
        return ExtendedGameEntity.a(this);
    }

    /* renamed from: ib */
    public ExtendedGame freeze() {
        return new ExtendedGameEntity(this);
    }

    public String toString() {
        return ExtendedGameEntity.b((ExtendedGame) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((ExtendedGameEntity) freeze()).writeToParcel(dest, flags);
    }
}
