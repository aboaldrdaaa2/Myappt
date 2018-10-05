package lip.com.cnative.tv;

interface IBannerAd {
    void hide();

    void requestAd(String str, boolean z);

    void setPosition(int i, int i2, int i3, int i4);

    void show();

    void stop();
}
