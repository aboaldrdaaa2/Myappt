package lip.com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.hq;
import com.google.android.gms.internal.ip;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    private static final Object EX = new Object();
    private static HashSet<Uri> EY = new HashSet();
    private static ImageManager EZ;
    private static ImageManager Fa;
    private final ExecutorService Fb = Executors.newFixedThreadPool(4);
    private final b Fc;
    private final gw Fd;
    private final Map<a, ImageReceiver> Fe;
    private final Map<Uri, ImageReceiver> Ff;
    private final Map<Uri, Long> Fg;
    private final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    private final class ImageReceiver extends ResultReceiver {
        private final ArrayList<a> Fh = new ArrayList();
        private final Uri mUri;

        ImageReceiver(Uri uri) {
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
        }

        public void b(a aVar) {
            gx.ay("ImageReceiver.addImageRequest() must be called in the main thread");
            this.Fh.add(aVar);
        }

        public void c(a aVar) {
            gx.ay("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.Fh.remove(aVar);
        }

        public void ff() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.this.mContext.sendBroadcast(intent);
        }

        public void onReceiveResult(int resultCode, Bundle resultData) {
            ImageManager.this.Fb.execute(new c(this.mUri, (ParcelFileDescriptor) resultData.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    private static final class a {
        static int a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    private final class c implements Runnable {
        private final ParcelFileDescriptor Fj;
        private final Uri mUri;

        public c(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.mUri = uri;
            this.Fj = parcelFileDescriptor;
        }

        public void run() {
            gx.az("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.Fj != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.Fj.getFileDescriptor());
                } catch (Throwable e) {
                    Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, e);
                    z = true;
                }
                try {
                    this.Fj.close();
                } catch (Throwable e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.mHandler.post(new f(this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
        }
    }

    private final class d implements Runnable {
        private final a Fk;

        public d(a aVar) {
            this.Fk = aVar;
        }

        public void run() {
            gx.ay("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.Fe.get(this.Fk);
            if (imageReceiver != null) {
                ImageManager.this.Fe.remove(this.Fk);
                imageReceiver.c(this.Fk);
            }
            a aVar = this.Fk.Fm;
            if (aVar.uri == null) {
                this.Fk.a(ImageManager.this.mContext, ImageManager.this.Fd, true);
                return;
            }
            Bitmap a = ImageManager.this.a(aVar);
            if (a != null) {
                this.Fk.a(ImageManager.this.mContext, a, true);
                return;
            }
            Long l = (Long) ImageManager.this.Fg.get(aVar.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.Fk.a(ImageManager.this.mContext, ImageManager.this.Fd, true);
                    return;
                }
                ImageManager.this.Fg.remove(aVar.uri);
            }
            this.Fk.a(ImageManager.this.mContext, ImageManager.this.Fd);
            imageReceiver = (ImageReceiver) ImageManager.this.Ff.get(aVar.uri);
            if (imageReceiver == null) {
                imageReceiver = new ImageReceiver(aVar.uri);
                ImageManager.this.Ff.put(aVar.uri, imageReceiver);
            }
            imageReceiver.b(this.Fk);
            if (!(this.Fk instanceof com.google.android.gms.common.images.a.c)) {
                ImageManager.this.Fe.put(this.Fk, imageReceiver);
            }
            synchronized (ImageManager.EX) {
                if (!ImageManager.EY.contains(aVar.uri)) {
                    ImageManager.EY.add(aVar.uri);
                    imageReceiver.ff();
                }
            }
        }
    }

    private static final class e implements ComponentCallbacks2 {
        private final b Fc;

        public e(b bVar) {
            this.Fc = bVar;
        }

        public void onConfigurationChanged(Configuration newConfig) {
        }

        public void onLowMemory() {
            this.Fc.evictAll();
        }

        public void onTrimMemory(int level) {
            if (level >= 60) {
                this.Fc.evictAll();
            } else if (level >= 20) {
                this.Fc.trimToSize(this.Fc.size() / 2);
            }
        }
    }

    private final class f implements Runnable {
        private boolean Fl;
        private final CountDownLatch kK;
        private final Bitmap mBitmap;
        private final Uri mUri;

        public f(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.Fl = z;
            this.kK = countDownLatch;
        }

        private void a(ImageReceiver imageReceiver, boolean z) {
            ArrayList a = imageReceiver.Fh;
            int size = a.size();
            for (int i = 0; i < size; i++) {
                a aVar = (a) a.get(i);
                if (z) {
                    aVar.a(ImageManager.this.mContext, this.mBitmap, false);
                } else {
                    ImageManager.this.Fg.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    aVar.a(ImageManager.this.mContext, ImageManager.this.Fd, false);
                }
                if (!(aVar instanceof com.google.android.gms.common.images.a.c)) {
                    ImageManager.this.Fe.remove(aVar);
                }
            }
        }

        public void run() {
            gx.ay("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (ImageManager.this.Fc != null) {
                if (this.Fl) {
                    ImageManager.this.Fc.evictAll();
                    System.gc();
                    this.Fl = false;
                    ImageManager.this.mHandler.post(this);
                    return;
                } else if (z) {
                    ImageManager.this.Fc.put(new a(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.Ff.remove(this.mUri);
            if (imageReceiver != null) {
                a(imageReceiver, z);
            }
            this.kK.countDown();
            synchronized (ImageManager.EX) {
                ImageManager.EY.remove(this.mUri);
            }
        }
    }

    private static final class b extends hq<a, Bitmap> {
        public b(Context context) {
            super(D(context));
        }

        private static int D(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int memoryClass = (((context.getApplicationInfo().flags & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) != 0 ? 1 : null) == null || !ip.gc()) ? activityManager.getMemoryClass() : a.a(activityManager);
            return (int) (((float) (memoryClass * AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START)) * 0.33f);
        }

        /* renamed from: a */
        protected int sizeOf(a aVar, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        /* renamed from: a */
        protected void entryRemoved(boolean z, a aVar, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, aVar, bitmap, bitmap2);
        }
    }

    private ImageManager(Context context, boolean withMemoryCache) {
        this.mContext = context.getApplicationContext();
        if (withMemoryCache) {
            this.Fc = new b(this.mContext);
            if (ip.gf()) {
                fc();
            }
        } else {
            this.Fc = null;
        }
        this.Fd = new gw();
        this.Fe = new HashMap();
        this.Ff = new HashMap();
        this.Fg = new HashMap();
    }

    private Bitmap a(a aVar) {
        return this.Fc == null ? null : (Bitmap) this.Fc.get(aVar);
    }

    public static ImageManager a(Context context, boolean z) {
        if (z) {
            if (Fa == null) {
                Fa = new ImageManager(context, true);
            }
            return Fa;
        }
        if (EZ == null) {
            EZ = new ImageManager(context, false);
        }
        return EZ;
    }

    public static ImageManager create(Context context) {
        return a(context, false);
    }

    private void fc() {
        this.mContext.registerComponentCallbacks(new e(this.Fc));
    }

    public void a(a aVar) {
        gx.ay("ImageManager.loadImage() must be called in the main thread");
        new d(aVar).run();
    }

    public void loadImage(ImageView imageView, int resId) {
        a(new com.google.android.gms.common.images.a.b(imageView, resId));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        a(new com.google.android.gms.common.images.a.b(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int defaultResId) {
        a bVar = new com.google.android.gms.common.images.a.b(imageView, uri);
        bVar.aj(defaultResId);
        a(bVar);
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri) {
        a(new com.google.android.gms.common.images.a.c(listener, uri));
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri, int defaultResId) {
        a cVar = new com.google.android.gms.common.images.a.c(listener, uri);
        cVar.aj(defaultResId);
        a(cVar);
    }
}
