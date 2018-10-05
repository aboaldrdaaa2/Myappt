package lip.com.cnative.tv;

interface IInterstitialAd {
    int isLoaded();

    void requestAd(String str, boolean z);

    void show();

    void stop();
}
