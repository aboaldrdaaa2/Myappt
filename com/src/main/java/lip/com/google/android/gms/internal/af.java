package lip.com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.ae.a;
import org.json.JSONObject;

public class af implements ae {
    private final ex lN;

    public af(Context context, ev evVar) {
        this.lN = ex.a(context, new al(), false, false, null, evVar);
    }

    public void a(final a aVar) {
        this.lN.cb().a(new ey.a() {
            public void a(ex exVar) {
                aVar.aE();
            }
        });
    }

    public void a(String str, bc bcVar) {
        this.lN.cb().a(str, bcVar);
    }

    public void a(String str, JSONObject jSONObject) {
        this.lN.a(str, jSONObject);
    }

    public void d(String str) {
        this.lN.loadUrl(str);
    }

    public void e(String str) {
        this.lN.cb().a(str, null);
    }

    public void pause() {
        eo.a(this.lN);
    }

    public void resume() {
        eo.b(this.lN);
    }
}
