package lip.com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.webkit.WebView;

public class do implements Runnable {
    private final int ku;
    private final int kv;
    protected final ex lN;
    private final Handler pK;
    private final long pL;
    private long pM;
    private com.google.android.gms.internal.ey.a pN;
    protected boolean pO;
    protected boolean pP;

    protected final class a extends AsyncTask<Void, Void, Boolean> {
        private final WebView pQ;
        private Bitmap pR;

        public a(WebView webView) {
            this.pQ = webView;
        }

        /* renamed from: a */
        protected synchronized Boolean doInBackground(Void... voidArr) {
            Boolean valueOf;
            int width = this.pR.getWidth();
            int height = this.pR.getHeight();
            if (width == 0 || height == 0) {
                valueOf = Boolean.valueOf(false);
            } else {
                int i = 0;
                for (int i2 = 0; i2 < width; i2 += 10) {
                    for (int i3 = 0; i3 < height; i3 += 10) {
                        if (this.pR.getPixel(i2, i3) != 0) {
                            i++;
                        }
                    }
                }
                valueOf = Boolean.valueOf(((double) i) / (((double) (width * height)) / 100.0d) > 0.1d);
            }
            return valueOf;
        }

        /* renamed from: a */
        protected void onPostExecute(Boolean bool) {
            do.c(do.this);
            if (bool.booleanValue() || do.this.bq() || do.this.pM <= 0) {
                do.this.pP = bool.booleanValue();
                do.this.pN.a(do.this.lN);
            } else if (do.this.pM > 0) {
                if (eu.p(2)) {
                    eu.z("Ad not detected, scheduling another run.");
                }
                do.this.pK.postDelayed(do.this, do.this.pL);
            }
        }

        protected synchronized void onPreExecute() {
            this.pR = Bitmap.createBitmap(do.this.ku, do.this.kv, Config.ARGB_8888);
            this.pQ.setVisibility(0);
            this.pQ.measure(MeasureSpec.makeMeasureSpec(do.this.ku, 0), MeasureSpec.makeMeasureSpec(do.this.kv, 0));
            this.pQ.layout(0, 0, do.this.ku, do.this.kv);
            this.pQ.draw(new Canvas(this.pR));
            this.pQ.invalidate();
        }
    }

    public do(com.google.android.gms.internal.ey.a aVar, ex exVar, int i, int i2) {
        this(aVar, exVar, i, i2, 200, 50);
    }

    public do(com.google.android.gms.internal.ey.a aVar, ex exVar, int i, int i2, long j, long j2) {
        this.pL = j;
        this.pM = j2;
        this.pK = new Handler(Looper.getMainLooper());
        this.lN = exVar;
        this.pN = aVar;
        this.pO = false;
        this.pP = false;
        this.kv = i2;
        this.ku = i;
    }

    static /* synthetic */ long c(do doVar) {
        long j = doVar.pM - 1;
        doVar.pM = j;
        return j;
    }

    public void a(du duVar, fc fcVar) {
        this.lN.setWebViewClient(fcVar);
        this.lN.loadDataWithBaseURL(TextUtils.isEmpty(duVar.oA) ? null : eo.v(duVar.oA), duVar.qe, "text/html", "UTF-8", null);
    }

    public void b(du duVar) {
        a(duVar, new fc(this, this.lN, duVar.qn));
    }

    public void bo() {
        this.pK.postDelayed(this, this.pL);
    }

    public synchronized void bp() {
        this.pO = true;
    }

    public synchronized boolean bq() {
        return this.pO;
    }

    public boolean br() {
        return this.pP;
    }

    public void run() {
        if (this.lN == null || bq()) {
            this.pN.a(this.lN);
        } else {
            new a(this.lN).execute(new Void[0]);
        }
    }
}
