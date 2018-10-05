package lip.com.google.android.gms.games.internal.game;

import android.os.Parcel;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.internal.ha;
import com.google.android.gms.internal.hk;
import java.util.ArrayList;

public final class ExtendedGameEntity extends GamesDowngradeableSafeParcel implements ExtendedGame {
    public static final ExtendedGameEntityCreator CREATOR = new ExtendedGameEntityCreatorCompat();
    private final long RA;
    private final String RB;
    private final ArrayList<GameBadgeEntity> RC;
    private final SnapshotMetadataEntity RD;
    private final GameEntity Rt;
    private final int Ru;
    private final boolean Rv;
    private final int Rw;
    private final long Rx;
    private final long Ry;
    private final String Rz;
    private final int xM;

    static final class ExtendedGameEntityCreatorCompat extends ExtendedGameEntityCreator {
        ExtendedGameEntityCreatorCompat() {
        }

        /* renamed from: bg */
        public ExtendedGameEntity createFromParcel(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.c(ha.fq()) || ha.aA(ExtendedGameEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            GameEntity gameEntity = (GameEntity) GameEntity.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            boolean z = parcel.readInt() == 1;
            int readInt2 = parcel.readInt();
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            String readString = parcel.readString();
            long readLong3 = parcel.readLong();
            String readString2 = parcel.readString();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i = 0; i < readInt3; i++) {
                arrayList.add(GameBadgeEntity.CREATOR.createFromParcel(parcel));
            }
            return new ExtendedGameEntity(2, gameEntity, readInt, z, readInt2, readLong, readLong2, readString, readLong3, readString2, arrayList, null);
        }
    }

    ExtendedGameEntity(int versionCode, GameEntity game, int availability, boolean owned, int achievementUnlockedCount, long lastPlayedServerTimestamp, long priceMicros, String formattedPrice, long fullPriceMicros, String formattedFullPrice, ArrayList<GameBadgeEntity> badges, SnapshotMetadataEntity snapshot) {
        this.xM = versionCode;
        this.Rt = game;
        this.Ru = availability;
        this.Rv = owned;
        this.Rw = achievementUnlockedCount;
        this.Rx = lastPlayedServerTimestamp;
        this.Ry = priceMicros;
        this.Rz = formattedPrice;
        this.RA = fullPriceMicros;
        this.RB = formattedFullPrice;
        this.RC = badges;
        this.RD = snapshot;
    }

    public ExtendedGameEntity(ExtendedGame extendedGame) {
        SnapshotMetadataEntity snapshotMetadataEntity = null;
        this.xM = 2;
        Game game = extendedGame.getGame();
        this.Rt = game == null ? null : new GameEntity(game);
        this.Ru = extendedGame.hR();
        this.Rv = extendedGame.hS();
        this.Rw = extendedGame.hT();
        this.Rx = extendedGame.hU();
        this.Ry = extendedGame.hV();
        this.Rz = extendedGame.hW();
        this.RA = extendedGame.hX();
        this.RB = extendedGame.hY();
        SnapshotMetadata hZ = extendedGame.hZ();
        if (hZ != null) {
            snapshotMetadataEntity = new SnapshotMetadataEntity(hZ);
        }
        this.RD = snapshotMetadataEntity;
        ArrayList hQ = extendedGame.hQ();
        int size = hQ.size();
        this.RC = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.RC.add((GameBadgeEntity) ((GameBadge) hQ.get(i)).freeze());
        }
    }

    static int a(ExtendedGame extendedGame) {
        return hk.hashCode(extendedGame.getGame(), Integer.valueOf(extendedGame.hR()), Boolean.valueOf(extendedGame.hS()), Integer.valueOf(extendedGame.hT()), Long.valueOf(extendedGame.hU()), Long.valueOf(extendedGame.hV()), extendedGame.hW(), Long.valueOf(extendedGame.hX()), extendedGame.hY());
    }

    static boolean a(ExtendedGame extendedGame, Object obj) {
        if (!(obj instanceof ExtendedGame)) {
            return false;
        }
        if (extendedGame == obj) {
            return true;
        }
        ExtendedGame extendedGame2 = (ExtendedGame) obj;
        return hk.equal(extendedGame2.getGame(), extendedGame.getGame()) && hk.equal(Integer.valueOf(extendedGame2.hR()), Integer.valueOf(extendedGame.hR())) && hk.equal(Boolean.valueOf(extendedGame2.hS()), Boolean.valueOf(extendedGame.hS())) && hk.equal(Integer.valueOf(extendedGame2.hT()), Integer.valueOf(extendedGame.hT())) && hk.equal(Long.valueOf(extendedGame2.hU()), Long.valueOf(extendedGame.hU())) && hk.equal(Long.valueOf(extendedGame2.hV()), Long.valueOf(extendedGame.hV())) && hk.equal(extendedGame2.hW(), extendedGame.hW()) && hk.equal(Long.valueOf(extendedGame2.hX()), Long.valueOf(extendedGame.hX())) && hk.equal(extendedGame2.hY(), extendedGame.hY());
    }

    static String b(ExtendedGame extendedGame) {
        return hk.e(extendedGame).a("Game", extendedGame.getGame()).a("Availability", Integer.valueOf(extendedGame.hR())).a("Owned", Boolean.valueOf(extendedGame.hS())).a("AchievementUnlockedCount", Integer.valueOf(extendedGame.hT())).a("LastPlayedServerTimestamp", Long.valueOf(extendedGame.hU())).a("PriceMicros", Long.valueOf(extendedGame.hV())).a("FormattedPrice", extendedGame.hW()).a("FullPriceMicros", Long.valueOf(extendedGame.hX())).a("FormattedFullPrice", extendedGame.hY()).a("Snapshot", extendedGame.hZ()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public int getVersionCode() {
        return this.xM;
    }

    public ArrayList<GameBadge> hQ() {
        return new ArrayList(this.RC);
    }

    public int hR() {
        return this.Ru;
    }

    public boolean hS() {
        return this.Rv;
    }

    public int hT() {
        return this.Rw;
    }

    public long hU() {
        return this.Rx;
    }

    public long hV() {
        return this.Ry;
    }

    public String hW() {
        return this.Rz;
    }

    public long hX() {
        return this.RA;
    }

    public String hY() {
        return this.RB;
    }

    public SnapshotMetadata hZ() {
        return this.RD;
    }

    public int hashCode() {
        return a(this);
    }

    /* renamed from: ia */
    public GameEntity getGame() {
        return this.Rt;
    }

    /* renamed from: ib */
    public ExtendedGame freeze() {
        return this;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return b((ExtendedGame) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        int i = 0;
        if (fr()) {
            this.Rt.writeToParcel(dest, flags);
            dest.writeInt(this.Ru);
            dest.writeInt(this.Rv ? 1 : 0);
            dest.writeInt(this.Rw);
            dest.writeLong(this.Rx);
            dest.writeLong(this.Ry);
            dest.writeString(this.Rz);
            dest.writeLong(this.RA);
            dest.writeString(this.RB);
            int size = this.RC.size();
            dest.writeInt(size);
            while (i < size) {
                ((GameBadgeEntity) this.RC.get(i)).writeToParcel(dest, flags);
                i++;
            }
            return;
        }
        ExtendedGameEntityCreator.a(this, dest, flags);
    }
}
