package lip.com.cnative.tv;

import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.HttpMethod;
import com.facebook.Request;
import com.facebook.RequestAsyncTask;
import com.facebook.RequestBatch;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.Session.NewPermissionsRequest;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.OpenGraphAction;
import com.facebook.model.OpenGraphObject;
import com.facebook.model.OpenGraphObject.Factory;
import com.facebook.widget.FacebookDialog;
import com.facebook.widget.FacebookDialog.Callback;
import com.facebook.widget.FacebookDialog.PendingCall;
import com.facebook.widget.FacebookDialog.ShareDialogBuilder;
import com.facebook.widget.FacebookDialog.ShareDialogFeature;
import com.facebook.widget.WebDialog;
import com.facebook.widget.WebDialog.FeedDialogBuilder;
import com.facebook.widget.WebDialog.OnCompleteListener;
import com.google.android.gms.plus.PlusShare;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookSN implements IFacebookSN {
    private static final String PENDING_LOGIN_KEY = "pendingLogin";
    private static final String PENDING_PUBLISH_KEY = "pendingPublishReauthorization";
    private static final String PENDING_STORY_PUBLISH_KEY = "pendingPublishReauthorizationStory";
    private static final String PENDING_US_PUBLISH_KEY = "pendingPublishReauthorizationUserStatus";
    private static final List<String> PERMISSIONS = Arrays.asList(new String[]{"publish_actions", "public_profile"});
    public static final String TAG = "FacebookSN";
    private TvCoreActivity m_activity;
    private Bundle m_autoLoginNewsParams = new Bundle();
    private StatusCallback m_commonCallback = new StatusCallback() {
        public void call(Session session, SessionState state, Exception exception) {
            FacebookSN.this.onSessionStateChange(session, state, exception);
        }
    };
    private Callback m_dialogCallback = new Callback() {
        public void onError(PendingCall pendingCall, Exception error, Bundle data) {
            Log.e("FacebookSN", String.format("FacebookDialog: Error: %s", new Object[]{error.toString()}));
            FacebookSN.this.PostNewsAutoLoginError(FacebookSN.this.m_pnalSign, error.toString());
        }

        public void onComplete(PendingCall pendingCall, Bundle data) {
            boolean didCancel = FacebookDialog.getNativeDialogDidComplete(data);
            Log.i("FacebookSN", "FacebookDialog: Success! Cancel ? " + didCancel);
            if (didCancel) {
                FacebookSN.this.PostNewsAutoLoginCanceled(FacebookSN.this.m_pnalSign);
            } else {
                FacebookSN.this.PostNewsAutoLoginSuccess(FacebookSN.this.m_pnalSign);
            }
        }
    };
    int m_loginSign = 0;
    int m_logoutSign = 0;
    private Bundle m_newsParams = new Bundle();
    int m_pnSign = 0;
    int m_pnalSign = 0;
    int m_puSign = 0;
    private String m_status = "";
    private Bundle m_storyParams = new Bundle();
    int m_storySign = 0;
    private UiLifecycleHelper m_uiHelper;
    private boolean pendingLogin = false;
    private boolean pendingPublishReauthorization = false;
    private boolean pendingPublishReauthorizationStory = false;
    private boolean pendingPublishReauthorizationUserStatus = false;

    private native void LoginIsFailed(int i, String str);

    private native void PostNewsAutoLoginCanceled(int i);

    private native void PostNewsAutoLoginError(int i, String str);

    private native void PostNewsAutoLoginSuccess(int i);

    private native void PostNewsError(int i, String str);

    private native void PostNewsSuccess(int i);

    private native void PostStoryError(int i, String str);

    private native void PostStorySuccess(int i);

    private native void PostUserStatusError(int i, String str);

    private native void PostUserStatusSuccess(int i);

    private native void SuccessLogin(int i);

    private native void SuccessLogout(int i);

    private void onSessionStateChange(Session session, SessionState state, Exception exception) {
        if (session.isOpened()) {
            Log.i("FacebookSN", "session.isOpened()");
            if (this.pendingPublishReauthorization && state.equals(SessionState.OPENED_TOKEN_UPDATED)) {
                this.pendingPublishReauthorization = false;
                PostNews();
            }
            if (this.pendingPublishReauthorizationUserStatus && state.equals(SessionState.OPENED_TOKEN_UPDATED)) {
                this.pendingPublishReauthorizationUserStatus = false;
                PostUserStatus();
            }
            if (this.pendingPublishReauthorizationStory && state.equals(SessionState.OPENED_TOKEN_UPDATED)) {
                this.pendingPublishReauthorizationStory = false;
                PostStory();
                return;
            }
            return;
        }
        Log.i("FacebookSN", "! session.isOpened()");
    }

    private void PostNewsAutoLogin() {
        Session session = Session.getActiveSession();
        if (FacebookDialog.canPresentShareDialog(this.m_activity, ShareDialogFeature.SHARE_DIALOG)) {
            Log.i("FacebookSN", "PostNewsAutoLogin: shareDialog...");
            FacebookDialog shareDialog = ((ShareDialogBuilder) ((ShareDialogBuilder) ((ShareDialogBuilder) ((ShareDialogBuilder) ((ShareDialogBuilder) new ShareDialogBuilder(this.m_activity).setLink(this.m_autoLoginNewsParams.getString("link"))).setName(this.m_autoLoginNewsParams.getString("name"))).setCaption(this.m_autoLoginNewsParams.getString("caption"))).setDescription(this.m_autoLoginNewsParams.getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION))).setPicture(this.m_autoLoginNewsParams.getString("picture"))).build();
            this.m_autoLoginNewsParams.clear();
            this.m_uiHelper.trackPendingDialogCall(shareDialog.present());
        } else if (session == null || !session.isOpened()) {
            Log.e("FacebookSN", "PostNewsAutoLogin: Error: session isn't exist");
            this.m_autoLoginNewsParams.clear();
            PostNewsAutoLoginError(this.m_pnalSign, "Facebook session isn't exist");
        } else {
            Log.i("FacebookSN", "PostNewsAutoLogin: feedDialog...");
            WebDialog feedDialog = ((FeedDialogBuilder) new FeedDialogBuilder(this.m_activity, session, this.m_autoLoginNewsParams).setOnCompleteListener(new OnCompleteListener() {
                public void onComplete(Bundle values, FacebookException error) {
                    if (error == null) {
                        String postId = values.getString("post_id");
                        if (postId != null) {
                            Log.i("FacebookSN", "PostNewsAutoLogin: Posted story, id: " + postId);
                            FacebookSN.this.PostNewsAutoLoginSuccess(FacebookSN.this.m_pnalSign);
                            return;
                        }
                        Log.e("FacebookSN", "PostNewsAutoLogin: Publish cancelled");
                        FacebookSN.this.PostNewsAutoLoginCanceled(FacebookSN.this.m_pnalSign);
                    } else if (error instanceof FacebookOperationCanceledException) {
                        Log.e("FacebookSN", "PostNewsAutoLogin: Publish cancelled");
                        FacebookSN.this.PostNewsAutoLoginCanceled(FacebookSN.this.m_pnalSign);
                    } else {
                        Log.e("FacebookSN", "PostNewsAutoLogin: Error posting story");
                        FacebookSN.this.PostNewsAutoLoginError(FacebookSN.this.m_pnalSign, "PostNewsAutoLogin: Error");
                    }
                }
            })).build();
            this.m_autoLoginNewsParams.clear();
            feedDialog.show();
        }
    }

    private boolean isSubsetOf(Collection<String> subset, Collection<String> superset) {
        for (String string : subset) {
            if (!superset.contains(string)) {
                return false;
            }
        }
        return true;
    }

    private void PostNews() {
        Session session = Session.getActiveSession();
        if (session != null) {
            Log.i("FacebookSN", "PostNews: request...");
            if (isSubsetOf(PERMISSIONS, session.getPermissions())) {
                Request request = new Request(session, "me/feed", this.m_newsParams, HttpMethod.POST, new Request.Callback() {
                    public void onCompleted(Response response) {
                        String postId = null;
                        if (response.getGraphObject() != null) {
                            JSONObject graphResponse = response.getGraphObject().getInnerJSONObject();
                            if (graphResponse != null) {
                                try {
                                    postId = graphResponse.getString("id");
                                } catch (JSONException e) {
                                    Log.e("FacebookSN", "JSON error " + e.getMessage());
                                }
                            }
                        }
                        FacebookRequestError error = response.getError();
                        if (error != null) {
                            Log.e("FacebookSN", "PostNews: Error: " + error.getErrorMessage());
                            FacebookSN.this.PostNewsError(FacebookSN.this.m_pnSign, error.getErrorMessage());
                        } else if (postId != null) {
                            Log.i("FacebookSN", "PostNews: news id: " + postId);
                            FacebookSN.this.PostNewsSuccess(FacebookSN.this.m_pnSign);
                        } else {
                            Log.e("FacebookSN", "PostNews: Error: id is empty");
                            FacebookSN.this.PostNewsError(FacebookSN.this.m_pnSign, "PostNews: Error: id is empty");
                        }
                    }
                });
                this.m_newsParams.clear();
                new RequestAsyncTask(request).execute(new Void[0]);
                return;
            }
            Log.i("FacebookSN", "PostNews: ask permission...");
            this.pendingPublishReauthorization = true;
            if (this.pendingPublishReauthorizationUserStatus || this.pendingPublishReauthorizationStory) {
                Log.w("FacebookSN", "PostNews: permission have already been asked...");
                return;
            } else {
                session.requestNewPublishPermissions(new NewPermissionsRequest(this.m_activity, PERMISSIONS));
                return;
            }
        }
        Log.e("FacebookSN", "PostNews: Error: session isn't exist");
        this.m_newsParams.clear();
        PostNewsError(this.m_pnSign, "Facebook  session isn't exist");
    }

    private void PostUserStatus() {
        Session session = Session.getActiveSession();
        if (session != null) {
            Log.i("FacebookSN", "PostUserStatus: request...");
            if (isSubsetOf(PERMISSIONS, session.getPermissions())) {
                Request request = Request.newStatusUpdateRequest(session, this.m_status, new Request.Callback() {
                    public void onCompleted(Response response) {
                        String postId = null;
                        if (response.getGraphObject() != null) {
                            JSONObject graphResponse = response.getGraphObject().getInnerJSONObject();
                            if (graphResponse != null) {
                                try {
                                    postId = graphResponse.getString("id");
                                } catch (JSONException e) {
                                    Log.e("FacebookSN", "JSON error " + e.getMessage());
                                }
                            }
                        }
                        FacebookRequestError error = response.getError();
                        if (error != null) {
                            Log.e("FacebookSN", "PostUserStatus: Error: " + error.getErrorMessage());
                            FacebookSN.this.PostUserStatusError(FacebookSN.this.m_puSign, error.getErrorMessage());
                        } else if (postId != null) {
                            Log.i("FacebookSN", "PostUserStatus: status id: " + postId);
                            FacebookSN.this.PostUserStatusSuccess(FacebookSN.this.m_puSign);
                        } else {
                            Log.e("FacebookSN", "PostUserStatus: Error: id is empty");
                            FacebookSN.this.PostUserStatusError(FacebookSN.this.m_puSign, "PostUserStatus: Error: id is empty");
                        }
                    }
                });
                this.m_status = "";
                request.executeAsync();
                return;
            }
            Log.i("FacebookSN", "PostUserStatus: ask permission...");
            this.pendingPublishReauthorizationUserStatus = true;
            if (this.pendingPublishReauthorization || this.pendingPublishReauthorizationStory) {
                Log.w("FacebookSN", "PostUserStatus: permission have already been asked...");
                return;
            } else {
                session.requestNewPublishPermissions(new NewPermissionsRequest(this.m_activity, PERMISSIONS));
                return;
            }
        }
        Log.e("FacebookSN", "PostUserStatus: Error: session isn't exist");
        this.m_status = "";
        PostUserStatusError(this.m_puSign, "Facebook  session isn't exist");
    }

    private void PostStory() {
        Session session = Session.getActiveSession();
        if (session != null) {
            Log.i("FacebookSN", "PostStory: request...");
            if (isSubsetOf(PERMISSIONS, session.getPermissions())) {
                RequestBatch requestBatch = new RequestBatch();
                OpenGraphObject move = Factory.createForPost("movie");
                move.setImageUrls(Arrays.asList(new String[]{this.m_storyParams.getString("picture")}));
                move.setTitle(this.m_storyParams.getString("name"));
                move.setUrl(this.m_storyParams.getString("link"));
                move.setDescription(this.m_storyParams.getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION));
                this.m_storyParams.clear();
                Request objectRequest = Request.newPostOpenGraphObjectRequest(session, move, new Request.Callback() {
                    public void onCompleted(Response response) {
                        FacebookRequestError error = response.getError();
                        if (error != null) {
                            Log.e("FacebookSN", "PostStory: Error: " + error.getErrorMessage());
                            FacebookSN.this.PostStoryError(FacebookSN.this.m_storySign, error.getErrorMessage());
                        }
                    }
                });
                objectRequest.setBatchEntryName("objectCreate");
                requestBatch.add(objectRequest);
                OpenGraphAction action = OpenGraphAction.Factory.createForPost("video.watches");
                action.setProperty("movie", "{result=objectCreate:$.id}");
                action.setExplicitlyShared(true);
                requestBatch.add(Request.newPostOpenGraphActionRequest(session, action, new Request.Callback() {
                    public void onCompleted(Response response) {
                        FacebookRequestError error = response.getError();
                        if (error != null) {
                            Log.e("FacebookSN", "PostStory: Errror: " + error.getErrorMessage());
                            FacebookSN.this.PostStoryError(FacebookSN.this.m_storySign, error.getErrorMessage());
                            return;
                        }
                        String actionId = null;
                        try {
                            if (response.getGraphObject() != null) {
                                JSONObject graphResponse = response.getGraphObject().getInnerJSONObject();
                                if (graphResponse != null) {
                                    actionId = graphResponse.getString("id");
                                }
                            }
                        } catch (JSONException e) {
                            Log.i("FacebookSN", "JSON error " + e.getMessage());
                        }
                        if (actionId != null) {
                            Log.i("FacebookSN", "PostStory: Action id: " + actionId);
                            FacebookSN.this.PostStorySuccess(FacebookSN.this.m_storySign);
                            return;
                        }
                        FacebookSN.this.PostStoryError(FacebookSN.this.m_storySign, "PostStory: Error: id is empty");
                    }
                }));
                requestBatch.executeAsync();
                return;
            }
            Log.i("FacebookSN", "PostStory: ask permission...");
            this.pendingPublishReauthorizationStory = true;
            if (this.pendingPublishReauthorizationUserStatus || this.pendingPublishReauthorization) {
                Log.w("FacebookSN", "PostStory: permission have already been asked...");
                return;
            } else {
                session.requestNewPublishPermissions(new NewPermissionsRequest(this.m_activity, PERMISSIONS));
                return;
            }
        }
        Log.e("FacebookSN", "PostStory: Error: session isn't exist");
        this.m_storyParams.clear();
        PostStoryError(this.m_storySign, "Facebook session isn't exist");
    }

    public void onCreate(Bundle savedInstanceState) {
        Log.i("FacebookSN", "onCreate");
        if (savedInstanceState != null) {
            this.pendingPublishReauthorization = savedInstanceState.getBoolean(PENDING_PUBLISH_KEY, false);
            this.pendingPublishReauthorizationUserStatus = savedInstanceState.getBoolean(PENDING_US_PUBLISH_KEY, false);
            this.pendingPublishReauthorizationStory = savedInstanceState.getBoolean(PENDING_STORY_PUBLISH_KEY, false);
            this.pendingLogin = savedInstanceState.getBoolean(PENDING_LOGIN_KEY, false);
        }
        this.m_uiHelper.onCreate(savedInstanceState);
    }

    public void onDestroy() {
        Log.i("FacebookSN", "onDestroy");
        this.m_uiHelper.onDestroy();
    }

    public void onResume() {
        Log.i("FacebookSN", "onResume");
        Session session = Session.getActiveSession();
        if (session != null && (session.isOpened() || session.isClosed())) {
            onSessionStateChange(session, session.getState(), null);
        }
        this.m_uiHelper.onResume();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("FacebookSN", "onActivityResult(" + requestCode + "," + resultCode + "," + data);
        this.m_uiHelper.onActivityResult(requestCode, resultCode, data, this.m_dialogCallback);
    }

    public void onPause() {
        Log.i("FacebookSN", "onPause");
        this.m_uiHelper.onPause();
    }

    public void onSaveInstanceState(Bundle outState) {
        Log.i("FacebookSN", "onSaveInstanceState");
        outState.putBoolean(PENDING_PUBLISH_KEY, this.pendingPublishReauthorization);
        outState.putBoolean(PENDING_US_PUBLISH_KEY, this.pendingPublishReauthorizationUserStatus);
        outState.putBoolean(PENDING_STORY_PUBLISH_KEY, this.pendingPublishReauthorizationStory);
        outState.putBoolean(PENDING_LOGIN_KEY, this.pendingLogin);
        this.m_uiHelper.onSaveInstanceState(outState);
    }

    public FacebookSN(TvCoreActivity activity) {
        Log.i("FacebookSN", "Creating FacebookSNs");
        this.m_activity = activity;
        this.m_uiHelper = new UiLifecycleHelper(this.m_activity, this.m_commonCallback);
        try {
            for (Signature signature : this.m_activity.getPackageManager().getPackageInfo("com.crystalreality.crystaltvplus", 64).signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.i("KeyHash:", Base64.encodeToString(md.digest(), 0));
            }
        } catch (Throwable th) {
            Log.e("KeyHash:", "Exception");
        }
    }

    public void Login(int sign) {
        this.m_loginSign = sign;
        this.m_activity.runOnUiThread(new Runnable() {
            public void run() {
                Log.i("FacebookSN", "Logging in...");
                FacebookSN.this.pendingLogin = true;
                Session session = Session.getActiveSession();
                if (session == null || !session.isOpened()) {
                    Session.openActiveSession(FacebookSN.this.m_activity, true, new StatusCallback() {
                        public void call(Session session, SessionState state, Exception exception) {
                            if (!session.isOpened() && !session.isClosed()) {
                                Log.i("FacebookSN", "wait...");
                            } else if (session.isOpened()) {
                                if (FacebookSN.this.pendingLogin) {
                                    Log.i("FacebookSN", "State: Logged in!");
                                    FacebookSN.this.pendingLogin = false;
                                    FacebookSN.this.SuccessLogin(FacebookSN.this.m_loginSign);
                                }
                            } else if (FacebookSN.this.pendingLogin) {
                                Log.e("FacebookSN", "Login: Error!");
                                FacebookSN.this.pendingLogin = false;
                                FacebookSN.this.LoginIsFailed(FacebookSN.this.m_loginSign, "Login: Error!");
                            }
                        }
                    });
                } else if (FacebookSN.this.pendingLogin) {
                    Log.i("FacebookSN", "State: Logged in!");
                    FacebookSN.this.pendingLogin = false;
                    FacebookSN.this.SuccessLogin(FacebookSN.this.m_loginSign);
                }
            }
        });
    }

    public boolean LoggedIn() {
        Session session = Session.getActiveSession();
        if (session != null) {
            return session.isOpened();
        }
        return true;
    }

    public void Logout(int sign) {
        this.m_logoutSign = sign;
        this.m_activity.runOnUiThread(new Runnable() {
            public void run() {
                Session session = Session.getActiveSession();
                if (session != null) {
                    session.closeAndClearTokenInformation();
                    Log.i("FacebookSN", "Logging out...");
                }
                FacebookSN.this.SuccessLogout(FacebookSN.this.m_logoutSign);
            }
        });
    }

    public void PostNewsAutoLogin(int sign, String name, String caption, String description, String link, String pictureUri) {
        this.m_pnalSign = sign;
        this.m_autoLoginNewsParams.putString("name", name);
        this.m_autoLoginNewsParams.putString("caption", caption);
        this.m_autoLoginNewsParams.putString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, description);
        this.m_autoLoginNewsParams.putString("link", link);
        this.m_autoLoginNewsParams.putString("picture", pictureUri);
        this.m_activity.runOnUiThread(new Runnable() {
            public void run() {
                FacebookSN.this.PostNewsAutoLogin();
            }
        });
    }

    public void PostUserStatus(int sign, String userStatus) {
        this.m_puSign = sign;
        this.m_status = userStatus;
        this.m_activity.runOnUiThread(new Runnable() {
            public void run() {
                FacebookSN.this.PostUserStatus();
            }
        });
    }

    public void PostNews(int sign, String name, String caption, String description, String link, String pictureUri) {
        this.m_pnSign = sign;
        this.m_newsParams.putString("name", name);
        this.m_newsParams.putString("caption", caption);
        this.m_newsParams.putString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, description);
        this.m_newsParams.putString("link", link);
        this.m_newsParams.putString("picture", pictureUri);
        this.m_activity.runOnUiThread(new Runnable() {
            public void run() {
                FacebookSN.this.PostNews();
            }
        });
    }

    public void PostStory(int sign, String name, String description, String link, String pictureUri) {
        this.m_storySign = sign;
        this.m_storyParams.putString("name", name);
        this.m_storyParams.putString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, description);
        this.m_storyParams.putString("link", link);
        this.m_storyParams.putString("picture", pictureUri);
        this.m_activity.runOnUiThread(new Runnable() {
            public void run() {
                FacebookSN.this.PostStory();
            }
        });
    }
}
