package lip.com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.ads.AdSize;
import com.google.android.gms.common.images.WebImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class gs {
    private static final gn BG = new gn("MetadataUtils");
    private static final String[] CO = new String[]{"Z", "+hh", "+hhmm", "+hh:mm"};
    private static final String CP = ("yyyyMMdd'T'HHmmss" + CO[0]);

    public static String a(Calendar calendar) {
        if (calendar == null) {
            BG.b("Calendar object cannot be null", new Object[0]);
            return null;
        }
        String str = CP;
        if (calendar.get(11) == 0 && calendar.get(12) == 0 && calendar.get(13) == 0) {
            str = "yyyyMMdd";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(calendar.getTimeZone());
        str = simpleDateFormat.format(calendar.getTime());
        return str.endsWith("+0000") ? str.replace("+0000", CO[0]) : str;
    }

    public static void a(List<WebImage> list, JSONObject jSONObject) {
        try {
            list.clear();
            JSONArray jSONArray = jSONObject.getJSONArray("images");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    list.add(new WebImage(jSONArray.getJSONObject(i)));
                } catch (IllegalArgumentException e) {
                }
            }
        } catch (JSONException e2) {
        }
    }

    public static void a(JSONObject jSONObject, List<WebImage> list) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (WebImage dZ : list) {
                jSONArray.put(dZ.dZ());
            }
            try {
                jSONObject.put("images", jSONArray);
            } catch (JSONException e) {
            }
        }
    }

    public static Calendar aq(String str) {
        if (TextUtils.isEmpty(str)) {
            BG.b("Input string is empty or null", new Object[0]);
            return null;
        }
        String ar = ar(str);
        if (TextUtils.isEmpty(ar)) {
            BG.b("Invalid date format", new Object[0]);
            return null;
        }
        String as = as(str);
        String str2 = "yyyyMMdd";
        if (!TextUtils.isEmpty(as)) {
            ar = ar + "T" + as;
            str2 = as.length() == "HHmmss".length() ? "yyyyMMdd'T'HHmmss" : CP;
        }
        Calendar instance = GregorianCalendar.getInstance();
        try {
            instance.setTime(new SimpleDateFormat(str2).parse(ar));
            return instance;
        } catch (ParseException e) {
            BG.b("Error parsing string: %s", e.getMessage());
            return null;
        }
    }

    private static String ar(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            BG.b("Input string is empty or null", new Object[0]);
            return str2;
        }
        try {
            return str.substring(0, "yyyyMMdd".length());
        } catch (IndexOutOfBoundsException e) {
            BG.c("Error extracting the date: %s", e.getMessage());
            return str2;
        }
    }

    private static String as(String str) {
        if (TextUtils.isEmpty(str)) {
            BG.b("string is empty or null", new Object[0]);
            return null;
        }
        int indexOf = str.indexOf(84);
        int i = indexOf + 1;
        if (indexOf != "yyyyMMdd".length()) {
            BG.b("T delimeter is not found", new Object[0]);
            return null;
        }
        try {
            String substring = str.substring(i);
            if (substring.length() == "HHmmss".length()) {
                return substring;
            }
            switch (substring.charAt("HHmmss".length())) {
                case '+':
                case '-':
                    return at(substring) ? substring.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2") : null;
                case AdSize.LARGE_AD_HEIGHT /*90*/:
                    return substring.length() == "HHmmss".length() + CO[0].length() ? substring.substring(0, substring.length() - 1) + "+0000" : null;
                default:
                    return null;
            }
        } catch (IndexOutOfBoundsException e) {
            BG.b("Error extracting the time substring: %s", e.getMessage());
            return null;
        }
    }

    private static boolean at(String str) {
        int length = str.length();
        int length2 = "HHmmss".length();
        return length == CO[1].length() + length2 || length == CO[2].length() + length2 || length == length2 + CO[3].length();
    }
}
