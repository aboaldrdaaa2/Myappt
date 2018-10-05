package lip.com.crystalnative.tv;

import android.app.NativeActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.market.IabHelper;
import com.market.IabHelper.OnConsumeFinishedListener;
import com.market.IabHelper.OnIabPurchaseFinishedListener;
import com.market.IabHelper.OnIabSetupFinishedListener;
import com.market.IabHelper.QueryInventoryFinishedListener;
import com.market.IabResult;
import com.market.Inventory;
import com.market.Purchase;
import java.util.List;
import org.json.JSONException;
import tv.cast.player.Chromecast;

public class MyNativeActivity extends NativeActivity {
    public static final int BILLING_RESPONSE_RESULT_OK = 0;
    private static final String PROPERTY_APP_VERSION = "appVersion";
    public static final String PROPERTY_REG_ID = "registration_id";
    static final int RC_REQUEST = 10001;
    public static final String RESPONSE_CODE = "RESPONSE_CODE";
    public static final String RESPONSE_INAPP_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
    public static final String RESPONSE_INAPP_SIGNATURE = "INAPP_DATA_SIGNATURE";
    public static String TAG = "MyNativeActivityBilling";
    private String mAppName;
    OnConsumeFinishedListener mConsumeFinishedListener = new OnConsumeFinishedListener() {
        public void onConsumeFinished(Purchase purchase, IabResult result) {
            Log.d(MyNativeActivity.TAG, "Consumption finished. Purchase: " + purchase + ", result: " + result);
            if (result.isSuccess()) {
                Log.d(MyNativeActivity.TAG, "Consumption successful. Provisioning.");
            } else {
                Log.d(MyNativeActivity.TAG, " error!! Consumption successful. Provisioning.");
            }
            Log.d(MyNativeActivity.TAG, "End consumption flow.");
        }
    };
    private Context mContext;
    private String mGCMProjectId;
    QueryInventoryFinishedListener mGotInventoryListener = new QueryInventoryFinishedListener() {
        public void onQueryInventoryFinished(IabResult result, Inventory inventory) {
            Log.d(MyNativeActivity.TAG, "Query inventory finished.");
            if (!result.isFailure()) {
                Log.d(MyNativeActivity.TAG, "Query inventory was successful.");
                List<Purchase> owned = inventory.getAllPurchases();
                Log.d(MyNativeActivity.TAG, " all product" + owned.size());
                for (int i = 0; i < owned.size(); i++) {
                    Log.d(MyNativeActivity.TAG, ((Purchase) owned.get(i)).getSku());
                }
                MyNativeActivity.this.callRestore(owned);
            }
        }
    };
    public IabHelper mHelper;
    OnIabPurchaseFinishedListener mPurchaseFinishedListener = new OnIabPurchaseFinishedListener() {
        public void onIabPurchaseFinished(IabResult result, Purchase purchase) {
            Log.d(MyNativeActivity.TAG, "Purchase finished: " + result + ", purchase: " + purchase);
            if (result.isFailure()) {
                Log.d(MyNativeActivity.TAG, "Error purchasing: " + result);
            } else {
                Log.d(MyNativeActivity.TAG, "Purchase successful.");
            }
        }
    };
    String mPurchasingItemType;
    private String mRegid;
    private MyNativeActivity m_activity;
    private Chromecast m_chromecast = null;
    private FacebookSN m_facebook = null;
    private LinearLayout m_mainLayout = null;
    private VkSN m_vk = null;
    public int makePurchase;

    public static native int isRunning();

    public native void callBack(Intent intent, Purchase purchase);

    public native void callRestore(List<Purchase> list);

    public native String getPublicKey();

    public native void setRegisterId(String str);

    static {
        System.loadLibrary("main");
    }

    public InterstitialAd createInterstitialAd(int handler) {
        return new InterstitialAd(this.m_activity, handler);
    }

    public BannerAd createBannerAd(int handler) {
        Log.i(TAG, "Creating BannerAd");
        return new BannerAd(this.m_activity, handler);
    }

    public IMA createImaAd(int handler, String language) {
        Log.i(TAG, "Creating IMA");
        return new IMA(this.m_activity, handler, language);
    }

    public FacebookSN getFacebookObject() {
        Log.e(TAG, "getting FacebookSN");
        if (this.m_facebook == null) {
            this.m_facebook = new FacebookSN(this.m_activity);
        }
        return this.m_facebook;
    }

    public VkSN getVkObject() {
        Log.e(TAG, "getting VkSN");
        if (this.m_vk == null) {
            this.m_vk = new VkSN(this.m_activity);
            this.m_vk.Init();
            this.m_vk.onCreate(null);
        }
        return this.m_vk;
    }

    public Chromecast getCastObject() {
        Log.e(TAG, "getting Chromecast - " + (this.m_chromecast == null ? "null" : "not null"));
        return this.m_chromecast;
    }

    public float getDensity() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Log.i(TAG, "get density: " + metrics.density);
        return metrics.density;
    }

    public LinearLayout getMainLayout() {
        return this.m_mainLayout;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "Creating MyNativeActivity - begin");
        this.m_activity = this;
        this.m_mainLayout = new LinearLayout(this.m_activity);
        this.m_activity.setContentView(this.m_mainLayout);
        if (this.m_vk != null) {
            this.m_vk.onCreate(savedInstanceState);
        }
        if (this.m_facebook != null) {
            this.m_facebook.onCreate(savedInstanceState);
        }
        if (this.m_chromecast == null) {
            this.m_chromecast = new Chromecast(this.m_activity);
        }
        Log.e(TAG, "Creating MyNativeActivity - end");
    }

    protected void onDestroy() {
        Log.e(TAG, "onDestroy");
        if (this.m_facebook != null) {
            this.m_facebook.onDestroy();
        }
        if (this.m_vk != null) {
            this.m_vk.onDestroy();
        }
        if (this.m_chromecast != null) {
            this.m_chromecast.onDestroy();
        }
        super.onDestroy();
    }

    public void onResume() {
        Log.e(TAG, "onResume");
        if (this.m_facebook != null) {
            this.m_facebook.onResume();
        }
        if (this.m_vk != null) {
            this.m_vk.onResume();
        }
        if (this.m_chromecast != null) {
            this.m_chromecast.onResume();
        }
        super.onResume();
        Log.e(TAG, "onResume - end");
    }

    public void onPause() {
        Log.e(TAG, "onPause");
        if (this.m_facebook != null) {
            this.m_facebook.onPause();
        }
        if (this.m_vk != null) {
            this.m_vk.onPause();
        }
        if (this.m_chromecast != null) {
            this.m_chromecast.onPause();
        }
        super.onPause();
    }

    public void onStop() {
        Log.e(TAG, "onStop");
        super.onStop();
    }

    public void onSaveInstanceState(Bundle outState) {
        Log.i(TAG, "onSaveInstanceState");
        if (this.m_facebook != null) {
            this.m_facebook.onSaveInstanceState(outState);
        }
        if (this.m_vk != null) {
            this.m_vk.onSaveInstanceState(outState);
        }
        super.onSaveInstanceState(outState);
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        if (this.m_chromecast == null || !this.m_chromecast.dispatchKeyEvent(event)) {
            return super.dispatchKeyEvent(event);
        }
        return true;
    }

    public void startHelper() {
        String base64EncodedPublicKey;
        int strId = getResources().getIdentifier("PublicKey", "string", getPackageName());
        if (strId != 0) {
            base64EncodedPublicKey = getString(strId);
        } else {
            base64EncodedPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxl+3XznaF30SQ/nta1hXB425M6Dm9lYnDp3pBD3xuOgdZVssir8JkLibXMi8JPq8BaPtzDkb4ZynhibnHWzUVUBsX966d2XDslYfGAWCHad9CqoyqIZySwXdL6KyPDxvltf5tiEb0vGIgQFLvihAKWeWwvn5CSKyG3q+iPBkUH26Qjt7mQpbinGvCdOZTvha07WXfGM1RczyI5KNEOAh849mV6rMIRlJQr0dL7XywJVMK4LOs/bkM6nL74C8cg6AWHE/ooAb0s6sBw0XkrcoNzMJxyWWDq5uSnbtCBgDETxbduFUtX9MguR5hyX8mYpc8YiLydWp4QBOl264wew6OQIDAQAB";
        }
        Log.d(TAG, "Creating IAB helper. " + base64EncodedPublicKey + "_endkey");
        this.makePurchase = 0;
        Log.d(TAG, "Creating IAB helper.");
        this.mHelper = new IabHelper(this, base64EncodedPublicKey);
        this.mHelper.enableDebugLogging(true);
        Log.d(TAG, "Starting setup.");
        this.mHelper.startSetup(new OnIabSetupFinishedListener() {
            public void onIabSetupFinished(IabResult result) {
                Log.d(MyNativeActivity.TAG, "Setup finished.");
                if (result.isSuccess()) {
                    MyNativeActivity.this.makePurchase = 1;
                    Log.d(MyNativeActivity.TAG, "Setup successful. Querying inventory.");
                    return;
                }
                Log.d(MyNativeActivity.TAG, "Problem setting up in-app billing: " + result);
            }
        });
    }

    public int canMakePurchase() {
        if (this.makePurchase == 0) {
            startHelper();
        }
        return 1;
    }

    public void performPurchaseSubscription(String id) {
        try {
            Log.d(TAG, "id is" + id);
            String[] temp = id.split("/");
            if (temp[1].equals("?subscribe=true")) {
                this.mPurchasingItemType = IabHelper.ITEM_TYPE_SUBS;
                this.mHelper.launchPurchaseFlow(this, temp[0], IabHelper.ITEM_TYPE_SUBS, 10001, this.mPurchaseFinishedListener, "");
                return;
            }
            this.mPurchasingItemType = IabHelper.ITEM_TYPE_INAPP;
            this.mHelper.launchPurchaseFlow(this, temp[0], IabHelper.ITEM_TYPE_INAPP, 10001, this.mPurchaseFinishedListener, "");
        } catch (Exception e) {
            Log.d(TAG, " cathc id is" + id);
            this.mPurchasingItemType = IabHelper.ITEM_TYPE_INAPP;
            this.mHelper.launchPurchaseFlow(this, id, IabHelper.ITEM_TYPE_INAPP, 10001, this.mPurchaseFinishedListener, "");
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i(TAG, "onActivityResult(" + requestCode + "," + resultCode + "," + data);
        if (this.m_facebook != null) {
            this.m_facebook.onActivityResult(requestCode, resultCode, data);
        }
        if (this.m_vk != null) {
            this.m_vk.onActivityResult(requestCode, resultCode, data);
        }
        if (this.mHelper != null) {
            if (this.mHelper.handleActivityResult(requestCode, resultCode, data)) {
                Log.d(TAG, " billing responcedata ");
                if (data.getStringExtra("INAPP_PURCHASE_DATA") == null || data.getStringExtra("INAPP_DATA_SIGNATURE") == null) {
                    callBack(data, null);
                } else {
                    try {
                        callBack(data, new Purchase(this.mPurchasingItemType, data.getStringExtra("INAPP_PURCHASE_DATA"), data.getStringExtra("INAPP_DATA_SIGNATURE")));
                    } catch (JSONException e) {
                        callBack(data, null);
                    }
                }
                Log.d(TAG, "onActivityResult handled by IABUtil.");
                return;
            }
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public int getResponseCode(Intent i) {
        Object o = i.getExtras().get("RESPONSE_CODE");
        if (o == null) {
            Log.d(TAG, "Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (o instanceof Integer) {
            return ((Integer) o).intValue();
        } else {
            if (o instanceof Long) {
                return (int) ((Long) o).longValue();
            }
            Log.d(TAG, "getResponse code error");
            return -1;
        }
    }

    public void restoreTransaction() {
        Log.d(TAG, "restoreTransaction");
        runOnUiThread(new Runnable() {
            public void run() {
                MyNativeActivity.this.mHelper.queryInventoryAsync(MyNativeActivity.this.mGotInventoryListener);
            }
        });
    }

    public void startRegister(String appName, String projectID) {
        this.mContext = getApplicationContext();
        this.mAppName = appName;
        this.mGCMProjectId = projectID;
        Log.i(TAG, "GCM startRegister: {" + this.mAppName + "; " + this.mGCMProjectId + "}");
        if (checkPlayServices()) {
            runOnUiThread(new Runnable() {
                public void run() {
                    MyNativeActivity.this.registerInBackground();
                }
            });
        } else {
            Log.e(TAG, "No valid Google Play Services APK found.");
        }
    }

    private boolean checkPlayServices() {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) == 0) {
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
                        MyNativeActivity.this.mRegid = MyNativeActivity.this.getRegistrationId(MyNativeActivity.this.mContext);
                        if (MyNativeActivity.this.mRegid.isEmpty()) {
                            GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(MyNativeActivity.this.mContext);
                            MyNativeActivity.this.mRegid = gcm.register(MyNativeActivity.this.mGCMProjectId);
                            MyNativeActivity.this.storeRegistrationId(MyNativeActivity.this.mContext, MyNativeActivity.this.mRegid);
                        }
                        Log.i(MyNativeActivity.TAG, "Register ID: " + MyNativeActivity.this.mRegid);
                        MyNativeActivity.this.sendRegistrationIdToBackend();
                    } catch (Throwable ex) {
                        Log.e(MyNativeActivity.TAG, "Error :" + ex.getMessage());
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
        setRegisterId(this.mRegid);
    }

    public static boolean isRunningApp() {
        return isRunning() == 1;
    }
}
