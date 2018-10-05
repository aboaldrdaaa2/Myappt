package lip.com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.c.f;
import com.google.android.gms.internal.c.i;
import com.google.android.gms.internal.c.j;
import com.google.android.gms.tagmanager.cq.c;
import com.google.android.gms.tagmanager.cq.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
    private final String aet;
    private final DataLayer aeu;
    private cs aev;
    private Map<String, FunctionCallMacroCallback> aew = new HashMap();
    private Map<String, FunctionCallTagCallback> aex = new HashMap();
    private volatile long aey;
    private volatile String aez = "";
    private final Context mContext;

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    private class a implements com.google.android.gms.tagmanager.s.a {
        private a() {
        }

        public Object b(String str, Map<String, Object> map) {
            FunctionCallMacroCallback bF = Container.this.bF(str);
            return bF == null ? null : bF.getValue(str, map);
        }
    }

    private class b implements com.google.android.gms.tagmanager.s.a {
        private b() {
        }

        public Object b(String str, Map<String, Object> map) {
            FunctionCallTagCallback bG = Container.this.bG(str);
            if (bG != null) {
                bG.execute(str, map);
            }
            return dh.nc();
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, j resource) {
        this.mContext = context;
        this.aeu = dataLayer;
        this.aet = containerId;
        this.aey = lastRefreshTime;
        a(resource.fK);
        if (resource.fJ != null) {
            a(resource.fJ);
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, c resource) {
        this.mContext = context;
        this.aeu = dataLayer;
        this.aet = containerId;
        this.aey = lastRefreshTime;
        a(resource);
    }

    private void a(f fVar) {
        if (fVar == null) {
            throw new NullPointerException();
        }
        try {
            a(cq.b(fVar));
        } catch (g e) {
            bh.A("Not loading resource: " + fVar + " because it is invalid: " + e.toString());
        }
    }

    private void a(c cVar) {
        this.aez = cVar.getVersion();
        c cVar2 = cVar;
        a(new cs(this.mContext, cVar2, this.aeu, new a(), new b(), bI(this.aez)));
    }

    private synchronized void a(cs csVar) {
        this.aev = csVar;
    }

    private void a(i[] iVarArr) {
        List arrayList = new ArrayList();
        for (Object add : iVarArr) {
            arrayList.add(add);
        }
        ln().h(arrayList);
    }

    private synchronized cs ln() {
        return this.aev;
    }

    FunctionCallMacroCallback bF(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.aew) {
            functionCallMacroCallback = (FunctionCallMacroCallback) this.aew.get(str);
        }
        return functionCallMacroCallback;
    }

    FunctionCallTagCallback bG(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.aex) {
            functionCallTagCallback = (FunctionCallTagCallback) this.aex.get(str);
        }
        return functionCallTagCallback;
    }

    void bH(String str) {
        ln().bH(str);
    }

    ag bI(String str) {
        if (cd.md().me().equals(a.CONTAINER_DEBUG)) {
        }
        return new bq();
    }

    public boolean getBoolean(String key) {
        cs ln = ln();
        if (ln == null) {
            bh.A("getBoolean called for closed container.");
            return dh.na().booleanValue();
        }
        try {
            return dh.n((com.google.android.gms.internal.d.a) ln.cj(key).getObject()).booleanValue();
        } catch (Exception e) {
            bh.A("Calling getBoolean() threw an exception: " + e.getMessage() + " Returning default value.");
            return dh.na().booleanValue();
        }
    }

    public String getContainerId() {
        return this.aet;
    }

    public double getDouble(String key) {
        cs ln = ln();
        if (ln == null) {
            bh.A("getDouble called for closed container.");
            return dh.mZ().doubleValue();
        }
        try {
            return dh.m((com.google.android.gms.internal.d.a) ln.cj(key).getObject()).doubleValue();
        } catch (Exception e) {
            bh.A("Calling getDouble() threw an exception: " + e.getMessage() + " Returning default value.");
            return dh.mZ().doubleValue();
        }
    }

    public long getLastRefreshTime() {
        return this.aey;
    }

    public long getLong(String key) {
        cs ln = ln();
        if (ln == null) {
            bh.A("getLong called for closed container.");
            return dh.mY().longValue();
        }
        try {
            return dh.l((com.google.android.gms.internal.d.a) ln.cj(key).getObject()).longValue();
        } catch (Exception e) {
            bh.A("Calling getLong() threw an exception: " + e.getMessage() + " Returning default value.");
            return dh.mY().longValue();
        }
    }

    public String getString(String key) {
        cs ln = ln();
        if (ln == null) {
            bh.A("getString called for closed container.");
            return dh.nc();
        }
        try {
            return dh.j((com.google.android.gms.internal.d.a) ln.cj(key).getObject());
        } catch (Exception e) {
            bh.A("Calling getString() threw an exception: " + e.getMessage() + " Returning default value.");
            return dh.nc();
        }
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    String lm() {
        return this.aez;
    }

    public void registerFunctionCallMacroCallback(String customMacroName, FunctionCallMacroCallback customMacroCallback) {
        if (customMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.aew) {
            this.aew.put(customMacroName, customMacroCallback);
        }
    }

    public void registerFunctionCallTagCallback(String customTagName, FunctionCallTagCallback customTagCallback) {
        if (customTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.aex) {
            this.aex.put(customTagName, customTagCallback);
        }
    }

    void release() {
        this.aev = null;
    }

    public void unregisterFunctionCallMacroCallback(String customMacroName) {
        synchronized (this.aew) {
            this.aew.remove(customMacroName);
        }
    }

    public void unregisterFunctionCallTagCallback(String customTagName) {
        synchronized (this.aex) {
            this.aex.remove(customTagName);
        }
    }
}
