package lip.com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.ha;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.ik;

public final class GameEntity extends GamesDowngradeableSafeParcel implements Game {
    public static final Creator<GameEntity> CREATOR = new GameEntityCreatorCompat();
    private final String Ln;
    private final boolean MA;
    private final boolean MB;
    private final String MC;
    private final String MD;
    private final String ME;
    private final boolean MF;
    private final boolean MG;
    private final boolean MH;
    private final String Mn;
    private final String Mo;
    private final String Mp;
    private final String Mq;
    private final Uri Mr;
    private final Uri Ms;
    private final Uri Mt;
    private final boolean Mu;
    private final boolean Mv;
    private final String Mw;
    private final int Mx;
    private final int My;
    private final int Mz;
    private final int xM;
    private final String zP;

    static final class GameEntityCreatorCompat extends GameEntityCreator {
        GameEntityCreatorCompat() {
        }

        /* renamed from: bd */
        public GameEntity createFromParcel(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.c(ha.fq()) || ha.aA(GameEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            Uri parse = readString7 == null ? null : Uri.parse(readString7);
            readString7 = parcel.readString();
            Uri parse2 = readString7 == null ? null : Uri.parse(readString7);
            readString7 = parcel.readString();
            return new GameEntity(4, readString, readString2, readString3, readString4, readString5, readString6, parse, parse2, readString7 == null ? null : Uri.parse(readString7), parcel.readInt() > 0, parcel.readInt() > 0, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), false, false, null, null, null, false, false, false);
        }
    }

    GameEntity(int versionCode, String applicationId, String displayName, String primaryCategory, String secondaryCategory, String description, String developerName, Uri iconImageUri, Uri hiResImageUri, Uri featuredImageUri, boolean playEnabledGame, boolean instanceInstalled, String instancePackageName, int gameplayAclStatus, int achievementTotalCount, int leaderboardCount, boolean realTimeEnabled, boolean turnBasedEnabled, String iconImageUrl, String hiResImageUrl, String featuredImageUrl, boolean muted, boolean identitySharingConfirmed, boolean snapshotsEnabled) {
        this.xM = versionCode;
        this.zP = applicationId;
        this.Ln = displayName;
        this.Mn = primaryCategory;
        this.Mo = secondaryCategory;
        this.Mp = description;
        this.Mq = developerName;
        this.Mr = iconImageUri;
        this.MC = iconImageUrl;
        this.Ms = hiResImageUri;
        this.MD = hiResImageUrl;
        this.Mt = featuredImageUri;
        this.ME = featuredImageUrl;
        this.Mu = playEnabledGame;
        this.Mv = instanceInstalled;
        this.Mw = instancePackageName;
        this.Mx = gameplayAclStatus;
        this.My = achievementTotalCount;
        this.Mz = leaderboardCount;
        this.MA = realTimeEnabled;
        this.MB = turnBasedEnabled;
        this.MF = muted;
        this.MG = identitySharingConfirmed;
        this.MH = snapshotsEnabled;
    }

    public GameEntity(Game game) {
        this.xM = 4;
        this.zP = game.getApplicationId();
        this.Mn = game.getPrimaryCategory();
        this.Mo = game.getSecondaryCategory();
        this.Mp = game.getDescription();
        this.Mq = game.getDeveloperName();
        this.Ln = game.getDisplayName();
        this.Mr = game.getIconImageUri();
        this.MC = game.getIconImageUrl();
        this.Ms = game.getHiResImageUri();
        this.MD = game.getHiResImageUrl();
        this.Mt = game.getFeaturedImageUri();
        this.ME = game.getFeaturedImageUrl();
        this.Mu = game.gM();
        this.Mv = game.gO();
        this.Mw = game.gP();
        this.Mx = game.gQ();
        this.My = game.getAchievementTotalCount();
        this.Mz = game.getLeaderboardCount();
        this.MA = game.isRealTimeMultiplayerEnabled();
        this.MB = game.isTurnBasedMultiplayerEnabled();
        this.MF = game.isMuted();
        this.MG = game.gN();
        this.MH = game.areSnapshotsEnabled();
    }

    static int a(Game game) {
        return hk.hashCode(game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), Boolean.valueOf(game.gM()), Boolean.valueOf(game.gO()), game.gP(), Integer.valueOf(game.gQ()), Integer.valueOf(game.getAchievementTotalCount()), Integer.valueOf(game.getLeaderboardCount()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isMuted()), Boolean.valueOf(game.gN()), Boolean.valueOf(game.areSnapshotsEnabled()));
    }

    static boolean a(Game game, Object obj) {
        if (!(obj instanceof Game)) {
            return false;
        }
        if (game == obj) {
            return true;
        }
        Game game2 = (Game) obj;
        if (hk.equal(game2.getApplicationId(), game.getApplicationId()) && hk.equal(game2.getDisplayName(), game.getDisplayName()) && hk.equal(game2.getPrimaryCategory(), game.getPrimaryCategory()) && hk.equal(game2.getSecondaryCategory(), game.getSecondaryCategory()) && hk.equal(game2.getDescription(), game.getDescription()) && hk.equal(game2.getDeveloperName(), game.getDeveloperName()) && hk.equal(game2.getIconImageUri(), game.getIconImageUri()) && hk.equal(game2.getHiResImageUri(), game.getHiResImageUri()) && hk.equal(game2.getFeaturedImageUri(), game.getFeaturedImageUri()) && hk.equal(Boolean.valueOf(game2.gM()), Boolean.valueOf(game.gM())) && hk.equal(Boolean.valueOf(game2.gO()), Boolean.valueOf(game.gO())) && hk.equal(game2.gP(), game.gP()) && hk.equal(Integer.valueOf(game2.gQ()), Integer.valueOf(game.gQ())) && hk.equal(Integer.valueOf(game2.getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) && hk.equal(Integer.valueOf(game2.getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount())) && hk.equal(Boolean.valueOf(game2.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()))) {
            Boolean valueOf = Boolean.valueOf(game2.isTurnBasedMultiplayerEnabled());
            boolean z = game.isTurnBasedMultiplayerEnabled() && hk.equal(Boolean.valueOf(game2.isMuted()), Boolean.valueOf(game.isMuted())) && hk.equal(Boolean.valueOf(game2.gN()), Boolean.valueOf(game.gN()));
            if (hk.equal(valueOf, Boolean.valueOf(z)) && hk.equal(Boolean.valueOf(game2.areSnapshotsEnabled()), Boolean.valueOf(game.areSnapshotsEnabled()))) {
                return true;
            }
        }
        return false;
    }

    static String b(Game game) {
        return hk.e(game).a("ApplicationId", game.getApplicationId()).a("DisplayName", game.getDisplayName()).a("PrimaryCategory", game.getPrimaryCategory()).a("SecondaryCategory", game.getSecondaryCategory()).a("Description", game.getDescription()).a("DeveloperName", game.getDeveloperName()).a("IconImageUri", game.getIconImageUri()).a("IconImageUrl", game.getIconImageUrl()).a("HiResImageUri", game.getHiResImageUri()).a("HiResImageUrl", game.getHiResImageUrl()).a("FeaturedImageUri", game.getFeaturedImageUri()).a("FeaturedImageUrl", game.getFeaturedImageUrl()).a("PlayEnabledGame", Boolean.valueOf(game.gM())).a("InstanceInstalled", Boolean.valueOf(game.gO())).a("InstancePackageName", game.gP()).a("AchievementTotalCount", Integer.valueOf(game.getAchievementTotalCount())).a("LeaderboardCount", Integer.valueOf(game.getLeaderboardCount())).a("RealTimeMultiplayerEnabled", Boolean.valueOf(game.isRealTimeMultiplayerEnabled())).a("TurnBasedMultiplayerEnabled", Boolean.valueOf(game.isTurnBasedMultiplayerEnabled())).a("AreSnapshotsEnabled", Boolean.valueOf(game.areSnapshotsEnabled())).toString();
    }

    public boolean areSnapshotsEnabled() {
        return this.MH;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public Game freeze() {
        return this;
    }

    public boolean gM() {
        return this.Mu;
    }

    public boolean gN() {
        return this.MG;
    }

    public boolean gO() {
        return this.Mv;
    }

    public String gP() {
        return this.Mw;
    }

    public int gQ() {
        return this.Mx;
    }

    public int getAchievementTotalCount() {
        return this.My;
    }

    public String getApplicationId() {
        return this.zP;
    }

    public String getDescription() {
        return this.Mp;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        ik.b(this.Mp, dataOut);
    }

    public String getDeveloperName() {
        return this.Mq;
    }

    public void getDeveloperName(CharArrayBuffer dataOut) {
        ik.b(this.Mq, dataOut);
    }

    public String getDisplayName() {
        return this.Ln;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        ik.b(this.Ln, dataOut);
    }

    public Uri getFeaturedImageUri() {
        return this.Mt;
    }

    public String getFeaturedImageUrl() {
        return this.ME;
    }

    public Uri getHiResImageUri() {
        return this.Ms;
    }

    public String getHiResImageUrl() {
        return this.MD;
    }

    public Uri getIconImageUri() {
        return this.Mr;
    }

    public String getIconImageUrl() {
        return this.MC;
    }

    public int getLeaderboardCount() {
        return this.Mz;
    }

    public String getPrimaryCategory() {
        return this.Mn;
    }

    public String getSecondaryCategory() {
        return this.Mo;
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

    public boolean isMuted() {
        return this.MF;
    }

    public boolean isRealTimeMultiplayerEnabled() {
        return this.MA;
    }

    public boolean isTurnBasedMultiplayerEnabled() {
        return this.MB;
    }

    public String toString() {
        return b((Game) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        int i = 1;
        String str = null;
        if (fr()) {
            dest.writeString(this.zP);
            dest.writeString(this.Ln);
            dest.writeString(this.Mn);
            dest.writeString(this.Mo);
            dest.writeString(this.Mp);
            dest.writeString(this.Mq);
            dest.writeString(this.Mr == null ? null : this.Mr.toString());
            dest.writeString(this.Ms == null ? null : this.Ms.toString());
            if (this.Mt != null) {
                str = this.Mt.toString();
            }
            dest.writeString(str);
            dest.writeInt(this.Mu ? 1 : 0);
            if (!this.Mv) {
                i = 0;
            }
            dest.writeInt(i);
            dest.writeString(this.Mw);
            dest.writeInt(this.Mx);
            dest.writeInt(this.My);
            dest.writeInt(this.Mz);
            return;
        }
        GameEntityCreator.a(this, dest, flags);
    }
}
