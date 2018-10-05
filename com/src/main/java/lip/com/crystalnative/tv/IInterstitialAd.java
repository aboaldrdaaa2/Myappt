package lip.com.crystalnative.tv;

interface IInterstitialAd {
    int isLoaded();

    void requestAd(String str, boolean z);

    void show();

    void stop();
}
