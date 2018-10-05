package lip.com.google.ads.interactivemedia.v3.b;

import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.b.r.b;
import com.google.ads.interactivemedia.v3.b.r.c;
import com.google.ads.interactivemedia.v3.b.v.a;
import java.util.SortedSet;

/* compiled from: IMASDK */
public final class n implements a {
    private final SortedSet<Float> a;
    private s b;
    private String c;
    private float d = 0.0f;

    public n(s sVar, SortedSet<Float> sortedSet, String str) {
        this.b = sVar;
        this.c = str;
        this.a = sortedSet;
    }

    public final void a(VideoProgressUpdate videoProgressUpdate) {
        if (videoProgressUpdate != null && videoProgressUpdate.getDuration() >= 0.0f) {
            float currentTime = videoProgressUpdate.getCurrentTime();
            Object obj = !((this.d > currentTime ? 1 : (this.d == currentTime ? 0 : -1)) < 0 ? this.a.subSet(Float.valueOf(this.d), Float.valueOf(currentTime)) : this.a.subSet(Float.valueOf(currentTime), Float.valueOf(this.d))).isEmpty() ? 1 : null;
            this.d = videoProgressUpdate.getCurrentTime();
            if (obj != null) {
                this.b.b(new r(b.contentTimeUpdate, c.contentTimeUpdate, this.c, videoProgressUpdate));
            }
        }
    }
}
