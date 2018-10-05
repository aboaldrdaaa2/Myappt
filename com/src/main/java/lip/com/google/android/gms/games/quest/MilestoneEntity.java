package lip.com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;

public final class MilestoneEntity implements SafeParcelable, Milestone {
    public static final MilestoneEntityCreator CREATOR = new MilestoneEntityCreator();
    private final String Ni;
    private final String Ot;
    private final long TM;
    private final long TN;
    private final byte[] TO;
    private final int mState;
    private final int xM;

    MilestoneEntity(int versionCode, String milestoneId, long currentProgress, long targetProgress, byte[] completionBlob, int state, String eventId) {
        this.xM = versionCode;
        this.Ot = milestoneId;
        this.TM = currentProgress;
        this.TN = targetProgress;
        this.TO = completionBlob;
        this.mState = state;
        this.Ni = eventId;
    }

    public MilestoneEntity(Milestone milestone) {
        this.xM = 4;
        this.Ot = milestone.getMilestoneId();
        this.TM = milestone.getCurrentProgress();
        this.TN = milestone.getTargetProgress();
        this.mState = milestone.getState();
        this.Ni = milestone.getEventId();
        Object completionRewardData = milestone.getCompletionRewardData();
        if (completionRewardData == null) {
            this.TO = null;
            return;
        }
        this.TO = new byte[completionRewardData.length];
        System.arraycopy(completionRewardData, 0, this.TO, 0, completionRewardData.length);
    }

    static int a(Milestone milestone) {
        return hk.hashCode(milestone.getMilestoneId(), Long.valueOf(milestone.getCurrentProgress()), Long.valueOf(milestone.getTargetProgress()), Integer.valueOf(milestone.getState()), milestone.getEventId());
    }

    static boolean a(Milestone milestone, Object obj) {
        if (!(obj instanceof Milestone)) {
            return false;
        }
        if (milestone == obj) {
            return true;
        }
        Milestone milestone2 = (Milestone) obj;
        return hk.equal(milestone2.getMilestoneId(), milestone.getMilestoneId()) && hk.equal(Long.valueOf(milestone2.getCurrentProgress()), Long.valueOf(milestone.getCurrentProgress())) && hk.equal(Long.valueOf(milestone2.getTargetProgress()), Long.valueOf(milestone.getTargetProgress())) && hk.equal(Integer.valueOf(milestone2.getState()), Integer.valueOf(milestone.getState())) && hk.equal(milestone2.getEventId(), milestone.getEventId());
    }

    static String b(Milestone milestone) {
        return hk.e(milestone).a("MilestoneId", milestone.getMilestoneId()).a("CurrentProgress", Long.valueOf(milestone.getCurrentProgress())).a("TargetProgress", Long.valueOf(milestone.getTargetProgress())).a("State", Integer.valueOf(milestone.getState())).a("CompletionRewardData", milestone.getCompletionRewardData()).a("EventId", milestone.getEventId()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public Milestone freeze() {
        return this;
    }

    public byte[] getCompletionRewardData() {
        return this.TO;
    }

    public long getCurrentProgress() {
        return this.TM;
    }

    public String getEventId() {
        return this.Ni;
    }

    public String getMilestoneId() {
        return this.Ot;
    }

    public int getState() {
        return this.mState;
    }

    public long getTargetProgress() {
        return this.TN;
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
        MilestoneEntityCreator.a(this, out, flags);
    }
}
