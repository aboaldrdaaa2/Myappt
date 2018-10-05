package lip.com.google.ads.interactivemedia.v3.a.b.a;

import com.google.ads.interactivemedia.v3.a.d.b;
import com.google.ads.interactivemedia.v3.a.d.c;
import com.google.ads.interactivemedia.v3.a.f;
import com.google.ads.interactivemedia.v3.a.i;
import com.google.ads.interactivemedia.v3.a.m;
import com.google.ads.interactivemedia.v3.a.n;
import com.google.ads.interactivemedia.v3.a.o;
import com.google.ads.interactivemedia.v3.a.q;
import com.google.ads.interactivemedia.v3.a.t;
import com.google.ads.interactivemedia.v3.a.w;
import com.google.ads.interactivemedia.v3.a.x;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.UUID;

/* compiled from: IMASDK */
public final class l {
    public static final w<StringBuffer> A = new w<StringBuffer>() {
        public final /* synthetic */ Object a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return new StringBuffer(aVar.h());
            }
            aVar.j();
            return null;
        }

        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            StringBuffer stringBuffer = (StringBuffer) obj;
            cVar.a(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final x B = a(StringBuffer.class, A);
    public static final w<URL> C = new w<URL>() {
        public final /* synthetic */ Object a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            String h = aVar.h();
            return !"null".equals(h) ? new URL(h) : null;
        }

        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            URL url = (URL) obj;
            cVar.a(url == null ? null : url.toExternalForm());
        }
    };
    public static final x D = a(URL.class, C);
    public static final w<URI> E = new w<URI>() {
        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            URI uri = (URI) obj;
            cVar.a(uri == null ? null : uri.toASCIIString());
        }

        private static URI b(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            try {
                String h = aVar.h();
                if ("null".equals(h)) {
                    return null;
                }
                return new URI(h);
            } catch (Throwable e) {
                throw new m(e);
            }
        }
    };
    public static final x F = a(URI.class, E);
    public static final w<InetAddress> G = new w<InetAddress>() {
        public final /* synthetic */ Object a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return InetAddress.getByName(aVar.h());
            }
            aVar.j();
            return null;
        }

        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            InetAddress inetAddress = (InetAddress) obj;
            cVar.a(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final x H = b(InetAddress.class, G);
    public static final w<UUID> I = new w<UUID>() {
        public final /* synthetic */ Object a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return UUID.fromString(aVar.h());
            }
            aVar.j();
            return null;
        }

        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            UUID uuid = (UUID) obj;
            cVar.a(uuid == null ? null : uuid.toString());
        }
    };
    public static final x J = a(UUID.class, I);
    public static final x K = new x() {
        public final <T> w<T> a(f fVar, com.google.ads.interactivemedia.v3.a.c.a<T> aVar) {
            if (aVar.a() != Timestamp.class) {
                return null;
            }
            final w a = fVar.a(Date.class);
            return new w<Timestamp>() {
                public final /* synthetic */ Object a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
                    Date date = (Date) a.a(aVar);
                    return date != null ? new Timestamp(date.getTime()) : null;
                }

                public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
                    a.a(cVar, (Timestamp) obj);
                }
            };
        }
    };
    public static final w<Calendar> L = new w<Calendar>() {
        public final /* synthetic */ Object a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            int i = 0;
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            aVar.c();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (aVar.f() != b.END_OBJECT) {
                String g = aVar.g();
                int m = aVar.m();
                if ("year".equals(g)) {
                    i6 = m;
                } else if ("month".equals(g)) {
                    i5 = m;
                } else if ("dayOfMonth".equals(g)) {
                    i4 = m;
                } else if ("hourOfDay".equals(g)) {
                    i3 = m;
                } else if ("minute".equals(g)) {
                    i2 = m;
                } else if ("second".equals(g)) {
                    i = m;
                }
            }
            aVar.d();
            return new GregorianCalendar(i6, i5, i4, i3, i2, i);
        }

        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            Calendar calendar = (Calendar) obj;
            if (calendar == null) {
                cVar.f();
                return;
            }
            cVar.d();
            cVar.a("year");
            cVar.a((long) calendar.get(1));
            cVar.a("month");
            cVar.a((long) calendar.get(2));
            cVar.a("dayOfMonth");
            cVar.a((long) calendar.get(5));
            cVar.a("hourOfDay");
            cVar.a((long) calendar.get(11));
            cVar.a("minute");
            cVar.a((long) calendar.get(12));
            cVar.a("second");
            cVar.a((long) calendar.get(13));
            cVar.e();
        }
    };
    public static final x M;
    public static final w<Locale> N = new w<Locale>() {
        public final /* synthetic */ Object a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.h(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (nextToken2 == null && nextToken3 == null) {
                return new Locale(nextToken);
            }
            return nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
        }

        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            Locale locale = (Locale) obj;
            cVar.a(locale == null ? null : locale.toString());
        }
    };
    public static final x O = a(Locale.class, N);
    public static final w<com.google.ads.interactivemedia.v3.a.l> P = new w<com.google.ads.interactivemedia.v3.a.l>() {
        private com.google.ads.interactivemedia.v3.a.l b(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            com.google.ads.interactivemedia.v3.a.l iVar;
            switch (aVar.f()) {
                case NUMBER:
                    return new q(new com.google.ads.interactivemedia.v3.a.b.f(aVar.h()));
                case BOOLEAN:
                    return new q(Boolean.valueOf(aVar.i()));
                case STRING:
                    return new q(aVar.h());
                case NULL:
                    aVar.j();
                    return n.a;
                case BEGIN_ARRAY:
                    iVar = new i();
                    aVar.a();
                    while (aVar.e()) {
                        iVar.a(b(aVar));
                    }
                    aVar.b();
                    return iVar;
                case BEGIN_OBJECT:
                    iVar = new o();
                    aVar.c();
                    while (aVar.e()) {
                        iVar.a(aVar.g(), b(aVar));
                    }
                    aVar.d();
                    return iVar;
                default:
                    throw new IllegalArgumentException();
            }
        }

        private void a(c cVar, com.google.ads.interactivemedia.v3.a.l lVar) throws IOException {
            if (lVar == null || lVar.j()) {
                cVar.f();
            } else if (lVar.i()) {
                q m = lVar.m();
                if (m.o()) {
                    cVar.a(m.a());
                } else if (m.n()) {
                    cVar.a(m.f());
                } else {
                    cVar.a(m.b());
                }
            } else if (lVar.g()) {
                cVar.b();
                Iterator it = lVar.l().iterator();
                while (it.hasNext()) {
                    a(cVar, (com.google.ads.interactivemedia.v3.a.l) it.next());
                }
                cVar.c();
            } else if (lVar.h()) {
                cVar.d();
                for (Entry entry : lVar.k().n()) {
                    cVar.a((String) entry.getKey());
                    a(cVar, (com.google.ads.interactivemedia.v3.a.l) entry.getValue());
                }
                cVar.e();
            } else {
                throw new IllegalArgumentException("Couldn't write " + lVar.getClass());
            }
        }
    };
    public static final x Q = b(com.google.ads.interactivemedia.v3.a.l.class, P);
    public static final x R = new x() {
        public final <T> w<T> a(f fVar, com.google.ads.interactivemedia.v3.a.c.a<T> aVar) {
            Class a = aVar.a();
            if (!Enum.class.isAssignableFrom(a) || a == Enum.class) {
                return null;
            }
            if (!a.isEnum()) {
                a = a.getSuperclass();
            }
            return new a(a);
        }
    };
    public static final w<Class> a = new w<Class>() {
        public final /* synthetic */ Object a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            Class cls = (Class) obj;
            if (cls == null) {
                cVar.f();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    };
    public static final x b = a(Class.class, a);
    public static final w<BitSet> c = new w<BitSet>() {
        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            BitSet bitSet = (BitSet) obj;
            if (bitSet == null) {
                cVar.f();
                return;
            }
            cVar.b();
            for (int i = 0; i < bitSet.length(); i++) {
                cVar.a((long) (bitSet.get(i) ? 1 : 0));
            }
            cVar.c();
        }

        private static BitSet b(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            BitSet bitSet = new BitSet();
            aVar.a();
            b f = aVar.f();
            int i = 0;
            while (f != b.END_ARRAY) {
                boolean z;
                switch (f) {
                    case NUMBER:
                        if (aVar.m() == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case BOOLEAN:
                        z = aVar.i();
                        break;
                    case STRING:
                        String h = aVar.h();
                        try {
                            if (Integer.parseInt(h) == 0) {
                                z = false;
                                break;
                            }
                            z = true;
                            break;
                        } catch (NumberFormatException e) {
                            throw new t("Error: Expecting: bitset number value (1, 0), Found: " + h);
                        }
                    default:
                        throw new t("Invalid bitset value type: " + f);
                }
                if (z) {
                    bitSet.set(i);
                }
                i++;
                f = aVar.f();
            }
            aVar.b();
            return bitSet;
        }
    };
    public static final x d = a(BitSet.class, c);
    public static final w<Boolean> e = new w<Boolean>() {
        public final /* synthetic */ Object a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return aVar.f() == b.STRING ? Boolean.valueOf(Boolean.parseBoolean(aVar.h())) : Boolean.valueOf(aVar.i());
            } else {
                aVar.j();
                return null;
            }
        }

        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            Boolean bool = (Boolean) obj;
            if (bool == null) {
                cVar.f();
            } else {
                cVar.a(bool.booleanValue());
            }
        }
    };
    public static final w<Boolean> f = new w<Boolean>() {
        public final /* synthetic */ Object a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return Boolean.valueOf(aVar.h());
            }
            aVar.j();
            return null;
        }

        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            Boolean bool = (Boolean) obj;
            cVar.a(bool == null ? "null" : bool.toString());
        }
    };
    public static final x g = a(Boolean.TYPE, Boolean.class, e);
    public static final w<Number> h = new w<Number>() {
        private static Number b(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return Byte.valueOf((byte) aVar.m());
            } catch (Throwable e) {
                throw new t(e);
            }
        }
    };
    public static final x i = a(Byte.TYPE, Byte.class, h);
    public static final w<Number> j = new w<Number>() {
        private static Number b(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return Short.valueOf((short) aVar.m());
            } catch (Throwable e) {
                throw new t(e);
            }
        }
    };
    public static final x k = a(Short.TYPE, Short.class, j);
    public static final w<Number> l = new w<Number>() {
        private static Number b(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return Integer.valueOf(aVar.m());
            } catch (Throwable e) {
                throw new t(e);
            }
        }
    };
    public static final x m = a(Integer.TYPE, Integer.class, l);
    public static final w<Number> n = new w<Number>() {
        private static Number b(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return Long.valueOf(aVar.l());
            } catch (Throwable e) {
                throw new t(e);
            }
        }
    };
    public static final w<Number> o = new w<Number>() {
        public final /* synthetic */ Object a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return Float.valueOf((float) aVar.k());
            }
            aVar.j();
            return null;
        }
    };
    public static final w<Number> p = new w<Number>() {
        public final /* synthetic */ Object a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return Double.valueOf(aVar.k());
            }
            aVar.j();
            return null;
        }
    };
    public static final w<Number> q = new w<Number>() {
        public final /* synthetic */ Object a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            b f = aVar.f();
            switch (f) {
                case NUMBER:
                    return new com.google.ads.interactivemedia.v3.a.b.f(aVar.h());
                case NULL:
                    aVar.j();
                    return null;
                default:
                    throw new t("Expecting number, got: " + f);
            }
        }
    };
    public static final x r = a(Number.class, q);
    public static final w<Character> s = new w<Character>() {
        public final /* synthetic */ Object a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            String h = aVar.h();
            if (h.length() == 1) {
                return Character.valueOf(h.charAt(0));
            }
            throw new t("Expecting character, got: " + h);
        }

        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            Character ch = (Character) obj;
            cVar.a(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final x t = a(Character.TYPE, Character.class, s);
    public static final w<String> u = new w<String>() {
        public final /* synthetic */ Object a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            b f = aVar.f();
            if (f != b.NULL) {
                return f == b.BOOLEAN ? Boolean.toString(aVar.i()) : aVar.h();
            } else {
                aVar.j();
                return null;
            }
        }
    };
    public static final w<BigDecimal> v = new w<BigDecimal>() {
        private static BigDecimal b(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return new BigDecimal(aVar.h());
            } catch (Throwable e) {
                throw new t(e);
            }
        }
    };
    public static final w<BigInteger> w = new w<BigInteger>() {
        private static BigInteger b(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return new BigInteger(aVar.h());
            } catch (Throwable e) {
                throw new t(e);
            }
        }
    };
    public static final x x = a(String.class, u);
    public static final w<StringBuilder> y = new w<StringBuilder>() {
        public final /* synthetic */ Object a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return new StringBuilder(aVar.h());
            }
            aVar.j();
            return null;
        }

        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            StringBuilder stringBuilder = (StringBuilder) obj;
            cVar.a(stringBuilder == null ? null : stringBuilder.toString());
        }
    };
    public static final x z = a(StringBuilder.class, y);

    /* compiled from: IMASDK */
    private static final class a<T extends Enum<T>> extends w<T> {
        private final Map<String, T> a = new HashMap();
        private final Map<T, String> b = new HashMap();

        public final /* synthetic */ Object a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return (Enum) this.a.get(aVar.h());
            }
            aVar.j();
            return null;
        }

        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            Enum enumR = (Enum) obj;
            cVar.a(enumR == null ? null : (String) this.b.get(enumR));
        }

        public a(Class<T> cls) {
            try {
                for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                    Object a;
                    String name = enumR.name();
                    com.google.ads.interactivemedia.v3.a.a.b bVar = (com.google.ads.interactivemedia.v3.a.a.b) cls.getField(name).getAnnotation(com.google.ads.interactivemedia.v3.a.a.b.class);
                    if (bVar != null) {
                        a = bVar.a();
                    } else {
                        String a2 = name;
                    }
                    this.a.put(a2, enumR);
                    this.b.put(enumR, a2);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError();
            }
        }
    }

    static {
        final Class cls = Calendar.class;
        final Class cls2 = GregorianCalendar.class;
        final w wVar = L;
        M = new x() {
            public final <T> w<T> a(f fVar, com.google.ads.interactivemedia.v3.a.c.a<T> aVar) {
                Class a = aVar.a();
                return (a == cls || a == cls2) ? wVar : null;
            }

            public final String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + wVar + "]";
            }
        };
    }

    public static <TT> x a(final com.google.ads.interactivemedia.v3.a.c.a<TT> aVar, final w<TT> wVar) {
        return new x() {
            public final <T> w<T> a(f fVar, com.google.ads.interactivemedia.v3.a.c.a<T> aVar) {
                return aVar.equals(aVar) ? wVar : null;
            }
        };
    }

    public static <TT> x a(final Class<TT> cls, final w<TT> wVar) {
        return new x() {
            public final <T> w<T> a(f fVar, com.google.ads.interactivemedia.v3.a.c.a<T> aVar) {
                return aVar.a() == cls ? wVar : null;
            }

            public final String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + wVar + "]";
            }
        };
    }

    public static <TT> x a(final Class<TT> cls, final Class<TT> cls2, final w<? super TT> wVar) {
        return new x() {
            public final <T> w<T> a(f fVar, com.google.ads.interactivemedia.v3.a.c.a<T> aVar) {
                Class a = aVar.a();
                return (a == cls || a == cls2) ? wVar : null;
            }

            public final String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + wVar + "]";
            }
        };
    }

    private static <TT> x b(final Class<TT> cls, final w<TT> wVar) {
        return new x() {
            public final <T> w<T> a(f fVar, com.google.ads.interactivemedia.v3.a.c.a<T> aVar) {
                return cls.isAssignableFrom(aVar.a()) ? wVar : null;
            }

            public final String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + wVar + "]";
            }
        };
    }
}
