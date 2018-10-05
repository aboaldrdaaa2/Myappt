package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class gy {
    private final View DJ;
    private final a FU;

    public static final class a implements SafeParcelable {
        public static final hl CREATOR = new hl();
        private final int DI;
        private final String DK;
        private final List<String> Ef;
        private final int xM;
        private final String yQ;

        a(int i, String str, List<String> list, int i2, String str2) {
            this.Ef = new ArrayList();
            this.xM = i;
            this.yQ = str;
            this.Ef.addAll(list);
            this.DI = i2;
            this.DK = str2;
        }

        public a(String str, Collection<String> collection, int i, String str2) {
            this(3, str, new ArrayList(collection), i, str2);
        }

        public int describeContents() {
            return 0;
        }

        public String fj() {
            return this.yQ != null ? this.yQ : "<<default account>>";
        }

        public int fk() {
            return this.DI;
        }

        public List<String> fl() {
            return new ArrayList(this.Ef);
        }

        public String fn() {
            return this.DK;
        }

        public String getAccountName() {
            return this.yQ;
        }

        public int getVersionCode() {
            return this.xM;
        }

        public void writeToParcel(Parcel out, int flags) {
            hl.a(this, out, flags);
        }
    }

    public gy(String str, Collection<String> collection, int i, View view, String str2) {
        this.FU = new a(str, collection, i, str2);
        this.DJ = view;
    }

    public String fj() {
        return this.FU.fj();
    }

    public int fk() {
        return this.FU.fk();
    }

    public List<String> fl() {
        return this.FU.fl();
    }

    public String[] fm() {
        return (String[]) this.FU.fl().toArray(new String[0]);
    }

    public String fn() {
        return this.FU.fn();
    }

    public View fo() {
        return this.DJ;
    }

    public String getAccountName() {
        return this.FU.getAccountName();
    }
}
