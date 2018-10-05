package lip.com.crystalnative.tv;

import android.content.Intent;
import android.util.Log;
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

public class PlayBilling implements IPlayBilling {
    public static final int BILLING_RESPONSE_RESULT_OK = 0;
    static final int RC_REQUEST = 10001;
    public static final String RESPONSE_CODE = "RESPONSE_CODE";
    public static final String RESPONSE_INAPP_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
    public static final String RESPONSE_INAPP_SIGNATURE = "INAPP_DATA_SIGNATURE";
    public static String TAG = "PlayBilling";
    OnConsumeFinishedListener mConsumeFinishedListener = new OnConsumeFinishedListener() {
        public void onConsumeFinished(Purchase purchase, IabResult result) {
            Log.d(PlayBilling.TAG, "Consumption finished. Purchase: " + purchase + ", result: " + result);
            if (result.isSuccess()) {
                Log.d(PlayBilling.TAG, "Consumption successful. Provisioning.");
            } else {
                Log.d(PlayBilling.TAG, " error!! Consumption successful. Provisioning.");
            }
            Log.d(PlayBilling.TAG, "End consumption flow.");
        }
    };
    QueryInventoryFinishedListener mGotInventoryListener = new QueryInventoryFinishedListener() {
        public void onQueryInventoryFinished(IabResult result, Inventory inventory) {
            Log.d(PlayBilling.TAG, "Query inventory finished.");
            if (!result.isFailure()) {
                Log.d(PlayBilling.TAG, "Query inventory was successful.");
                List<Purchase> owned = inventory.getAllPurchases();
                Log.d(PlayBilling.TAG, " all product" + owned.size());
                for (int i = 0; i < owned.size(); i++) {
                    Log.d(PlayBilling.TAG, ((Purchase) owned.get(i)).getSku());
                }
                PlayBilling.this.callRestore(owned);
            }
        }
    };
    public IabHelper mHelper;
    OnIabPurchaseFinishedListener mPurchaseFinishedListener = new OnIabPurchaseFinishedListener() {
        public void onIabPurchaseFinished(IabResult result, Purchase purchase) {
            Log.d(PlayBilling.TAG, "Purchase finished: " + result + ", purchase: " + purchase);
            if (result.isFailure()) {
                Log.d(PlayBilling.TAG, "Error purchasing: " + result);
            } else {
                Log.d(PlayBilling.TAG, "Purchase successful.");
            }
        }
    };
    String mPurchasingItemType;
    private TvCoreActivity m_activity;
    public int makePurchase;

    public native void callBack(Intent intent, Purchase purchase);

    public native void callRestore(List<Purchase> list);

    public PlayBilling(TvCoreActivity activity) {
        this.m_activity = activity;
    }

    public boolean handleActivityResult(int requestCode, int resultCode, Intent data) {
        if (this.mHelper == null || !this.mHelper.handleActivityResult(requestCode, resultCode, data)) {
            return false;
        }
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
        return true;
    }

    public void startHelper() {
        String base64EncodedPublicKey;
        Log.i(TAG, "Billing: Starting setup.");
        int strId = this.m_activity.getResources().getIdentifier("PublicKey", "string", this.m_activity.getPackageName());
        if (strId != 0) {
            base64EncodedPublicKey = this.m_activity.getString(strId);
        } else {
            base64EncodedPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxl+3XznaF30SQ/nta1hXB425M6Dm9lYnDp3pBD3xuOgdZVssir8JkLibXMi8JPq8BaPtzDkb4ZynhibnHWzUVUBsX966d2XDslYfGAWCHad9CqoyqIZySwXdL6KyPDxvltf5tiEb0vGIgQFLvihAKWeWwvn5CSKyG3q+iPBkUH26Qjt7mQpbinGvCdOZTvha07WXfGM1RczyI5KNEOAh849mV6rMIRlJQr0dL7XywJVMK4LOs/bkM6nL74C8cg6AWHE/ooAb0s6sBw0XkrcoNzMJxyWWDq5uSnbtCBgDETxbduFUtX9MguR5hyX8mYpc8YiLydWp4QBOl264wew6OQIDAQAB";
        }
        Log.d(TAG, "Creating IAB helper. " + base64EncodedPublicKey + "_endkey");
        this.makePurchase = 0;
        this.mHelper = new IabHelper(this.m_activity, base64EncodedPublicKey);
        this.mHelper.enableDebugLogging(true);
        this.mHelper.startSetup(new OnIabSetupFinishedListener() {
            public void onIabSetupFinished(IabResult result) {
                Log.d(PlayBilling.TAG, "Setup finished.");
                if (result.isSuccess()) {
                    PlayBilling.this.makePurchase = 1;
                    Log.d(PlayBilling.TAG, "Setup successful. Querying inventory.");
                    return;
                }
                Log.d(PlayBilling.TAG, "Problem setting up in-app billing: " + result);
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
                this.mHelper.launchPurchaseFlow(this.m_activity, temp[0], IabHelper.ITEM_TYPE_SUBS, 10001, this.mPurchaseFinishedListener, "");
                return;
            }
            this.mPurchasingItemType = IabHelper.ITEM_TYPE_INAPP;
            this.mHelper.launchPurchaseFlow(this.m_activity, temp[0], IabHelper.ITEM_TYPE_INAPP, 10001, this.mPurchaseFinishedListener, "");
        } catch (Exception e) {
            Log.d(TAG, " cathc id is" + id);
            this.mPurchasingItemType = IabHelper.ITEM_TYPE_INAPP;
            this.mHelper.launchPurchaseFlow(this.m_activity, id, IabHelper.ITEM_TYPE_INAPP, 10001, this.mPurchaseFinishedListener, "");
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
        this.m_activity.runOnUiThread(new Runnable() {
            public void run() {
                PlayBilling.this.mHelper.queryInventoryAsync(PlayBilling.this.mGotInventoryListener);
            }
        });
    }
}
