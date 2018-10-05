package lip.com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.hm;

public final class RealTimeMessage implements Parcelable {
    public static final Creator<RealTimeMessage> CREATOR = new Creator<RealTimeMessage>() {
        /* renamed from: bn */
        public RealTimeMessage createFromParcel(Parcel parcel) {
            return new RealTimeMessage(parcel, null);
        }

        /* renamed from: cz */
        public RealTimeMessage[] newArray(int i) {
            return new RealTimeMessage[i];
        }
    };
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;
    private final String Th;
    private final byte[] Ti;
    private final int Tj;

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    /* synthetic */ RealTimeMessage(Parcel x0, AnonymousClass1 x1) {
        this(x0);
    }

    public RealTimeMessage(String senderParticipantId, byte[] messageData, int isReliable) {
        this.Th = (String) hm.f(senderParticipantId);
        this.Ti = (byte[]) ((byte[]) hm.f(messageData)).clone();
        this.Tj = isReliable;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getMessageData() {
        return this.Ti;
    }

    public String getSenderParticipantId() {
        return this.Th;
    }

    public boolean isReliable() {
        return this.Tj == 1;
    }

    public void writeToParcel(Parcel parcel, int flag) {
        parcel.writeString(this.Th);
        parcel.writeByteArray(this.Ti);
        parcel.writeInt(this.Tj);
    }
}
