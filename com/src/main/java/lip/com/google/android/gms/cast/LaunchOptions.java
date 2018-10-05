package lip.com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.hk;
import java.util.Locale;

public class LaunchOptions implements SafeParcelable {
    public static final Creator<LaunchOptions> CREATOR = new c();
    private boolean Aq;
    private String Ar;
    private final int xM;

    public static final class Builder {
        private LaunchOptions As = new LaunchOptions();

        public LaunchOptions build() {
            return this.As;
        }

        public Builder setLocale(Locale locale) {
            this.As.setLanguage(gi.b(locale));
            return this;
        }

        public Builder setRelaunchIfRunning(boolean relaunchIfRunning) {
            this.As.setRelaunchIfRunning(relaunchIfRunning);
            return this;
        }
    }

    public LaunchOptions() {
        this(1, false, gi.b(Locale.getDefault()));
    }

    LaunchOptions(int versionCode, boolean relaunchIfRunning, String language) {
        this.xM = versionCode;
        this.Aq = relaunchIfRunning;
        this.Ar = language;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LaunchOptions)) {
            return false;
        }
        LaunchOptions launchOptions = (LaunchOptions) obj;
        return this.Aq == launchOptions.Aq && gi.a(this.Ar, launchOptions.Ar);
    }

    public String getLanguage() {
        return this.Ar;
    }

    public boolean getRelaunchIfRunning() {
        return this.Aq;
    }

    int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return hk.hashCode(Boolean.valueOf(this.Aq), this.Ar);
    }

    public void setLanguage(String language) {
        this.Ar = language;
    }

    public void setRelaunchIfRunning(boolean relaunchIfRunning) {
        this.Aq = relaunchIfRunning;
    }

    public String toString() {
        return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", new Object[]{Boolean.valueOf(this.Aq), this.Ar});
    }

    public void writeToParcel(Parcel out, int flags) {
        c.a(this, out, flags);
    }
}
