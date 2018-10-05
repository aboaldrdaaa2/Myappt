package lip.com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;

public final class MostRecentGameInfoEntity implements SafeParcelable, MostRecentGameInfo {
    public static final MostRecentGameInfoEntityCreator CREATOR = new MostRecentGameInfoEntityCreator();
    private final String RI;
    private final String RJ;
    private final long RK;
    private final Uri RL;
    private final Uri RM;
    private final Uri RN;
    private final int xM;

    MostRecentGameInfoEntity(int versionCode, String gameId, String gameName, long activityTimestampMillis, Uri gameIconImageUri, Uri gameHiResIconImageUri, Uri gameFeaturedImageUri) {
        this.xM = versionCode;
        this.RI = gameId;
        this.RJ = gameName;
        this.RK = activityTimestampMillis;
        this.RL = gameIconImageUri;
        this.RM = gameHiResIconImageUri;
        this.RN = gameFeaturedImageUri;
    }

    public MostRecentGameInfoEntity(MostRecentGameInfo info) {
        this.xM = 2;
        this.RI = info.ip();
        this.RJ = info.iq();
        this.RK = info.ir();
        this.RL = info.is();
        this.RM = info.it();
        this.RN = info.iu();
    }

    static int a(MostRecentGameInfo mostRecentGameInfo) {
        return hk.hashCode(mostRecentGameInfo.ip(), mostRecentGameInfo.iq(), Long.valueOf(mostRecentGameInfo.ir()), mostRecentGameInfo.is(), mostRecentGameInfo.it(), mostRecentGameInfo.iu());
    }

    static boolean a(MostRecentGameInfo mostRecentGameInfo, Object obj) {
        if (!(obj instanceof MostRecentGameInfo)) {
            return false;
        }
        if (mostRecentGameInfo == obj) {
            return true;
        }
        MostRecentGameInfo mostRecentGameInfo2 = (MostRecentGameInfo) obj;
        return hk.equal(mostRecentGameInfo2.ip(), mostRecentGameInfo.ip()) && hk.equal(mostRecentGameInfo2.iq(), mostRecentGameInfo.iq()) && hk.equal(Long.valueOf(mostRecentGameInfo2.ir()), Long.valueOf(mostRecentGameInfo.ir())) && hk.equal(mostRecentGameInfo2.is(), mostRecentGameInfo.is()) && hk.equal(mostRecentGameInfo2.it(), mostRecentGameInfo.it()) && hk.equal(mostRecentGameInfo2.iu(), mostRecentGameInfo.iu());
    }

    static String b(MostRecentGameInfo mostRecentGameInfo) {
        return hk.e(mostRecentGameInfo).a("GameId", mostRecentGameInfo.ip()).a("GameName", mostRecentGameInfo.iq()).a("ActivityTimestampMillis", Long.valueOf(mostRecentGameInfo.ir())).a("GameIconUri", mostRecentGameInfo.is()).a("GameHiResUri", mostRecentGameInfo.it()).a("GameFeaturedUri", mostRecentGameInfo.iu()).toString();
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

    public int hashCode() {
        return a(this);
    }

    public String ip() {
        return this.RI;
    }

    public String iq() {
        return this.RJ;
    }

    public long ir() {
        return this.RK;
    }

    public Uri is() {
        return this.RL;
    }

    public boolean isDataValid() {
        return true;
    }

    public Uri it() {
        return this.RM;
    }

    public Uri iu() {
        return this.RN;
    }

    /* renamed from: iv */
    public MostRecentGameInfo freeze() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        MostRecentGameInfoEntityCreator.a(this, out, flags);
    }
}
