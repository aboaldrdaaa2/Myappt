package lip.com.cnative.tv;

import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKSdk;
import com.vk.sdk.VKSdkListener;
import com.vk.sdk.VKUIHelper;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKRequest.VKRequestListener;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKApiLink;
import com.vk.sdk.api.model.VKApiPhoto;
import com.vk.sdk.api.model.VKAttachments;
import com.vk.sdk.api.model.VKAttachments.VKApiAttachment;
import com.vk.sdk.api.model.VKPhotoArray;
import com.vk.sdk.api.model.VKWallPostResult;
import com.vk.sdk.api.photo.VKImageParameters;
import com.vk.sdk.api.photo.VKUploadImage;
import com.vk.sdk.dialogs.VKCaptchaDialog;
import com.vk.sdk.util.VKUtil;
import java.net.URL;

public class VkSN implements IVkSN {
    public static final String TAG = "VkSN";
    private static String mAppID = "4543864";
    private static String[] mScope = new String[]{"wall", "photos", "status"};
    private static String mTokenKey = "VK_ACCESS_TOKEN";
    private TvCoreActivity m_activity;
    VKSdkListener m_listener = new VkSNListener(this, null);
    int m_loginSign = 0;
    int m_logoutSign = 0;
    int m_pnSign = 0;
    int m_pnalSign = 0;
    int m_puSign = 0;

    class DownloadPictureURL extends AsyncTask<String, String, String> {
        public String m_description;
        public String m_link;
        public String m_pictureUrl;
        public int m_pnSign;

        DownloadPictureURL() {
        }

        protected String doInBackground(String... param) {
            try {
                Log.i("VkSN", "PostNews: url: " + this.m_pictureUrl);
                VKUploadImage image = new VKUploadImage(BitmapFactory.decodeStream(new URL(this.m_pictureUrl).openStream()), VKImageParameters.pngImage());
                if (image == null || image.getTmpFile().length() <= 0) {
                    Log.e("VkSN", "PostNews: Error: Can't get picture by url");
                    VkSN.this.PostNewsError(this.m_pnSign, "Can't get picture by url");
                } else {
                    VKApi.uploadWallPhotoRequest(image, 0, 0).executeWithListener(new VKRequestListener() {
                        String mLink = DownloadPictureURL.this.m_link;
                        String mMessage = DownloadPictureURL.this.m_description;
                        int mSign = DownloadPictureURL.this.m_pnSign;

                        public void onComplete(VKResponse response) {
                            Log.i("VkSN", "PostNews: uploadWallPhotoRequest: complete");
                            new VKAttachments(new VKApiAttachment[]{(VKApiPhoto) ((VKPhotoArray) response.parsedModel).get(0)}).add(new VKApiLink(this.mLink));
                            VKRequest post = VKApi.wall().post(VKParameters.from(new Object[]{"attachments", attachments, "message", this.mMessage}));
                            post.setModelClass(VKWallPostResult.class);
                            post.executeWithListener(new VKRequestListener() {
                                public void onComplete(VKResponse response) {
                                    super.onComplete(response);
                                    Log.i("VkSN", "PostNews: post: complete: " + response.parsedModel.post_id);
                                    VkSN.this.PostNewsSuccess(AnonymousClass1.this.mSign);
                                }

                                public void onError(VKError error) {
                                    Log.e("VkSN", "PostNews: post: error: code " + error.errorCode);
                                    if (error.errorCode == -101) {
                                        Log.e("VkSN", "PostNews: post: api error: " + error.apiError.errorMessage);
                                        VkSN.this.PostNewsError(AnonymousClass1.this.mSign, error.apiError.errorMessage);
                                        return;
                                    }
                                    Log.e("VkSN", "PostNews: post: http error: " + error.httpError);
                                    VkSN.this.PostNewsError(AnonymousClass1.this.mSign, "Http error, code: " + error.errorCode);
                                }
                            });
                        }

                        public void onError(VKError error) {
                            Log.e("VkSN", "PostNews: uploadWallPhotoRequest: error: code " + error.errorCode);
                            if (error.errorCode == -101) {
                                Log.e("VkSN", "PostNews: uploadWallPhotoRequest: api error: " + error.apiError.errorMessage);
                                VkSN.this.PostNewsError(this.mSign, error.apiError.errorMessage);
                                return;
                            }
                            Log.e("VkSN", "PostNews: uploadWallPhotoRequest: http error: " + error.httpError);
                            VkSN.this.PostNewsError(this.mSign, "Http error, code: " + error.errorCode);
                        }

                        public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts) {
                            Log.e("VkSN", "PostNews: uploadWallPhotoRequest: Attempt to " + attemptNumber + " of " + totalAttempts + "is failed");
                        }
                    });
                }
            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
                VkSN.this.PostNewsError(this.m_pnSign, e.getMessage());
            }
            return null;
        }

        protected void onPostExecute(String file_url) {
            Log.i("VkSN", "DownloadPictureURL: onPostExecute");
        }
    }

    private class VkSNListener extends VKSdkListener {
        private VkSNListener() {
        }

        /* synthetic */ VkSNListener(VkSN x0, AnonymousClass1 x1) {
            this();
        }

        public void onReceiveNewToken(VKAccessToken newToken) {
            Log.i("VkSN", "onReceiveNewToken: " + newToken);
            newToken.saveTokenToSharedPreferences(VkSN.this.m_activity, VkSN.mTokenKey);
            super.onReceiveNewToken(newToken);
            VkSN.this.SuccessLogin(VkSN.this.m_loginSign);
        }

        public void onAccessDenied(VKError authorizationError) {
            Log.i("VkSN", "onAccessDenied: " + authorizationError.errorReason);
            VkSN.this.LoginIsFailed(VkSN.this.m_loginSign, authorizationError.errorReason == null ? "" : authorizationError.errorReason);
        }

        public void onAcceptUserToken(VKAccessToken token) {
            Log.i("VkSN", "onAcceptUserToken: " + token);
            super.onAcceptUserToken(token);
        }

        public void onCaptchaError(VKError captchaError) {
            Log.e("VkSN", "onCaptchaError: " + captchaError.errorMessage);
            new VKCaptchaDialog(captchaError).show();
        }

        public void onRenewAccessToken(VKAccessToken token) {
            Log.i("VkSN", "onRenewAccessToken: " + token);
            super.onRenewAccessToken(token);
        }

        public void onTokenExpired(VKAccessToken expiredToken) {
            Log.i("VkSN", "onTokenExpired: " + expiredToken);
            VKSdk.authorize(VkSN.mScope);
        }
    }

    private native void LoginIsFailed(int i, String str);

    private native void PostNewsError(int i, String str);

    private native void PostNewsSuccess(int i);

    private native void PostUserStatusError(int i, String str);

    private native void PostUserStatusSuccess(int i);

    private native void SuccessLogin(int i);

    private native void SuccessLogout(int i);

    public void Init() {
        Log.i("VkSN", "Init");
        try {
            mAppID = this.m_activity.getPackageManager().getApplicationInfo(this.m_activity.getPackageName(), 128).metaData.getString("com.vk.sdk.ApplicationId");
            Log.i("VkSN", "Init: " + mAppID);
            VKSdk.initialize(this.m_listener, mAppID, VKAccessToken.tokenFromSharedPreferences(this.m_activity, mTokenKey));
        } catch (NameNotFoundException e) {
            Log.e("VkSN", "onCreate: exception! VK module doesn't work!");
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        Log.i("VkSN", "onCreate");
        VKUIHelper.onCreate(this.m_activity);
    }

    public void onDestroy() {
        Log.i("VkSN", "onDestroy");
        VKUIHelper.onDestroy(this.m_activity);
    }

    public void onResume() {
        Log.i("VkSN", "onResume");
        VKUIHelper.onResume(this.m_activity);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("VkSN", "onActivityResult(" + requestCode + "," + resultCode + "," + data);
        VKUIHelper.onActivityResult(this.m_activity, requestCode, resultCode, data);
    }

    public void onPause() {
        Log.i("VkSN", "onPause");
    }

    public void onSaveInstanceState(Bundle outState) {
        Log.i("VkSN", "onSaveInstanceState");
    }

    public VkSN(TvCoreActivity activity) {
        Log.i("VkSN", "Creating VkSN");
        this.m_activity = activity;
        try {
            for (String s : VKUtil.getCertificateFingerprint(activity, "com.crystalreality.crystaltvplus")) {
                Log.i("FingerPrints", s);
            }
        } catch (Throwable th) {
            Log.e("FingerPrints", "Exception");
        }
    }

    public void Login(int sign) {
        this.m_loginSign = sign;
        VKSdk.authorize(mScope, false, false);
    }

    public boolean LoggedIn() {
        return VKSdk.isLoggedIn();
    }

    public void Logout(int sign) {
        this.m_logoutSign = sign;
        VKSdk.logout();
        SuccessLogout(this.m_logoutSign);
    }

    public void PostUserStatus(int sign, String userStatus) {
        this.m_puSign = sign;
        new VKRequest("status.set", VKParameters.from(new Object[]{"text", userStatus})).executeWithListener(new VKRequestListener() {
            int mSign = VkSN.this.m_puSign;

            public void onComplete(VKResponse response) {
                Log.i("VkSN", "PostUserStatus: complete");
                VkSN.this.PostUserStatusSuccess(this.mSign);
            }

            public void onError(VKError error) {
                Log.e("VkSN", "PostUserStatus: error: code " + error.errorCode);
                if (error.errorCode == -101) {
                    Log.e("VkSN", "PostUserStatus: api error: " + error.apiError.errorMessage);
                    VkSN.this.PostUserStatusError(this.mSign, error.apiError.errorMessage);
                    return;
                }
                Log.e("VkSN", "PostUserStatus: http error: " + error.httpError);
                VkSN.this.PostUserStatusError(this.mSign, "Http error, code: " + error.errorCode);
            }

            public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts) {
                Log.e("VkSN", "PostUserStatus: Attempt to " + attemptNumber + " of " + totalAttempts + "is failed");
            }
        });
    }

    public void PostNews(int sign, String name, String caption, String description, String link, String pictureUrl) {
        DownloadPictureURL task = new DownloadPictureURL();
        task.m_pictureUrl = pictureUrl;
        task.m_pnSign = sign;
        task.m_description = description;
        task.m_link = link;
        task.execute(new String[]{pictureUrl});
    }
}
