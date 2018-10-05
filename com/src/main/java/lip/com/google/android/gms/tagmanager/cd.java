package lip.com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class cd {
    private static cd agx;
    private volatile String aet;
    private volatile String agA;
    private volatile a agy;
    private volatile String agz;

    enum a {
        NONE,
        CONTAINER,
        CONTAINER_DEBUG
    }

    cd() {
        clear();
    }

    private String ca(String str) {
        return str.split("&")[0].split("=")[1];
    }

    private String j(Uri uri) {
        return uri.getQuery().replace("&gtm_debug=x", "");
    }

    static cd md() {
        cd cdVar;
        synchronized (cd.class) {
            if (agx == null) {
                agx = new cd();
            }
            cdVar = agx;
        }
        return cdVar;
    }

    void clear() {
        this.agy = a.NONE;
        this.agz = null;
        this.aet = null;
        this.agA = null;
    }

    String getContainerId() {
        return this.aet;
    }

    synchronized boolean i(Uri uri) {
        boolean z = true;
        synchronized (this) {
            try {
                String decode = URLDecoder.decode(uri.toString(), "UTF-8");
                if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                    bh.C("Container preview url: " + decode);
                    if (decode.matches(".*?&gtm_debug=x$")) {
                        this.agy = a.CONTAINER_DEBUG;
                    } else {
                        this.agy = a.CONTAINER;
                    }
                    this.agA = j(uri);
                    if (this.agy == a.CONTAINER || this.agy == a.CONTAINER_DEBUG) {
                        this.agz = "/r?" + this.agA;
                    }
                    this.aet = ca(this.agA);
                } else {
                    if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                        bh.D("Invalid preview uri: " + decode);
                        z = false;
                    } else if (ca(uri.getQuery()).equals(this.aet)) {
                        bh.C("Exit preview mode for container: " + this.aet);
                        this.agy = a.NONE;
                        this.agz = null;
                    } else {
                        z = false;
                    }
                }
            } catch (UnsupportedEncodingException e) {
                z = false;
            }
        }
        return z;
    }

    a me() {
        return this.agy;
    }

    String mf() {
        return this.agz;
    }
}
