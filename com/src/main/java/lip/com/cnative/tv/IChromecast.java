package lip.com.cnative.tv;

import android.view.KeyEvent;

public interface IChromecast {
    boolean dispatchKeyEvent(KeyEvent keyEvent);

    long getCurrentMediaPosition();

    long getMediaDuration();

    INativeMRB getMediaRouteButton();

    int getPlaybackStatus();

    double getVolume();

    void onDestroy();

    void onPause();

    void onResume();

    void pause();

    void play();

    void setContentData(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z);

    void setMediaPosition(int i);

    void setVolume(double d);

    void showDialogThreadWrapper();

    void stop();
}
