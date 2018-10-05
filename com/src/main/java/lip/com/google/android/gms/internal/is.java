package lip.com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import java.util.Date;

public class is {
    public static final e KA = new e("sharedWithMe", 4100000);
    public static final a Kw = new a("created", 4100000);
    public static final b Kx = new b("lastOpenedTime", 4300000);
    public static final d Ky = new d("modified", 4100000);
    public static final c Kz = new c("modifiedByMe", 4100000);

    public static class a extends com.google.android.gms.drive.metadata.internal.d implements SortableMetadataField<Date> {
        public a(String str, int i) {
            super(str, i);
        }
    }

    public static class b extends com.google.android.gms.drive.metadata.internal.d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public b(String str, int i) {
            super(str, i);
        }
    }

    public static class c extends com.google.android.gms.drive.metadata.internal.d implements SortableMetadataField<Date> {
        public c(String str, int i) {
            super(str, i);
        }
    }

    public static class d extends com.google.android.gms.drive.metadata.internal.d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public d(String str, int i) {
            super(str, i);
        }
    }

    public static class e extends com.google.android.gms.drive.metadata.internal.d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public e(String str, int i) {
            super(str, i);
        }
    }
}
