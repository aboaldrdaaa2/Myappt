package lip.com.google.ads.interactivemedia.v3.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.google.ads.interactivemedia.v3.b.a.c;
import com.google.ads.interactivemedia.v3.b.r.b;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
public final class q extends ImageView implements OnClickListener {
    private final c a;
    private final s b;
    private final String c;

    static /* synthetic */ void b(q qVar) {
        Map hashMap = new HashMap();
        hashMap.put("companionId", qVar.a.companionId);
        qVar.b.b(new r(b.displayContainer, r.c.companionView, qVar.c, hashMap));
    }

    public q(Context context, s sVar, c cVar, String str) {
        super(context);
        this.b = sVar;
        this.a = cVar;
        this.c = str;
        setOnClickListener(this);
        new AsyncTask<Void, Void, Bitmap>() {
            Exception a = null;

            protected final /* synthetic */ void onPostExecute(Object x0) {
                Bitmap bitmap = (Bitmap) x0;
                if (bitmap == null) {
                    Log.e("IMASDK", "Loading image companion " + q.this.a.src + " failed: " + this.a);
                    return;
                }
                q.b(q.this);
                q.this.setImageBitmap(bitmap);
            }

            private Bitmap a() {
                try {
                    return BitmapFactory.decodeStream(new URL(q.this.a.src).openConnection().getInputStream());
                } catch (Exception e) {
                    this.a = e;
                    return null;
                }
            }
        }.execute(new Void[0]);
    }

    public final void onClick(View view) {
        this.b.b(this.a.clickThroughUrl);
    }
}
