package lip.com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.hk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity implements SafeParcelable, GameRequest {
    public static final GameRequestEntityCreator CREATOR = new GameRequestEntityCreator();
    private final int AT;
    private final String OB;
    private final GameEntity Rt;
    private final long SU;
    private final byte[] TF;
    private final int Tb;
    private final PlayerEntity Ua;
    private final ArrayList<PlayerEntity> Ub;
    private final long Uc;
    private final Bundle Ud;
    private final int xM;

    GameRequestEntity(int versionCode, GameEntity game, PlayerEntity sender, byte[] data, String requestId, ArrayList<PlayerEntity> recipients, int type, long creationTimestamp, long expirationTimestamp, Bundle recipientStatuses, int status) {
        this.xM = versionCode;
        this.Rt = game;
        this.Ua = sender;
        this.TF = data;
        this.OB = requestId;
        this.Ub = recipients;
        this.AT = type;
        this.SU = creationTimestamp;
        this.Uc = expirationTimestamp;
        this.Ud = recipientStatuses;
        this.Tb = status;
    }

    public GameRequestEntity(GameRequest request) {
        this.xM = 2;
        this.Rt = new GameEntity(request.getGame());
        this.Ua = new PlayerEntity(request.getSender());
        this.OB = request.getRequestId();
        this.AT = request.getType();
        this.SU = request.getCreationTimestamp();
        this.Uc = request.getExpirationTimestamp();
        this.Tb = request.getStatus();
        Object data = request.getData();
        if (data == null) {
            this.TF = null;
        } else {
            this.TF = new byte[data.length];
            System.arraycopy(data, 0, this.TF, 0, data.length);
        }
        List recipients = request.getRecipients();
        int size = recipients.size();
        this.Ub = new ArrayList(size);
        this.Ud = new Bundle();
        for (int i = 0; i < size; i++) {
            Player player = (Player) ((Player) recipients.get(i)).freeze();
            String playerId = player.getPlayerId();
            this.Ub.add((PlayerEntity) player);
            this.Ud.putInt(playerId, request.getRecipientStatus(playerId));
        }
    }

    static int a(GameRequest gameRequest) {
        return hk.hashCode(gameRequest.getGame(), gameRequest.getRecipients(), gameRequest.getRequestId(), gameRequest.getSender(), b(gameRequest), Integer.valueOf(gameRequest.getType()), Long.valueOf(gameRequest.getCreationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    static boolean a(GameRequest gameRequest, Object obj) {
        if (!(obj instanceof GameRequest)) {
            return false;
        }
        if (gameRequest == obj) {
            return true;
        }
        GameRequest gameRequest2 = (GameRequest) obj;
        return hk.equal(gameRequest2.getGame(), gameRequest.getGame()) && hk.equal(gameRequest2.getRecipients(), gameRequest.getRecipients()) && hk.equal(gameRequest2.getRequestId(), gameRequest.getRequestId()) && hk.equal(gameRequest2.getSender(), gameRequest.getSender()) && Arrays.equals(b(gameRequest2), b(gameRequest)) && hk.equal(Integer.valueOf(gameRequest2.getType()), Integer.valueOf(gameRequest.getType())) && hk.equal(Long.valueOf(gameRequest2.getCreationTimestamp()), Long.valueOf(gameRequest.getCreationTimestamp())) && hk.equal(Long.valueOf(gameRequest2.getExpirationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    private static int[] b(GameRequest gameRequest) {
        List recipients = gameRequest.getRecipients();
        int size = recipients.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = gameRequest.getRecipientStatus(((Player) recipients.get(i)).getPlayerId());
        }
        return iArr;
    }

    static String c(GameRequest gameRequest) {
        return hk.e(gameRequest).a("Game", gameRequest.getGame()).a("Sender", gameRequest.getSender()).a("Recipients", gameRequest.getRecipients()).a("Data", gameRequest.getData()).a("RequestId", gameRequest.getRequestId()).a("Type", Integer.valueOf(gameRequest.getType())).a("CreationTimestamp", Long.valueOf(gameRequest.getCreationTimestamp())).a("ExpirationTimestamp", Long.valueOf(gameRequest.getExpirationTimestamp())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public GameRequest freeze() {
        return this;
    }

    public long getCreationTimestamp() {
        return this.SU;
    }

    public byte[] getData() {
        return this.TF;
    }

    public long getExpirationTimestamp() {
        return this.Uc;
    }

    public Game getGame() {
        return this.Rt;
    }

    public int getRecipientStatus(String playerId) {
        return this.Ud.getInt(playerId, 0);
    }

    public List<Player> getRecipients() {
        return new ArrayList(this.Ub);
    }

    public String getRequestId() {
        return this.OB;
    }

    public Player getSender() {
        return this.Ua;
    }

    public int getStatus() {
        return this.Tb;
    }

    public int getType() {
        return this.AT;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return a(this);
    }

    public Bundle iL() {
        return this.Ud;
    }

    public boolean isConsumed(String playerId) {
        return getRecipientStatus(playerId) == 1;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return c(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        GameRequestEntityCreator.a(this, dest, flags);
    }
}
