package lip.com.google.ads.interactivemedia.v3.a.d;

import com.facebook.internal.ServerProtocol;
import com.google.ads.interactivemedia.v3.a.b.a.d;
import com.google.ads.interactivemedia.v3.a.b.e;
import com.google.android.gms.games.quest.Quests;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

/* compiled from: IMASDK */
public class a implements Closeable {
    private static final char[] a = ")]}'\n".toCharArray();
    private final Reader b;
    private boolean c = false;
    private final char[] d = new char[1024];
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private long j;
    private int k;
    private String l;
    private int[] m = new int[32];
    private int n = 0;

    static {
        e.a = new e() {
            public final void a(a aVar) throws IOException {
                if (aVar instanceof d) {
                    ((d) aVar).o();
                    return;
                }
                int a = aVar.i;
                if (a == 0) {
                    a = aVar.o();
                }
                if (a == 13) {
                    aVar.i = 9;
                } else if (a == 12) {
                    aVar.i = 8;
                } else if (a == 14) {
                    aVar.i = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + aVar.f() + "  at line " + (aVar.g + 1) + " column " + aVar.t());
                }
            }
        };
    }

    public a(Reader reader) {
        int[] iArr = this.m;
        int i = this.n;
        this.n = i + 1;
        iArr[i] = 6;
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.b = reader;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public final boolean p() {
        return this.c;
    }

    public void a() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        if (i == 3) {
            a(1);
            this.i = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + f() + " at line " + (this.g + 1) + " column " + t());
    }

    public void b() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        if (i == 4) {
            this.n--;
            this.i = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + f() + " at line " + (this.g + 1) + " column " + t());
    }

    public void c() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        if (i == 1) {
            a(3);
            this.i = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + f() + " at line " + (this.g + 1) + " column " + t());
    }

    public void d() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        if (i == 2) {
            this.n--;
            this.i = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + f() + " at line " + (this.g + 1) + " column " + t());
    }

    public boolean e() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public b f() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        switch (i) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    private int o() throws IOException {
        int b;
        int i = this.m[this.n - 1];
        if (i == 1) {
            this.m[this.n - 1] = 2;
        } else if (i == 2) {
            switch (b(true)) {
                case 44:
                    break;
                case 59:
                    u();
                    break;
                case 93:
                    this.i = 4;
                    return 4;
                default:
                    throw a("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.m[this.n - 1] = 4;
            if (i == 5) {
                switch (b(true)) {
                    case 44:
                        break;
                    case 59:
                        u();
                        break;
                    case 125:
                        this.i = 2;
                        return 2;
                    default:
                        throw a("Unterminated object");
                }
            }
            b = b(true);
            switch (b) {
                case 34:
                    this.i = 13;
                    return 13;
                case 39:
                    u();
                    this.i = 12;
                    return 12;
                case 125:
                    if (i != 5) {
                        this.i = 2;
                        return 2;
                    }
                    throw a("Expected name");
                default:
                    u();
                    this.e--;
                    if (a((char) b)) {
                        this.i = 14;
                        return 14;
                    }
                    throw a("Expected name");
            }
        } else if (i == 4) {
            this.m[this.n - 1] = 5;
            switch (b(true)) {
                case 58:
                    break;
                case 61:
                    u();
                    if ((this.e < this.f || b(1)) && this.d[this.e] == '>') {
                        this.e++;
                        break;
                    }
                default:
                    throw a("Expected ':'");
            }
        } else if (i == 6) {
            if (this.c) {
                b(true);
                this.e--;
                if (this.e + a.length <= this.f || b(a.length)) {
                    for (b = 0; b < a.length; b++) {
                        if (this.d[this.e + b] != a[b]) {
                            break;
                        }
                    }
                    this.e += a.length;
                }
            }
            this.m[this.n - 1] = 7;
        } else if (i == 7) {
            if (b(false) == -1) {
                this.i = 17;
                return 17;
            }
            u();
            this.e--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (b(true)) {
            case 34:
                if (this.n == 1) {
                    u();
                }
                this.i = 9;
                return 9;
            case 39:
                u();
                this.i = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.i = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.i = 4;
                    return 4;
                }
                break;
            case 123:
                this.i = 1;
                return 1;
            default:
                this.e--;
                if (this.n == 1) {
                    u();
                }
                b = q();
                if (b != 0) {
                    return b;
                }
                b = r();
                if (b != 0) {
                    return b;
                }
                if (a(this.d[this.e])) {
                    u();
                    this.i = 10;
                    return 10;
                }
                throw a("Expected value");
        }
        if (i == 1 || i == 2) {
            u();
            this.e--;
            this.i = 7;
            return 7;
        }
        throw a("Unexpected value");
    }

    private int q() throws IOException {
        String str;
        int i;
        char c = this.d[this.e];
        String str2;
        if (c == 't' || c == 'T') {
            str = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        int i2 = 1;
        while (i2 < length) {
            if (this.e + i2 >= this.f && !b(i2 + 1)) {
                return 0;
            }
            char c2 = this.d[this.e + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
            i2++;
        }
        if ((this.e + length < this.f || b(length + 1)) && a(this.d[this.e + length])) {
            return 0;
        }
        this.e += length;
        this.i = i;
        return i;
    }

    private int r() throws IOException {
        char c;
        char[] cArr = this.d;
        int i = this.e;
        long j = 0;
        Object obj = null;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        int i5 = this.f;
        int i6 = i;
        while (true) {
            Object obj2;
            long j2;
            int i7;
            if (i6 + i4 == i5) {
                if (i4 == cArr.length) {
                    return 0;
                }
                if (b(i4 + 1)) {
                    i6 = this.e;
                    i5 = this.f;
                }
            }
            c = cArr[i6 + i4];
            switch (c) {
                case '+':
                    if (i3 != 5) {
                        return 0;
                    }
                    i = 6;
                    i3 = i2;
                    obj2 = obj;
                    j2 = j;
                    continue;
                case '-':
                    if (i3 == 0) {
                        i = 1;
                        i7 = i2;
                        obj2 = 1;
                        i3 = i7;
                        j2 = j;
                        continue;
                    } else if (i3 == 5) {
                        i = 6;
                        i3 = i2;
                        obj2 = obj;
                        j2 = j;
                        break;
                    } else {
                        return 0;
                    }
                case '.':
                    if (i3 != 2) {
                        return 0;
                    }
                    i = 3;
                    i3 = i2;
                    obj2 = obj;
                    j2 = j;
                    continue;
                case 'E':
                case Quests.SELECT_COMPLETED_UNCLAIMED /*101*/:
                    if (i3 != 2 && i3 != 4) {
                        return 0;
                    }
                    i = 5;
                    i3 = i2;
                    obj2 = obj;
                    j2 = j;
                    continue;
                default:
                    if (c >= '0' && c <= '9') {
                        if (i3 != 1 && i3 != 0) {
                            if (i3 != 2) {
                                if (i3 != 3) {
                                    if (i3 != 5 && i3 != 6) {
                                        i = i3;
                                        i3 = i2;
                                        obj2 = obj;
                                        j2 = j;
                                        break;
                                    }
                                    i = 7;
                                    i3 = i2;
                                    obj2 = obj;
                                    j2 = j;
                                    break;
                                }
                                i = 4;
                                i3 = i2;
                                obj2 = obj;
                                j2 = j;
                                break;
                            } else if (j != 0) {
                                long j3 = (10 * j) - ((long) (c - 48));
                                i = (j > -922337203685477580L || (j == -922337203685477580L && j3 < j)) ? 1 : 0;
                                i &= i2;
                                obj2 = obj;
                                j2 = j3;
                                i7 = i3;
                                i3 = i;
                                i = i7;
                                break;
                            } else {
                                return 0;
                            }
                        }
                        j = (long) (-(c - 48));
                        i = 2;
                        i3 = i2;
                        obj2 = obj;
                        j2 = j;
                        continue;
                    } else {
                        break;
                    }
                    break;
            }
            i4++;
            i7 = i3;
            i3 = i;
            Object obj3 = obj2;
            i2 = i7;
            j = j2;
            obj = obj3;
        }
        if (a(c)) {
            return 0;
        }
        if (i3 == 2 && i2 != 0 && (j != Long.MIN_VALUE || obj != null)) {
            if (obj == null) {
                j = -j;
            }
            this.j = j;
            this.e += i4;
            this.i = 15;
            return 15;
        } else if (i3 != 2 && i3 != 4 && i3 != 7) {
            return 0;
        } else {
            this.k = i4;
            this.i = 16;
            return 16;
        }
    }

    private boolean a(char c) throws IOException {
        switch (c) {
            case 9:
            case 10:
            case 12:
            case 13:
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
                break;
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
                u();
                break;
            default:
                return true;
        }
        return false;
    }

    public String g() throws IOException {
        String s;
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        if (i == 14) {
            s = s();
        } else if (i == 12) {
            s = b('\'');
        } else if (i == 13) {
            s = b('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + f() + " at line " + (this.g + 1) + " column " + t());
        }
        this.i = 0;
        return s;
    }

    public String h() throws IOException {
        String s;
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        if (i == 10) {
            s = s();
        } else if (i == 8) {
            s = b('\'');
        } else if (i == 9) {
            s = b('\"');
        } else if (i == 11) {
            s = this.l;
            this.l = null;
        } else if (i == 15) {
            s = Long.toString(this.j);
        } else if (i == 16) {
            s = new String(this.d, this.e, this.k);
            this.e += this.k;
        } else {
            throw new IllegalStateException("Expected a string but was " + f() + " at line " + (this.g + 1) + " column " + t());
        }
        this.i = 0;
        return s;
    }

    public boolean i() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        if (i == 5) {
            this.i = 0;
            return true;
        } else if (i == 6) {
            this.i = 0;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + f() + " at line " + (this.g + 1) + " column " + t());
        }
    }

    public void j() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        if (i == 7) {
            this.i = 0;
            return;
        }
        throw new IllegalStateException("Expected null but was " + f() + " at line " + (this.g + 1) + " column " + t());
    }

    public double k() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        if (i == 15) {
            this.i = 0;
            return (double) this.j;
        }
        if (i == 16) {
            this.l = new String(this.d, this.e, this.k);
            this.e += this.k;
        } else if (i == 8 || i == 9) {
            this.l = b(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.l = s();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + f() + " at line " + (this.g + 1) + " column " + t());
        }
        this.i = 11;
        double parseDouble = Double.parseDouble(this.l);
        if (this.c || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            this.l = null;
            this.i = 0;
            return parseDouble;
        }
        throw new d("JSON forbids NaN and infinities: " + parseDouble + " at line " + (this.g + 1) + " column " + t());
    }

    public long l() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        if (i == 15) {
            this.i = 0;
            return this.j;
        }
        long parseLong;
        if (i == 16) {
            this.l = new String(this.d, this.e, this.k);
            this.e += this.k;
        } else if (i == 8 || i == 9) {
            this.l = b(i == 8 ? '\'' : '\"');
            try {
                parseLong = Long.parseLong(this.l);
                this.i = 0;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + f() + " at line " + (this.g + 1) + " column " + t());
        }
        this.i = 11;
        double parseDouble = Double.parseDouble(this.l);
        parseLong = (long) parseDouble;
        if (((double) parseLong) != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.l + " at line " + (this.g + 1) + " column " + t());
        }
        this.l = null;
        this.i = 0;
        return parseLong;
    }

    private String b(char c) throws IOException {
        char[] cArr = this.d;
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int i = this.e;
            int i2 = this.f;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.e = i4;
                    stringBuilder.append(cArr, i, (i4 - i) - 1);
                    return stringBuilder.toString();
                } else if (c2 == '\\') {
                    this.e = i4;
                    stringBuilder.append(cArr, i, (i4 - i) - 1);
                    stringBuilder.append(w());
                    break;
                } else {
                    if (c2 == 10) {
                        this.g++;
                        this.h = i4;
                    }
                    i3 = i4;
                }
            }
            stringBuilder.append(cArr, i, i3 - i);
            this.e = i3;
            if (!b(1)) {
                throw a("Unterminated string");
            }
        }
    }

    private String s() throws IOException {
        String str;
        StringBuilder stringBuilder = null;
        int i = 0;
        while (true) {
            if (this.e + i < this.f) {
                switch (this.d[this.e + i]) {
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        u();
                        break;
                    default:
                        i++;
                        continue;
                }
            } else if (i >= this.d.length) {
                if (stringBuilder == null) {
                    stringBuilder = new StringBuilder();
                }
                stringBuilder.append(this.d, this.e, i);
                this.e = i + this.e;
                if (b(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            } else if (b(i + 1)) {
            }
        }
        if (stringBuilder == null) {
            str = new String(this.d, this.e, i);
        } else {
            stringBuilder.append(this.d, this.e, i);
            str = stringBuilder.toString();
        }
        this.e = i + this.e;
        return str;
    }

    private void c(char c) throws IOException {
        char[] cArr = this.d;
        while (true) {
            int i = this.e;
            int i2 = this.f;
            while (i < i2) {
                int i3 = i + 1;
                char c2 = cArr[i];
                if (c2 == c) {
                    this.e = i3;
                    return;
                } else if (c2 == '\\') {
                    this.e = i3;
                    w();
                    break;
                } else {
                    if (c2 == 10) {
                        this.g++;
                        this.h = i3;
                    }
                    i = i3;
                }
            }
            this.e = i;
            if (!b(1)) {
                throw a("Unterminated string");
            }
        }
    }

    public int m() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        if (i == 15) {
            i = (int) this.j;
            if (this.j != ((long) i)) {
                throw new NumberFormatException("Expected an int but was " + this.j + " at line " + (this.g + 1) + " column " + t());
            }
            this.i = 0;
            return i;
        }
        if (i == 16) {
            this.l = new String(this.d, this.e, this.k);
            this.e += this.k;
        } else if (i == 8 || i == 9) {
            this.l = b(i == 8 ? '\'' : '\"');
            try {
                i = Integer.parseInt(this.l);
                this.i = 0;
                return i;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + f() + " at line " + (this.g + 1) + " column " + t());
        }
        this.i = 11;
        double parseDouble = Double.parseDouble(this.l);
        i = (int) parseDouble;
        if (((double) i) != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.l + " at line " + (this.g + 1) + " column " + t());
        }
        this.l = null;
        this.i = 0;
        return i;
    }

    public void close() throws IOException {
        this.i = 0;
        this.m[0] = 8;
        this.n = 1;
        this.b.close();
    }

    public void n() throws IOException {
        int i = 0;
        do {
            int i2 = this.i;
            if (i2 == 0) {
                i2 = o();
            }
            if (i2 == 3) {
                a(1);
                i++;
            } else if (i2 == 1) {
                a(3);
                i++;
            } else if (i2 == 4) {
                this.n--;
                i--;
            } else if (i2 == 2) {
                this.n--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                do {
                    i2 = 0;
                    while (this.e + i2 < this.f) {
                        switch (this.d[this.e + i2]) {
                            case 9:
                            case 10:
                            case 12:
                            case 13:
                            case ' ':
                            case ',':
                            case ':':
                            case '[':
                            case ']':
                            case '{':
                            case '}':
                                break;
                            case '#':
                            case '/':
                            case ';':
                            case '=':
                            case '\\':
                                u();
                                break;
                            default:
                                i2++;
                        }
                        this.e = i2 + this.e;
                    }
                    this.e = i2 + this.e;
                } while (b(1));
            } else if (i2 == 8 || i2 == 12) {
                c('\'');
            } else if (i2 == 9 || i2 == 13) {
                c('\"');
            } else if (i2 == 16) {
                this.e += this.k;
            }
            this.i = 0;
        } while (i != 0);
    }

    private void a(int i) {
        if (this.n == this.m.length) {
            Object obj = new int[(this.n * 2)];
            System.arraycopy(this.m, 0, obj, 0, this.n);
            this.m = obj;
        }
        int[] iArr = this.m;
        int i2 = this.n;
        this.n = i2 + 1;
        iArr[i2] = i;
    }

    private boolean b(int i) throws IOException {
        Object obj = this.d;
        this.h -= this.e;
        if (this.f != this.e) {
            this.f -= this.e;
            System.arraycopy(obj, this.e, obj, 0, this.f);
        } else {
            this.f = 0;
        }
        this.e = 0;
        do {
            int read = this.b.read(obj, this.f, obj.length - this.f);
            if (read == -1) {
                return false;
            }
            this.f = read + this.f;
            if (this.g == 0 && this.h == 0 && this.f > 0 && obj[0] == 65279) {
                this.e++;
                this.h++;
                i++;
            }
        } while (this.f < i);
        return true;
    }

    private int t() {
        return (this.e - this.h) + 1;
    }

    private int b(boolean z) throws IOException {
        char[] cArr = this.d;
        int i = this.e;
        int i2 = this.f;
        while (true) {
            if (i == i2) {
                this.e = i;
                if (b(1)) {
                    i = this.e;
                    i2 = this.f;
                } else if (!z) {
                    return -1;
                } else {
                    throw new EOFException("End of input at line " + (this.g + 1) + " column " + t());
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == 10) {
                this.g++;
                this.h = i3;
                i = i3;
            } else if (c == ' ' || c == 13 || c == 9) {
                i = i3;
            } else if (c == '/') {
                this.e = i3;
                if (i3 == i2) {
                    this.e--;
                    boolean b = b(2);
                    this.e++;
                    if (!b) {
                        return c;
                    }
                }
                u();
                switch (cArr[this.e]) {
                    case '*':
                        this.e++;
                        String str = "*/";
                        while (true) {
                            if (this.e + str.length() <= this.f || b(str.length())) {
                                if (this.d[this.e] == 10) {
                                    this.g++;
                                    this.h = this.e + 1;
                                } else {
                                    i2 = 0;
                                    while (i2 < str.length()) {
                                        if (this.d[this.e + i2] == str.charAt(i2)) {
                                            i2++;
                                        }
                                    }
                                    i2 = 1;
                                }
                                this.e++;
                            } else {
                                i2 = 0;
                            }
                        }
                        if (i2 != 0) {
                            i = this.e + 2;
                            i2 = this.f;
                            break;
                        }
                        throw a("Unterminated comment");
                    case '/':
                        this.e++;
                        v();
                        i = this.e;
                        i2 = this.f;
                        break;
                    default:
                        return c;
                }
            } else if (c == '#') {
                this.e = i3;
                u();
                v();
                i = this.e;
                i2 = this.f;
            } else {
                this.e = i3;
                return c;
            }
        }
    }

    private void u() throws IOException {
        if (!this.c) {
            throw a("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void v() throws IOException {
        char c;
        do {
            if (this.e < this.f || b(1)) {
                char[] cArr = this.d;
                int i = this.e;
                this.e = i + 1;
                c = cArr[i];
                if (c == 10) {
                    this.g++;
                    this.h = this.e;
                    return;
                }
            } else {
                return;
            }
        } while (c != 13);
    }

    public String toString() {
        return getClass().getSimpleName() + " at line " + (this.g + 1) + " column " + t();
    }

    private char w() throws IOException {
        if (this.e != this.f || b(1)) {
            char[] cArr = this.d;
            int i = this.e;
            this.e = i + 1;
            char c = cArr[i];
            switch (c) {
                case 10:
                    this.g++;
                    this.h = this.e;
                    return c;
                case 'b':
                    return 8;
                case 'f':
                    return 12;
                case 'n':
                    return 10;
                case 'r':
                    return 13;
                case 't':
                    return 9;
                case 'u':
                    if (this.e + 4 <= this.f || b(4)) {
                        int i2 = this.e;
                        int i3 = i2 + 4;
                        int i4 = i2;
                        c = 0;
                        for (i = i4; i < i3; i++) {
                            int i5;
                            char c2 = this.d[i];
                            c = (char) (c << 4);
                            if (c2 >= '0' && c2 <= '9') {
                                i5 = c2 - 48;
                            } else if (c2 >= 'a' && c2 <= 'f') {
                                i5 = (c2 - 97) + 10;
                            } else if (c2 < 'A' || c2 > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.d, this.e, 4));
                            } else {
                                i5 = (c2 - 65) + 10;
                            }
                            c = (char) (c + i5);
                        }
                        this.e += 4;
                        return c;
                    }
                    throw a("Unterminated escape sequence");
                default:
                    return c;
            }
        }
        throw a("Unterminated escape sequence");
    }

    private IOException a(String str) throws IOException {
        throw new d(str + " at line " + (this.g + 1) + " column " + t());
    }
}
