package lip.com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.iq;
import com.google.android.gms.internal.is;
import com.google.android.gms.internal.iu;
import java.util.Date;

public abstract class Metadata implements Freezable<Metadata> {
    public static final int CONTENT_AVAILABLE_LOCALLY = 1;
    public static final int CONTENT_NOT_AVAILABLE_LOCALLY = 0;

    protected abstract <T> T a(MetadataField<T> metadataField);

    public String getAlternateLink() {
        return (String) a(iq.JU);
    }

    public int getContentAvailability() {
        Integer num = (Integer) a(iu.KC);
        return num == null ? 0 : num.intValue();
    }

    public Date getCreatedDate() {
        return (Date) a(is.Kw);
    }

    public String getDescription() {
        return (String) a(iq.JW);
    }

    public DriveId getDriveId() {
        return (DriveId) a(iq.JT);
    }

    public String getEmbedLink() {
        return (String) a(iq.JX);
    }

    public String getFileExtension() {
        return (String) a(iq.JY);
    }

    public long getFileSize() {
        return ((Long) a(iq.JZ)).longValue();
    }

    public Date getLastViewedByMeDate() {
        return (Date) a(is.Kx);
    }

    public String getMimeType() {
        return (String) a(iq.Kk);
    }

    public Date getModifiedByMeDate() {
        return (Date) a(is.Kz);
    }

    public Date getModifiedDate() {
        return (Date) a(is.Ky);
    }

    public String getOriginalFilename() {
        return (String) a(iq.Kl);
    }

    public long getQuotaBytesUsed() {
        return ((Long) a(iq.Ko)).longValue();
    }

    public Date getSharedWithMeDate() {
        return (Date) a(is.KA);
    }

    public String getTitle() {
        return (String) a(iq.Kr);
    }

    public String getWebContentLink() {
        return (String) a(iq.Kt);
    }

    public String getWebViewLink() {
        return (String) a(iq.Ku);
    }

    public boolean isEditable() {
        Boolean bool = (Boolean) a(iq.Ke);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isFolder() {
        return DriveFolder.MIME_TYPE.equals(getMimeType());
    }

    public boolean isInAppFolder() {
        Boolean bool = (Boolean) a(iq.Kc);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinnable() {
        Boolean bool = (Boolean) a(iu.KD);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinned() {
        Boolean bool = (Boolean) a(iq.Kf);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isRestricted() {
        Boolean bool = (Boolean) a(iq.Kg);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isShared() {
        Boolean bool = (Boolean) a(iq.Kh);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isStarred() {
        Boolean bool = (Boolean) a(iq.Kp);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isTrashed() {
        Boolean bool = (Boolean) a(iq.Ks);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isViewed() {
        Boolean bool = (Boolean) a(iq.Kj);
        return bool == null ? false : bool.booleanValue();
    }
}
