package lip.com.google.android.gms.cast;

import com.google.android.gms.internal.gi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaStatus {
    public static final long COMMAND_PAUSE = 1;
    public static final long COMMAND_SEEK = 2;
    public static final long COMMAND_SET_VOLUME = 4;
    public static final long COMMAND_SKIP_BACKWARD = 32;
    public static final long COMMAND_SKIP_FORWARD = 16;
    public static final long COMMAND_TOGGLE_MUTE = 8;
    public static final int IDLE_REASON_CANCELED = 2;
    public static final int IDLE_REASON_ERROR = 4;
    public static final int IDLE_REASON_FINISHED = 1;
    public static final int IDLE_REASON_INTERRUPTED = 3;
    public static final int IDLE_REASON_NONE = 0;
    public static final int PLAYER_STATE_BUFFERING = 4;
    public static final int PLAYER_STATE_IDLE = 1;
    public static final int PLAYER_STATE_PAUSED = 3;
    public static final int PLAYER_STATE_PLAYING = 2;
    public static final int PLAYER_STATE_UNKNOWN = 0;
    private JSONObject AA;
    private MediaInfo AB;
    private long AJ;
    private double AK;
    private int AL;
    private int AM;
    private long AN;
    private long AO;
    private double AP;
    private boolean AQ;
    private long[] AR;

    public MediaStatus(JSONObject json) throws JSONException {
        a(json, 0);
    }

    public int a(JSONObject jSONObject, int i) throws JSONException {
        int i2;
        long b;
        long[] jArr;
        int i3 = 2;
        Object obj = null;
        Object obj2 = 1;
        long j = jSONObject.getLong("mediaSessionId");
        if (j != this.AJ) {
            this.AJ = j;
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (jSONObject.has("playerState")) {
            String string = jSONObject.getString("playerState");
            int i4 = string.equals("IDLE") ? 1 : string.equals("PLAYING") ? 2 : string.equals("PAUSED") ? 3 : string.equals("BUFFERING") ? 4 : 0;
            if (i4 != this.AL) {
                this.AL = i4;
                i2 |= 2;
            }
            if (i4 == 1 && jSONObject.has("idleReason")) {
                string = jSONObject.getString("idleReason");
                if (!string.equals("CANCELLED")) {
                    i3 = string.equals("INTERRUPTED") ? 3 : string.equals("FINISHED") ? 1 : string.equals("ERROR") ? 4 : 0;
                }
                if (i3 != this.AM) {
                    this.AM = i3;
                    i2 |= 2;
                }
            }
        }
        if (jSONObject.has("playbackRate")) {
            double d = jSONObject.getDouble("playbackRate");
            if (this.AK != d) {
                this.AK = d;
                i2 |= 2;
            }
        }
        if (jSONObject.has("currentTime") && (i & 2) == 0) {
            b = gi.b(jSONObject.getDouble("currentTime"));
            if (b != this.AN) {
                this.AN = b;
                i2 |= 2;
            }
        }
        if (jSONObject.has("supportedMediaCommands")) {
            b = jSONObject.getLong("supportedMediaCommands");
            if (b != this.AO) {
                this.AO = b;
                i2 |= 2;
            }
        }
        if (jSONObject.has("volume") && (i & 1) == 0) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("volume");
            double d2 = jSONObject2.getDouble("level");
            if (d2 != this.AP) {
                this.AP = d2;
                i2 |= 2;
            }
            boolean z = jSONObject2.getBoolean("muted");
            if (z != this.AQ) {
                this.AQ = z;
                i2 |= 2;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            long[] jArr2 = new long[length];
            for (i3 = 0; i3 < length; i3++) {
                jArr2[i3] = jSONArray.getLong(i3);
            }
            if (this.AR != null && this.AR.length == length) {
                for (i3 = 0; i3 < length; i3++) {
                    if (this.AR[i3] != jArr2[i3]) {
                        break;
                    }
                }
                obj2 = null;
            }
            if (obj2 != null) {
                this.AR = jArr2;
            }
            obj = obj2;
            jArr = jArr2;
        } else if (this.AR != null) {
            int obj3 = 1;
            jArr = null;
        } else {
            jArr = null;
        }
        if (obj3 != null) {
            this.AR = jArr;
            i2 |= 2;
        }
        if (jSONObject.has("customData")) {
            this.AA = jSONObject.getJSONObject("customData");
            i2 |= 2;
        }
        if (!jSONObject.has("media")) {
            return i2;
        }
        JSONObject jSONObject3 = jSONObject.getJSONObject("media");
        this.AB = new MediaInfo(jSONObject3);
        i2 |= 2;
        return jSONObject3.has("metadata") ? i2 | 4 : i2;
    }

    public long ea() {
        return this.AJ;
    }

    public long[] getActiveTrackIds() {
        return this.AR;
    }

    public JSONObject getCustomData() {
        return this.AA;
    }

    public int getIdleReason() {
        return this.AM;
    }

    public MediaInfo getMediaInfo() {
        return this.AB;
    }

    public double getPlaybackRate() {
        return this.AK;
    }

    public int getPlayerState() {
        return this.AL;
    }

    public long getStreamPosition() {
        return this.AN;
    }

    public double getStreamVolume() {
        return this.AP;
    }

    public boolean isMediaCommandSupported(long mediaCommand) {
        return (this.AO & mediaCommand) != 0;
    }

    public boolean isMute() {
        return this.AQ;
    }
}
