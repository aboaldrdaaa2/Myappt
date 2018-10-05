package lip.com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.internal.iq;
import com.google.android.gms.internal.is;
import java.util.Date;

public class SortableField {
    public static final SortableMetadataField<Date> CREATED_DATE = is.Kw;
    public static final SortableMetadataField<Date> LAST_VIEWED_BY_ME = is.Kx;
    public static final SortableMetadataField<Date> MODIFIED_BY_ME_DATE = is.Kz;
    public static final SortableMetadataField<Date> MODIFIED_DATE = is.Ky;
    public static final SortableMetadataField<Long> QUOTA_USED = iq.Ko;
    public static final SortableMetadataField<Date> SHARED_WITH_ME_DATE = is.KA;
    public static final SortableMetadataField<String> TITLE = iq.Kr;
}
