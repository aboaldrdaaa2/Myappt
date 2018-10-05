package lip.com.google.android.gms.games.internal.player;

import android.text.TextUtils;

public final class PlayerColumnNames {
    public final String RO;
    public final String RP;
    public final String RQ;
    public final String RR;
    public final String RS;
    public final String RT;
    public final String RU;
    public final String RV;
    public final String RW;
    public final String RX;
    public final String RY;
    public final String RZ;
    public final String Sa;
    public final String Sb;
    public final String Sc;
    public final String Sd;
    public final String Se;
    public final String Sf;
    public final String Sg;
    public final String Sh;
    public final String Si;
    public final String Sj;
    public final String Sk;
    public final String Sl;

    public PlayerColumnNames(String prefix) {
        if (TextUtils.isEmpty(prefix)) {
            this.RO = "external_player_id";
            this.RP = "profile_name";
            this.RQ = "profile_icon_image_uri";
            this.RR = "profile_icon_image_url";
            this.RS = "profile_hi_res_image_uri";
            this.RT = "profile_hi_res_image_url";
            this.RU = "last_updated";
            this.RV = "is_in_circles";
            this.RW = "played_with_timestamp";
            this.RX = "current_xp_total";
            this.RY = "current_level";
            this.RZ = "current_level_min_xp";
            this.Sa = "current_level_max_xp";
            this.Sb = "next_level";
            this.Sc = "next_level_max_xp";
            this.Sd = "last_level_up_timestamp";
            this.Se = "player_title";
            this.Sf = "has_all_public_acls";
            this.Sg = "most_recent_external_game_id";
            this.Sh = "most_recent_game_name";
            this.Si = "most_recent_activity_timestamp";
            this.Sj = "most_recent_game_icon_uri";
            this.Sk = "most_recent_game_hi_res_uri";
            this.Sl = "most_recent_game_featured_uri";
            return;
        }
        this.RO = prefix + "external_player_id";
        this.RP = prefix + "profile_name";
        this.RQ = prefix + "profile_icon_image_uri";
        this.RR = prefix + "profile_icon_image_url";
        this.RS = prefix + "profile_hi_res_image_uri";
        this.RT = prefix + "profile_hi_res_image_url";
        this.RU = prefix + "last_updated";
        this.RV = prefix + "is_in_circles";
        this.RW = prefix + "played_with_timestamp";
        this.RX = prefix + "current_xp_total";
        this.RY = prefix + "current_level";
        this.RZ = prefix + "current_level_min_xp";
        this.Sa = prefix + "current_level_max_xp";
        this.Sb = prefix + "next_level";
        this.Sc = prefix + "next_level_max_xp";
        this.Sd = prefix + "last_level_up_timestamp";
        this.Se = prefix + "player_title";
        this.Sf = prefix + "has_all_public_acls";
        this.Sg = prefix + "most_recent_external_game_id";
        this.Sh = prefix + "most_recent_game_name";
        this.Si = prefix + "most_recent_activity_timestamp";
        this.Sj = prefix + "most_recent_game_icon_uri";
        this.Sk = prefix + "most_recent_game_hi_res_uri";
        this.Sl = prefix + "most_recent_game_featured_uri";
    }
}
