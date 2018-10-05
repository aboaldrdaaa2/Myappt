package lip.com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.ha;
import com.google.android.gms.internal.hk;

public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements GameBadge {
    public static final GameBadgeEntityCreator CREATOR = new GameBadgeEntityCreatorCompat();
    private int AT;
    private String HY;
    private String Mp;
    private Uri Mr;
    private final int xM;

    static final class GameBadgeEntityCreatorCompat extends GameBadgeEntityCreator {
        GameBadgeEntityCreatorCompat() {
        }

        /* renamed from: bh */
        public GameBadgeEntity createFromParcel(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.c(ha.fq()) || ha.aA(GameBadgeEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            return new GameBadgeEntity(1, readInt, readString, readString2, readString3 == null ? null : Uri.parse(readString3));
        }
    }

    GameBadgeEntity(int versionCode, int type, String title, String description, Uri iconImageUri) {
        this.xM = versionCode;
        this.AT = type;
        this.HY = title;
        this.Mp = description;
        this.Mr = iconImageUri;
    }

    public GameBadgeEntity(GameBadge gameBadge) {
        this.xM = 1;
        this.AT = gameBadge.getType();
        this.HY = gameBadge.getTitle();
        this.Mp = gameBadge.getDescription();
        this.Mr = gameBadge.getIconImageUri();
    }

    static int a(GameBadge gameBadge) {
        return hk.hashCode(Integer.valueOf(gameBadge.getType()), gameBadge.getTitle(), gameBadge.getDescription(), gameBadge.getIconImageUri());
    }

    static boolean a(GameBadge gameBadge, Object obj) {
        if (!(obj instanceof GameBadge)) {
            return false;
        }
        if (gameBadge == obj) {
            return true;
        }
        GameBadge gameBadge2 = (GameBadge) obj;
        return hk.equal(Integer.valueOf(gameBadge2.getType()), gameBadge.getTitle()) && hk.equal(gameBadge2.getDescription(), gameBadge.getIconImageUri());
    }

    static String b(GameBadge gameBadge) {
        return hk.e(gameBadge).a("Type", Integer.valueOf(gameBadge.getType())).a("Title", gameBadge.getTitle()).a("Description", gameBadge.getDescription()).a("IconImageUri", gameBadge.getIconImageUri()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public String getDescription() {
        return this.Mp;
    }

    public Uri getIconImageUri() {
        return this.Mr;
    }

    public String getTitle() {
        return this.HY;
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

    /* renamed from: ic */
    public GameBadge freeze() {
        return this;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return b((GameBadge) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (fr()) {
            dest.writeInt(this.AT);
            dest.writeString(this.HY);
            dest.writeString(this.Mp);
            dest.writeString(this.Mr == null ? null : this.Mr.toString());
            return;
        }
        GameBadgeEntityCreator.a(this, dest, flags);
    }
}
