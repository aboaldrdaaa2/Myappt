package lip.com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
    private static TagManager aig;
    private final DataLayer aeu;
    private final r agO;
    private final a aie;
    private final ConcurrentMap<n, Boolean> aif;
    private final Context mContext;

    interface a {
        o a(Context context, TagManager tagManager, Looper looper, String str, int i, r rVar);
    }

    TagManager(Context context, a containerHolderLoaderProvider, DataLayer dataLayer) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.aie = containerHolderLoaderProvider;
        this.aif = new ConcurrentHashMap();
        this.aeu = dataLayer;
        this.aeu.a(new b() {
            public void x(Map<String, Object> map) {
                Object obj = map.get(DataLayer.EVENT_KEY);
                if (obj != null) {
                    TagManager.this.cl(obj.toString());
                }
            }
        });
        this.aeu.a(new d(this.mContext));
        this.agO = new r();
    }

    private void cl(String str) {
        for (n bH : this.aif.keySet()) {
            bH.bH(str);
        }
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (aig == null) {
                if (context == null) {
                    bh.A("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                aig = new TagManager(context, new a() {
                    public o a(Context context, TagManager tagManager, Looper looper, String str, int i, r rVar) {
                        return new o(context, tagManager, looper, str, i, rVar);
                    }
                }, new DataLayer(new v(context)));
            }
            tagManager = aig;
        }
        return tagManager;
    }

    void a(n nVar) {
        this.aif.put(nVar, Boolean.valueOf(true));
    }

    boolean b(n nVar) {
        return this.aif.remove(nVar) != null;
    }

    public DataLayer getDataLayer() {
        return this.aeu;
    }

    synchronized boolean i(Uri uri) {
        boolean z;
        cd md = cd.md();
        if (md.i(uri)) {
            String containerId = md.getContainerId();
            switch (md.me()) {
                case NONE:
                    for (n nVar : this.aif.keySet()) {
                        if (nVar.getContainerId().equals(containerId)) {
                            nVar.bJ(null);
                            nVar.refresh();
                        }
                    }
                    break;
                case CONTAINER:
                case CONTAINER_DEBUG:
                    for (n nVar2 : this.aif.keySet()) {
                        if (nVar2.getContainerId().equals(containerId)) {
                            nVar2.bJ(md.mf());
                            nVar2.refresh();
                        } else if (nVar2.lo() != null) {
                            nVar2.bJ(null);
                            nVar2.refresh();
                        }
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.aie.a(this.mContext, this, null, containerId, defaultContainerResourceId, this.agO);
        a.lr();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.aie.a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.agO);
        a.lr();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.aie.a(this.mContext, this, null, containerId, defaultContainerResourceId, this.agO);
        a.lt();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.aie.a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.agO);
        a.lt();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.aie.a(this.mContext, this, null, containerId, defaultContainerResourceId, this.agO);
        a.ls();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.aie.a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.agO);
        a.ls();
        return a;
    }

    public void setVerboseLoggingEnabled(boolean enableVerboseLogging) {
        bh.setLogLevel(enableVerboseLogging ? 2 : 5);
    }
}
