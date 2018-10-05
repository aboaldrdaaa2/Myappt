package lip.com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

class g implements m {
    private static g tG;
    private static Object tq = new Object();
    protected String tC;
    protected String tD;
    protected String tE;
    protected String tF;

    protected g() {
    }

    private g(Context context) {
        PackageManager packageManager = context.getPackageManager();
        this.tE = context.getPackageName();
        this.tF = packageManager.getInstallerPackageName(this.tE);
        String str = this.tE;
        String str2 = null;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                str = packageManager.getApplicationLabel(packageInfo.applicationInfo).toString();
                str2 = packageInfo.versionName;
            }
        } catch (NameNotFoundException e) {
            aa.A("Error retrieving package info: appName set to " + str);
        }
        this.tC = str;
        this.tD = str2;
    }

    public static g cu() {
        return tG;
    }

    public static void u(Context context) {
        synchronized (tq) {
            if (tG == null) {
                tG = new g(context);
            }
        }
    }

    public boolean J(String str) {
        return "&an".equals(str) || "&av".equals(str) || "&aid".equals(str) || "&aiid".equals(str);
    }

    public String getValue(String field) {
        if (field == null) {
            return null;
        }
        if (field.equals("&an")) {
            return this.tC;
        }
        if (field.equals("&av")) {
            return this.tD;
        }
        if (field.equals("&aid")) {
            return this.tE;
        }
        return field.equals("&aiid") ? this.tF : null;
    }
}
