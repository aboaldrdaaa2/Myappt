package lip.com.crystalnative.tv;

import android.app.Activity;

interface IIMA {
    void destroy();

    void requestAd(String str);

    void setImaUIActivity(Activity activity);

    void start();

    void stop();
}
