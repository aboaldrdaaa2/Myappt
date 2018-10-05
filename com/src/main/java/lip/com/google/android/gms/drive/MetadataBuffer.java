package lip.com.google.android.gms.drive;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.l;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.e;
import com.google.android.gms.internal.iq;
import java.util.ArrayList;
import java.util.List;

public final class MetadataBuffer extends DataBuffer<Metadata> {
    private static final String[] HR;
    private final String HS;
    private a HT;

    private static class a extends Metadata {
        private final DataHolder DG;
        private final int ED;
        private final int HU;

        public a(DataHolder dataHolder, int i) {
            this.DG = dataHolder;
            this.HU = i;
            this.ED = dataHolder.ae(i);
        }

        protected <T> T a(MetadataField<T> metadataField) {
            return metadataField.a(this.DG, this.HU, this.ED);
        }

        /* renamed from: gl */
        public Metadata freeze() {
            MetadataBundle gF = MetadataBundle.gF();
            for (MetadataField metadataField : e.gE()) {
                if (!((metadataField instanceof b) || metadataField == iq.Kq)) {
                    metadataField.a(this.DG, gF, this.HU, this.ED);
                }
            }
            return new l(gF);
        }

        public boolean isDataValid() {
            return !this.DG.isClosed();
        }
    }

    static {
        List arrayList = new ArrayList();
        for (MetadataField gC : e.gE()) {
            arrayList.addAll(gC.gC());
        }
        HR = (String[]) arrayList.toArray(new String[0]);
    }

    public MetadataBuffer(DataHolder dataHolder, String nextPageToken) {
        super(dataHolder);
        this.HS = nextPageToken;
        dataHolder.eU().setClassLoader(MetadataBuffer.class.getClassLoader());
    }

    public Metadata get(int row) {
        a aVar = this.HT;
        if (aVar != null && aVar.HU == row) {
            return aVar;
        }
        Metadata aVar2 = new a(this.DG, row);
        this.HT = aVar2;
        return aVar2;
    }

    public String getNextPageToken() {
        return this.HS;
    }
}
