package lip.com.google.android.gms.plus.internal;

import android.content.Context;
import com.google.android.gms.common.Scopes;
import java.util.ArrayList;
import java.util.Arrays;

public class i {
    private String[] abV;
    private String abW;
    private String abX;
    private String abY;
    private PlusCommonExtras aca;
    private final ArrayList<String> acb = new ArrayList();
    private String[] acc;
    private String yQ;

    public i(Context context) {
        this.abX = context.getPackageName();
        this.abW = context.getPackageName();
        this.aca = new PlusCommonExtras();
        this.acb.add(Scopes.PLUS_LOGIN);
    }

    public i bz(String str) {
        this.yQ = str;
        return this;
    }

    public i e(String... strArr) {
        this.acb.clear();
        this.acb.addAll(Arrays.asList(strArr));
        return this;
    }

    public i f(String... strArr) {
        this.acc = strArr;
        return this;
    }

    public i ki() {
        this.acb.clear();
        return this;
    }

    public h kj() {
        if (this.yQ == null) {
            this.yQ = "<<default account>>";
        }
        return new h(this.yQ, (String[]) this.acb.toArray(new String[this.acb.size()]), this.acc, this.abV, this.abW, this.abX, this.abY, this.aca);
    }
}
