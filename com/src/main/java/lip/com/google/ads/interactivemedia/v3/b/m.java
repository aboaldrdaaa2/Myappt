package lip.com.google.ads.interactivemedia.v3.b;

import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer.VideoAdPlayerCallback;

/* compiled from: IMASDK */
final class m implements VideoAdPlayerCallback {
    private v a;

    public m(v vVar) {
        this.a = vVar;
    }

    public final void onPlay() {
        this.a.a();
    }

    public final void onPause() {
        this.a.c();
    }

    public final void onResume() {
        this.a.a();
    }

    public final void onEnded() {
        this.a.c();
    }

    public final void onError() {
        this.a.c();
    }

    public final void onVolumeChanged(int i) {
    }
}
