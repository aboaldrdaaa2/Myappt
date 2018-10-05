package lip.com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.internal.hm;
import java.util.ArrayList;
import java.util.Arrays;

public final class RoomConfig {
    private final String NQ;
    private final int SY;
    private final RoomUpdateListener Tk;
    private final RoomStatusUpdateListener Tl;
    private final RealTimeMessageReceivedListener Tm;
    private final String[] Tn;
    private final Bundle To;
    private final boolean Tp;

    public static final class Builder {
        int SY;
        final RoomUpdateListener Tk;
        RoomStatusUpdateListener Tl;
        RealTimeMessageReceivedListener Tm;
        Bundle To;
        boolean Tp;
        String Tq;
        ArrayList<String> Tr;

        private Builder(RoomUpdateListener updateListener) {
            this.Tq = null;
            this.SY = -1;
            this.Tr = new ArrayList();
            this.Tp = false;
            this.Tk = (RoomUpdateListener) hm.b((Object) updateListener, (Object) "Must provide a RoomUpdateListener");
        }

        public Builder addPlayersToInvite(ArrayList<String> playerIds) {
            hm.f(playerIds);
            this.Tr.addAll(playerIds);
            return this;
        }

        public Builder addPlayersToInvite(String... playerIds) {
            hm.f(playerIds);
            this.Tr.addAll(Arrays.asList(playerIds));
            return this;
        }

        public RoomConfig build() {
            return new RoomConfig(this);
        }

        public Builder setAutoMatchCriteria(Bundle autoMatchCriteria) {
            this.To = autoMatchCriteria;
            return this;
        }

        public Builder setInvitationIdToAccept(String invitationId) {
            hm.f(invitationId);
            this.Tq = invitationId;
            return this;
        }

        public Builder setMessageReceivedListener(RealTimeMessageReceivedListener listener) {
            this.Tm = listener;
            return this;
        }

        public Builder setRoomStatusUpdateListener(RoomStatusUpdateListener listener) {
            this.Tl = listener;
            return this;
        }

        public Builder setSocketCommunicationEnabled(boolean enableSockets) {
            this.Tp = enableSockets;
            return this;
        }

        public Builder setVariant(int variant) {
            boolean z = variant == -1 || variant > 0;
            hm.b(z, (Object) "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
            this.SY = variant;
            return this;
        }
    }

    private RoomConfig(Builder builder) {
        this.Tk = builder.Tk;
        this.Tl = builder.Tl;
        this.Tm = builder.Tm;
        this.NQ = builder.Tq;
        this.SY = builder.SY;
        this.To = builder.To;
        this.Tp = builder.Tp;
        this.Tn = (String[]) builder.Tr.toArray(new String[builder.Tr.size()]);
        if (this.Tm == null) {
            hm.a(this.Tp, "Must either enable sockets OR specify a message listener");
        }
    }

    public static Builder builder(RoomUpdateListener listener) {
        return new Builder(listener);
    }

    public static Bundle createAutoMatchCriteria(int minAutoMatchPlayers, int maxAutoMatchPlayers, long exclusiveBitMask) {
        Bundle bundle = new Bundle();
        bundle.putInt(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, minAutoMatchPlayers);
        bundle.putInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, maxAutoMatchPlayers);
        bundle.putLong(Multiplayer.EXTRA_EXCLUSIVE_BIT_MASK, exclusiveBitMask);
        return bundle;
    }

    public Bundle getAutoMatchCriteria() {
        return this.To;
    }

    public String getInvitationId() {
        return this.NQ;
    }

    public String[] getInvitedPlayerIds() {
        return this.Tn;
    }

    public RealTimeMessageReceivedListener getMessageReceivedListener() {
        return this.Tm;
    }

    public RoomStatusUpdateListener getRoomStatusUpdateListener() {
        return this.Tl;
    }

    public RoomUpdateListener getRoomUpdateListener() {
        return this.Tk;
    }

    public int getVariant() {
        return this.SY;
    }

    public boolean isSocketEnabled() {
        return this.Tp;
    }
}
