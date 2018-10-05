package lip.com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

public class gz implements OnClickListener {
    private final Fragment FV;
    private final int FW;
    private final Intent mIntent;
    private final Activity og;

    public gz(Activity activity, Intent intent, int i) {
        this.og = activity;
        this.FV = null;
        this.mIntent = intent;
        this.FW = i;
    }

    public gz(Fragment fragment, Intent intent, int i) {
        this.og = null;
        this.FV = fragment;
        this.mIntent = intent;
        this.FW = i;
    }

    public void onClick(DialogInterface dialog, int which) {
        try {
            if (this.mIntent != null && this.FV != null) {
                this.FV.startActivityForResult(this.mIntent, this.FW);
            } else if (this.mIntent != null) {
                this.og.startActivityForResult(this.mIntent, this.FW);
            }
            dialog.dismiss();
        } catch (ActivityNotFoundException e) {
            Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
        }
    }
}
