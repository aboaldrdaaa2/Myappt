package lip.com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class at {
    public static final String DEVICE_ID_EMULATOR = et.y("emulator");
    private final Date d;
    private final Set<String> f;
    private final Location h;
    private final String mk;
    private final int ml;
    private final boolean mm;
    private final Bundle mn;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> mo;
    private final String mp;
    private final SearchAdRequest mq;
    private final int mr;
    private final Set<String> ms;

    public static final class a {
        private Date d;
        private Location h;
        private String mk;
        private int ml = -1;
        private boolean mm = false;
        private final Bundle mn = new Bundle();
        private String mp;
        private int mr = -1;
        private final HashSet<String> mt = new HashSet();
        private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> mu = new HashMap();
        private final HashSet<String> mv = new HashSet();

        public void a(Location location) {
            this.h = location;
        }

        @Deprecated
        public void a(NetworkExtras networkExtras) {
            if (networkExtras instanceof AdMobExtras) {
                a(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
            } else {
                this.mu.put(networkExtras.getClass(), networkExtras);
            }
        }

        public void a(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.mn.putBundle(cls.getName(), bundle);
        }

        public void a(Date date) {
            this.d = date;
        }

        public void b(Class<? extends CustomEvent> cls, Bundle bundle) {
            if (this.mn.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
                this.mn.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
            }
            this.mn.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
        }

        public void e(int i) {
            this.ml = i;
        }

        public void g(String str) {
            this.mt.add(str);
        }

        public void g(boolean z) {
            this.mm = z;
        }

        public void h(String str) {
            this.mv.add(str);
        }

        public void h(boolean z) {
            this.mr = z ? 1 : 0;
        }

        public void i(String str) {
            this.mk = str;
        }

        public void j(String str) {
            this.mp = str;
        }
    }

    public at(a aVar) {
        this(aVar, null);
    }

    public at(a aVar, SearchAdRequest searchAdRequest) {
        this.d = aVar.d;
        this.mk = aVar.mk;
        this.ml = aVar.ml;
        this.f = Collections.unmodifiableSet(aVar.mt);
        this.h = aVar.h;
        this.mm = aVar.mm;
        this.mn = aVar.mn;
        this.mo = Collections.unmodifiableMap(aVar.mu);
        this.mp = aVar.mp;
        this.mq = searchAdRequest;
        this.mr = aVar.mr;
        this.ms = Collections.unmodifiableSet(aVar.mv);
    }

    public SearchAdRequest aH() {
        return this.mq;
    }

    public Map<Class<? extends NetworkExtras>, NetworkExtras> aI() {
        return this.mo;
    }

    public Bundle aJ() {
        return this.mn;
    }

    public int aK() {
        return this.mr;
    }

    public Date getBirthday() {
        return this.d;
    }

    public String getContentUrl() {
        return this.mk;
    }

    public Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> adapterClass) {
        Bundle bundle = this.mn.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        return bundle != null ? bundle.getBundle(adapterClass.getClass().getName()) : null;
    }

    public int getGender() {
        return this.ml;
    }

    public Set<String> getKeywords() {
        return this.f;
    }

    public Location getLocation() {
        return this.h;
    }

    public boolean getManualImpressionsEnabled() {
        return this.mm;
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return (NetworkExtras) this.mo.get(networkExtrasClass);
    }

    public Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> adapterClass) {
        return this.mn.getBundle(adapterClass.getName());
    }

    public String getPublisherProvidedId() {
        return this.mp;
    }

    public boolean isTestDevice(Context context) {
        return this.ms.contains(et.r(context));
    }
}
