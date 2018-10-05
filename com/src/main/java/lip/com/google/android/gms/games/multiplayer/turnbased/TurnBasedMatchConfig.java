package lip.com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.internal.hm;
import java.util.ArrayList;

public final class TurnBasedMatchConfig {
    private final int SY;
    private final String[] Tn;
    private final Bundle To;
    private final int Tz;

    public static final class Builder {
        int SY;
        Bundle To;
        ArrayList<String> Tr;
        int Tz;

        private Builder() {
            this.SY = -1;
            this.Tr = new ArrayList();
            this.To = null;
            this.Tz = 2;
        }

        public Builder addInvitedPlayer(String playerId) {
            hm.f(playerId);
            this.Tr.add(playerId);
            return this;
        }

        public Builder addInvitedPlayers(ArrayList<String> playerIds) {
            hm.f(playerIds);
            this.Tr.addAll(playerIds);
            return this;
        }

        public TurnBasedMatchConfig build() {
            return new TurnBasedMatchConfig(this);
        }

        public Builder setAutoMatchCriteria(Bundle autoMatchCriteria) {
            this.To = autoMatchCriteria;
            return this;
        }

        public Builder setVariant(int variant) {
            boolean z = variant == -1 || variant > 0;
            hm.b(z, (Object) "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
            this.SY = variant;
            return this;
        }
    }

    private TurnBasedMatchConfig(Builder builder) {
        this.SY = builder.SY;
        this.Tz = builder.Tz;
        this.To = builder.To;
        this.Tn = (String[]) builder.Tr.toArray(new String[builder.Tr.size()]);
    }

    public static Builder builder() {
        return new Builder();
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

    public String[] getInvitedPlayerIds() {
        return this.Tn;
    }

    public int getVariant() {
        return this.SY;
    }

    public int iH() {
        return this.Tz;
    }
}
