package lip.com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.internal.b;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class i extends df {
    private static final String ID = com.google.android.gms.internal.a.ARBITRARY_PIXEL.toString();
    private static final String URL = b.URL.toString();
    private static final String aem = b.ADDITIONAL_PARAMS.toString();
    private static final String aen = b.UNREPEATABLE.toString();
    static final String aeo = ("gtm_" + ID + "_unrepeatable");
    private static final Set<String> aep = new HashSet();
    private final a aeq;
    private final Context mContext;

    public interface a {
        aq li();
    }

    public i(final Context context) {
        this(context, new a() {
            public aq li() {
                return y.N(context);
            }
        });
    }

    i(Context context, a aVar) {
        super(ID, URL);
        this.aeq = aVar;
        this.mContext = context;
    }

    private synchronized boolean bB(String str) {
        boolean z = true;
        synchronized (this) {
            if (!bD(str)) {
                if (bC(str)) {
                    aep.add(str);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    boolean bC(String str) {
        return this.mContext.getSharedPreferences(aeo, 0).contains(str);
    }

    boolean bD(String str) {
        return aep.contains(str);
    }

    public void y(Map<String, com.google.android.gms.internal.d.a> map) {
        String j = map.get(aen) != null ? dh.j((com.google.android.gms.internal.d.a) map.get(aen)) : null;
        if (j == null || !bB(j)) {
            Builder buildUpon = Uri.parse(dh.j((com.google.android.gms.internal.d.a) map.get(URL))).buildUpon();
            com.google.android.gms.internal.d.a aVar = (com.google.android.gms.internal.d.a) map.get(aem);
            if (aVar != null) {
                Object o = dh.o(aVar);
                if (o instanceof List) {
                    for (Object o2 : (List) o2) {
                        if (o2 instanceof Map) {
                            for (Entry entry : ((Map) o2).entrySet()) {
                                buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                            }
                        } else {
                            bh.A("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + buildUpon.build().toString());
                            return;
                        }
                    }
                }
                bh.A("ArbitraryPixel: additional params not a list: not sending partial hit: " + buildUpon.build().toString());
                return;
            }
            String uri = buildUpon.build().toString();
            this.aeq.li().bR(uri);
            bh.C("ArbitraryPixel: url = " + uri);
            if (j != null) {
                synchronized (i.class) {
                    aep.add(j);
                    cy.a(this.mContext, aeo, j, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                }
            }
        }
    }
}
