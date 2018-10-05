package lip.com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.i;
import com.google.android.gms.drive.metadata.internal.j;
import com.google.android.gms.drive.metadata.internal.k;
import com.google.android.gms.drive.metadata.internal.l;
import com.google.android.gms.plus.PlusShare;
import java.util.Collections;

public class iq {
    public static final MetadataField<DriveId> JT = it.KB;
    public static final MetadataField<String> JU = new l("alternateLink", 4300000);
    public static final a JV = new a(5000000);
    public static final MetadataField<String> JW = new l(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 4300000);
    public static final MetadataField<String> JX = new l("embedLink", 4300000);
    public static final MetadataField<String> JY = new l("fileExtension", 4300000);
    public static final MetadataField<Long> JZ = new com.google.android.gms.drive.metadata.internal.g("fileSize", 4300000);
    public static final MetadataField<Boolean> Ka = new com.google.android.gms.drive.metadata.internal.b("hasThumbnail", 4300000);
    public static final MetadataField<String> Kb = new l("indexableText", 4300000);
    public static final MetadataField<Boolean> Kc = new com.google.android.gms.drive.metadata.internal.b("isAppData", 4300000);
    public static final MetadataField<Boolean> Kd = new com.google.android.gms.drive.metadata.internal.b("isCopyable", 4300000);
    public static final MetadataField<Boolean> Ke = new com.google.android.gms.drive.metadata.internal.b("isEditable", 4100000);
    public static final b Kf = new b("isPinned", 4100000);
    public static final MetadataField<Boolean> Kg = new com.google.android.gms.drive.metadata.internal.b("isRestricted", 4300000);
    public static final MetadataField<Boolean> Kh = new com.google.android.gms.drive.metadata.internal.b("isShared", 4300000);
    public static final MetadataField<Boolean> Ki = new com.google.android.gms.drive.metadata.internal.b("isTrashable", 4400000);
    public static final MetadataField<Boolean> Kj = new com.google.android.gms.drive.metadata.internal.b("isViewed", 4300000);
    public static final c Kk = new c("mimeType", 4100000);
    public static final MetadataField<String> Kl = new l("originalFilename", 4300000);
    public static final com.google.android.gms.drive.metadata.b<String> Km = new k("ownerNames", 4300000);
    public static final d Kn = new d("parents", 4100000);
    public static final e Ko = new e("quotaBytesUsed", 4300000);
    public static final f Kp = new f("starred", 4100000);
    public static final MetadataField<com.google.android.gms.common.data.a> Kq = new j<com.google.android.gms.common.data.a>("thumbnail", Collections.emptySet(), Collections.emptySet(), 4400000) {
        /* renamed from: i */
        protected com.google.android.gms.common.data.a b(DataHolder dataHolder, int i, int i2) {
            throw new IllegalStateException("Thumbnail field is write only");
        }
    };
    public static final g Kr = new g(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 4100000);
    public static final h Ks = new h("trashed", 4100000);
    public static final MetadataField<String> Kt = new l("webContentLink", 4300000);
    public static final MetadataField<String> Ku = new l("webViewLink", 4300000);
    public static final MetadataField<String> Kv = new l("uniqueIdentifier", 5000000);

    public static class b extends com.google.android.gms.drive.metadata.internal.b implements SearchableMetadataField<Boolean> {
        public b(String str, int i) {
            super(str, i);
        }
    }

    public static class c extends l implements SearchableMetadataField<String> {
        public c(String str, int i) {
            super(str, i);
        }
    }

    public static class e extends com.google.android.gms.drive.metadata.internal.g implements SortableMetadataField<Long> {
        public e(String str, int i) {
            super(str, i);
        }
    }

    public static class f extends com.google.android.gms.drive.metadata.internal.b implements SearchableMetadataField<Boolean> {
        public f(String str, int i) {
            super(str, i);
        }
    }

    public static class g extends l implements SearchableMetadataField<String>, SortableMetadataField<String> {
        public g(String str, int i) {
            super(str, i);
        }
    }

    public static class h extends com.google.android.gms.drive.metadata.internal.b implements SearchableMetadataField<Boolean> {
        public h(String str, int i) {
            super(str, i);
        }

        /* renamed from: d */
        protected Boolean b(DataHolder dataHolder, int i, int i2) {
            return Boolean.valueOf(dataHolder.b(getName(), i, i2) != 0);
        }
    }

    public static class a extends ir implements SearchableMetadataField<AppVisibleCustomProperties> {
        public a(int i) {
            super(i);
        }
    }

    public static class d extends i<DriveId> implements SearchableCollectionMetadataField<DriveId> {
        public d(String str, int i) {
            super(str, i);
        }
    }
}
