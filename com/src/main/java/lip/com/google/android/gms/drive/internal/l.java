package lip.com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class l extends Metadata {
    private final MetadataBundle II;

    public l(MetadataBundle metadataBundle) {
        this.II = metadataBundle;
    }

    protected <T> T a(MetadataField<T> metadataField) {
        return this.II.a((MetadataField) metadataField);
    }

    /* renamed from: gl */
    public Metadata freeze() {
        return new l(MetadataBundle.a(this.II));
    }

    public boolean isDataValid() {
        return this.II != null;
    }

    public String toString() {
        return "Metadata [mImpl=" + this.II + "]";
    }
}
