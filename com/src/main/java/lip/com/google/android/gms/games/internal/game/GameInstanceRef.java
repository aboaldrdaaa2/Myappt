package lip.com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.internal.constants.PlatformType;
import com.google.android.gms.internal.hk;

public final class GameInstanceRef extends d implements GameInstance {
    GameInstanceRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public String getApplicationId() {
        return getString("external_game_id");
    }

    public String getDisplayName() {
        return getString("instance_display_name");
    }

    public String getPackageName() {
        return getString("package_name");
    }

    public boolean id() {
        return getInteger("real_time_support") > 0;
    }

    public boolean ie() {
        return getInteger("turn_based_support") > 0;
    }

    public int if() {
        return getInteger("platform_type");
    }

    public boolean ig() {
        return getInteger("piracy_check") > 0;
    }

    public boolean ih() {
        return getInteger("installed") > 0;
    }

    public String toString() {
        return hk.e(this).a("ApplicationId", getApplicationId()).a("DisplayName", getDisplayName()).a("SupportsRealTime", Boolean.valueOf(id())).a("SupportsTurnBased", Boolean.valueOf(ie())).a("PlatformType", PlatformType.cm(if())).a("PackageName", getPackageName()).a("PiracyCheckEnabled", Boolean.valueOf(ig())).a("Installed", Boolean.valueOf(ih())).toString();
    }
}
