package lip.com.google.ads.interactivemedia.v3.b.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.ads.interactivemedia.v3.api.Ad;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.b.r;
import com.google.ads.interactivemedia.v3.b.s;
import com.google.ads.interactivemedia.v3.b.s.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
public final class e extends RelativeLayout implements OnClickListener, c, com.google.ads.interactivemedia.v3.b.v.a {
    private FrameLayout a;
    private List<a> b = new ArrayList();
    private final float c;
    private final String d;
    private s e;
    private boolean f = false;
    private float g;
    private String h;
    private b i;
    private b j;
    private d k;
    private a l;

    /* compiled from: IMASDK */
    private enum b {
        NOT_SKIPPABLE,
        WAITING_TO_SKIP,
        SKIPPABLE
    }

    /* compiled from: IMASDK */
    public interface a extends com.google.ads.interactivemedia.v3.b.b.a.a {
        void a();
    }

    public e(Context context, d dVar, s sVar, String str) {
        super(context);
        this.e = sVar;
        this.d = str;
        this.k = dVar;
        this.c = getResources().getDisplayMetrics().density;
        this.l = new a(context, this.k);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.addRule(10);
        addView(this.l, layoutParams);
        this.l.a(new com.google.ads.interactivemedia.v3.b.b.a.a() {
            public final void b() {
                for (a b : e.this.b) {
                    b.b();
                }
            }
        });
        if (dVar.a) {
            this.a = new FrameLayout(context);
            this.j = new b(context);
            this.a.addView(this.j, new LayoutParams(-2, -2));
            int a = c.a(15, this.c);
            this.a.setPadding(a, a, 0, a);
            layoutParams = new LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            this.a.setLayoutParams(layoutParams);
            this.a.setOnClickListener(this);
            addView(this.a);
        }
        this.f = this.f;
        if (this.k.a) {
            ((LayoutParams) this.a.getLayoutParams()).setMargins(0, 0, 0, c.a(25, this.c));
        }
    }

    public final View a() {
        return this;
    }

    public final void a(r.c cVar, String str) {
        switch (cVar) {
            case adRemainingTime:
                a(str);
                return;
            case learnMore:
                b(str);
                return;
            case preSkipButton:
            case skipButton:
                this.j.a(str);
                return;
            default:
                return;
        }
    }

    private void a(String str) {
        if (!this.f || TextUtils.isEmpty(this.h)) {
            this.l.a(str);
        } else {
            this.l.a(str + ": " + this.h + "»");
        }
    }

    private void b(String str) {
        this.l.b(str);
    }

    public final void a(a aVar) {
        this.b.add(aVar);
    }

    public final void a(Ad ad) {
        a("");
        b(this.k.m);
        this.e.b(new r(com.google.ads.interactivemedia.v3.b.r.b.i18n, r.c.learnMore, this.d));
        if (ad.isSkippable()) {
            this.i = b.WAITING_TO_SKIP;
            this.a.setVisibility(0);
            Map hashMap = new HashMap(1);
            hashMap.put("seconds", Integer.valueOf(5));
            this.e.b(new r(com.google.ads.interactivemedia.v3.b.r.b.i18n, r.c.preSkipButton, this.d, hashMap));
        } else {
            this.i = b.NOT_SKIPPABLE;
            if (this.a != null) {
                this.a.setVisibility(4);
            }
        }
        setVisibility(0);
    }

    public final void a(VideoProgressUpdate videoProgressUpdate) {
        if (videoProgressUpdate != null && videoProgressUpdate.getDuration() >= 0.0f) {
            float duration = videoProgressUpdate.getDuration() - videoProgressUpdate.getCurrentTime();
            int i = Math.floor((double) duration) != Math.floor((double) this.g) ? 1 : 0;
            if (i != 0) {
                Map hashMap = new HashMap(2);
                hashMap.put("minutes", Float.valueOf(duration / 60.0f));
                hashMap.put("seconds", Float.valueOf(duration % 60.0f));
                this.e.b(new r(com.google.ads.interactivemedia.v3.b.r.b.i18n, r.c.adRemainingTime, this.d, hashMap));
            }
            if (this.i == b.WAITING_TO_SKIP) {
                float currentTime = 5.0f - videoProgressUpdate.getCurrentTime();
                if (currentTime <= 0.0f) {
                    this.i = b.SKIPPABLE;
                    this.e.b(new r(com.google.ads.interactivemedia.v3.b.r.b.i18n, r.c.skipButton, this.d));
                    Iterator it = this.b.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                } else if (i != 0) {
                    Map hashMap2 = new HashMap(1);
                    hashMap2.put("seconds", Float.valueOf(currentTime));
                    this.e.b(new r(com.google.ads.interactivemedia.v3.b.r.b.i18n, r.c.preSkipButton, this.d, hashMap2));
                }
                this.g = duration;
            }
        }
    }

    public final void b() {
        setVisibility(4);
    }

    public final void onClick(View view) {
        if (view == this.a && this.i == b.SKIPPABLE) {
            for (a a : this.b) {
                a.a();
            }
        }
    }
}
