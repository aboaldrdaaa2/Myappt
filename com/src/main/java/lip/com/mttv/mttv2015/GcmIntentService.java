package lip.com.mttv.mttv2015;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.cnative.tv.TvCoreActivity;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.mytv.mytv2016.R;

public class GcmIntentService extends IntentService {
    public static final int NOTIFICATION_ID = 1;
    public static final String TAG = "Crystal GCM Intent Service";
    Builder builder;
    private NotificationManager mNotificationManager;

    public GcmIntentService() {
        super("GcmIntentService");
    }

    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        String messageType = GoogleCloudMessaging.getInstance(this).getMessageType(intent);
        if (!extras.isEmpty()) {
            if (GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR.equals(messageType)) {
                sendNotification("Send error: " + extras.toString(), "");
            } else if (GoogleCloudMessaging.MESSAGE_TYPE_DELETED.equals(messageType)) {
                sendNotification("Deleted messages on server: " + extras.toString(), "");
            } else if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType)) {
                sendNotification(extras.getString("message"), extras.getString("header"));
            }
        }
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }

    private void sendNotification(String msg, String header) {
        Log.i("Crystal GCM Intent Service", "Received: " + header + ", " + msg);
        if (TvCoreActivity.isRunningApp()) {
            Log.e("Crystal GCM Intent Service", "App is running");
            return;
        }
        Log.i("Crystal GCM Intent Service", "App isn't running");
        this.mNotificationManager = (NotificationManager) getSystemService("notification");
        Intent notificationIntent = new Intent("android.intent.action.com.mttv.mttv2015");
        notificationIntent.setFlags(603979776);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 134217728);
        Builder smallIcon = new Builder(this).setSmallIcon(R.drawable.icon);
        if (header == null || header.isEmpty()) {
            header = getString(R.string.app_name);
        }
        Builder mBuilder = smallIcon.setContentTitle(header).setStyle(new BigTextStyle().bigText(msg)).setContentText(msg).setAutoCancel(true).setDefaults(-1);
        mBuilder.setContentIntent(contentIntent);
        this.mNotificationManager.notify(1, mBuilder.build());
    }
}
