package lip.com.google.ads.interactivemedia.v3.b;

import android.net.Uri;
import com.google.ads.interactivemedia.v3.a.f;
import com.google.ads.interactivemedia.v3.a.g;
import com.google.ads.interactivemedia.v3.a.l;
import com.google.ads.interactivemedia.v3.a.q;
import com.google.ads.interactivemedia.v3.a.s;
import com.google.ads.interactivemedia.v3.a.t;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.b.a.e;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
public final class r {
    private static final f a = new g().a(CompanionAdSlot.class, new s<CompanionAdSlot>() {
        public final /* synthetic */ l a(Object obj) {
            CompanionAdSlot companionAdSlot = (CompanionAdSlot) obj;
            return new q(companionAdSlot.getWidth() + "x" + companionAdSlot.getHeight());
        }
    }).a();
    private final b b;
    private final Object c;
    private final String d;
    private final c e;

    /* compiled from: IMASDK */
    public enum a {
        webView,
        nativeUi,
        none
    }

    /* compiled from: IMASDK */
    public enum b {
        adsManager,
        adsLoader,
        contentTimeUpdate,
        displayContainer,
        i18n,
        log,
        videoDisplay,
        webViewLoaded
    }

    /* compiled from: IMASDK */
    public enum c {
        adMetadata,
        adsLoaded,
        allAdsCompleted,
        click,
        complete,
        companionView,
        contentComplete,
        contentPauseRequested,
        contentResumeRequested,
        contentTimeUpdate,
        csi,
        displayCompanions,
        destroy,
        end,
        error,
        firstquartile,
        fullscreen,
        hide,
        init,
        initialized,
        load,
        loaded,
        log,
        midpoint,
        mute,
        pause,
        play,
        resume,
        requestAds,
        showVideo,
        skip,
        start,
        startTracking,
        stop,
        stopTracking,
        thirdquartile,
        timeupdate,
        unmute,
        adRemainingTime,
        learnMore,
        preSkipButton,
        skipButton
    }

    public static r a(String str) throws MalformedURLException, t {
        Uri parse = Uri.parse(str);
        String substring = parse.getPath().substring(1);
        if (parse.getQueryParameter("sid") != null) {
            return new r(b.valueOf(substring), c.valueOf(parse.getQueryParameter("type")), parse.getQueryParameter("sid"), a.a(parse.getQueryParameter("data"), e.class));
        }
        throw new MalformedURLException("Session id must be provided in message.");
    }

    public r(b bVar, c cVar, String str, Object obj) {
        this.b = bVar;
        this.e = cVar;
        this.d = str;
        this.c = obj;
    }

    public r(b bVar, c cVar, String str) {
        this(bVar, cVar, str, null);
    }

    public final b a() {
        return this.b;
    }

    public final c b() {
        return this.e;
    }

    public final Object c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final String e() {
        Map hashMap = new HashMap(3);
        hashMap.put("type", this.e);
        hashMap.put("sid", this.d);
        hashMap.put("data", this.c);
        Object[] objArr = new Object[3];
        objArr[0] = "javascript:adsense.mobileads.afmanotify.receiveMessage";
        objArr[1] = this.b;
        f fVar = a;
        Type type = hashMap.getClass();
        Object stringWriter = new StringWriter();
        fVar.a(hashMap, type, stringWriter);
        objArr[2] = stringWriter.toString();
        return String.format("%s('%s', %s);", objArr);
    }

    public final String toString() {
        return String.format("JavaScriptMessage [command=%s, type=%s, sid=%s, data=%s]", new Object[]{this.b, this.e, this.d, this.c});
    }
}
