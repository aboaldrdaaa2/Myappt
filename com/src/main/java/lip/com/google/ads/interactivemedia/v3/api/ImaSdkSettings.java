package lip.com.google.ads.interactivemedia.v3.api;

/* compiled from: IMASDK */
public class ImaSdkSettings {
    private transient String language = "en";
    private String ppid;

    public String getPpid() {
        return this.ppid;
    }

    public void setPpid(String ppid) {
        this.ppid = ppid;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String toString() {
        return "ImaSdkSettings [ppid=" + this.ppid + ", language=" + this.language + "]";
    }
}
