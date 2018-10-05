package lip.com.cnative.tv;

import android.content.Intent;
import android.os.Bundle;

interface IFacebookSN {
    boolean LoggedIn();

    void Login(int i);

    void Logout(int i);

    void PostNews(int i, String str, String str2, String str3, String str4, String str5);

    void PostNewsAutoLogin(int i, String str, String str2, String str3, String str4, String str5);

    void PostStory(int i, String str, String str2, String str3, String str4);

    void PostUserStatus(int i, String str);

    void onActivityResult(int i, int i2, Intent intent);

    void onCreate(Bundle bundle);

    void onDestroy();

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle bundle);
}
