package lip.com.google.ads.interactivemedia.v3.api;

/* compiled from: IMASDK */
public interface AdEvent {

    /* compiled from: IMASDK */
    public interface AdEventListener {
        void onAdEvent(AdEvent adEvent);
    }

    /* compiled from: IMASDK */
    public enum AdEventType {
        ALL_ADS_COMPLETED,
        CLICKED,
        COMPLETED,
        CONTENT_PAUSE_REQUESTED,
        CONTENT_RESUME_REQUESTED,
        FIRST_QUARTILE,
        MIDPOINT,
        PAUSED,
        RESUMED,
        SKIPPED,
        STARTED,
        THIRD_QUARTILE,
        LOADED
    }

    Ad getAd();

    AdEventType getType();
}
