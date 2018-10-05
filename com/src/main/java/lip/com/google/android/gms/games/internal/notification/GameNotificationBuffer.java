package lip.com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.DataBuffer;

public final class GameNotificationBuffer extends DataBuffer<GameNotification> {
    /* renamed from: ct */
    public GameNotification get(int i) {
        return new GameNotificationRef(this.DG, i);
    }
}
