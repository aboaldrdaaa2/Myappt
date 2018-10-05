package lip.com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.ik;
import java.util.ArrayList;
import java.util.List;

public final class QuestEntity implements SafeParcelable, Quest {
    public static final QuestEntityCreator CREATOR = new QuestEntityCreator();
    private final int AT;
    private final String Mp;
    private final GameEntity Rt;
    private final long TB;
    private final String TP;
    private final long TQ;
    private final Uri TR;
    private final String TS;
    private final long TT;
    private final Uri TU;
    private final String TV;
    private final long TW;
    private final long TX;
    private final ArrayList<MilestoneEntity> TY;
    private final String mName;
    private final int mState;
    private final int xM;

    QuestEntity(int versionCode, GameEntity game, String questId, long acceptedTimestamp, Uri bannerImageUri, String bannerImageUrl, String description, long endTimestamp, long lastUpdatedTimestamp, Uri iconImageUri, String iconImageUrl, String name, long notifyTimestamp, long startTimestamp, int state, int type, ArrayList<MilestoneEntity> milestones) {
        this.xM = versionCode;
        this.Rt = game;
        this.TP = questId;
        this.TQ = acceptedTimestamp;
        this.TR = bannerImageUri;
        this.TS = bannerImageUrl;
        this.Mp = description;
        this.TT = endTimestamp;
        this.TB = lastUpdatedTimestamp;
        this.TU = iconImageUri;
        this.TV = iconImageUrl;
        this.mName = name;
        this.TW = notifyTimestamp;
        this.TX = startTimestamp;
        this.mState = state;
        this.AT = type;
        this.TY = milestones;
    }

    public QuestEntity(Quest quest) {
        this.xM = 2;
        this.Rt = new GameEntity(quest.getGame());
        this.TP = quest.getQuestId();
        this.TQ = quest.getAcceptedTimestamp();
        this.Mp = quest.getDescription();
        this.TR = quest.getBannerImageUri();
        this.TS = quest.getBannerImageUrl();
        this.TT = quest.getEndTimestamp();
        this.TU = quest.getIconImageUri();
        this.TV = quest.getIconImageUrl();
        this.TB = quest.getLastUpdatedTimestamp();
        this.mName = quest.getName();
        this.TW = quest.iK();
        this.TX = quest.getStartTimestamp();
        this.mState = quest.getState();
        this.AT = quest.getType();
        List iJ = quest.iJ();
        int size = iJ.size();
        this.TY = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.TY.add((MilestoneEntity) ((Milestone) iJ.get(i)).freeze());
        }
    }

    static int a(Quest quest) {
        return hk.hashCode(quest.getGame(), quest.getQuestId(), Long.valueOf(quest.getAcceptedTimestamp()), quest.getBannerImageUri(), quest.getDescription(), Long.valueOf(quest.getEndTimestamp()), quest.getIconImageUri(), Long.valueOf(quest.getLastUpdatedTimestamp()), quest.iJ(), quest.getName(), Long.valueOf(quest.iK()), Long.valueOf(quest.getStartTimestamp()), Integer.valueOf(quest.getState()));
    }

    static boolean a(Quest quest, Object obj) {
        if (!(obj instanceof Quest)) {
            return false;
        }
        if (quest == obj) {
            return true;
        }
        Quest quest2 = (Quest) obj;
        return hk.equal(quest2.getGame(), quest.getGame()) && hk.equal(quest2.getQuestId(), quest.getQuestId()) && hk.equal(Long.valueOf(quest2.getAcceptedTimestamp()), Long.valueOf(quest.getAcceptedTimestamp())) && hk.equal(quest2.getBannerImageUri(), quest.getBannerImageUri()) && hk.equal(quest2.getDescription(), quest.getDescription()) && hk.equal(Long.valueOf(quest2.getEndTimestamp()), Long.valueOf(quest.getEndTimestamp())) && hk.equal(quest2.getIconImageUri(), quest.getIconImageUri()) && hk.equal(Long.valueOf(quest2.getLastUpdatedTimestamp()), Long.valueOf(quest.getLastUpdatedTimestamp())) && hk.equal(quest2.iJ(), quest.iJ()) && hk.equal(quest2.getName(), quest.getName()) && hk.equal(Long.valueOf(quest2.iK()), Long.valueOf(quest.iK())) && hk.equal(Long.valueOf(quest2.getStartTimestamp()), Long.valueOf(quest.getStartTimestamp())) && hk.equal(Integer.valueOf(quest2.getState()), Integer.valueOf(quest.getState()));
    }

    static String b(Quest quest) {
        return hk.e(quest).a("Game", quest.getGame()).a("QuestId", quest.getQuestId()).a("AcceptedTimestamp", Long.valueOf(quest.getAcceptedTimestamp())).a("BannerImageUri", quest.getBannerImageUri()).a("BannerImageUrl", quest.getBannerImageUrl()).a("Description", quest.getDescription()).a("EndTimestamp", Long.valueOf(quest.getEndTimestamp())).a("IconImageUri", quest.getIconImageUri()).a("IconImageUrl", quest.getIconImageUrl()).a("LastUpdatedTimestamp", Long.valueOf(quest.getLastUpdatedTimestamp())).a("Milestones", quest.iJ()).a("Name", quest.getName()).a("NotifyTimestamp", Long.valueOf(quest.iK())).a("StartTimestamp", Long.valueOf(quest.getStartTimestamp())).a("State", Integer.valueOf(quest.getState())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public Quest freeze() {
        return this;
    }

    public long getAcceptedTimestamp() {
        return this.TQ;
    }

    public Uri getBannerImageUri() {
        return this.TR;
    }

    public String getBannerImageUrl() {
        return this.TS;
    }

    public Milestone getCurrentMilestone() {
        return (Milestone) iJ().get(0);
    }

    public String getDescription() {
        return this.Mp;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        ik.b(this.Mp, dataOut);
    }

    public long getEndTimestamp() {
        return this.TT;
    }

    public Game getGame() {
        return this.Rt;
    }

    public Uri getIconImageUri() {
        return this.TU;
    }

    public String getIconImageUrl() {
        return this.TV;
    }

    public long getLastUpdatedTimestamp() {
        return this.TB;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer dataOut) {
        ik.b(this.mName, dataOut);
    }

    public String getQuestId() {
        return this.TP;
    }

    public long getStartTimestamp() {
        return this.TX;
    }

    public int getState() {
        return this.mState;
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

    public List<Milestone> iJ() {
        return new ArrayList(this.TY);
    }

    public long iK() {
        return this.TW;
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isEndingSoon() {
        return this.TW <= System.currentTimeMillis() + 1800000;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        QuestEntityCreator.a(this, out, flags);
    }
}
