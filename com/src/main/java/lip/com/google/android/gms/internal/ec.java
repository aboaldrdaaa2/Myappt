package lip.com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import java.util.Locale;

public final class ec {
    public final int rb;
    public final boolean rc;
    public final boolean rd;
    public final String re;
    public final String rf;
    public final boolean rg;
    public final boolean rh;
    public final boolean ri;
    public final String rj;
    public final String rk;
    public final int rl;
    public final int rm;
    public final int rn;
    public final int ro;
    public final int rp;
    public final int rq;
    public final float rr;
    public final int rs;
    public final int rt;
    public final double ru;
    public final boolean rv;
    public final boolean rw;
    public final int rx;

    public ec(Context context) {
        boolean z = true;
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Locale locale = Locale.getDefault();
        PackageManager packageManager = context.getPackageManager();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.rb = audioManager.getMode();
        this.rc = a(packageManager, "geo:0,0?q=donuts") != null;
        this.rd = a(packageManager, "http://www.google.com") != null;
        this.re = telephonyManager.getNetworkOperator();
        this.rf = locale.getCountry();
        this.rg = et.bV();
        this.rh = audioManager.isMusicActive();
        this.ri = audioManager.isSpeakerphoneOn();
        this.rj = locale.getLanguage();
        this.rk = a(packageManager);
        this.rl = audioManager.getStreamVolume(3);
        this.rm = a(context, connectivityManager, packageManager);
        this.rn = telephonyManager.getNetworkType();
        this.ro = telephonyManager.getPhoneType();
        this.rp = audioManager.getRingerMode();
        this.rq = audioManager.getStreamVolume(2);
        this.rr = displayMetrics.density;
        this.rs = displayMetrics.widthPixels;
        this.rt = displayMetrics.heightPixels;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            this.ru = (double) (((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
            if (!(intExtra == 2 || intExtra == 5)) {
                z = false;
            }
            this.rv = z;
        } else {
            this.ru = -1.0d;
            this.rv = false;
        }
        if (VERSION.SDK_INT >= 16) {
            this.rw = connectivityManager.isActiveNetworkMetered();
            if (connectivityManager.getActiveNetworkInfo() != null) {
                this.rx = connectivityManager.getActiveNetworkInfo().getDetailedState().ordinal();
                return;
            } else {
                this.rx = -1;
                return;
            }
        }
        this.rw = false;
        this.rx = -1;
    }

    private static int a(Context context, ConnectivityManager connectivityManager, PackageManager packageManager) {
        if (!eo.a(packageManager, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
            return -2;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null ? activeNetworkInfo.getType() : -1;
    }

    private static ResolveInfo a(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    private static String a(PackageManager packageManager) {
        ResolveInfo a = a(packageManager, "market://details?id=com.google.android.gms.ads");
        if (a == null) {
            return null;
        }
        ActivityInfo activityInfo = a.activityInfo;
        if (activityInfo == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0);
            return packageInfo != null ? packageInfo.versionCode + "." + activityInfo.packageName : null;
        } catch (NameNotFoundException e) {
            return null;
        }
    }
}
