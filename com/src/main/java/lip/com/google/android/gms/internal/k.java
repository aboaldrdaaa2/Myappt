package lip.com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;

public class k {
    private String kg = "googleads.g.doubleclick.net";
    private String kh = "/pagead/ads";
    private String ki = "ad.doubleclick.net";
    private String[] kj = new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private g kk;

    public k(g gVar) {
        this.kk = gVar;
    }

    private Uri a(Uri uri, Context context, String str, boolean z) throws l {
        try {
            boolean a = a(uri);
            if (a) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new l("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new l("Query parameter already exists: ms");
            }
            String a2 = z ? this.kk.a(context, str) : this.kk.a(context);
            return a ? b(uri, "dc_ms", a2) : a(uri, "ms", a2);
        } catch (UnsupportedOperationException e) {
            throw new l("Provided Uri is not in a valid state");
        }
    }

    private Uri a(Uri uri, String str, String str2) throws UnsupportedOperationException {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append("&").append(uri2.substring(indexOf + 1)).toString()) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    private Uri b(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf(";adurl");
        if (indexOf != -1) {
            return Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append(";").append(uri2.substring(indexOf + 1)).toString());
        }
        String encodedPath = uri.getEncodedPath();
        int indexOf2 = uri2.indexOf(encodedPath);
        return Uri.parse(new StringBuilder(uri2.substring(0, encodedPath.length() + indexOf2)).append(";").append(str).append("=").append(str2).append(";").append(uri2.substring(encodedPath.length() + indexOf2)).toString());
    }

    public Uri a(Uri uri, Context context) throws l {
        try {
            return a(uri, context, uri.getQueryParameter("ai"), true);
        } catch (UnsupportedOperationException e) {
            throw new l("Provided Uri is not in a valid state");
        }
    }

    public void a(MotionEvent motionEvent) {
        this.kk.a(motionEvent);
    }

    public boolean a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.ki);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean b(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.kj) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public g z() {
        return this.kk;
    }
}
