package lip.com.google.android.gms.internal;

import android.os.Parcel;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.MMRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class ks extends hy implements SafeParcelable, Person {
    public static final kt CREATOR = new kt();
    private static final HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> acr = new HashMap();
    private String Ar;
    private String Ln;
    private final Set<Integer> acs;
    private String adA;
    private int adB;
    private List<f> adC;
    private List<g> adD;
    private int adE;
    private int adF;
    private String adG;
    private List<h> adH;
    private boolean adI;
    private String adq;
    private a adr;
    private String ads;
    private String adt;
    private int adu;
    private b adv;
    private String adw;
    private c adx;
    private boolean ady;
    private d adz;
    private int ml;
    private String qY;
    private String xG;
    private final int xM;

    public static class e {
        public static int bA(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    public static final class a extends hy implements SafeParcelable, AgeRange {
        public static final ku CREATOR = new ku();
        private static final HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> acr = new HashMap();
        private final Set<Integer> acs;
        private int adJ;
        private int adK;
        private final int xM;

        static {
            acr.put("max", com.google.android.gms.internal.hy.a.g("max", 2));
            acr.put("min", com.google.android.gms.internal.hy.a.g("min", 3));
        }

        public a() {
            this.xM = 1;
            this.acs = new HashSet();
        }

        a(Set<Integer> set, int i, int i2, int i3) {
            this.acs = set;
            this.xM = i;
            this.adJ = i2;
            this.adK = i3;
        }

        protected boolean a(com.google.android.gms.internal.hy.a aVar) {
            return this.acs.contains(Integer.valueOf(aVar.fN()));
        }

        protected Object aF(String str) {
            return null;
        }

        protected boolean aG(String str) {
            return false;
        }

        protected Object b(com.google.android.gms.internal.hy.a aVar) {
            switch (aVar.fN()) {
                case 2:
                    return Integer.valueOf(this.adJ);
                case 3:
                    return Integer.valueOf(this.adK);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.fN());
            }
        }

        public int describeContents() {
            ku kuVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ks.a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ks.a aVar = (ks.a) obj;
            for (com.google.android.gms.internal.hy.a aVar2 : acr.values()) {
                if (a(aVar2)) {
                    if (!aVar.a(aVar2)) {
                        return false;
                    }
                    if (!b(aVar2).equals(aVar.b(aVar2))) {
                        return false;
                    }
                } else if (aVar.a(aVar2)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> fG() {
            return acr;
        }

        public int getMax() {
            return this.adJ;
        }

        public int getMin() {
            return this.adK;
        }

        int getVersionCode() {
            return this.xM;
        }

        public boolean hasMax() {
            return this.acs.contains(Integer.valueOf(2));
        }

        public boolean hasMin() {
            return this.acs.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            Iterator it = acr.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                com.google.android.gms.internal.hy.a aVar = (com.google.android.gms.internal.hy.a) it.next();
                if (a(aVar)) {
                    i = b(aVar).hashCode() + (i2 + aVar.fN());
                } else {
                    i = i2;
                }
            }
        }

        public boolean isDataValid() {
            return true;
        }

        /* renamed from: kN */
        public ks.a freeze() {
            return this;
        }

        Set<Integer> kk() {
            return this.acs;
        }

        public void writeToParcel(Parcel out, int flags) {
            ku kuVar = CREATOR;
            ku.a(this, out, flags);
        }
    }

    public static final class b extends hy implements SafeParcelable, Cover {
        public static final kv CREATOR = new kv();
        private static final HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> acr = new HashMap();
        private final Set<Integer> acs;
        private a adL;
        private b adM;
        private int adN;
        private final int xM;

        public static final class a extends hy implements SafeParcelable, CoverInfo {
            public static final kw CREATOR = new kw();
            private static final HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> acr = new HashMap();
            private final Set<Integer> acs;
            private int adO;
            private int adP;
            private final int xM;

            static {
                acr.put("leftImageOffset", com.google.android.gms.internal.hy.a.g("leftImageOffset", 2));
                acr.put("topImageOffset", com.google.android.gms.internal.hy.a.g("topImageOffset", 3));
            }

            public a() {
                this.xM = 1;
                this.acs = new HashSet();
            }

            a(Set<Integer> set, int i, int i2, int i3) {
                this.acs = set;
                this.xM = i;
                this.adO = i2;
                this.adP = i3;
            }

            protected boolean a(com.google.android.gms.internal.hy.a aVar) {
                return this.acs.contains(Integer.valueOf(aVar.fN()));
            }

            protected Object aF(String str) {
                return null;
            }

            protected boolean aG(String str) {
                return false;
            }

            protected Object b(com.google.android.gms.internal.hy.a aVar) {
                switch (aVar.fN()) {
                    case 2:
                        return Integer.valueOf(this.adO);
                    case 3:
                        return Integer.valueOf(this.adP);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + aVar.fN());
                }
            }

            public int describeContents() {
                kw kwVar = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof ks.b.a)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                ks.b.a aVar = (ks.b.a) obj;
                for (com.google.android.gms.internal.hy.a aVar2 : acr.values()) {
                    if (a(aVar2)) {
                        if (!aVar.a(aVar2)) {
                            return false;
                        }
                        if (!b(aVar2).equals(aVar.b(aVar2))) {
                            return false;
                        }
                    } else if (aVar.a(aVar2)) {
                        return false;
                    }
                }
                return true;
            }

            public HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> fG() {
                return acr;
            }

            public int getLeftImageOffset() {
                return this.adO;
            }

            public int getTopImageOffset() {
                return this.adP;
            }

            int getVersionCode() {
                return this.xM;
            }

            public boolean hasLeftImageOffset() {
                return this.acs.contains(Integer.valueOf(2));
            }

            public boolean hasTopImageOffset() {
                return this.acs.contains(Integer.valueOf(3));
            }

            public int hashCode() {
                int i = 0;
                Iterator it = acr.values().iterator();
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        return i2;
                    }
                    com.google.android.gms.internal.hy.a aVar = (com.google.android.gms.internal.hy.a) it.next();
                    if (a(aVar)) {
                        i = b(aVar).hashCode() + (i2 + aVar.fN());
                    } else {
                        i = i2;
                    }
                }
            }

            public boolean isDataValid() {
                return true;
            }

            /* renamed from: kR */
            public ks.b.a freeze() {
                return this;
            }

            Set<Integer> kk() {
                return this.acs;
            }

            public void writeToParcel(Parcel out, int flags) {
                kw kwVar = CREATOR;
                kw.a(this, out, flags);
            }
        }

        public static final class b extends hy implements SafeParcelable, CoverPhoto {
            public static final kx CREATOR = new kx();
            private static final HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> acr = new HashMap();
            private final Set<Integer> acs;
            private int ku;
            private int kv;
            private String qY;
            private final int xM;

            static {
                acr.put(MMLayout.KEY_HEIGHT, com.google.android.gms.internal.hy.a.g(MMLayout.KEY_HEIGHT, 2));
                acr.put("url", com.google.android.gms.internal.hy.a.j("url", 3));
                acr.put(MMLayout.KEY_WIDTH, com.google.android.gms.internal.hy.a.g(MMLayout.KEY_WIDTH, 4));
            }

            public b() {
                this.xM = 1;
                this.acs = new HashSet();
            }

            b(Set<Integer> set, int i, int i2, String str, int i3) {
                this.acs = set;
                this.xM = i;
                this.kv = i2;
                this.qY = str;
                this.ku = i3;
            }

            protected boolean a(com.google.android.gms.internal.hy.a aVar) {
                return this.acs.contains(Integer.valueOf(aVar.fN()));
            }

            protected Object aF(String str) {
                return null;
            }

            protected boolean aG(String str) {
                return false;
            }

            protected Object b(com.google.android.gms.internal.hy.a aVar) {
                switch (aVar.fN()) {
                    case 2:
                        return Integer.valueOf(this.kv);
                    case 3:
                        return this.qY;
                    case 4:
                        return Integer.valueOf(this.ku);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + aVar.fN());
                }
            }

            public int describeContents() {
                kx kxVar = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof ks.b.b)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                ks.b.b bVar = (ks.b.b) obj;
                for (com.google.android.gms.internal.hy.a aVar : acr.values()) {
                    if (a(aVar)) {
                        if (!bVar.a(aVar)) {
                            return false;
                        }
                        if (!b(aVar).equals(bVar.b(aVar))) {
                            return false;
                        }
                    } else if (bVar.a(aVar)) {
                        return false;
                    }
                }
                return true;
            }

            public HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> fG() {
                return acr;
            }

            public int getHeight() {
                return this.kv;
            }

            public String getUrl() {
                return this.qY;
            }

            int getVersionCode() {
                return this.xM;
            }

            public int getWidth() {
                return this.ku;
            }

            public boolean hasHeight() {
                return this.acs.contains(Integer.valueOf(2));
            }

            public boolean hasUrl() {
                return this.acs.contains(Integer.valueOf(3));
            }

            public boolean hasWidth() {
                return this.acs.contains(Integer.valueOf(4));
            }

            public int hashCode() {
                int i = 0;
                Iterator it = acr.values().iterator();
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        return i2;
                    }
                    com.google.android.gms.internal.hy.a aVar = (com.google.android.gms.internal.hy.a) it.next();
                    if (a(aVar)) {
                        i = b(aVar).hashCode() + (i2 + aVar.fN());
                    } else {
                        i = i2;
                    }
                }
            }

            public boolean isDataValid() {
                return true;
            }

            /* renamed from: kS */
            public ks.b.b freeze() {
                return this;
            }

            Set<Integer> kk() {
                return this.acs;
            }

            public void writeToParcel(Parcel out, int flags) {
                kx kxVar = CREATOR;
                kx.a(this, out, flags);
            }
        }

        static {
            acr.put("coverInfo", com.google.android.gms.internal.hy.a.a("coverInfo", 2, a.class));
            acr.put("coverPhoto", com.google.android.gms.internal.hy.a.a("coverPhoto", 3, b.class));
            acr.put("layout", com.google.android.gms.internal.hy.a.a("layout", 4, new hv().f("banner", 0), false));
        }

        public b() {
            this.xM = 1;
            this.acs = new HashSet();
        }

        b(Set<Integer> set, int i, a aVar, b bVar, int i2) {
            this.acs = set;
            this.xM = i;
            this.adL = aVar;
            this.adM = bVar;
            this.adN = i2;
        }

        protected boolean a(com.google.android.gms.internal.hy.a aVar) {
            return this.acs.contains(Integer.valueOf(aVar.fN()));
        }

        protected Object aF(String str) {
            return null;
        }

        protected boolean aG(String str) {
            return false;
        }

        protected Object b(com.google.android.gms.internal.hy.a aVar) {
            switch (aVar.fN()) {
                case 2:
                    return this.adL;
                case 3:
                    return this.adM;
                case 4:
                    return Integer.valueOf(this.adN);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.fN());
            }
        }

        public int describeContents() {
            kv kvVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            b bVar = (b) obj;
            for (com.google.android.gms.internal.hy.a aVar : acr.values()) {
                if (a(aVar)) {
                    if (!bVar.a(aVar)) {
                        return false;
                    }
                    if (!b(aVar).equals(bVar.b(aVar))) {
                        return false;
                    }
                } else if (bVar.a(aVar)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> fG() {
            return acr;
        }

        public CoverInfo getCoverInfo() {
            return this.adL;
        }

        public CoverPhoto getCoverPhoto() {
            return this.adM;
        }

        public int getLayout() {
            return this.adN;
        }

        int getVersionCode() {
            return this.xM;
        }

        public boolean hasCoverInfo() {
            return this.acs.contains(Integer.valueOf(2));
        }

        public boolean hasCoverPhoto() {
            return this.acs.contains(Integer.valueOf(3));
        }

        public boolean hasLayout() {
            return this.acs.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            Iterator it = acr.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                com.google.android.gms.internal.hy.a aVar = (com.google.android.gms.internal.hy.a) it.next();
                if (a(aVar)) {
                    i = b(aVar).hashCode() + (i2 + aVar.fN());
                } else {
                    i = i2;
                }
            }
        }

        public boolean isDataValid() {
            return true;
        }

        a kO() {
            return this.adL;
        }

        b kP() {
            return this.adM;
        }

        /* renamed from: kQ */
        public b freeze() {
            return this;
        }

        Set<Integer> kk() {
            return this.acs;
        }

        public void writeToParcel(Parcel out, int flags) {
            kv kvVar = CREATOR;
            kv.a(this, out, flags);
        }
    }

    public static final class c extends hy implements SafeParcelable, Image {
        public static final ky CREATOR = new ky();
        private static final HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> acr = new HashMap();
        private final Set<Integer> acs;
        private String qY;
        private final int xM;

        static {
            acr.put("url", com.google.android.gms.internal.hy.a.j("url", 2));
        }

        public c() {
            this.xM = 1;
            this.acs = new HashSet();
        }

        public c(String str) {
            this.acs = new HashSet();
            this.xM = 1;
            this.qY = str;
            this.acs.add(Integer.valueOf(2));
        }

        c(Set<Integer> set, int i, String str) {
            this.acs = set;
            this.xM = i;
            this.qY = str;
        }

        protected boolean a(com.google.android.gms.internal.hy.a aVar) {
            return this.acs.contains(Integer.valueOf(aVar.fN()));
        }

        protected Object aF(String str) {
            return null;
        }

        protected boolean aG(String str) {
            return false;
        }

        protected Object b(com.google.android.gms.internal.hy.a aVar) {
            switch (aVar.fN()) {
                case 2:
                    return this.qY;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.fN());
            }
        }

        public int describeContents() {
            ky kyVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            c cVar = (c) obj;
            for (com.google.android.gms.internal.hy.a aVar : acr.values()) {
                if (a(aVar)) {
                    if (!cVar.a(aVar)) {
                        return false;
                    }
                    if (!b(aVar).equals(cVar.b(aVar))) {
                        return false;
                    }
                } else if (cVar.a(aVar)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> fG() {
            return acr;
        }

        public String getUrl() {
            return this.qY;
        }

        int getVersionCode() {
            return this.xM;
        }

        public boolean hasUrl() {
            return this.acs.contains(Integer.valueOf(2));
        }

        public int hashCode() {
            int i = 0;
            Iterator it = acr.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                com.google.android.gms.internal.hy.a aVar = (com.google.android.gms.internal.hy.a) it.next();
                if (a(aVar)) {
                    i = b(aVar).hashCode() + (i2 + aVar.fN());
                } else {
                    i = i2;
                }
            }
        }

        public boolean isDataValid() {
            return true;
        }

        /* renamed from: kT */
        public c freeze() {
            return this;
        }

        Set<Integer> kk() {
            return this.acs;
        }

        public void writeToParcel(Parcel out, int flags) {
            ky kyVar = CREATOR;
            ky.a(this, out, flags);
        }
    }

    public static final class d extends hy implements SafeParcelable, Name {
        public static final kz CREATOR = new kz();
        private static final HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> acr = new HashMap();
        private String acQ;
        private String acT;
        private final Set<Integer> acs;
        private String adQ;
        private String adR;
        private String adS;
        private String adT;
        private final int xM;

        static {
            acr.put("familyName", com.google.android.gms.internal.hy.a.j("familyName", 2));
            acr.put("formatted", com.google.android.gms.internal.hy.a.j("formatted", 3));
            acr.put("givenName", com.google.android.gms.internal.hy.a.j("givenName", 4));
            acr.put("honorificPrefix", com.google.android.gms.internal.hy.a.j("honorificPrefix", 5));
            acr.put("honorificSuffix", com.google.android.gms.internal.hy.a.j("honorificSuffix", 6));
            acr.put("middleName", com.google.android.gms.internal.hy.a.j("middleName", 7));
        }

        public d() {
            this.xM = 1;
            this.acs = new HashSet();
        }

        d(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.acs = set;
            this.xM = i;
            this.acQ = str;
            this.adQ = str2;
            this.acT = str3;
            this.adR = str4;
            this.adS = str5;
            this.adT = str6;
        }

        protected boolean a(com.google.android.gms.internal.hy.a aVar) {
            return this.acs.contains(Integer.valueOf(aVar.fN()));
        }

        protected Object aF(String str) {
            return null;
        }

        protected boolean aG(String str) {
            return false;
        }

        protected Object b(com.google.android.gms.internal.hy.a aVar) {
            switch (aVar.fN()) {
                case 2:
                    return this.acQ;
                case 3:
                    return this.adQ;
                case 4:
                    return this.acT;
                case 5:
                    return this.adR;
                case 6:
                    return this.adS;
                case 7:
                    return this.adT;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.fN());
            }
        }

        public int describeContents() {
            kz kzVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            d dVar = (d) obj;
            for (com.google.android.gms.internal.hy.a aVar : acr.values()) {
                if (a(aVar)) {
                    if (!dVar.a(aVar)) {
                        return false;
                    }
                    if (!b(aVar).equals(dVar.b(aVar))) {
                        return false;
                    }
                } else if (dVar.a(aVar)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> fG() {
            return acr;
        }

        public String getFamilyName() {
            return this.acQ;
        }

        public String getFormatted() {
            return this.adQ;
        }

        public String getGivenName() {
            return this.acT;
        }

        public String getHonorificPrefix() {
            return this.adR;
        }

        public String getHonorificSuffix() {
            return this.adS;
        }

        public String getMiddleName() {
            return this.adT;
        }

        int getVersionCode() {
            return this.xM;
        }

        public boolean hasFamilyName() {
            return this.acs.contains(Integer.valueOf(2));
        }

        public boolean hasFormatted() {
            return this.acs.contains(Integer.valueOf(3));
        }

        public boolean hasGivenName() {
            return this.acs.contains(Integer.valueOf(4));
        }

        public boolean hasHonorificPrefix() {
            return this.acs.contains(Integer.valueOf(5));
        }

        public boolean hasHonorificSuffix() {
            return this.acs.contains(Integer.valueOf(6));
        }

        public boolean hasMiddleName() {
            return this.acs.contains(Integer.valueOf(7));
        }

        public int hashCode() {
            int i = 0;
            Iterator it = acr.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                com.google.android.gms.internal.hy.a aVar = (com.google.android.gms.internal.hy.a) it.next();
                if (a(aVar)) {
                    i = b(aVar).hashCode() + (i2 + aVar.fN());
                } else {
                    i = i2;
                }
            }
        }

        public boolean isDataValid() {
            return true;
        }

        /* renamed from: kU */
        public d freeze() {
            return this;
        }

        Set<Integer> kk() {
            return this.acs;
        }

        public void writeToParcel(Parcel out, int flags) {
            kz kzVar = CREATOR;
            kz.a(this, out, flags);
        }
    }

    public static final class f extends hy implements SafeParcelable, Organizations {
        public static final la CREATOR = new la();
        private static final HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> acr = new HashMap();
        private int AT;
        private String HY;
        private String Mp;
        private String acP;
        private final Set<Integer> acs;
        private String adU;
        private String adV;
        private boolean adW;
        private String adf;
        private String mName;
        private final int xM;

        static {
            acr.put("department", com.google.android.gms.internal.hy.a.j("department", 2));
            acr.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, com.google.android.gms.internal.hy.a.j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 3));
            acr.put("endDate", com.google.android.gms.internal.hy.a.j("endDate", 4));
            acr.put("location", com.google.android.gms.internal.hy.a.j("location", 5));
            acr.put("name", com.google.android.gms.internal.hy.a.j("name", 6));
            acr.put("primary", com.google.android.gms.internal.hy.a.i("primary", 7));
            acr.put("startDate", com.google.android.gms.internal.hy.a.j("startDate", 8));
            acr.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, com.google.android.gms.internal.hy.a.j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 9));
            acr.put("type", com.google.android.gms.internal.hy.a.a("type", 10, new hv().f("work", 0).f("school", 1), false));
        }

        public f() {
            this.xM = 1;
            this.acs = new HashSet();
        }

        f(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.acs = set;
            this.xM = i;
            this.adU = str;
            this.Mp = str2;
            this.acP = str3;
            this.adV = str4;
            this.mName = str5;
            this.adW = z;
            this.adf = str6;
            this.HY = str7;
            this.AT = i2;
        }

        protected boolean a(com.google.android.gms.internal.hy.a aVar) {
            return this.acs.contains(Integer.valueOf(aVar.fN()));
        }

        protected Object aF(String str) {
            return null;
        }

        protected boolean aG(String str) {
            return false;
        }

        protected Object b(com.google.android.gms.internal.hy.a aVar) {
            switch (aVar.fN()) {
                case 2:
                    return this.adU;
                case 3:
                    return this.Mp;
                case 4:
                    return this.acP;
                case 5:
                    return this.adV;
                case 6:
                    return this.mName;
                case 7:
                    return Boolean.valueOf(this.adW);
                case 8:
                    return this.adf;
                case 9:
                    return this.HY;
                case 10:
                    return Integer.valueOf(this.AT);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.fN());
            }
        }

        public int describeContents() {
            la laVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof f)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            f fVar = (f) obj;
            for (com.google.android.gms.internal.hy.a aVar : acr.values()) {
                if (a(aVar)) {
                    if (!fVar.a(aVar)) {
                        return false;
                    }
                    if (!b(aVar).equals(fVar.b(aVar))) {
                        return false;
                    }
                } else if (fVar.a(aVar)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> fG() {
            return acr;
        }

        public String getDepartment() {
            return this.adU;
        }

        public String getDescription() {
            return this.Mp;
        }

        public String getEndDate() {
            return this.acP;
        }

        public String getLocation() {
            return this.adV;
        }

        public String getName() {
            return this.mName;
        }

        public String getStartDate() {
            return this.adf;
        }

        public String getTitle() {
            return this.HY;
        }

        public int getType() {
            return this.AT;
        }

        int getVersionCode() {
            return this.xM;
        }

        public boolean hasDepartment() {
            return this.acs.contains(Integer.valueOf(2));
        }

        public boolean hasDescription() {
            return this.acs.contains(Integer.valueOf(3));
        }

        public boolean hasEndDate() {
            return this.acs.contains(Integer.valueOf(4));
        }

        public boolean hasLocation() {
            return this.acs.contains(Integer.valueOf(5));
        }

        public boolean hasName() {
            return this.acs.contains(Integer.valueOf(6));
        }

        public boolean hasPrimary() {
            return this.acs.contains(Integer.valueOf(7));
        }

        public boolean hasStartDate() {
            return this.acs.contains(Integer.valueOf(8));
        }

        public boolean hasTitle() {
            return this.acs.contains(Integer.valueOf(9));
        }

        public boolean hasType() {
            return this.acs.contains(Integer.valueOf(10));
        }

        public int hashCode() {
            int i = 0;
            Iterator it = acr.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                com.google.android.gms.internal.hy.a aVar = (com.google.android.gms.internal.hy.a) it.next();
                if (a(aVar)) {
                    i = b(aVar).hashCode() + (i2 + aVar.fN());
                } else {
                    i = i2;
                }
            }
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.adW;
        }

        /* renamed from: kV */
        public f freeze() {
            return this;
        }

        Set<Integer> kk() {
            return this.acs;
        }

        public void writeToParcel(Parcel out, int flags) {
            la laVar = CREATOR;
            la.a(this, out, flags);
        }
    }

    public static final class g extends hy implements SafeParcelable, PlacesLived {
        public static final lb CREATOR = new lb();
        private static final HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> acr = new HashMap();
        private final Set<Integer> acs;
        private boolean adW;
        private String mValue;
        private final int xM;

        static {
            acr.put("primary", com.google.android.gms.internal.hy.a.i("primary", 2));
            acr.put("value", com.google.android.gms.internal.hy.a.j("value", 3));
        }

        public g() {
            this.xM = 1;
            this.acs = new HashSet();
        }

        g(Set<Integer> set, int i, boolean z, String str) {
            this.acs = set;
            this.xM = i;
            this.adW = z;
            this.mValue = str;
        }

        protected boolean a(com.google.android.gms.internal.hy.a aVar) {
            return this.acs.contains(Integer.valueOf(aVar.fN()));
        }

        protected Object aF(String str) {
            return null;
        }

        protected boolean aG(String str) {
            return false;
        }

        protected Object b(com.google.android.gms.internal.hy.a aVar) {
            switch (aVar.fN()) {
                case 2:
                    return Boolean.valueOf(this.adW);
                case 3:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.fN());
            }
        }

        public int describeContents() {
            lb lbVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof g)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            g gVar = (g) obj;
            for (com.google.android.gms.internal.hy.a aVar : acr.values()) {
                if (a(aVar)) {
                    if (!gVar.a(aVar)) {
                        return false;
                    }
                    if (!b(aVar).equals(gVar.b(aVar))) {
                        return false;
                    }
                } else if (gVar.a(aVar)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> fG() {
            return acr;
        }

        public String getValue() {
            return this.mValue;
        }

        int getVersionCode() {
            return this.xM;
        }

        public boolean hasPrimary() {
            return this.acs.contains(Integer.valueOf(2));
        }

        public boolean hasValue() {
            return this.acs.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            Iterator it = acr.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                com.google.android.gms.internal.hy.a aVar = (com.google.android.gms.internal.hy.a) it.next();
                if (a(aVar)) {
                    i = b(aVar).hashCode() + (i2 + aVar.fN());
                } else {
                    i = i2;
                }
            }
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.adW;
        }

        /* renamed from: kW */
        public g freeze() {
            return this;
        }

        Set<Integer> kk() {
            return this.acs;
        }

        public void writeToParcel(Parcel out, int flags) {
            lb lbVar = CREATOR;
            lb.a(this, out, flags);
        }
    }

    public static final class h extends hy implements SafeParcelable, Urls {
        public static final lc CREATOR = new lc();
        private static final HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> acr = new HashMap();
        private int AT;
        private final Set<Integer> acs;
        private String adX;
        private final int adY;
        private String mValue;
        private final int xM;

        static {
            acr.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, com.google.android.gms.internal.hy.a.j(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            acr.put("type", com.google.android.gms.internal.hy.a.a("type", 6, new hv().f("home", 0).f("work", 1).f("blog", 2).f(Scopes.PROFILE, 3).f("other", 4).f("otherProfile", 5).f("contributor", 6).f("website", 7), false));
            acr.put("value", com.google.android.gms.internal.hy.a.j("value", 4));
        }

        public h() {
            this.adY = 4;
            this.xM = 2;
            this.acs = new HashSet();
        }

        h(Set<Integer> set, int i, String str, int i2, String str2, int i3) {
            this.adY = 4;
            this.acs = set;
            this.xM = i;
            this.adX = str;
            this.AT = i2;
            this.mValue = str2;
        }

        protected boolean a(com.google.android.gms.internal.hy.a aVar) {
            return this.acs.contains(Integer.valueOf(aVar.fN()));
        }

        protected Object aF(String str) {
            return null;
        }

        protected boolean aG(String str) {
            return false;
        }

        protected Object b(com.google.android.gms.internal.hy.a aVar) {
            switch (aVar.fN()) {
                case 4:
                    return this.mValue;
                case 5:
                    return this.adX;
                case 6:
                    return Integer.valueOf(this.AT);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.fN());
            }
        }

        public int describeContents() {
            lc lcVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof h)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            h hVar = (h) obj;
            for (com.google.android.gms.internal.hy.a aVar : acr.values()) {
                if (a(aVar)) {
                    if (!hVar.a(aVar)) {
                        return false;
                    }
                    if (!b(aVar).equals(hVar.b(aVar))) {
                        return false;
                    }
                } else if (hVar.a(aVar)) {
                    return false;
                }
            }
            return true;
        }

        public HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> fG() {
            return acr;
        }

        public String getLabel() {
            return this.adX;
        }

        public int getType() {
            return this.AT;
        }

        public String getValue() {
            return this.mValue;
        }

        int getVersionCode() {
            return this.xM;
        }

        public boolean hasLabel() {
            return this.acs.contains(Integer.valueOf(5));
        }

        public boolean hasType() {
            return this.acs.contains(Integer.valueOf(6));
        }

        public boolean hasValue() {
            return this.acs.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            Iterator it = acr.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                com.google.android.gms.internal.hy.a aVar = (com.google.android.gms.internal.hy.a) it.next();
                if (a(aVar)) {
                    i = b(aVar).hashCode() + (i2 + aVar.fN());
                } else {
                    i = i2;
                }
            }
        }

        public boolean isDataValid() {
            return true;
        }

        @Deprecated
        public int kX() {
            return 4;
        }

        /* renamed from: kY */
        public h freeze() {
            return this;
        }

        Set<Integer> kk() {
            return this.acs;
        }

        public void writeToParcel(Parcel out, int flags) {
            lc lcVar = CREATOR;
            lc.a(this, out, flags);
        }
    }

    static {
        acr.put("aboutMe", com.google.android.gms.internal.hy.a.j("aboutMe", 2));
        acr.put("ageRange", com.google.android.gms.internal.hy.a.a("ageRange", 3, a.class));
        acr.put("birthday", com.google.android.gms.internal.hy.a.j("birthday", 4));
        acr.put("braggingRights", com.google.android.gms.internal.hy.a.j("braggingRights", 5));
        acr.put("circledByCount", com.google.android.gms.internal.hy.a.g("circledByCount", 6));
        acr.put("cover", com.google.android.gms.internal.hy.a.a("cover", 7, b.class));
        acr.put("currentLocation", com.google.android.gms.internal.hy.a.j("currentLocation", 8));
        acr.put("displayName", com.google.android.gms.internal.hy.a.j("displayName", 9));
        acr.put(MMRequest.KEY_GENDER, com.google.android.gms.internal.hy.a.a(MMRequest.KEY_GENDER, 12, new hv().f(MMRequest.GENDER_MALE, 0).f(MMRequest.GENDER_FEMALE, 1).f("other", 2), false));
        acr.put("id", com.google.android.gms.internal.hy.a.j("id", 14));
        acr.put("image", com.google.android.gms.internal.hy.a.a("image", 15, c.class));
        acr.put("isPlusUser", com.google.android.gms.internal.hy.a.i("isPlusUser", 16));
        acr.put("language", com.google.android.gms.internal.hy.a.j("language", 18));
        acr.put("name", com.google.android.gms.internal.hy.a.a("name", 19, d.class));
        acr.put("nickname", com.google.android.gms.internal.hy.a.j("nickname", 20));
        acr.put("objectType", com.google.android.gms.internal.hy.a.a("objectType", 21, new hv().f("person", 0).f("page", 1), false));
        acr.put("organizations", com.google.android.gms.internal.hy.a.b("organizations", 22, f.class));
        acr.put("placesLived", com.google.android.gms.internal.hy.a.b("placesLived", 23, g.class));
        acr.put("plusOneCount", com.google.android.gms.internal.hy.a.g("plusOneCount", 24));
        acr.put("relationshipStatus", com.google.android.gms.internal.hy.a.a("relationshipStatus", 25, new hv().f(MMRequest.MARITAL_SINGLE, 0).f("in_a_relationship", 1).f(MMRequest.MARITAL_ENGAGED, 2).f(MMRequest.MARITAL_MARRIED, 3).f("its_complicated", 4).f("open_relationship", 5).f("widowed", 6).f("in_domestic_partnership", 7).f("in_civil_union", 8), false));
        acr.put("tagline", com.google.android.gms.internal.hy.a.j("tagline", 26));
        acr.put("url", com.google.android.gms.internal.hy.a.j("url", 27));
        acr.put("urls", com.google.android.gms.internal.hy.a.b("urls", 28, h.class));
        acr.put("verified", com.google.android.gms.internal.hy.a.i("verified", 29));
    }

    public ks() {
        this.xM = 2;
        this.acs = new HashSet();
    }

    public ks(String str, String str2, c cVar, int i, String str3) {
        this.xM = 2;
        this.acs = new HashSet();
        this.Ln = str;
        this.acs.add(Integer.valueOf(9));
        this.xG = str2;
        this.acs.add(Integer.valueOf(14));
        this.adx = cVar;
        this.acs.add(Integer.valueOf(15));
        this.adB = i;
        this.acs.add(Integer.valueOf(21));
        this.qY = str3;
        this.acs.add(Integer.valueOf(27));
    }

    ks(Set<Integer> set, int i, String str, a aVar, String str2, String str3, int i2, b bVar, String str4, String str5, int i3, String str6, c cVar, boolean z, String str7, d dVar, String str8, int i4, List<f> list, List<g> list2, int i5, int i6, String str9, String str10, List<h> list3, boolean z2) {
        this.acs = set;
        this.xM = i;
        this.adq = str;
        this.adr = aVar;
        this.ads = str2;
        this.adt = str3;
        this.adu = i2;
        this.adv = bVar;
        this.adw = str4;
        this.Ln = str5;
        this.ml = i3;
        this.xG = str6;
        this.adx = cVar;
        this.ady = z;
        this.Ar = str7;
        this.adz = dVar;
        this.adA = str8;
        this.adB = i4;
        this.adC = list;
        this.adD = list2;
        this.adE = i5;
        this.adF = i6;
        this.adG = str9;
        this.qY = str10;
        this.adH = list3;
        this.adI = z2;
    }

    public static ks i(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        ks bG = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return bG;
    }

    protected boolean a(com.google.android.gms.internal.hy.a aVar) {
        return this.acs.contains(Integer.valueOf(aVar.fN()));
    }

    protected Object aF(String str) {
        return null;
    }

    protected boolean aG(String str) {
        return false;
    }

    protected Object b(com.google.android.gms.internal.hy.a aVar) {
        switch (aVar.fN()) {
            case 2:
                return this.adq;
            case 3:
                return this.adr;
            case 4:
                return this.ads;
            case 5:
                return this.adt;
            case 6:
                return Integer.valueOf(this.adu);
            case 7:
                return this.adv;
            case 8:
                return this.adw;
            case 9:
                return this.Ln;
            case 12:
                return Integer.valueOf(this.ml);
            case 14:
                return this.xG;
            case 15:
                return this.adx;
            case 16:
                return Boolean.valueOf(this.ady);
            case 18:
                return this.Ar;
            case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                return this.adz;
            case MMException.DISPLAY_AD_NOT_READY /*20*/:
                return this.adA;
            case MMException.DISPLAY_AD_EXPIRED /*21*/:
                return Integer.valueOf(this.adB);
            case MMException.DISPLAY_AD_NOT_FOUND /*22*/:
                return this.adC;
            case MMException.DISPLAY_AD_ALREADY_DISPLAYED /*23*/:
                return this.adD;
            case MMException.DISPLAY_AD_NOT_PERMITTED /*24*/:
                return Integer.valueOf(this.adE);
            case MMException.AD_BROKEN_REFERENCE /*25*/:
                return Integer.valueOf(this.adF);
            case MMException.AD_NO_ACTIVITY /*26*/:
                return this.adG;
            case 27:
                return this.qY;
            case 28:
                return this.adH;
            case 29:
                return Boolean.valueOf(this.adI);
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + aVar.fN());
        }
    }

    public int describeContents() {
        kt ktVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ks)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ks ksVar = (ks) obj;
        for (com.google.android.gms.internal.hy.a aVar : acr.values()) {
            if (a(aVar)) {
                if (!ksVar.a(aVar)) {
                    return false;
                }
                if (!b(aVar).equals(ksVar.b(aVar))) {
                    return false;
                }
            } else if (ksVar.a(aVar)) {
                return false;
            }
        }
        return true;
    }

    public HashMap<String, com.google.android.gms.internal.hy.a<?, ?>> fG() {
        return acr;
    }

    public String getAboutMe() {
        return this.adq;
    }

    public AgeRange getAgeRange() {
        return this.adr;
    }

    public String getBirthday() {
        return this.ads;
    }

    public String getBraggingRights() {
        return this.adt;
    }

    public int getCircledByCount() {
        return this.adu;
    }

    public Cover getCover() {
        return this.adv;
    }

    public String getCurrentLocation() {
        return this.adw;
    }

    public String getDisplayName() {
        return this.Ln;
    }

    public int getGender() {
        return this.ml;
    }

    public String getId() {
        return this.xG;
    }

    public Image getImage() {
        return this.adx;
    }

    public String getLanguage() {
        return this.Ar;
    }

    public Name getName() {
        return this.adz;
    }

    public String getNickname() {
        return this.adA;
    }

    public int getObjectType() {
        return this.adB;
    }

    public List<Organizations> getOrganizations() {
        return (ArrayList) this.adC;
    }

    public List<PlacesLived> getPlacesLived() {
        return (ArrayList) this.adD;
    }

    public int getPlusOneCount() {
        return this.adE;
    }

    public int getRelationshipStatus() {
        return this.adF;
    }

    public String getTagline() {
        return this.adG;
    }

    public String getUrl() {
        return this.qY;
    }

    public List<Urls> getUrls() {
        return (ArrayList) this.adH;
    }

    int getVersionCode() {
        return this.xM;
    }

    public boolean hasAboutMe() {
        return this.acs.contains(Integer.valueOf(2));
    }

    public boolean hasAgeRange() {
        return this.acs.contains(Integer.valueOf(3));
    }

    public boolean hasBirthday() {
        return this.acs.contains(Integer.valueOf(4));
    }

    public boolean hasBraggingRights() {
        return this.acs.contains(Integer.valueOf(5));
    }

    public boolean hasCircledByCount() {
        return this.acs.contains(Integer.valueOf(6));
    }

    public boolean hasCover() {
        return this.acs.contains(Integer.valueOf(7));
    }

    public boolean hasCurrentLocation() {
        return this.acs.contains(Integer.valueOf(8));
    }

    public boolean hasDisplayName() {
        return this.acs.contains(Integer.valueOf(9));
    }

    public boolean hasGender() {
        return this.acs.contains(Integer.valueOf(12));
    }

    public boolean hasId() {
        return this.acs.contains(Integer.valueOf(14));
    }

    public boolean hasImage() {
        return this.acs.contains(Integer.valueOf(15));
    }

    public boolean hasIsPlusUser() {
        return this.acs.contains(Integer.valueOf(16));
    }

    public boolean hasLanguage() {
        return this.acs.contains(Integer.valueOf(18));
    }

    public boolean hasName() {
        return this.acs.contains(Integer.valueOf(19));
    }

    public boolean hasNickname() {
        return this.acs.contains(Integer.valueOf(20));
    }

    public boolean hasObjectType() {
        return this.acs.contains(Integer.valueOf(21));
    }

    public boolean hasOrganizations() {
        return this.acs.contains(Integer.valueOf(22));
    }

    public boolean hasPlacesLived() {
        return this.acs.contains(Integer.valueOf(23));
    }

    public boolean hasPlusOneCount() {
        return this.acs.contains(Integer.valueOf(24));
    }

    public boolean hasRelationshipStatus() {
        return this.acs.contains(Integer.valueOf(25));
    }

    public boolean hasTagline() {
        return this.acs.contains(Integer.valueOf(26));
    }

    public boolean hasUrl() {
        return this.acs.contains(Integer.valueOf(27));
    }

    public boolean hasUrls() {
        return this.acs.contains(Integer.valueOf(28));
    }

    public boolean hasVerified() {
        return this.acs.contains(Integer.valueOf(29));
    }

    public int hashCode() {
        int i = 0;
        Iterator it = acr.values().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            com.google.android.gms.internal.hy.a aVar = (com.google.android.gms.internal.hy.a) it.next();
            if (a(aVar)) {
                i = b(aVar).hashCode() + (i2 + aVar.fN());
            } else {
                i = i2;
            }
        }
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isPlusUser() {
        return this.ady;
    }

    public boolean isVerified() {
        return this.adI;
    }

    a kF() {
        return this.adr;
    }

    b kG() {
        return this.adv;
    }

    c kH() {
        return this.adx;
    }

    d kI() {
        return this.adz;
    }

    List<f> kJ() {
        return this.adC;
    }

    List<g> kK() {
        return this.adD;
    }

    List<h> kL() {
        return this.adH;
    }

    /* renamed from: kM */
    public ks freeze() {
        return this;
    }

    Set<Integer> kk() {
        return this.acs;
    }

    public void writeToParcel(Parcel out, int flags) {
        kt ktVar = CREATOR;
        kt.a(this, out, flags);
    }
}
