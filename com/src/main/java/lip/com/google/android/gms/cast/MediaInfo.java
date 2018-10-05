package lip.com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.in;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaInfo {
    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;
    private JSONObject AA;
    private final String At;
    private int Au;
    private String Av;
    private MediaMetadata Aw;
    private long Ax;
    private List<MediaTrack> Ay;
    private TextTrackStyle Az;

    public static class Builder {
        private final MediaInfo AB;

        public Builder(String contentId) throws IllegalArgumentException {
            if (TextUtils.isEmpty(contentId)) {
                throw new IllegalArgumentException("Content ID cannot be empty");
            }
            this.AB = new MediaInfo(contentId);
        }

        public MediaInfo build() throws IllegalArgumentException {
            this.AB.dY();
            return this.AB;
        }

        public Builder setContentType(String contentType) throws IllegalArgumentException {
            this.AB.setContentType(contentType);
            return this;
        }

        public Builder setCustomData(JSONObject customData) {
            this.AB.setCustomData(customData);
            return this;
        }

        public Builder setMediaTracks(List<MediaTrack> mediaTracks) {
            this.AB.b(mediaTracks);
            return this;
        }

        public Builder setMetadata(MediaMetadata metadata) {
            this.AB.a(metadata);
            return this;
        }

        public Builder setStreamDuration(long duration) throws IllegalArgumentException {
            this.AB.m(duration);
            return this;
        }

        public Builder setStreamType(int streamType) throws IllegalArgumentException {
            this.AB.setStreamType(streamType);
            return this;
        }

        public Builder setTextTrackStyle(TextTrackStyle textTrackStyle) {
            this.AB.setTextTrackStyle(textTrackStyle);
            return this;
        }
    }

    MediaInfo(String contentId) throws IllegalArgumentException {
        if (TextUtils.isEmpty(contentId)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
        this.At = contentId;
        this.Au = -1;
    }

    MediaInfo(JSONObject json) throws JSONException {
        int i = 0;
        this.At = json.getString("contentId");
        String string = json.getString("streamType");
        if ("NONE".equals(string)) {
            this.Au = 0;
        } else if ("BUFFERED".equals(string)) {
            this.Au = 1;
        } else if ("LIVE".equals(string)) {
            this.Au = 2;
        } else {
            this.Au = -1;
        }
        this.Av = json.getString("contentType");
        if (json.has("metadata")) {
            JSONObject jSONObject = json.getJSONObject("metadata");
            this.Aw = new MediaMetadata(jSONObject.getInt("metadataType"));
            this.Aw.b(jSONObject);
        }
        this.Ax = gi.b(json.optDouble("duration", 0.0d));
        if (json.has("tracks")) {
            this.Ay = new ArrayList();
            JSONArray jSONArray = json.getJSONArray("tracks");
            while (i < jSONArray.length()) {
                this.Ay.add(new MediaTrack(jSONArray.getJSONObject(i)));
                i++;
            }
        } else {
            this.Ay = null;
        }
        if (json.has("textTrackStyle")) {
            JSONObject jSONObject2 = json.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle = new TextTrackStyle();
            textTrackStyle.b(jSONObject2);
            this.Az = textTrackStyle;
        } else {
            this.Az = null;
        }
        this.AA = json.optJSONObject("customData");
    }

    void a(MediaMetadata mediaMetadata) {
        this.Aw = mediaMetadata;
    }

    void b(List<MediaTrack> list) {
        this.Ay = list;
    }

    void dY() throws IllegalArgumentException {
        if (TextUtils.isEmpty(this.At)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        } else if (TextUtils.isEmpty(this.Av)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        } else if (this.Au == -1) {
            throw new IllegalArgumentException("a valid stream type must be specified");
        }
    }

    public JSONObject dZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            Object obj;
            jSONObject.put("contentId", this.At);
            switch (this.Au) {
                case 1:
                    obj = "BUFFERED";
                    break;
                case 2:
                    obj = "LIVE";
                    break;
                default:
                    obj = "NONE";
                    break;
            }
            jSONObject.put("streamType", obj);
            if (this.Av != null) {
                jSONObject.put("contentType", this.Av);
            }
            if (this.Aw != null) {
                jSONObject.put("metadata", this.Aw.dZ());
            }
            jSONObject.put("duration", gi.o(this.Ax));
            if (this.Ay != null) {
                JSONArray jSONArray = new JSONArray();
                for (MediaTrack dZ : this.Ay) {
                    jSONArray.put(dZ.dZ());
                }
                jSONObject.put("tracks", jSONArray);
            }
            if (this.Az != null) {
                jSONObject.put("textTrackStyle", this.Az.dZ());
            }
            if (this.AA != null) {
                jSONObject.put("customData", this.AA);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) other;
        if ((this.AA == null) != (mediaInfo.AA == null)) {
            return false;
        }
        if (this.AA != null && mediaInfo.AA != null && !in.d(this.AA, mediaInfo.AA)) {
            return false;
        }
        if (!(gi.a(this.At, mediaInfo.At) && this.Au == mediaInfo.Au && gi.a(this.Av, mediaInfo.Av) && gi.a(this.Aw, mediaInfo.Aw) && this.Ax == mediaInfo.Ax)) {
            z = false;
        }
        return z;
    }

    public String getContentId() {
        return this.At;
    }

    public String getContentType() {
        return this.Av;
    }

    public JSONObject getCustomData() {
        return this.AA;
    }

    public List<MediaTrack> getMediaTracks() {
        return this.Ay;
    }

    public MediaMetadata getMetadata() {
        return this.Aw;
    }

    public long getStreamDuration() {
        return this.Ax;
    }

    public int getStreamType() {
        return this.Au;
    }

    public TextTrackStyle getTextTrackStyle() {
        return this.Az;
    }

    public int hashCode() {
        return hk.hashCode(this.At, Integer.valueOf(this.Au), this.Av, this.Aw, Long.valueOf(this.Ax), String.valueOf(this.AA));
    }

    void m(long j) throws IllegalArgumentException {
        if (j < 0) {
            throw new IllegalArgumentException("Stream duration cannot be negative");
        }
        this.Ax = j;
    }

    void setContentType(String contentType) throws IllegalArgumentException {
        if (TextUtils.isEmpty(contentType)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        this.Av = contentType;
    }

    void setCustomData(JSONObject customData) {
        this.AA = customData;
    }

    void setStreamType(int streamType) throws IllegalArgumentException {
        if (streamType < -1 || streamType > 2) {
            throw new IllegalArgumentException("invalid stream type");
        }
        this.Au = streamType;
    }

    public void setTextTrackStyle(TextTrackStyle textTrackStyle) {
        this.Az = textTrackStyle;
    }
}
