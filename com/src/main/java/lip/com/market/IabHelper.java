package lip.com.market;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.android.vending.billing.IInAppBillingService;
import com.android.vending.billing.IInAppBillingService.Stub;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

public class IabHelper {
    public static final int BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE = 3;
    public static final int BILLING_RESPONSE_RESULT_DEVELOPER_ERROR = 5;
    public static final int BILLING_RESPONSE_RESULT_ERROR = 6;
    public static final int BILLING_RESPONSE_RESULT_ITEM_ALREADY_OWNED = 7;
    public static final int BILLING_RESPONSE_RESULT_ITEM_NOT_OWNED = 8;
    public static final int BILLING_RESPONSE_RESULT_ITEM_UNAVAILABLE = 4;
    public static final int BILLING_RESPONSE_RESULT_OK = 0;
    public static final int BILLING_RESPONSE_RESULT_USER_CANCELED = 1;
    public static final String GET_SKU_DETAILS_ITEM_LIST = "ITEM_ID_LIST";
    public static final String GET_SKU_DETAILS_ITEM_TYPE_LIST = "ITEM_TYPE_LIST";
    public static final int IABHELPER_BAD_RESPONSE = -1002;
    public static final int IABHELPER_ERROR_BASE = -1000;
    public static final int IABHELPER_INVALID_CONSUMPTION = -1010;
    public static final int IABHELPER_MISSING_TOKEN = -1007;
    public static final int IABHELPER_REMOTE_EXCEPTION = -1001;
    public static final int IABHELPER_SEND_INTENT_FAILED = -1004;
    public static final int IABHELPER_SUBSCRIPTIONS_NOT_AVAILABLE = -1009;
    public static final int IABHELPER_UNKNOWN_ERROR = -1008;
    public static final int IABHELPER_UNKNOWN_PURCHASE_RESPONSE = -1006;
    public static final int IABHELPER_USER_CANCELLED = -1005;
    public static final int IABHELPER_VERIFICATION_FAILED = -1003;
    public static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    public static final String ITEM_TYPE_INAPP = "inapp";
    public static final String ITEM_TYPE_SUBS = "subs";
    public static final String RESPONSE_BUY_INTENT = "BUY_INTENT";
    public static final String RESPONSE_CODE = "RESPONSE_CODE";
    public static final String RESPONSE_GET_SKU_DETAILS_LIST = "DETAILS_LIST";
    public static final String RESPONSE_INAPP_ITEM_LIST = "INAPP_PURCHASE_ITEM_LIST";
    public static final String RESPONSE_INAPP_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
    public static final String RESPONSE_INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    public static final String RESPONSE_INAPP_SIGNATURE = "INAPP_DATA_SIGNATURE";
    public static final String RESPONSE_INAPP_SIGNATURE_LIST = "INAPP_DATA_SIGNATURE_LIST";
    boolean mAsyncInProgress = false;
    String mAsyncOperation = "";
    Context mContext;
    boolean mDebugLog = false;
    String mDebugTag = "IabHelper";
    OnIabPurchaseFinishedListener mPurchaseListener;
    String mPurchasingItemType;
    int mRequestCode;
    IInAppBillingService mService;
    ServiceConnection mServiceConn;
    boolean mSetupDone = false;
    String mSignatureBase64 = null;
    boolean mSubscriptionsSupported = false;

    public interface OnConsumeFinishedListener {
        void onConsumeFinished(Purchase purchase, IabResult iabResult);
    }

    public interface OnConsumeMultiFinishedListener {
        void onConsumeMultiFinished(List<Purchase> list, List<IabResult> list2);
    }

    public interface OnIabPurchaseFinishedListener {
        void onIabPurchaseFinished(IabResult iabResult, Purchase purchase);
    }

    public interface OnIabSetupFinishedListener {
        void onIabSetupFinished(IabResult iabResult);
    }

    public interface QueryInventoryFinishedListener {
        void onQueryInventoryFinished(IabResult iabResult, Inventory inventory);
    }

    public IabHelper(Context ctx, String base64PublicKey) {
        logDebug("IAB helper creating.");
        this.mContext = ctx.getApplicationContext();
        this.mSignatureBase64 = base64PublicKey;
        logDebug("IAB helper created.");
    }

    public void enableDebugLogging(boolean enable, String tag) {
        this.mDebugLog = enable;
        this.mDebugTag = tag;
    }

    public void enableDebugLogging(boolean enable) {
        this.mDebugLog = enable;
    }

    public void startSetup(final OnIabSetupFinishedListener listener) {
        if (this.mSetupDone) {
            throw new IllegalStateException("IAB helper is already set up.");
        }
        logDebug("Starting in-app billing setup.");
        this.mServiceConn = new ServiceConnection() {
            public void onServiceDisconnected(ComponentName name) {
                IabHelper.this.logDebug("Billing service disconnected.");
                IabHelper.this.mService = null;
            }

            public void onServiceConnected(ComponentName name, IBinder service) {
                IabHelper.this.logDebug("Billing service connected.");
                IabHelper.this.mService = Stub.asInterface(service);
                String packageName = IabHelper.this.mContext.getPackageName();
                try {
                    IabHelper.this.logDebug("Checking for in-app billing 3 support.");
                    int response = IabHelper.this.mService.isBillingSupported(3, packageName, IabHelper.ITEM_TYPE_INAPP);
                    if (response != 0) {
                        if (listener != null) {
                            listener.onIabSetupFinished(new IabResult(response, "Error checking for billing v3 support."));
                        }
                        IabHelper.this.mSubscriptionsSupported = false;
                        return;
                    }
                    IabHelper.this.logDebug("In-app billing version 3 supported for " + packageName);
                    response = IabHelper.this.mService.isBillingSupported(3, packageName, IabHelper.ITEM_TYPE_SUBS);
                    if (response == 0) {
                        IabHelper.this.logDebug("Subscriptions AVAILABLE.");
                        IabHelper.this.mSubscriptionsSupported = true;
                    } else {
                        IabHelper.this.logDebug("Subscriptions NOT AVAILABLE. Response: " + response);
                    }
                    IabHelper.this.mSetupDone = true;
                    if (listener != null) {
                        listener.onIabSetupFinished(new IabResult(0, "Setup successful."));
                    }
                } catch (RemoteException e) {
                    if (listener != null) {
                        listener.onIabSetupFinished(new IabResult(IabHelper.IABHELPER_REMOTE_EXCEPTION, "RemoteException while setting up in-app billing."));
                    }
                    e.printStackTrace();
                }
            }
        };
        Intent serviceIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        if (!this.mContext.getPackageManager().queryIntentServices(serviceIntent, 0).isEmpty()) {
            this.mContext.bindService(serviceIntent, this.mServiceConn, 1);
        } else if (listener != null) {
            listener.onIabSetupFinished(new IabResult(3, "Billing service unavailable on device."));
        }
    }

    public void dispose() {
        logDebug("Disposing.");
        this.mSetupDone = false;
        if (this.mServiceConn != null) {
            logDebug("Unbinding from service.");
            if (this.mContext != null) {
                this.mContext.unbindService(this.mServiceConn);
            }
            this.mServiceConn = null;
            this.mService = null;
            this.mPurchaseListener = null;
        }
    }

    public boolean subscriptionsSupported() {
        return this.mSubscriptionsSupported;
    }

    public void launchPurchaseFlow(Activity act, String sku, int requestCode, OnIabPurchaseFinishedListener listener) {
        launchPurchaseFlow(act, sku, requestCode, listener, "");
    }

    public void launchPurchaseFlow(Activity act, String sku, int requestCode, OnIabPurchaseFinishedListener listener, String extraData) {
        launchPurchaseFlow(act, sku, ITEM_TYPE_INAPP, requestCode, listener, extraData);
    }

    public void launchSubscriptionPurchaseFlow(Activity act, String sku, int requestCode, OnIabPurchaseFinishedListener listener) {
        launchSubscriptionPurchaseFlow(act, sku, requestCode, listener, "");
    }

    public void launchSubscriptionPurchaseFlow(Activity act, String sku, int requestCode, OnIabPurchaseFinishedListener listener, String extraData) {
        launchPurchaseFlow(act, sku, ITEM_TYPE_SUBS, requestCode, listener, extraData);
    }

    public void launchPurchaseFlow(Activity act, String sku, String itemType, int requestCode, OnIabPurchaseFinishedListener listener, String extraData) {
        checkSetupDone("launchPurchaseFlow");
        flagStartAsync("launchPurchaseFlow");
        if (!itemType.equals(ITEM_TYPE_SUBS) || this.mSubscriptionsSupported) {
            IabResult result;
            try {
                logDebug("Constructing buy intent for " + sku + ", item type: " + itemType + " package " + this.mContext.getPackageName() + " extra " + extraData);
                Bundle buyIntentBundle = this.mService.getBuyIntent(3, this.mContext.getPackageName(), sku, itemType, extraData);
                int response = getResponseCodeFromBundle(buyIntentBundle);
                if (response != 0) {
                    logError("Unable to buy item, Error response: " + getResponseDesc(response));
                    result = new IabResult(response, "Unable to buy item");
                    flagEndAsync();
                    if (listener != null) {
                        listener.onIabPurchaseFinished(result, null);
                        return;
                    }
                    return;
                }
                PendingIntent pendingIntent = (PendingIntent) buyIntentBundle.getParcelable(RESPONSE_BUY_INTENT);
                logDebug("Launching buy intent for " + sku + ". Request code: " + requestCode + "  activity name " + act.getClass().getSimpleName());
                this.mRequestCode = requestCode;
                this.mPurchaseListener = listener;
                this.mPurchasingItemType = itemType;
                act.startIntentSenderForResult(pendingIntent.getIntentSender(), requestCode, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
                return;
            } catch (SendIntentException e) {
                logError("SendIntentException while launching purchase flow for sku " + sku);
                e.printStackTrace();
                result = new IabResult(IABHELPER_SEND_INTENT_FAILED, "Failed to send intent.");
                if (listener != null) {
                    listener.onIabPurchaseFinished(result, null);
                    return;
                }
                return;
            } catch (RemoteException e2) {
                logError("RemoteException while launching purchase flow for sku " + sku);
                e2.printStackTrace();
                result = new IabResult(IABHELPER_REMOTE_EXCEPTION, "Remote exception while starting purchase flow");
                if (listener != null) {
                    listener.onIabPurchaseFinished(result, null);
                    return;
                }
                return;
            }
        }
        IabResult r = new IabResult(IABHELPER_SUBSCRIPTIONS_NOT_AVAILABLE, "Subscriptions are not available.");
        if (listener != null) {
            listener.onIabPurchaseFinished(r, null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x015e  */
    public boolean handleActivityResult(int r13, int r14, Intent r15) {
        /*
        r12 = this;
        r8 = r12.mRequestCode;
        if (r13 == r8) goto L_0x0006;
    L_0x0004:
        r8 = 0;
    L_0x0005:
        return r8;
    L_0x0006:
        r8 = "handleActivityResult";
        r12.checkSetupDone(r8);
        r12.flagEndAsync();
        if (r15 != 0) goto L_0x002a;
    L_0x0010:
        r8 = "Null data in IAB activity result.";
        r12.logError(r8);
        r6 = new com.market.IabResult;
        r8 = -1002; // 0xfffffffffffffc16 float:NaN double:NaN;
        r9 = "Null data in IAB result";
        r6.<init>(r8, r9);
        r8 = r12.mPurchaseListener;
        if (r8 == 0) goto L_0x0028;
    L_0x0022:
        r8 = r12.mPurchaseListener;
        r9 = 0;
        r8.onIabPurchaseFinished(r6, r9);
    L_0x0028:
        r8 = 1;
        goto L_0x0005;
    L_0x002a:
        r5 = r12.getResponseCodeFromIntent(r15);
        r8 = "INAPP_PURCHASE_DATA";
        r4 = r15.getStringExtra(r8);
        r8 = "INAPP_DATA_SIGNATURE";
        r0 = r15.getStringExtra(r8);
        r8 = -1;
        if (r14 != r8) goto L_0x0167;
    L_0x003d:
        if (r5 != 0) goto L_0x0167;
    L_0x003f:
        r8 = "Successful resultcode from purchase activity.";
        r12.logDebug(r8);
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "Purchase data: ";
        r8 = r8.append(r9);
        r8 = r8.append(r4);
        r8 = r8.toString();
        r12.logDebug(r8);
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "Data signature: ";
        r8 = r8.append(r9);
        r8 = r8.append(r0);
        r8 = r8.toString();
        r12.logDebug(r8);
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "Extras: ";
        r8 = r8.append(r9);
        r9 = r15.getExtras();
        r8 = r8.append(r9);
        r8 = r8.toString();
        r12.logDebug(r8);
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "Expected item type: ";
        r8 = r8.append(r9);
        r9 = r12.mPurchasingItemType;
        r8 = r8.append(r9);
        r8 = r8.toString();
        r12.logDebug(r8);
        if (r4 == 0) goto L_0x00a6;
    L_0x00a4:
        if (r0 != 0) goto L_0x00df;
    L_0x00a6:
        r8 = "BUG: either purchaseData or dataSignature is null.";
        r12.logError(r8);
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "Extras: ";
        r8 = r8.append(r9);
        r9 = r15.getExtras();
        r9 = r9.toString();
        r8 = r8.append(r9);
        r8 = r8.toString();
        r12.logDebug(r8);
        r6 = new com.market.IabResult;
        r8 = -1008; // 0xfffffffffffffc10 float:NaN double:NaN;
        r9 = "IAB returned null purchaseData or dataSignature";
        r6.<init>(r8, r9);
        r8 = r12.mPurchaseListener;
        if (r8 == 0) goto L_0x00dc;
    L_0x00d6:
        r8 = r12.mPurchaseListener;
        r9 = 0;
        r8.onIabPurchaseFinished(r6, r9);
    L_0x00dc:
        r8 = 1;
        goto L_0x0005;
    L_0x00df:
        r2 = 0;
        r3 = new com.market.Purchase;	 Catch:{ JSONException -> 0x0148 }
        r8 = r12.mPurchasingItemType;	 Catch:{ JSONException -> 0x0148 }
        r3.<init>(r8, r4, r0);	 Catch:{ JSONException -> 0x0148 }
        r7 = r3.getSku();	 Catch:{ JSONException -> 0x0203 }
        r8 = r12.mSignatureBase64;	 Catch:{ JSONException -> 0x0203 }
        r8 = com.market.Security.verifyPurchase(r8, r4, r0);	 Catch:{ JSONException -> 0x0203 }
        if (r8 != 0) goto L_0x012f;
    L_0x00f3:
        r8 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x0203 }
        r8.<init>();	 Catch:{ JSONException -> 0x0203 }
        r9 = "Purchase signature verification FAILED for sku ";
        r8 = r8.append(r9);	 Catch:{ JSONException -> 0x0203 }
        r8 = r8.append(r7);	 Catch:{ JSONException -> 0x0203 }
        r8 = r8.toString();	 Catch:{ JSONException -> 0x0203 }
        r12.logError(r8);	 Catch:{ JSONException -> 0x0203 }
        r6 = new com.market.IabResult;	 Catch:{ JSONException -> 0x0203 }
        r8 = -1003; // 0xfffffffffffffc15 float:NaN double:NaN;
        r9 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x0203 }
        r9.<init>();	 Catch:{ JSONException -> 0x0203 }
        r10 = "Signature verification failed for sku ";
        r9 = r9.append(r10);	 Catch:{ JSONException -> 0x0203 }
        r9 = r9.append(r7);	 Catch:{ JSONException -> 0x0203 }
        r9 = r9.toString();	 Catch:{ JSONException -> 0x0203 }
        r6.<init>(r8, r9);	 Catch:{ JSONException -> 0x0203 }
        r8 = r12.mPurchaseListener;	 Catch:{ JSONException -> 0x0203 }
        if (r8 == 0) goto L_0x012c;
    L_0x0127:
        r8 = r12.mPurchaseListener;	 Catch:{ JSONException -> 0x0203 }
        r8.onIabPurchaseFinished(r6, r3);	 Catch:{ JSONException -> 0x0203 }
    L_0x012c:
        r8 = 1;
        goto L_0x0005;
    L_0x012f:
        r8 = "Purchase signature successfully verified.";
        r12.logDebug(r8);	 Catch:{ JSONException -> 0x0203 }
        r8 = r12.mPurchaseListener;
        if (r8 == 0) goto L_0x0145;
    L_0x0138:
        r8 = r12.mPurchaseListener;
        r9 = new com.market.IabResult;
        r10 = 0;
        r11 = "Success";
        r9.<init>(r10, r11);
        r8.onIabPurchaseFinished(r9, r3);
    L_0x0145:
        r8 = 1;
        goto L_0x0005;
    L_0x0148:
        r1 = move-exception;
    L_0x0149:
        r8 = "Failed to parse purchase data.";
        r12.logError(r8);
        r1.printStackTrace();
        r6 = new com.market.IabResult;
        r8 = -1002; // 0xfffffffffffffc16 float:NaN double:NaN;
        r9 = "Failed to parse purchase data.";
        r6.<init>(r8, r9);
        r8 = r12.mPurchaseListener;
        if (r8 == 0) goto L_0x0164;
    L_0x015e:
        r8 = r12.mPurchaseListener;
        r9 = 0;
        r8.onIabPurchaseFinished(r6, r9);
    L_0x0164:
        r8 = 1;
        goto L_0x0005;
    L_0x0167:
        r8 = -1;
        if (r14 != r8) goto L_0x0196;
    L_0x016a:
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "Result code was OK but in-app billing response was not OK: ";
        r8 = r8.append(r9);
        r9 = getResponseDesc(r5);
        r8 = r8.append(r9);
        r8 = r8.toString();
        r12.logDebug(r8);
        r8 = r12.mPurchaseListener;
        if (r8 == 0) goto L_0x0145;
    L_0x0188:
        r6 = new com.market.IabResult;
        r8 = "Problem purchashing item.";
        r6.<init>(r5, r8);
        r8 = r12.mPurchaseListener;
        r9 = 0;
        r8.onIabPurchaseFinished(r6, r9);
        goto L_0x0145;
    L_0x0196:
        if (r14 != 0) goto L_0x01c6;
    L_0x0198:
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "Purchase canceled - Response: ";
        r8 = r8.append(r9);
        r9 = getResponseDesc(r5);
        r8 = r8.append(r9);
        r8 = r8.toString();
        r12.logDebug(r8);
        r6 = new com.market.IabResult;
        r8 = -1005; // 0xfffffffffffffc13 float:NaN double:NaN;
        r9 = "User canceled.";
        r6.<init>(r8, r9);
        r8 = r12.mPurchaseListener;
        if (r8 == 0) goto L_0x0145;
    L_0x01bf:
        r8 = r12.mPurchaseListener;
        r9 = 0;
        r8.onIabPurchaseFinished(r6, r9);
        goto L_0x0145;
    L_0x01c6:
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "Purchase failed. Result code: ";
        r8 = r8.append(r9);
        r9 = java.lang.Integer.toString(r14);
        r8 = r8.append(r9);
        r9 = ". Response: ";
        r8 = r8.append(r9);
        r9 = getResponseDesc(r5);
        r8 = r8.append(r9);
        r8 = r8.toString();
        r12.logError(r8);
        r6 = new com.market.IabResult;
        r8 = -1006; // 0xfffffffffffffc12 float:NaN double:NaN;
        r9 = "Unknown purchase response.";
        r6.<init>(r8, r9);
        r8 = r12.mPurchaseListener;
        if (r8 == 0) goto L_0x0145;
    L_0x01fb:
        r8 = r12.mPurchaseListener;
        r9 = 0;
        r8.onIabPurchaseFinished(r6, r9);
        goto L_0x0145;
    L_0x0203:
        r1 = move-exception;
        r2 = r3;
        goto L_0x0149;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.market.IabHelper.handleActivityResult(int, int, android.content.Intent):boolean");
    }

    public Inventory queryInventory(boolean querySkuDetails, List<String> moreSkus) throws IabException {
        return queryInventory(querySkuDetails, moreSkus, null);
    }

    public Inventory queryInventory(boolean querySkuDetails, List<String> moreItemSkus, List<String> list) throws IabException {
        checkSetupDone("queryInventory");
        try {
            Inventory inv = new Inventory();
            int r = queryPurchases(inv, ITEM_TYPE_INAPP);
            if (r != 0) {
                throw new IabException(r, "Error refreshing inventory (querying owned items).");
            }
            if (querySkuDetails) {
                r = querySkuDetails(ITEM_TYPE_INAPP, inv, moreItemSkus);
                if (r != 0) {
                    throw new IabException(r, "Error refreshing inventory (querying prices of items).");
                }
            }
            if (this.mSubscriptionsSupported) {
                r = queryPurchases(inv, ITEM_TYPE_SUBS);
                if (r != 0) {
                    throw new IabException(r, "Error refreshing inventory (querying owned subscriptions).");
                } else if (querySkuDetails) {
                    r = querySkuDetails(ITEM_TYPE_SUBS, inv, moreItemSkus);
                    if (r != 0) {
                        throw new IabException(r, "Error refreshing inventory (querying prices of subscriptions).");
                    }
                }
            }
            return inv;
        } catch (RemoteException e) {
            throw new IabException(IABHELPER_REMOTE_EXCEPTION, "Remote exception while refreshing inventory.", e);
        } catch (JSONException e2) {
            throw new IabException(IABHELPER_BAD_RESPONSE, "Error parsing JSON response while refreshing inventory.", e2);
        }
    }

    public void queryInventoryAsync(boolean querySkuDetails, List<String> moreSkus, QueryInventoryFinishedListener listener) {
        final Handler handler = new Handler();
        checkSetupDone("queryInventory");
        flagStartAsync("refresh inventory");
        final boolean z = querySkuDetails;
        final List<String> list = moreSkus;
        final QueryInventoryFinishedListener queryInventoryFinishedListener = listener;
        new Thread(new Runnable() {
            public void run() {
                IabResult result = new IabResult(0, "Inventory refresh successful.");
                Inventory inv = null;
                try {
                    inv = IabHelper.this.queryInventory(z, list);
                } catch (IabException ex) {
                    result = ex.getResult();
                }
                IabHelper.this.flagEndAsync();
                final IabResult result_f = result;
                final Inventory inv_f = inv;
                handler.post(new Runnable() {
                    public void run() {
                        queryInventoryFinishedListener.onQueryInventoryFinished(result_f, inv_f);
                    }
                });
            }
        }).start();
    }

    public void queryInventoryAsync(QueryInventoryFinishedListener listener) {
        queryInventoryAsync(true, null, listener);
    }

    public void queryInventoryAsync(boolean querySkuDetails, QueryInventoryFinishedListener listener) {
        queryInventoryAsync(querySkuDetails, null, listener);
    }

    void consume(Purchase itemInfo) throws IabException {
        checkSetupDone("consume");
        if (itemInfo.mItemType.equals(ITEM_TYPE_INAPP)) {
            try {
                String token = itemInfo.getToken();
                String sku = itemInfo.getSku();
                if (token == null || token.equals("")) {
                    logError("Can't consume " + sku + ". No token.");
                    throw new IabException((int) IABHELPER_MISSING_TOKEN, "PurchaseInfo is missing token for sku: " + sku + " " + itemInfo);
                }
                logDebug("Consuming sku: " + sku + ", token: " + token);
                int response = this.mService.consumePurchase(3, this.mContext.getPackageName(), token);
                if (response == 0) {
                    logDebug("Successfully consumed sku: " + sku);
                    return;
                } else {
                    logDebug("Error consuming consuming sku " + sku + ". " + getResponseDesc(response));
                    throw new IabException(response, "Error consuming sku " + sku);
                }
            } catch (RemoteException e) {
                throw new IabException(IABHELPER_REMOTE_EXCEPTION, "Remote exception while consuming. PurchaseInfo: " + itemInfo, e);
            }
        }
        throw new IabException((int) IABHELPER_INVALID_CONSUMPTION, "Items of type '" + itemInfo.mItemType + "' can't be consumed.");
    }

    public void consumeAsync(Purchase purchase, OnConsumeFinishedListener listener) {
        checkSetupDone("consume");
        List<Purchase> purchases = new ArrayList();
        purchases.add(purchase);
        consumeAsyncInternal(purchases, listener, null);
    }

    public void consumeAsync(List<Purchase> purchases, OnConsumeMultiFinishedListener listener) {
        checkSetupDone("consume");
        consumeAsyncInternal(purchases, null, listener);
    }

    public static String getResponseDesc(int code) {
        String[] iab_msgs = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
        String[] iabhelper_msgs = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
        if (code <= IABHELPER_ERROR_BASE) {
            int index = -1000 - code;
            if (index < 0 || index >= iabhelper_msgs.length) {
                return String.valueOf(code) + ":Unknown IAB Helper Error";
            }
            return iabhelper_msgs[index];
        } else if (code < 0 || code >= iab_msgs.length) {
            return String.valueOf(code) + ":Unknown";
        } else {
            return iab_msgs[code];
        }
    }

    void checkSetupDone(String operation) {
        if (!this.mSetupDone) {
            logError("Illegal state for operation (" + operation + "): IAB helper is not set up.");
            throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + operation);
        }
    }

    int getResponseCodeFromBundle(Bundle b) {
        Object o = b.get("RESPONSE_CODE");
        if (o == null) {
            logDebug("Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (o instanceof Integer) {
            return ((Integer) o).intValue();
        } else {
            if (o instanceof Long) {
                return (int) ((Long) o).longValue();
            }
            logError("Unexpected type for bundle response code.");
            logError(o.getClass().getName());
            throw new RuntimeException("Unexpected type for bundle response code: " + o.getClass().getName());
        }
    }

    int getResponseCodeFromIntent(Intent i) {
        Object o = i.getExtras().get("RESPONSE_CODE");
        if (o == null) {
            logError("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (o instanceof Integer) {
            return ((Integer) o).intValue();
        } else {
            if (o instanceof Long) {
                return (int) ((Long) o).longValue();
            }
            logError("Unexpected type for intent response code.");
            logError(o.getClass().getName());
            throw new RuntimeException("Unexpected type for intent response code: " + o.getClass().getName());
        }
    }

    void flagStartAsync(String operation) {
        if (this.mAsyncInProgress) {
            throw new IllegalStateException("Can't start async operation (" + operation + ") because another async operation(" + this.mAsyncOperation + ") is in progress.");
        }
        this.mAsyncOperation = operation;
        this.mAsyncInProgress = true;
        logDebug("Starting async operation: " + operation);
    }

    void flagEndAsync() {
        logDebug("Ending async operation: " + this.mAsyncOperation);
        this.mAsyncOperation = "";
        this.mAsyncInProgress = false;
    }

    int queryPurchases(Inventory inv, String itemType) throws JSONException, RemoteException {
        logDebug("Querying owned items, item type: " + itemType);
        logDebug("Package name: " + this.mContext.getPackageName());
        boolean verificationFailed = false;
        String continueToken = null;
        do {
            logDebug("Calling getPurchases with continuation token: " + continueToken);
            Bundle ownedItems = this.mService.getPurchases(3, this.mContext.getPackageName(), itemType, continueToken);
            int response = getResponseCodeFromBundle(ownedItems);
            logDebug("Owned items response: " + String.valueOf(response));
            if (response != 0) {
                logDebug("getPurchases() failed: " + getResponseDesc(response));
                return response;
            } else if (ownedItems.containsKey(RESPONSE_INAPP_ITEM_LIST) && ownedItems.containsKey(RESPONSE_INAPP_PURCHASE_DATA_LIST) && ownedItems.containsKey(RESPONSE_INAPP_SIGNATURE_LIST)) {
                ArrayList<String> ownedSkus = ownedItems.getStringArrayList(RESPONSE_INAPP_ITEM_LIST);
                ArrayList<String> purchaseDataList = ownedItems.getStringArrayList(RESPONSE_INAPP_PURCHASE_DATA_LIST);
                ArrayList<String> signatureList = ownedItems.getStringArrayList(RESPONSE_INAPP_SIGNATURE_LIST);
                for (int i = 0; i < purchaseDataList.size(); i++) {
                    String purchaseData = (String) purchaseDataList.get(i);
                    String signature = (String) signatureList.get(i);
                    String sku = (String) ownedSkus.get(i);
                    if (Security.verifyPurchase(this.mSignatureBase64, purchaseData, signature)) {
                        logDebug("Sku is owned: " + sku);
                        Purchase purchase = new Purchase(itemType, purchaseData, signature);
                        if (TextUtils.isEmpty(purchase.getToken())) {
                            logWarn("BUG: empty/null token!");
                            logDebug("Purchase data: " + purchaseData);
                        }
                        inv.addPurchase(purchase);
                    } else {
                        logWarn("Purchase signature verification **FAILED**. Not adding item.");
                        logDebug("   Purchase data: " + purchaseData);
                        logDebug("   Signature: " + signature);
                        verificationFailed = true;
                    }
                }
                continueToken = ownedItems.getString(INAPP_CONTINUATION_TOKEN);
                logDebug("Continuation token: " + continueToken);
            } else {
                logError("Bundle returned from getPurchases() doesn't contain required fields.");
                return IABHELPER_BAD_RESPONSE;
            }
        } while (!TextUtils.isEmpty(continueToken));
        return verificationFailed ? IABHELPER_VERIFICATION_FAILED : 0;
    }

    int querySkuDetails(String itemType, Inventory inv, List<String> moreSkus) throws RemoteException, JSONException {
        logDebug("Querying SKU details.");
        ArrayList<String> skuList = new ArrayList();
        skuList.addAll(inv.getAllOwnedSkus(itemType));
        if (moreSkus != null) {
            skuList.addAll(moreSkus);
        }
        if (skuList.size() == 0) {
            logDebug("queryPrices: nothing to do because there are no SKUs.");
            return 0;
        }
        Bundle querySkus = new Bundle();
        querySkus.putStringArrayList(GET_SKU_DETAILS_ITEM_LIST, skuList);
        Bundle skuDetails = this.mService.getSkuDetails(3, this.mContext.getPackageName(), itemType, querySkus);
        if (skuDetails.containsKey(RESPONSE_GET_SKU_DETAILS_LIST)) {
            Iterator i$ = skuDetails.getStringArrayList(RESPONSE_GET_SKU_DETAILS_LIST).iterator();
            while (i$.hasNext()) {
                SkuDetails d = new SkuDetails(itemType, (String) i$.next());
                logDebug("Got sku details: " + d);
                inv.addSkuDetails(d);
            }
            return 0;
        }
        int response = getResponseCodeFromBundle(skuDetails);
        if (response != 0) {
            logDebug("getSkuDetails() failed: " + getResponseDesc(response));
            return response;
        }
        logError("getSkuDetails() returned a bundle with neither an error nor a detail list.");
        return IABHELPER_BAD_RESPONSE;
    }

    void consumeAsyncInternal(List<Purchase> purchases, OnConsumeFinishedListener singleListener, OnConsumeMultiFinishedListener multiListener) {
        final Handler handler = new Handler();
        flagStartAsync("consume");
        final List<Purchase> list = purchases;
        final OnConsumeFinishedListener onConsumeFinishedListener = singleListener;
        final OnConsumeMultiFinishedListener onConsumeMultiFinishedListener = multiListener;
        new Thread(new Runnable() {
            public void run() {
                final List<IabResult> results = new ArrayList();
                for (Purchase purchase : list) {
                    try {
                        IabHelper.this.consume(purchase);
                        results.add(new IabResult(0, "Successful consume of sku " + purchase.getSku()));
                    } catch (IabException ex) {
                        results.add(ex.getResult());
                    }
                }
                IabHelper.this.flagEndAsync();
                if (onConsumeFinishedListener != null) {
                    handler.post(new Runnable() {
                        public void run() {
                            onConsumeFinishedListener.onConsumeFinished((Purchase) list.get(0), (IabResult) results.get(0));
                        }
                    });
                }
                if (onConsumeMultiFinishedListener != null) {
                    handler.post(new Runnable() {
                        public void run() {
                            onConsumeMultiFinishedListener.onConsumeMultiFinished(list, results);
                        }
                    });
                }
            }
        }).start();
    }

    void logDebug(String msg) {
        if (this.mDebugLog) {
            Log.d(this.mDebugTag, msg);
        }
    }

    void logError(String msg) {
        Log.e(this.mDebugTag, "In-app billing error: " + msg);
    }

    void logWarn(String msg) {
        Log.w(this.mDebugTag, "In-app billing warning: " + msg);
    }
}
