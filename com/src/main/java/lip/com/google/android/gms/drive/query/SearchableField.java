package lip.com.google.android.gms.drive.query;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.iq;
import com.google.android.gms.internal.is;
import java.util.Date;

public class SearchableField {
    public static final SearchableMetadataField<Boolean> IS_PINNED = iq.Kf;
    public static final SearchableOrderedMetadataField<Date> KI = is.KA;
    public static final SearchableMetadataField<AppVisibleCustomProperties> KJ = iq.JV;
    public static final SearchableOrderedMetadataField<Date> LAST_VIEWED_BY_ME = is.Kx;
    public static final SearchableMetadataField<String> MIME_TYPE = iq.Kk;
    public static final SearchableOrderedMetadataField<Date> MODIFIED_DATE = is.Ky;
    public static final SearchableCollectionMetadataField<DriveId> PARENTS = iq.Kn;
    public static final SearchableMetadataField<Boolean> STARRED = iq.Kp;
    public static final SearchableMetadataField<String> TITLE = iq.Kr;
    public static final SearchableMetadataField<Boolean> TRASHED = iq.Ks;
}
