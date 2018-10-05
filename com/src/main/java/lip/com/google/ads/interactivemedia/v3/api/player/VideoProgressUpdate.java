package lip.com.google.ads.interactivemedia.v3.api.player;

/* compiled from: IMASDK */
public class VideoProgressUpdate {
    public static final VideoProgressUpdate VIDEO_TIME_NOT_READY = new VideoProgressUpdate(-1, -1);
    private float currentTime;
    private float duration;

    public VideoProgressUpdate() {
        this(-1, -1);
    }

    public VideoProgressUpdate(long currentTimeMillis, long durationMillis) {
        this.currentTime = ((float) currentTimeMillis) / 1000.0f;
        this.duration = ((float) durationMillis) / 1000.0f;
    }

    public float getCurrentTime() {
        return this.currentTime;
    }

    public float getDuration() {
        return this.duration;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        VideoProgressUpdate videoProgressUpdate = (VideoProgressUpdate) obj;
        if (Float.floatToIntBits(this.currentTime) != Float.floatToIntBits(videoProgressUpdate.currentTime)) {
            return false;
        }
        if (Float.floatToIntBits(this.duration) != Float.floatToIntBits(videoProgressUpdate.duration)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "VideoProgressUpdate [currentTime=" + this.currentTime + ", duration=" + this.duration + "]";
    }
}
