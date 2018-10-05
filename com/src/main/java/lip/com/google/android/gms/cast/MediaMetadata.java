package lip.com.google.android.gms.cast;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.gs;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaMetadata {
    private static final String[] AC = new String[]{null, "String", "int", "double", "ISO-8601 date String"};
    private static final a AD = new a().a(KEY_CREATION_DATE, "creationDateTime", 4).a(KEY_RELEASE_DATE, "releaseDate", 4).a(KEY_BROADCAST_DATE, "originalAirdate", 4).a(KEY_TITLE, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 1).a(KEY_SUBTITLE, "subtitle", 1).a(KEY_ARTIST, "artist", 1).a(KEY_ALBUM_ARTIST, "albumArtist", 1).a(KEY_ALBUM_TITLE, "albumName", 1).a(KEY_COMPOSER, "composer", 1).a(KEY_DISC_NUMBER, "discNumber", 2).a(KEY_TRACK_NUMBER, "trackNumber", 2).a(KEY_SEASON_NUMBER, "season", 2).a(KEY_EPISODE_NUMBER, "episode", 2).a(KEY_SERIES_TITLE, "seriesTitle", 1).a(KEY_STUDIO, "studio", 1).a(KEY_WIDTH, MMLayout.KEY_WIDTH, 2).a(KEY_HEIGHT, MMLayout.KEY_HEIGHT, 2).a(KEY_LOCATION_NAME, "location", 1).a(KEY_LOCATION_LATITUDE, "latitude", 3).a(KEY_LOCATION_LONGITUDE, "longitude", 3);
    public static final String KEY_ALBUM_ARTIST = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
    public static final String KEY_ALBUM_TITLE = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
    public static final String KEY_ARTIST = "com.google.android.gms.cast.metadata.ARTIST";
    public static final String KEY_BROADCAST_DATE = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
    public static final String KEY_COMPOSER = "com.google.android.gms.cast.metadata.COMPOSER";
    public static final String KEY_CREATION_DATE = "com.google.android.gms.cast.metadata.CREATION_DATE";
    public static final String KEY_DISC_NUMBER = "com.google.android.gms.cast.metadata.DISC_NUMBER";
    public static final String KEY_EPISODE_NUMBER = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
    public static final String KEY_HEIGHT = "com.google.android.gms.cast.metadata.HEIGHT";
    public static final String KEY_LOCATION_LATITUDE = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
    public static final String KEY_LOCATION_LONGITUDE = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";
    public static final String KEY_LOCATION_NAME = "com.google.android.gms.cast.metadata.LOCATION_NAME";
    public static final String KEY_RELEASE_DATE = "com.google.android.gms.cast.metadata.RELEASE_DATE";
    public static final String KEY_SEASON_NUMBER = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
    public static final String KEY_SERIES_TITLE = "com.google.android.gms.cast.metadata.SERIES_TITLE";
    public static final String KEY_STUDIO = "com.google.android.gms.cast.metadata.STUDIO";
    public static final String KEY_SUBTITLE = "com.google.android.gms.cast.metadata.SUBTITLE";
    public static final String KEY_TITLE = "com.google.android.gms.cast.metadata.TITLE";
    public static final String KEY_TRACK_NUMBER = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
    public static final String KEY_WIDTH = "com.google.android.gms.cast.metadata.WIDTH";
    public static final int MEDIA_TYPE_GENERIC = 0;
    public static final int MEDIA_TYPE_MOVIE = 1;
    public static final int MEDIA_TYPE_MUSIC_TRACK = 3;
    public static final int MEDIA_TYPE_PHOTO = 4;
    public static final int MEDIA_TYPE_TV_SHOW = 2;
    public static final int MEDIA_TYPE_USER = 100;
    private final Bundle AE;
    private int AF;
    private final List<WebImage> zQ;

    private static class a {
        private final Map<String, String> AG = new HashMap();
        private final Map<String, String> AH = new HashMap();
        private final Map<String, Integer> AI = new HashMap();

        public a a(String str, String str2, int i) {
            this.AG.put(str, str2);
            this.AH.put(str2, str);
            this.AI.put(str, Integer.valueOf(i));
            return this;
        }

        public String ae(String str) {
            return (String) this.AG.get(str);
        }

        public String af(String str) {
            return (String) this.AH.get(str);
        }

        public int ag(String str) {
            Integer num = (Integer) this.AI.get(str);
            return num != null ? num.intValue() : 0;
        }
    }

    public MediaMetadata() {
        this(0);
    }

    public MediaMetadata(int mediaType) {
        this.zQ = new ArrayList();
        this.AE = new Bundle();
        this.AF = mediaType;
    }

    private void a(JSONObject jSONObject, String... strArr) {
        try {
            for (String str : strArr) {
                if (this.AE.containsKey(str)) {
                    switch (AD.ag(str)) {
                        case 1:
                        case 4:
                            jSONObject.put(AD.ae(str), this.AE.getString(str));
                            break;
                        case 2:
                            jSONObject.put(AD.ae(str), this.AE.getInt(str));
                            break;
                        case 3:
                            jSONObject.put(AD.ae(str), this.AE.getDouble(str));
                            break;
                        default:
                            break;
                    }
                }
            }
            for (String str2 : this.AE.keySet()) {
                if (!str2.startsWith("com.google.")) {
                    Object obj = this.AE.get(str2);
                    if (obj instanceof String) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Integer) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Double) {
                        jSONObject.put(str2, obj);
                    }
                }
            }
        } catch (JSONException e) {
        }
    }

    private boolean a(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !a((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null) {
                if (obj2 != null || !bundle2.containsKey(str)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    private void b(JSONObject jSONObject, String... strArr) {
        Set hashSet = new HashSet(Arrays.asList(strArr));
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (!"metadataType".equals(str)) {
                    String af = AD.af(str);
                    if (af == null) {
                        Object obj = jSONObject.get(str);
                        if (obj instanceof String) {
                            this.AE.putString(str, (String) obj);
                        } else if (obj instanceof Integer) {
                            this.AE.putInt(str, ((Integer) obj).intValue());
                        } else if (obj instanceof Double) {
                            this.AE.putDouble(str, ((Double) obj).doubleValue());
                        }
                    } else if (hashSet.contains(af)) {
                        try {
                            Object obj2 = jSONObject.get(str);
                            if (obj2 != null) {
                                switch (AD.ag(af)) {
                                    case 1:
                                        if (!(obj2 instanceof String)) {
                                            break;
                                        }
                                        this.AE.putString(af, (String) obj2);
                                        break;
                                    case 2:
                                        if (!(obj2 instanceof Integer)) {
                                            break;
                                        }
                                        this.AE.putInt(af, ((Integer) obj2).intValue());
                                        break;
                                    case 3:
                                        if (!(obj2 instanceof Double)) {
                                            break;
                                        }
                                        this.AE.putDouble(af, ((Double) obj2).doubleValue());
                                        break;
                                    case 4:
                                        if ((obj2 instanceof String) && gs.aq((String) obj2) != null) {
                                            this.AE.putString(af, (String) obj2);
                                            break;
                                        }
                                    default:
                                        break;
                                }
                            }
                        } catch (JSONException e) {
                        }
                    }
                }
            }
        } catch (JSONException e2) {
        }
    }

    private void d(String str, int i) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        }
        int ag = AD.ag(str);
        if (ag != i && ag != 0) {
            throw new IllegalArgumentException("Value for " + str + " must be a " + AC[i]);
        }
    }

    public void addImage(WebImage image) {
        this.zQ.add(image);
    }

    public void b(JSONObject jSONObject) {
        clear();
        this.AF = 0;
        try {
            this.AF = jSONObject.getInt("metadataType");
        } catch (JSONException e) {
        }
        gs.a(this.zQ, jSONObject);
        switch (this.AF) {
            case 0:
                b(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_SUBTITLE, KEY_RELEASE_DATE);
                return;
            case 1:
                b(jSONObject, KEY_TITLE, KEY_STUDIO, KEY_SUBTITLE, KEY_RELEASE_DATE);
                return;
            case 2:
                b(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
                return;
            case 3:
                b(jSONObject, KEY_TITLE, KEY_ALBUM_TITLE, KEY_ARTIST, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
                return;
            case 4:
                b(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
                return;
            default:
                b(jSONObject, new String[0]);
                return;
        }
    }

    public void clear() {
        this.AE.clear();
        this.zQ.clear();
    }

    public void clearImages() {
        this.zQ.clear();
    }

    public boolean containsKey(String key) {
        return this.AE.containsKey(key);
    }

    public JSONObject dZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metadataType", this.AF);
        } catch (JSONException e) {
        }
        gs.a(jSONObject, this.zQ);
        switch (this.AF) {
            case 0:
                a(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_SUBTITLE, KEY_RELEASE_DATE);
                break;
            case 1:
                a(jSONObject, KEY_TITLE, KEY_STUDIO, KEY_SUBTITLE, KEY_RELEASE_DATE);
                break;
            case 2:
                a(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
                break;
            case 3:
                a(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_ALBUM_TITLE, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
                break;
            case 4:
                a(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
                break;
            default:
                a(jSONObject, new String[0]);
                break;
        }
        return jSONObject;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaMetadata)) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) other;
        return a(this.AE, mediaMetadata.AE) && this.zQ.equals(mediaMetadata.zQ);
    }

    public Calendar getDate(String key) {
        d(key, 4);
        String string = this.AE.getString(key);
        return string != null ? gs.aq(string) : null;
    }

    public String getDateAsString(String key) {
        d(key, 4);
        return this.AE.getString(key);
    }

    public double getDouble(String key) {
        d(key, 3);
        return this.AE.getDouble(key);
    }

    public List<WebImage> getImages() {
        return this.zQ;
    }

    public int getInt(String key) {
        d(key, 2);
        return this.AE.getInt(key);
    }

    public int getMediaType() {
        return this.AF;
    }

    public String getString(String key) {
        d(key, 1);
        return this.AE.getString(key);
    }

    public boolean hasImages() {
        return (this.zQ == null || this.zQ.isEmpty()) ? false : true;
    }

    public int hashCode() {
        int i = 17;
        Iterator it = this.AE.keySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return (i2 * 31) + this.zQ.hashCode();
            }
            i2 *= 31;
            i = this.AE.get((String) it.next()).hashCode() + i2;
        }
    }

    public Set<String> keySet() {
        return this.AE.keySet();
    }

    public void putDate(String key, Calendar value) {
        d(key, 4);
        this.AE.putString(key, gs.a(value));
    }

    public void putDouble(String key, double value) {
        d(key, 3);
        this.AE.putDouble(key, value);
    }

    public void putInt(String key, int value) {
        d(key, 2);
        this.AE.putInt(key, value);
    }

    public void putString(String key, String value) {
        d(key, 1);
        this.AE.putString(key, value);
    }
}
