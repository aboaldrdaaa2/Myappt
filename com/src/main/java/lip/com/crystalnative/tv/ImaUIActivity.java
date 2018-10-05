package lip.com.crystalnative.tv;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.crystalnative.tv.adplayer.AdPlayer;

public class ImaUIActivity extends Activity {
    public static String TAG = "ImaUIActivity";
    private ImaUIActivity m_activity;
    private int m_handler = 0;
    private FrameLayout m_layout;
    private AdPlayer m_videoPlayer = null;

    public native void onImaUIActivityCreated(int i, ImaUIActivity imaUIActivity);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Creating UI Activity");
        this.m_activity = this;
        this.m_handler = getIntent().getIntExtra("IMA.Handler.ID", 0);
        this.m_layout = new FrameLayout(this.m_activity);
        this.m_layout.setLayoutParams(new LayoutParams(-1, -1));
        this.m_activity.setContentView(this.m_layout);
        onImaUIActivityCreated(this.m_handler, this.m_activity);
    }

    public void onBackPressed() {
    }

    protected void onPause() {
        super.onPause();
        if (this.m_videoPlayer != null) {
            this.m_videoPlayer.savePosition();
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.m_videoPlayer != null) {
            this.m_videoPlayer.restorePosition();
        }
    }

    public void setPlayer(AdPlayer player) {
        Log.i(TAG, "setPlayer");
        this.m_videoPlayer = player;
        this.m_activity.runOnUiThread(new Runnable() {
            public void run() {
                if (ImaUIActivity.this.m_videoPlayer != null) {
                    ImaUIActivity.this.m_layout.addView(ImaUIActivity.this.m_videoPlayer);
                }
            }
        });
    }
}
