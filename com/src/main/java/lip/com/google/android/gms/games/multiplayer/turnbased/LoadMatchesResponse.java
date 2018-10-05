package lip.com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

public final class LoadMatchesResponse {
    private final InvitationBuffer Tv;
    private final TurnBasedMatchBuffer Tw;
    private final TurnBasedMatchBuffer Tx;
    private final TurnBasedMatchBuffer Ty;

    public LoadMatchesResponse(Bundle matchData) {
        DataHolder a = a(matchData, 0);
        if (a != null) {
            this.Tv = new InvitationBuffer(a);
        } else {
            this.Tv = null;
        }
        a = a(matchData, 1);
        if (a != null) {
            this.Tw = new TurnBasedMatchBuffer(a);
        } else {
            this.Tw = null;
        }
        a = a(matchData, 2);
        if (a != null) {
            this.Tx = new TurnBasedMatchBuffer(a);
        } else {
            this.Tx = null;
        }
        a = a(matchData, 3);
        if (a != null) {
            this.Ty = new TurnBasedMatchBuffer(a);
        } else {
            this.Ty = null;
        }
    }

    private static DataHolder a(Bundle bundle, int i) {
        String cm = TurnBasedMatchTurnStatus.cm(i);
        return !bundle.containsKey(cm) ? null : (DataHolder) bundle.getParcelable(cm);
    }

    public void close() {
        if (this.Tv != null) {
            this.Tv.close();
        }
        if (this.Tw != null) {
            this.Tw.close();
        }
        if (this.Tx != null) {
            this.Tx.close();
        }
        if (this.Ty != null) {
            this.Ty.close();
        }
    }

    public TurnBasedMatchBuffer getCompletedMatches() {
        return this.Ty;
    }

    public InvitationBuffer getInvitations() {
        return this.Tv;
    }

    public TurnBasedMatchBuffer getMyTurnMatches() {
        return this.Tw;
    }

    public TurnBasedMatchBuffer getTheirTurnMatches() {
        return this.Tx;
    }

    public boolean hasData() {
        return (this.Tv == null || this.Tv.getCount() <= 0) ? (this.Tw == null || this.Tw.getCount() <= 0) ? (this.Tx == null || this.Tx.getCount() <= 0) ? this.Ty != null && this.Ty.getCount() > 0 : true : true : true;
    }
}
