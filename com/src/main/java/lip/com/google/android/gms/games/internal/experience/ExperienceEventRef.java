package lip.com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class ExperienceEventRef extends d implements ExperienceEvent {
    public ExperienceEventRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public String getIconImageUrl() {
        return getString("icon_url");
    }
}
