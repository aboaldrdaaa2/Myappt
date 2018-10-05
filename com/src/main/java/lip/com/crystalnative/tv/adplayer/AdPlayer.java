package lip.com.crystalnative.tv.adplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer.VideoAdPlayerCallback;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;

public class AdPlayer extends RelativeLayout implements VideoAdPlayer {
    public static String TAG = "AdPlayer";
    private FrameLayout adUiContainer;
    private int savedPosition = 0;
    private TrackingVideoView video;

    public AdPlayer(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public AdPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AdPlayer(Context context) {
        super(context);
        init();
    }

    private void init() {
        Log.i(TAG, "init()");
        LayoutParams videoLayouyParams = new LayoutParams(-1, -1);
        videoLayouyParams.addRule(14);
        videoLayouyParams.addRule(13);
        this.video = new TrackingVideoView(getContext());
        this.video.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                Log.i(AdPlayer.TAG, "onTouch()");
                AdPlayer.this.video.togglePlayback();
                return false;
            }
        });
        addView(this.video, videoLayouyParams);
        this.adUiContainer = new FrameLayout(getContext());
        addView(this.adUiContainer, -1);
    }

    public ViewGroup getUiContainer() {
        return this.adUiContainer;
    }

    public void savePosition() {
        this.savedPosition = this.video.getCurrentPosition();
        this.video.togglePlayback();
    }

    public void restorePosition() {
        this.video.seekTo(this.savedPosition);
        this.video.togglePlayback();
    }

    public void playAd() {
        Log.i(TAG, "playAd()");
        this.video.start();
    }

    public void stopAd() {
        Log.i(TAG, "stopAd()");
        this.video.stopPlayback();
    }

    public void loadAd(String url) {
        Log.i(TAG, "loadAd() - " + url);
        this.video.setVideoPath(url);
    }

    public void pauseAd() {
        Log.i(TAG, "pauseAd()");
        this.video.pause();
    }

    public void resumeAd() {
        Log.i(TAG, "resumeAd()");
        this.video.start();
    }

    public void addCallback(VideoAdPlayerCallback callback) {
        Log.i(TAG, "addCallBack()");
        this.video.addCallback(callback);
    }

    public void removeCallback(VideoAdPlayerCallback callback) {
        Log.i(TAG, "removeCallBack()");
        this.video.removeCallback(callback);
    }

    public VideoProgressUpdate getProgress() {
        int durationMs = this.video.getDuration();
        if (durationMs <= 0) {
            return VideoProgressUpdate.VIDEO_TIME_NOT_READY;
        }
        return new VideoProgressUpdate((long) this.video.getCurrentPosition(), (long) durationMs);
    }
}
