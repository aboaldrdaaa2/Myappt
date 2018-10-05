package lip.com.google.ads.interactivemedia.v3.a.b;

import com.google.ads.interactivemedia.v3.a.d.c;
import com.google.ads.interactivemedia.v3.a.l;
import com.google.ads.interactivemedia.v3.a.m;
import com.google.ads.interactivemedia.v3.a.n;
import com.google.ads.interactivemedia.v3.a.p;
import com.google.ads.interactivemedia.v3.a.t;
import java.io.IOException;
import java.io.Writer;

/* compiled from: IMASDK */
public final class j {

    /* compiled from: IMASDK */
    private static final class a extends Writer {
        private final Appendable a;
        private final a b;

        /* compiled from: IMASDK */
        static class a implements CharSequence {
            char[] a;

            a() {
            }

            public final int length() {
                return this.a.length;
            }

            public final char charAt(int i) {
                return this.a[i];
            }

            public final CharSequence subSequence(int start, int end) {
                return new String(this.a, start, end - start);
            }
        }

        /* synthetic */ a(Appendable appendable, byte b) {
            this(appendable);
        }

        private a(Appendable appendable) {
            this.b = new a();
            this.a = appendable;
        }

        public final void write(char[] chars, int offset, int length) throws IOException {
            this.b.a = chars;
            this.a.append(this.b, offset, offset + length);
        }

        public final void write(int i) throws IOException {
            this.a.append((char) i);
        }

        public final void flush() {
        }

        public final void close() {
        }
    }

    public static l a(com.google.ads.interactivemedia.v3.a.d.a aVar) throws p {
        Object obj = 1;
        try {
            aVar.f();
            obj = null;
            return (l) com.google.ads.interactivemedia.v3.a.b.a.l.P.a(aVar);
        } catch (Throwable e) {
            if (obj != null) {
                return n.a;
            }
            throw new t(e);
        } catch (Throwable e2) {
            throw new t(e2);
        } catch (Throwable e22) {
            throw new m(e22);
        } catch (Throwable e222) {
            throw new t(e222);
        }
    }

    public static void a(l lVar, c cVar) throws IOException {
        com.google.ads.interactivemedia.v3.a.b.a.l.P.a(cVar, lVar);
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable, (byte) 0);
    }
}
