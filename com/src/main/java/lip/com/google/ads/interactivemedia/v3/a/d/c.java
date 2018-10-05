package lip.com.google.ads.interactivemedia.v3.a.d;

import com.facebook.internal.ServerProtocol;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* compiled from: IMASDK */
public class c implements Closeable, Flushable {
    private static final String[] a = new String[128];
    private static final String[] b;
    private final Writer c;
    private int[] d = new int[32];
    private int e = 0;
    private String f;
    private String g;
    private boolean h;
    private boolean i;
    private String j;
    private boolean k;

    static {
        for (int i = 0; i <= 31; i++) {
            a[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        a[34] = "\\\"";
        a[92] = "\\\\";
        a[9] = "\\t";
        a[8] = "\\b";
        a[10] = "\\n";
        a[13] = "\\r";
        a[12] = "\\f";
        String[] strArr = (String[]) a.clone();
        b = strArr;
        strArr[60] = "\\u003c";
        b[62] = "\\u003e";
        b[38] = "\\u0026";
        b[61] = "\\u003d";
        b[39] = "\\u0027";
    }

    public c(Writer writer) {
        a(6);
        this.g = ":";
        this.k = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.c = writer;
    }

    public final void c(String str) {
        if (str.length() == 0) {
            this.f = null;
            this.g = ":";
            return;
        }
        this.f = str;
        this.g = ": ";
    }

    public final void b(boolean z) {
        this.h = z;
    }

    public final boolean g() {
        return this.h;
    }

    public final void c(boolean z) {
        this.i = z;
    }

    public final boolean h() {
        return this.i;
    }

    public final void d(boolean z) {
        this.k = z;
    }

    public final boolean i() {
        return this.k;
    }

    public c b() throws IOException {
        j();
        return a(1, "[");
    }

    public c c() throws IOException {
        return a(1, 2, "]");
    }

    public c d() throws IOException {
        j();
        return a(3, "{");
    }

    public c e() throws IOException {
        return a(3, 5, "}");
    }

    private c a(int i, String str) throws IOException {
        e(true);
        a(i);
        this.c.write(str);
        return this;
    }

    private c a(int i, int i2, String str) throws IOException {
        int a = a();
        if (a != i2 && a != i) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.j != null) {
            throw new IllegalStateException("Dangling name: " + this.j);
        } else {
            this.e--;
            if (a == i2) {
                k();
            }
            this.c.write(str);
            return this;
        }
    }

    private void a(int i) {
        if (this.e == this.d.length) {
            Object obj = new int[(this.e * 2)];
            System.arraycopy(this.d, 0, obj, 0, this.e);
            this.d = obj;
        }
        int[] iArr = this.d;
        int i2 = this.e;
        this.e = i2 + 1;
        iArr[i2] = i;
    }

    private int a() {
        if (this.e != 0) {
            return this.d[this.e - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void b(int i) {
        this.d[this.e - 1] = i;
    }

    public c a(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.j != null) {
            throw new IllegalStateException();
        } else if (this.e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else {
            this.j = str;
            return this;
        }
    }

    private void j() throws IOException {
        if (this.j != null) {
            int a = a();
            if (a == 5) {
                this.c.write(44);
            } else if (a != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            k();
            b(4);
            d(this.j);
            this.j = null;
        }
    }

    /* renamed from: b */
    public c a(String str) throws IOException {
        if (str == null) {
            return f();
        }
        j();
        e(false);
        d(str);
        return this;
    }

    public c f() throws IOException {
        if (this.j != null) {
            if (this.k) {
                j();
            } else {
                this.j = null;
                return this;
            }
        }
        e(false);
        this.c.write("null");
        return this;
    }

    public c a(boolean z) throws IOException {
        j();
        e(false);
        this.c.write(z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return this;
    }

    public c a(long j) throws IOException {
        j();
        e(false);
        this.c.write(Long.toString(j));
        return this;
    }

    public c a(Number number) throws IOException {
        if (number == null) {
            return f();
        }
        j();
        CharSequence obj = number.toString();
        if (this.h || !(obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            e(false);
            this.c.append(obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public void flush() throws IOException {
        if (this.e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.c.flush();
    }

    public void close() throws IOException {
        this.c.close();
        int i = this.e;
        if (i > 1 || (i == 1 && this.d[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.e = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0030  */
    private void d(String r8) throws IOException {
        /*
        r7 = this;
        r1 = 0;
        r0 = r7.i;
        if (r0 == 0) goto L_0x0025;
    L_0x0005:
        r0 = b;
    L_0x0007:
        r2 = r7.c;
        r3 = "\"";
        r2.write(r3);
        r4 = r8.length();
        r3 = r1;
    L_0x0013:
        if (r3 >= r4) goto L_0x0046;
    L_0x0015:
        r2 = r8.charAt(r3);
        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r2 >= r5) goto L_0x0028;
    L_0x001d:
        r2 = r0[r2];
        if (r2 != 0) goto L_0x002e;
    L_0x0021:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x0013;
    L_0x0025:
        r0 = a;
        goto L_0x0007;
    L_0x0028:
        r5 = 8232; // 0x2028 float:1.1535E-41 double:4.067E-320;
        if (r2 != r5) goto L_0x003f;
    L_0x002c:
        r2 = "\\u2028";
    L_0x002e:
        if (r1 >= r3) goto L_0x0037;
    L_0x0030:
        r5 = r7.c;
        r6 = r3 - r1;
        r5.write(r8, r1, r6);
    L_0x0037:
        r1 = r7.c;
        r1.write(r2);
        r1 = r3 + 1;
        goto L_0x0021;
    L_0x003f:
        r5 = 8233; // 0x2029 float:1.1537E-41 double:4.0676E-320;
        if (r2 != r5) goto L_0x0021;
    L_0x0043:
        r2 = "\\u2029";
        goto L_0x002e;
    L_0x0046:
        if (r1 >= r4) goto L_0x004f;
    L_0x0048:
        r0 = r7.c;
        r2 = r4 - r1;
        r0.write(r8, r1, r2);
    L_0x004f:
        r0 = r7.c;
        r1 = "\"";
        r0.write(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.a.d.c.d(java.lang.String):void");
    }

    private void k() throws IOException {
        if (this.f != null) {
            this.c.write("\n");
            int i = this.e;
            for (int i2 = 1; i2 < i; i2++) {
                this.c.write(this.f);
            }
        }
    }

    private void e(boolean z) throws IOException {
        switch (a()) {
            case 1:
                b(2);
                k();
                return;
            case 2:
                this.c.append(',');
                k();
                return;
            case 4:
                this.c.append(this.g);
                b(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
            default:
                throw new IllegalStateException("Nesting problem.");
        }
        if (this.h || z) {
            b(7);
            return;
        }
        throw new IllegalStateException("JSON must start with an array or an object.");
    }
}
