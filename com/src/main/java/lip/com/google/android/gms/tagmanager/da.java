package lip.com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class da implements ab {
    private final Context ahK;
    private final String aib = a("GoogleTagManager", "4.00", VERSION.RELEASE, c(Locale.getDefault()), Build.MODEL, Build.ID);
    private final HttpClient aic;
    private a aid;

    public interface a {
        void a(ap apVar);

        void b(ap apVar);

        void c(ap apVar);
    }

    da(HttpClient httpClient, Context context, a aVar) {
        this.ahK = context.getApplicationContext();
        this.aic = httpClient;
        this.aid = aVar;
    }

    private HttpEntityEnclosingRequest a(URL url) {
        HttpEntityEnclosingRequest basicHttpEntityEnclosingRequest;
        URISyntaxException e;
        try {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", url.toURI().toString());
            try {
                basicHttpEntityEnclosingRequest.addHeader("User-Agent", this.aib);
            } catch (URISyntaxException e2) {
                e = e2;
                bh.D("Exception sending hit: " + e.getClass().getSimpleName());
                bh.D(e.getMessage());
                return basicHttpEntityEnclosingRequest;
            }
        } catch (URISyntaxException e3) {
            URISyntaxException uRISyntaxException = e3;
            basicHttpEntityEnclosingRequest = null;
            e = uRISyntaxException;
            bh.D("Exception sending hit: " + e.getClass().getSimpleName());
            bh.D(e.getMessage());
            return basicHttpEntityEnclosingRequest;
        }
        return basicHttpEntityEnclosingRequest;
    }

    private void a(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Object obj : httpEntityEnclosingRequest.getAllHeaders()) {
            stringBuffer.append(obj.toString()).append("\n");
        }
        stringBuffer.append(httpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
        if (httpEntityEnclosingRequest.getEntity() != null) {
            try {
                InputStream content = httpEntityEnclosingRequest.getEntity().getContent();
                if (content != null) {
                    int available = content.available();
                    if (available > 0) {
                        byte[] bArr = new byte[available];
                        content.read(bArr);
                        stringBuffer.append("POST:\n");
                        stringBuffer.append(new String(bArr)).append("\n");
                    }
                }
            } catch (IOException e) {
                bh.C("Error Writing hit to log...");
            }
        }
        bh.C(stringBuffer.toString());
    }

    static String c(Locale locale) {
        if (locale == null || locale.getLanguage() == null || locale.getLanguage().length() == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(locale.getLanguage().toLowerCase());
        if (!(locale.getCountry() == null || locale.getCountry().length() == 0)) {
            stringBuilder.append("-").append(locale.getCountry().toLowerCase());
        }
        return stringBuilder.toString();
    }

    String a(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    public boolean cC() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.ahK.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        bh.C("...no network connectivity");
        return false;
    }

    URL d(ap apVar) {
        try {
            return new URL(apVar.lO());
        } catch (MalformedURLException e) {
            bh.A("Error trying to parse the GTM url.");
            return null;
        }
    }

    public void g(List<ap> list) {
        int min = Math.min(list.size(), 40);
        Object obj = 1;
        int i = 0;
        while (i < min) {
            ap apVar = (ap) list.get(i);
            URL d = d(apVar);
            if (d == null) {
                bh.D("No destination: discarding hit.");
                this.aid.b(apVar);
            } else {
                HttpEntityEnclosingRequest a = a(d);
                if (a == null) {
                    this.aid.b(apVar);
                } else {
                    HttpHost httpHost = new HttpHost(d.getHost(), d.getPort(), d.getProtocol());
                    a.addHeader("Host", httpHost.toHostString());
                    a(a);
                    if (obj != null) {
                        try {
                            bn.w(this.ahK);
                            obj = null;
                        } catch (ClientProtocolException e) {
                            bh.D("ClientProtocolException sending hit; discarding hit...");
                            this.aid.b(apVar);
                        } catch (IOException e2) {
                            bh.D("Exception sending hit: " + e2.getClass().getSimpleName());
                            bh.D(e2.getMessage());
                            this.aid.c(apVar);
                        }
                    }
                    HttpResponse execute = this.aic.execute(httpHost, a);
                    int statusCode = execute.getStatusLine().getStatusCode();
                    HttpEntity entity = execute.getEntity();
                    if (entity != null) {
                        entity.consumeContent();
                    }
                    if (statusCode != 200) {
                        bh.D("Bad response: " + execute.getStatusLine().getStatusCode());
                        this.aid.c(apVar);
                    } else {
                        this.aid.a(apVar);
                    }
                }
            }
            i++;
            obj = obj;
        }
    }
}
