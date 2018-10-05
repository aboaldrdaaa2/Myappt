package lip.com.google.ads.interactivemedia.v3.api;

/* compiled from: IMASDK */
public interface Ad {
    String getAdId();

    AdPodInfo getAdPodInfo();

    String getAdSystem();

    String[] getAdWrapperIds();

    String[] getAdWrapperSystems();

    double getDuration();

    int getHeight();

    String getSelectedMediaUrl();

    String getTraffickingParameters();

    int getWidth();

    boolean isLinear();

    boolean isSkippable();
}
