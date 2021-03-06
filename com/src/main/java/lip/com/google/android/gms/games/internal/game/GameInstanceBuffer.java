package lip.com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class GameInstanceBuffer extends DataBuffer<GameInstance> {
    public GameInstanceBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* renamed from: cr */
    public GameInstance get(int i) {
        return new GameInstanceRef(this.DG, i);
    }
}
