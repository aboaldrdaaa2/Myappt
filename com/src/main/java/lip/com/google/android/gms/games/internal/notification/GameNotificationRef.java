package lip.com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.internal.hk;
import com.google.android.gms.plus.PlusShare;

public final class GameNotificationRef extends d implements GameNotification {
    GameNotificationRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public long getId() {
        return getLong("_id");
    }

    public String getText() {
        return getString("text");
    }

    public String getTitle() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
    }

    public int getType() {
        return getInteger("type");
    }

    public String ik() {
        return getString("notification_id");
    }

    public String il() {
        return getString("ticker");
    }

    public String im() {
        return getString("coalesced_text");
    }

    public boolean in() {
        return getInteger("acknowledged") > 0;
    }

    public boolean io() {
        return getInteger("alert_level") == 0;
    }

    public String toString() {
        return hk.e(this).a("Id", Long.valueOf(getId())).a("NotificationId", ik()).a("Type", Integer.valueOf(getType())).a("Title", getTitle()).a("Ticker", il()).a("Text", getText()).a("CoalescedText", im()).a("isAcknowledged", Boolean.valueOf(in())).a("isSilent", Boolean.valueOf(io())).toString();
    }
}
