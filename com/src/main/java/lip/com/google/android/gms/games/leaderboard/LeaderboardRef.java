package lip.com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

public final class LeaderboardRef extends d implements Leaderboard {
    private final int RG;
    private final Game Ss;

    LeaderboardRef(DataHolder holder, int dataRow, int numChildren) {
        super(holder, dataRow);
        this.RG = numChildren;
        this.Ss = new GameRef(holder, dataRow);
    }

    public boolean equals(Object obj) {
        return LeaderboardEntity.a(this, obj);
    }

    public String getDisplayName() {
        return getString("name");
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        a("name", dataOut);
    }

    public Game getGame() {
        return this.Ss;
    }

    public Uri getIconImageUri() {
        return aw("board_icon_image_uri");
    }

    public String getIconImageUrl() {
        return getString("board_icon_image_url");
    }

    public String getLeaderboardId() {
        return getString("external_leaderboard_id");
    }

    public int getScoreOrder() {
        return getInteger("score_order");
    }

    public ArrayList<LeaderboardVariant> getVariants() {
        ArrayList<LeaderboardVariant> arrayList = new ArrayList(this.RG);
        for (int i = 0; i < this.RG; i++) {
            arrayList.add(new LeaderboardVariantRef(this.DG, this.EC + i));
        }
        return arrayList;
    }

    public int hashCode() {
        return LeaderboardEntity.a(this);
    }

    /* renamed from: iz */
    public Leaderboard freeze() {
        return new LeaderboardEntity(this);
    }

    public String toString() {
        return LeaderboardEntity.b(this);
    }
}
