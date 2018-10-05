package lip.com.crystalnative.tv.adplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.util.Log;
import android.widget.VideoView;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer.VideoAdPlayerCallback;
import java.util.ArrayList;
import java.util.List;

public class TrackingVideoView extends VideoView implements OnCompletionListener, OnErrorListener {
    public static String TAG = "TrackingVideoView";
    private final List<VideoAdPlayerCallback> adCallbacks = new ArrayList(1);
    private CompleteCallback completeCallback;
    private PlaybackState state = PlaybackState.STOPPED;

    public interface CompleteCallback {
        void onComplete();
    }

    private enum PlaybackState {
        STOPPED,
        PAUSED,
        PLAYING
    }

    public TrackingVideoView(Context context) {
        super(context);
        super.setOnCompletionListener(this);
        super.setOnErrorListener(this);
        Log.i(TAG, "TrackingVideoView()");
    }

    public void setCompleteCallback(CompleteCallback callback) {
        Log.i(TAG, "setCompleteCallback()");
        this.completeCallback = callback;
    }

    public void togglePlayback() {
        Log.i(TAG, "togglePlayback()");
        switch (this.state) {
            case STOPPED:
            case PAUSED:
                start();
                return;
            case PLAYING:
                pause();
                return;
            default:
                return;
        }
    }

    public void start() {
        Log.i(TAG, "start()");
        super.start();
        PlaybackState oldState = this.state;
        this.state = PlaybackState.PLAYING;
        switch (oldState) {
            case STOPPED:
                for (VideoAdPlayerCallback callback : this.adCallbacks) {
                    Log.i(TAG, "callback.onPlay()");
                    callback.onPlay();
                }
                return;
            case PAUSED:
                for (VideoAdPlayerCallback callback2 : this.adCallbacks) {
                    Log.i(TAG, "callback.onResume()");
                    callback2.onResume();
                }
                return;
            default:
                return;
        }
    }

    public void pause() {
        Log.i(TAG, "pause()");
        super.pause();
        this.state = PlaybackState.PAUSED;
        for (VideoAdPlayerCallback callback : this.adCallbacks) {
            callback.onPause();
        }
    }

    public void stopPlayback() {
        Log.i(TAG, "stopPlayback()");
        super.stopPlayback();
        onStop();
    }

    private void onStop() {
        Log.i(TAG, "onStop()");
        if (this.state != PlaybackState.STOPPED) {
            this.state = PlaybackState.STOPPED;
        }
    }

    public void onCompletion(MediaPlayer mp) {
        Log.i(TAG, "onCompletion()");
        onStop();
        for (VideoAdPlayerCallback callback : this.adCallbacks) {
            callback.onEnded();
        }
    }

    public boolean onError(MediaPlayer mp, int what, int extra) {
        Log.e(TAG, "onError() " + what);
        for (VideoAdPlayerCallback callback : this.adCallbacks) {
            callback.onError();
        }
        onStop();
        return true;
    }

    public void addCallback(VideoAdPlayerCallback callback) {
        Log.i(TAG, "addCallback()");
        this.adCallbacks.add(callback);
    }

    public void removeCallback(VideoAdPlayerCallback callback) {
        Log.i(TAG, "removeCallback()");
        this.adCallbacks.remove(callback);
    }

    public void setOnCompletionListener(OnCompletionListener l) {
        throw new UnsupportedOperationException();
    }
}
