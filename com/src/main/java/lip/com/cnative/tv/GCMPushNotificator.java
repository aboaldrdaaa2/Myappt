package lip.com.cnative.tv;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;

public class GCMPushNotificator implements IGCMPushNotificator {
    private static final String PROPERTY_APP_VERSION = "appVersion";
    public static final String PROPERTY_REG_ID = "registration_id";
    public static String TAG = "GCMPushNotificator";
    private String mAppName;
    private String mGCMProjectId;
    private String mRegid;
    private TvCoreActivity m_activity;

    public native void setRegisterId(String str);

    public GCMPushNotificator(TvCoreActivity activity) {
        Log.i(TAG, "Creating GCMPushNotificator");
        this.m_activity = activity;
    }

    public void startRegister(String appName, String projectID) {
        this.mAppName = appName;
        this.mGCMProjectId = projectID;
        Log.i(TAG, "GCM startRegister: {" + this.mAppName + "; " + this.mGCMProjectId + "}");
        if (checkPlayServices()) {
            this.m_activity.runOnUiThread(new Runnable() {
                public void run() {
                    GCMPushNotificator.this.registerInBackground();
                }
            });
        } else {
            Log.e(TAG, "No valid Google Play Services APK found.");
        }
    }

    private boolean checkPlayServices() {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.m_activity) == 0) {
            return true;
        }
        Log.e(TAG, "This device is not supported.");
        return false;
    }

    private void storeRegistrationId(Context context, String regId) {
        SharedPreferences prefs = getGcmPreferences(context);
        int appVersion = getAppVersion(context);
        Log.i(TAG, "Saving regId on app version " + appVersion);
        Editor editor = prefs.edit();
        editor.putString("registration_id", regId);
        editor.putInt(PROPERTY_APP_VERSION, appVersion);
        editor.commit();
    }

    private String getRegistrationId(Context context) {
        SharedPreferences prefs = getGcmPreferences(context);
        String registrationId = prefs.getString("registration_id", "");
        if (registrationId.isEmpty()) {
            Log.i(TAG, "Registration not found.");
            return "";
        } else if (prefs.getInt(PROPERTY_APP_VERSION, ExploreByTouchHelper.INVALID_ID) == getAppVersion(context)) {
            return registrationId;
        } else {
            Log.i(TAG, "App version changed.");
            return "";
        }
    }

    private void registerInBackground() {
        try {
            new AsyncTask<Void, Void, String>() {
                protected String doInBackground(Void... params) {
                    try {
                        GCMPushNotificator.this.mRegid = GCMPushNotificator.this.getRegistrationId(GCMPushNotificator.this.m_activity);
                        if (GCMPushNotificator.this.mRegid.isEmpty()) {
                            GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(GCMPushNotificator.this.m_activity);
                            GCMPushNotificator.this.mRegid = gcm.register(GCMPushNotificator.this.mGCMProjectId);
                            GCMPushNotificator.this.storeRegistrationId(GCMPushNotificator.this.m_activity, GCMPushNotificator.this.mRegid);
                        }
                        Log.i(GCMPushNotificator.TAG, "Register ID: " + GCMPushNotificator.this.mRegid);
                        GCMPushNotificator.this.sendRegistrationIdToBackend();
                    } catch (Throwable ex) {
                        Log.e(GCMPushNotificator.TAG, "Error :" + ex.getMessage());
                    }
                    return "";
                }
            }.execute(new Void[]{null, null, null});
        } catch (Throwable ex) {
            Log.e(TAG, "Error :" + ex.getMessage());
        }
    }

    private int getAppVersion(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.e(TAG, "Error :" + e);
            return i;
        }
    }

    private SharedPreferences getGcmPreferences(Context context) {
        return context.getSharedPreferences(this.mAppName, 0);
    }

    private void sendRegistrationIdToBackend() {
        Log.e(TAG, "setRegisterId:" + this.mRegid);
        setRegisterId(this.mRegid);
    }
}
