package lip.com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.tagmanager.DataLayer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class cj extends FrameLayout implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    private final ex lN;
    private final MediaController oI;
    private final a oJ = new a(this);
    private final VideoView oK;
    private long oL;
    private String oM;

    private static final class a {
        private final Runnable lg;
        private volatile boolean oN = false;

        public a(final cj cjVar) {
            this.lg = new Runnable() {
                private final WeakReference<cj> oO = new WeakReference(cjVar);

                public void run() {
                    cj cjVar = (cj) this.oO.get();
                    if (!a.this.oN && cjVar != null) {
                        cjVar.bb();
                        a.this.bc();
                    }
                }
            };
        }

        public void bc() {
            et.sv.postDelayed(this.lg, 250);
        }

        public void cancel() {
            this.oN = true;
            et.sv.removeCallbacks(this.lg);
        }
    }

    public cj(Context context, ex exVar) {
        super(context);
        this.lN = exVar;
        this.oK = new VideoView(context);
        addView(this.oK, new LayoutParams(-1, -1, 17));
        this.oI = new MediaController(context);
        this.oJ.bc();
        this.oK.setOnCompletionListener(this);
        this.oK.setOnPreparedListener(this);
        this.oK.setOnErrorListener(this);
    }

    private static void a(ex exVar, String str) {
        a(exVar, str, new HashMap(1));
    }

    public static void a(ex exVar, String str, String str2) {
        Object obj = str2 == null ? 1 : null;
        Map hashMap = new HashMap(obj != null ? 2 : 3);
        hashMap.put("what", str);
        if (obj == null) {
            hashMap.put("extra", str2);
        }
        a(exVar, NativeProtocol.BRIDGE_ARG_ERROR_BUNDLE, hashMap);
    }

    private static void a(ex exVar, String str, String str2, String str3) {
        Map hashMap = new HashMap(2);
        hashMap.put(str2, str3);
        a(exVar, str, hashMap);
    }

    private static void a(ex exVar, String str, Map<String, String> map) {
        map.put(DataLayer.EVENT_KEY, str);
        exVar.a("onVideoEvent", (Map) map);
    }

    public void b(MotionEvent motionEvent) {
        this.oK.dispatchTouchEvent(motionEvent);
    }

    public void ba() {
        if (TextUtils.isEmpty(this.oM)) {
            a(this.lN, "no_src", null);
        } else {
            this.oK.setVideoPath(this.oM);
        }
    }

    public void bb() {
        long currentPosition = (long) this.oK.getCurrentPosition();
        if (this.oL != currentPosition) {
            a(this.lN, "timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
            this.oL = currentPosition;
        }
    }

    public void destroy() {
        this.oJ.cancel();
        this.oK.stopPlayback();
    }

    public void l(boolean z) {
        if (z) {
            this.oK.setMediaController(this.oI);
            return;
        }
        this.oI.hide();
        this.oK.setMediaController(null);
    }

    public void o(String str) {
        this.oM = str;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        a(this.lN, "ended");
    }

    public boolean onError(MediaPlayer mediaPlayer, int what, int extra) {
        a(this.lN, String.valueOf(what), String.valueOf(extra));
        return true;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        a(this.lN, "canplaythrough", "duration", String.valueOf(((float) this.oK.getDuration()) / 1000.0f));
    }

    public void pause() {
        this.oK.pause();
    }

    public void play() {
        this.oK.start();
    }

    public void seekTo(int timeInMilliseconds) {
        this.oK.seekTo(timeInMilliseconds);
    }
}
