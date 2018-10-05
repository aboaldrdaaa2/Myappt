package lip.com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Map;

public final class bh implements bc {
    private static int a(DisplayMetrics displayMetrics, Map<String, String> map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            return et.a(displayMetrics, Integer.parseInt(str2));
        } catch (NumberFormatException e) {
            eu.D("Could not parse " + str + " in a video GMSG: " + str2);
            return i;
        }
    }

    public void b(ex exVar, Map<String, String> map) {
        String str = (String) map.get("action");
        if (str == null) {
            eu.D("Action missing from video GMSG.");
            return;
        }
        cf ca = exVar.ca();
        if (ca == null) {
            eu.D("Could not get ad overlay for a video GMSG.");
            return;
        }
        boolean equalsIgnoreCase = "new".equalsIgnoreCase(str);
        boolean equalsIgnoreCase2 = "position".equalsIgnoreCase(str);
        DisplayMetrics displayMetrics;
        int a;
        if (equalsIgnoreCase || equalsIgnoreCase2) {
            displayMetrics = exVar.getContext().getResources().getDisplayMetrics();
            a = a(displayMetrics, map, "x", 0);
            int a2 = a(displayMetrics, map, "y", 0);
            int a3 = a(displayMetrics, map, "w", -1);
            int a4 = a(displayMetrics, map, "h", -1);
            if (equalsIgnoreCase && ca.aQ() == null) {
                ca.c(a, a2, a3, a4);
                return;
            } else {
                ca.b(a, a2, a3, a4);
                return;
            }
        }
        cj aQ = ca.aQ();
        if (aQ == null) {
            cj.a(exVar, "no_video_view", null);
        } else if ("click".equalsIgnoreCase(str)) {
            displayMetrics = exVar.getContext().getResources().getDisplayMetrics();
            int a5 = a(displayMetrics, map, "x", 0);
            a = a(displayMetrics, map, "y", 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) a5, (float) a, 0);
            aQ.b(obtain);
            obtain.recycle();
        } else if ("controls".equalsIgnoreCase(str)) {
            str = (String) map.get("enabled");
            if (str == null) {
                eu.D("Enabled parameter missing from controls video GMSG.");
            } else {
                aQ.l(Boolean.parseBoolean(str));
            }
        } else if ("currentTime".equalsIgnoreCase(str)) {
            str = (String) map.get("time");
            if (str == null) {
                eu.D("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                aQ.seekTo((int) (Float.parseFloat(str) * 1000.0f));
            } catch (NumberFormatException e) {
                eu.D("Could not parse time parameter from currentTime video GMSG: " + str);
            }
        } else if ("hide".equalsIgnoreCase(str)) {
            aQ.setVisibility(4);
        } else if ("load".equalsIgnoreCase(str)) {
            aQ.ba();
        } else if ("pause".equalsIgnoreCase(str)) {
            aQ.pause();
        } else if ("play".equalsIgnoreCase(str)) {
            aQ.play();
        } else if ("show".equalsIgnoreCase(str)) {
            aQ.setVisibility(0);
        } else if ("src".equalsIgnoreCase(str)) {
            aQ.o((String) map.get("src"));
        } else {
            eu.D("Unknown video action: " + str);
        }
    }
}
