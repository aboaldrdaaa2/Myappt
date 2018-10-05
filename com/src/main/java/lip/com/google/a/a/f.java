package lip.com.google.a.a;

import android.content.Context;
import android.net.Uri;

/* compiled from: IMASDK */
public final class f {
    private String a = "googleads.g.doubleclick.net";
    private String b = "/pagead/ads";
    private String[] c = new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private c d;
    private b e = new b();

    public f(String str, Context context) {
        this.d = e.a(str, context);
    }

    public final boolean a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.c) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public final Uri a(Uri uri, Context context) throws g {
        return b(uri, context);
    }

    private Uri b(Uri uri, Context context) throws g {
        try {
            if (uri.getQueryParameter("ms") != null) {
                throw new g("Query parameter already exists: ms");
            }
            String a = this.d.a(context);
            String str = "ms";
            String uri2 = uri.toString();
            int indexOf = uri2.indexOf("&adurl");
            if (indexOf == -1) {
                indexOf = uri2.indexOf("?adurl");
            }
            return indexOf != -1 ? Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(a).append("&").append(uri2.substring(indexOf + 1)).toString()) : uri.buildUpon().appendQueryParameter(str, a).build();
        } catch (UnsupportedOperationException e) {
            throw new g("Provided Uri is not in a valid state");
        }
    }
}
