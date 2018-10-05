package lip.com.google.ads.interactivemedia.v3.b.a;

import android.util.Log;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

/* compiled from: IMASDK */
public class e {
    public List<Float> adCuePoints;
    public a adData;
    public long adTimeUpdateMs;
    public String adUiStyle;
    public Map<String, c> companions;
    public int errorCode;
    public String errorMessage;
    public String innerError;
    public SortedSet<Float> internalCuePoints;
    public String ln;
    public String m;
    public String n;
    public String translation;
    public String videoUrl;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JavaScriptMsgData[");
        for (Field field : e.class.getFields()) {
            try {
                Object obj = field.get(this);
                stringBuilder.append(field.getName()).append(":");
                stringBuilder.append(obj).append(",");
            } catch (Throwable e) {
                Log.e("IMASDK", "IllegalArgumentException occurred", e);
            } catch (Throwable e2) {
                Log.e("IMASDK", "IllegalAccessException occurred", e2);
            }
        }
        return stringBuilder.append("]").toString();
    }
}
