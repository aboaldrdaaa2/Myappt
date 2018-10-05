package lip.com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.ik;

public final class EventEntity implements SafeParcelable, Event {
    public static final EventEntityCreator CREATOR = new EventEntityCreator();
    private final String MC;
    private final String Mp;
    private final Uri Mr;
    private final String Ni;
    private final PlayerEntity Nj;
    private final long Nk;
    private final String Nl;
    private final boolean Nm;
    private final String mName;
    private final int xM;

    EventEntity(int versionCode, String eventId, String name, String description, Uri iconImageUri, String iconImageUrl, Player player, long value, String formattedValue, boolean isVisible) {
        this.xM = versionCode;
        this.Ni = eventId;
        this.mName = name;
        this.Mp = description;
        this.Mr = iconImageUri;
        this.MC = iconImageUrl;
        this.Nj = new PlayerEntity(player);
        this.Nk = value;
        this.Nl = formattedValue;
        this.Nm = isVisible;
    }

    public EventEntity(Event event) {
        this.xM = 1;
        this.Ni = event.getEventId();
        this.mName = event.getName();
        this.Mp = event.getDescription();
        this.Mr = event.getIconImageUri();
        this.MC = event.getIconImageUrl();
        this.Nj = (PlayerEntity) event.getPlayer().freeze();
        this.Nk = event.getValue();
        this.Nl = event.getFormattedValue();
        this.Nm = event.isVisible();
    }

    static int a(Event event) {
        return hk.hashCode(event.getEventId(), event.getName(), event.getDescription(), event.getIconImageUri(), event.getIconImageUrl(), event.getPlayer(), Long.valueOf(event.getValue()), event.getFormattedValue(), Boolean.valueOf(event.isVisible()));
    }

    static boolean a(Event event, Object obj) {
        if (!(obj instanceof Event)) {
            return false;
        }
        if (event == obj) {
            return true;
        }
        Event event2 = (Event) obj;
        return hk.equal(event2.getEventId(), event.getEventId()) && hk.equal(event2.getName(), event.getName()) && hk.equal(event2.getDescription(), event.getDescription()) && hk.equal(event2.getIconImageUri(), event.getIconImageUri()) && hk.equal(event2.getIconImageUrl(), event.getIconImageUrl()) && hk.equal(event2.getPlayer(), event.getPlayer()) && hk.equal(Long.valueOf(event2.getValue()), Long.valueOf(event.getValue())) && hk.equal(event2.getFormattedValue(), event.getFormattedValue()) && hk.equal(Boolean.valueOf(event2.isVisible()), Boolean.valueOf(event.isVisible()));
    }

    static String b(Event event) {
        return hk.e(event).a("Id", event.getEventId()).a("Name", event.getName()).a("Description", event.getDescription()).a("IconImageUri", event.getIconImageUri()).a("IconImageUrl", event.getIconImageUrl()).a("Player", event.getPlayer()).a("Value", Long.valueOf(event.getValue())).a("FormattedValue", event.getFormattedValue()).a("isVisible", Boolean.valueOf(event.isVisible())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public Event freeze() {
        return this;
    }

    public String getDescription() {
        return this.Mp;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        ik.b(this.Mp, dataOut);
    }

    public String getEventId() {
        return this.Ni;
    }

    public String getFormattedValue() {
        return this.Nl;
    }

    public void getFormattedValue(CharArrayBuffer dataOut) {
        ik.b(this.Nl, dataOut);
    }

    public Uri getIconImageUri() {
        return this.Mr;
    }

    public String getIconImageUrl() {
        return this.MC;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer dataOut) {
        ik.b(this.mName, dataOut);
    }

    public Player getPlayer() {
        return this.Nj;
    }

    public long getValue() {
        return this.Nk;
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

    public boolean isVisible() {
        return this.Nm;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        EventEntityCreator.a(this, out, flags);
    }
}
