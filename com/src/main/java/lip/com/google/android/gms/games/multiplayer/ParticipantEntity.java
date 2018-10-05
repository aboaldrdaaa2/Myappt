package lip.com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.ha;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.ik;

public final class ParticipantEntity extends GamesDowngradeableSafeParcel implements Participant {
    public static final Creator<ParticipantEntity> CREATOR = new ParticipantEntityCreatorCompat();
    private final int Ap;
    private final String Ln;
    private final String MC;
    private final String MD;
    private final Uri Mr;
    private final Uri Ms;
    private final PlayerEntity Nj;
    private final String Nn;
    private final String Oq;
    private final int Tb;
    private final boolean Tc;
    private final ParticipantResult Td;
    private final int xM;

    static final class ParticipantEntityCreatorCompat extends ParticipantEntityCreator {
        ParticipantEntityCreatorCompat() {
        }

        /* renamed from: bm */
        public ParticipantEntity createFromParcel(Parcel parcel) {
            Object obj = 1;
            if (GamesDowngradeableSafeParcel.c(ha.fq()) || ha.aA(ParticipantEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Uri parse = readString3 == null ? null : Uri.parse(readString3);
            String readString4 = parcel.readString();
            Uri parse2 = readString4 == null ? null : Uri.parse(readString4);
            int readInt = parcel.readInt();
            String readString5 = parcel.readString();
            boolean z = parcel.readInt() > 0;
            if (parcel.readInt() <= 0) {
                obj = null;
            }
            return new ParticipantEntity(3, readString, readString2, parse, parse2, readInt, readString5, z, obj != null ? (PlayerEntity) PlayerEntity.CREATOR.createFromParcel(parcel) : null, 7, null, null, null);
        }
    }

    ParticipantEntity(int versionCode, String participantId, String displayName, Uri iconImageUri, Uri hiResImageUri, int status, String clientAddress, boolean connectedToRoom, PlayerEntity player, int capabilities, ParticipantResult result, String iconImageUrl, String hiResImageUrl) {
        this.xM = versionCode;
        this.Oq = participantId;
        this.Ln = displayName;
        this.Mr = iconImageUri;
        this.Ms = hiResImageUri;
        this.Tb = status;
        this.Nn = clientAddress;
        this.Tc = connectedToRoom;
        this.Nj = player;
        this.Ap = capabilities;
        this.Td = result;
        this.MC = iconImageUrl;
        this.MD = hiResImageUrl;
    }

    public ParticipantEntity(Participant participant) {
        this.xM = 3;
        this.Oq = participant.getParticipantId();
        this.Ln = participant.getDisplayName();
        this.Mr = participant.getIconImageUri();
        this.Ms = participant.getHiResImageUri();
        this.Tb = participant.getStatus();
        this.Nn = participant.gW();
        this.Tc = participant.isConnectedToRoom();
        Player player = participant.getPlayer();
        this.Nj = player == null ? null : new PlayerEntity(player);
        this.Ap = participant.getCapabilities();
        this.Td = participant.getResult();
        this.MC = participant.getIconImageUrl();
        this.MD = participant.getHiResImageUrl();
    }

    static int a(Participant participant) {
        return hk.hashCode(participant.getPlayer(), Integer.valueOf(participant.getStatus()), participant.gW(), Boolean.valueOf(participant.isConnectedToRoom()), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), Integer.valueOf(participant.getCapabilities()), participant.getResult(), participant.getParticipantId());
    }

    static boolean a(Participant participant, Object obj) {
        if (!(obj instanceof Participant)) {
            return false;
        }
        if (participant == obj) {
            return true;
        }
        Participant participant2 = (Participant) obj;
        return hk.equal(participant2.getPlayer(), participant.getPlayer()) && hk.equal(Integer.valueOf(participant2.getStatus()), Integer.valueOf(participant.getStatus())) && hk.equal(participant2.gW(), participant.gW()) && hk.equal(Boolean.valueOf(participant2.isConnectedToRoom()), Boolean.valueOf(participant.isConnectedToRoom())) && hk.equal(participant2.getDisplayName(), participant.getDisplayName()) && hk.equal(participant2.getIconImageUri(), participant.getIconImageUri()) && hk.equal(participant2.getHiResImageUri(), participant.getHiResImageUri()) && hk.equal(Integer.valueOf(participant2.getCapabilities()), Integer.valueOf(participant.getCapabilities())) && hk.equal(participant2.getResult(), participant.getResult()) && hk.equal(participant2.getParticipantId(), participant.getParticipantId());
    }

    static String b(Participant participant) {
        return hk.e(participant).a("ParticipantId", participant.getParticipantId()).a("Player", participant.getPlayer()).a("Status", Integer.valueOf(participant.getStatus())).a("ClientAddress", participant.gW()).a("ConnectedToRoom", Boolean.valueOf(participant.isConnectedToRoom())).a("DisplayName", participant.getDisplayName()).a("IconImage", participant.getIconImageUri()).a("IconImageUrl", participant.getIconImageUrl()).a("HiResImage", participant.getHiResImageUri()).a("HiResImageUrl", participant.getHiResImageUrl()).a("Capabilities", Integer.valueOf(participant.getCapabilities())).a("Result", participant.getResult()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public Participant freeze() {
        return this;
    }

    public String gW() {
        return this.Nn;
    }

    public int getCapabilities() {
        return this.Ap;
    }

    public String getDisplayName() {
        return this.Nj == null ? this.Ln : this.Nj.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        if (this.Nj == null) {
            ik.b(this.Ln, dataOut);
        } else {
            this.Nj.getDisplayName(dataOut);
        }
    }

    public Uri getHiResImageUri() {
        return this.Nj == null ? this.Ms : this.Nj.getHiResImageUri();
    }

    public String getHiResImageUrl() {
        return this.Nj == null ? this.MD : this.Nj.getHiResImageUrl();
    }

    public Uri getIconImageUri() {
        return this.Nj == null ? this.Mr : this.Nj.getIconImageUri();
    }

    public String getIconImageUrl() {
        return this.Nj == null ? this.MC : this.Nj.getIconImageUrl();
    }

    public String getParticipantId() {
        return this.Oq;
    }

    public Player getPlayer() {
        return this.Nj;
    }

    public ParticipantResult getResult() {
        return this.Td;
    }

    public int getStatus() {
        return this.Tb;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return a(this);
    }

    public boolean isConnectedToRoom() {
        return this.Tc;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return b((Participant) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        String str = null;
        int i = 0;
        if (fr()) {
            dest.writeString(this.Oq);
            dest.writeString(this.Ln);
            dest.writeString(this.Mr == null ? null : this.Mr.toString());
            if (this.Ms != null) {
                str = this.Ms.toString();
            }
            dest.writeString(str);
            dest.writeInt(this.Tb);
            dest.writeString(this.Nn);
            dest.writeInt(this.Tc ? 1 : 0);
            if (this.Nj != null) {
                i = 1;
            }
            dest.writeInt(i);
            if (this.Nj != null) {
                this.Nj.writeToParcel(dest, flags);
                return;
            }
            return;
        }
        ParticipantEntityCreator.a(this, dest, flags);
    }
}
