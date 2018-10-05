package lip.com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

class l<K, V> {
    final a<K, V> aer = new a<K, V>() {
        public int sizeOf(K k, V v) {
            return 1;
        }
    };

    public interface a<K, V> {
        int sizeOf(K k, V v);
    }

    public k<K, V> a(int i, a<K, V> aVar) {
        if (i > 0) {
            return lj() < 12 ? new cz(i, aVar) : new bb(i, aVar);
        } else {
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    int lj() {
        return VERSION.SDK_INT;
    }
}
