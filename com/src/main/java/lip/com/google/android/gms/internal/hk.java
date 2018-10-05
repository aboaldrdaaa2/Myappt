package lip.com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class hk {

    public static final class a {
        private final List<String> GJ;
        private final Object GK;

        private a(Object obj) {
            this.GK = hm.f(obj);
            this.GJ = new ArrayList();
        }

        public a a(String str, Object obj) {
            this.GJ.add(((String) hm.f(str)) + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.GK.getClass().getSimpleName()).append('{');
            int size = this.GJ.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.GJ.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    public static a e(Object obj) {
        return new a(obj);
    }

    public static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    public static int hashCode(Object... objects) {
        return Arrays.hashCode(objects);
    }
}
