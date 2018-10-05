package lip.com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;

public class ei {
    private final Object ls = new Object();
    private final String rR;
    private int rX = 0;
    private long rY = -1;
    private long rZ = -1;
    private int sa = 0;
    private int sb = -1;

    public ei(String str) {
        this.rR = str;
    }

    public static boolean l(Context context) {
        int identifier = context.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (identifier == 0) {
            eu.B("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            eu.B("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (NameNotFoundException e) {
            eu.D("Fail to fetch AdActivity theme");
            eu.B("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    public Bundle b(Context context, String str) {
        Bundle bundle;
        synchronized (this.ls) {
            bundle = new Bundle();
            bundle.putString("session_id", this.rR);
            bundle.putLong("basets", this.rZ);
            bundle.putLong("currts", this.rY);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.sb);
            bundle.putInt("pclick", this.rX);
            bundle.putInt("pimp", this.sa);
            bundle.putBoolean("support_transparent_background", l(context));
        }
        return bundle;
    }

    public void b(ai aiVar, long j) {
        synchronized (this.ls) {
            if (this.rZ == -1) {
                this.rZ = j;
                this.rY = this.rZ;
            } else {
                this.rY = j;
            }
            if (aiVar.extras == null || aiVar.extras.getInt("gw", 2) != 1) {
                this.sb++;
                return;
            }
        }
    }

    public void bB() {
        synchronized (this.ls) {
            this.sa++;
        }
    }

    public void bC() {
        synchronized (this.ls) {
            this.rX++;
        }
    }

    public long bO() {
        return this.rZ;
    }
}
