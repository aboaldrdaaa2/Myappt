package lip.com.google.android.gms.games.internal.game;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import java.util.ArrayList;

public interface ExtendedGame extends Parcelable, Freezable<ExtendedGame> {
    Game getGame();

    ArrayList<GameBadge> hQ();

    int hR();

    boolean hS();

    int hT();

    long hU();

    long hV();

    String hW();

    long hX();

    String hY();

    SnapshotMetadata hZ();
}
