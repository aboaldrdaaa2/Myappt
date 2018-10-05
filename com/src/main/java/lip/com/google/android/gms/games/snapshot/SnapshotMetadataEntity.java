package lip.com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.ik;

public final class SnapshotMetadataEntity implements SafeParcelable, SnapshotMetadata {
    public static final SnapshotMetadataEntityCreator CREATOR = new SnapshotMetadataEntityCreator();
    private final String HY;
    private final String Mp;
    private final String NK;
    private final GameEntity Rt;
    private final Uri Uh;
    private final PlayerEntity Ul;
    private final String Um;
    private final long Un;
    private final long Uo;
    private final float Up;
    private final String Uq;
    private final int xM;

    SnapshotMetadataEntity(int versionCode, GameEntity game, PlayerEntity owner, String snapshotId, Uri coverImageUri, String coverImageUrl, String title, String description, long lastModifiedTimestamp, long playedTime, float coverImageAspectRatio, String uniqueName) {
        this.xM = versionCode;
        this.Rt = game;
        this.Ul = owner;
        this.NK = snapshotId;
        this.Uh = coverImageUri;
        this.Um = coverImageUrl;
        this.Up = coverImageAspectRatio;
        this.HY = title;
        this.Mp = description;
        this.Un = lastModifiedTimestamp;
        this.Uo = playedTime;
        this.Uq = uniqueName;
    }

    public SnapshotMetadataEntity(SnapshotMetadata snapshotMetadata) {
        this.xM = 3;
        this.Rt = new GameEntity(snapshotMetadata.getGame());
        this.Ul = new PlayerEntity(snapshotMetadata.getOwner());
        this.NK = snapshotMetadata.getSnapshotId();
        this.Uh = snapshotMetadata.getCoverImageUri();
        this.Um = snapshotMetadata.getCoverImageUrl();
        this.Up = snapshotMetadata.getCoverImageAspectRatio();
        this.HY = snapshotMetadata.getTitle();
        this.Mp = snapshotMetadata.getDescription();
        this.Un = snapshotMetadata.getLastModifiedTimestamp();
        this.Uo = snapshotMetadata.getPlayedTime();
        this.Uq = snapshotMetadata.getUniqueName();
    }

    static int a(SnapshotMetadata snapshotMetadata) {
        return hk.hashCode(snapshotMetadata.getGame(), snapshotMetadata.getOwner(), snapshotMetadata.getSnapshotId(), snapshotMetadata.getCoverImageUri(), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio()), snapshotMetadata.getTitle(), snapshotMetadata.getDescription(), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getPlayedTime()), snapshotMetadata.getUniqueName());
    }

    static boolean a(SnapshotMetadata snapshotMetadata, Object obj) {
        if (!(obj instanceof SnapshotMetadata)) {
            return false;
        }
        if (snapshotMetadata == obj) {
            return true;
        }
        SnapshotMetadata snapshotMetadata2 = (SnapshotMetadata) obj;
        return hk.equal(snapshotMetadata2.getGame(), snapshotMetadata.getGame()) && hk.equal(snapshotMetadata2.getOwner(), snapshotMetadata.getOwner()) && hk.equal(snapshotMetadata2.getSnapshotId(), snapshotMetadata.getSnapshotId()) && hk.equal(snapshotMetadata2.getCoverImageUri(), snapshotMetadata.getCoverImageUri()) && hk.equal(Float.valueOf(snapshotMetadata2.getCoverImageAspectRatio()), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())) && hk.equal(snapshotMetadata2.getTitle(), snapshotMetadata.getTitle()) && hk.equal(snapshotMetadata2.getDescription(), snapshotMetadata.getDescription()) && hk.equal(Long.valueOf(snapshotMetadata2.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())) && hk.equal(Long.valueOf(snapshotMetadata2.getPlayedTime()), Long.valueOf(snapshotMetadata.getPlayedTime())) && hk.equal(snapshotMetadata2.getUniqueName(), snapshotMetadata.getUniqueName());
    }

    static String b(SnapshotMetadata snapshotMetadata) {
        return hk.e(snapshotMetadata).a("Game", snapshotMetadata.getGame()).a("Owner", snapshotMetadata.getOwner()).a("SnapshotId", snapshotMetadata.getSnapshotId()).a("CoverImageUri", snapshotMetadata.getCoverImageUri()).a("CoverImageUrl", snapshotMetadata.getCoverImageUrl()).a("CoverImageAspectRatio", Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())).a("Description", snapshotMetadata.getDescription()).a("LastModifiedTimestamp", Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())).a("PlayedTime", Long.valueOf(snapshotMetadata.getPlayedTime())).a("UniqueName", snapshotMetadata.getUniqueName()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public SnapshotMetadata freeze() {
        return this;
    }

    public float getCoverImageAspectRatio() {
        return this.Up;
    }

    public Uri getCoverImageUri() {
        return this.Uh;
    }

    public String getCoverImageUrl() {
        return this.Um;
    }

    public String getDescription() {
        return this.Mp;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        ik.b(this.Mp, dataOut);
    }

    public Game getGame() {
        return this.Rt;
    }

    public long getLastModifiedTimestamp() {
        return this.Un;
    }

    public Player getOwner() {
        return this.Ul;
    }

    public long getPlayedTime() {
        return this.Uo;
    }

    public String getSnapshotId() {
        return this.NK;
    }

    public String getTitle() {
        return this.HY;
    }

    public String getUniqueName() {
        return this.Uq;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        SnapshotMetadataEntityCreator.a(this, out, flags);
    }
}
