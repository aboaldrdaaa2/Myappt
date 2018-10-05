package lip.com.google.android.gms.drive;

import android.content.Context;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.a;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.iq;
import com.google.android.gms.internal.is;
import java.util.Date;

public final class MetadataChangeSet {
    public static final MetadataChangeSet HV = new MetadataChangeSet(MetadataBundle.gF());
    private final MetadataBundle HW;

    public static class Builder {
        private final MetadataBundle HW;
        private a HX;
        private final Context mContext;

        public Builder() {
            this(null);
        }

        public Builder(Context context) {
            this.HW = MetadataBundle.gF();
            this.mContext = context;
        }

        public MetadataChangeSet build() {
            if (this.HX != null) {
                this.HW.b(iq.JV, this.HX.gD());
            }
            return new MetadataChangeSet(this.HW);
        }

        public Builder setDescription(String description) {
            this.HW.b(iq.JW, description);
            return this;
        }

        public Builder setIndexableText(String text) {
            this.HW.b(iq.Kb, text);
            return this;
        }

        public Builder setLastViewedByMeDate(Date date) {
            this.HW.b(is.Kx, date);
            return this;
        }

        public Builder setMimeType(String mimeType) {
            this.HW.b(iq.Kk, mimeType);
            return this;
        }

        public Builder setPinned(boolean pinned) {
            this.HW.b(iq.Kf, Boolean.valueOf(pinned));
            return this;
        }

        public Builder setStarred(boolean starred) {
            this.HW.b(iq.Kp, Boolean.valueOf(starred));
            return this;
        }

        public Builder setTitle(String title) {
            this.HW.b(iq.Kr, title);
            return this;
        }

        public Builder setViewed(boolean viewed) {
            this.HW.b(iq.Kj, Boolean.valueOf(viewed));
            return this;
        }
    }

    public MetadataChangeSet(MetadataBundle bag) {
        this.HW = MetadataBundle.a(bag);
    }

    public String getDescription() {
        return (String) this.HW.a(iq.JW);
    }

    public String getIndexableText() {
        return (String) this.HW.a(iq.Kb);
    }

    public Date getLastViewedByMeDate() {
        return (Date) this.HW.a(is.Kx);
    }

    public String getMimeType() {
        return (String) this.HW.a(iq.Kk);
    }

    public String getTitle() {
        return (String) this.HW.a(iq.Kr);
    }

    public MetadataBundle gm() {
        return this.HW;
    }

    public Boolean isPinned() {
        return (Boolean) this.HW.a(iq.Kf);
    }

    public Boolean isStarred() {
        return (Boolean) this.HW.a(iq.Kp);
    }

    public Boolean isViewed() {
        return (Boolean) this.HW.a(iq.Kj);
    }
}
