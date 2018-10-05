package lip.com.cnative.tv;

import android.content.Intent;

interface IPlayBilling {
    int canMakePurchase();

    int getResponseCode(Intent intent);

    boolean handleActivityResult(int i, int i2, Intent intent);

    void performPurchaseSubscription(String str);

    void restoreTransaction();

    void startHelper();
}
