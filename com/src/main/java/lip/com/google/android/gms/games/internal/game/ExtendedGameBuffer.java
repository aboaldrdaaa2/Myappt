package lip.com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;

public final class ExtendedGameBuffer extends g<ExtendedGame> {
    public ExtendedGameBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* renamed from: e */
    protected ExtendedGame c(int i, int i2) {
        return new ExtendedGameRef(this.DG, i, i2);
    }

    protected String eZ() {
        return "external_game_id";
    }
}
