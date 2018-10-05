package lip.com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.internal.gt;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.gv;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.hk;
import java.lang.ref.WeakReference;

public abstract class a {
    final a Fm;
    protected int Fn = 0;
    protected int Fo = 0;
    private boolean Fp = true;
    private boolean Fq = false;
    protected int Fr;

    static final class a {
        public final Uri uri;

        public a(Uri uri) {
            this.uri = uri;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return this == obj ? true : hk.equal(((a) obj).uri, this.uri);
            } else {
                return false;
            }
        }

        public int hashCode() {
            return hk.hashCode(this.uri);
        }
    }

    public static final class b extends a {
        private WeakReference<ImageView> Fs;

        public b(ImageView imageView, int i) {
            super(null, i);
            gx.c(imageView);
            this.Fs = new WeakReference(imageView);
        }

        public b(ImageView imageView, Uri uri) {
            super(uri, 0);
            gx.c(imageView);
            this.Fs = new WeakReference(imageView);
        }

        private void a(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
            Object obj = (z2 || z3) ? null : 1;
            if (obj != null && (imageView instanceof gv)) {
                int fi = ((gv) imageView).fi();
                if (this.Fo != 0 && fi == this.Fo) {
                    return;
                }
            }
            boolean b = b(z, z2);
            Drawable a = b ? a(imageView.getDrawable(), drawable) : drawable;
            imageView.setImageDrawable(a);
            if (imageView instanceof gv) {
                gv gvVar = (gv) imageView;
                gvVar.g(z3 ? this.Fm.uri : null);
                gvVar.al(obj != null ? this.Fo : 0);
            }
            if (b) {
                ((gt) a).startTransition(250);
            }
        }

        protected void a(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageView imageView = (ImageView) this.Fs.get();
            if (imageView != null) {
                a(imageView, drawable, z, z2, z3);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageView imageView = (ImageView) this.Fs.get();
            ImageView imageView2 = (ImageView) ((b) obj).Fs.get();
            boolean z = (imageView2 == null || imageView == null || !hk.equal(imageView2, imageView)) ? false : true;
            return z;
        }

        public int hashCode() {
            return 0;
        }
    }

    public static final class c extends a {
        private WeakReference<OnImageLoadedListener> Ft;

        public c(OnImageLoadedListener onImageLoadedListener, Uri uri) {
            super(uri, 0);
            gx.c(onImageLoadedListener);
            this.Ft = new WeakReference(onImageLoadedListener);
        }

        protected void a(Drawable drawable, boolean z, boolean z2, boolean z3) {
            if (!z2) {
                OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.Ft.get();
                if (onImageLoadedListener != null) {
                    onImageLoadedListener.onImageLoaded(this.Fm.uri, drawable, z3);
                }
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            c cVar = (c) obj;
            OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.Ft.get();
            OnImageLoadedListener onImageLoadedListener2 = (OnImageLoadedListener) cVar.Ft.get();
            boolean z = onImageLoadedListener2 != null && onImageLoadedListener != null && hk.equal(onImageLoadedListener2, onImageLoadedListener) && hk.equal(cVar.Fm, this.Fm);
            return z;
        }

        public int hashCode() {
            return hk.hashCode(this.Fm);
        }
    }

    public a(Uri uri, int i) {
        this.Fm = new a(uri);
        this.Fo = i;
    }

    private Drawable a(Context context, gw gwVar, int i) {
        Resources resources = context.getResources();
        if (this.Fr <= 0) {
            return resources.getDrawable(i);
        }
        com.google.android.gms.internal.gw.a aVar = new com.google.android.gms.internal.gw.a(i, this.Fr);
        Drawable drawable = (Drawable) gwVar.get(aVar);
        if (drawable != null) {
            return drawable;
        }
        drawable = resources.getDrawable(i);
        if ((this.Fr & 1) != 0) {
            drawable = a(resources, drawable);
        }
        gwVar.put(aVar, drawable);
        return drawable;
    }

    protected Drawable a(Resources resources, Drawable drawable) {
        return gu.a(resources, drawable);
    }

    protected gt a(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof gt) {
            drawable = ((gt) drawable).fg();
        }
        return new gt(drawable, drawable2);
    }

    void a(Context context, Bitmap bitmap, boolean z) {
        gx.c(bitmap);
        if ((this.Fr & 1) != 0) {
            bitmap = gu.a(bitmap);
        }
        a(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    void a(Context context, gw gwVar) {
        Drawable drawable = null;
        if (this.Fn != 0) {
            drawable = a(context, gwVar, this.Fn);
        }
        a(drawable, false, true, false);
    }

    void a(Context context, gw gwVar, boolean z) {
        Drawable drawable = null;
        if (this.Fo != 0) {
            drawable = a(context, gwVar, this.Fo);
        }
        a(drawable, z, false, false);
    }

    protected abstract void a(Drawable drawable, boolean z, boolean z2, boolean z3);

    public void aj(int i) {
        this.Fo = i;
    }

    protected boolean b(boolean z, boolean z2) {
        return this.Fp && !z2 && (!z || this.Fq);
    }
}
