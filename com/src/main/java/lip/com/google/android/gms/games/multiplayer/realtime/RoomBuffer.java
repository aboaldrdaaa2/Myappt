package lip.com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;

public final class RoomBuffer extends g<Room> {
    public RoomBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected String eZ() {
        return "external_match_id";
    }

    /* renamed from: h */
    protected Room c(int i, int i2) {
        return new RoomRef(this.DG, i, i2);
    }
}
